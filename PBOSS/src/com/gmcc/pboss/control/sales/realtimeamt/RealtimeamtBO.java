/**
 * auto-generated code
 * Tue Oct 13 09:42:25 CST 2009
 */
package com.gmcc.pboss.control.sales.realtimeamt;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtDBParam;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtDAO;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RealtimeamtBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RealtimeamtBO extends AbstractControlBean implements
		Realtimeamt {

	public RealtimeamtVO doCreate(RealtimeamtVO vo) throws Exception {
		try {
			RealtimeamtDAO dao = (RealtimeamtDAO) DAOFactory.build(RealtimeamtDAO.class, user);
			// TODO set the pk */
			return (RealtimeamtVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RealtimeamtVO vo) throws Exception {
		try {
			RealtimeamtDAO dao = (RealtimeamtDAO) DAOFactory.build(RealtimeamtDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RealtimeamtDAO dao = (RealtimeamtDAO) DAOFactory.build(RealtimeamtDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RealtimeamtVO doUpdate(RealtimeamtVO vo) throws Exception {
		try {
			RealtimeamtDAO dao = (RealtimeamtDAO) DAOFactory.build(RealtimeamtDAO.class,user);
			return (RealtimeamtVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RealtimeamtVO doFindByPk(Serializable pk) throws Exception {
		RealtimeamtDAO dao = (RealtimeamtDAO) DAOFactory.build(RealtimeamtDAO.class,user);
		return (RealtimeamtVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RealtimeamtDBParam params)
			throws Exception {
		RealtimeamtDAO dao = (RealtimeamtDAO) DAOFactory.build(RealtimeamtDAO.class,user);
		return dao.query(params);
	}
}
