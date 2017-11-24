/**
 * auto-generated code Wed Oct 18 16:14:47 CST 2006
 */
package com.sunrise.boss.business.cms.employeelog.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.employeelog.persistent.EmployeelogDAO;
import com.sunrise.boss.business.cms.employeelog.persistent.EmployeelogListVO;
import com.sunrise.boss.business.cms.employeelog.persistent.EmployeelogVO;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleDAO;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleListVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: EmployeelogControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author He Kun
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/employeelog/control/EmployeelogControlBean"
 *           name="EmployeelogControl" view-type="local" type="Stateless"
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class EmployeelogControlBean extends AbstractControlBean implements
		EmployeelogControl {
	private static final long serialVersionUID = 9060375020619410951L;

	public EmployeelogVO doCreate(EmployeelogVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			EmployeelogDAO dao = (EmployeelogDAO) DAOFactory.build(
					EmployeelogDAO.class, user);
			return (EmployeelogVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(EmployeelogVO vo, User user) throws Exception {
		try {
			EmployeelogDAO dao = (EmployeelogDAO) DAOFactory.build(
					EmployeelogDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public EmployeelogVO doUpdate(EmployeelogVO vo, User user) throws Exception {
		try {
			EmployeelogDAO dao = (EmployeelogDAO) DAOFactory.build(
					EmployeelogDAO.class, user);
			return (EmployeelogVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public EmployeelogVO doFindByPk(Serializable pk, User user)
			throws Exception {
		EmployeelogDAO dao = (EmployeelogDAO) DAOFactory.build(
				EmployeelogDAO.class, user);
		return (EmployeelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmployeelogListVO params, User user)
			throws Exception {
		EmployeelogDAO dao = (EmployeelogDAO) DAOFactory.build(
				EmployeelogDAO.class, user);
		return dao.query(params);
	}

	public DataPackage doSocietyEmployeeLogQuery(EmployeelogListVO params,
			User user) throws Exception {
		EmployeelogDAO dao = (EmployeelogDAO) DAOFactory.build(
				EmployeelogDAO.class, user);
		return dao.societyEmployeeLogQuery(params);
	}

	// 移动渠道服务厅人员信息查询
	public DataPackage doServerhallEmployeeLogQuery(EmployeelogListVO params,
			User user) throws Exception {
		EmployeelogDAO dao = (EmployeelogDAO) DAOFactory.build(EmployeelogDAO.class,
				user);
		OperroleDAO operroledao = (OperroleDAO) DAOFactory.build(
				OperroleDAO.class, user);
		OperroleListVO operrolelistvo = new OperroleListVO();
		operrolelistvo.set_se_operid(user.getOpercode());
		operrolelistvo.set_se_roleid("bchworker");
		int i = operroledao.query(operrolelistvo).getDatas().size();
		return dao.serverhallEmployeeLogQuery(params, user, i);
	}
	// 移动渠道渠道经理信息查询
	public DataPackage doDitchmgrEmployeeLogQuery(EmployeelogListVO params, User user)
			throws Exception {
		EmployeelogDAO dao = (EmployeelogDAO) DAOFactory.build(EmployeelogDAO.class,
				user);
		OperroleDAO operroledao = (OperroleDAO) DAOFactory.build(
				OperroleDAO.class, user);
		OperroleListVO operrolelistvo = new OperroleListVO();
		operrolelistvo.set_se_operid(user.getOpercode());
		operrolelistvo.set_se_roleid("waymanager");
		int i = operroledao.query(operrolelistvo).getDatas().size();
		return dao.ditchmgrEmployeeLogQuery(params, user, i);
	}
}
