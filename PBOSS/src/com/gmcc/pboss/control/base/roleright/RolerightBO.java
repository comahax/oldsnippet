/**
 * auto-generated code
 * Thu Jul 09 16:16:16 CST 2009
 */
package com.gmcc.pboss.control.base.roleright;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.gmcc.pboss.business.base.roleright.RolerightDAO;
import com.gmcc.pboss.business.base.roleright.RolerightDBParam;
import com.gmcc.pboss.business.base.roleright.RolerightVO;
import com.gmcc.pboss.control.base.role.Role;
import com.gmcc.pboss.control.base.role.RoleBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: RolerightBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name=
 *           "com/sunrise/jop/business/base/roleright/control/RolerightBO"
 *           name="Roleright" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class RolerightBO extends AbstractControlBean implements Roleright {

	public RolerightVO doCreate(RolerightVO vo) throws Exception {
		try {
			RolerightDAO dao = (RolerightDAO) DAOFactory.build(
					RolerightDAO.class, user);
			// TODO set the pk */
			return (RolerightVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RolerightVO vo) throws Exception {
		try {
			RolerightDAO dao = (RolerightDAO) DAOFactory.build(
					RolerightDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RolerightDAO dao = (RolerightDAO) DAOFactory.build(
					RolerightDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RolerightVO doUpdate(RolerightVO vo) throws Exception {
		try {
			RolerightDAO dao = (RolerightDAO) DAOFactory.build(
					RolerightDAO.class, user);
			return (RolerightVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RolerightVO doFindByPk(Serializable pk) throws Exception {
		RolerightDAO dao = (RolerightDAO) DAOFactory.build(RolerightDAO.class,
				user);
		return (RolerightVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RolerightDBParam params,User user) throws Exception {
		RolerightDAO dao = (RolerightDAO) DAOFactory.build(RolerightDAO.class,
				user);
		Role role = (Role)BOFactory.build(RoleBO.class, user);
		params.getQueryConditions().put("loginwayid", user.getWayid());
		params.getQueryConditions().put("logincityid", user.getCityid());
		if(!role.doIfAdmin()){
			return dao.queryByNamedSqlQuery("system.rolerightLimitedQuery",params);
		}else{
			return dao.queryByNamedSqlQuery("system.rolerightWithoutLimitedQuery",params);
		}
	}

	public void doBatchSave(List rightList, List roleList) throws Exception {
		try {
			// RolerightDAO dao = (RolerightDAO)
			// DAOFactory.build(RolerightDAO.class,user);
			Roleright roleright = (Roleright) BOFactory.build(
					RolerightBO.class, user);
			for (Iterator ittRight = rightList.iterator(); ittRight.hasNext();) {
				String rightid = (String) ittRight.next();
				for (Iterator ittRole = roleList.iterator(); ittRole.hasNext();) {
					String roleid = (String) ittRole.next();
					RolerightVO vo = new RolerightVO();
					vo.setItemid(roleid);
					vo.setRightid(rightid);
					if ((RolerightVO) roleright.doFindByPk(vo) == null) {
						vo.setStatus((byte) 1);
						vo.setCreatedate(new Date());
						vo.setStatusdate(PublicUtils.UtilStrToDate(
								"2099-12-31", "yyyy-MM-dd"));
						roleright.doCreate(vo);
					}
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
}
