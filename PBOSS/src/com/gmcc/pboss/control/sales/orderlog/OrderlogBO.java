/**
 * auto-generated code
 * Tue Apr 24 15:01:18 CST 2012
 */
package com.gmcc.pboss.control.sales.orderlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.order.OrderDAO;
import com.gmcc.pboss.business.sales.orderlog.OrderlogDBParam;
import com.gmcc.pboss.business.sales.orderlog.OrderlogDAO;
import com.gmcc.pboss.business.sales.orderlog.OrderlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: OrderlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderlogBO extends AbstractControlBean implements
		Orderlog {

	public OrderlogVO doCreate(OrderlogVO vo) throws Exception {
		try {
			OrderlogDAO dao = (OrderlogDAO) DAOFactory.build(OrderlogDAO.class, user);
			// TODO set the pk */
			return (OrderlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderlogVO vo) throws Exception {
		try {
			OrderlogDAO dao = (OrderlogDAO) DAOFactory.build(OrderlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderlogDAO dao = (OrderlogDAO) DAOFactory.build(OrderlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderlogVO doUpdate(OrderlogVO vo) throws Exception {
		try {
			OrderlogDAO dao = (OrderlogDAO) DAOFactory.build(OrderlogDAO.class,user);
			return (OrderlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderlogVO doFindByPk(Serializable pk) throws Exception {
		OrderlogDAO dao = (OrderlogDAO) DAOFactory.build(OrderlogDAO.class,user);
		return (OrderlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderlogDBParam params)
			throws Exception {
		OrderlogDAO dao = (OrderlogDAO) DAOFactory.build(OrderlogDAO.class,user);
		return dao.query(params);
	}
	
	   public DataPackage doExportList(OrderlogDBParam params) throws Exception{
		   OrderlogDAO dao = (OrderlogDAO) DAOFactory.build(OrderlogDAO.class, user);
		   return  dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.orderlog.orderlogList",params); 
		   
	   }
}
