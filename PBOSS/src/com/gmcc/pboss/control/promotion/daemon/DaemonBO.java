/**
 * auto-generated code
 * Thu Sep 17 10:37:46 CST 2009
 */
package com.gmcc.pboss.control.promotion.daemon;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.daemon.DaemonDBParam;
import com.gmcc.pboss.business.promotion.daemon.DaemonDAO;
import com.gmcc.pboss.business.promotion.daemon.DaemonVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: DaemonBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/daemon/control/DaemonBO"
*    name="Daemon"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class DaemonBO extends AbstractControlBean implements
		Daemon {

	public DaemonVO doCreate(DaemonVO vo) throws Exception {
		try {
			DaemonDAO dao = (DaemonDAO) DAOFactory.build(DaemonDAO.class, user);
			// TODO set the pk */
			return (DaemonVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(DaemonVO vo) throws Exception {
		try {
			DaemonDAO dao = (DaemonDAO) DAOFactory.build(DaemonDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DaemonDAO dao = (DaemonDAO) DAOFactory.build(DaemonDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DaemonVO doUpdate(DaemonVO vo) throws Exception {
		try {
			DaemonDAO dao = (DaemonDAO) DAOFactory.build(DaemonDAO.class,user);
			return (DaemonVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DaemonVO doFindByPk(Serializable pk) throws Exception {
		DaemonDAO dao = (DaemonDAO) DAOFactory.build(DaemonDAO.class,user);
		return (DaemonVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(DaemonDBParam params)
			throws Exception {
		DaemonDAO dao = (DaemonDAO) DAOFactory.build(DaemonDAO.class,user);
		return dao.query(params);
	}
}
