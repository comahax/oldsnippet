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
		serviceName = "���ʻ��ܹ���";
		serviceCode = ServiceCode.ADPAYSUM;
		isNeedLogin = true;

		setProcessor(new AdpaysumParameterProcessor());
	}
	
	//���л���
	private BankdeductDao bankdeductDao;
	public void setBankdeductDao(BankdeductDao bankdeductDao) {
		this.bankdeductDao = bankdeductDao;
	}
	//�˻���Ϣ
	private WayAccountDao wayAccountDao;
	public void setWayAccountDao(WayAccountDao wayAccountDao) {
		this.wayAccountDao = wayAccountDao;
	}
	//�����̻���Ϣ
	private BankshopDao bankshopDao;	
	public void setBankshopDao(BankshopDao bankshopDao) {
		this.bankshopDao = bankshopDao;
	}

	/**
	 * �鵥����¼
	 */
	public ServiceResult queryForOne(LoginMember member,
			QueryParameter parameter) {
		AdpaysumQueryParameter param = (AdpaysumQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		//ID��֤
		Assert.notNull(param.getSumid(), SalesrServiceRetCode.ID_Empty, "ID�����ڣ�");
		try{
			FxSwAdpaysum obj = (FxSwAdpaysum) this.get(param.getSumid());
			//��֤�û�Ȩ��
			Assert.isTrue(member.getWayid().equals(obj.getDiscomcode()), SalesrServiceRetCode.AUTHOR_FAIL, "ID����ȷ��");
			//��ѯ
			result.setRetObject(obj);
			
			result.setSuccess(true);
			result.setRetCode(SalesrServiceRetCode.SUCCESS);
			
		}catch(ObjectRetrievalFailureException e){
			//���󲻴����쳣
			result.setSuccess(false);
			result.setRetCode(SalesrServiceRetCode.INIT_FAIL);//5���������SALESORDER_5
		}
		return result;
	}

	/**
	 * �ύ��֧��
	 */
	public ServiceResult modify(LoginMember member, QueryParameter parameter) {
		AdpaysumQueryParameter param = (AdpaysumQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(AdpayServiceRetCode.FAIL);
		//�жϲ���
		Assert.notNull(param.getSumid(), AdpayServiceRetCode.PAY_ERR_ID_EMPTY, "ID��ʧ!");
		Assert.notBlank(param.getState(), AdpayServiceRetCode.PAY_ERR_STATE_EMPTY, "״̬������!");
		FxSwAdpaysum fxSwAdpaysum = (FxSwAdpaysum)get(param.getSumid());
		if("WAITSUBMIT".equals(fxSwAdpaysum.getState())){//���ύ
			fxSwAdpaysum.setState("WAITCONFIRM");
			fxSwAdpaysum.setSubmitCode(member.getEmployeeid());
			fxSwAdpaysum.setSubmitTime(new Date());
			result.setSuccess(true);
			result.setRetCode(SalesrServiceRetCode.SUCCESS);
		}else if("CONFIRMED".equals(fxSwAdpaysum.getState())){//��ȷ��,����֧���߼�
			//1 )��黮�ۼ�¼�Ƿ����
			String[] properties = {"orderid"};
			Object[] values = {param.getSumid().toString()};
			FxSwBankdeduct  bankdeductObj = null;
			try{
				bankdeductObj = (FxSwBankdeduct)this.bankdeductDao.getOne(properties, values);
			}catch(IllegalStateException e){
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_RECORD_EXIST);//��ѯ����ж���,���ۼ�¼�Ѵ���
				System.out.println("��ѯ����ж���,���ۼ�¼�Ѵ���");
				//result.setMessage("��ѯ����ж���,���ۼ�¼�Ѵ���");
				return result;
			}
			if(bankdeductObj!=null){//���ۼ�¼�Ѵ���
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_RECORD_EXIST);
				System.out.println("���ۼ�¼�Ѵ���");
				//result.setMessage("���ۼ�¼�Ѵ���");
				return result;
			}			
			//2)��ȡ�˻�����
			WayAccount wayaccountObj = this.wayAccountDao.getWayAccountByWayidAccno(fxSwAdpaysum.getDiscomcode());
			if(wayaccountObj==null){//�˻����ϲ�����
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_CUST_NOT_EXIST);//AdpayServiceRetCode.WAYACCOUNT_NOT_EXIST
				System.out.println("[" + fxSwAdpaysum.getDiscomcode() + "]�˻����ϲ�����");
				//result.setMessage("[" + fxSwAdpaysum.getDiscomcode() + "]�˻����ϲ�����");
				return result;
			}
			if (null == wayaccountObj.getAccttype()) {
				//throw new Exception("[" + wayid + "]�������˻������ʺ�����Ϊ��");
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_ACC_TYPE_NULL);
				System.out.println("[" + fxSwAdpaysum.getDiscomcode() + "]�������˻������ʺ�����Ϊ��");
				//result.setMessage("[" + fxSwAdpaysum.getDiscomcode() + "]�������˻������ʺ�����Ϊ��");
				return result;
			}
			if (StringUtils.isEmpty(wayaccountObj.getDeacctno())) {
				//throw new Exception("[" + wayid + "]�������˻����������˺�Ϊ��");
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_ACC_NO_NULL);
				System.out.println("[" + fxSwAdpaysum.getDiscomcode() + "]�������˻����������˺�Ϊ��");
				//result.setMessage("[" + fxSwAdpaysum.getDiscomcode() + "]�������˻����������˺�Ϊ��");
				return result;
			}
			if (StringUtils.isEmpty(wayaccountObj.getDeacctname())) {
				//throw new Exception("[" + wayid + "]�������˻������ʺ�����Ϊ��");
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_ACC_NAME_NULL);
				System.out.println("[" + fxSwAdpaysum.getDiscomcode() + "]�������˻������ʺ�����Ϊ��");
				//result.setMessage("[" + fxSwAdpaysum.getDiscomcode() + "]�������˻������ʺ�����Ϊ��");
				return result;
			}
			if (StringUtils.isEmpty(wayaccountObj.getDebankid())) {
				//throw new Exception("[" + wayid + "]�������˻��������б�ʶΪ��");
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_ACC_MARK_NULL);
				System.out.println("[" + fxSwAdpaysum.getDiscomcode() + "]�������˻��������б�ʶΪ��");
				//result.setMessage("[" + fxSwAdpaysum.getDiscomcode() + "]�������˻��������б�ʶΪ��");
				return result;
			}
			//3)��ȡ�����̻���Ϣ
			FxCbBankshop bankshopObj = this.bankshopDao.getByCityCounty(member.getCityid(), member.getChannel().getCountyid());
			if(bankshopObj==null){//�����̻���Ϣ������
				result.setRetCode(AdpayServiceRetCode.PAY_ERR_NO_ACCOUNT);
				System.out.println("[�й�˾"+member.getCityid()+",�ֹ�˾"+member.getChannel().getCountyid()+ "]�����̻���Ϣ������");
				//result.setMessage("[�й�˾"+member.getCityid()+",�ֹ�˾"+member.getChannel().getCountyid()+ "]�����̻���Ϣ������");
				return result;
			}
			//4)��ȡ�ֻ�����
			String officetel = member.getOfficetel();
			//5)�������ۼ�¼
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
			//���µ��ʶ������ܱ� (FX_SW_ADPAYSUM)����Ϣ��֧����Ϊ��ǰ�����ˣ�֧��ʱ��Ϊ��ǰʱ�䣻
			//֧����ʽΪ���л��ۣ��Ѹ����ΪӦ�ս�֧��״̬Ϊ��֧��
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
			//System.out.println("�û��ܵ����ǡ����ύ״̬������ȷ��״̬��!");
			//result.setMessage("�û��ܵ����ǡ����ύ״̬������ȷ��״̬��!");
		}
		return result;
	}	
}
