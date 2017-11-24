package com.gmcc.pboss.control.reward.payway;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.payment.PaymentDBParam;
import com.gmcc.pboss.business.reward.payment.VPaymentDAO;
import com.gmcc.pboss.business.reward.payway.PaywayDAO;
import com.gmcc.pboss.business.reward.payway.PaywayDBParam;
import com.gmcc.pboss.business.reward.payway.PaywayVO;
import com.gmcc.pboss.business.reward.payway.VPaywayDAO;
import com.gmcc.pboss.business.reward.payway.VWayDAO;
import com.gmcc.pboss.control.reward.payway.Payway;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class PaywayBO extends AbstractControlBean implements Payway {
	public PaywayVO doCreate(PaywayVO vo) throws Exception {
		try {
			PaywayDAO dao = (PaywayDAO) DAOFactory.build(PaywayDAO.class, user);
			// TODO set the pk */
			return (PaywayVO) dao.saveOrUpdate(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PaywayVO vo) throws Exception {
		try {
			PaywayDAO dao = (PaywayDAO) DAOFactory.build(PaywayDAO.class, user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PaywayDAO dao = (PaywayDAO) DAOFactory.build(PaywayDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PaywayVO doUpdate(PaywayVO vo) throws Exception {
		try {
			PaywayDAO dao = (PaywayDAO) DAOFactory.build(PaywayDAO.class, user);
			return (PaywayVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PaywayVO doFindByPk(Serializable pk) throws Exception {
		try {
			PaywayDAO dao = (PaywayDAO) DAOFactory.build(PaywayDAO.class, user);
			return (PaywayVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(PaywayDBParam params) throws Exception {
		try {
			PaywayDAO dao = (PaywayDAO) DAOFactory.build(PaywayDAO.class, user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQueryBySql(PaywayDBParam params, String qrySql)
			throws Exception {
		try {
			VPaywayDAO dao = (VPaywayDAO) DAOFactory.build(VPaywayDAO.class,
					user);
			DataPackage dp = dao.queryByNamedSqlQuery(qrySql, params);
			return dp;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	public DataPackage doQueryVWayBySql(PaywayDBParam params, String qrySql)
			throws Exception {
		try {
			VWayDAO dao = (VWayDAO) DAOFactory.build(VWayDAO.class, user);
			DataPackage dp = dao.queryByNamedSqlQuery(qrySql, params);
			return dp;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}
}
