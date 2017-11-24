package com.gmcc.pboss.control.reward.paymentlog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.paymentlog.PaymentlogDAO;
import com.gmcc.pboss.business.reward.paymentlog.PaymentlogDBParam;
import com.gmcc.pboss.business.reward.paymentlog.PaymentlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PaymentlogBO </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class PaymentlogBO extends AbstractControlBean implements Paymentlog {

	public PaymentlogVO doCreate(PaymentlogVO vo) throws Exception {
		try {
			PaymentlogDAO dao = (PaymentlogDAO) DAOFactory.build(PaymentlogDAO.class, user);
			// TODO set the pk */
			return (PaymentlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PaymentlogVO vo) throws Exception {
		try {
			PaymentlogDAO dao = (PaymentlogDAO) DAOFactory.build(PaymentlogDAO.class,user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PaymentlogDAO dao = (PaymentlogDAO) DAOFactory.build(PaymentlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PaymentlogVO doUpdate(PaymentlogVO vo) throws Exception {
		try {
			PaymentlogDAO dao = (PaymentlogDAO) DAOFactory.build(PaymentlogDAO.class,user);
			return (PaymentlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PaymentlogVO doFindByPk(Serializable pk) throws Exception {
		try {
			PaymentlogDAO dao = (PaymentlogDAO) DAOFactory.build(PaymentlogDAO.class,user);
			return (PaymentlogVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(PaymentlogDBParam params) throws Exception {
		try {
			PaymentlogDAO dao = (PaymentlogDAO) DAOFactory.build(PaymentlogDAO.class,user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
}
