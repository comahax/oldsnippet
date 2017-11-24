package com.gmcc.pboss.member.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.biz.basic.goods.dao.IbGlSysparamDao;
import com.gmcc.pboss.biz.info.delivery.dao.ChSmsSmstmplDao;
import com.gmcc.pboss.biz.info.delivery.dao.ChSmsWaitreqDao;
import com.gmcc.pboss.common.bean.Channel;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ChannelState;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.Role;
import com.gmcc.pboss.common.nosect.service.NosectService;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.member.dao.IChannelDao;
import com.gmcc.pboss.member.dao.IMemberDao;
import com.gmcc.pboss.member.extend.dao.EmployeeextendDao;
import com.gmcc.pboss.member.extend.dao.ProvincecityadminDao;
import com.gmcc.pboss.member.extend.model.ChPwEmployeeextend;
import com.gmcc.pboss.member.extend.model.Provincecityadmin;
import com.gmcc.pboss.member.model.Employee;
import com.gmcc.pboss.member.support.MemberQueryParameter;
import com.gmcc.pboss.member.support.MemberQueryParameterProcessor;
import com.gmcc.pboss.model.sms.ChSmsSmstmpl;
import com.gmcc.pboss.model.sms.ChSmsWaitreq;

/**
 * ���˹�˾��������ҵ��
 * 
 * @author tangzhu
 * @date 2009-7-29 ������Ŀ�� ����ģ�飺 ������
 */
public class MemberService extends BaseServiceImpl implements IMemberService {
	private static Logger logger = Logger.getLogger(MemberService.class);

	private static Map<Integer, String> ISNET_MAP = new HashMap<Integer, String>();
	static {
		ISNET_MAP.put(0, "��Ա");
		ISNET_MAP.put(1, "����");
		ISNET_MAP.put(2, "�ƹ�רԱ");
		ISNET_MAP.put(3, "������");
		ISNET_MAP.put(4, "��������");
		ISNET_MAP.put(5, "ʡ��˾����Ա");
		ISNET_MAP.put(6, "�й�˾����Ա");
	}

	/** ����DAO */
	private IChannelDao channelDao;

	/** �ֻ���������ز�ѯ Service */
	private NosectService nosectService;

	private IbGlSysparamDao ibGlSysparamDao;

	// ʷ���� 2012-07-12
	// �˴����ݼ����߼�Ǩ�Ƶ�DelayLoadServiceImpl�࣬���ݲ�ͬ��¼��ɫ��ÿ�ν�����Ӧ��ҳ�Ǽ��أ��Ա���ߵ�¼Ч��
	// /** ע��ChDstCooperatorService�ӿ�,���ݵ�½�û�����id���ҷ���������*/
	// private ChDstCooperatorService chDstCooperatorService;
	//	
	// /**���ز˵���Service���˵���Ϣ�������ݿ��SA_DB_WEBFUNCTIONITEM��*/
	// private SaDbWebfunctionitemService saDbWebfunctionitemService;

	/** Ա��չ����Ϣ��ѯ�����ڹ̶������¼ */
	private EmployeeextendDao employeeextendDao;
	/** ʡ�й���Ա��չ����Ϣ��ѯ�����ڹ̶������¼ */
	private ProvincecityadminDao provincecityadminDao;

	// ��ȡ����ģ��
	private ChSmsSmstmplDao chSmsSmstmplDao;
	// �����������
	private ChSmsWaitreqDao chSmsWaitreqDao;

	/**
	 * ����������ServiceCode��ServiceName��ֵ
	 */
	public MemberService() {
		super();
		this.serviceCode = ServiceCode.MEMBER;
		this.serviceName = "��Ա����";
		isNeedLogin = false;// ����Ҫ��¼
	}

	/**
	 * ������ʵ�ֵ�¼��ҵ���߼�
	 */
	public ServiceResult initiate(LoginMember member, QueryParameter parameter) {

		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(MemberServiceRetCode.FAIL);

		MemberQueryParameter mparameter = (MemberQueryParameter) parameter;
		if (mparameter.getIsnet() == null || "".equals(mparameter.getIsnet())) {
			result = this.initialize1(mparameter);// ��Ӧ��һ����¼����
		} else {
			result = this.initialize2(mparameter);// ��Ӧ�ڶ�����¼����
		}

		return result;
	}

