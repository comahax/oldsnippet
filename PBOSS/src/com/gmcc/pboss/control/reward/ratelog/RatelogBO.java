package com.gmcc.pboss.control.reward.ratelog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.ratelog.RatelogDAO;
import com.gmcc.pboss.business.reward.ratelog.RatelogDBParam;
import com.gmcc.pboss.business.reward.ratelog.RatelogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RatelogBO </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class RatelogBO extends AbstractControlBean implements Ratelog {

	public RatelogVO doCreate(RatelogVO vo) throws Exception {
		try {
			RatelogDAO dao = (RatelogDAO) DAOFactory.build(RatelogDAO.class, user);
			// TODO set the pk */
			return (RatelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RatelogVO vo) throws Exception {
		try {
			RatelogDAO dao = (RatelogDAO) DAOFactory.build(RatelogDAO.class,user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RatelogDAO dao = (RatelogDAO) DAOFactory.build(RatelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RatelogVO doUpdate(RatelogVO vo) throws Exception {
		try {
			RatelogDAO dao = (RatelogDAO) DAOFactory.build(RatelogDAO.class,user);
			return (RatelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RatelogVO doFindByPk(Serializable pk) throws Exception {
		try {
			RatelogDAO dao = (RatelogDAO) DAOFactory.build(RatelogDAO.class,user);
			return (RatelogVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(RatelogDBParam params) throws Exception {
		try {
			RatelogDAO dao = (RatelogDAO) DAOFactory.build(RatelogDAO.class,user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
}
