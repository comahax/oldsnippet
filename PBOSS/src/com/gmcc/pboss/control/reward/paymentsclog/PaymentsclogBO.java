package com.gmcc.pboss.control.reward.paymentsclog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.paymentsclog.PaymentsclogDAO;
import com.gmcc.pboss.business.reward.paymentsclog.PaymentsclogDBParam;
import com.gmcc.pboss.business.reward.paymentsclog.PaymentsclogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PaymentsclogBO </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class PaymentsclogBO extends AbstractControlBean implements Paymentsclog {

	public PaymentsclogVO doCreate(PaymentsclogVO vo) throws Exception {
		try {
			PaymentsclogDAO dao = (PaymentsclogDAO) DAOFactory.build(PaymentsclogDAO.class, user);
			// TODO set the pk */
			return (PaymentsclogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PaymentsclogVO vo) throws Exception {
		try {
			PaymentsclogDAO dao = (PaymentsclogDAO) DAOFactory.build(PaymentsclogDAO.class,user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PaymentsclogDAO dao = (PaymentsclogDAO) DAOFactory.build(PaymentsclogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PaymentsclogVO doUpdate(PaymentsclogVO vo) throws Exception {
		try {
			PaymentsclogDAO dao = (PaymentsclogDAO) DAOFactory.build(PaymentsclogDAO.class,user);
			return (PaymentsclogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PaymentsclogVO doFindByPk(Serializable pk) throws Exception {
		try {
			PaymentsclogDAO dao = (PaymentsclogDAO) DAOFactory.build(PaymentsclogDAO.class,user);
			return (PaymentsclogVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(PaymentsclogDBParam params) throws Exception {
		try {
			PaymentsclogDAO dao = (PaymentsclogDAO) DAOFactory.build(PaymentsclogDAO.class,user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
}
