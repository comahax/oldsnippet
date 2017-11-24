/**
 * auto-generated code
 * Thu Nov 15 12:26:36 CST 2007
 */
package com.sunrise.boss.business.zifee.feediscmolog.control;

import java.io.Serializable;

import com.sunrise.boss.business.zifee.feediscmolog.persistent.FeediscmologDAO;
import com.sunrise.boss.business.zifee.feediscmolog.persistent.FeediscmologListVO;
import com.sunrise.boss.business.zifee.feediscmolog.persistent.FeediscmologVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: FeediscmologControlBean
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
 * @author zeng jianxin
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/zifee/feediscmolog/control/FeediscmologControlBean"
 *           name="FeediscmologControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class FeediscmologControlBean extends AbstractControlBean implements
		FeediscmologControl {

	public FeediscmologVO doCreate(FeediscmologVO vo, User user)
			throws Exception {
		try {
			// TODO set the pk */
			FeediscmologDAO dao = (FeediscmologDAO) DAOFactory.build(
					FeediscmologDAO.class, user);
			return (FeediscmologVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(FeediscmologVO vo, User user) throws Exception {
		try {
			FeediscmologDAO dao = (FeediscmologDAO) DAOFactory.build(
					FeediscmologDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public FeediscmologVO doUpdate(FeediscmologVO vo, User user)
			throws Exception {
		try {
			FeediscmologDAO dao = (FeediscmologDAO) DAOFactory.build(
					FeediscmologDAO.class, user);
			return (FeediscmologVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public FeediscmologVO doFindByPk(Serializable pk, User user)
			throws Exception {
		FeediscmologDAO dao = (FeediscmologDAO) DAOFactory.build(
				FeediscmologDAO.class, user);
		return (FeediscmologVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(FeediscmologListVO params, User user)
			throws Exception {
		FeediscmologDAO dao = (FeediscmologDAO) DAOFactory.build(
				FeediscmologDAO.class, user);
		if (!"".equals(params.get_sk_discbill())
				&& params.get_sk_discbill() != null) {
			params.set_sk_discbill(params.get_sk_discbill()
					.replaceAll(" ", "%"));
		}
		if (!"".equals(params.get_sk_excludebill())
				&& params.get_sk_excludebill() != null) {
			params.set_sk_excludebill(params.get_sk_excludebill().replaceAll(
					" ", "%"));
		}
		return dao.query(params);
	}
}
