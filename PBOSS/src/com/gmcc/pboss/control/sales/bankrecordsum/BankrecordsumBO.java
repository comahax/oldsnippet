/**
 * auto-generated code
 * Tue Jan 17 09:43:50 CST 2012
 */
package com.gmcc.pboss.control.sales.bankrecordsum;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.bankrecordsum.BankrecordsumDBParam;
import com.gmcc.pboss.business.sales.bankrecordsum.BankrecordsumDAO;
import com.gmcc.pboss.business.sales.bankrecordsum.BankrecordsumVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: BankrecordsumBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class BankrecordsumBO extends AbstractControlBean implements
		Bankrecordsum {

	public BankrecordsumVO doCreate(BankrecordsumVO vo) throws Exception {
		try {
			BankrecordsumDAO dao = (BankrecordsumDAO) DAOFactory.build(BankrecordsumDAO.class, user);
			// TODO set the pk */
			return (BankrecordsumVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BankrecordsumVO vo) throws Exception {
		try {
			BankrecordsumDAO dao = (BankrecordsumDAO) DAOFactory.build(BankrecordsumDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BankrecordsumDAO dao = (BankrecordsumDAO) DAOFactory.build(BankrecordsumDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BankrecordsumVO doUpdate(BankrecordsumVO vo) throws Exception {
		try {
			BankrecordsumDAO dao = (BankrecordsumDAO) DAOFactory.build(BankrecordsumDAO.class,user);
			return (BankrecordsumVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BankrecordsumVO doFindByPk(Serializable pk) throws Exception {
		BankrecordsumDAO dao = (BankrecordsumDAO) DAOFactory.build(BankrecordsumDAO.class,user);
		return (BankrecordsumVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BankrecordsumDBParam params)
			throws Exception {
		BankrecordsumDAO dao = (BankrecordsumDAO) DAOFactory.build(BankrecordsumDAO.class,user);
		return dao.query(params);
	}
}
