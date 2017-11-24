/**
 * auto-generated code
 * Tue Oct 13 14:32:53 CST 2009
 */
package com.gmcc.pboss.control.sales.orderunitweek;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderunit.OrderunitVO;
import com.gmcc.pboss.business.sales.orderunitweek.OrderunitweekDAO;
import com.gmcc.pboss.business.sales.orderunitweek.OrderunitweekDBParam;
import com.gmcc.pboss.business.sales.orderunitweek.OrderunitweekVO;
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
public class OrderunitweekBO extends AbstractControlBean implements
		Orderunitweek {

	public OrderunitweekVO doCreate(OrderunitweekVO vo) throws Exception {
		try {
			OrderunitweekDAO dao = (OrderunitweekDAO) DAOFactory.build(OrderunitweekDAO.class, user);
			// TODO set the pk */
			return (OrderunitweekVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderunitweekVO vo) throws Exception {
		try {
			OrderunitweekDAO dao = (OrderunitweekDAO) DAOFactory.build(OrderunitweekDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderunitweekDAO dao = (OrderunitweekDAO) DAOFactory.build(OrderunitweekDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderunitweekVO doUpdate(OrderunitweekVO vo) throws Exception {
		try {
			OrderunitweekDAO dao = (OrderunitweekDAO) DAOFactory.build(OrderunitweekDAO.class,user);
			return (OrderunitweekVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderunitweekVO doFindByPk(Serializable pk) throws Exception {
		OrderunitweekDAO dao = (OrderunitweekDAO) DAOFactory.build(OrderunitweekDAO.class,user);
		return (OrderunitweekVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderunitweekDBParam params)
			throws Exception {
		OrderunitweekDAO dao = (OrderunitweekDAO) DAOFactory.build(OrderunitweekDAO.class,user);
		return dao.query(params);
	}
}
