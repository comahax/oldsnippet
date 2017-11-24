/**
 * auto-generated code
 * Thu Jun 09 15:03:21 CST 2011
 */
package com.gmcc.pboss.business.chpwwaysyn22crm.waysyn2log;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: Waysyn2logBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class Waysyn2logBO extends AbstractControlBean implements
		Waysyn2log {

	public Waysyn2logVO doCreate(Waysyn2logVO vo) throws Exception {
		try {
			Waysyn2logDAO dao = (Waysyn2logDAO) DAOFactory.build(Waysyn2logDAO.class, user);
			// TODO set the pk */
			return (Waysyn2logVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(Waysyn2logVO vo) throws Exception {
		try {
			Waysyn2logDAO dao = (Waysyn2logDAO) DAOFactory.build(Waysyn2logDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			Waysyn2logDAO dao = (Waysyn2logDAO) DAOFactory.build(Waysyn2logDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public Waysyn2logVO doUpdate(Waysyn2logVO vo) throws Exception {
		try {
			Waysyn2logDAO dao = (Waysyn2logDAO) DAOFactory.build(Waysyn2logDAO.class,user);
			return (Waysyn2logVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public Waysyn2logVO doFindByPk(Serializable pk) throws Exception {
		Waysyn2logDAO dao = (Waysyn2logDAO) DAOFactory.build(Waysyn2logDAO.class,user);
		return (Waysyn2logVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(Waysyn2logDBParam params)
			throws Exception {
		Waysyn2logDAO dao = (Waysyn2logDAO) DAOFactory.build(Waysyn2logDAO.class,user);
		return dao.query(params);
	}
}
