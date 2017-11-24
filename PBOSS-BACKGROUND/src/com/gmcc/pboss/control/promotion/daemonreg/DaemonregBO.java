/**
 * auto-generated code
 * Thu Sep 17 15:58:40 CST 2009
 */
package com.gmcc.pboss.control.promotion.daemonreg;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.daemonreg.DaemonregDAO;
import com.gmcc.pboss.business.promotion.daemonreg.DaemonregDBParam;
import com.gmcc.pboss.business.promotion.daemonreg.DaemonregVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: DaemonregBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotions/daemonreg/control/DaemonregBO"
*    name="Daemonreg"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class DaemonregBO extends AbstractControlBean implements
		Daemonreg {

	public DaemonregVO doCreate(DaemonregVO vo) throws Exception {
		try {
			DaemonregDAO dao = (DaemonregDAO) DAOFactory.build(DaemonregDAO.class, user);
			// TODO set the pk */
			return (DaemonregVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(DaemonregVO vo) throws Exception {
		try {
			DaemonregDAO dao = (DaemonregDAO) DAOFactory.build(DaemonregDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DaemonregDAO dao = (DaemonregDAO) DAOFactory.build(DaemonregDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DaemonregVO doUpdate(DaemonregVO vo) throws Exception {
		try {
			DaemonregDAO dao = (DaemonregDAO) DAOFactory.build(DaemonregDAO.class,user);
			return (DaemonregVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DaemonregVO doFindByPk(Serializable pk) throws Exception {
		DaemonregDAO dao = (DaemonregDAO) DAOFactory.build(DaemonregDAO.class,user);
		return (DaemonregVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(DaemonregDBParam params)
			throws Exception {
		DaemonregDAO dao = (DaemonregDAO) DAOFactory.build(DaemonregDAO.class,user);
		return dao.query(params);
	}
}
