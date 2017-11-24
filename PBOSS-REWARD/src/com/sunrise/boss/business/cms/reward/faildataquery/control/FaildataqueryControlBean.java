package com.sunrise.boss.business.cms.reward.faildataquery.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.reward.faildataquery.persistent.FaildataqueryDAO;
import com.sunrise.boss.business.cms.reward.faildataquery.persistent.FaildataqueryListVO;
import com.sunrise.boss.business.cms.reward.faildataquery.persistent.FaildataqueryVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/reward/faildataquery/control/FaildataqueryControlBean"
 *           name="FaildataqueryControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class FaildataqueryControlBean extends AbstractControlBean implements
	FaildataqueryControl {
	
	private static final long serialVersionUID = -7511162432728797986L;

	public FaildataqueryVO doCreate(FaildataqueryVO vo, User user)
			throws Exception {
		try {
			FaildataqueryDAO dao = (FaildataqueryDAO) DAOFactory.build(
					FaildataqueryDAO.class, user);
			return (FaildataqueryVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(FaildataqueryVO vo, User user) throws Exception {
		try {
			FaildataqueryDAO dao = (FaildataqueryDAO) DAOFactory.build(
					FaildataqueryDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public FaildataqueryVO doUpdate(FaildataqueryVO vo, User user)
			throws Exception {
		try {
			FaildataqueryDAO dao = (FaildataqueryDAO) DAOFactory.build(
					FaildataqueryDAO.class, user);
			return (FaildataqueryVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public FaildataqueryVO doFindByPk(Serializable pk, User user)
			throws Exception {
		FaildataqueryDAO dao = (FaildataqueryDAO) DAOFactory.build(
				FaildataqueryDAO.class, user);
		return (FaildataqueryVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(FaildataqueryListVO params, User user)
			throws Exception {
		FaildataqueryDAO dao = (FaildataqueryDAO) DAOFactory.build(
				FaildataqueryDAO.class, user);
		return dao.doQuery(params);
	}
}
