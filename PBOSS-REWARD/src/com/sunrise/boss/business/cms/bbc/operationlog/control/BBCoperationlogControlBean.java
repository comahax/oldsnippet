/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
package com.sunrise.boss.business.cms.bbc.operationlog.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.operationlog.persistent.BBCoperationlogDAO;
import com.sunrise.boss.business.cms.bbc.operationlog.persistent.BBCoperationlogListVO;
import com.sunrise.boss.business.cms.bbc.operationlog.persistent.BBCoperationlogVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: BBCoperationlogControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/bbc/operationlog/control/BBCoperationlogControlBean"
 *           name="BBCoperationlogControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class BBCoperationlogControlBean extends AbstractControlBean implements
		BBCoperationlogControl {

	public BBCoperationlogVO doCreate(BBCoperationlogVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			BBCoperationlogDAO dao = (BBCoperationlogDAO) DAOFactory.build(
					BBCoperationlogDAO.class, user);
			return (BBCoperationlogVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(BBCoperationlogVO vo, User user) throws Exception {
		try {
			BBCoperationlogDAO dao = (BBCoperationlogDAO) DAOFactory.build(
					BBCoperationlogDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BBCoperationlogVO doUpdate(BBCoperationlogVO vo, User user) throws Exception {
		try {
			BBCoperationlogDAO dao = (BBCoperationlogDAO) DAOFactory.build(
					BBCoperationlogDAO.class, user);
			return (BBCoperationlogVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BBCoperationlogVO doFindByPk(Serializable pk, User user) throws Exception {
		BBCoperationlogDAO dao = (BBCoperationlogDAO) DAOFactory.build(
				BBCoperationlogDAO.class, user);
		return (BBCoperationlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BBCoperationlogListVO params, User user)
			throws Exception {
		BBCoperationlogDAO dao = (BBCoperationlogDAO) DAOFactory.build(
				BBCoperationlogDAO.class, user);
		return dao.query(params);
	}

}


