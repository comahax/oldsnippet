package com.gmcc.pboss.control.base.role;

import java.io.Serializable;
import java.util.Iterator;

import com.gmcc.pboss.business.base.operrole.OperroleDAO;
import com.gmcc.pboss.business.base.operrole.OperroleDBParam;
import com.gmcc.pboss.business.base.operrole.OperroleVO;
import com.gmcc.pboss.business.base.role.RoleDAO;
import com.gmcc.pboss.business.base.role.RoleDBParam;
import com.gmcc.pboss.business.base.role.RoleVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: RoleBO</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/gmcc/pboss/control/base/role/RoleBO"
 *           name="Role" view-type="local" type="Stateless"
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */

public class RoleBO extends AbstractControlBean implements Role {

	public RoleVO doCreate(RoleVO vo) throws Exception {
		try {
			RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class, user);
			return (RoleVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RoleVO doFindByPk(Serializable pk) throws Exception {
		RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class, user);
		return (RoleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RoleDBParam params,User user) throws Exception {
		RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class, user);
		params.getQueryConditions().put("loginwayid", user.getWayid());
		params.getQueryConditions().put("logincityid", user.getCityid());
		if(!this.doIfAdmin()){
			return dao.queryByNamedSqlQuery("base.role.querybynotadmin", params);
		}else{
			return dao.queryByNamedSqlQuery("base.role.querybyadmin", params);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RoleVO vo) throws Exception {
		try {
			RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RoleVO doUpdate(RoleVO vo) throws Exception {
		try {
			RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class, user);
			return (RoleVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	
	/*
	 * 判断登录工号是否是后台角色(即管理员角色),
	 *  true:是
	 *  false:否
	 */
	public boolean doIfAdmin() throws Exception {
		try {
			boolean flag = false;
			String oprcode = user.getOprcode();
			OperroleDAO ordao = (OperroleDAO) DAOFactory.build(
					OperroleDAO.class, user);
			Role role = (Role)BOFactory.build(RoleBO.class, user);
			OperroleDBParam orparam = new OperroleDBParam();
			orparam.set_se_operid(oprcode);
			DataPackage dpxx = ordao.query(orparam);
			if (null != dpxx && dpxx.getDatas().size() > 0) {
				for (Iterator it = dpxx.getDatas().iterator(); it.hasNext();) {
					OperroleVO orvo = (OperroleVO) it.next();
					String roleid = orvo.getRoleid();
					RoleVO rolevo = role.doFindByPk(roleid);
					if(null!=rolevo){
						if (null!=rolevo.getIsback() && rolevo.getIsback()==1) {
							flag = true;
							break;
						}
					}
				}
			}
			return flag;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

}
