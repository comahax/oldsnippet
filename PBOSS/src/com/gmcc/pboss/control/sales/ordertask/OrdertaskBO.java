/**
 * auto-generated code
 * Fri Oct 16 13:35:33 CST 2009
 */
package com.gmcc.pboss.control.sales.ordertask;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.ordertask.OrdertaskDBParam;
import com.gmcc.pboss.business.sales.ordertask.OrdertaskDAO;
import com.gmcc.pboss.business.sales.ordertask.OrdertaskVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrdertaskBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrdertaskBO extends AbstractControlBean implements
		Ordertask {

	public OrdertaskVO doCreate(OrdertaskVO vo) throws Exception {
		try {
			OrdertaskDAO dao = (OrdertaskDAO) DAOFactory.build(OrdertaskDAO.class, user);
			// TODO set the pk */
			return (OrdertaskVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrdertaskVO vo) throws Exception {
		try {
			OrdertaskDAO dao = (OrdertaskDAO) DAOFactory.build(OrdertaskDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrdertaskDAO dao = (OrdertaskDAO) DAOFactory.build(OrdertaskDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrdertaskVO doUpdate(OrdertaskVO vo) throws Exception {
		try {
			OrdertaskDAO dao = (OrdertaskDAO) DAOFactory.build(OrdertaskDAO.class,user);
			return (OrdertaskVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrdertaskVO doFindByPk(Serializable pk) throws Exception {
		OrdertaskDAO dao = (OrdertaskDAO) DAOFactory.build(OrdertaskDAO.class,user);
		return (OrdertaskVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrdertaskDBParam params)
			throws Exception {
		OrdertaskDAO dao = (OrdertaskDAO) DAOFactory.build(OrdertaskDAO.class,user);
		return dao.query(params);
	}
}
