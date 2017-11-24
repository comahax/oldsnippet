/**
 * auto-generated code
 * Wed Jul 28 14:30:16 CST 2010
 */
package com.gmcc.pboss.control.reward.rewardlocalvalue;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.rewardlocalvalue.RewardlocalvalueDBParam;
import com.gmcc.pboss.business.reward.rewardlocalvalue.RewardlocalvalueDAO;
import com.gmcc.pboss.business.reward.rewardlocalvalue.RewardlocalvalueVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RewardlocalvalueBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class RewardlocalvalueBO extends AbstractControlBean implements
		Rewardlocalvalue {

	public RewardlocalvalueVO doCreate(RewardlocalvalueVO vo) throws Exception {
		try {
			RewardlocalvalueDAO dao = (RewardlocalvalueDAO) DAOFactory.build(RewardlocalvalueDAO.class, user);
			// TODO set the pk */
			return (RewardlocalvalueVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RewardlocalvalueVO vo) throws Exception {
		try {
			RewardlocalvalueDAO dao = (RewardlocalvalueDAO) DAOFactory.build(RewardlocalvalueDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RewardlocalvalueDAO dao = (RewardlocalvalueDAO) DAOFactory.build(RewardlocalvalueDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardlocalvalueVO doUpdate(RewardlocalvalueVO vo) throws Exception {
		try {
			RewardlocalvalueDAO dao = (RewardlocalvalueDAO) DAOFactory.build(RewardlocalvalueDAO.class,user);
			return (RewardlocalvalueVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardlocalvalueVO doFindByPk(Serializable pk) throws Exception {
		RewardlocalvalueDAO dao = (RewardlocalvalueDAO) DAOFactory.build(RewardlocalvalueDAO.class,user);
		return (RewardlocalvalueVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RewardlocalvalueDBParam params)
			throws Exception {
		RewardlocalvalueDAO dao = (RewardlocalvalueDAO) DAOFactory.build(RewardlocalvalueDAO.class,user);
		return dao.query(params);
	}
}
