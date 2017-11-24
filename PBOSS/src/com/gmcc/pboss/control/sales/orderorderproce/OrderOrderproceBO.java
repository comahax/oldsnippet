/**
 * auto-generated code
 * Wed Aug 10 16:07:59 CST 2011
 */
package com.gmcc.pboss.control.sales.orderorderproce;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.sales.orderorderproce.OrderOrderproceDBParam;
import com.gmcc.pboss.business.sales.orderorderproce.OrderOrderproceDAO;
import com.gmcc.pboss.business.sales.orderorderproce.OrderOrderproceVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: OrderOrderproceBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderOrderproceBO extends AbstractControlBean implements
		OrderOrderproce {

	public OrderOrderproceVO doCreate(OrderOrderproceVO vo) throws Exception {
		try {
			OrderOrderproceDAO dao = (OrderOrderproceDAO) DAOFactory.build(OrderOrderproceDAO.class, user);
			// TODO set the pk */
			return (OrderOrderproceVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderOrderproceVO vo) throws Exception {
		try {
			OrderOrderproceDAO dao = (OrderOrderproceDAO) DAOFactory.build(OrderOrderproceDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderOrderproceDAO dao = (OrderOrderproceDAO) DAOFactory.build(OrderOrderproceDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderOrderproceVO doUpdate(OrderOrderproceVO vo) throws Exception {
		try {
			OrderOrderproceDAO dao = (OrderOrderproceDAO) DAOFactory.build(OrderOrderproceDAO.class,user);
			return (OrderOrderproceVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderOrderproceVO doFindByPk(Serializable pk) throws Exception {
		OrderOrderproceDAO dao = (OrderOrderproceDAO) DAOFactory.build(OrderOrderproceDAO.class,user);
		return (OrderOrderproceVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderOrderproceDBParam params)
			throws Exception {
		OrderOrderproceDAO dao = (OrderOrderproceDAO) DAOFactory.build(OrderOrderproceDAO.class,user);
		return dao.query(params);
	}
	
	 public DataPackage doQueryProce(Map<String,String> conditionMap,OrderOrderproceDBParam params) throws Exception{
		 OrderOrderproceDAO dao = (OrderOrderproceDAO) DAOFactory.build(OrderOrderproceDAO.class,user);
//		 System.out.println("*********************"+dao.getDbFlag());	
		 return dao.queryProce(conditionMap,params);
	 }

	public DataPackage doQueryProceDetail(Map<String, String> conditionMap,
			OrderOrderproceDBParam params) throws Exception {
		OrderOrderproceDAO dao = (OrderOrderproceDAO) DAOFactory.build(OrderOrderproceDAO.class,user);
//		 System.out.println("*********************"+dao.getDbFlag());	
		 return dao.queryDetail(conditionMap,params);
	}

	
}
