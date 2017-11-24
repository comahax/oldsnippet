package com.gmcc.pboss.biz.info.adpay.service.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.gmcc.pboss.biz.info.adpay.service.AdpayServiceRetCode;
import com.gmcc.pboss.biz.info.adpay.dao.BankdeductDao;
import com.gmcc.pboss.biz.info.adpay.dao.BankshopDao;
import com.gmcc.pboss.biz.info.adpay.service.AdpaysumService;
import com.gmcc.pboss.biz.info.adpay.support.AdpaysumQueryParameter;
import com.gmcc.pboss.biz.info.adpay.support.processor.AdpaysumParameterProcessor;
import com.gmcc.pboss.biz.info.node.dao.WayAccountDao;
import com.gmcc.pboss.biz.info.node.model.WayAccount;
import com.gmcc.pboss.biz.info.salesRpt.service.SalesrServiceRetCode;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.model.adpay.FxSwAdpaysum;
import com.gmcc.pboss.model.sales.bankdeduct.FxSwBankdeduct;
import com.gmcc.pboss.model.sales.bankshop.FxCbBankshop;

public class AdpaysumServiceImpl extends QueryBaseServiceImpl implements AdpaysumService {

	private static Logger logger = Logger.getLogger(AdpaysumServiceImpl.class);
	public AdpaysumServiceImpl() {
		serviceName = "垫资汇总管理";
		serviceCode = ServiceCode.ADPAYSUM;
		isNeedLogin = true;

		setProcessor(new AdpaysumParameterProcessor());
	}
	
	//银行划扣
	private BankdeductDao bankdeductDao;
	public void setBankdeductDao(BankdeductDao bankdeductDao) {
		this.bankdeductDao = bankdeductDao;
	}
	//账户信息
	private WayAccountDao wayAccountDao;
	public void setWayAccountDao(WayAccountDao wayAccountDao) {
		this.wayAccountDao = wayAccountDao;
	}
	//银行商户信息
	private BankshopDao bankshopDao;	
	public void setBankshopDao(BankshopDao bankshopDao) {
		this.bankshopDao = bankshopDao;
	}

