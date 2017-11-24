/**
 * auto-generated code
 * Thu Sep 09 16:14:40 CST 2010
 */
package com.gmcc.pboss.control.channel.bank;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.bank.BankDBParam;
import com.gmcc.pboss.business.channel.bank.BankDAO;
import com.gmcc.pboss.business.channel.bank.BankVO;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductDAO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: BankBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class BankBO extends AbstractControlBean implements
		Bank {

	public BankVO doCreate(BankVO vo) throws Exception {
		try {
			BankDAO dao = (BankDAO) DAOFactory.build(BankDAO.class, user);
			// TODO set the pk */
			return (BankVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BankVO vo) throws Exception {
		try {
			BankDAO dao = (BankDAO) DAOFactory.build(BankDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BankDAO dao = (BankDAO) DAOFactory.build(BankDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BankVO doUpdate(BankVO vo) throws Exception {
		try {
			BankDAO dao = (BankDAO) DAOFactory.build(BankDAO.class,user);
			return (BankVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BankVO doFindByPk(Serializable pk) throws Exception {
		BankDAO dao = (BankDAO) DAOFactory.build(BankDAO.class,user);
		return (BankVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BankDBParam params)
			throws Exception {
		BankDAO dao = (BankDAO) DAOFactory.build(BankDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doQueryBank(BankDBParam params) throws Exception {
		BankDAO dao = (BankDAO) DAOFactory.build(BankDAO.class,user);
		params.getQueryConditions().put("cityid", user.getCityid());
		return dao.queryByNamedSqlQuery("base.bank.querybank", params);
	}
}
