/**
 * auto-generated code
 * Wed Oct 07 13:35:00 CST 2009
 */
package com.gmcc.pboss.control.channel.cooperator;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.cooperator.CooperatorDBParam;
import com.gmcc.pboss.business.channel.cooperator.CooperatorDAO;
import com.gmcc.pboss.business.channel.cooperator.CooperatorVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: CooperatorBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class CooperatorBO extends AbstractControlBean implements
		Cooperator {

	public CooperatorVO doCreate(CooperatorVO vo) throws Exception {
		try {
			CooperatorDAO dao = (CooperatorDAO) DAOFactory.build(CooperatorDAO.class, user);
			// TODO set the pk */
			return (CooperatorVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CooperatorVO vo) throws Exception {
		try {
			CooperatorDAO dao = (CooperatorDAO) DAOFactory.build(CooperatorDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CooperatorDAO dao = (CooperatorDAO) DAOFactory.build(CooperatorDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CooperatorVO doUpdate(CooperatorVO vo) throws Exception {
		try {
			CooperatorDAO dao = (CooperatorDAO) DAOFactory.build(CooperatorDAO.class,user);
			return (CooperatorVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CooperatorVO doFindByPk(Serializable pk) throws Exception {
		CooperatorDAO dao = (CooperatorDAO) DAOFactory.build(CooperatorDAO.class,user);
		return (CooperatorVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CooperatorDBParam params)
			throws Exception {
		CooperatorDAO dao = (CooperatorDAO) DAOFactory.build(CooperatorDAO.class,user);
		return dao.query(params);
	}
}
