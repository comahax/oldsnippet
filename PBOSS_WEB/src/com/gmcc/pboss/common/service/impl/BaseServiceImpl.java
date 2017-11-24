package com.gmcc.pboss.common.service.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.common.util.string.CharacterStrUtil;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.common.dictionary.CommonConfig;
import com.gmcc.pboss.common.dictionary.FileDictionary;
import com.gmcc.pboss.common.exception.AssertConditionException;
import com.gmcc.pboss.common.exception.TransactionProcessionException;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.pnrg.MobileInfo;
//import com.gmcc.pboss.common.pnrg.PNRGLoader;
import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.sms.service.SMSRetCode;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.CommonUtil;
import com.gmcc.pboss.member.dao.IMemberDao;
import com.gmcc.pboss.member.model.Employee;

public abstract class BaseServiceImpl implements BaseService {
	private static Logger logger = Logger.getLogger(BaseServiceImpl.class);

	/** ҵ����� */
	protected String serviceCode;
	/** ҵ������ */
	protected String serviceName;
	/** �Ƿ���Ҫ��¼ */
	protected boolean isNeedLogin = true;

	private BaseDao dao;
	
	private IMemberDao memberDao;
	private QueryParameterProcessor processor;
	
	public ServiceResult transactionProcessing(LoginMember member, QueryParameter parameter, short serviceType) 
										throws TransactionProcessionException{
		logger.info("�����������ServiceType " + serviceType);
		
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);

		// δ��¼
		if (isNeedLogin && member == null) {
			result.setRetCode(ServiceRetCode.NOT_LOGIN);
		}
		// �ѵ�¼
		else {
			// �ж�ҵ�����/�����Ƿ��Ѿ���ʼ��
			if (isServiceCodeOrNameInit()) {
				try {
						switch (serviceType) {
						case ServiceType.INITIATE:
							result = this.initiate(member, parameter);
							break;
						case ServiceType.MODIFY:
							result = this.modify(member, parameter);
							break;
						case ServiceType.CANCEL:
							result = this.cancel(member, parameter);
							break;
						case ServiceType.QUERY_ONE:
							result = this.queryForOne(member, parameter);
							break;
						case ServiceType.OTHER:
							result = this.other(member, parameter);
							break;
						default: 
							result.setRetCode(ServiceRetCode.ILLEGALITY);
						}// end switch
					} 
					catch (Throwable e) {
						e.printStackTrace();
						noteException(member, e, serviceType, parameter.getOperation());
						throw new TransactionProcessionException(e);
					}
			}
			// δ��ʼ��
			else {
				result.setRetCode(ServiceRetCode.INIT_FAIL);
			}
		}// end else
		
