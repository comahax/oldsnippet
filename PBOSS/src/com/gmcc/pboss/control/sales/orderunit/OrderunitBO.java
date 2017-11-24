/**
 * auto-generated code
 * Tue Oct 13 14:32:53 CST 2009
 */
package com.gmcc.pboss.control.sales.orderunit;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderunit.OrderunitDBParam;
import com.gmcc.pboss.business.sales.orderunit.OrderunitDAO;
import com.gmcc.pboss.business.sales.orderunit.OrderunitVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderunitBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OrderunitBO extends AbstractControlBean implements
		Orderunit {

	public OrderunitVO doCreate(OrderunitVO vo) throws Exception {
		try {
			OrderunitDAO dao = (OrderunitDAO) DAOFactory.build(OrderunitDAO.class, user);
			// TODO set the pk */
			return (OrderunitVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderunitVO vo) throws Exception {
		try {
			OrderunitDAO dao = (OrderunitDAO) DAOFactory.build(OrderunitDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderunitDAO dao = (OrderunitDAO) DAOFactory.build(OrderunitDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderunitVO doUpdate(OrderunitVO vo) throws Exception {
		try {
			OrderunitDAO dao = (OrderunitDAO) DAOFactory.build(OrderunitDAO.class,user);
			return (OrderunitVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderunitVO doFindByPk(Serializable pk) throws Exception {
		OrderunitDAO dao = (OrderunitDAO) DAOFactory.build(OrderunitDAO.class,user);
		return (OrderunitVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderunitDBParam params)
			throws Exception {
		OrderunitDAO dao = (OrderunitDAO) DAOFactory.build(OrderunitDAO.class,user);
		return dao.query(params);
	}
}
