/**
 * auto-generated code
 * Mon Sep 14 16:39:35 CST 2009
 */
package com.gmcc.pboss.control.promotion.rewardstd;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.rewardstd.RewardstdDBParam;
import com.gmcc.pboss.business.promotion.rewardstd.RewardstdDAO;
import com.gmcc.pboss.business.promotion.rewardstd.RewardstdVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RewardstdBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/rewardstd/control/RewardstdBO"
*    name="Rewardstd"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RewardstdBO extends AbstractControlBean implements
		Rewardstd {

	public RewardstdVO doCreate(RewardstdVO vo) throws Exception {
		try {
			RewardstdDAO dao = (RewardstdDAO) DAOFactory.build(RewardstdDAO.class, user);
			// TODO set the pk */
			return (RewardstdVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RewardstdVO vo) throws Exception {
		try {
			RewardstdDAO dao = (RewardstdDAO) DAOFactory.build(RewardstdDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RewardstdDAO dao = (RewardstdDAO) DAOFactory.build(RewardstdDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardstdVO doUpdate(RewardstdVO vo) throws Exception {
		try {
			RewardstdDAO dao = (RewardstdDAO) DAOFactory.build(RewardstdDAO.class,user);
			return (RewardstdVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardstdVO doFindByPk(Serializable pk) throws Exception {
		RewardstdDAO dao = (RewardstdDAO) DAOFactory.build(RewardstdDAO.class,user);
		return (RewardstdVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RewardstdDBParam params)
			throws Exception {
		RewardstdDAO dao = (RewardstdDAO) DAOFactory.build(RewardstdDAO.class,user);
		return dao.query(params);
	}
}
