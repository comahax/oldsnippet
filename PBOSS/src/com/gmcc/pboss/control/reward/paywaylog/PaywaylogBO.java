package com.gmcc.pboss.control.reward.paywaylog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.paywaylog.PaywaylogDAO;
import com.gmcc.pboss.business.reward.paywaylog.PaywaylogDBParam;
import com.gmcc.pboss.business.reward.paywaylog.PaywaylogVO;
import com.gmcc.pboss.control.reward.paywaylog.Paywaylog;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class PaywaylogBO  extends AbstractControlBean implements Paywaylog {

	public PaywaylogVO doCreate(PaywaylogVO vo) throws Exception {
		try {
			PaywaylogDAO dao = (PaywaylogDAO) DAOFactory.build(PaywaylogDAO.class, user);
			// TODO set the pk */
			return (PaywaylogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PaywaylogVO vo) throws Exception {
		try {
			PaywaylogDAO dao = (PaywaylogDAO) DAOFactory.build(PaywaylogDAO.class,user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PaywaylogDAO dao = (PaywaylogDAO) DAOFactory.build(PaywaylogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PaywaylogVO doUpdate(PaywaylogVO vo) throws Exception {
		try {
			PaywaylogDAO dao = (PaywaylogDAO) DAOFactory.build(PaywaylogDAO.class,user);
			return (PaywaylogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PaywaylogVO doFindByPk(Serializable pk) throws Exception {
		try {
			PaywaylogDAO dao = (PaywaylogDAO) DAOFactory.build(PaywaylogDAO.class,user);
			return (PaywaylogVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(PaywaylogDBParam params) throws Exception {
		try {
			PaywaylogDAO dao = (PaywaylogDAO) DAOFactory.build(PaywaylogDAO.class,user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}

}
