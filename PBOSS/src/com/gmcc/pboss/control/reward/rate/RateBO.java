package com.gmcc.pboss.control.reward.rate;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.rate.RateDAO;
import com.gmcc.pboss.business.reward.rate.RateDBParam;
import com.gmcc.pboss.business.reward.rate.RateVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RateBO </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class RateBO extends AbstractControlBean implements Rate {

	public RateVO doCreate(RateVO vo) throws Exception {
		try {
			RateDAO dao = (RateDAO) DAOFactory.build(RateDAO.class, user);
			// TODO set the pk */
			return (RateVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RateVO vo) throws Exception {
		try {
			RateDAO dao = (RateDAO) DAOFactory.build(RateDAO.class,user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RateDAO dao = (RateDAO) DAOFactory.build(RateDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RateVO doUpdate(RateVO vo) throws Exception {
		try {
			RateDAO dao = (RateDAO) DAOFactory.build(RateDAO.class,user);
			return (RateVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RateVO doFindByPk(Serializable pk) throws Exception {
		try {
			RateDAO dao = (RateDAO) DAOFactory.build(RateDAO.class,user);
			return (RateVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(RateDBParam params) throws Exception {
		try {
			RateDAO dao = (RateDAO) DAOFactory.build(RateDAO.class,user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
}
