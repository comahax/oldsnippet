/**
 * auto-generated code
 * Thu Apr 10 14:34:42 CST 2014
 */
package com.gmcc.pboss.control.base.rewardsendsms;

import java.io.Serializable;

import com.gmcc.pboss.business.base.rewardsendsms.RewardsendsmsDBParam;
import com.gmcc.pboss.business.base.rewardsendsms.RewardsendsmsDAO;
import com.gmcc.pboss.business.base.rewardsendsms.RewardsendsmsVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: RewardsendsmsBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardsendsmsBO extends AbstractControlBean implements
		Rewardsendsms {

	public RewardsendsmsVO doCreate(RewardsendsmsVO vo) throws Exception {
		try {
			RewardsendsmsDAO dao = (RewardsendsmsDAO) DAOFactory.build(RewardsendsmsDAO.class, user);
			// TODO set the pk */
			return (RewardsendsmsVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RewardsendsmsVO vo) throws Exception {
		try {
			RewardsendsmsDAO dao = (RewardsendsmsDAO) DAOFactory.build(RewardsendsmsDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RewardsendsmsDAO dao = (RewardsendsmsDAO) DAOFactory.build(RewardsendsmsDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardsendsmsVO doUpdate(RewardsendsmsVO vo) throws Exception {
		try {
			RewardsendsmsDAO dao = (RewardsendsmsDAO) DAOFactory.build(RewardsendsmsDAO.class,user);
			return (RewardsendsmsVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardsendsmsVO doFindByPk(Serializable pk) throws Exception {
		RewardsendsmsDAO dao = (RewardsendsmsDAO) DAOFactory.build(RewardsendsmsDAO.class,user);
		return (RewardsendsmsVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RewardsendsmsDBParam params)
			throws Exception {
		RewardsendsmsDAO dao = (RewardsendsmsDAO) DAOFactory.build(RewardsendsmsDAO.class,user);
		return dao.query(params);
	}
}
