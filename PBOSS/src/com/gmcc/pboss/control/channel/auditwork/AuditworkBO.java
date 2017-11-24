/**
 * auto-generated code
 * Thu Oct 15 16:20:00 CST 2009
 */
package com.gmcc.pboss.control.channel.auditwork;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.auditwork.AuditworkDBParam;
import com.gmcc.pboss.business.channel.auditwork.AuditworkDAO;
import com.gmcc.pboss.business.channel.auditwork.AuditworkVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: AuditworkBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/auditwork/control/AuditworkBO"
*    name="Auditwork"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class AuditworkBO extends AbstractControlBean implements
		Auditwork {

	public AuditworkVO doCreate(AuditworkVO vo) throws Exception {
		try {
			AuditworkDAO dao = (AuditworkDAO) DAOFactory.build(AuditworkDAO.class, user);
			// TODO set the pk */
			return (AuditworkVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(AuditworkVO vo) throws Exception {
		try {
			AuditworkDAO dao = (AuditworkDAO) DAOFactory.build(AuditworkDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			AuditworkDAO dao = (AuditworkDAO) DAOFactory.build(AuditworkDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AuditworkVO doUpdate(AuditworkVO vo) throws Exception {
		try {
			AuditworkDAO dao = (AuditworkDAO) DAOFactory.build(AuditworkDAO.class,user);
			return (AuditworkVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AuditworkVO doFindByPk(Serializable pk) throws Exception {
		AuditworkDAO dao = (AuditworkDAO) DAOFactory.build(AuditworkDAO.class,user);
		return (AuditworkVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(AuditworkDBParam params)
			throws Exception {
		AuditworkDAO dao = (AuditworkDAO) DAOFactory.build(AuditworkDAO.class,user);
		return dao.query(params);
	}
}