	private ServiceResult initialize1(MemberQueryParameter mparameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(MemberServiceRetCode.FAIL);
		String officeTel = mparameter.getOfficeTel();
		// String officeTel = "13666666677";

		try {
			// �ж��ֻ��������ڵ���//�л�������
			SessionFactoryContextHolder.setSessionFactoryContext(null);
			// result = nosectService.transact(null, mparameter,
			// ServiceType.INITIATE);
			result = nosectService.initiate(null, mparameter);
			if (!result.isSuccess()){
					result.setSuccess(false);
					return result;
		
			}
			String cityId = (String) result.getRetObject();
			// �жϵ����Ƿ񿪷�
			String getConfig = Constant.getConstantName(ConstantsType.ISOPEN,
					cityId);
			if (!ConstantsType.ISOPEN_YES.equals(getConfig)) {
				result.setSuccess(false);
				result.setRetCode(MemberServiceRetCode.INVALIDCITY);
				return result;
			}

			// �л����п�
			// ��Ա
			SessionFactoryContextHolder.setSessionFactoryContext(cityId);
			// List<Employee> empAll = ((IMemberDao)
			// getDao()).getAllUserByOfficTel(officeTel);
			List<Employee> empAll = ((IMemberDao) getDao())
					.getAllUserByMobile(officeTel);
			if (empAll != null && empAll.size() > 1) {// ���ڶ����Ա
				int isnet[] = { 0, 0, 0, 0, 0, 0, 0 };// ��¼��ѯ���ĸ�����Ա����
				for (Employee e : empAll) {
					switch (e.getIsnet().intValue()) {
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
					case Role.GD_MANAGER:
						isnet[5]++;
						break;
					case Role.CITY_MANAGER:
						isnet[6]++;
						break;
					default:
						;
					}
				}
				if ((isnet[0] > 0 && isnet[1] > 0) // �����Ϊ��Ա���ǵ�������Ա�����ظ�
						|| isnet[0] > 1 // ���ڶ����Ա����Ա�����ظ�
						|| isnet[1] > 1 // ���ڶ����������Ա�����ظ�
						|| isnet[2] > 1 // ���ڶ��רԱ����Ա�����ظ�
						|| isnet[3] > 1 // ���ڶ�������̣���Ա�����ظ�
						|| isnet[4] > 1 || isnet[5] > 1 || isnet[6] > 1) {// ���ڶ������������Ա�����ظ�
					result.setSuccess(false);
					result
							.setRetCode(MemberServiceRetCode.MORE_THAN_ONE_MASTER);
				} else {// ����һ��������ڶ����ͬ��ɫ�����
					result = dealEmployeeMixrole(empAll, mparameter);
					if (!result.isSuccess()) {// ��ʧ����Ϣ�����ؽ���
						return result;
					} else if (result.isSuccess()
							&& result.getRetCode() == MemberServiceRetCode.MIX_ROLE) {// �̶������Ӧ�����Ա�����ؽ������û�ѡ���¼��ɫ
						return result;
					}
					// �̶������ӦΨһ��Ա��ֱ������������
					// else if(result.isSuccess() &&
					// result.getRetCode()==MemberServiceRetCode.SUCCESS){;}
				}
			} else if (empAll != null && empAll.size() == 1) {// ����һ����Ա
				result = dealEmployee(empAll.get(0), mparameter);
				if (!result.isSuccess())
					return result;
			} else {
				
					// ��Ա������
					result.setSuccess(false);
					result.setRetCode(MemberServiceRetCode.NOT_REGISTER);
					return result;
			}

			// ����
			Employee employee = (Employee) result.getRetObject();
			if (employee != null) {
				if (employee.getIsnet() == 5) {
					result = this.createMember2(employee);
					
					return result;
				}
				if (employee.getIsnet() == 6) {
					result = this.createMember2(employee);
					return result;
				}
				if (employee.getWayid() == null || employee.getIsnet() == null) {
					// ������Ϣ��ѯʧ��
					result.setSuccess(false);
					result.setRetCode(MemberServiceRetCode.CHANNEL_FAIL);
					return result;
				} else {
					result = getChannelInfo(employee.getWayid(), employee
							.getIsnet());
				}
			} else {
				// ������Ϣ��ѯʧ��
				result.setSuccess(false);
				result.setRetCode(MemberServiceRetCode.CHANNEL_FAIL);
				return result;
			}
			if (!result.isSuccess())
				return result;
			if (mparameter.getChosenAuthType().equals("SimpAuth")) {
				// �̶������½����֤�ɹ�����������Ͷ��ŵ�CH_SMS_WAITREQ��
				ChSmsWaitreq smsWaitreq = new ChSmsWaitreq();
				Date d = new Date();
				smsWaitreq.setCreattime(d);
				smsWaitreq.setAreacode(employee.getCityid());
				smsWaitreq.setSmstype(new Long(0));
				smsWaitreq.setSendno("10086111");
				smsWaitreq.setRecno(employee.getOfficetel());
				ChSmsSmstmpl chSmsSmstmpl = (ChSmsSmstmpl) chSmsSmstmplDao
						.get("WEB_WELCOME");
				smsWaitreq.setMessage(chSmsSmstmpl.getScontent());
				chSmsWaitreqDao.save(smsWaitreq);
			}

			// �������
			Channel channel = (Channel) result.getRetObject();
			// �����Ǽ�����
			if (channel != null) {
				if (channel.getStarlevel() != null) {
					channel.setStrStarLevel(Constant.getConstantName(
							ConstantsType.STARLEVEL, channel.getStarlevel()
									.toString()));
				}
			}

			// ��������
			if (result.isSuccess()) {
				// LoginMember lm = createMember(employee, channel);
				// result.setRetObject(lm);
				result = this.createMember(employee, channel);
			}
		} catch (Exception e) {
			logger.error("MemberService��׽�쳣������������������initialize1:"
					+ e.getMessage());// ������û�
			e.printStackTrace();
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
		}
		return result;
	}

