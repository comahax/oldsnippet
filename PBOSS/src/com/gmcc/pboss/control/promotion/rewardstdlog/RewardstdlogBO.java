/**
 * auto-generated code
 * Mon Sep 14 16:40:25 CST 2009
 */
package com.gmcc.pboss.control.promotion.rewardstdlog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.rewardstdlog.RewardstdlogDBParam;
import com.gmcc.pboss.business.promotion.rewardstdlog.RewardstdlogDAO;
import com.gmcc.pboss.business.promotion.rewardstdlog.RewardstdlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RewardstdlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/rewardstdlog/control/RewardstdlogBO"
*    name="Rewardstdlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RewardstdlogBO extends AbstractControlBean implements
		Rewardstdlog {

	public RewardstdlogVO doCreate(RewardstdlogVO vo) throws Exception {
		try {
			RewardstdlogDAO dao = (RewardstdlogDAO) DAOFactory.build(RewardstdlogDAO.class, user);
			// TODO set the pk */
			return (RewardstdlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RewardstdlogVO vo) throws Exception {
		try {
			RewardstdlogDAO dao = (RewardstdlogDAO) DAOFactory.build(RewardstdlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RewardstdlogDAO dao = (RewardstdlogDAO) DAOFactory.build(RewardstdlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardstdlogVO doUpdate(RewardstdlogVO vo) throws Exception {
		try {
			RewardstdlogDAO dao = (RewardstdlogDAO) DAOFactory.build(RewardstdlogDAO.class,user);
			return (RewardstdlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardstdlogVO doFindByPk(Serializable pk) throws Exception {
		RewardstdlogDAO dao = (RewardstdlogDAO) DAOFactory.build(RewardstdlogDAO.class,user);
		return (RewardstdlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RewardstdlogDBParam params)
			throws Exception {
		RewardstdlogDAO dao = (RewardstdlogDAO) DAOFactory.build(RewardstdlogDAO.class,user);
		return dao.query(params);
	}
}