		return finishProcessor(result, member, serviceType, parameter.getOperation());
	}
	public ServiceResult transact(LoginMember member, QueryParameter parameter, short serviceType) {
		//logger.info("���ý����������>>>>ServiceType " + serviceType);
		
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);

		// δ��¼
		if (isNeedLogin && member == null) {
			result.setRetCode(ServiceRetCode.NOT_LOGIN);
		}
		// �ѵ�¼
		else {
			// �ж�ҵ�����/�����Ƿ��Ѿ���ʼ��
			if (isServiceCodeOrNameInit()) {
				try {
					switch (serviceType) {
					case ServiceType.INITIATE:
						result = this.initiate(member, parameter);
						break;
					case ServiceType.QUERY:
						result = this.query(member, parameter);
						break;
					case ServiceType.QUERY_ONE:
						result = this.queryForOne(member, parameter);
						break;
					case ServiceType.OTHER:
						result = this.other(member, parameter);
						break;
					default:
						result.setRetCode(ServiceRetCode.ILLEGALITY);
					}// end switch

				} catch (AssertConditionException ex) {
					// ��������֤ʧ�ܵ��쳣����������Ϣ���ؿͻ��� ��ʾ
					StringBuffer einfo = new StringBuffer();
					einfo.append("AssertConditionException >>> :").append(ex.toString()).append('|').append(ex.getMessage());
					logger.error(einfo.toString());
					result.setRetCode(ex.getErrorCode());
					
				} catch (Throwable e) {
					e.printStackTrace();

					noteException(member,e, serviceType, parameter.getOperation());
					result.setRetCode(ServiceRetCode.EXCEPTION);
				}
			}
			// δ��ʼ��
			else {
				result.setRetCode(ServiceRetCode.INIT_FAIL);
			}
		}// end else
		
		
		return finishProcessor(result, member, serviceType, parameter.getOperation());
	}
	
	/**
	 * ҵ��δ����
	 * @param result
	 * @return
	 */
	protected ServiceResult finishProcessor(ServiceResult result, LoginMember member, short serviceType, int operation){
		// ��ȡ��ʾ��Ϣ
		result.setMessage(ConfigUtil.getMessage(serviceCode, result.getRetCode()));
		
		StringBuffer info = new StringBuffer();
		// ҵ����־
		if (member != null) {
			Log.bizLog(member.getOfficetel(), member.getWayid(),member.getEmployeeid(),
						serviceCode, serviceName, serviceType, operation, result);
			info.append("WayId[").append(member.getWayid()).append(']');
			info.append("OfficeTel[").append(member.getOfficetel()).append(']');
		}

		
		info.append("ServiceCode[").append(this.serviceCode)
			.append("]ServiceName[").append(this.serviceName)
			.append("]ServiceType[").append(serviceType).append("]Operation[").append(operation)
			.append("]is finish IsSuccess[").append(result.isSuccess())
			.append("]RetCode[").append(result.getRetCode()).append("]Message[").append(result.getMessage()).append("]");
		logger.info(info.toString());
		
		return result;
	}
	/**
	 * ��¼�쳣��־
	 * @param e
	 * @param serviceType
	 */
	private void noteException(LoginMember member,Throwable e, short serviceType, int operation){
		StringBuffer einfo = new StringBuffer();
		einfo.append(serviceCode)
			 .append(" Exception: ")
			 .append(e.toString())
			 .append(" Message: ")
			 .append(e.getMessage());
		logger.error(einfo.toString());
		// ������־
		if(member != null)
			Log.errorLog(member.getOfficetel(), member.getWayid(), member.getEmployeeid(), 
						serviceCode, serviceName, serviceType, operation, einfo.toString());
	}
	
	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		throw new UnsupportedOperationException();
	}
	
	
	public ServiceResult queryForOne(LoginMember member,QueryParameter parameter) {
		throw new UnsupportedOperationException();
	}
	
	public ServiceResult initiate(LoginMember member, QueryParameter parameter) {
		throw new UnsupportedOperationException();
	}

	
	public ServiceResult modify(LoginMember member, QueryParameter parameter) {
		throw new UnsupportedOperationException();
	}

	
	public ServiceResult cancel(LoginMember member, QueryParameter parameter) {
		throw new UnsupportedOperationException();
	}
	
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		throw new UnsupportedOperationException();
	}
	
	
	/**
	 * �ж�ҵ�����/�����Ƿ��Ѿ���ʼ��
	 * 
	 * @return
	 */
	private boolean isServiceCodeOrNameInit() {
		boolean isSuccess = true;

		if (CharacterStrUtil.isBlank(serviceCode) || 
			CharacterStrUtil.isBlank(serviceName)){
			isSuccess = false;
		}

		return isSuccess;
	}
	
	/**
	 * �ж��û��ֻ������Ƿ��ǹ㶫�ƶ�����
	 * @param mobile
	 * @return
	 */
