/**
 * auto-generated code
 * Mon Nov 23 16:50:43 CST 2009
 */
package com.gmcc.pboss.control.channel.employeeapplylog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.employeeapplylog.EmployeeapplylogDBParam;
import com.gmcc.pboss.business.channel.employeeapplylog.EmployeeapplylogDAO;
import com.gmcc.pboss.business.channel.employeeapplylog.EmployeeapplylogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: EmployeeapplylogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class EmployeeapplylogBO extends AbstractControlBean implements
		Employeeapplylog {

	public EmployeeapplylogVO doCreate(EmployeeapplylogVO vo) throws Exception {
		try {
			EmployeeapplylogDAO dao = (EmployeeapplylogDAO) DAOFactory.build(EmployeeapplylogDAO.class, user);
			// TODO set the pk */
			return (EmployeeapplylogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmployeeapplylogVO vo) throws Exception {
		try {
			EmployeeapplylogDAO dao = (EmployeeapplylogDAO) DAOFactory.build(EmployeeapplylogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmployeeapplylogDAO dao = (EmployeeapplylogDAO) DAOFactory.build(EmployeeapplylogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmployeeapplylogVO doUpdate(EmployeeapplylogVO vo) throws Exception {
		try {
			EmployeeapplylogDAO dao = (EmployeeapplylogDAO) DAOFactory.build(EmployeeapplylogDAO.class,user);
			return (EmployeeapplylogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmployeeapplylogVO doFindByPk(Serializable pk) throws Exception {
		EmployeeapplylogDAO dao = (EmployeeapplylogDAO) DAOFactory.build(EmployeeapplylogDAO.class,user);
		return (EmployeeapplylogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmployeeapplylogDBParam params)
			throws Exception {
		EmployeeapplylogDAO dao = (EmployeeapplylogDAO) DAOFactory.build(EmployeeapplylogDAO.class,user);
		return dao.query(params);
	}
}
