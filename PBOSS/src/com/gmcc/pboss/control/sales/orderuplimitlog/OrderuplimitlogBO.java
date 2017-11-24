/**
 * auto-generated code
 * Wed Jun 23 08:51:05 CST 2010
 */
package com.gmcc.pboss.control.sales.orderuplimitlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderuplimitlog.OrderuplimitlogDBParam;
import com.gmcc.pboss.business.sales.orderuplimitlog.OrderuplimitlogDAO;
import com.gmcc.pboss.business.sales.orderuplimitlog.OrderuplimitlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: OrderuplimitlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderuplimitlogBO extends AbstractControlBean implements
		Orderuplimitlog {

	public OrderuplimitlogVO doCreate(OrderuplimitlogVO vo) throws Exception {
		try {
			OrderuplimitlogDAO dao = (OrderuplimitlogDAO) DAOFactory.build(OrderuplimitlogDAO.class, user);
			// TODO set the pk */
			return (OrderuplimitlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderuplimitlogVO vo) throws Exception {
		try {
			OrderuplimitlogDAO dao = (OrderuplimitlogDAO) DAOFactory.build(OrderuplimitlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderuplimitlogDAO dao = (OrderuplimitlogDAO) DAOFactory.build(OrderuplimitlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderuplimitlogVO doUpdate(OrderuplimitlogVO vo) throws Exception {
		try {
			OrderuplimitlogDAO dao = (OrderuplimitlogDAO) DAOFactory.build(OrderuplimitlogDAO.class,user);
			return (OrderuplimitlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderuplimitlogVO doFindByPk(Serializable pk) throws Exception {
		OrderuplimitlogDAO dao = (OrderuplimitlogDAO) DAOFactory.build(OrderuplimitlogDAO.class,user);
		return (OrderuplimitlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderuplimitlogDBParam params)
			throws Exception {
		OrderuplimitlogDAO dao = (OrderuplimitlogDAO) DAOFactory.build(OrderuplimitlogDAO.class,user);
		return dao.query(params);
	}
}