	private ServiceResult initialize2(MemberQueryParameter mparameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(MemberServiceRetCode.FAIL);
		try {
			String officeTel = mparameter.getOfficeTel();
			logger.info("��¼���롡officeTel >>> " + officeTel);
			String isnet = mparameter.getIsnet();
			logger.info("��¼��ɫ��isnet >>> " + isnet);

			// �ж��ֻ��������ڵ���//�л�������
			SessionFactoryContextHolder.setSessionFactoryContext(null);
			// result = nosectService.transact(null, mparameter,
			// ServiceType.INITIATE);
			result = nosectService.initiate(null, mparameter);
			if (!result.isSuccess()){
				result.setSuccess(false);
				return result;
		
			}
				
			String cityId = (String) result.getRetObject();
			// �жϵ����Ƿ񿪷�
			String getConfig = Constant.getConstantName(ConstantsType.ISOPEN,
					cityId);
			if (!ConstantsType.ISOPEN_YES.equals(getConfig)) {
				result.setSuccess(false);
				result.setRetCode(MemberServiceRetCode.INVALIDCITY);
				return result;
			}

			// �л����п�
			// ��Ա
			SessionFactoryContextHolder.setSessionFactoryContext(cityId);
			logger.info("�������С�cityId >>> " + cityId);
			Employee employee = ((IMemberDao) getDao()).getUserByOfftelIsnet(
					officeTel, Long.parseLong(isnet));
			if (employee != null) {
				if (employee.getIsnet() == 5) {
					result = this.createMember2(employee);
					return result;
					
				}
				if (employee.getIsnet() == 6) {
					result = this.createMember2(employee);
					return result;
				}
				if (employee.getWayid() == null || employee.getIsnet() == null) {
					// ������Ϣ��ѯʧ��
					logger.info("�����������IsnetΪnull >>> ");
					result.setSuccess(false);
					result.setRetCode(MemberServiceRetCode.CHANNEL_FAIL);
					return result;
				} else {
					result = getChannelInfo(employee.getWayid(), employee
							.getIsnet());
				}
			} else {
				
					// ��Ա������
					result.setSuccess(false);
					result.setRetCode(MemberServiceRetCode.NOT_REGISTER);
					return result;
				
			}
			if (!result.isSuccess())
				return result;
			if (mparameter.getChosenAuthType().equals("SimpAuth")) {
				// �̶������½����֤�ɹ�����������Ͷ��ŵ�CH_SMS_WAITREQ��
				ChSmsWaitreq smsWaitreq = new ChSmsWaitreq();
				Date d = new Date();
				smsWaitreq.setCreattime(d);
				smsWaitreq.setAreacode(employee.getCityid());
				smsWaitreq.setSmstype(new Long(0));
				smsWaitreq.setSendno("10086111");
				smsWaitreq.setRecno(employee.getOfficetel());
				ChSmsSmstmpl chSmsSmstmpl = (ChSmsSmstmpl) chSmsSmstmplDao
						.get("WEB_WELCOME");
				smsWaitreq.setMessage(chSmsSmstmpl.getScontent());
				chSmsWaitreqDao.save(smsWaitreq);
			}

			// �������
			Channel channel = (Channel) result.getRetObject();
			// �����Ǽ�����
			if (channel != null) {
				if (channel.getStarlevel() != null) {
					channel.setStrStarLevel(Constant.getConstantName(
							ConstantsType.STARLEVEL, channel.getStarlevel()
									.toString()));
				}
			}

			// ��������
			if (result.isSuccess()) {
				// LoginMember lm = createMember(employee, channel);
				// result.setRetObject(lm);
				result = this.createMember(employee, channel);
			}

		} catch (Exception e) {
			logger.error("MemberService��׽�쳣������������������initialize2:"
					+ e.getMessage());// ������û�
			e.printStackTrace();
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
		} finally {
			return result;
		}
	}

