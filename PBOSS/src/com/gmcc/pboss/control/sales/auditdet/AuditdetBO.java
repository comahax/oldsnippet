/**
 * auto-generated code
 * Fri Dec 17 11:26:27 CST 2010
 */
package com.gmcc.pboss.control.sales.auditdet;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.auditdet.AuditdetDBParam;
import com.gmcc.pboss.business.sales.auditdet.AuditdetDAO;
import com.gmcc.pboss.business.sales.auditdet.AuditdetVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: AuditdetBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class AuditdetBO extends AbstractControlBean implements
		Auditdet {

	public AuditdetVO doCreate(AuditdetVO vo) throws Exception {
		try {
			AuditdetDAO dao = (AuditdetDAO) DAOFactory.build(AuditdetDAO.class, user);
			// TODO set the pk */
			return (AuditdetVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(AuditdetVO vo) throws Exception {
		try {
			AuditdetDAO dao = (AuditdetDAO) DAOFactory.build(AuditdetDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			AuditdetDAO dao = (AuditdetDAO) DAOFactory.build(AuditdetDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AuditdetVO doUpdate(AuditdetVO vo) throws Exception {
		try {
			AuditdetDAO dao = (AuditdetDAO) DAOFactory.build(AuditdetDAO.class,user);
			return (AuditdetVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AuditdetVO doFindByPk(Serializable pk) throws Exception {
		AuditdetDAO dao = (AuditdetDAO) DAOFactory.build(AuditdetDAO.class,user);
		return (AuditdetVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(AuditdetDBParam params)
			throws Exception {
		AuditdetDAO dao = (AuditdetDAO) DAOFactory.build(AuditdetDAO.class,user);
		return dao.query(params);
	}
}
