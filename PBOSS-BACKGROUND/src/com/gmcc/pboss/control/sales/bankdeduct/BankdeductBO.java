package com.gmcc.pboss.control.sales.bankdeduct;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.bankdeduct.BankdeductDAO;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductDBParam;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: BankdeductBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BankdeductBO extends AbstractControlBean implements
		Bankdeduct {

	public BankdeductVO doCreate(BankdeductVO vo) throws Exception {
		try {
			BankdeductDAO dao = (BankdeductDAO) DAOFactory.build(BankdeductDAO.class, user);
			// TODO set the pk */
			return (BankdeductVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BankdeductVO vo) throws Exception {
		try {
			BankdeductDAO dao = (BankdeductDAO) DAOFactory.build(BankdeductDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BankdeductDAO dao = (BankdeductDAO) DAOFactory.build(BankdeductDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BankdeductVO doUpdate(BankdeductVO vo) throws Exception {
		try {
			BankdeductDAO dao = (BankdeductDAO) DAOFactory.build(BankdeductDAO.class, user);
			return (BankdeductVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BankdeductVO doFindByPk(Serializable pk) throws Exception {
		BankdeductDAO dao = (BankdeductDAO) DAOFactory.build(BankdeductDAO.class, user);
		return (BankdeductVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BankdeductDBParam params)
			throws Exception {
		BankdeductDAO dao = (BankdeductDAO) DAOFactory.build(BankdeductDAO.class, user);
		return dao.query(params);
	}
}