	/**
	 * ��ѯ��Ա
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		boolean isSuccess = false;
		int retCode = MemberServiceRetCode.FAIL;
		try {
			// ��ѯ����������
			setProcessor(new MemberQueryParameterProcessor());

			// this.getDao().reloadSessionFactory();
			QueryResult queryResult = getAll(parameter);
			if (queryResult != null) {
				isSuccess = true;
				retCode = MemberServiceRetCode.SUCCESS;
				result.setRetResult(queryResult);

			}

			result.setSuccess(isSuccess);
			result.setRetCode(retCode);
		} catch (Exception e) {
			logger.error("MemberService��׽�쳣������������������ѯ��Աquery��:"
					+ e.getMessage());// ������û�
			e.printStackTrace();
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
		} finally {
			return result;
		}
	}

	/**
	 * 20140307 ʷ���� �ķ�������ʹ�� ��֧���ƹ�רԱ��¼ �����Ա��Ϣ
	 * 
	 * @param empAll
	 *            ��ѯ������Ա�б�
	 * @param mparameter
	 *            ��¼���洫�ݵĲ���
	 * @return
	 */
	// private ServiceResult dealEmployee(List<Employee>
	// empAll,MemberQueryParameter mparameter){
	// ServiceResult result = new ServiceResult();
	// boolean isSuccess = false;
	// int retCode = MemberServiceRetCode.FAIL;
	// Employee employee = null;
	// // �û�������
	// if(empAll.size()==0 ){//empAll == null ||
	// retCode = MemberServiceRetCode.NOT_REGISTER;
	// }
	// //��Ӧ������ڸ���Ա��Ψһ
	// else if(empAll.size()>1){
	// retCode = MemberServiceRetCode.MORE_THAN_ONE_MASTER;
	// }
	// // �û�����ȷ
	// else{
	// employee = empAll.get(0);
	// int empstatus = employee.getEmpstatus().intValue();
	// //��ְ
	// if (empstatus == Role.INCUMBENCY) {
	// isSuccess = true;
	// retCode = MemberServiceRetCode.SUCCESS;
	// result.setRetObject(employee);
	// }
	// //����ְ
	// else if(empstatus == Role.DIMISSION){
	// retCode = MemberServiceRetCode.DISMISSIONED;
	// }
	// //�ж��Ƿ���Ҫ�̶�������֤
	// //�̶�������֤��������ǹ̶������¼��ִ�д˴�����
	// if(mparameter.getChosenAuthType().equals("SimpAuth")){
	// if(employeeextendDao.find4Login(employee.getEmployeeid(),
	// mparameter.getFixedPW())==null){
	// isSuccess = false;
	// retCode = MemberServiceRetCode.FIXED_PW_VERIFY_FAIL;
	// }
	// }
	// }
	// result.setSuccess(isSuccess);
	// result.setRetCode(retCode);
	// return result;
	// }
	/*
	 * 20140307 ʷ���� �������� ֧�ָ��������Ա��¼����Ա������רԱ�������̡��������� �����Ա��Ϣ
	 */
	private ServiceResult dealEmployee(Employee emp,
			MemberQueryParameter mparameter) {
		ServiceResult result = new ServiceResult();
		boolean isSuccess = false;
		int retCode = MemberServiceRetCode.FAIL;
		// �û�������
		if (emp == null) {// empAll == null ||
			retCode = MemberServiceRetCode.NOT_REGISTER;
		}
		// �û�����ȷ
		else {
			int empstatus = emp.getEmpstatus().intValue();
			// ��ְ
			if (empstatus == Role.INCUMBENCY) {
				isSuccess = true;
				retCode = MemberServiceRetCode.SUCCESS;
				result.setRetObject(emp);
			}
			// ����ְ
			else if (empstatus == Role.DIMISSION) {
				retCode = MemberServiceRetCode.DISMISSIONED;
			}
			// �ж��Ƿ���Ҫ�̶�������֤
			// �̶�������֤��������ǹ̶������¼��ִ�д˴�����
			if (mparameter.getChosenAuthType().equals("SimpAuth")) {
				if (employeeextendDao.find4Login(emp.getEmployeeid(),
						mparameter.getFixedPW()) == null) {
					isSuccess = false;
					retCode = MemberServiceRetCode.FIXED_PW_VERIFY_FAIL;
				}
			}
		}
		result.setSuccess(isSuccess);
		result.setRetCode(retCode);
		return result;
	}

