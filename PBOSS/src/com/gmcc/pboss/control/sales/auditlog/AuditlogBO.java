/**
 * auto-generated code
 * Tue Aug 03 15:52:05 CST 2010
 */
package com.gmcc.pboss.control.sales.auditlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.auditlog.AuditlogDBParam;
import com.gmcc.pboss.business.sales.auditlog.AuditlogDAO;
import com.gmcc.pboss.business.sales.auditlog.AuditlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: AuditlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AuditlogBO extends AbstractControlBean implements
		Auditlog {

	public AuditlogVO doCreate(AuditlogVO vo) throws Exception {
		try {
			AuditlogDAO dao = (AuditlogDAO) DAOFactory.build(AuditlogDAO.class, user);
			// TODO set the pk */
			return (AuditlogVO) dao.create(vo);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(AuditlogVO vo) throws Exception {
		try {
			AuditlogDAO dao = (AuditlogDAO) DAOFactory.build(AuditlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			AuditlogDAO dao = (AuditlogDAO) DAOFactory.build(AuditlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AuditlogVO doUpdate(AuditlogVO vo) throws Exception {
		try {
			AuditlogDAO dao = (AuditlogDAO) DAOFactory.build(AuditlogDAO.class,user);
			return (AuditlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AuditlogVO doFindByPk(Serializable pk) throws Exception {
		AuditlogDAO dao = (AuditlogDAO) DAOFactory.build(AuditlogDAO.class,user);
		return (AuditlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(AuditlogDBParam params)
			throws Exception {
		AuditlogDAO dao = (AuditlogDAO) DAOFactory.build(AuditlogDAO.class,user);
		return dao.query(params);
	}
}
