/**
 * auto-generated code
 * Mon Mar 23 12:59:35 CST 2015
 */
package com.gmcc.pboss.control.communication.chpwcomsadvinfolog;

import java.io.Serializable;

import com.gmcc.pboss.business.communication.chpwcomsadvinfolog.ChPwComsadvinfologDBParam;
import com.gmcc.pboss.business.communication.chpwcomsadvinfolog.ChPwComsadvinfologDAO;
import com.gmcc.pboss.business.communication.chpwcomsadvinfolog.ChPwComsadvinfologVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ChPwComsadvinfologBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPwComsadvinfologBO extends AbstractControlBean implements
		ChPwComsadvinfolog {

	public ChPwComsadvinfologVO doCreate(ChPwComsadvinfologVO vo) throws Exception {
		try {
			ChPwComsadvinfologDAO dao = (ChPwComsadvinfologDAO) DAOFactory.build(ChPwComsadvinfologDAO.class, user);
			// TODO set the pk */
			return (ChPwComsadvinfologVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ChPwComsadvinfologVO vo) throws Exception {
		try {
			ChPwComsadvinfologDAO dao = (ChPwComsadvinfologDAO) DAOFactory.build(ChPwComsadvinfologDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ChPwComsadvinfologDAO dao = (ChPwComsadvinfologDAO) DAOFactory.build(ChPwComsadvinfologDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ChPwComsadvinfologVO doUpdate(ChPwComsadvinfologVO vo) throws Exception {
		try {
			ChPwComsadvinfologDAO dao = (ChPwComsadvinfologDAO) DAOFactory.build(ChPwComsadvinfologDAO.class,user);
			return (ChPwComsadvinfologVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ChPwComsadvinfologVO doFindByPk(Serializable pk) throws Exception {
		ChPwComsadvinfologDAO dao = (ChPwComsadvinfologDAO) DAOFactory.build(ChPwComsadvinfologDAO.class,user);
		return (ChPwComsadvinfologVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ChPwComsadvinfologDBParam params)
			throws Exception {
		ChPwComsadvinfologDAO dao = (ChPwComsadvinfologDAO) DAOFactory.build(ChPwComsadvinfologDAO.class,user);
		return dao.query(params);
	}
}