	/**
	 * 20140307 ʷ���� �ķ�������ʹ�� ��֧���ƹ�רԱ��¼ �����Ա��Ϣ-�����Ͻ�ɫ����ʱʹ�ô˷���
	 * 
	 * @param empAll
	 *            ��ѯ������Ա�б�
	 * @param mparameter
	 *            ��¼���洫�ݵĲ���
	 * @return
	 */
	// private ServiceResult dealEmployeeMixrole(List<Employee>
	// empAll,MemberQueryParameter mparameter){
	// ServiceResult result = new ServiceResult();
	// boolean isSuccess = false;
	// int retCode = MemberServiceRetCode.FAIL;
	//	    
	// Employee emp1 = empAll.get(0);
	// Employee emp2 = empAll.get(1);
	// if((emp1.getIsnet()==3 && emp2.getIsnet()==4) || (emp1.getIsnet()==4 &&
	// emp2.getIsnet()==3)){
	// isSuccess = true;
	// retCode = MemberServiceRetCode.MIX_ROLE; //ȷ�������¼��Ա�辭���ڶ�����֤����¼����ڶ���
	//	    	
	// //�ж��Ƿ���Ҫ�̶�������֤
	// //�̶�������֤��������ǹ̶������¼��ִ�д˴�����
	// if(mparameter.getChosenAuthType().equals("SimpAuth")){
	// ChPwEmployeeextend ext1 =
	// employeeextendDao.find4Login(emp1.getEmployeeid(),
	// mparameter.getFixedPW());
	// ChPwEmployeeextend ext2 =
	// employeeextendDao.find4Login(emp2.getEmployeeid(),
	// mparameter.getFixedPW());
	// if(ext1==null && ext2==null){//�̶��������
	// isSuccess = false;
	// retCode = MemberServiceRetCode.FIXED_PW_VERIFY_FAIL;
	// }else if(ext1!=null && ext2!=null){//������Ա�̶�������ͬ����ͨ����֤
	// ;//ȷ�������¼��Ա�辭���ڶ�����֤����¼����ڶ���
	// }else if(ext1!=null){
	// isSuccess = true;
	// retCode = MemberServiceRetCode.SUCCESS;
	// result.setRetObject(emp1);
	// }else{//ext2!=null
	// isSuccess = true;
	// retCode = MemberServiceRetCode.SUCCESS;
	// result.setRetObject(emp2);
	// }
	// }
	// }else{
	// retCode = MemberServiceRetCode.MORE_THAN_ONE_MASTER;
	// }
	//	    
	// result.setSuccess(isSuccess);
	// result.setRetCode(retCode);
	// return result;
	// }

