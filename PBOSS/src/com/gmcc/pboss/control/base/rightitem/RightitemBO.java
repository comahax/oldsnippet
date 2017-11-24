/**
 * auto-generated code
 * Mon Jul 13 10:27:28 CST 2009
 */
package com.gmcc.pboss.control.base.rightitem;

import java.io.Serializable;

import com.gmcc.pboss.business.base.rightitem.RightitemDBParam;
import com.gmcc.pboss.business.base.rightitem.RightitemDAO;
import com.gmcc.pboss.business.base.rightitem.RightitemVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: RightitemBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Lee
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/rightitem/control/RightitemBO"
*    name="Rightitem"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RightitemBO extends AbstractControlBean implements
		Rightitem {

	public RightitemVO doCreate(RightitemVO vo) throws Exception {
		try {
			RightitemDAO dao = (RightitemDAO) DAOFactory.build(RightitemDAO.class, user);
			// TODO set the pk */
			return (RightitemVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RightitemVO vo) throws Exception {
		try {
			RightitemDAO dao = (RightitemDAO) DAOFactory.build(RightitemDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RightitemDAO dao = (RightitemDAO) DAOFactory.build(RightitemDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RightitemVO doUpdate(RightitemVO vo) throws Exception {
		try {
			RightitemDAO dao = (RightitemDAO) DAOFactory.build(RightitemDAO.class,user);
			return (RightitemVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RightitemVO doFindByPk(Serializable pk) throws Exception {
		RightitemDAO dao = (RightitemDAO) DAOFactory.build(RightitemDAO.class,user);
		return (RightitemVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RightitemDBParam params)
			throws Exception {
		RightitemDAO dao = (RightitemDAO) DAOFactory.build(RightitemDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doQueryRightRootId() throws Exception{
		RightitemDBParam params = new RightitemDBParam();
		RightitemDAO dao = (RightitemDAO) DAOFactory.build(RightitemDAO.class,user);
		params.getQueryConditions().put("cityid", user.getCityid());
		params.getQueryConditions().put("wayid", ((User)user).getWayid());
		params.setQueryAll(true);
		return dao.queryByNamedSqlQuery("getRightRootID",params);
	}
	
	public DataPackage doQueryText(String queryText) throws Exception{
		RightitemDBParam params = new RightitemDBParam();
		RightitemDAO dao = (RightitemDAO) DAOFactory.build(RightitemDAO.class,user);
		params.getQueryConditions().put("queryText", "%"+queryText+"%");
		params.setQueryAll(true);
		return dao.queryByNamedSqlQuery("queryTextSQL",params);
	}
}
