/**
 * auto-generated code
 * Thu Jul 08 15:13:51 CST 2010
 */
package com.gmcc.pboss.control.sales.timesectlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.timesectlog.TimesectlogDBParam;
import com.gmcc.pboss.business.sales.timesectlog.TimesectlogDAO;
import com.gmcc.pboss.business.sales.timesectlog.TimesectlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: TimesectlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class TimesectlogBO extends AbstractControlBean implements
		Timesectlog {

	public TimesectlogVO doCreate(TimesectlogVO vo) throws Exception {
		try {
			TimesectlogDAO dao = (TimesectlogDAO) DAOFactory.build(TimesectlogDAO.class, user);
			// TODO set the pk */
			return (TimesectlogVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(TimesectlogVO vo) throws Exception {
		try {
			TimesectlogDAO dao = (TimesectlogDAO) DAOFactory.build(TimesectlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			TimesectlogDAO dao = (TimesectlogDAO) DAOFactory.build(TimesectlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public TimesectlogVO doUpdate(TimesectlogVO vo) throws Exception {
		try {
			TimesectlogDAO dao = (TimesectlogDAO) DAOFactory.build(TimesectlogDAO.class,user);
			return (TimesectlogVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public TimesectlogVO doFindByPk(Serializable pk) throws Exception {
		TimesectlogDAO dao = (TimesectlogDAO) DAOFactory.build(TimesectlogDAO.class,user);
		return (TimesectlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(TimesectlogDBParam params)
			throws Exception {
		TimesectlogDAO dao = (TimesectlogDAO) DAOFactory.build(TimesectlogDAO.class,user);
		return dao.query(params);
	}
}
