/**
 * auto-generated code
 * Thu Aug 12 18:07:03 CST 2010
 */
package com.gmcc.pboss.control.channel.cooperalog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.cooperalog.CooperalogDBParam;
import com.gmcc.pboss.business.channel.cooperalog.CooperalogDAO;
import com.gmcc.pboss.business.channel.cooperalog.CooperalogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: CooperalogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public class CooperalogBO extends AbstractControlBean implements
		Cooperalog {

	public CooperalogVO doCreate(CooperalogVO vo) throws Exception {
		try {
			CooperalogDAO dao = (CooperalogDAO) DAOFactory.build(CooperalogDAO.class, user);
			// TODO set the pk */
			return (CooperalogVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CooperalogVO vo) throws Exception {
		try {
			CooperalogDAO dao = (CooperalogDAO) DAOFactory.build(CooperalogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CooperalogDAO dao = (CooperalogDAO) DAOFactory.build(CooperalogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public CooperalogVO doUpdate(CooperalogVO vo) throws Exception {
		try {
			CooperalogDAO dao = (CooperalogDAO) DAOFactory.build(CooperalogDAO.class,user);
			return (CooperalogVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public CooperalogVO doFindByPk(Serializable pk) throws Exception {
		CooperalogDAO dao = (CooperalogDAO) DAOFactory.build(CooperalogDAO.class,user);
		return (CooperalogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CooperalogDBParam params)
			throws Exception {
		CooperalogDAO dao = (CooperalogDAO) DAOFactory.build(CooperalogDAO.class,user);
		return dao.query(params);
	}
}
