/**
 * auto-generated code
 * Tue Sep 13 15:08:16 CST 2011
 */
package com.gmcc.pboss.business.imprrlparamsyn2crm.rlparamsynlog;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: RlparamsynlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RlparamsynlogBO extends AbstractControlBean implements
		Rlparamsynlog {

	public RlparamsynlogVO doCreate(RlparamsynlogVO vo) throws Exception {
		try {
			RlparamsynlogDAO dao = (RlparamsynlogDAO) DAOFactory.build(RlparamsynlogDAO.class, user);
			// TODO set the pk */
			return (RlparamsynlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RlparamsynlogVO vo) throws Exception {
		try {
			RlparamsynlogDAO dao = (RlparamsynlogDAO) DAOFactory.build(RlparamsynlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RlparamsynlogDAO dao = (RlparamsynlogDAO) DAOFactory.build(RlparamsynlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RlparamsynlogVO doUpdate(RlparamsynlogVO vo) throws Exception {
		try {
			RlparamsynlogDAO dao = (RlparamsynlogDAO) DAOFactory.build(RlparamsynlogDAO.class,user);
			return (RlparamsynlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RlparamsynlogVO doFindByPk(Serializable pk) throws Exception {
		RlparamsynlogDAO dao = (RlparamsynlogDAO) DAOFactory.build(RlparamsynlogDAO.class,user);
		return (RlparamsynlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RlparamsynlogDBParam params)
			throws Exception {
		RlparamsynlogDAO dao = (RlparamsynlogDAO) DAOFactory.build(RlparamsynlogDAO.class,user);
		return dao.query(params);
	}
}
