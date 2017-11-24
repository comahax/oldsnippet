/**
 * auto-generated code
 * Thu Apr 05 09:18:42 CST 2012
 */
package com.gmcc.pboss.control.sales.simrealtimeamt;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.simrealtimeamt.SimrealtimeamtDBParam;
import com.gmcc.pboss.business.sales.simrealtimeamt.SimrealtimeamtDAO;
import com.gmcc.pboss.business.sales.simrealtimeamt.SimrealtimeamtVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: SimrealtimeamtBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class SimrealtimeamtBO extends AbstractControlBean implements
		Simrealtimeamt {

	public SimrealtimeamtVO doCreate(SimrealtimeamtVO vo) throws Exception {
		try {
			SimrealtimeamtDAO dao = (SimrealtimeamtDAO) DAOFactory.build(SimrealtimeamtDAO.class, user);
			// TODO set the pk */
			return (SimrealtimeamtVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SimrealtimeamtVO vo) throws Exception {
		try {
			SimrealtimeamtDAO dao = (SimrealtimeamtDAO) DAOFactory.build(SimrealtimeamtDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SimrealtimeamtDAO dao = (SimrealtimeamtDAO) DAOFactory.build(SimrealtimeamtDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SimrealtimeamtVO doUpdate(SimrealtimeamtVO vo) throws Exception {
		try {
			SimrealtimeamtDAO dao = (SimrealtimeamtDAO) DAOFactory.build(SimrealtimeamtDAO.class,user);
			return (SimrealtimeamtVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SimrealtimeamtVO doFindByPk(Serializable pk) throws Exception {
		SimrealtimeamtDAO dao = (SimrealtimeamtDAO) DAOFactory.build(SimrealtimeamtDAO.class,user);
		return (SimrealtimeamtVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SimrealtimeamtDBParam params)
			throws Exception {
		SimrealtimeamtDAO dao = (SimrealtimeamtDAO) DAOFactory.build(SimrealtimeamtDAO.class,user);
		return dao.query(params);
	}
}
