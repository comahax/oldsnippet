/**
 * auto-generated code
 * Sun May 22 15:19:11 GMT 2011
 */
package com.gmcc.pboss.control.sales.stockalmfloat;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.stockalmfloat.StockalmfloatDBParam;
import com.gmcc.pboss.business.sales.stockalmfloat.StockalmfloatDAO;
import com.gmcc.pboss.business.sales.stockalmfloat.StockalmfloatVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: StockalmfloatBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class StockalmfloatBO extends AbstractControlBean implements
		Stockalmfloat {

	public StockalmfloatVO doCreate(StockalmfloatVO vo) throws Exception {
		try {
			StockalmfloatDAO dao = (StockalmfloatDAO) DAOFactory.build(StockalmfloatDAO.class, user);
			// TODO set the pk */
			return (StockalmfloatVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(StockalmfloatVO vo) throws Exception {
		try {
			StockalmfloatDAO dao = (StockalmfloatDAO) DAOFactory.build(StockalmfloatDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			StockalmfloatDAO dao = (StockalmfloatDAO) DAOFactory.build(StockalmfloatDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StockalmfloatVO doUpdate(StockalmfloatVO vo) throws Exception {
		try {
			StockalmfloatDAO dao = (StockalmfloatDAO) DAOFactory.build(StockalmfloatDAO.class,user);
			return (StockalmfloatVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StockalmfloatVO doFindByPk(Serializable pk) throws Exception {
		StockalmfloatDAO dao = (StockalmfloatDAO) DAOFactory.build(StockalmfloatDAO.class,user);
		return (StockalmfloatVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(StockalmfloatDBParam params)
			throws Exception {
		StockalmfloatDAO dao = (StockalmfloatDAO) DAOFactory.build(StockalmfloatDAO.class,user);
		return dao.query(params);
	}
}
