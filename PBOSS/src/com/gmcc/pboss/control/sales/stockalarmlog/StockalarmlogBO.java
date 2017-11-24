/**
 * auto-generated code
 * Wed Jun 23 08:53:40 CST 2010
 */
package com.gmcc.pboss.control.sales.stockalarmlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.stockalarmlog.StockalarmlogDBParam;
import com.gmcc.pboss.business.sales.stockalarmlog.StockalarmlogDAO;
import com.gmcc.pboss.business.sales.stockalarmlog.StockalarmlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: StockalarmlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class StockalarmlogBO extends AbstractControlBean implements
		Stockalarmlog {

	public StockalarmlogVO doCreate(StockalarmlogVO vo) throws Exception {
		try {
			StockalarmlogDAO dao = (StockalarmlogDAO) DAOFactory.build(StockalarmlogDAO.class, user);
			// TODO set the pk */
			return (StockalarmlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(StockalarmlogVO vo) throws Exception {
		try {
			StockalarmlogDAO dao = (StockalarmlogDAO) DAOFactory.build(StockalarmlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			StockalarmlogDAO dao = (StockalarmlogDAO) DAOFactory.build(StockalarmlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StockalarmlogVO doUpdate(StockalarmlogVO vo) throws Exception {
		try {
			StockalarmlogDAO dao = (StockalarmlogDAO) DAOFactory.build(StockalarmlogDAO.class,user);
			return (StockalarmlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StockalarmlogVO doFindByPk(Serializable pk) throws Exception {
		StockalarmlogDAO dao = (StockalarmlogDAO) DAOFactory.build(StockalarmlogDAO.class,user);
		return (StockalarmlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(StockalarmlogDBParam params)
			throws Exception {
		StockalarmlogDAO dao = (StockalarmlogDAO) DAOFactory.build(StockalarmlogDAO.class,user);
		return dao.query(params);
	}
}
