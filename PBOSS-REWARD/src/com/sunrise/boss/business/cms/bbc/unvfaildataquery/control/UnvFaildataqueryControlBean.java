/**
 * auto-generated code
 * Wed Sep 02 16:37:07 CST 2009
 */
package com.sunrise.boss.business.cms.bbc.unvfaildataquery.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvfaildataquery.persistent.UnvFaildataqueryVO;
import com.sunrise.boss.business.cms.bbc.unvfaildataquery.persistent.UnvFaildataqueryDAO;
import com.sunrise.boss.business.cms.bbc.unvfaildataquery.persistent.UnvFaildataqueryListVO;

/**
 * <p>Title: UnvFaildataqueryControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/unvfaildataquery/control/UnvFaildataqueryControlBean"
 name="UnvFaildataqueryControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
 */
public class UnvFaildataqueryControlBean extends AbstractControlBean implements
		UnvFaildataqueryControl {

	public UnvFaildataqueryVO doCreate(UnvFaildataqueryVO vo, User user)
			throws Exception {
		try {
			UnvFaildataqueryDAO dao = (UnvFaildataqueryDAO) DAOFactory.build(
					UnvFaildataqueryDAO.class, user);
			// TODO  set the pk */
			return (UnvFaildataqueryVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(UnvFaildataqueryVO vo, User user) throws Exception {
		try {
			UnvFaildataqueryDAO dao = (UnvFaildataqueryDAO) DAOFactory.build(
					UnvFaildataqueryDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public UnvFaildataqueryVO doUpdate(UnvFaildataqueryVO vo, User user)
			throws Exception {
		try {
			UnvFaildataqueryDAO dao = (UnvFaildataqueryDAO) DAOFactory.build(
					UnvFaildataqueryDAO.class, user);
			return (UnvFaildataqueryVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public UnvFaildataqueryVO doFindByPk(Serializable pk, User user)
			throws Exception {
		UnvFaildataqueryDAO dao = (UnvFaildataqueryDAO) DAOFactory.build(
				UnvFaildataqueryDAO.class, user);
		return (UnvFaildataqueryVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(UnvFaildataqueryListVO params, User user)
			throws Exception {
		UnvFaildataqueryDAO dao = (UnvFaildataqueryDAO) DAOFactory.build(
				UnvFaildataqueryDAO.class, user);
		return dao.queryByNamedSqlQuery("unvFaildataQuery", params);
	}

	public DataPackage doQueryWayName(UnvFaildataqueryListVO params, User user)
			throws Exception {
		UnvFaildataqueryDAO dao = (UnvFaildataqueryDAO) DAOFactory.build(
				UnvFaildataqueryDAO.class, user);
		return dao.doQueryWayIdName(params, user);
	}
}
