/**
 * auto-generated code
 * Tue Nov 08 14:10:56 CST 2011
 */
package com.gmcc.pboss.control.sales.saleplanlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.saleplanlog.SaleplanlogDBParam;
import com.gmcc.pboss.business.sales.saleplanlog.SaleplanlogDAO;
import com.gmcc.pboss.business.sales.saleplanlog.SaleplanlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: SaleplanlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SaleplanlogBO extends AbstractControlBean implements
		Saleplanlog {

	public SaleplanlogVO doCreate(SaleplanlogVO vo) throws Exception {
		try {
			SaleplanlogDAO dao = (SaleplanlogDAO) DAOFactory.build(SaleplanlogDAO.class, user);
			// TODO set the pk */
			return (SaleplanlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SaleplanlogVO vo) throws Exception {
		try {
			SaleplanlogDAO dao = (SaleplanlogDAO) DAOFactory.build(SaleplanlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SaleplanlogDAO dao = (SaleplanlogDAO) DAOFactory.build(SaleplanlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SaleplanlogVO doUpdate(SaleplanlogVO vo) throws Exception {
		try {
			SaleplanlogDAO dao = (SaleplanlogDAO) DAOFactory.build(SaleplanlogDAO.class,user);
			return (SaleplanlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SaleplanlogVO doFindByPk(Serializable pk) throws Exception {
		SaleplanlogDAO dao = (SaleplanlogDAO) DAOFactory.build(SaleplanlogDAO.class,user);
		return (SaleplanlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SaleplanlogDBParam params)
			throws Exception {
		SaleplanlogDAO dao = (SaleplanlogDAO) DAOFactory.build(SaleplanlogDAO.class,user);
		return dao.query(params);
	}
}