	/*
	 * 20140307 ʷ���� �������� ֧�ָ��������Ա��¼����Ա������רԱ�������̡��������� �����Ա��Ϣ-�����Ͻ�ɫ����ʱʹ�ô˷���
	 */
	private ServiceResult dealEmployeeMixrole(List<Employee> empAll,
			MemberQueryParameter mparameter) {
		ServiceResult result = new ServiceResult();
		Employee empone = null;
		try {
			Map<Integer, String> isnetMap = new HashMap<Integer, String>();
			for (Employee emp : empAll) {
				if (!mparameter.getChosenAuthType().equals("SimpAuth")) {// �ǹ̶������½
					isnetMap.put(emp.getIsnet().intValue(), ISNET_MAP.get(emp
							.getIsnet().intValue()));
				} else {
					ChPwEmployeeextend ext = employeeextendDao.find4Login(emp
							.getEmployeeid(), mparameter.getFixedPW());
					if (ext != null) {
						isnetMap.put(emp.getIsnet().intValue(), ISNET_MAP
								.get(emp.getIsnet().intValue()));
						empone = emp;
					}
				}
			}

			if (isnetMap.size() > 1) {// �����Ա�Ĺ̶�����һ��
				result.setSuccess(true);
				result.setRetCode(MemberServiceRetCode.MIX_ROLE);
				result.setRetObject(isnetMap);
			} else if (isnetMap.size() == 1) {// �����Ա�У��̶����������һ����Ա
				result.setSuccess(true);
				result.setRetCode(MemberServiceRetCode.SUCCESS);
				result.setRetObject(empone);
			} else {// ֻ�е��̶������¼�����̶����벻�������в�ѯ����Աʱ�Ż����˴��߼�
				result.setSuccess(false);
				result.setRetCode(MemberServiceRetCode.FIXED_PW_VERIFY_FAIL);
			}
		} catch (Exception e) {
			logger
					.error("MemberService��׽�쳣���������������������Ա��Ϣ-�����Ͻ�ɫ����ʱʹ�ô˷���dealEmployeeMixrole��:"
							+ e.getMessage());// ������û�
			e.printStackTrace();
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
		} finally {
			return result;
		}
	}

	/**
	 * ��ѯ������Ϣ
	 * 
	 * @param wayid
	 * @return
	 */
	private ServiceResult getChannelInfo(String wayid, long employee_isnet) {
		logger.info("��ѯ������Ϣ WAYID>>> " + wayid);
		ServiceResult result = new ServiceResult();
		boolean isSuccess = false;
		int retCode = MemberServiceRetCode.FAIL;

		try {
			Channel channel = getChannelDao().getChannelByWayId(wayid,
					employee_isnet);

			// ������Ϣ��ѯ�ɹ�
			if (channel != null) {
				int channelState = channel.getWaystate().intValue();
				logger.info("����״̬��ChannelState >>> " + channelState);
				// ����״̬Ϊ��Ч
				if (channelState == ChannelState.VALIDATION) {
					isSuccess = true;
					retCode = MemberServiceRetCode.SUCCESS;
					result.setRetObject(channel);
				}
				// ����״̬Ϊ��Ч
				else if (channelState == ChannelState.INVALIDATION) {
					retCode = MemberServiceRetCode.CHANNEL_INVALIDATION;
				}
				// ����״̬Ϊ��ɾ��
				else if (channelState == ChannelState.DELETE) {
					retCode = MemberServiceRetCode.CHANNEL_DELETE;
				} else {
					retCode = MemberServiceRetCode.CHANNEL_STATE_MISTAKE;
				}
			}// if
			else {
				retCode = MemberServiceRetCode.CHANNEL_FAIL;
			}

			result.setSuccess(isSuccess);
			result.setRetCode(retCode);
		} catch (Exception e) {
			logger.error("MemberService��׽�쳣������������������ѯ������ϢServiceResult��:"
					+ e.getMessage());// ������û�
			e.printStackTrace();
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
		} finally {
			return result;
		}
	}

	/**
	 * ������¼����
	 * 
	 * @param employee
	 *            ��Ա��Ϣ
	 * @param channel
	 *            ������Ϣ
	 * @param loginType
	 *            ��¼����
	 * @return
	 */
	// private LoginMember createMember(Employee employee, Channel channel) {
	private ServiceResult createMember(Employee employee, Channel channel) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(MemberServiceRetCode.FAIL);