//	public ServiceResult vaildateGDMobile(String mobile){
//		ServiceResult result = new ServiceResult();
//		int retCode = ServiceRetCode.UN_GD_MOBILE;
//		boolean isSuccess = false;
//		
//		if(!CommonUtil.isChinaMobile(mobile)){
//			retCode = ServiceRetCode.UNMOBILE;
//		}
//		else{
//			//����ֻ����������
//			MobileInfo info = PNRGLoader.getMobileInfo(mobile,FileConfigAdapter.getCommonPath());
//			logger.info("��ѯ�ֻ���������أ�" + info.getBranchCode());
//			if(info.getFlage().equals(MobileInfo.SUCCESS)){
//				retCode = ServiceRetCode.SUCCESS;
//				isSuccess = true;
//				result.setRetObject(info);
//			}
//		}
//		
//		result.setRetCode(retCode);
//		result.setSuccess(isSuccess);
//		return result;
//	}
	/**
	 * �ж��û��ֻ������Ƿ���ϵͳ֧�ֵ���
	 * @param mobile
	 * @return
//	 */
//	public ServiceResult vaildateSysDefaultBranch(String mobile){
//		ServiceResult result = this.vaildateGDMobile(mobile);
//		
//		if(result.isSuccess()){
//			String defaultBranch = ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, CommonConfig.SYSSUPPORT_BRANCH);
//			MobileInfo info = (MobileInfo)result.getRetObject();
//			//Ĭ�ϵ��в������û��ֻ��Ź�����
//			logger.info("�ж��ֻ������Ƿ���ϵͳĬ�ϵ��� " + defaultBranch);
//			if(!defaultBranch.equals("ALL") && defaultBranch.indexOf(info.getBranchCode()) == -1){
//				result.setSuccess(false);
//				result.setRetCode(ServiceRetCode.UNDEFAULT_BRANCH);
//				result.setRetObject(null);
//			}
//		}
//		return result;
//	}
	
	/**
	 * ����mobile�ж�employee�Ƿ���ڣ������ڷ���"�û��ֻ������ϵͳĬ�ϵ���"
	 * ������"�ֻ������¼����"
	 * @param mobile
	 * @return
	 */
	public ServiceResult getMobileCityid(String mobile){
		return existsEmployee(mobile);
	}
	
	/**
	 * ����mobile�ж�employee�Ƿ���ڣ������ڷ���"�û��ֻ������ϵͳĬ�ϵ���"
	 * ������"�ֻ������¼����"
	 * ע��employee�ڹ����⣬����֮ǰ�����ֹ�����һ��Ҫʹ�õ�sessionFactor
	 * @param mobile
	 * @return
	 */
	protected ServiceResult existsEmployee(String mobile){
		memberDao.reloadSessionFactory();
		ServiceResult result = new ServiceResult();
		try{
			Employee employee = memberDao.getUserByOfficTel(mobile);
			if(employee==null){
				result.setSuccess(false);
				result.setRetCode(ServiceRetCode.MOBLENOTEXIST);
			}else{
				result.setSuccess(true);
				result.setRetObject(employee);
				result.setRetCode(ServiceRetCode.SUCCESS);
			}
		}catch(Exception e){
			e.printStackTrace();
			result.setSuccess(false);
//			result.setRetCode(SMSRetCode.W_UNIQUE);
		}
		return result;
	}
		
	
	public void setDao(BaseDao dao) {
		this.dao = dao;
	}

	public BaseDao getDao() {
		return dao;
	}

	public Object get(Serializable id) {
		return dao.get(id);
	}

	public Object getOne(String[] propertyNames,String[] values) {
		return dao.getOne(propertyNames,values);
	}
	
	public QueryResult getAll(QueryParameter parameter) {
		return dao.getAll(processor, parameter);
	}

	public void remove(Serializable id) {
		dao.remove(id);
	}

	public void removeObject(Object id) {
		dao.removeObject(id);
	}

	public Object save(Object object) {
		return dao.save(object);
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	/**
	 * ���ò�ѯ���������� ÿ��ҵ���Ӧ��ͬ�Ĵ�����
	 * @param processor
	 */
	public void setProcessor(QueryParameterProcessor processor) {
		this.processor = processor;
	}
	
	public QueryParameterProcessor getProcessor() {
		return this.processor;
	}

	public boolean isNeedLogin() {
		return isNeedLogin;
	}

	public void setNeedLogin(boolean isNeedLogin) {
		this.isNeedLogin = isNeedLogin;
	}
	public IMemberDao getMemberDao() {
		return memberDao;
	}
	public void setMemberDao(IMemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
