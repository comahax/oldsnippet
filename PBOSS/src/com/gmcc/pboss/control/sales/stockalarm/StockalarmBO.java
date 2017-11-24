/**
 * auto-generated code
 * Wed Jun 23 08:53:23 CST 2010
 */
package com.gmcc.pboss.control.sales.stockalarm;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.stockalarm.StockalarmDBParam;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmDAO;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: StockalarmBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class StockalarmBO extends AbstractControlBean implements
		Stockalarm {

	public StockalarmVO doCreate(StockalarmVO vo) throws Exception {
		try {
			StockalarmDAO dao = (StockalarmDAO) DAOFactory.build(StockalarmDAO.class, user);
			// TODO set the pk */
			return (StockalarmVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(StockalarmVO vo) throws Exception {
		try {
			StockalarmDAO dao = (StockalarmDAO) DAOFactory.build(StockalarmDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			StockalarmDAO dao = (StockalarmDAO) DAOFactory.build(StockalarmDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StockalarmVO doUpdate(StockalarmVO vo) throws Exception {
		try {
			StockalarmDAO dao = (StockalarmDAO) DAOFactory.build(StockalarmDAO.class,user);
			return (StockalarmVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StockalarmVO doFindByPk(Serializable pk) throws Exception {
		StockalarmDAO dao = (StockalarmDAO) DAOFactory.build(StockalarmDAO.class,user);
		return (StockalarmVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(StockalarmDBParam params)
			throws Exception {
		StockalarmDAO dao = (StockalarmDAO) DAOFactory.build(StockalarmDAO.class,user);
		return dao.query(params);
	}
	
}
