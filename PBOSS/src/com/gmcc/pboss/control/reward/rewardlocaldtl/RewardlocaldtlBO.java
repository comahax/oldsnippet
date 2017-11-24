/**
 * auto-generated code
 * Wed Jul 28 14:29:18 CST 2010
 */
package com.gmcc.pboss.control.reward.rewardlocaldtl;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.rewardlocaldtl.RewardlocaldtlDBParam;
import com.gmcc.pboss.business.reward.rewardlocaldtl.RewardlocaldtlDAO;
import com.gmcc.pboss.business.reward.rewardlocaldtl.RewardlocaldtlVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RewardlocaldtlBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class RewardlocaldtlBO extends AbstractControlBean implements
		Rewardlocaldtl {

	public RewardlocaldtlVO doCreate(RewardlocaldtlVO vo) throws Exception {
		try {
			RewardlocaldtlDAO dao = (RewardlocaldtlDAO) DAOFactory.build(RewardlocaldtlDAO.class, user);
			// TODO set the pk */
			return (RewardlocaldtlVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RewardlocaldtlVO vo) throws Exception {
		try {
			RewardlocaldtlDAO dao = (RewardlocaldtlDAO) DAOFactory.build(RewardlocaldtlDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RewardlocaldtlDAO dao = (RewardlocaldtlDAO) DAOFactory.build(RewardlocaldtlDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardlocaldtlVO doUpdate(RewardlocaldtlVO vo) throws Exception {
		try {
			RewardlocaldtlDAO dao = (RewardlocaldtlDAO) DAOFactory.build(RewardlocaldtlDAO.class,user);
			return (RewardlocaldtlVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardlocaldtlVO doFindByPk(Serializable pk) throws Exception {
		RewardlocaldtlDAO dao = (RewardlocaldtlDAO) DAOFactory.build(RewardlocaldtlDAO.class,user);
		return (RewardlocaldtlVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RewardlocaldtlDBParam params)
			throws Exception {
		RewardlocaldtlDAO dao = (RewardlocaldtlDAO) DAOFactory.build(RewardlocaldtlDAO.class,user);
		return dao.query(params);
	}
}
