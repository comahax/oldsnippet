/**
 * auto-generated code
 * Sat Jun 11 09:41:33 CST 2011
 */
package com.gmcc.pboss.business.chpwempsyn2crm.empsynlog;

import java.io.Serializable;

import com.gmcc.pboss.business.chpwempsyn2crm.empsynlog.EmpsynlogDBParam;
import com.gmcc.pboss.business.chpwempsyn2crm.empsynlog.EmpsynlogDAO;
import com.gmcc.pboss.business.chpwempsyn2crm.empsynlog.EmpsynlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: EmpsynlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class EmpsynlogBO extends AbstractControlBean implements
		Empsynlog {

	public EmpsynlogVO doCreate(EmpsynlogVO vo) throws Exception {
		try {
			EmpsynlogDAO dao = (EmpsynlogDAO) DAOFactory.build(EmpsynlogDAO.class, user);
			// TODO set the pk */
			return (EmpsynlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmpsynlogVO vo) throws Exception {
		try {
			EmpsynlogDAO dao = (EmpsynlogDAO) DAOFactory.build(EmpsynlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmpsynlogDAO dao = (EmpsynlogDAO) DAOFactory.build(EmpsynlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmpsynlogVO doUpdate(EmpsynlogVO vo) throws Exception {
		try {
			EmpsynlogDAO dao = (EmpsynlogDAO) DAOFactory.build(EmpsynlogDAO.class,user);
			return (EmpsynlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmpsynlogVO doFindByPk(Serializable pk) throws Exception {
		EmpsynlogDAO dao = (EmpsynlogDAO) DAOFactory.build(EmpsynlogDAO.class,user);
		return (EmpsynlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmpsynlogDBParam params)
			throws Exception {
		EmpsynlogDAO dao = (EmpsynlogDAO) DAOFactory.build(EmpsynlogDAO.class,user);
		return dao.query(params);
	}
}
