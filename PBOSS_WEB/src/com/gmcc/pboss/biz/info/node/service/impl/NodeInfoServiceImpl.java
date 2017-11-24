package com.gmcc.pboss.biz.info.node.service.impl;

import java.util.Date;
import java.util.List;

import com.gmcc.pboss.biz.basic.AuditWork.dao.AuditWorkDao;
import com.gmcc.pboss.biz.basic.goods.dao.IbGlSysparamDao;
import com.gmcc.pboss.biz.basic.node.dao.ChPwAdvinfoDao;
import com.gmcc.pboss.biz.basic.node.dao.ChPwFlownameDao;
import com.gmcc.pboss.biz.basic.node.dao.ChPwRcvobjDao;
import com.gmcc.pboss.biz.info.node.dao.WayAccountDao;
import com.gmcc.pboss.biz.info.node.model.WayAccount;
import com.gmcc.pboss.biz.info.node.service.NodeInfoService;
import com.gmcc.pboss.biz.info.node.support.NodeInfoQueryParameter;
import com.gmcc.pboss.biz.info.node.support.NodeInfoQueryParameterProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.config.bean.PendingTaskConfigBean;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.PendingTaskName;
import com.gmcc.pboss.common.nosect.service.NosectService;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.common.util.CommonUtil;
import com.gmcc.pboss.member.model.Employee;
import com.gmcc.pboss.member.support.MemberQueryParameter;
import com.gmcc.pboss.model.auditWork.ChPwAuditwork;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;
import com.gmcc.pboss.model.communi.ChPwRcvobj;
import com.gmcc.pboss.model.constant.IbGlSysparam;
import com.gmcc.pboss.model.constant.IbGlSysparamId;
import com.gmcc.pboss.model.wayapply.ChPwWayapply;

public class NodeInfoServiceImpl extends QueryBaseServiceImpl implements NodeInfoService {

	private AuditWorkDao auditWorkDao;
	
	/**审核步骤定义DAO*/
	private ChPwFlownameDao chPwFlownameDao;
	/**公告信息DAO*/
	private ChPwAdvinfoDao chPwAdvinfoDao;
	/**接受对象DAO*/
	private ChPwRcvobjDao chPwRcvobjDao;
	/**WayAccountDao DAO*/
	private WayAccountDao wayAccountDao;

	/** 手机号码归属地查询 Service*/
	private NosectService nosectService;
	
	/**
	 * 系统参数 DAO
	 */
	private IbGlSysparamDao ibGlSysparamDao;
	/**
	 * @return the auditWorkDao
	 */
	public AuditWorkDao getAuditWorkDao() {
		return auditWorkDao;
	}

	/**
	 * @param auditWorkDao the auditWorkDao to set
	 */
	public void setAuditWorkDao(AuditWorkDao auditWorkDao) {
		this.auditWorkDao = auditWorkDao;
	}