	/**
	 * 查单条记录
	 */
	public ServiceResult queryForOne(LoginMember member,
			QueryParameter parameter) {
		AdpaysumQueryParameter param = (AdpaysumQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		//ID验证
		Assert.notNull(param.getSumid(), SalesrServiceRetCode.ID_Empty, "ID不存在！");
		try{
			FxSwAdpaysum obj = (FxSwAdpaysum) this.get(param.getSumid());
			//验证用户权限
			Assert.isTrue(member.getWayid().equals(obj.getDiscomcode()), SalesrServiceRetCode.AUTHOR_FAIL, "ID不明确！");
			//查询
			result.setRetObject(obj);
			
			result.setSuccess(true);
			result.setRetCode(SalesrServiceRetCode.SUCCESS);
			
		}catch(ObjectRetrievalFailureException e){
			//对象不存在异常
			result.setSuccess(false);
			result.setRetCode(SalesrServiceRetCode.INIT_FAIL);//5，错误代表：SALESORDER_5
		}
		return result;
	}

	/**
	 * 提交、支付
	 */
	public ServiceResult modify(LoginMember member, QueryParameter parameter) {
		AdpaysumQueryParameter param = (AdpaysumQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(AdpayServiceRetCode.FAIL);
		//判断参数
		Assert.notNull(param.getSumid(), AdpayServiceRetCode.PAY_ERR_ID_EMPTY, "ID丢失!");
		Assert.notBlank(param.getState(), AdpayServiceRetCode.PAY_ERR_STATE_EMPTY, "状态不存在!");
		FxSwAdpaysum fxSwAdpaysum = (FxSwAdpaysum)get(param.getSumid());
		if("WAITSUBMIT".equals(fxSwAdpaysum.getState())){//待提交
			fxSwAdpaysum.setState("WAITCONFIRM");
			fxSwAdpaysum.setSubmitCode(member.getEmployeeid());
			fxSwAdpaysum.setSubmitTime(new Date());
			result.setSuccess(true);
			result.setRetCode(SalesrServiceRetCode.SUCCESS);
		}else if("CONFIRMED".equals(fxSwAdpaysum.getState())){//已确认,处理支付逻辑
			//1 )检查划扣记录是否存在
			String[] properties = {"orderid"};
			Object[] values = {param.getSumid().toString()};
			FxSwBankdeduct  bankdeductObj = null;
			try{
				bankdeductObj = (FxSwBankdeduct)this.bankdeductDao.getOne(properties, values);
			}catch(IllegalStateException e){
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_RECORD_EXIST);//查询结果有多条,划扣记录已存在
				System.out.println("查询结果有多条,划扣记录已存在");
				//result.setMessage("查询结果有多条,划扣记录已存在");
				return result;
			}
			if(bankdeductObj!=null){//划扣记录已存在
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_RECORD_EXIST);
				System.out.println("划扣记录已存在");
				//result.setMessage("划扣记录已存在");
				return result;
			}			
			//2)获取账户资料
			WayAccount wayaccountObj = this.wayAccountDao.getWayAccountByWayidAccno(fxSwAdpaysum.getDiscomcode());
			if(wayaccountObj==null){//账户资料不存在
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_CUST_NOT_EXIST);//AdpayServiceRetCode.WAYACCOUNT_NOT_EXIST
				System.out.println("[" + fxSwAdpaysum.getDiscomcode() + "]账户资料不存在");
				//result.setMessage("[" + fxSwAdpaysum.getDiscomcode() + "]账户资料不存在");
				return result;
			}
			if (null == wayaccountObj.getAccttype()) {
				//throw new Exception("[" + wayid + "]合作商账户资料帐号类型为空");
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_ACC_TYPE_NULL);
				System.out.println("[" + fxSwAdpaysum.getDiscomcode() + "]合作商账户资料帐号类型为空");
				//result.setMessage("[" + fxSwAdpaysum.getDiscomcode() + "]合作商账户资料帐号类型为空");
				return result;
			}
			if (StringUtils.isEmpty(wayaccountObj.getDeacctno())) {
				//throw new Exception("[" + wayid + "]合作商账户资料银行账号为空");
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_ACC_NO_NULL);
				System.out.println("[" + fxSwAdpaysum.getDiscomcode() + "]合作商账户资料银行账号为空");
				//result.setMessage("[" + fxSwAdpaysum.getDiscomcode() + "]合作商账户资料银行账号为空");
				return result;
			}
			if (StringUtils.isEmpty(wayaccountObj.getDeacctname())) {
				//throw new Exception("[" + wayid + "]合作商账户资料帐号名称为空");
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_ACC_NAME_NULL);
				System.out.println("[" + fxSwAdpaysum.getDiscomcode() + "]合作商账户资料帐号名称为空");
				//result.setMessage("[" + fxSwAdpaysum.getDiscomcode() + "]合作商账户资料帐号名称为空");
				return result;
			}
			if (StringUtils.isEmpty(wayaccountObj.getDebankid())) {
				//throw new Exception("[" + wayid + "]合作商账户资料银行标识为空");
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_ACC_MARK_NULL);
				System.out.println("[" + fxSwAdpaysum.getDiscomcode() + "]合作商账户资料银行标识为空");
				//result.setMessage("[" + fxSwAdpaysum.getDiscomcode() + "]合作商账户资料银行标识为空");
				return result;
			}
			//3)获取银行商户信息
			FxCbBankshop bankshopObj = this.bankshopDao.getByCityCounty(member.getCityid(), member.getChannel().getCountyid());
			if(bankshopObj==null){//银行商户信息不存在
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_NO_ACCOUNT);
				System.out.println("[市公司"+member.getCityid()+",分公司"+member.getChannel().getCountyid()+ "]银行商户信息不存在");
				//result.setMessage("[市公司"+member.getCityid()+",分公司"+member.getChannel().getCountyid()+ "]银行商户信息不存在");
				return result;
			}
			//4)获取手机号码
			String officetel = member.getOfficetel();
			//5)新增划扣记录
			bankdeductObj = new FxSwBankdeduct();
			bankdeductObj.setOrderid(fxSwAdpaysum.getSumid().toString());
			bankdeductObj.setBankid(wayaccountObj.getDebankid());
			bankdeductObj.setAcctnum(wayaccountObj.getDeacctno());
			bankdeductObj.setAccttype(wayaccountObj.getAccttype());
			bankdeductObj.setAcctname(wayaccountObj.getDeacctname());
			bankdeductObj.setDeductamt(fxSwAdpaysum.getRecAmt());//??
			bankdeductObj.setState("WAITPROC");
			bankdeductObj.setCreatdate(new Date());
			bankdeductObj.setStatechgtime(new Date());
			bankdeductObj.setCallnum(officetel);
			bankdeductObj.setShopnum(bankshopObj.getShopnum());
			bankdeductObj.setTerminalnum(bankshopObj.getTerminalnum());
			bankdeductObj.setFormtype(new Short("1"));
			this.bankdeductDao.save(bankdeductObj);
			//更新垫资订单汇总表 (FX_SW_ADPAYSUM)表信息，支付人为当前操作人；支付时间为当前时间；
			//支付方式为银行划扣；已付金额为应收金额；支付状态为已支付
			fxSwAdpaysum.setPaymentcode(member.getEmployeeid());
			fxSwAdpaysum.setPaymenttime(new Date());
			fxSwAdpaysum.setPaymentmode("BANK");
			fxSwAdpaysum.setPrepaidlamt(fxSwAdpaysum.getRecAmt());
			fxSwAdpaysum.setState("WAITPAYMENT");//PAYMENT
			//this.save(fxSwAdpaysum);
			result.setSuccess(true);
			result.setRetCode(AdpayServiceRetCode.SUCCESS);
		}else{
			result.setRetCode(AdpayServiceRetCode.PAY_ERR_STATE_ERROR);
			//System.out.println("该汇总单不是”待提交状态“或“已确认状态”!");
			//result.setMessage("该汇总单不是”待提交状态“或“已确认状态”!");
		}
		return result;
	}	
}
