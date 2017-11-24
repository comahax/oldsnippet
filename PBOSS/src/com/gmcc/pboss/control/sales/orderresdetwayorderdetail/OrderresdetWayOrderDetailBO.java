/**
 * auto-generated code
 * Sat Dec 18 20:30:45 CST 2010
 */
package com.gmcc.pboss.control.sales.orderresdetwayorderdetail;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.sales.orderresdetwayorderdetail.OrderresdetWayOrderDetailDBParam;
import com.gmcc.pboss.business.sales.orderresdetwayorderdetail.OrderresdetWayOrderDetailDAO;
import com.gmcc.pboss.business.sales.orderresdetwayorderdetail.OrderresdetWayOrderDetailVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: OrderresdetWayOrderDetailBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderresdetWayOrderDetailBO extends AbstractControlBean implements
		OrderresdetWayOrderDetail {

	public OrderresdetWayOrderDetailVO doCreate(OrderresdetWayOrderDetailVO vo) throws Exception {
		try {
			OrderresdetWayOrderDetailDAO dao = (OrderresdetWayOrderDetailDAO) DAOFactory.build(OrderresdetWayOrderDetailDAO.class, user);
			// TODO set the pk */
			return (OrderresdetWayOrderDetailVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderresdetWayOrderDetailVO vo) throws Exception {
		try {
			OrderresdetWayOrderDetailDAO dao = (OrderresdetWayOrderDetailDAO) DAOFactory.build(OrderresdetWayOrderDetailDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderresdetWayOrderDetailDAO dao = (OrderresdetWayOrderDetailDAO) DAOFactory.build(OrderresdetWayOrderDetailDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderresdetWayOrderDetailVO doUpdate(OrderresdetWayOrderDetailVO vo) throws Exception {
		try {
			OrderresdetWayOrderDetailDAO dao = (OrderresdetWayOrderDetailDAO) DAOFactory.build(OrderresdetWayOrderDetailDAO.class,user);
			return (OrderresdetWayOrderDetailVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderresdetWayOrderDetailVO doFindByPk(Serializable pk) throws Exception {
		OrderresdetWayOrderDetailDAO dao = (OrderresdetWayOrderDetailDAO) DAOFactory.build(OrderresdetWayOrderDetailDAO.class,user);
		return (OrderresdetWayOrderDetailVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderresdetWayOrderDetailDBParam params)
			throws Exception {
		OrderresdetWayOrderDetailDAO dao = (OrderresdetWayOrderDetailDAO) DAOFactory.build(OrderresdetWayOrderDetailDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doQueryOrderresdetWayOrderDetail(Map<String,String> conditionMap, OrderresdetWayOrderDetailDBParam param) 
			throws Exception{
		OrderresdetWayOrderDetailDAO detailDAO=(OrderresdetWayOrderDetailDAO)DAOFactory.build(OrderresdetWayOrderDetailDAO.class, user);
		return detailDAO.doQueryOrderresdetWayOrderDetail(conditionMap, param);
	}
	
}
