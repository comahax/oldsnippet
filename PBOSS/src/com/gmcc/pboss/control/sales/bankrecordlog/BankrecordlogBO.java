/**
 * auto-generated code
 * Tue Jan 17 09:54:18 CST 2012
 */
package com.gmcc.pboss.control.sales.bankrecordlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.bankrecordlog.BankrecordlogDBParam;
import com.gmcc.pboss.business.sales.bankrecordlog.BankrecordlogDAO;
import com.gmcc.pboss.business.sales.bankrecordlog.BankrecordlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: BankrecordlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class BankrecordlogBO extends AbstractControlBean implements
		Bankrecordlog {

	public BankrecordlogVO doCreate(BankrecordlogVO vo) throws Exception {
		try {
			BankrecordlogDAO dao = (BankrecordlogDAO) DAOFactory.build(BankrecordlogDAO.class, user);
			// TODO set the pk */
			return (BankrecordlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BankrecordlogVO vo) throws Exception {
		try {
			BankrecordlogDAO dao = (BankrecordlogDAO) DAOFactory.build(BankrecordlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BankrecordlogDAO dao = (BankrecordlogDAO) DAOFactory.build(BankrecordlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BankrecordlogVO doUpdate(BankrecordlogVO vo) throws Exception {
		try {
			BankrecordlogDAO dao = (BankrecordlogDAO) DAOFactory.build(BankrecordlogDAO.class,user);
			return (BankrecordlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BankrecordlogVO doFindByPk(Serializable pk) throws Exception {
		BankrecordlogDAO dao = (BankrecordlogDAO) DAOFactory.build(BankrecordlogDAO.class,user);
		return (BankrecordlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BankrecordlogDBParam params)
			throws Exception {
		BankrecordlogDAO dao = (BankrecordlogDAO) DAOFactory.build(BankrecordlogDAO.class,user);
		return dao.query(params);
	}
}
