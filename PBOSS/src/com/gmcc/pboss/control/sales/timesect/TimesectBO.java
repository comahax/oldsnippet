/**
 * auto-generated code
 * Thu Jul 08 15:12:12 CST 2010
 */
package com.gmcc.pboss.control.sales.timesect;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.timesect.TimesectDBParam;
import com.gmcc.pboss.business.sales.timesect.TimesectDAO;
import com.gmcc.pboss.business.sales.timesect.TimesectVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: TimesectBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class TimesectBO extends AbstractControlBean implements
		Timesect {

	public TimesectVO doCreate(TimesectVO vo) throws Exception {
		try {
			TimesectDAO dao = (TimesectDAO) DAOFactory.build(TimesectDAO.class, user);
			// TODO set the pk */
			return (TimesectVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(TimesectVO vo) throws Exception {
		try {
			TimesectDAO dao = (TimesectDAO) DAOFactory.build(TimesectDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			TimesectDAO dao = (TimesectDAO) DAOFactory.build(TimesectDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public TimesectVO doUpdate(TimesectVO vo) throws Exception {
		try {
			TimesectDAO dao = (TimesectDAO) DAOFactory.build(TimesectDAO.class,user);
			return (TimesectVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public TimesectVO doFindByPk(Serializable pk) throws Exception {
		TimesectDAO dao = (TimesectDAO) DAOFactory.build(TimesectDAO.class,user);
		return (TimesectVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(TimesectDBParam params)
			throws Exception {
		TimesectDAO dao = (TimesectDAO) DAOFactory.build(TimesectDAO.class,user);
		return dao.query(params);
	}
}
