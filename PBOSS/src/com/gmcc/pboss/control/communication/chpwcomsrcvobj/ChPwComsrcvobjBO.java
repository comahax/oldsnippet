/**
 * auto-generated code
 * Fri Mar 20 16:55:40 CST 2015
 */
package com.gmcc.pboss.control.communication.chpwcomsrcvobj;

import java.io.Serializable;

import com.gmcc.pboss.business.communication.chpwcomsrcvobj.ChPwComsrcvobjDBParam;
import com.gmcc.pboss.business.communication.chpwcomsrcvobj.ChPwComsrcvobjDAO;
import com.gmcc.pboss.business.communication.chpwcomsrcvobj.ChPwComsrcvobjVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ChPwComsrcvobjBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPwComsrcvobjBO extends AbstractControlBean implements
		ChPwComsrcvobj {

	public ChPwComsrcvobjVO doCreate(ChPwComsrcvobjVO vo) throws Exception {
		try {
			ChPwComsrcvobjDAO dao = (ChPwComsrcvobjDAO) DAOFactory.build(ChPwComsrcvobjDAO.class, user);
			// TODO set the pk */
			return (ChPwComsrcvobjVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ChPwComsrcvobjVO vo) throws Exception {
		try {
			ChPwComsrcvobjDAO dao = (ChPwComsrcvobjDAO) DAOFactory.build(ChPwComsrcvobjDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ChPwComsrcvobjDAO dao = (ChPwComsrcvobjDAO) DAOFactory.build(ChPwComsrcvobjDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ChPwComsrcvobjVO doUpdate(ChPwComsrcvobjVO vo) throws Exception {
		try {
			ChPwComsrcvobjDAO dao = (ChPwComsrcvobjDAO) DAOFactory.build(ChPwComsrcvobjDAO.class,user);
			return (ChPwComsrcvobjVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ChPwComsrcvobjVO doFindByPk(Serializable pk) throws Exception {
		ChPwComsrcvobjDAO dao = (ChPwComsrcvobjDAO) DAOFactory.build(ChPwComsrcvobjDAO.class,user);
		return (ChPwComsrcvobjVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ChPwComsrcvobjDBParam params)
			throws Exception {
		ChPwComsrcvobjDAO dao = (ChPwComsrcvobjDAO) DAOFactory.build(ChPwComsrcvobjDAO.class,user);
		return dao.query(params);
	}
}
