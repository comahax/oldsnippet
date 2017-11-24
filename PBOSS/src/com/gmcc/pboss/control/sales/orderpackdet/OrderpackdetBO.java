/**
 * auto-generated code
 * Tue Oct 13 14:59:20 CST 2009
 */
package com.gmcc.pboss.control.sales.orderpackdet;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderpackdet.OrderpackdetDBParam;
import com.gmcc.pboss.business.sales.orderpackdet.OrderpackdetDAO;
import com.gmcc.pboss.business.sales.orderpackdet.OrderpackdetVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderpackdetBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderpackdetBO extends AbstractControlBean implements
		Orderpackdet {

	public OrderpackdetVO doCreate(OrderpackdetVO vo) throws Exception {
		try {
			OrderpackdetDAO dao = (OrderpackdetDAO) DAOFactory.build(OrderpackdetDAO.class, user);
			// TODO set the pk */
			return (OrderpackdetVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderpackdetVO vo) throws Exception {
		try {
			OrderpackdetDAO dao = (OrderpackdetDAO) DAOFactory.build(OrderpackdetDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderpackdetDAO dao = (OrderpackdetDAO) DAOFactory.build(OrderpackdetDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderpackdetVO doUpdate(OrderpackdetVO vo) throws Exception {
		try {
			OrderpackdetDAO dao = (OrderpackdetDAO) DAOFactory.build(OrderpackdetDAO.class,user);
			return (OrderpackdetVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderpackdetVO doFindByPk(Serializable pk) throws Exception {
		OrderpackdetDAO dao = (OrderpackdetDAO) DAOFactory.build(OrderpackdetDAO.class,user);
		return (OrderpackdetVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderpackdetDBParam params)
			throws Exception {
		OrderpackdetDAO dao = (OrderpackdetDAO) DAOFactory.build(OrderpackdetDAO.class,user);
		return dao.query(params);
	}
}