	public NodeInfoServiceImpl() {
		this.serviceCode = ServiceCode.NODE;
		this.serviceName = "网点资料";
		this.isNeedLogin = true;
		setProcessor(new NodeInfoQueryParameterProcessor());
	}

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl#query(com.gmcc.pboss.common.bean.LoginMember, com.gmcc.pboss.common.support.QueryParameter)
	 */
	/**
	 * 重载父类，网店资料查询
	 */
	@Override
	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		ServiceResult rtn = super.query(member, parameter);
		//单独查询WayAccount
		if (rtn.isSuccess()){
			//查询成功才提取
			List rtnList = rtn.getRetResult().getData();
			if (rtnList.size()>0){
				com.gmcc.pboss.biz.info.node.model.Employee emp = (com.gmcc.pboss.biz.info.node.model.Employee)rtnList.get(0);
				//提取wayaccount
				WayAccount wayAcc = this.wayAccountDao.getWayAccountByWayidAccno(emp.getWayid());
				emp.setWayAccount(wayAcc);
				//重新封装
				rtnList.clear();
				rtnList.add(emp);
				rtn.setRetResult(new QueryResult(null, rtnList));
//				System.out.println(emp.getWayid() +"");
			}
		}
		return rtn;
	}

	/**
	 * 网点资料修改
	 * @@修改为同步方法
	 */
	public ServiceResult modify(LoginMember member, QueryParameter parameter) {
		NodeInfoQueryParameter saveParm = ( NodeInfoQueryParameter)parameter;
		
		ServiceResult result = new ServiceResult();
		boolean isSuccess = false;
		int retCode = ServiceRetCode.FAIL;

		//检查手机号码是否存在
		Employee employee = (Employee)getMemberDao().get(saveParm.getEmployeeId());
		ChPwWayapply apply = (ChPwWayapply)saveParm.getSaveObj();
		if(!apply.getPrincipaltel().equals(employee.getOfficetel())){
			//判断手机号码所在地市
			//切换公共库
			SessionFactoryContextHolder.setSessionFactoryContext(null);
			MemberQueryParameter mparameter = new MemberQueryParameter();
			mparameter.setOfficeTel(apply.getPrincipaltel());
			ServiceResult noSectrslt = nosectService.transact(null, mparameter, ServiceType.INITIATE);
			if(!noSectrslt.isSuccess()){
				result.setSuccess(false);
				result.setRetCode(ServiceRetCode.UNDEFAULT_BRANCH);
				return result;
			}
			String cityId = (String)noSectrslt.getRetObject();
			if (!cityId.equals(member.getCityid())){
				result.setSuccess(false);
				result.setRetCode(ServiceRetCode.MOBILENOCITYERROR);
				return result;
			}
			
			//切换到地市库
			SessionFactoryContextHolder.setSessionFactoryContext(member.getCityid());
			ServiceResult offTelResl = existsEmployee(apply.getPrincipaltel());
			if (offTelResl.isSuccess()){
				//手机号码已经存在
				result.setSuccess(false);
				result.setRetCode(ServiceRetCode.MOBLEEXIST);
				return result;
			}
		}
		
		String stepid = ConstantsType.AUDITSTEPID_WAY_UPDATE1;
		Byte state = ConstantsType.AUDITSTATUS_NO;

		//切换到地市库
		SessionFactoryContextHolder.setSessionFactoryContext(member.getCityid());
		chPwFlownameDao.reloadSessionFactory();
		

		//提取系统参数：网点审批角色控制，1为启用；0为不启用
		String paramChannal = ((IbGlSysparam) ibGlSysparamDao.get(new IbGlSysparamId((long)67,"channel"))).getParamvalue();
		String oprcode = null;
		boolean useWayMmg = false;
		if ("1".equals(paramChannal)){
			//渠道经理
			useWayMmg = true;
			oprcode = member.getChannel().getWaymagcode();
		}else{	
			//按步骤表 查询默认处理人
			oprcode = chPwFlownameDao.getOprcodeByStepID(stepid);
		}
		
		if(!CommonUtil.isEmptyOrNull(oprcode)){
			
			Date now = new Date();

			//把Principaltel复制到Officetel
			apply.setOfficetel(apply.getPrincipaltel());
			//1，插入申请表
			apply = (ChPwWayapply)saveParm.getSaveObj();
			apply.setAuditstatus(state);//审核状（AUDITSTATUS）态为0
			apply.setOptime(now);
			this.save(apply);
			
			//2，插入处理工单表
			ChPwAuditwork auditWork = new ChPwAuditwork();
			auditWork.setWorktype(ConstantsType.AUDITWORKTYPE_WAYUPDATE);
			auditWork.setApplyno(apply.getApplyno());
			auditWork.setStepid(stepid);
			auditWork.setCreatetime(apply.getOptime());
			auditWork.setAuditstatus(state);
			auditWork.setOprcode(oprcode);
			auditWorkDao.save(auditWork);
			
			//3，录入公告信息表及待办任务
			PendingTaskConfigBean bean = ConfigUtil.getPendingTaskConfigByName(PendingTaskName.WAY_UPDATE);

			//设置发布工号
			ChPwAdvinfo info = CommonUtil.createPendingTask(bean, now, auditWork, stepid,member.getEmployeeid());
			chPwAdvinfoDao.save(info);
			
			//4，录入接受对象表
			ChPwRcvobj obj = new ChPwRcvobj();
			obj.setAdvinfo(info);
			obj.setObjid(oprcode);
			obj.setState(ConstantsType.UNPUBLISH);
			obj.setStatetime(now);
			chPwRcvobjDao.save(obj);
			
			isSuccess = true;
			retCode = ServiceRetCode.DEF_APPLY;
		}
		else{
			if (useWayMmg) 
				retCode = ServiceRetCode.EMPTY_WAYMMG;//渠道经理没有定义
			else
				retCode = ServiceRetCode.NOTFOUND_OPRCODE;//下一步处理人没有定义
		}
		
		result.setSuccess(isSuccess);
		result.setRetCode(retCode);
		return result;
	}

	/**
	 * 网点申请退出
	 * @@修改为同步方法
	 */
	public ServiceResult cancel(LoginMember member, QueryParameter parameter) {
		NodeInfoQueryParameter saveParm = ( NodeInfoQueryParameter)parameter;
		
		ServiceResult result = new ServiceResult();
		boolean isSuccess = false;
		int retCode = ServiceRetCode.FAIL;
		
		String stepid = ConstantsType.AUDITSTEPID_WAY_REMOVE1;
		Byte state = ConstantsType.AUDITSTATUS_NO;
		
		//提取系统参数：网点审批角色控制，1为启用；0为不启用
		String paramChannal = ((IbGlSysparam) ibGlSysparamDao.get(new IbGlSysparamId((long)67,"channel"))).getParamvalue();
		String oprcode = null;
		boolean useWayMmg = false;
		if ("1".equals(paramChannal)){
			//渠道经理
			useWayMmg = true;
			oprcode = member.getChannel().getWaymagcode();
		}else{	
			//按步骤表 查询默认处理人
			oprcode = chPwFlownameDao.getOprcodeByStepID(stepid);
		}
		
		if(!CommonUtil.isEmptyOrNull(oprcode)){
			Date now = new Date();
			
			//1，插入申请表
			ChPwWayapply apply = (ChPwWayapply)saveParm.getSaveObj();
			apply.setAuditstatus(state);//审核状（AUDITSTATUS）态为0
			apply.setOptime(now);
			this.save(apply);
			
			//2，插入处理工单表
			ChPwAuditwork auditWork = new ChPwAuditwork();
			auditWork.setWorktype(ConstantsType.AUDITWORKTYPE_WAYREMOVE);
			auditWork.setApplyno(apply.getApplyno());
			auditWork.setStepid(stepid);
			auditWork.setCreatetime(apply.getOptime());
			auditWork.setAuditstatus(state);
			auditWork.setOprcode(oprcode);
			auditWorkDao.save(auditWork);
			
			//3，录入公告信息表及待办任务
			PendingTaskConfigBean bean = ConfigUtil.getPendingTaskConfigByName(PendingTaskName.WAY_REMOVE);
			ChPwAdvinfo info = CommonUtil.createPendingTask(bean, now, auditWork, stepid,member.getEmployeeid());
			chPwAdvinfoDao.save(info);
			
			//4，录入接受对象表
			ChPwRcvobj obj = new ChPwRcvobj();
			obj.setAdvinfo(info);
			obj.setObjid(oprcode);
			obj.setState(ConstantsType.UNPUBLISH);
			obj.setStatetime(now);
			chPwRcvobjDao.save(obj);
			
			isSuccess = true;
			retCode = ServiceRetCode.DEF_OUT;
		}
		else{
			if (useWayMmg) 
				retCode = ServiceRetCode.EMPTY_WAYMMG;//渠道经理没有定义
			else
				retCode = ServiceRetCode.NOTFOUND_OPRCODE;//下一步处理人没有定义
		}
		
		result.setSuccess(isSuccess);
		result.setRetCode(retCode);
		
		return result;
	}

	public ChPwFlownameDao getChPwFlownameDao() {
		return chPwFlownameDao;
	}

	public void setChPwFlownameDao(ChPwFlownameDao chPwFlownameDao) {
		this.chPwFlownameDao = chPwFlownameDao;
	}

	public ChPwAdvinfoDao getChPwAdvinfoDao() {
		return chPwAdvinfoDao;
	}

	public void setChPwAdvinfoDao(ChPwAdvinfoDao chPwAdvinfoDao) {
		this.chPwAdvinfoDao = chPwAdvinfoDao;
	}

	public ChPwRcvobjDao getChPwRcvobjDao() {
		return chPwRcvobjDao;
	}

	public void setChPwRcvobjDao(ChPwRcvobjDao chPwRcvobjDao) {
		this.chPwRcvobjDao = chPwRcvobjDao;
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

	/**
	 * @return the wayAccountDao
	 */
	public WayAccountDao getWayAccountDao() {
		return wayAccountDao;
	}

	/**
	 * @param wayAccountDao the wayAccountDao to set
	 */
	public void setWayAccountDao(WayAccountDao wayAccountDao) {
		this.wayAccountDao = wayAccountDao;
	}

	/**
	 * @return the ibGlSysparamDao
	 */
	public IbGlSysparamDao getIbGlSysparamDao() {
		return ibGlSysparamDao;
	}

	/**
	 * @param ibGlSysparamDao the ibGlSysparamDao to set
	 */
	public void setIbGlSysparamDao(IbGlSysparamDao ibGlSysparamDao) {
		this.ibGlSysparamDao = ibGlSysparamDao;
	}
}
