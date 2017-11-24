/**
 * auto-generated code
 * Wed Aug 04 10:45:31 CST 2010
 */
package com.gmcc.pboss.control.sales.ordcomlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.ordcomlog.OrdcomlogDBParam;
import com.gmcc.pboss.business.sales.ordcomlog.OrdcomlogDAO;
import com.gmcc.pboss.business.sales.ordcomlog.OrdcomlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: OrdcomlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrdcomlogBO extends AbstractControlBean implements
		Ordcomlog {

	public OrdcomlogVO doCreate(OrdcomlogVO vo) throws Exception {
		try {
			OrdcomlogDAO dao = (OrdcomlogDAO) DAOFactory.build(OrdcomlogDAO.class, user);
			// TODO set the pk */
			return (OrdcomlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrdcomlogVO vo) throws Exception {
		try {
			OrdcomlogDAO dao = (OrdcomlogDAO) DAOFactory.build(OrdcomlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrdcomlogDAO dao = (OrdcomlogDAO) DAOFactory.build(OrdcomlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrdcomlogVO doUpdate(OrdcomlogVO vo) throws Exception {
		try {
			OrdcomlogDAO dao = (OrdcomlogDAO) DAOFactory.build(OrdcomlogDAO.class,user);
			return (OrdcomlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrdcomlogVO doFindByPk(Serializable pk) throws Exception {
		OrdcomlogDAO dao = (OrdcomlogDAO) DAOFactory.build(OrdcomlogDAO.class,user);
		return (OrdcomlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrdcomlogDBParam params)
			throws Exception {
		OrdcomlogDAO dao = (OrdcomlogDAO) DAOFactory.build(OrdcomlogDAO.class,user);
		return dao.query(params);
	}
}
