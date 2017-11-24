/**
 * auto-generated code
 * Tue Jan 17 09:52:22 CST 2012
 */
 package com.gmcc.pboss.web.sales.bankrecord;

import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductDBParam;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductVO;
import com.gmcc.pboss.business.sales.bankrecord.BankrecordDBParam;
import com.gmcc.pboss.business.sales.bankrecord.BankrecordVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.sales.bankdeduct.Bankdeduct;
import com.gmcc.pboss.control.sales.bankdeduct.BankdeductBO;
import com.gmcc.pboss.control.sales.bankrecord.Bankrecord;
import com.gmcc.pboss.control.sales.bankrecord.BankrecordBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: BankrecordAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class BankrecordAction extends BaseAction{
	
	private BankrecordDetailForm brdForm = new BankrecordDetailForm();
	
	private String disFlag = "true";
	
	public BankrecordAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new BankrecordForm());
		this.setParam(new BankrecordDBParam());

        //指定VO类
        setClsVO(BankrecordVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"deductid"};
		this.setClsControl(Bankrecord.class);
		this.setClsQueryParam(BankrecordDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception {
		try{
			BankrecordDBParam pam = (BankrecordDBParam)this.getParam();
			
			Bankrecord bankrecordBO = (BankrecordBO) BOFactory.build(BankrecordBO.class,super.getDBAccessUser());
			DataPackage tmp = bankrecordBO.doDetail(pam);
			if(tmp.getRowCount() > 0){
				for(int i=0; i<tmp.getDatas().size(); i++){
					HashMap vvo = (HashMap)tmp.getDatas().get(i);
					Long deductid = (Long)vvo.get("deductid");
					Long aaa_deductid = (Long)vvo.get("aaa_deductid");
					if(deductid != null && aaa_deductid != null 
							&& !"".equals(deductid) && !"".equals(aaa_deductid)
							&&  deductid.longValue() != aaa_deductid.longValue()){
						vvo.put("recordinfo","银联与银行之间处理异常，请联系管理员确认！");
					}
					if( aaa_deductid == null || "".equals(aaa_deductid)){
						vvo.put("recordinfo","银联与银行之间处理异常，请联系管理员确认！");
					}
					Double amount = (Double)vvo.get("amount");
					if(amount != null && !"".equals(amount)){
						amount = amount/100;
						vvo.remove("amount");
						vvo.put("amount",amount);
					}
				}
			}
			this.setDp(tmp);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return WEB_RESULT_LIST;
	}
	
	public String doToDetail() throws Exception {
		Bankrecord bankrecordBO = (BankrecordBO) BOFactory.build(BankrecordBO.class,super.getDBAccessUser());
		String pk = getParam().get_pk();
		DataPackage brDP = bankrecordBO.doQueryBankRecordDetail(pk);
		
		if(brDP != null && !"".equals(brDP) && brDP.getDatas() != null 
				&& !"".equals(brDP.getDatas()) && brDP.getDatas().size()>0){
			HashMap brMap = (HashMap)brDP.getDatas().get(0);
			
			brdForm = new BankrecordDetailForm();
			
			//params.setSelectFieldsString("a_deductid,b_deductid,a_shopnum,b_shopnum" +
			if(brMap.get("a_deductid") != null && !"".equals(brMap.get("a_deductid"))){
				brdForm.setA_deductid(Long.parseLong((String)brMap.get("a_deductid")));
			}
			if(brMap.get("b_deductid") != null && !"".equals(brMap.get("b_deductid"))){
				brdForm.setDeductid(Long.parseLong((String)brMap.get("b_deductid")));	
			}
			brdForm.setA_shopnum((String)brMap.get("a_shopnum"));
			brdForm.setShopnum((String)brMap.get("b_shopnum"));
			
			//",a_acctnum,b_account,a_acctname,b_accountname" +
			brdForm.setA_acctnum((String)brMap.get("a_acctnum"));
			brdForm.setAccount((String)brMap.get("b_account"));
			brdForm.setA_acctname((String)brMap.get("a_acctname"));
			brdForm.setAccountname((String)brMap.get("b_accountname"));
			
			//",a_deductamt,b_amount,a_statechgtime,b_completetime" +
			if(brMap.get("a_deductamt") != null && !"".equals(brMap.get("a_deductamt"))){
				brdForm.setA_deductamt(Double.parseDouble((String)brMap.get("a_deductamt")));
			}
			if(brMap.get("b_amount") != null && !"".equals(brMap.get("b_amount"))){
				brdForm.setAmount(Double.parseDouble((String)brMap.get("b_amount"))/100);
			}
			if(brMap.get("a_statechgtime") != null && !"".equals(brMap.get("a_statechgtime"))){
				String st = (String)brMap.get("a_statechgtime");
				brdForm.setA_statechgtime(PublicUtils.UtilStrToDate(st,"yyyy-MM-dd HH:mm:ss"));
			}
			if(brMap.get("b_completetime") != null && !"".equals(brMap.get("b_completetime"))){
				String st = (String)brMap.get("b_completetime");
				brdForm.setCompletetime(PublicUtils.UtilStrToDate(st,"yyyy-MM-dd HH:mm:ss"));
			}
			
			//",a_respcode,b_retcode,a_errmsg,b_errmsg" +
			brdForm.setA_respcode((String)brMap.get("a_respcode"));
			brdForm.setRetcode((String)brMap.get("b_retcode"));
			brdForm.setA_errmsg((String)brMap.get("a_errmsg"));
			brdForm.setErrmsg((String)brMap.get("b_errmsg"));
			
			//",recordstate,recordinfo");
			if(brMap.get("recordstate") != null && !"".equals(brMap.get("recordstate"))){
				brdForm.setRecordstate((Short)brMap.get("recordstate"));
			}
			brdForm.setRecordinfo((String)brMap.get("recordinfo"));
			
			Long a_deductid = brdForm.getA_deductid();
			Long b_deductid = brdForm.getDeductid();
			if(a_deductid != null && b_deductid !=null 
					&& !"".equals(a_deductid) && !"".equals(b_deductid)
					&& a_deductid.longValue() != b_deductid.longValue()){
				brdForm.setRecordinfo("银联与银行之间处理异常，请核对商户等信息后再重新划扣。");
			}
			if( b_deductid == null || "".equals(b_deductid)){
				brdForm.setRecordinfo("银联与银行之间处理异常，请核对商户等信息后再重新划扣。");
			}
			
			//“重新划扣”按钮处理
			if((brdForm.getRecordstate() != null && 1 != brdForm.getRecordstate() && 4 != brdForm.getRecordstate())
					|| b_deductid == null){
				//银行划扣交易记录表(FX_SW_BANKRECORD)记录的对账状态[RECORDSTATE]
				//不等于成功（1）和重新划扣（4）时或银联交易信息为空
				disFlag = "false";
			}
			if(b_deductid == null){
				//当银联划扣信息（银行划扣交易记录表(FX_SW_BANKRECORD)）不存在时
				Bankdeduct bankdeductBO = (BankdeductBO) BOFactory.build(BankdeductBO.class,super.getDBAccessUser());
				BankdeductDBParam bankdeductDBParam = new BankdeductDBParam();
				String _se_orderid = (String)brMap.get("orderid");
				bankdeductDBParam.set_se_orderid(_se_orderid);
				bankdeductDBParam.set_orderby("deductid");
				bankdeductDBParam.set_desc("1");//最新（创建时间降序，取最新一条）
				
				DataPackage bdDP = bankdeductBO.doDeduct(bankdeductDBParam);
				
				if(bdDP.getRowCount() > 0){
					BankdeductVO bankdeductVO = (BankdeductVO)bdDP.getDatas().get(0);
					Long deductid = bankdeductVO.getDeductid();
					
					//	是否不为“已处理”或存在返回码为“0000”的最新（创建时间降序，取最新一条）
					//不等于自身deductid的银行划扣记录表[FX_SW_BANKDEDUCT]信息，
					//如有“重新划扣”按钮失效
					
					if(deductid.longValue() != brdForm.getA_deductid().longValue()){//不等于自身deductid
						disFlag = "true";
					}
				}
			}
		}
		
		return "detail";
	}
	
	public String doDeduct() {
		try{
			String deductid = this.getRequest().getParameter("deductid");
			Bankrecord bankrecordBO = (BankrecordBO) BOFactory.build(BankrecordBO.class,super.getDBAccessUser());
			bankrecordBO.doDeduct(deductid);		
			
			getParam().set_pk(deductid);
			return doToDetail();
		}catch(Exception e){
			this.addActionError(e.getMessage());
			return "detail";
		}
	}

	public BankrecordDetailForm getBrdForm() {
		return brdForm;
	}

	public void setBrdForm(BankrecordDetailForm brdForm) {
		this.brdForm = brdForm;
	}
	
	public String doRetcodeSelect() throws Exception {
		Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, getDBAccessUser());
		BankrecordDBParam bankrecordDBParam = (BankrecordDBParam)getParam();
		DictitemDBParam params = new DictitemDBParam();
		BeanUtils.copyProperties(params, bankrecordDBParam);
		
		String _se_d = bankrecordDBParam.get_se_retcode();
		String _sk_d = bankrecordDBParam.get_sk_retcode();
		if(_se_d != null && !"".equals(_se_d)){
			params.set_se_dictid(_se_d);
		}
		if(_sk_d != null && !"".equals(_sk_d)){
			params.set_sk_dictname(_sk_d);
		}
		
		params.set_se_groupid("FX_BANKRESPCODE");
		DataPackage retCodeDP = dictitem.doQuery(params);
		
		this.setDp(retCodeDP);
		
		return "retcodeSelect";
	}

	public String getDisFlag() {
		return disFlag;
	}

	public void setDisFlag(String disFlag) {
		this.disFlag = disFlag;
	}
}