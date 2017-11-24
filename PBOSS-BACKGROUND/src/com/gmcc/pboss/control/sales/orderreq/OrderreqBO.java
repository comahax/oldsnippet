/**
 * auto-generated code
 * Wed Nov 18 17:19:05 CST 2009
 */
package com.gmcc.pboss.control.sales.orderreq;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderreq.OrderreqDAO;
import com.gmcc.pboss.business.sales.orderreq.OrderreqDBParam;
import com.gmcc.pboss.business.sales.orderreq.OrderreqVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderreqBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderreqBO extends AbstractControlBean implements
		Orderreq {

	public OrderreqVO doCreate(OrderreqVO vo) throws Exception {
		try {
			OrderreqDAO dao = (OrderreqDAO) DAOFactory.build(OrderreqDAO.class, user);
			// TODO set the pk */
			return (OrderreqVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderreqVO vo) throws Exception {
		try {
			OrderreqDAO dao = (OrderreqDAO) DAOFactory.build(OrderreqDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderreqDAO dao = (OrderreqDAO) DAOFactory.build(OrderreqDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderreqVO doUpdate(OrderreqVO vo) throws Exception {
		try {
			OrderreqDAO dao = (OrderreqDAO) DAOFactory.build(OrderreqDAO.class, user);
			return (OrderreqVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderreqVO doFindByPk(Serializable pk) throws Exception {
		OrderreqDAO dao = (OrderreqDAO) DAOFactory.build(OrderreqDAO.class, user);
		return (OrderreqVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderreqDBParam params)
			throws Exception {
		OrderreqDAO dao = (OrderreqDAO) DAOFactory.build(OrderreqDAO.class, user);
		return dao.query(params);
	}
}
