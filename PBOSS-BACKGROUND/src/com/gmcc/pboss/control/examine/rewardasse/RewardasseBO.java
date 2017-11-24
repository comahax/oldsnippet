package com.gmcc.pboss.control.examine.rewardasse;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.rewardasse.RewardasseDBParam;
import com.gmcc.pboss.business.cms.examine.rewardasse.RewardasseDAO;
import com.gmcc.pboss.business.cms.examine.rewardasse.RewardasseVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: RewardasseBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class RewardasseBO extends AbstractControlBean implements
		Rewardasse {

	public RewardasseVO doCreate(RewardasseVO vo) throws Exception {
		try {
			RewardasseDAO dao = (RewardasseDAO) DAOFactory.build(RewardasseDAO.class, user);
			// TODO set the pk */
			return (RewardasseVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RewardasseVO vo) throws Exception {
		try {
			RewardasseDAO dao = (RewardasseDAO) DAOFactory.build(RewardasseDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RewardasseDAO dao = (RewardasseDAO) DAOFactory.build(RewardasseDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardasseVO doUpdate(RewardasseVO vo) throws Exception {
		try {
			RewardasseDAO dao = (RewardasseDAO) DAOFactory.build(RewardasseDAO.class,user);
			return (RewardasseVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardasseVO doFindByPk(Serializable pk) throws Exception {
		RewardasseDAO dao = (RewardasseDAO) DAOFactory.build(RewardasseDAO.class,user);
		return (RewardasseVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RewardasseDBParam params)
			throws Exception {
		RewardasseDAO dao = (RewardasseDAO) DAOFactory.build(RewardasseDAO.class,user);
		return dao.query(params);
	}
}
