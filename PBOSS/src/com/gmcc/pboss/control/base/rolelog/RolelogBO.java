/**
 * auto-generated code
 * Mon Sep 07 10:46:06 CST 2009
 */
package com.gmcc.pboss.control.base.rolelog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.rolelog.RolelogDBParam;
import com.gmcc.pboss.business.base.rolelog.RolelogDAO;
import com.gmcc.pboss.business.base.rolelog.RolelogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RolelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/rolelog/control/RolelogBO"
*    name="Rolelog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RolelogBO extends AbstractControlBean implements
		Rolelog {

	public RolelogVO doCreate(RolelogVO vo) throws Exception {
		try {
			RolelogDAO dao = (RolelogDAO) DAOFactory.build(RolelogDAO.class, user);
			// TODO set the pk */
			return (RolelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RolelogVO vo) throws Exception {
		try {
			RolelogDAO dao = (RolelogDAO) DAOFactory.build(RolelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RolelogDAO dao = (RolelogDAO) DAOFactory.build(RolelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RolelogVO doUpdate(RolelogVO vo) throws Exception {
		try {
			RolelogDAO dao = (RolelogDAO) DAOFactory.build(RolelogDAO.class,user);
			return (RolelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RolelogVO doFindByPk(Serializable pk) throws Exception {
		RolelogDAO dao = (RolelogDAO) DAOFactory.build(RolelogDAO.class,user);
		return (RolelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RolelogDBParam params)
			throws Exception {
		RolelogDAO dao = (RolelogDAO) DAOFactory.build(RolelogDAO.class,user);
		return dao.query(params);
	}
}
