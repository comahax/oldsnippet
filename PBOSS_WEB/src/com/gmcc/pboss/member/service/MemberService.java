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
 * 从兴公司电子渠道业务部
 * 
 * @author tangzhu
 * @date 2009-7-29 所属项目： 所属模块： 描述：
 */
public class MemberService extends BaseServiceImpl implements IMemberService {
	private static Logger logger = Logger.getLogger(MemberService.class);

	private static Map<Integer, String> ISNET_MAP = new HashMap<Integer, String>();
	static {
		ISNET_MAP.put(0, "店员");
		ISNET_MAP.put(1, "店主");
		ISNET_MAP.put(2, "推广专员");
		ISNET_MAP.put(3, "配送商");
		ISNET_MAP.put(4, "渠道经理");
		ISNET_MAP.put(5, "省公司管理员");
		ISNET_MAP.put(6, "市公司管理员");
	}

	/** 渠道DAO */
	private IChannelDao channelDao;

	/** 手机号码归属地查询 Service */
	private NosectService nosectService;

	private IbGlSysparamDao ibGlSysparamDao;

	// 史晓龙 2012-07-12
	// 此处数据加载逻辑迁移到DelayLoadServiceImpl类，根据不同登录角色，每次进入相应首页是加载，以便提高登录效率
	// /** 注入ChDstCooperatorService接口,根据登陆用户渠道id查找分销合作商*/
	// private ChDstCooperatorService chDstCooperatorService;
	//	
	// /**加载菜单的Service，菜单信息放在数据库表SA_DB_WEBFUNCTIONITEM中*/
	// private SaDbWebfunctionitemService saDbWebfunctionitemService;

	/** 员扩展表信息查询，用于固定密码登录 */
	private EmployeeextendDao employeeextendDao;
	/** 省市管理员扩展表信息查询，用于固定密码登录 */
	private ProvincecityadminDao provincecityadminDao;

	// 获取短信模版
	private ChSmsSmstmplDao chSmsSmstmplDao;
	// 插入待发短信
	private ChSmsWaitreqDao chSmsWaitreqDao;

	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public MemberService() {
		super();
		this.serviceCode = ServiceCode.MEMBER;
		this.serviceName = "店员管理";
		isNeedLogin = false;// 不需要登录
	}

