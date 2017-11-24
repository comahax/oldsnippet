/**
 * auto-generated code
 * Wed Oct 28 16:03:20 CST 2009
 */
package com.gmcc.pboss.control.channel.wayapply;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.gmcc.pboss.business.channel.auditwork.AuditworkDAO;
import com.gmcc.pboss.business.channel.auditwork.AuditworkVO;
import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.gmcc.pboss.business.channel.cooperator.CooperatorVO;
import com.gmcc.pboss.business.channel.flowname.FlownameDAO;
import com.gmcc.pboss.business.channel.flowname.FlownameVO;
import com.gmcc.pboss.business.channel.way.AGWayVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.channel.wayapply.WayapplyDAO;
import com.gmcc.pboss.business.channel.wayapply.WayapplyDBParam;
import com.gmcc.pboss.business.channel.wayapply.WayapplyVO;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceVO;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjVO;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.auditwork.Auditwork;
import com.gmcc.pboss.control.channel.auditwork.AuditworkBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.AGWay;
import com.gmcc.pboss.control.channel.way.AGWayBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayprovince.Wayprovince;
import com.gmcc.pboss.control.channel.wayprovince.WayprovinceBO;
import com.gmcc.pboss.control.communication.advinfo.Advinfo;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoBO;
import com.gmcc.pboss.control.communication.pendingtask.Pendingtask;
import com.gmcc.pboss.control.communication.pendingtask.PendingtaskBO;
import com.gmcc.pboss.control.communication.rcvobj.Rcvobj;
import com.gmcc.pboss.control.communication.rcvobj.RcvobjBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: WayapplyBO
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class WayapplyBO extends AbstractControlBean implements Wayapply {
	public static final String ADD = "WAY_ADD_AUDIT";
	public static final String UPDATE = "WAY_UPDATE_AUDIT";
	public static final String REMOVE = "WAY_REMOVE_AUDIT";

	public WayapplyVO doCreate(WayapplyVO vo) throws Exception {
		try {
			WayapplyDAO dao = (WayapplyDAO) DAOFactory.build(WayapplyDAO.class,
					user);
			// TODO set the pk */
			if (vo.getApplyno() == null) {
				Long sequence = (Long) dao.getSequence("CH_PW_WAYAPPLY_SEQ");
				vo.setApplyno(sequence);
			}
			return (WayapplyVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WayapplyVO vo) throws Exception {
		try {
			WayapplyDAO dao = (WayapplyDAO) DAOFactory.build(WayapplyDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WayapplyDAO dao = (WayapplyDAO) DAOFactory.build(WayapplyDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayapplyVO doUpdate(WayapplyVO vo) throws Exception {
		try {
			WayapplyDAO dao = (WayapplyDAO) DAOFactory.build(WayapplyDAO.class,
					user);
			return (WayapplyVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayapplyVO doFindByPk(Serializable pk) throws Exception {
		WayapplyDAO dao = (WayapplyDAO) DAOFactory.build(WayapplyDAO.class,
				user);
		return (WayapplyVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WayapplyDBParam params) throws Exception {
		WayapplyDAO dao = (WayapplyDAO) DAOFactory.build(WayapplyDAO.class,
				user);
		return dao.query(params);
	}

	/**
	 * 网点审批管理之保存
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public WayapplyVO doSave(WayapplyVO vo) throws Exception {
		try {
			
			AuditworkDAO auditworkDAO = (AuditworkDAO) DAOFactory.build(
					AuditworkDAO.class, user);
			// 取得CH_PW_AUDITWORK工单表的SEQID。
			// 如果没有则要根据applyno去CH_PW_AUDITWORK
			Long seqid = vo.getSeqid();
			Wayapply wayapply = (Wayapply) BOFactory.build(WayapplyBO.class,
					user);

			// WayapplyDAO dao = (WayapplyDAO)
			// DAOFactory.build(WayapplyDAO.class,user);
			if (seqid == null) {
				// 应该没有这种情况

			}
			AuditworkVO auditworkVO = (AuditworkVO) auditworkDAO
					.findByPk(seqid);
			if (auditworkVO != null) {
				auditworkVO.setContent(vo.getContent());
				auditworkVO.setOptime(new java.util.Date());
				auditworkVO.setOprcode(user.getOprcode());
				auditworkDAO.update(auditworkVO);
			} else {
				// throw new JOPException("数据异常:网点申请信息表 根据主键找不到记录");
			}

			return (WayapplyVO) wayapply.doUpdate(vo);
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}

	/**
	 * 网点审批管理之取消
	 * 
	 * @param vo
	 * @param isTask
	 *            是否从待办任务过来的 为TRUE时则需更新接受对象表（CH_PW_RCVOBJ）状态为关闭2
	 * @param rvcobjid
	 *            接受对象表（CH_PW_RCVOBJ）标识
	 * @return
	 * @throws Exception
	 */
	public WayapplyVO doCancel(WayapplyVO vo, boolean isTask, Long rvcobjid)
			throws Exception {
		try {
			Wayapply wayapply = (Wayapply) BOFactory.build(WayapplyBO.class,
					user);
			if (vo.getAuditstatus() != null
					&& vo.getAuditstatus().equals((short) 0)) {
				vo.setAuditstatus(new Short("-1"));
			}
			AuditworkDAO auditworkDAO = (AuditworkDAO) DAOFactory.build(
					AuditworkDAO.class, user);
			Long seqid = vo.getSeqid();
			AuditworkVO auditworkVO = (AuditworkVO) auditworkDAO
					.findByPk(seqid);
			if (auditworkVO != null) {
				auditworkVO.setContent(vo.getContent());
				auditworkVO.setOptime(new java.util.Date());
				auditworkVO.setOprcode(user.getOprcode());
				if (auditworkVO.getAuditstatus() != null
						&& auditworkVO.getAuditstatus().equals((short) 0)) {
					auditworkVO.setAuditstatus(new Short("-1"));
				}
				auditworkDAO.update(auditworkVO);
				//写短信待发送表,改用短信模板
				Smstmpl  smsBO=(Smstmpl)BOFactory.build(SmstmplBO.class,user);
				String sId="CH_PW_WAYAPPLY_REMOVE";
				Map <String,String>keyAndValue=new HashMap<String,String>();
				keyAndValue.put("WAYNAME", vo.getWayname());
				keyAndValue.put("DESCRIPTION", vo.getContent());
				String content=smsBO.doGenSMS(sId, keyAndValue);
				// 写短信待发送表
				Waitreq waitreq = (Waitreq) BOFactory.build(
						WaitreqBO.class, user);
				waitreq.doInsert(Waitreq.SMS_CH, content, vo
								.getOfficetel());
			} else {
				// throw new JOPException("数据异常:网点申请信息表 根据主键找不到记录");
			}
			//	关闭待办信息
			Advinfo advinfo = (Advinfo) BOFactory.build(AdvinfoBO.class,
					user);
			advinfo.doFinishadvinfo(vo.getApplyno(),vo.getSeqid(),true);
			return (WayapplyVO) wayapply.doUpdate(vo);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	/**
	 * 网点审批管理之通过
	 * 
	 * @param vo
	 * @param isTask
	 *            是否从待办任务过来的 为TRUE时则需更新接受对象表（CH_PW_RCVOBJ）状态为关闭2
	 * @param rvcobjid
	 *            接受对象表（CH_PW_RCVOBJ）标识
	 * @return
	 * @throws Exception
	 */
	public WayapplyVO doPass(WayapplyVO vo, boolean isTask, Long rvcobjid)
			throws Exception {
		FlownameVO findVO=null;
		try {
			//检查“所属渠道经理工号”是否在工号表（SA_SO_OPERATOR）存在。如工号不存在提示：该工号为无效工号请核对。
//			if(vo.getWaymagcode() != null && !"".equals(vo.getWaymagcode().trim())){
//				Operator operatorBO = (OperatorBO) BOFactory.build(OperatorBO.class,user);
//				if( null == operatorBO.doFindByPk(vo.getWaymagcode()))
//					throw new Exception("该所属渠道经理工号["+vo.getWaymagcode()+"]为无效工号,请核对");
//			}
			// 检查权限令牌   add by yangdaren
			Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
			String paramvalue = sysparam.doFindByID(new Long("77"), "channel");
			
			Wayapply wayapply = (Wayapply) BOFactory.build(WayapplyBO.class,
					user);
			Way way = (Way)BOFactory.build(WayBO.class, user);
			AuditworkDAO auditworkDAO = (AuditworkDAO) DAOFactory.build(
					AuditworkDAO.class, user);
			Long seqid = vo.getSeqid();
			if (seqid == null) {
				// 应该没有这种情况
			}
			AuditworkVO auditworkVO = (AuditworkVO) auditworkDAO
					.findByPk(seqid);
			if (auditworkVO != null) {
				auditworkVO.setAuditstatus(new Short("1"));
				auditworkVO.setContent(vo.getContent());
				auditworkVO.setOptime(new java.util.Date());
				auditworkVO.setOprcode(user.getOprcode());
			} else {
				throw new JOPException("数据发生错误,根据主键找不到记录!");
			}
			// 根据(CH_PW_WAYAPPLY)的步骤ID（STEPID）查询审核步骤定义表(CH_PW_FLOWNAME)的下一步骤ID（NEXTSTEPID），
			 findVO = doGetstepvo(auditworkVO.getStepid());
			if (findVO.getNextstepid() != null
					&& "-1".equals(findVO.getNextstepid())) {
				if (auditworkVO.getWorktype() != null) {
					try {
						AGWayVO agWayVO = new AGWayVO();
						BeanUtils.copyProperties(agWayVO, vo);
						if (vo.getEndtime() != null) {
							agWayVO.setCmpendtime(vo.getEndtime());
						}
						AGWay agway = (AGWay) BOFactory.build(AGWayBO.class,
								user);
						if (ADD.equals(auditworkVO.getWorktype())) {	
							if ("1".equals(paramvalue) && "DIS".equals(vo.getWaysubtype())) {
								doSaveway(agWayVO);
							} else {
								agway.doCreate(agWayVO, user);
								// COMS系统网点审批申请的话，需要新增或者修改渠道省公司属性表
								if ("1".equals(vo.getComefrom())) {
									doSavewayprovince(vo);
								}
							}
						}
						if (UPDATE.equals(auditworkVO.getWorktype())) {
							WayVO wayVO = way.doFindByPk(agWayVO.getWayid());
							agWayVO.setCreatetime(wayVO.getCreatetime()); // 保留渠道创建时间
							if ("1".equals(paramvalue) && "DIS".equals(vo.getWaysubtype())) {
								doSaveway(agWayVO);
							} else {
								agway.doUpdate(agWayVO, user);
								// COMS系统网点审批申请的话，需要新增或者修改渠道省公司属性表
								if ("1".equals(vo.getComefrom())) {
									doSavewayprovince(vo);
								}
							}
						}
						if (REMOVE.equals(auditworkVO.getWorktype())) {
							WayVO wayVO = new WayVO();
							BeanUtils.copyProperties(wayVO, vo);
							WayVO wayVO1 = way.doFindByPk(agWayVO.getWayid());
							wayVO.setCreatetime(wayVO1.getCreatetime()); // 保留渠道创建时间
							agway.doDelete(wayVO, user);
						}
						auditworkDAO.update(auditworkVO);
					} catch (Exception ex) {
						throw new JOPException(CheckUtil
								.delMsg(ex.getMessage()));
					}
					//写短信待发送表,改用短信模板
					Smstmpl  smsBO=(Smstmpl)BOFactory.build(SmstmplBO.class,user);
					String sId="CH_PW_WAYAPPLY_ADD";
					Map <String,String>keyAndValue=new HashMap<String,String>();
					keyAndValue.put("WAYNAME", vo.getWayname());
					String content=smsBO.doGenSMS(sId, keyAndValue);
					// 写短信待发送表
					Waitreq waitreq = (Waitreq) BOFactory.build(
							WaitreqBO.class, user);
					waitreq.doInsert(Waitreq.SMS_CH, content, vo
									.getOfficetel());
					// 最终审核状态改为1,已通过
					vo.setAuditstatus(new Short("1"));
					//关闭待办
					Advinfo advinfo = (Advinfo) BOFactory.build(AdvinfoBO.class,
							user);
					advinfo.doFinishadvinfo(vo.getApplyno(),vo.getSeqid(),true);
				}
			}
			if (findVO.getNextstepid() != null
					&& !"-1".equals(findVO.getNextstepid())) {
				AuditworkVO newVO = new AuditworkVO();
				FlownameVO nextVO=null;
				// 单类型 worktype: 同前记录的单类型
				newVO.setWorktype(auditworkVO.getWorktype());
				// 申请ID APPLYNO：同当前记录的申请ID
				newVO.setApplyno(auditworkVO.getApplyno());
				newVO.setStepid(findVO.getNextstepid());
				newVO.setCreatetime(new java.util.Date());
				//查询下一条记录的处理人
				 nextVO = doGetstepvo(findVO.getNextstepid());
				if (vo.getOprcode() == null || "".equals(vo.getOprcode())) {
					if (findVO.getOprcode() != null) {
						
						if (nextVO.getOprcode() != null) {
							newVO.setOprcode(nextVO.getOprcode());
						} else {
							throw new JOPException("数据定义有误,查询不到下一处理工号!");
						}
					} else {
						throw new JOPException("");
					}
				} else {
					newVO.setOprcode(vo.getOprcode());
				}
				newVO.setAuditstatus(new Short("0"));
				
				//新增工单
				AuditworkVO resultVO=(AuditworkVO)auditworkDAO.create(newVO);
				//写待办
				Pendingtask daiban=(Pendingtask) BOFactory.build(PendingtaskBO.class,
						user);
				// 修改URL格式为XXX.do?param._pk=xxx&form.seqid=xxx&... , 才能在关闭待办时根据URL的值准确获取待办信息
				String url="/channel/wayapply_edit.do?param._pk="+vo.getApplyno()+"&form.seqid="+resultVO.getSeqid()+"&form.auditstatus_work=0&form.stepid="+newVO.getStepid();
				Date system=new Date();
				Calendar cal=Calendar.getInstance();
				cal.setTime(system);
				cal.add(Calendar.DATE, 7);
				// 通过审批后，新的待办的接收对象(objid)应该为下一处理人
				daiban.doCreate(findVO.getStepname(), url,"4", newVO.getOprcode(), nextVO.getIssms(), user.getOprcode(), system, cal.getTime());
				//关闭待办
				Advinfo advinfo = (Advinfo) BOFactory.build(AdvinfoBO.class,
						user);
				advinfo.doFinishadvinfo(vo.getApplyno(),vo.getSeqid(),true);
			}
			return (WayapplyVO) wayapply.doUpdate(vo);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex.getMessage());
		}
	}

	public void doSavewayprovince(WayapplyVO vo) throws Exception {
		WayprovinceVO wpVO = new WayprovinceVO();
		Wayprovince wayprovince = (Wayprovince) BOFactory.build(WayprovinceBO.class, user);
		wpVO = wayprovince.doFindByPk(vo.getWayid());
		if (wpVO == null) {
			WayprovinceVO newvo = new WayprovinceVO();
			newvo.setWayid(vo.getWayid());
			newvo.setUniquewayid(vo.getUniquewayid());
			newvo.setTown(vo.getTown());
			newvo.setProvtype(vo.getProvtype());
			newvo.setMobilemall(vo.getMobilemall());
			newvo.setFrontarea(vo.getFrontarea());
			newvo.setIspconntype(vo.getIspconntype());
			wayprovince.doCreate(newvo);
		} else {
			wpVO.setUniquewayid(vo.getUniquewayid());
			wpVO.setTown(vo.getTown());
			wpVO.setProvtype(vo.getProvtype());
			wpVO.setMobilemall(vo.getMobilemall());
			wpVO.setFrontarea(vo.getFrontarea());
			wpVO.setIspconntype(vo.getIspconntype());
			wayprovince.doUpdate(wpVO);
		}
	}
	
	public void doSaveway(AGWayVO appvo) throws Exception {
				
		WayVO newVO = new WayVO();
		boolean upperwayfalg = false;// 用于判断本渠道是否等于上级渠道
		// 增加vo
		CooperatorVO cooperatorvo = new CooperatorVO();
		WaycompactVO waycompactvo = new WaycompactVO();
		WayaccountVO wayaccountvo = new WayaccountVO();
		BchcontactVO bchcontactvo = new BchcontactVO();
		
		BeanUtils.copyProperties(cooperatorvo, appvo);
		BeanUtils.copyProperties(waycompactvo, appvo);
		BeanUtils.copyProperties(wayaccountvo, appvo);
		BeanUtils.copyProperties(bchcontactvo, appvo);
		
		wayaccountvo.setAccid(new Integer(1));
		// 合作商资料信息设定
		cooperatorvo.setCooperauid(appvo.getWayid());
		cooperatorvo.setCooperaname(appvo.getWayname());
		cooperatorvo.setCpabbrname(appvo.getWayname());
		cooperatorvo.setState(appvo.getWaystate());
		cooperatorvo.setSmsmobileno(appvo.getBuzphoneno());		
		cooperatorvo.setServman(appvo.getPrincipal());
		cooperatorvo.setCooperadel(appvo.getPrincipal());
		cooperatorvo.setConntel(appvo.getPrincipaltel());
		cooperatorvo.setUsremail(appvo.getPrincipalemail());
		cooperatorvo.setConnpers(appvo.getLinkman());
		cooperatorvo.setBusconntel(appvo.getLinkmantel());
		cooperatorvo.setStarttime(appvo.getBegintime());
		cooperatorvo.setLicenceid(appvo.getLicenceno());
		cooperatorvo.setCustmanager(appvo.getWaymagcode());
		cooperatorvo.setDistrictid(appvo.getCityid());
		
		wayaccountvo.setAccttype(new Short("0"));
		wayaccountvo.setChargetype(new Short("0"));
		BeanUtils.copyProperties(newVO, appvo);
		//如果是星级模式,把统一模式的时间设置为空
		if ("DIS".equals(newVO.getWaysubtype())) {
			if(newVO.getCalcumode()==0){
				newVO.setUniformtime("");
			}
		}
		// 设置停用时间
		if (appvo.getCmpendtime() != null) {
			waycompactvo.setEndtime(appvo.getCmpendtime());
		}
		AGWay delegate = (AGWay)BOFactory.build(AGWayBO.class, user);
		
		newVO.setWaytype("AG");
		if (newVO.getWaysubtype() == null
				|| newVO.getWaysubtype().trim().equals("")) {
			throw new Exception("渠道子类别没有值！");
		}

		WayVO oldVO = delegate.doFindByPk(appvo.getWayid(), user);		
		if (oldVO != null) {
			if (!oldVO.getUpperwayid().equalsIgnoreCase(newVO.getUpperwayid())) {
				upperwayfalg = true;
			}
			delegate.doAgupdate(oldVO, newVO, cooperatorvo, waycompactvo,
					wayaccountvo, bchcontactvo, upperwayfalg, user);
		} else {
			if (oldVO == null) {
				// 新增
				delegate.doAgcreate(newVO, cooperatorvo, waycompactvo,
						wayaccountvo, bchcontactvo, user);
			} else {
				throw new Exception("已经存在相同渠道编码的记录,请更换渠道编码");
			}
		}			
	}
	
	public FlownameVO doGetstepvo(String stepid) throws Exception {
		try {
			FlownameDAO dao = (FlownameDAO) DAOFactory.build(FlownameDAO.class,
					user);
			FlownameVO vo = (FlownameVO) dao.findByPk(stepid);
			if (vo == null) {
				throw new JOPException("根据stepid:" + stepid + "在数据库中查找不到所定义的记录");
			} else {
				return vo;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}
	
	public void doWayapply(String oprcode, WayapplyVO vo, DBAccessUser user, String uptype) throws Exception {
		try {
			// 插入一条数据到网点申请信息表
			Date date = new Date();
			Wayapply control = (Wayapply) BOFactory .build(WayapplyBO.class,user);
			vo.setAuditstatus(Short.valueOf("0")); // 审核状态
			vo.setOptime(date); // 申请时间
			vo.setComefrom("1"); // 数据来源
			WayapplyVO newvo = control.doCreate(vo);
			
			// 插入一条数据到处理工单表
			Auditwork wcontrol = (Auditwork)BOFactory.build(AuditworkBO.class,user);
			AuditworkVO workvo = new AuditworkVO();
			workvo.setApplyno(newvo.getApplyno());
			// 网点申请退出的时候
			if ("remove".equals(uptype)) {
				workvo.setWorktype("WAY_REMOVE_AUDIT");
				workvo.setStepid("WAY_REMOVE_AUDIT1");
				// 网点申请新增的时候
			} else if ("add".equals(uptype)) {
				workvo.setWorktype("WAY_ADD_AUDIT");
				workvo.setStepid("WAY_ADD_AUDIT1");
				// 网点申请修改的时候
			} else {
				workvo.setWorktype("WAY_UPDATE_AUDIT");
				workvo.setStepid("WAY_UPDATE_AUDIT1");
			}
			workvo.setAuditstatus(Short.valueOf("0"));
			workvo.setOprcode(oprcode);
			workvo.setCreatetime(date);
			AuditworkVO newkvo = wcontrol.doCreate(workvo);
			
			// 插入一条数据到公告信息表（CH_PW_ADVINFO）
			Advinfo acontrol = (Advinfo)BOFactory.build(AdvinfoBO.class,user);
			String url = "/channel/wayapply_edit.do?param._pk="+newvo.getApplyno()+"&form.seqid="+newkvo.getSeqid();
			AdvinfoVO infovo = new AdvinfoVO();
			if ("remove".equals(uptype)) {
				if ("DIS".equals(vo.getWaysubtype())) {
					infovo.setTitle("连锁合作商退出申请，请审批。");
				} else {
					infovo.setTitle("网点退出申请，请审批。");
				}
			} else if ("add".equals(uptype)) {
				if ("DIS".equals(vo.getWaysubtype())) {
					infovo.setTitle("新增连锁合作商注册，请审批。");
				} else {
					infovo.setTitle("新增网点注册，请审批。");
				}
			} else {
				if ("DIS".equals(vo.getWaysubtype())) {
					infovo.setTitle("连锁合作商资料修改申请，请审批。");
				} else {
					infovo.setTitle("网点资料修改申请，请审批。");
				}
			}
			infovo.setUrl(url);
			infovo.setType(Short.valueOf("5"));
			infovo.setReleasetime(date);
			infovo.setPlantime(getDate(date,7));
			infovo.setDesttype(Short.valueOf("7"));
			infovo.setSmsnotify(Short.valueOf("1"));
			infovo.setNdapproval(Short.valueOf("0"));
			infovo.setState(Short.valueOf("3"));
			AdvinfoVO newifvo = acontrol.doCreate(infovo);
			
			// 插入一条数据到接受对象表（CH_PW_RCVOBJ）
			Rcvobj rcontrol = (Rcvobj)BOFactory.build(RcvobjBO.class,user);
			RcvobjVO rvo = new RcvobjVO();
			rvo.setAdvinfoid(newifvo.getAdvinfoid());
			rvo.setObjid(oprcode);
			rvo.setState(Short.valueOf("1"));
			rvo.setStatetime(date);
			rcontrol.doCreate(rvo);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	/**
	 * 取取当前时间前、后N天的日期
	 * @param now		当前时间
	 * @param addDay	前后天数，前天为负数
	 */
	public static Date getDate(Date now, int addDay)
	{   
		if(now == null){
			now = new Date();
		}
        Calendar cd = Calendar.getInstance();   
        cd.setTime(now);   
        cd.add(Calendar.DATE, addDay);   
        Date date = cd.getTime();
		return date;
    }
}
