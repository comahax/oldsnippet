/**
 * auto-generated code
 * Sat Dec 18 09:48:51 CST 2010
 */
package com.gmcc.pboss.control.sales.orderresdetwayorder;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.sales.orderresdetwayorder.OrderresdetWayOrderDBParam;
import com.gmcc.pboss.business.sales.orderresdetwayorder.OrderresdetWayOrderDAO;
import com.gmcc.pboss.business.sales.orderresdetwayorder.OrderresdetWayOrderVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: OrderresdetWayOrderBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderresdetWayOrderBO extends AbstractControlBean implements
		OrderresdetWayOrder {

	public OrderresdetWayOrderVO doCreate(OrderresdetWayOrderVO vo) throws Exception {
		try {
			OrderresdetWayOrderDAO dao = (OrderresdetWayOrderDAO) DAOFactory.build(OrderresdetWayOrderDAO.class, user);
			// TODO set the pk */
			return (OrderresdetWayOrderVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderresdetWayOrderVO vo) throws Exception {
		try {
			OrderresdetWayOrderDAO dao = (OrderresdetWayOrderDAO) DAOFactory.build(OrderresdetWayOrderDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderresdetWayOrderDAO dao = (OrderresdetWayOrderDAO) DAOFactory.build(OrderresdetWayOrderDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderresdetWayOrderVO doUpdate(OrderresdetWayOrderVO vo) throws Exception {
		try {
			OrderresdetWayOrderDAO dao = (OrderresdetWayOrderDAO) DAOFactory.build(OrderresdetWayOrderDAO.class,user);
			return (OrderresdetWayOrderVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderresdetWayOrderVO doFindByPk(Serializable pk) throws Exception {
		OrderresdetWayOrderDAO dao = (OrderresdetWayOrderDAO) DAOFactory.build(OrderresdetWayOrderDAO.class,user);
		return (OrderresdetWayOrderVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderresdetWayOrderDBParam params)
			throws Exception {
		OrderresdetWayOrderDAO dao = (OrderresdetWayOrderDAO) DAOFactory.build(OrderresdetWayOrderDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doQueryOrderresdetWayOrder(Map<String,String> conditionMap, OrderresdetWayOrderDBParam param) throws Exception {
		OrderresdetWayOrderDAO dao=(OrderresdetWayOrderDAO)DAOFactory.build(OrderresdetWayOrderDAO.class, user);
		return dao.doQueryOrderresdetWayOrder(conditionMap, param);
	}
	
	
}
