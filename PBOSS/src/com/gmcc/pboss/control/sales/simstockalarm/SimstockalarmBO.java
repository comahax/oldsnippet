/**
 * auto-generated code
 * Sat Mar 31 10:28:57 CST 2012
 */
package com.gmcc.pboss.control.sales.simstockalarm;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.simstockalarm.SimstockalarmDBParam;
import com.gmcc.pboss.business.sales.simstockalarm.SimstockalarmDAO;
import com.gmcc.pboss.business.sales.simstockalarm.SimstockalarmVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: SimstockalarmBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class SimstockalarmBO extends AbstractControlBean implements
		Simstockalarm {

	public SimstockalarmVO doCreate(SimstockalarmVO vo) throws Exception {
		try {
			SimstockalarmDAO dao = (SimstockalarmDAO) DAOFactory.build(SimstockalarmDAO.class, user);
			// TODO set the pk */
			return (SimstockalarmVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SimstockalarmVO vo) throws Exception {
		try {
			SimstockalarmDAO dao = (SimstockalarmDAO) DAOFactory.build(SimstockalarmDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SimstockalarmDAO dao = (SimstockalarmDAO) DAOFactory.build(SimstockalarmDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SimstockalarmVO doUpdate(SimstockalarmVO vo) throws Exception {
		try {
			SimstockalarmDAO dao = (SimstockalarmDAO) DAOFactory.build(SimstockalarmDAO.class,user);
			return (SimstockalarmVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SimstockalarmVO doFindByPk(Serializable pk) throws Exception {
		SimstockalarmDAO dao = (SimstockalarmDAO) DAOFactory.build(SimstockalarmDAO.class,user);
		return (SimstockalarmVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SimstockalarmDBParam params)
			throws Exception {
		SimstockalarmDAO dao = (SimstockalarmDAO) DAOFactory.build(SimstockalarmDAO.class,user);
		return dao.query(params);
	}
	
}
