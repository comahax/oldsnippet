package com.sunrise.boss.business.cms.reward.adtcode.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.reward.adtcode.persistent.AdtcodeDAO;
import com.sunrise.boss.business.cms.reward.adtcode.persistent.AdtcodeListVO;
import com.sunrise.boss.business.cms.reward.adtcode.persistent.AdtcodeVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/reward/adtcode/control/AdtcodeControlBean"
 *           name="AdtcodeControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class AdtcodeControlBean extends AbstractControlBean implements
	AdtcodeControl {
	
	private static final long serialVersionUID = -7511162432728797986L;

	public AdtcodeVO doCreate(AdtcodeVO vo, User user)
			throws Exception {
		try {
			AdtcodeDAO dao = (AdtcodeDAO) DAOFactory.build(
					AdtcodeDAO.class, user);
			return (AdtcodeVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(AdtcodeVO vo, User user) throws Exception {
		try {
			AdtcodeDAO dao = (AdtcodeDAO) DAOFactory.build(
					AdtcodeDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public AdtcodeVO doUpdate(AdtcodeVO vo, User user)
			throws Exception {
		try {
			AdtcodeDAO dao = (AdtcodeDAO) DAOFactory.build(
					AdtcodeDAO.class, user);
			return (AdtcodeVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public AdtcodeVO doFindByPk(Serializable pk, User user)
			throws Exception {
		AdtcodeDAO dao = (AdtcodeDAO) DAOFactory.build(
				AdtcodeDAO.class, user);
		return (AdtcodeVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(AdtcodeListVO params, User user)
			throws Exception {
		AdtcodeDAO dao = (AdtcodeDAO) DAOFactory.build(
				AdtcodeDAO.class, user);
		return dao.query(params);
	}
}
