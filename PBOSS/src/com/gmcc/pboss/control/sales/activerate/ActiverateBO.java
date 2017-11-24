/**
 * auto-generated code
 * Mon Oct 19 19:01:28 CST 2009
 */
package com.gmcc.pboss.control.sales.activerate;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.activerate.ActiverateDBParam;
import com.gmcc.pboss.business.sales.activerate.ActiverateDAO;
import com.gmcc.pboss.business.sales.activerate.ActiverateVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ActiverateBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/sales/activerate/control/ActiverateBO"
*    name="Activerate"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ActiverateBO extends AbstractControlBean implements
		Activerate {

	public ActiverateVO doCreate(ActiverateVO vo) throws Exception {
		try {
			ActiverateDAO dao = (ActiverateDAO) DAOFactory.build(ActiverateDAO.class, user);
			// TODO set the pk */
			return (ActiverateVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ActiverateVO vo) throws Exception {
		try {
			ActiverateDAO dao = (ActiverateDAO) DAOFactory.build(ActiverateDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ActiverateDAO dao = (ActiverateDAO) DAOFactory.build(ActiverateDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ActiverateVO doUpdate(ActiverateVO vo) throws Exception {
		try {
			ActiverateDAO dao = (ActiverateDAO) DAOFactory.build(ActiverateDAO.class,user);
			return (ActiverateVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ActiverateVO doFindByPk(Serializable pk) throws Exception {
		ActiverateDAO dao = (ActiverateDAO) DAOFactory.build(ActiverateDAO.class,user);
		return (ActiverateVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ActiverateDBParam params)
			throws Exception {
		ActiverateDAO dao = (ActiverateDAO) DAOFactory.build(ActiverateDAO.class,user);
		return dao.query(params);
	}
}