		LoginMember member = new LoginMember();
		member.setChannel(channel);// ����������Ϣ
		String cityid = employee.getCityid();
		if (cityid == null || "".equals(cityid.trim())) {
			cityid = channel.getCityid();
			if (cityid == null || "".equals(cityid.trim())) {
				result.setRetCode(MemberServiceRetCode.MEMBERCITY);
				// result.setMessage("�޷�ȷ����½��Ա��������");
				return result;
			}
		}
		logger.info("��Ա����Ϊ��cityid >>> " + cityid);
		member.setWayid(employee.getWayid());
		member.setCityid(cityid);
		member.setCityno(cityid);
		member.setEmployeename(employee.getEmployeename());
		if (employee.getIsnet() != 2L) {
			member.setOfficetel(employee.getOfficetel());
		} else {// isnet=2
			member.setOfficetel(employee.getTelephone());
		}

		member.setOprcode(employee.getOprcode());

		Long isnet = employee.getIsnet();
		member.setIsnet(isnet);

		member.setServoffice(employee.getServoffice());
		// ���� 2009/08/17 for �����ѯ
		member.setEmployeeid(employee.getEmployeeid());
		member.setTelephone(employee.getTelephone());

		if (employee.getIsnet() == Role.MISSIONER) {
			if (employee.getEmpattr2() == null) {
				result.setSuccess(false);
				result.setRetCode(MemberServiceRetCode.MEMBERNULL);
				// result.setMessage("רԱ����Ϊ�գ����ܷ���");
				return result;

			} else if (employee.getEmpattr2() != 1
					&& employee.getEmpattr2() != 2
					&& employee.getEmpattr2() != 3) {
				// result.setMessage("��������רԱ���Ͳ�֧�ַ���");
				result.setSuccess(false);
				result.setRetCode(MemberServiceRetCode.MEMBERTYPE);
				return result;
			}
		}
		member.setEmpattr2(employee.getEmpattr2());

		// //����Ƿ���ʾ
		// String paramReward = ibGlSysparamDao.getSysValue(1L, "pboss_Web");
		// //���س���Ƿ���ʾ
		// String paramLocalReward = ibGlSysparamDao.getSysValue(2L,
		// "pboss_Web");

		// ʷ���� 2012-07-12
		// �˴����ݼ����߼�Ǩ�Ƶ�DelayLoadServiceImpl�࣬���ݲ�ͬ��¼��ɫ��ÿ�ν�����Ӧ��ҳ�Ǽ��أ��Ա���ߵ�¼Ч��
		// //��ȡ��������Ϣ
		// ChDstCooperator cooperator =
		// this.chDstCooperatorService.getByWayid(channel.getWayid());
		// //��ȡ����������Ϣ
		// Employee mag = this.getById(channel.getWaymagcode());
		//		
		// // member.setIsShowReward(paramReward);
		// // member.setIsShowLocalReward(paramLocalReward);
		// member.setIsShowReward(this.saDbWebfunctionitemService.getShowReward(member.getCityid()));
		// //System.out.println("�Ƿ���ʾ���:"+member.getIsShowReward());
		// member.setIsShowLocalReward(this.saDbWebfunctionitemService.getShowLocalReward(member.getCityid()));
		// //System.out.println("�Ƿ���ʾ���س��:"+member.getIsShowLocalReward());
		// if(cooperator!=null){
		// member.setRecpers(cooperator.getRecpers());
		// member.setAcctno(cooperator.getAcctno());
		// member.setBankname(cooperator.getBankname());
		// }
		// if(mag!=null){
		// member.setMagName(mag.getEmployeename());
		// }
		// //���ز˵���
		// // Map<String,ArrayList> menuMap =
		// this.saDbWebfunctionitemService.getMenuMap(member);
		// Map<String,ArrayList> menuMap =
		// this.saDbWebfunctionitemService.getMenuMap(member.getCityid(),Integer.parseInt(member.getIsnet().toString()));
		// member.setMenuMap(menuMap);
		// ���ӳټ��ص���Ϣ��δ����
		member.setInfoloaded(false);

