/**
 * auto-generated code
 * Tue Oct 20 15:53:36 CST 2009
 */
package com.gmcc.pboss.control.channel.employeeapply;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.channel.auditwork.AuditworkDAO;
import com.gmcc.pboss.business.channel.auditwork.AuditworkVO;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.employeeapply.EmployeeapplyDAO;
import com.gmcc.pboss.business.channel.employeeapply.EmployeeapplyDBParam;
import com.gmcc.pboss.business.channel.employeeapply.EmployeeapplyVO;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.communication.advinfo.Advinfo;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: EmployeeapplyBO
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
public class EmployeeapplyBO extends AbstractControlBean implements
		Employeeapply {
	private static Log log = LogFactory.getLog(EmployeeapplyBO.class);
	public static final String ADD = "EMPLOYEE_ADD_AUDIT";
	public static final String UPDATE = "EMPLOYEE_UPDATE_AUDIT";
	public static final String REMOVE = "EMPLOYEE_REMOVE_AUDIT";

	public EmployeeapplyVO doCreate(EmployeeapplyVO vo) throws Exception {
		try {
			EmployeeapplyDAO dao = (EmployeeapplyDAO) DAOFactory.build(
					EmployeeapplyDAO.class, user);
			// TODO set the pk */
			return (EmployeeapplyVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmployeeapplyVO vo) throws Exception {
		try {
			EmployeeapplyDAO dao = (EmployeeapplyDAO) DAOFactory.build(
					EmployeeapplyDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmployeeapplyDAO dao = (EmployeeapplyDAO) DAOFactory.build(
					EmployeeapplyDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	/**
	 * 店员审批管理之保存
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public EmployeeapplyVO doSave(EmployeeapplyVO vo) throws Exception {
		try {
			AuditworkDAO auditworkDAO = (AuditworkDAO) DAOFactory.build(
					AuditworkDAO.class, user);
			Employeeapply employeeapply = (Employeeapply)BOFactory.build(EmployeeapplyBO.class, user);
			// 取得CH_PW_AUDITWORK工单表的SEQID。
			// 如果没有则要根据applyno去CH_PW_AUDITWORK
			Long seqid = vo.getSeqid();
			if (seqid == null) {
				// 应该没有这种情况

			}
			checkOpercode(vo, user);
			AuditworkVO auditworkVO = (AuditworkVO) auditworkDAO
					.findByPk(seqid);
			if (auditworkVO != null) {
				auditworkVO.setContent(vo.getContent());
				auditworkVO.setOptime(new java.util.Date());
				auditworkVO.setOprcode(user.getOprcode());
				auditworkDAO.update(auditworkVO);
			} else {
				// 保存失败
			}
			
			return (EmployeeapplyVO) employeeapply.doUpdate(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	/**
	 * 店员审批管理之取消
	 * 
	 * @param vo
	 * @param isTask 是否从待办任务过来的 为TRUE时则需更新接受对象表（CH_PW_RCVOBJ）状态为关闭2
	 * @param rvcobjid 接受对象表（CH_PW_RCVOBJ）标识
	 * @return
	 * @throws Exception
	 */
	public EmployeeapplyVO doCancel(EmployeeapplyVO vo,boolean isTask,Long rvcobjid) throws Exception {
		try {
			Employeeapply employeeapply = (Employeeapply)BOFactory.build(EmployeeapplyBO.class, user);
			Long seqid = vo.getSeqid();
			AuditworkDAO auditworkDAO = (AuditworkDAO) DAOFactory.build(
					AuditworkDAO.class, user);
			AuditworkVO auditworkVO = (AuditworkVO) auditworkDAO
			.findByPk(seqid);
			if (vo.getAuditstatus_work().shortValue()==(short)0) {
				auditworkVO.setAuditstatus(new Short("-1"));
			}
			if (auditworkVO != null) {
				auditworkVO.setContent(vo.getContent());
				auditworkVO.setOptime(new java.util.Date());
				auditworkVO.setOprcode(user.getOprcode());
				auditworkDAO.update(auditworkVO);
			} else {
				// throw new JOPException("数据异常:网点申请信息表 根据主键找不到记录");
			}
			//审批退回，关闭待办
			Advinfo advinfo = (Advinfo) BOFactory.build(AdvinfoBO.class,
					user);
			advinfo.doFinishadvinfo(vo.getApplyno(),vo.getSeqid(),false);
		
			//用短信模板取得所发短信内容
			Smstmpl  smsBO=(Smstmpl)BOFactory.build(SmstmplBO.class,user);
			String sId="CH_PW_EMPLOYEEAPPLY_REMOVE";
			Map <String,String>keyAndValue=new HashMap<String,String>();
			keyAndValue.put("EMPLOYEENAME", vo.getEmployeename());
			keyAndValue.put("DESCRIPTION", vo.getContent());
			String content=smsBO.doGenSMS(sId, keyAndValue);
			// 写短信待发送表
			Waitreq waitreq = (Waitreq) BOFactory.build(
					WaitreqBO.class, user);
			waitreq.doInsert(Waitreq.SMS_CH, content, vo
							.getOfficetel());
			return (EmployeeapplyVO) employeeapply.doUpdate(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	/**
	 * 店员审批管理之通过
	 * 
	 * @param vo
	 * @param isTask 是否从待办任务过来的 为TRUE时则需更新接受对象表（CH_PW_RCVOBJ）状态为关闭2
	 * @param rvcobjid 接受对象表（CH_PW_RCVOBJ）标识
	 * @return
	 * @throws Exception
	 */
	public EmployeeapplyVO doPass(EmployeeapplyVO vo,boolean isTask,Long rvcobjid) throws Exception {
		try {
			Employeeapply employeeapply = (Employeeapply)BOFactory.build(EmployeeapplyBO.class, user);
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
				auditworkDAO.update(auditworkVO);
			} else {
				// 保存失败
			}
			if (auditworkVO != null && auditworkVO.getWorktype() != null) {
				try {
					Employee employee = (Employee) BOFactory.build(
							EmployeeBO.class, user);
					EmployeeVO empVO = new EmployeeVO();
					BeanUtils.copyProperties(empVO, vo);
					if (ADD.equals(auditworkVO.getWorktype())) {
						checkOpercode(vo, user);
						empVO = employee.doCreateSociety(empVO,user);
						vo.setEmployeeid(empVO.getEmployeeid());
					}
					if (UPDATE.equals(auditworkVO.getWorktype())) {
						if(empVO.getEmployeeid()==null)
						{
							throw new JOPException("数据错误,该条数据根据主键查找不到要修改的记录!");
						}
						checkOpercode(vo, user);
						employee.doUpdate(empVO,user);
					}
					if (REMOVE.equals(auditworkVO.getWorktype())) {
						if(empVO.getEmployeeid()==null)
						{
							throw new JOPException("数据错误,该条数据的主键为空!");
						}
						String []employeeid={empVO.getEmployeeid()};
						employee.doUpdateEmpstatus(employeeid,new Short("1"));
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					if(log.isInfoEnabled())
					{
						e.printStackTrace();
					}
					throw new JOPException(CheckUtil.delMsg(e.getMessage()));
				}
			}
			//写短信待发送表,改用短信模板
			Smstmpl  smsBO=(Smstmpl)BOFactory.build(SmstmplBO.class,user);
			String sId="CH_PW_EMPLOYEEAPPLY_ADD";
			Map <String,String>keyAndValue=new HashMap<String,String>();
			keyAndValue.put("EMPLOYEENAME", vo.getEmployeename());
			String content=smsBO.doGenSMS(sId, keyAndValue);
			// 写短信待发送表
			Waitreq waitreq = (Waitreq) BOFactory.build(
					WaitreqBO.class, user);
			waitreq.doInsert(Waitreq.SMS_CH, content, vo
							.getOfficetel());
			//审批完成.
			vo.setAuditstatus(new Short("1"));
			//修改待办信息
			Advinfo advinfo = (Advinfo) BOFactory.build(AdvinfoBO.class,
					user);
			advinfo.doFinishadvinfo(vo.getApplyno(),vo.getSeqid(),false);
			return (EmployeeapplyVO) employeeapply.doUpdate(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmployeeapplyVO doUpdate(EmployeeapplyVO vo) throws Exception {
		try {
			EmployeeapplyDAO dao = (EmployeeapplyDAO) DAOFactory.build(
					EmployeeapplyDAO.class, user);
			return (EmployeeapplyVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmployeeapplyVO doFindByPk(Serializable pk) throws Exception {
		EmployeeapplyDAO dao = (EmployeeapplyDAO) DAOFactory.build(
				EmployeeapplyDAO.class, user);
		return (EmployeeapplyVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmployeeapplyDBParam params) throws Exception {
		EmployeeapplyDAO dao = (EmployeeapplyDAO) DAOFactory.build(
				EmployeeapplyDAO.class, user);
		return dao.query(params);
	}
	private void checkOpercode(EmployeeapplyVO vo, DBAccessUser user) throws Exception {
		if (vo.getOprcode2() == null || "".equals(vo.getOprcode2().trim())) {
			return;
		} else {
			Operator control = (OperatorBO) BOFactory
					.build(OperatorBO.class,user);
			if (control.doFindByPk(vo.getOprcode2()) == null) {
				throw new Exception("系统不存在录入工号");
			}
		}
	}
}
