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
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-9-9
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 */
public class SMSService extends BaseServiceImpl implements ISMSService{
	private static Logger logger = Logger.getLogger(SMSService.class);
	
	private SMSSendDao smsSendDao;

	/** 手机号码归属地查询 Service*/
	private NosectService nosectService;
	/** 系统参数查询	 */
	private IbGlSysparamDao ibGlSysparamDao;

	public SMSService() {
		this.isNeedLogin = false; //不需登录
		this.serviceCode = ServiceCode.SMS;
		this.serviceName = "短信服务";
	}
	
	public ServiceResult initiate(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		ServiceResult result = new ServiceResult();
		int retCode = SMSRetCode.FAIL;
		boolean isSuccess = false;
		
		SMSParameter smsParameter = (SMSParameter)parameter;
		String sendMobile = smsParameter.getSendMobile();
		SMSRndCode smsRndCode = smsParameter.getSmsRndCode();
		
		//手机号码
		String mobile = smsRndCode.getMobile();
		
		//公共库
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		//跟据手机号码加载地市库
		MemberQueryParameter mparameter = new MemberQueryParameter();
		mparameter.setOfficeTel(mobile);
		result = nosectService.transact(null, mparameter, ServiceType.INITIATE);
		if(!result.isSuccess())return result;
		String cityId = (String)result.getRetObject();
		
		//切换到地市库
		SessionFactoryContextHolder.setSessionFactoryContext(cityId);
		getSmsSendDao().reloadSessionFactory();
		
		result = this.getEmployeeInfo(mobile);
		if(!result.isSuccess())return result;
		//6位随机码
		String rndCode = RndNumberBuilder.getRndNumber(6);
		
		//随机码添加成功
		if((smsRndCode.addRndCode(rndCode)).equals(SMSRndCode.PASS)){			
			//短信内容
			String message = ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, CommonConfig.SMS_RND_MSG)
							 .replaceFirst(Regex.REPLAYCE, rndCode);
			
			//这里实现入库逻辑
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
			//地市库
			SessionFactoryContextHolder.setSessionFactoryContext(cityId);
			getSmsSendDao().reloadSessionFactory();
			
			if(getSmsSendDao().save(sms) != null){
				isSuccess = true;
				retCode = SMSRetCode.SEND_SUCCESS;
				result.setRetObject(smsRndCode);
				logger.info("手机号码："+mobile+"内容"+message);
				System.out.println("手机号码："+mobile+",内容:"+message);
			}
				
		}		
		else{//添加随机短信验证码失败
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
	 * 20140407 史晓龙 不再使用此方法
	 * 使用公务机号码officetel登录，不支持专员telephone登录
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
//				if("1".equals(mixtype)){//系统参数存在：存在组合类型：配送商+经理
//					Employee emp1 = empAll.get(0);
//					Employee emp2 = empAll.get(1);
//					if((emp1.getIsnet()==3 && emp2.getIsnet()==4) || (emp1.getIsnet()==4 && emp2.getIsnet()==3)){
//						result.setSuccess(true);
//						result.setRetObject(empAll.get(0));
//						result.setRetCode(ServiceRetCode.SUCCESS);
//					}else{//不满足组合类型
//						result.setSuccess(false);
//						result.setRetCode(SMSRetCode.W_UNIQUE);
//					}
//				}else{//不允许混合角色
//					result.setSuccess(false);
//					result.setRetCode(SMSRetCode.W_UNIQUE);
//				}
//			}else{//记录数大于等于3条
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
	 * 20140307 史晓龙 新增
	 * 同时查询公务机officetel和专员号码telephone，只是所有社会人员登录
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
				int isnet[] = {0,0,0,0,0};//记录查询到的各类人员数量
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
				if((isnet[0]>0 && isnet[1]>0) //号码既为店员又是店主，人员数据重复
						|| isnet[0]>1 //存在多个店员，人员数据重复
						|| isnet[1]>1 //存在多个店主，人员数据重复
						|| isnet[2]>1 //存在多个专员，人员数据重复
						|| isnet[3]>1 //存在多个配送商，人员数据重复
						|| isnet[4]>1){//存在多个渠道经理，人员数据重复
					result.setSuccess(false);
					result.setRetCode(SMSRetCode.W_UNIQUE);
				}else{//人员数据正常，发送短信
					result.setSuccess(true);
					result.setRetObject(empAll.get(0).getCityid());
					result.setRetCode(ServiceRetCode.SUCCESS);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.info("获取人员信息失败", e);
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
		}	
		return result;
	}
}