	/**
	 * 在这里实现登录的业务逻辑
	 */
	public ServiceResult initiate(LoginMember member, QueryParameter parameter) {

		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(MemberServiceRetCode.FAIL);

		MemberQueryParameter mparameter = (MemberQueryParameter) parameter;
		if (mparameter.getIsnet() == null || "".equals(mparameter.getIsnet())) {
			result = this.initialize1(mparameter);// 对应第一步登录界面
		} else {
			result = this.initialize2(mparameter);// 对应第二步登录界面
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
			// 判断手机号码所在地市//切换公共库
			SessionFactoryContextHolder.setSessionFactoryContext(null);
			// result = nosectService.transact(null, mparameter,
			// ServiceType.INITIATE);
			result = nosectService.initiate(null, mparameter);
			if (!result.isSuccess()){
					result.setSuccess(false);
					return result;
		
			}
			String cityId = (String) result.getRetObject();
			// 判断地市是否开放
			String getConfig = Constant.getConstantName(ConstantsType.ISOPEN,
					cityId);
			if (!ConstantsType.ISOPEN_YES.equals(getConfig)) {
				result.setSuccess(false);
				result.setRetCode(MemberServiceRetCode.INVALIDCITY);
				return result;
			}

			// 切换地市库
			// 雇员
			SessionFactoryContextHolder.setSessionFactoryContext(cityId);
			// List<Employee> empAll = ((IMemberDao)
			// getDao()).getAllUserByOfficTel(officeTel);
			List<Employee> empAll = ((IMemberDao) getDao())
					.getAllUserByMobile(officeTel);
			if (empAll != null && empAll.size() > 1) {// 存在多个人员
				int isnet[] = { 0, 0, 0, 0, 0, 0, 0 };// 记录查询到的各类人员数量
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
				if ((isnet[0] > 0 && isnet[1] > 0) // 号码既为店员又是店主，人员数据重复
						|| isnet[0] > 1 // 存在多个店员，人员数据重复
						|| isnet[1] > 1 // 存在多个店主，人员数据重复
						|| isnet[2] > 1 // 存在多个专员，人员数据重复
						|| isnet[3] > 1 // 存在多个配送商，人员数据重复
						|| isnet[4] > 1 || isnet[5] > 1 || isnet[6] > 1) {// 存在多个渠道经理，人员数据重复
					result.setSuccess(false);
					result
							.setRetCode(MemberServiceRetCode.MORE_THAN_ONE_MASTER);
				} else {// 处理一个号码存在多个不同角色的情况
					result = dealEmployeeMixrole(empAll, mparameter);
					if (!result.isSuccess()) {// 有失败信息，返回界面
						return result;
					} else if (result.isSuccess()
							&& result.getRetCode() == MemberServiceRetCode.MIX_ROLE) {// 固定密码对应多个人员，返回界面让用户选择登录角色
						return result;
					}
					// 固定密码对应唯一人员，直接做后续处理
					// else if(result.isSuccess() &&
					// result.getRetCode()==MemberServiceRetCode.SUCCESS){;}
				}
			} else if (empAll != null && empAll.size() == 1) {// 仅有一个人员
				result = dealEmployee(empAll.get(0), mparameter);
				if (!result.isSuccess())
					return result;
			} else {
				
					// 人员不存在
					result.setSuccess(false);
					result.setRetCode(MemberServiceRetCode.NOT_REGISTER);
					return result;
			}

			// 渠道
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
					// 渠道信息查询失败
					result.setSuccess(false);
					result.setRetCode(MemberServiceRetCode.CHANNEL_FAIL);
					return result;
				} else {
					result = getChannelInfo(employee.getWayid(), employee
							.getIsnet());
				}
			} else {
				// 渠道信息查询失败
				result.setSuccess(false);
				result.setRetCode(MemberServiceRetCode.CHANNEL_FAIL);
				return result;
			}
			if (!result.isSuccess())
				return result;
			if (mparameter.getChosenAuthType().equals("SimpAuth")) {
				// 固定密码登陆，验证成功，插入待发送短信到CH_SMS_WAITREQ表
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

			// 渠道类别
			Channel channel = (Channel) result.getRetObject();
			// 渠道星级翻译
			if (channel != null) {
				if (channel.getStarlevel() != null) {
					channel.setStrStarLevel(Constant.getConstantName(
							ConstantsType.STARLEVEL, channel.getStarlevel()
									.toString()));
				}
			}

			// 创建对象
			if (result.isSuccess()) {
				// LoginMember lm = createMember(employee, channel);
				// result.setRetObject(lm);
				result = this.createMember(employee, channel);
			}
		} catch (Exception e) {
			logger.error("MemberService扑捉异常》》》》》》》》》initialize1:"
					+ e.getMessage());// 输出到用户
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
			logger.info("登录号码　officeTel >>> " + officeTel);
			String isnet = mparameter.getIsnet();
			logger.info("登录角色　isnet >>> " + isnet);

			// 判断手机号码所在地市//切换公共库
			SessionFactoryContextHolder.setSessionFactoryContext(null);
			// result = nosectService.transact(null, mparameter,
			// ServiceType.INITIATE);
			result = nosectService.initiate(null, mparameter);
			if (!result.isSuccess()){
				result.setSuccess(false);
				return result;
		
			}
				
			String cityId = (String) result.getRetObject();
			// 判断地市是否开放
			String getConfig = Constant.getConstantName(ConstantsType.ISOPEN,
					cityId);
			if (!ConstantsType.ISOPEN_YES.equals(getConfig)) {
				result.setSuccess(false);
				result.setRetCode(MemberServiceRetCode.INVALIDCITY);
				return result;
			}

			// 切换地市库
			// 雇员
			SessionFactoryContextHolder.setSessionFactoryContext(cityId);
			logger.info("所属地市　cityId >>> " + cityId);
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
					// 渠道信息查询失败
					logger.info("渠道编码或者Isnet为null >>> ");
					result.setSuccess(false);
					result.setRetCode(MemberServiceRetCode.CHANNEL_FAIL);
					return result;
				} else {
					result = getChannelInfo(employee.getWayid(), employee
							.getIsnet());
				}
			} else {
				
					// 人员不存在
					result.setSuccess(false);
					result.setRetCode(MemberServiceRetCode.NOT_REGISTER);
					return result;
				
			}
			if (!result.isSuccess())
				return result;
			if (mparameter.getChosenAuthType().equals("SimpAuth")) {
				// 固定密码登陆，验证成功，插入待发送短信到CH_SMS_WAITREQ表
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

			// 渠道类别
			Channel channel = (Channel) result.getRetObject();
			// 渠道星级翻译
			if (channel != null) {
				if (channel.getStarlevel() != null) {
					channel.setStrStarLevel(Constant.getConstantName(
							ConstantsType.STARLEVEL, channel.getStarlevel()
									.toString()));
				}
			}

			// 创建对象
			if (result.isSuccess()) {
				// LoginMember lm = createMember(employee, channel);
				// result.setRetObject(lm);
				result = this.createMember(employee, channel);
			}

		} catch (Exception e) {
			logger.error("MemberService扑捉异常》》》》》》》》》initialize2:"
					+ e.getMessage());// 输出到用户
			e.printStackTrace();
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
		} finally {
			return result;
		}
	}

	/**
	 * 查询店员
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		boolean isSuccess = false;
		int retCode = MemberServiceRetCode.FAIL;
		try {
			// 查询条件处理器
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
			logger.error("MemberService扑捉异常》》》》》》》》查询店员query》:"
					+ e.getMessage());// 输出到用户
			e.printStackTrace();
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
		} finally {
			return result;
		}
	}

	/**
	 * 20140307 史晓龙 改方法不再使用 不支持推广专员登录 检测人员信息
	 * 
	 * @param empAll
	 *            查询到的人员列表
	 * @param mparameter
	 *            登录界面传递的参数
	 * @return
	 */
	// private ServiceResult dealEmployee(List<Employee>
	// empAll,MemberQueryParameter mparameter){
	// ServiceResult result = new ServiceResult();
	// boolean isSuccess = false;
	// int retCode = MemberServiceRetCode.FAIL;
	// Employee employee = null;
	// // 用户不存在
	// if(empAll.size()==0 ){//empAll == null ||
	// retCode = MemberServiceRetCode.NOT_REGISTER;
	// }
	// //对应号码的在岗人员不唯一
	// else if(empAll.size()>1){
	// retCode = MemberServiceRetCode.MORE_THAN_ONE_MASTER;
	// }
	// // 用户名正确
	// else{
	// employee = empAll.get(0);
	// int empstatus = employee.getEmpstatus().intValue();
	// //在职
	// if (empstatus == Role.INCUMBENCY) {
	// isSuccess = true;
	// retCode = MemberServiceRetCode.SUCCESS;
	// result.setRetObject(employee);
	// }
	// //不在职
	// else if(empstatus == Role.DIMISSION){
	// retCode = MemberServiceRetCode.DISMISSIONED;
	// }
	// //判定是否需要固定密码验证
	// //固定密码验证——如果是固定密码登录，执行此处操作
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
	 * 20140307 史晓龙 新增方法 支持各类社会人员登录：店员店主、专员、配送商、渠道经理 检测人员信息
	 */
	private ServiceResult dealEmployee(Employee emp,
			MemberQueryParameter mparameter) {
		ServiceResult result = new ServiceResult();
		boolean isSuccess = false;
		int retCode = MemberServiceRetCode.FAIL;
		// 用户不存在
		if (emp == null) {// empAll == null ||
			retCode = MemberServiceRetCode.NOT_REGISTER;
		}
		// 用户名正确
		else {
			int empstatus = emp.getEmpstatus().intValue();
			// 在职
			if (empstatus == Role.INCUMBENCY) {
				isSuccess = true;
				retCode = MemberServiceRetCode.SUCCESS;
				result.setRetObject(emp);
			}
			// 不在职
			else if (empstatus == Role.DIMISSION) {
				retCode = MemberServiceRetCode.DISMISSIONED;
			}
			// 判定是否需要固定密码验证
			// 固定密码验证——如果是固定密码登录，执行此处操作
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
	 * 20140307 史晓龙 改方法不再使用 不支持推广专员登录 检测人员信息-允许混合角色存在时使用此方法
	 * 
	 * @param empAll
	 *            查询到的人员列表
	 * @param mparameter
	 *            登录界面传递的参数
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
	// retCode = MemberServiceRetCode.MIX_ROLE; //确定具体登录人员需经过第二步认证：登录界面第二步
	//	    	
	// //判定是否需要固定密码验证
	// //固定密码验证——如果是固定密码登录，执行此处操作
	// if(mparameter.getChosenAuthType().equals("SimpAuth")){
	// ChPwEmployeeextend ext1 =
	// employeeextendDao.find4Login(emp1.getEmployeeid(),
	// mparameter.getFixedPW());
	// ChPwEmployeeextend ext2 =
	// employeeextendDao.find4Login(emp2.getEmployeeid(),
	// mparameter.getFixedPW());
	// if(ext1==null && ext2==null){//固定密码错误
	// isSuccess = false;
	// retCode = MemberServiceRetCode.FIXED_PW_VERIFY_FAIL;
	// }else if(ext1!=null && ext2!=null){//两个人员固定密码相同，都通过验证
	// ;//确定具体登录人员需经过第二步认证：登录界面第二步
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
	 * 20140307 史晓龙 新增方法 支持各类社会人员登录：店员店主、专员、配送商、渠道经理 检测人员信息-允许混合角色存在时使用此方法
	 */
	private ServiceResult dealEmployeeMixrole(List<Employee> empAll,
			MemberQueryParameter mparameter) {
		ServiceResult result = new ServiceResult();
		Employee empone = null;
		try {
			Map<Integer, String> isnetMap = new HashMap<Integer, String>();
			for (Employee emp : empAll) {
				if (!mparameter.getChosenAuthType().equals("SimpAuth")) {// 非固定密码登陆
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

			if (isnetMap.size() > 1) {// 多个人员的固定密码一样
				result.setSuccess(true);
				result.setRetCode(MemberServiceRetCode.MIX_ROLE);
				result.setRetObject(isnetMap);
			} else if (isnetMap.size() == 1) {// 多个人员中，固定密码仅符合一个人员
				result.setSuccess(true);
				result.setRetCode(MemberServiceRetCode.SUCCESS);
				result.setRetObject(empone);
			} else {// 只有当固定密码登录，但固定密码不符合所有查询到人员时才会进入此处逻辑
				result.setSuccess(false);
				result.setRetCode(MemberServiceRetCode.FIXED_PW_VERIFY_FAIL);
			}
		} catch (Exception e) {
			logger
					.error("MemberService扑捉异常》》》》》》》》检测人员信息-允许混合角色存在时使用此方法dealEmployeeMixrole》:"
							+ e.getMessage());// 输出到用户
			e.printStackTrace();
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
		} finally {
			return result;
		}
	}

	/**
	 * 查询渠道信息
	 * 
	 * @param wayid
	 * @return
	 */
	private ServiceResult getChannelInfo(String wayid, long employee_isnet) {
		logger.info("查询渠道信息 WAYID>>> " + wayid);
		ServiceResult result = new ServiceResult();
		boolean isSuccess = false;
		int retCode = MemberServiceRetCode.FAIL;

		try {
			Channel channel = getChannelDao().getChannelByWayId(wayid,
					employee_isnet);

			// 渠道信息查询成功
			if (channel != null) {
				int channelState = channel.getWaystate().intValue();
				logger.info("渠道状态　ChannelState >>> " + channelState);
				// 渠道状态为有效
				if (channelState == ChannelState.VALIDATION) {
					isSuccess = true;
					retCode = MemberServiceRetCode.SUCCESS;
					result.setRetObject(channel);
				}
				// 渠道状态为无效
				else if (channelState == ChannelState.INVALIDATION) {
					retCode = MemberServiceRetCode.CHANNEL_INVALIDATION;
				}
				// 渠道状态为被删除
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
			logger.error("MemberService扑捉异常》》》》》》》》查询渠道信息ServiceResult》:"
					+ e.getMessage());// 输出到用户
			e.printStackTrace();
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
		} finally {
			return result;
		}
	}

	/**
	 * 创建登录对象
	 * 
	 * @param employee
	 *            雇员信息
	 * @param channel
	 *            渠道信息
	 * @param loginType
	 *            登录类型
	 * @return
	 */
	// private LoginMember createMember(Employee employee, Channel channel) {
	private ServiceResult createMember(Employee employee, Channel channel) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(MemberServiceRetCode.FAIL);

		LoginMember member = new LoginMember();
		member.setChannel(channel);// 设置渠道信息
		String cityid = employee.getCityid();
		if (cityid == null || "".equals(cityid.trim())) {
			cityid = channel.getCityid();
			if (cityid == null || "".equals(cityid.trim())) {
				result.setRetCode(MemberServiceRetCode.MEMBERCITY);
				// result.setMessage("无法确定登陆人员所属地市");
				return result;
			}
		}
		logger.info("人员地市为　cityid >>> " + cityid);
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
		// 新增 2009/08/17 for 网点查询
		member.setEmployeeid(employee.getEmployeeid());
		member.setTelephone(employee.getTelephone());

		if (employee.getIsnet() == Role.MISSIONER) {
			if (employee.getEmpattr2() == null) {
				result.setSuccess(false);
				result.setRetCode(MemberServiceRetCode.MEMBERNULL);
				// result.setMessage("专员类型为空，不能访问");
				return result;

			} else if (employee.getEmpattr2() != 1
					&& employee.getEmpattr2() != 2
					&& employee.getEmpattr2() != 3) {
				// result.setMessage("您所属的专员类型不支持访问");
				result.setSuccess(false);
				result.setRetCode(MemberServiceRetCode.MEMBERTYPE);
				return result;
			}
		}
		member.setEmpattr2(employee.getEmpattr2());

		// //酬金是否显示
		// String paramReward = ibGlSysparamDao.getSysValue(1L, "pboss_Web");
		// //本地酬金是否显示
		// String paramLocalReward = ibGlSysparamDao.getSysValue(2L,
		// "pboss_Web");

		// 史晓龙 2012-07-12
		// 此处数据加载逻辑迁移到DelayLoadServiceImpl类，根据不同登录角色，每次进入相应首页是加载，以便提高登录效率
		// //获取合作商信息
		// ChDstCooperator cooperator =
		// this.chDstCooperatorService.getByWayid(channel.getWayid());
		// //获取渠道经理信息
		// Employee mag = this.getById(channel.getWaymagcode());
		//		
		// // member.setIsShowReward(paramReward);
		// // member.setIsShowLocalReward(paramLocalReward);
		// member.setIsShowReward(this.saDbWebfunctionitemService.getShowReward(member.getCityid()));
		// //System.out.println("是否显示酬金:"+member.getIsShowReward());
		// member.setIsShowLocalReward(this.saDbWebfunctionitemService.getShowLocalReward(member.getCityid()));
		// //System.out.println("是否显示本地酬金:"+member.getIsShowLocalReward());
		// if(cooperator!=null){
		// member.setRecpers(cooperator.getRecpers());
		// member.setAcctno(cooperator.getAcctno());
		// member.setBankname(cooperator.getBankname());
		// }
		// if(mag!=null){
		// member.setMagName(mag.getEmployeename());
		// }
		// //加载菜单项
		// // Map<String,ArrayList> menuMap =
		// this.saDbWebfunctionitemService.getMenuMap(member);
		// Map<String,ArrayList> menuMap =
		// this.saDbWebfunctionitemService.getMenuMap(member.getCityid(),Integer.parseInt(member.getIsnet().toString()));
		// member.setMenuMap(menuMap);
		// 待延迟加载的信息尚未加载
		member.setInfoloaded(false);

		result.setSuccess(true);
		result.setRetObject(member);
		return result;
	}

	/**
	 * 创建登录对象
	 * 
	 * @param employee
	 *            雇员信息
	 * @param loginType
	 *            登录类型
	 * @return
	 */
	// private LoginMember createMember(Employee employee, Channel channel) {
	private ServiceResult createMember2(Employee employee) {
		ServiceResult result = new ServiceResult();

		LoginMember member = new LoginMember();
		String cityid = employee.getCityid();
		if (cityid == null || "".equals(cityid.trim())) {
			result.setRetCode(MemberServiceRetCode.MEMBERCITY);
			// result.setMessage("无法确定登陆人员所属地市");
			return result;

		}
		logger.info("人员地市为　cityid >>> " + cityid);
		member.setCityid(cityid);
		member.setCityno(cityid);
		member.setEmployeeid(employee.getEmployeeid());
		member.setEmployeename(employee.getEmployeename());
		member.setOprcode(employee.getOprcode());
		member.setOfficetel(employee.getOfficetel());
		Long isnet = employee.getIsnet();
		member.setIsnet(isnet);

		member.setTelephone(employee.getOfficetel());

		// 待延迟加载的信息尚未加载
		member.setInfoloaded(false);
		result.setRetCode(MemberServiceRetCode.SUCCESS);
		result.setSuccess(true);
		result.setRetObject(member);
		return result;
	}

	/** GET / SET 方法 */
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
	 * 根据用户Id查询用户
	 * 
	 * @param id
	 *            人员Id
	 * @return
	 */
	public Employee getById(String id) {
		Employee employee = ((IMemberDao) getDao()).getById(id);
		return employee;
	}

	/**
	 * 根据用户wayId查询用户cityid
	 * 
	 * @param id
	 *            人员Id
	 * @return
	 */
	public Channel getByWayId(String wayid) {
		Channel channel = channelDao.getByWayId(wayid);
		return channel;
	}

	// 史晓龙 2012-07-12
	// 此处数据加载逻辑迁移到DelayLoadServiceImpl类，根据不同登录角色，每次进入相应首页是加载，以便提高登录效率
	// /**用户信息展示-合作商信息*/
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
