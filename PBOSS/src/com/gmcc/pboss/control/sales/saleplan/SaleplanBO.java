/**
 * auto-generated code
 * Tue Nov 08 11:17:27 CST 2011
 */
package com.gmcc.pboss.control.sales.saleplan;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.order.OrderDAO;
import com.gmcc.pboss.business.sales.saleplan.SaleplanDBParam;
import com.gmcc.pboss.business.sales.saleplan.SaleplanDAO;
import com.gmcc.pboss.business.sales.saleplan.SaleplanVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: SaleplanBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SaleplanBO extends AbstractControlBean implements
		Saleplan {

	public SaleplanVO doCreate(SaleplanVO vo) throws Exception {
		try {
			SaleplanDAO dao = (SaleplanDAO) DAOFactory.build(SaleplanDAO.class, user);
			// TODO set the pk */
			return (SaleplanVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SaleplanVO vo) throws Exception {
		try {
			SaleplanDAO dao = (SaleplanDAO) DAOFactory.build(SaleplanDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SaleplanDAO dao = (SaleplanDAO) DAOFactory.build(SaleplanDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SaleplanVO doUpdate(SaleplanVO vo) throws Exception {
		try {
			SaleplanDAO dao = (SaleplanDAO) DAOFactory.build(SaleplanDAO.class,user);
			return (SaleplanVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SaleplanVO doFindByPk(Serializable pk) throws Exception {
		SaleplanDAO dao = (SaleplanDAO) DAOFactory.build(SaleplanDAO.class,user);
		return (SaleplanVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SaleplanDBParam params)
			throws Exception {
		SaleplanDAO dao = (SaleplanDAO) DAOFactory.build(SaleplanDAO.class,user);
		return dao.query(params);
	}

	public DataPackage doQueryByName(String sqlName, SaleplanDBParam params)
			throws Exception {
		SaleplanDAO dao = (SaleplanDAO) DAOFactory.build(SaleplanDAO.class, user);
		return dao.queryByNamedSqlQuery(sqlName,params);
	}
}
