package com.gmcc.pboss.common.sms.action;

import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.SMSRndCode;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.dictionary.CommonConfig;
import com.gmcc.pboss.common.dictionary.FileDictionary;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.exception.TransactionProcessionException;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.sms.service.ISMSService;
import com.gmcc.pboss.common.sms.support.SMSParameter;
import com.gmcc.pboss.common.support.QueryParameter;
/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-9-10
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public class SMSAction extends AbstractAction{
	
	private static final long serialVersionUID = -7243040257562908376L;
	
	private SMSParameter loginParameter;
	private ISMSService service;
	
	public QueryParameter getParameter() {
		SMSParameter parameter = new SMSParameter();
		
		Object obj = getSessionAttribute(HttpDictionary.SMS_CODE_NAME);
		//System.out.println("SMS_CODE IN Session is null "+(obj == null));
		SMSParameter loginParameter = this.getLoginParameter();
		
		SMSRndCode smsRndCode = null;
		if(obj == null){
			smsRndCode = new SMSRndCode(loginParameter.getOfficeTel());
		}
		else{
			smsRndCode = (SMSRndCode)obj;
			smsRndCode.setMobile(loginParameter.getOfficeTel());
		}
		
		parameter.setSmsRndCode(smsRndCode);
		return parameter;
	}

	public void prepare() throws Exception {}
	
	/**
	 * �������������֤��
	 * @return
	 */
	public String doSendSMSRndCode(){
		
		//���ͺ���
		String sendMobile = ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, CommonConfig.SMS_SEND_MOBILE);
		
		//����SMSҵ����
		SMSParameter parameter = (SMSParameter)getParameter();
		parameter.setSendMobile(sendMobile);
		
		ServiceResult result;
		try {
			result = service.transactionProcessing(getMember(), parameter, ServiceType.INITIATE);
			//�ɹ�������Session��
			if(result.isSuccess()){
				setSessionAttribute(HttpDictionary.SMS_CODE_NAME, result.getRetObject());
			}
			
			// ����JSON
			result.setMessage(ConfigUtil.getMessage(ServiceCode.SMS, result.getRetCode()));
			writeJSONServiceData(result);
		} 
		catch (TransactionProcessionException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			this.writeJSONError(ConfigUtil.getMessage(ServiceCode.COMMON, ServiceRetCode.EXCEPTION));
		}
		
		
		return null;
	}
	public ISMSService getService() {
		return service;
	}

	public void setService(ISMSService service) {
		this.service = service;
	}

	public SMSParameter getLoginParameter() {
		return loginParameter;
	}

	public void setLoginParameter(SMSParameter loginParameter) {
		this.loginParameter = loginParameter;
	}
	
}
