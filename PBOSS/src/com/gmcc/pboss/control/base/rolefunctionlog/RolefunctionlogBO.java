/**
 * auto-generated code
 * Mon Sep 07 10:49:06 CST 2009
 */
package com.gmcc.pboss.control.base.rolefunctionlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.rolefunctionlog.RolefunctionlogDAO;
import com.gmcc.pboss.business.base.rolefunctionlog.RolefunctionlogDBParam;
import com.gmcc.pboss.business.base.rolefunctionlog.RolefunctionlogVO;
import com.gmcc.pboss.control.base.role.Role;
import com.gmcc.pboss.control.base.role.RoleBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RolefunctionlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/rolefunctionlog/control/RolefunctionlogBO"
*    name="Rolefunctionlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RolefunctionlogBO extends AbstractControlBean implements
		Rolefunctionlog {

	public RolefunctionlogVO doCreate(RolefunctionlogVO vo) throws Exception {
		try {
			RolefunctionlogDAO dao = (RolefunctionlogDAO) DAOFactory.build(RolefunctionlogDAO.class, user);
			// TODO set the pk */
			return (RolefunctionlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RolefunctionlogVO vo) throws Exception {
		try {
			RolefunctionlogDAO dao = (RolefunctionlogDAO) DAOFactory.build(RolefunctionlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RolefunctionlogDAO dao = (RolefunctionlogDAO) DAOFactory.build(RolefunctionlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RolefunctionlogVO doUpdate(RolefunctionlogVO vo) throws Exception {
		try {
			RolefunctionlogDAO dao = (RolefunctionlogDAO) DAOFactory.build(RolefunctionlogDAO.class,user);
			return (RolefunctionlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RolefunctionlogVO doFindByPk(Serializable pk) throws Exception {
		RolefunctionlogDAO dao = (RolefunctionlogDAO) DAOFactory.build(RolefunctionlogDAO.class,user);
		return (RolefunctionlogVO) dao.findByPk(pk);
	}
	
	public DataPackage doQuery(RolefunctionlogDBParam params) throws Exception {
		RolefunctionlogDAO dao = (RolefunctionlogDAO) DAOFactory.build(RolefunctionlogDAO.class,user);
		Role role = (Role) BOFactory.build(RoleBO.class, user);
		if (role.doIfAdmin()) {
			return dao.query(params);
		} else {
			return dao.queryWithRoleLimited(params);
		}
	}
}
