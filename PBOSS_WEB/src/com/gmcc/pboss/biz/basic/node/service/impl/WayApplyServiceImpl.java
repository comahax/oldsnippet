package com.gmcc.pboss.biz.basic.node.service.impl;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.gmcc.pboss.biz.basic.AuditWork.dao.AuditWorkDao;
import com.gmcc.pboss.biz.basic.node.dao.ChPwAdvinfoDao;
import com.gmcc.pboss.biz.basic.node.dao.ChPwFlownameDao;
import com.gmcc.pboss.biz.basic.node.dao.ChPwRcvobjDao;
import com.gmcc.pboss.biz.basic.node.service.WayApllyServiceRetCode;
import com.gmcc.pboss.biz.basic.node.service.WayApplyService;
import com.gmcc.pboss.biz.basic.node.support.WayApplyQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.config.bean.PendingTaskConfigBean;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.PendingTaskName;
import com.gmcc.pboss.common.nosect.service.NosectService;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.common.util.CommonUtil;
import com.gmcc.pboss.member.service.MemberServiceRetCode;
import com.gmcc.pboss.member.support.MemberQueryParameter;
import com.gmcc.pboss.model.auditWork.ChPwAuditwork;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;
import com.gmcc.pboss.model.communi.ChPwRcvobj;
import com.gmcc.pboss.model.wayapply.ChPwWayapply;

public class WayApplyServiceImpl extends BaseServiceImpl implements WayApplyService {
	
	private AuditWorkDao auditWorkDao;
	/**审核步骤定义DAO*/
	private ChPwFlownameDao chPwFlownameDao;
	/**公告信息DAO*/
	private ChPwAdvinfoDao chPwAdvinfoDao;
	/**接受对象DAO*/
	private ChPwRcvobjDao chPwRcvobjDao;

	/** 手机号码归属地查询 Service*/
	private NosectService nosectService;

	private static Logger logger = Logger.getLogger(WayApplyServiceImpl.class);
	public WayApplyServiceImpl() {
		this.isNeedLogin = false;
		this.serviceCode = ServiceCode.WAYAPPLY;
		this.serviceName = "网点申请";
		setProcessor(new DefaultQueryParameterProcessor());
	}

	public ServiceResult initiate(LoginMember member, QueryParameter parameter) {
		
		String stepid = ConstantsType.AUDITSTEPID_WAY_ADD1;
		Byte state = ConstantsType.AUDITSTATUS_NO;
		
		ServiceResult result = new ServiceResult();
		boolean isSuccess = false;
		int retCode = WayApllyServiceRetCode.FAIL;
		ChPwWayapply apply = convertParameter(parameter);//提取参数

		//判断手机号码所在地市
		//切换公共库
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		MemberQueryParameter mparameter = new MemberQueryParameter();
		mparameter.setOfficeTel(apply.getPrincipaltel());
		ServiceResult noSectrslt = nosectService.transact(null, mparameter, ServiceType.INITIATE);
		if(!noSectrslt.isSuccess()){
			result.setSuccess(false);
			result.setRetCode(WayApllyServiceRetCode.UNDEFAULT_BRANCH);
			return result;
		}
		String cityId = (String)noSectrslt.getRetObject();
		if (!cityId.equals(apply.getCityid())){
			result.setSuccess(false);
			result.setRetCode(WayApllyServiceRetCode.MOBILENOCITYERROR);
			return result;
		}
		//判断地市是否开放
		String getConfig = Constant.getConstantName(ConstantsType.ISOPEN, cityId);
		if (!ConstantsType.ISOPEN_YES.equals(getConfig)){
			result.setSuccess(false);
			result.setRetCode(MemberServiceRetCode.INVALIDCITY);
			return result;
		}
		
		//切换地市库
		SessionFactoryContextHolder.setSessionFactoryContext(cityId);
		this.getDao().reloadSessionFactory();
		//判断手机是否已经存在
		ServiceResult offTelResl = existsEmployee(apply.getPrincipaltel());
		
		if (offTelResl.isSuccess()){
			//手机号码已经存在
			result.setSuccess(isSuccess);
			result.setRetCode(WayApllyServiceRetCode.MOBLEEXIST);
			return result;
		}
		
		//切换地市库
		logger.info("切换地市库："+apply.getCityid());
		SessionFactoryContextHolder.setSessionFactoryContext(apply.getCityid());
		this.getDao().reloadSessionFactory();
		chPwFlownameDao.reloadSessionFactory();
		auditWorkDao.reloadSessionFactory();
		chPwAdvinfoDao.reloadSessionFactory();
		chPwRcvobjDao.reloadSessionFactory();
		
		//查询默认处理人
		String oprcode = chPwFlownameDao.getOprcodeByStepID(stepid);
		
		//处理人不为空
		if(!CommonUtil.isEmptyOrNull(oprcode)){
			
			Date now = new Date();
			//把Principaltel复制到Officetel
			apply.setOfficetel(apply.getPrincipaltel());
			//1，插入申请表
			apply.setAuditstatus(state);//审核状（AUDITSTATUS）态为0
			apply.setOptime(now);
			save(apply);
			
			//2，插入处理工单表
			ChPwAuditwork auditWork = new ChPwAuditwork();
			auditWork.setWorktype(ConstantsType.AUDITWORKTYPE_WAYADD);
			auditWork.setApplyno(apply.getApplyno());
			auditWork.setStepid(stepid);
			auditWork.setCreatetime(apply.getOptime());
			auditWork.setAuditstatus(state);
			auditWork.setOprcode(oprcode);
			auditWorkDao.save(auditWork);
			
			//3，录入公告信息表及待办任务
			PendingTaskConfigBean bean = ConfigUtil.getPendingTaskConfigByName(PendingTaskName.WAY_REGISTER);
			ChPwAdvinfo info = CommonUtil.createPendingTask(bean, now, auditWork, stepid);
			chPwAdvinfoDao.save(info);
			
			//4，录入接受对象表
			ChPwRcvobj obj = new ChPwRcvobj();
			obj.setAdvinfo(info);
			obj.setObjid(oprcode);
			obj.setState(ConstantsType.UNPUBLISH);
			obj.setStatetime(now);
			chPwRcvobjDao.save(obj);
			//@@ 测试回归用
//			Assert.isTrue(false, -1, "手工测试");
			isSuccess = true;
			retCode = WayApllyServiceRetCode.REGISTER_SUCCESS;
		}
		else{
			retCode = WayApllyServiceRetCode.NOTFOUND_OPRCODE;
		}
		
		result.setSuccess(isSuccess);
		result.setRetCode(retCode);
		return result;
	}
	
	private ChPwWayapply convertParameter(QueryParameter parameter) {
		Assert.notNull(parameter, "parameter 不能为空");

		if (!(WayApplyQueryParameter.class.isInstance(parameter))) {
			throw new IllegalArgumentException("参数类型不对");
		}

		ChPwWayapply apply = new ChPwWayapply();
		try {
			BeanUtils.copyProperties(apply, parameter);
		} catch (Exception e) {
			throw new IllegalStateException("赋值错误");
		}
		return apply;
	}

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
	
	
}
