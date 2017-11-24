/**
 * auto-generated code
 * Wed Mar 05 16:44:25 CST 2008
 */
package com.sunrise.boss.business.cms.reward.stdrewardbjlog.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.reward.stdrewardbjlog.persistent.StdrewardbjlogDAO;
import com.sunrise.boss.business.cms.reward.stdrewardbjlog.persistent.StdrewardbjlogListVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjlog.persistent.StdrewardbjlogVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: StdrewardbjlogControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/reward/stdrewardbjlog/control/StdrewardbjlogControlBean"
 *           name="StdrewardbjlogControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class StdrewardbjlogControlBean extends AbstractControlBean implements
		StdrewardbjlogControl {

	public StdrewardbjlogVO doCreate(StdrewardbjlogVO vo, User user)
			throws Exception {
		try {
			// TODO set the pk */
			StdrewardbjlogDAO dao = (StdrewardbjlogDAO) DAOFactory.build(
					StdrewardbjlogDAO.class, user);
			return (StdrewardbjlogVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(StdrewardbjlogVO vo, User user) throws Exception {
		try {
			StdrewardbjlogDAO dao = (StdrewardbjlogDAO) DAOFactory.build(
					StdrewardbjlogDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardbjlogVO doUpdate(StdrewardbjlogVO vo, User user)
			throws Exception {
		try {
			StdrewardbjlogDAO dao = (StdrewardbjlogDAO) DAOFactory.build(
					StdrewardbjlogDAO.class, user);
			return (StdrewardbjlogVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardbjlogVO doFindByPk(Serializable pk, User user)
			throws Exception {
		StdrewardbjlogDAO dao = (StdrewardbjlogDAO) DAOFactory.build(
				StdrewardbjlogDAO.class, user);
		return (StdrewardbjlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(StdrewardbjlogListVO params, User user)
			throws Exception {
		StdrewardbjlogDAO dao = (StdrewardbjlogDAO) DAOFactory.build(
				StdrewardbjlogDAO.class, user);
		return dao.query(params);
	}
}
