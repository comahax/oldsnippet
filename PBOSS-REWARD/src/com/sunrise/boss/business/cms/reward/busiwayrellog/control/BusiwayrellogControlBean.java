/**
 * auto-generated code
 * Mon Jan 05 11:36:43 CST 2009
 */
package com.sunrise.boss.business.cms.reward.busiwayrellog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busiwayrellog.persistent.BusiwayrellogVO;
import com.sunrise.boss.business.cms.reward.busiwayrellog.persistent.BusiwayrellogDAO;
import com.sunrise.boss.business.cms.reward.busiwayrellog.persistent.BusiwayrellogListVO;

/**
 * <p>Title: BusiwayrellogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/busiwayrellog/control/BusiwayrellogControlBean"
 name="BusiwayrellogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
 */
public class BusiwayrellogControlBean extends AbstractControlBean implements
		BusiwayrellogControl {

	public BusiwayrellogVO doCreate(BusiwayrellogVO vo, User user)
			throws Exception {
		try {
			BusiwayrellogDAO dao = (BusiwayrellogDAO) DAOFactory.build(
					BusiwayrellogDAO.class, user);
			// TODO  set the pk */
			return (BusiwayrellogVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(BusiwayrellogVO vo, User user) throws Exception {
		try {
			BusiwayrellogDAO dao = (BusiwayrellogDAO) DAOFactory.build(
					BusiwayrellogDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BusiwayrellogVO doUpdate(BusiwayrellogVO vo, User user)
			throws Exception {
		try {
			BusiwayrellogDAO dao = (BusiwayrellogDAO) DAOFactory.build(
					BusiwayrellogDAO.class, user);
			return (BusiwayrellogVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BusiwayrellogVO doFindByPk(Serializable pk, User user)
			throws Exception {
		BusiwayrellogDAO dao = (BusiwayrellogDAO) DAOFactory.build(
				BusiwayrellogDAO.class, user);
		return (BusiwayrellogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BusiwayrellogListVO params, User user)
			throws Exception {
		BusiwayrellogDAO dao = (BusiwayrellogDAO) DAOFactory.build(
				BusiwayrellogDAO.class, user);
		return dao.query(params);
	}
}
