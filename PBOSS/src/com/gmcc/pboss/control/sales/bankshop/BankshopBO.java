/**
 * auto-generated code
 * Mon Aug 23 12:07:17 CST 2010
 */
package com.gmcc.pboss.control.sales.bankshop;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.bankshop.BankshopDBParam;
import com.gmcc.pboss.business.sales.bankshop.BankshopDAO;
import com.gmcc.pboss.business.sales.bankshop.BankshopVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: BankshopBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class BankshopBO extends AbstractControlBean implements
		Bankshop {

	public BankshopVO doCreate(BankshopVO vo) throws Exception {
		try {
			BankshopDAO dao = (BankshopDAO) DAOFactory.build(BankshopDAO.class, user);
			// TODO set the pk */
			return (BankshopVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BankshopVO vo) throws Exception {
		try {
			BankshopDAO dao = (BankshopDAO) DAOFactory.build(BankshopDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BankshopDAO dao = (BankshopDAO) DAOFactory.build(BankshopDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BankshopVO doUpdate(BankshopVO vo) throws Exception {
		try {
			BankshopDAO dao = (BankshopDAO) DAOFactory.build(BankshopDAO.class,user);
			return (BankshopVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BankshopVO doFindByPk(Serializable pk) throws Exception {
		BankshopDAO dao = (BankshopDAO) DAOFactory.build(BankshopDAO.class,user);
		return (BankshopVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BankshopDBParam params)
			throws Exception {
		BankshopDAO dao = (BankshopDAO) DAOFactory.build(BankshopDAO.class,user);
		return dao.query(params);
	}
}
