/**
 * auto-generated code
 * Mon Sep 07 11:18:53 CST 2009
 */
package com.gmcc.pboss.control.base.operrolelog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.operrolelog.OperrolelogDAO;
import com.gmcc.pboss.business.base.operrolelog.OperrolelogDBParam;
import com.gmcc.pboss.business.base.operrolelog.OperrolelogVO;
import com.gmcc.pboss.control.base.role.Role;
import com.gmcc.pboss.control.base.role.RoleBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OperrolelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/operrolelog/control/OperrolelogBO"
*    name="Operrolelog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class OperrolelogBO extends AbstractControlBean implements
		Operrolelog {

	public OperrolelogVO doCreate(OperrolelogVO vo) throws Exception {
		try {
			OperrolelogDAO dao = (OperrolelogDAO) DAOFactory.build(OperrolelogDAO.class, user);
			// TODO set the pk */
			return (OperrolelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OperrolelogVO vo) throws Exception {
		try {
			OperrolelogDAO dao = (OperrolelogDAO) DAOFactory.build(OperrolelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OperrolelogDAO dao = (OperrolelogDAO) DAOFactory.build(OperrolelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperrolelogVO doUpdate(OperrolelogVO vo) throws Exception {
		try {
			OperrolelogDAO dao = (OperrolelogDAO) DAOFactory.build(OperrolelogDAO.class,user);
			return (OperrolelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperrolelogVO doFindByPk(Serializable pk) throws Exception {
		OperrolelogDAO dao = (OperrolelogDAO) DAOFactory.build(OperrolelogDAO.class,user);
		return (OperrolelogVO) dao.findByPk(pk);
	}
	
	public DataPackage doQuery(OperrolelogDBParam params) throws Exception {
		OperrolelogDAO dao = (OperrolelogDAO) DAOFactory.build(OperrolelogDAO.class,
				user);
		Role role = (Role)BOFactory.build(RoleBO.class, user);
		if(role.doIfAdmin()){
			return dao.queryWithoutRoleLimited(params);
		}else{
			return dao.queryWithRoleLimited(params);
		}
	}
}
