/**
 * auto-generated code
 * Thu Feb 17 11:55:20 CST 2011
 */
package com.gmcc.pboss.control.channel.employeeextendlog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.employeeextendlog.EmployeeextendlogDBParam;
import com.gmcc.pboss.business.channel.employeeextendlog.EmployeeextendlogDAO;
import com.gmcc.pboss.business.channel.employeeextendlog.EmployeeextendlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: EmployeeextendlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmployeeextendlogBO extends AbstractControlBean implements
		Employeeextendlog {

	public EmployeeextendlogVO doCreate(EmployeeextendlogVO vo) throws Exception {
		try {
			EmployeeextendlogDAO dao = (EmployeeextendlogDAO) DAOFactory.build(EmployeeextendlogDAO.class, user);
			// TODO set the pk */
			return (EmployeeextendlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmployeeextendlogVO vo) throws Exception {
		try {
			EmployeeextendlogDAO dao = (EmployeeextendlogDAO) DAOFactory.build(EmployeeextendlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmployeeextendlogDAO dao = (EmployeeextendlogDAO) DAOFactory.build(EmployeeextendlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmployeeextendlogVO doUpdate(EmployeeextendlogVO vo) throws Exception {
		try {
			EmployeeextendlogDAO dao = (EmployeeextendlogDAO) DAOFactory.build(EmployeeextendlogDAO.class,user);
			return (EmployeeextendlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmployeeextendlogVO doFindByPk(Serializable pk) throws Exception {
		EmployeeextendlogDAO dao = (EmployeeextendlogDAO) DAOFactory.build(EmployeeextendlogDAO.class,user);
		return (EmployeeextendlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmployeeextendlogDBParam params)
			throws Exception {
		EmployeeextendlogDAO dao = (EmployeeextendlogDAO) DAOFactory.build(EmployeeextendlogDAO.class,user);
		return dao.query(params);
	}
}
