/**
 * auto-generated code
 * Wed Oct 07 16:55:22 CST 2009
 */
package com.gmcc.pboss.control.channel.employeelog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.operrole.OperroleDAO;
import com.gmcc.pboss.business.base.operrole.OperroleDBParam;
import com.gmcc.pboss.business.channel.employeelog.EmployeelogDAO;
import com.gmcc.pboss.business.channel.employeelog.EmployeelogDBParam;
import com.gmcc.pboss.business.channel.employeelog.EmployeelogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>
 * Title: EmployeelogBO
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
 * @author wefrogll
 * @version 1.0
 */
public class EmployeelogBO extends AbstractControlBean implements Employeelog {

	public EmployeelogVO doCreate(EmployeelogVO vo) throws Exception {
		try {
			EmployeelogDAO dao = (EmployeelogDAO) DAOFactory.build(
					EmployeelogDAO.class, user);
			// TODO set the pk */
			return (EmployeelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmployeelogVO vo) throws Exception {
		try {
			EmployeelogDAO dao = (EmployeelogDAO) DAOFactory.build(
					EmployeelogDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmployeelogDAO dao = (EmployeelogDAO) DAOFactory.build(
					EmployeelogDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmployeelogVO doUpdate(EmployeelogVO vo) throws Exception {
		try {
			EmployeelogDAO dao = (EmployeelogDAO) DAOFactory.build(
					EmployeelogDAO.class, user);
			return (EmployeelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmployeelogVO doFindByPk(Serializable pk) throws Exception {
		EmployeelogDAO dao = (EmployeelogDAO) DAOFactory.build(
				EmployeelogDAO.class, user);
		return (EmployeelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmployeelogDBParam params) throws Exception {
		EmployeelogDAO dao = (EmployeelogDAO) DAOFactory.build(
				EmployeelogDAO.class, user);
		User user1 = (User) user;
		return dao.societyEmployeeLogQuery(params, user1);
	}

	// 移动渠道渠道经理信息查询
	public DataPackage doDitchmgrEmployeeLogQuery(EmployeelogDBParam params)
			throws Exception {
		EmployeelogDAO dao = (EmployeelogDAO) DAOFactory.build(
				EmployeelogDAO.class, user);
		OperroleDAO operroledao = (OperroleDAO) DAOFactory.build(
				OperroleDAO.class, user);
		User user1 = (User) user;
		OperroleDBParam operrolelistvo = new OperroleDBParam();
		operrolelistvo.set_se_operid(user.getOprcode());
		operrolelistvo.set_se_roleid("waymanager");
		int i = operroledao.query(operrolelistvo).getDatas().size();
		return dao.ditchmgrEmployeeLogQuery(params, user1, i);
	}
}
