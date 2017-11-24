/**
 * auto-generated code
 * Thu Feb 17 11:53:25 CST 2011
 */
package com.gmcc.pboss.control.channel.employeeextend;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.employeeextend.EmployeeextendDBParam;
import com.gmcc.pboss.business.channel.employeeextend.EmployeeextendDAO;
import com.gmcc.pboss.business.channel.employeeextend.EmployeeextendVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: EmployeeextendBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmployeeextendBO extends AbstractControlBean implements
		Employeeextend {

	public EmployeeextendVO doCreate(EmployeeextendVO vo) throws Exception {
		try {
			EmployeeextendDAO dao = (EmployeeextendDAO) DAOFactory.build(EmployeeextendDAO.class, user);
			// TODO set the pk */
			return (EmployeeextendVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmployeeextendVO vo) throws Exception {
		try {
			EmployeeextendDAO dao = (EmployeeextendDAO) DAOFactory.build(EmployeeextendDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmployeeextendDAO dao = (EmployeeextendDAO) DAOFactory.build(EmployeeextendDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmployeeextendVO doUpdate(EmployeeextendVO vo) throws Exception {
		try {
			EmployeeextendDAO dao = (EmployeeextendDAO) DAOFactory.build(EmployeeextendDAO.class,user);
			return (EmployeeextendVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmployeeextendVO doFindByPk(Serializable pk) throws Exception {
		EmployeeextendDAO dao = (EmployeeextendDAO) DAOFactory.build(EmployeeextendDAO.class,user);
		return (EmployeeextendVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmployeeextendDBParam params)
			throws Exception {
		EmployeeextendDAO dao = (EmployeeextendDAO) DAOFactory.build(EmployeeextendDAO.class,user);
		return dao.query(params);
	}
}
