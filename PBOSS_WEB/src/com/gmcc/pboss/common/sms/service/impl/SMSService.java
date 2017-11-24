package com.gmcc.pboss.common.sms.service.impl;

//import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.bean.SMSRndCode;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.dictionary.CommonConfig;
import com.gmcc.pboss.common.dictionary.FileDictionary;
import com.gmcc.pboss.common.dictionary.Regex;
import com.gmcc.pboss.common.dictionary.Role;
import com.gmcc.pboss.common.nosect.service.NosectService;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.sms.dao.SMSSendDao;
import com.gmcc.pboss.common.sms.dictionary.SMSType;
import com.gmcc.pboss.common.sms.service.ISMSService;
import com.gmcc.pboss.common.sms.service.SMSRetCode;
import com.gmcc.pboss.common.sms.support.SMSParameter;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.common.util.RndNumberBuilder;
import com.gmcc.pboss.member.model.Employee;
import com.gmcc.pboss.member.support.MemberQueryParameter;
import com.gmcc.pboss.model.sms.ChSmsWaitreq;
import com.gmcc.pboss.biz.basic.goods.dao.IbGlSysparamDao;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-9-9
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public class SMSService extends BaseServiceImpl implements ISMSService{
	private static Logger logger = Logger.getLogger(SMSService.class);
	
	private SMSSendDao smsSendDao;

	/** �ֻ���������ز�ѯ Service*/
	private NosectService nosectService;
	/** ϵͳ������ѯ	 */
	private IbGlSysparamDao ibGlSysparamDao;

	public SMSService() {
		this.isNeedLogin = false; //�����¼
		this.serviceCode = ServiceCode.SMS;
		this.serviceName = "���ŷ���";
	}
	
	public ServiceResult initiate(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		ServiceResult result = new ServiceResult();
		int retCode = SMSRetCode.FAIL;
		boolean isSuccess = false;
		
		SMSParameter smsParameter = (SMSParameter)parameter;
		String sendMobile = smsParameter.getSendMobile();
		SMSRndCode smsRndCode = smsParameter.getSmsRndCode();
		
		//�ֻ�����
		String mobile = smsRndCode.getMobile();
		
		//������
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		//�����ֻ�������ص��п�
		MemberQueryParameter mparameter = new MemberQueryParameter();
		mparameter.setOfficeTel(mobile);
		result = nosectService.transact(null, mparameter, ServiceType.INITIATE);
		if(!result.isSuccess())return result;
		String cityId = (String)result.getRetObject();
		
		//�л������п�
		SessionFactoryContextHolder.setSessionFactoryContext(cityId);
		getSmsSendDao().reloadSessionFactory();
		
		result = this.getEmployeeInfo(mobile);
		if(!result.isSuccess())return result;
		//6λ�����
		String rndCode = RndNumberBuilder.getRndNumber(6);
		
		//�������ӳɹ�
		if((smsRndCode.addRndCode(rndCode)).equals(SMSRndCode.PASS)){			
			//��������
			String message = ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, CommonConfig.SMS_RND_MSG)
							 .replaceFirst(Regex.REPLAYCE, rndCode);
			
			//����ʵ������߼�
			ChSmsWaitreq sms = new ChSmsWaitreq();
			sms.setSmstype(new Long(SMSType.REND_CODE));
			sms.setAreacode(cityId);	//sms.setAreacode(branch);
			sms.setCreattime(new Date());
			sms.setDealtime(new Date());
			sms.setMessage(message);
			sms.setSendno(sendMobile);
			sms.setRecno(mobile);
			sms.setDealcount(new Long(0));
			sms.setIssuccess(new Long(0));			
			//���п�
			SessionFactoryContextHolder.setSessionFactoryContext(cityId);
			getSmsSendDao().reloadSessionFactory();
			
			if(getSmsSendDao().save(sms) != null){
				isSuccess = true;
				retCode = SMSRetCode.SEND_SUCCESS;
				result.setRetObject(smsRndCode);
				logger.info("�ֻ����룺"+mobile+"����"+message);
				System.out.println("�ֻ����룺"+mobile+",����:"+message);
			}
				
		}		
		else{//������������֤��ʧ��
			retCode = SMSRetCode.RND_CODE_FORBIDDEN;
		}
		
		result.setRetCode(retCode);
		result.setSuccess(isSuccess);
		return result;
	}
	/**************************Getter and Setter*******************************/
	public SMSSendDao getSmsSendDao() {
		return smsSendDao;
	}

	public void setSmsSendDao(SMSSendDao smsSendDao) {
		this.smsSendDao = smsSendDao;
	}

	/**
	 * @return the nosectService
	 */
	public NosectService getNosectService() {
		return nosectService;
	}

	/**
	 * @param nosectService the nosectService to set
	 */
	public void setNosectService(NosectService nosectService) {
		this.nosectService = nosectService;
	}
	
	public IbGlSysparamDao getIbGlSysparamDao() {
		return ibGlSysparamDao;
	}

	public void setIbGlSysparamDao(IbGlSysparamDao ibGlSysparamDao) {
		this.ibGlSysparamDao = ibGlSysparamDao;
	}
	
	/*
	 * 20140407 ʷ���� ����ʹ�ô˷���
	 * ʹ�ù��������officetel��¼����֧��רԱtelephone��¼
	 */
