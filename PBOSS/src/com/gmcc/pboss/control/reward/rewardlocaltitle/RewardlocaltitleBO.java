/**
 * auto-generated code
 * Wed Jul 28 14:27:43 CST 2010
 */
package com.gmcc.pboss.control.reward.rewardlocaltitle;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.rewardlocaltitle.RewardlocaltitleDBParam;
import com.gmcc.pboss.business.reward.rewardlocaltitle.RewardlocaltitleDAO;
import com.gmcc.pboss.business.reward.rewardlocaltitle.RewardlocaltitleVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RewardlocaltitleBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class RewardlocaltitleBO extends AbstractControlBean implements
		Rewardlocaltitle {

	public RewardlocaltitleVO doCreate(RewardlocaltitleVO vo) throws Exception {
		try {
			RewardlocaltitleDAO dao = (RewardlocaltitleDAO) DAOFactory.build(RewardlocaltitleDAO.class, user);
			// TODO set the pk */
			return (RewardlocaltitleVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RewardlocaltitleVO vo) throws Exception {
		try {
			RewardlocaltitleDAO dao = (RewardlocaltitleDAO) DAOFactory.build(RewardlocaltitleDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RewardlocaltitleDAO dao = (RewardlocaltitleDAO) DAOFactory.build(RewardlocaltitleDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardlocaltitleVO doUpdate(RewardlocaltitleVO vo) throws Exception {
		try {
			RewardlocaltitleDAO dao = (RewardlocaltitleDAO) DAOFactory.build(RewardlocaltitleDAO.class,user);
			return (RewardlocaltitleVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardlocaltitleVO doFindByPk(Serializable pk) throws Exception {
		RewardlocaltitleDAO dao = (RewardlocaltitleDAO) DAOFactory.build(RewardlocaltitleDAO.class,user);
		return (RewardlocaltitleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RewardlocaltitleDBParam params)
			throws Exception {
		RewardlocaltitleDAO dao = (RewardlocaltitleDAO) DAOFactory.build(RewardlocaltitleDAO.class,user);
		return dao.query(params);
	}
}
