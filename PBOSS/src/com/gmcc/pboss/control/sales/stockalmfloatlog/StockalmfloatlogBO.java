/**
 * auto-generated code
 * Sun May 22 15:20:29 GMT 2011
 */
package com.gmcc.pboss.control.sales.stockalmfloatlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.stockalmfloatlog.StockalmfloatlogDBParam;
import com.gmcc.pboss.business.sales.stockalmfloatlog.StockalmfloatlogDAO;
import com.gmcc.pboss.business.sales.stockalmfloatlog.StockalmfloatlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: StockalmfloatlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class StockalmfloatlogBO extends AbstractControlBean implements
		Stockalmfloatlog {

	public StockalmfloatlogVO doCreate(StockalmfloatlogVO vo) throws Exception {
		try {
			StockalmfloatlogDAO dao = (StockalmfloatlogDAO) DAOFactory.build(StockalmfloatlogDAO.class, user);
			// TODO set the pk */
			return (StockalmfloatlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(StockalmfloatlogVO vo) throws Exception {
		try {
			StockalmfloatlogDAO dao = (StockalmfloatlogDAO) DAOFactory.build(StockalmfloatlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			StockalmfloatlogDAO dao = (StockalmfloatlogDAO) DAOFactory.build(StockalmfloatlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StockalmfloatlogVO doUpdate(StockalmfloatlogVO vo) throws Exception {
		try {
			StockalmfloatlogDAO dao = (StockalmfloatlogDAO) DAOFactory.build(StockalmfloatlogDAO.class,user);
			return (StockalmfloatlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StockalmfloatlogVO doFindByPk(Serializable pk) throws Exception {
		StockalmfloatlogDAO dao = (StockalmfloatlogDAO) DAOFactory.build(StockalmfloatlogDAO.class,user);
		return (StockalmfloatlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(StockalmfloatlogDBParam params)
			throws Exception {
		StockalmfloatlogDAO dao = (StockalmfloatlogDAO) DAOFactory.build(StockalmfloatlogDAO.class,user);
		return dao.query(params);
	}
}
