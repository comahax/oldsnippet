/**
 * auto-generated code
 * Tue Jul 05 09:55:04 CST 2011
 */
package com.gmcc.pboss.control.base.smsobject;

import java.io.Serializable;

import com.gmcc.pboss.business.base.smsobject.SmsobjectDBParam;
import com.gmcc.pboss.business.base.smsobject.SmsobjectDAO;
import com.gmcc.pboss.business.base.smsobject.SmsobjectVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: SmsobjectBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public class SmsobjectBO extends AbstractControlBean implements
		Smsobject {

	public SmsobjectVO doCreate(SmsobjectVO vo) throws Exception {
		try {
			SmsobjectDAO dao = (SmsobjectDAO) DAOFactory.build(SmsobjectDAO.class, user);
			// TODO set the pk */
			return (SmsobjectVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SmsobjectVO vo) throws Exception {
		try {
			SmsobjectDAO dao = (SmsobjectDAO) DAOFactory.build(SmsobjectDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SmsobjectDAO dao = (SmsobjectDAO) DAOFactory.build(SmsobjectDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmsobjectVO doUpdate(SmsobjectVO vo) throws Exception {
		try {
			SmsobjectDAO dao = (SmsobjectDAO) DAOFactory.build(SmsobjectDAO.class,user);
			return (SmsobjectVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmsobjectVO doFindByPk(Serializable pk) throws Exception {
		SmsobjectDAO dao = (SmsobjectDAO) DAOFactory.build(SmsobjectDAO.class,user);
		return (SmsobjectVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SmsobjectDBParam params)
			throws Exception {
		SmsobjectDAO dao = (SmsobjectDAO) DAOFactory.build(SmsobjectDAO.class,user);
		return dao.query(params);
	}
}