		result.setSuccess(true);
		result.setRetObject(member);
		return result;
	}

	/**
	 * ������¼����
	 * 
	 * @param employee
	 *            ��Ա��Ϣ
	 * @param loginType
	 *            ��¼����
	 * @return
	 */
	// private LoginMember createMember(Employee employee, Channel channel) {
	private ServiceResult createMember2(Employee employee) {
		ServiceResult result = new ServiceResult();

		LoginMember member = new LoginMember();
		String cityid = employee.getCityid();
		if (cityid == null || "".equals(cityid.trim())) {
			result.setRetCode(MemberServiceRetCode.MEMBERCITY);
			// result.setMessage("�޷�ȷ����½��Ա��������");
			return result;

		}
		logger.info("��Ա����Ϊ��cityid >>> " + cityid);
		member.setCityid(cityid);
		member.setCityno(cityid);
		member.setEmployeeid(employee.getEmployeeid());
		member.setEmployeename(employee.getEmployeename());
		member.setOprcode(employee.getOprcode());
		member.setOfficetel(employee.getOfficetel());
		Long isnet = employee.getIsnet();
		member.setIsnet(isnet);

		member.setTelephone(employee.getOfficetel());

		// ���ӳټ��ص���Ϣ��δ����
		member.setInfoloaded(false);
		result.setRetCode(MemberServiceRetCode.SUCCESS);
		result.setSuccess(true);
		result.setRetObject(member);
		return result;
	}

	/** GET / SET ���� */
	public IChannelDao getChannelDao() {
		return channelDao;
	}

	public void setChannelDao(IChannelDao channelDao) {
		this.channelDao = channelDao;
	}

	/**
	 * @return the nosectService
	 */
	public NosectService getNosectService() {
		return nosectService;
	}

	/**
	 * @param nosectService
	 *            the nosectService to set
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

	/**
	 * �����û�Id��ѯ�û�
	 * 
	 * @param id
	 *            ��ԱId
	 * @return
	 */
	public Employee getById(String id) {
		Employee employee = ((IMemberDao) getDao()).getById(id);
		return employee;
	}

	/**
	 * �����û�wayId��ѯ�û�cityid
	 * 
	 * @param id
	 *            ��ԱId
	 * @return
	 */
	public Channel getByWayId(String wayid) {
		Channel channel = channelDao.getByWayId(wayid);
		return channel;
	}

	// ʷ���� 2012-07-12
	// �˴����ݼ����߼�Ǩ�Ƶ�DelayLoadServiceImpl�࣬���ݲ�ͬ��¼��ɫ��ÿ�ν�����Ӧ��ҳ�Ǽ��أ��Ա���ߵ�¼Ч��
	// /**�û���Ϣչʾ-��������Ϣ*/
	// public void setChDstCooperatorService(ChDstCooperatorService
	// chDstCooperatorService){
	// this.chDstCooperatorService = chDstCooperatorService;
	// }
	// public ChDstCooperatorService getChDstCooperatorService(){
	// return this.chDstCooperatorService;
	// }
	//	
	// public SaDbWebfunctionitemService getSaDbWebfunctionitemService() {
	// return saDbWebfunctionitemService;
	// }
	// public void setSaDbWebfunctionitemService(
	// SaDbWebfunctionitemService saDbWebfunctionitemService) {
	// this.saDbWebfunctionitemService = saDbWebfunctionitemService;
	// }
	public EmployeeextendDao getEmployeeextendDao() {
		return employeeextendDao;
	}

	public void setEmployeeextendDao(EmployeeextendDao employeeextendDao) {
		this.employeeextendDao = employeeextendDao;
	}

	public ChSmsSmstmplDao getChSmsSmstmplDao() {
		return chSmsSmstmplDao;
	}

	public void setChSmsSmstmplDao(ChSmsSmstmplDao chSmsSmstmplDao) {
		this.chSmsSmstmplDao = chSmsSmstmplDao;
	}

	public ChSmsWaitreqDao getChSmsWaitreqDao() {
		return chSmsWaitreqDao;
	}

	public void setChSmsWaitreqDao(ChSmsWaitreqDao chSmsWaitreqDao) {
		this.chSmsWaitreqDao = chSmsWaitreqDao;
	}

	public ProvincecityadminDao getProvincecityadminDao() {
		return provincecityadminDao;
	}

	public void setProvincecityadminDao(ProvincecityadminDao provincecityadminDao) {
		this.provincecityadminDao = provincecityadminDao;
	}
	
}
