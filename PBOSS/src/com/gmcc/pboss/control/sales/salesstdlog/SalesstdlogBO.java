/**
 * auto-generated code
 * Wed Oct 26 09:57:14 CST 2011
 */
package com.gmcc.pboss.control.sales.salesstdlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.salesstdlog.SalesstdlogDBParam;
import com.gmcc.pboss.business.sales.salesstdlog.SalesstdlogDAO;
import com.gmcc.pboss.business.sales.salesstdlog.SalesstdlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: SalesstdlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SalesstdlogBO extends AbstractControlBean implements
		Salesstdlog {

	public SalesstdlogVO doCreate(SalesstdlogVO vo) throws Exception {
		try {
			SalesstdlogDAO dao = (SalesstdlogDAO) DAOFactory.build(SalesstdlogDAO.class, user);
			// TODO set the pk */
			return (SalesstdlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SalesstdlogVO vo) throws Exception {
		try {
			SalesstdlogDAO dao = (SalesstdlogDAO) DAOFactory.build(SalesstdlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SalesstdlogDAO dao = (SalesstdlogDAO) DAOFactory.build(SalesstdlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SalesstdlogVO doUpdate(SalesstdlogVO vo) throws Exception {
		try {
			SalesstdlogDAO dao = (SalesstdlogDAO) DAOFactory.build(SalesstdlogDAO.class,user);
			return (SalesstdlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SalesstdlogVO doFindByPk(Serializable pk) throws Exception {
		SalesstdlogDAO dao = (SalesstdlogDAO) DAOFactory.build(SalesstdlogDAO.class,user);
		return (SalesstdlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SalesstdlogDBParam params)
			throws Exception {
		SalesstdlogDAO dao = (SalesstdlogDAO) DAOFactory.build(SalesstdlogDAO.class,user);
		return dao.query(params);
	}
}
