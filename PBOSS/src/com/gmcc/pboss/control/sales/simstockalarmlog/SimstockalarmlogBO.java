/**
 * auto-generated code
 * Sat Mar 31 19:25:50 CST 2012
 */
package com.gmcc.pboss.control.sales.simstockalarmlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.simstockalarmlog.SimstockalarmlogDBParam;
import com.gmcc.pboss.business.sales.simstockalarmlog.SimstockalarmlogDAO;
import com.gmcc.pboss.business.sales.simstockalarmlog.SimstockalarmlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: SimstockalarmlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class SimstockalarmlogBO extends AbstractControlBean implements
		Simstockalarmlog {

	public SimstockalarmlogVO doCreate(SimstockalarmlogVO vo) throws Exception {
		try {
			SimstockalarmlogDAO dao = (SimstockalarmlogDAO) DAOFactory.build(SimstockalarmlogDAO.class, user);
			// TODO set the pk */
			return (SimstockalarmlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SimstockalarmlogVO vo) throws Exception {
		try {
			SimstockalarmlogDAO dao = (SimstockalarmlogDAO) DAOFactory.build(SimstockalarmlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SimstockalarmlogDAO dao = (SimstockalarmlogDAO) DAOFactory.build(SimstockalarmlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SimstockalarmlogVO doUpdate(SimstockalarmlogVO vo) throws Exception {
		try {
			SimstockalarmlogDAO dao = (SimstockalarmlogDAO) DAOFactory.build(SimstockalarmlogDAO.class,user);
			return (SimstockalarmlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SimstockalarmlogVO doFindByPk(Serializable pk) throws Exception {
		SimstockalarmlogDAO dao = (SimstockalarmlogDAO) DAOFactory.build(SimstockalarmlogDAO.class,user);
		return (SimstockalarmlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SimstockalarmlogDBParam params)
			throws Exception {
		SimstockalarmlogDAO dao = (SimstockalarmlogDAO) DAOFactory.build(SimstockalarmlogDAO.class,user);
		return dao.query(params);
	}
}