//	public ServiceResult getEmployeeInfo(String officeTel){
//		ServiceResult result = new ServiceResult();
//		try{
//			List<Employee> empAll = this.getMemberDao().getAllUserByOfficTel(officeTel);
//			if(empAll==null || empAll.size()==0){
//				result.setSuccess(false);
//				result.setRetCode(ServiceRetCode.MOBLENOTEXIST);
//			}else if(empAll.size()==1){
//				result.setSuccess(true);
//				result.setRetObject(empAll.get(0));
//				result.setRetCode(ServiceRetCode.SUCCESS);
//			}else if(empAll.size()==2){				
//				String mixtype = ibGlSysparamDao.getSysValue(76L,"channel");
//				if("1".equals(mixtype)){//ϵͳ�������ڣ�����������ͣ�������+����
//					Employee emp1 = empAll.get(0);
//					Employee emp2 = empAll.get(1);
//					if((emp1.getIsnet()==3 && emp2.getIsnet()==4) || (emp1.getIsnet()==4 && emp2.getIsnet()==3)){
//						result.setSuccess(true);
//						result.setRetObject(empAll.get(0));
//						result.setRetCode(ServiceRetCode.SUCCESS);
//					}else{//�������������
//						result.setSuccess(false);
//						result.setRetCode(SMSRetCode.W_UNIQUE);
//					}
//				}else{//�������Ͻ�ɫ
//					result.setSuccess(false);
//					result.setRetCode(SMSRetCode.W_UNIQUE);
//				}
//			}else{//��¼�����ڵ���3��
//				result.setSuccess(false);
//				result.setRetCode(SMSRetCode.W_UNIQUE);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			result.setSuccess(false);
//			result.setRetCode(ServiceRetCode.EXCEPTION);
//		}	
//		return result;
//	}
	
	/*
	 * 20140307 ʷ���� ����
	 * ͬʱ��ѯ�����officetel��רԱ����telephone��ֻ�����������Ա��¼
	 */
	public ServiceResult getEmployeeInfo(String officeTel){
		ServiceResult result = new ServiceResult();
		try{
			List<Employee> empAll = this.getMemberDao().getAllUserByMobile(officeTel);
			if(empAll==null || empAll.size()==0){
				result.setSuccess(false);
				result.setRetCode(ServiceRetCode.MOBLENOTEXIST);
			}else if(empAll.size()==1){
				result.setSuccess(true);
				result.setRetObject(empAll.get(0));
				result.setRetCode(ServiceRetCode.SUCCESS);
			}else{
				int isnet[] = {0,0,0,0,0};//��¼��ѯ���ĸ�����Ա����
				for(Employee e: empAll){
					switch(e.getIsnet().intValue()){
						case Role.SHOP_ASSISTANT:
							isnet[0]++;
							break;
						case Role.SHOP_MASTER:
							isnet[1]++;
							break;
						case Role.MISSIONER:
							isnet[2]++;
							break;
						case Role.DELIVERY_MAN:
							isnet[3]++;
							break;
						case Role.MANAGER:
							isnet[4]++;
							break;
						default:
							;
					}
				}
				if((isnet[0]>0 && isnet[1]>0) //�����Ϊ��Ա���ǵ�������Ա�����ظ�
						|| isnet[0]>1 //���ڶ����Ա����Ա�����ظ�
						|| isnet[1]>1 //���ڶ����������Ա�����ظ�
						|| isnet[2]>1 //���ڶ��רԱ����Ա�����ظ�
						|| isnet[3]>1 //���ڶ�������̣���Ա�����ظ�
						|| isnet[4]>1){//���ڶ������������Ա�����ظ�
					result.setSuccess(false);
					result.setRetCode(SMSRetCode.W_UNIQUE);
				}else{//��Ա�������������Ͷ���
					result.setSuccess(true);
					result.setRetObject(empAll.get(0).getCityid());
					result.setRetCode(ServiceRetCode.SUCCESS);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.info("��ȡ��Ա��Ϣʧ��", e);
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
		}	
		return result;
	}
}
