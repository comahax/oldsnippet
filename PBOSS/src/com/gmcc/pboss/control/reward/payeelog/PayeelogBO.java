package com.gmcc.pboss.control.reward.payeelog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.payeelog.PayeelogDAO;
import com.gmcc.pboss.business.reward.payeelog.PayeelogDBParam;
import com.gmcc.pboss.business.reward.payeelog.PayeelogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PayeelogBO </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class PayeelogBO extends AbstractControlBean implements Payeelog {

	public PayeelogVO doCreate(PayeelogVO vo) throws Exception {
		try {
			PayeelogDAO dao = (PayeelogDAO) DAOFactory.build(PayeelogDAO.class, user);
			// TODO set the pk */
			return (PayeelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PayeelogVO vo) throws Exception {
		try {
			PayeelogDAO dao = (PayeelogDAO) DAOFactory.build(PayeelogDAO.class,user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PayeelogDAO dao = (PayeelogDAO) DAOFactory.build(PayeelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PayeelogVO doUpdate(PayeelogVO vo) throws Exception {
		try {
			PayeelogDAO dao = (PayeelogDAO) DAOFactory.build(PayeelogDAO.class,user);
			return (PayeelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PayeelogVO doFindByPk(Serializable pk) throws Exception {
		try {
			PayeelogDAO dao = (PayeelogDAO) DAOFactory.build(PayeelogDAO.class,user);
			return (PayeelogVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(PayeelogDBParam params) throws Exception {
		try {
			PayeelogDAO dao = (PayeelogDAO) DAOFactory.build(PayeelogDAO.class,user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
}
