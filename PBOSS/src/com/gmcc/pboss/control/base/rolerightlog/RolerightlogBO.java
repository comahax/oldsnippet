/**
 * auto-generated code
 * Mon Sep 07 10:50:13 CST 2009
 */
package com.gmcc.pboss.control.base.rolerightlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.roleright.RolerightDAO;
import com.gmcc.pboss.business.base.roleright.RolerightDBParam;
import com.gmcc.pboss.business.base.rolerightlog.RolerightlogDBParam;
import com.gmcc.pboss.business.base.rolerightlog.RolerightlogDAO;
import com.gmcc.pboss.business.base.rolerightlog.RolerightlogVO;
import com.gmcc.pboss.control.base.role.Role;
import com.gmcc.pboss.control.base.role.RoleBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RolerightlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/rolerightlog/control/RolerightlogBO"
*    name="Rolerightlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RolerightlogBO extends AbstractControlBean implements
		Rolerightlog {

	public RolerightlogVO doCreate(RolerightlogVO vo) throws Exception {
		try {
			RolerightlogDAO dao = (RolerightlogDAO) DAOFactory.build(RolerightlogDAO.class, user);
			// TODO set the pk */
			return (RolerightlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RolerightlogVO vo) throws Exception {
		try {
			RolerightlogDAO dao = (RolerightlogDAO) DAOFactory.build(RolerightlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RolerightlogDAO dao = (RolerightlogDAO) DAOFactory.build(RolerightlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RolerightlogVO doUpdate(RolerightlogVO vo) throws Exception {
		try {
			RolerightlogDAO dao = (RolerightlogDAO) DAOFactory.build(RolerightlogDAO.class,user);
			return (RolerightlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RolerightlogVO doFindByPk(Serializable pk) throws Exception {
		RolerightlogDAO dao = (RolerightlogDAO) DAOFactory.build(RolerightlogDAO.class,user);
		return (RolerightlogVO) dao.findByPk(pk);
	}
	
	public DataPackage doQuery(RolerightlogDBParam params) throws Exception {
		RolerightlogDAO dao = (RolerightlogDAO) DAOFactory.build(RolerightlogDAO.class,user);
		Role role = (Role)BOFactory.build(RoleBO.class, user);
		if(role.doIfAdmin()){
			return dao.query(params);
		}else{
			return dao.queryWithRoleLimited(params);
		}
	}
}
