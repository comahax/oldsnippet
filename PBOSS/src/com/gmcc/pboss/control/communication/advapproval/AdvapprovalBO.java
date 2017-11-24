/**
 * auto-generated code
 * Tue Sep 29 10:24:36 CST 2009
 */
package com.gmcc.pboss.control.communication.advapproval;

import java.io.Serializable;

import com.gmcc.pboss.business.communication.advapproval.AdvapprovalDBParam;
import com.gmcc.pboss.business.communication.advapproval.AdvapprovalDAO;
import com.gmcc.pboss.business.communication.advapproval.AdvapprovalVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: AdvapprovalBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/communication/advapproval/control/AdvapprovalBO"
*    name="Advapproval"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class AdvapprovalBO extends AbstractControlBean implements
		Advapproval {

	public AdvapprovalVO doCreate(AdvapprovalVO vo) throws Exception {
		try {
			AdvapprovalDAO dao = (AdvapprovalDAO) DAOFactory.build(AdvapprovalDAO.class, user);
			// TODO set the pk */
			return (AdvapprovalVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(AdvapprovalVO vo) throws Exception {
		try {
			AdvapprovalDAO dao = (AdvapprovalDAO) DAOFactory.build(AdvapprovalDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			AdvapprovalDAO dao = (AdvapprovalDAO) DAOFactory.build(AdvapprovalDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdvapprovalVO doUpdate(AdvapprovalVO vo) throws Exception {
		try {
			AdvapprovalDAO dao = (AdvapprovalDAO) DAOFactory.build(AdvapprovalDAO.class,user);
			return (AdvapprovalVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdvapprovalVO doFindByPk(Serializable pk) throws Exception {
		AdvapprovalDAO dao = (AdvapprovalDAO) DAOFactory.build(AdvapprovalDAO.class,user);
		return (AdvapprovalVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(AdvapprovalDBParam params)
			throws Exception {
		AdvapprovalDAO dao = (AdvapprovalDAO) DAOFactory.build(AdvapprovalDAO.class,user);
		return dao.query(params);
	}
}
