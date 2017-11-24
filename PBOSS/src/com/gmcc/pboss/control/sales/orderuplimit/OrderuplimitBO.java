/**
 * auto-generated code
 * Tue Oct 13 14:30:52 CST 2009
 */
package com.gmcc.pboss.control.sales.orderuplimit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitDBParam;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitDAO;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderuplimitBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OrderuplimitBO extends AbstractControlBean implements
		Orderuplimit {

	public OrderuplimitVO doCreate(OrderuplimitVO vo) throws Exception {
		try {
			OrderuplimitDAO dao = (OrderuplimitDAO) DAOFactory.build(OrderuplimitDAO.class, user);
			// TODO set the pk */
			return (OrderuplimitVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderuplimitVO vo) throws Exception {
		try {
			OrderuplimitDAO dao = (OrderuplimitDAO) DAOFactory.build(OrderuplimitDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderuplimitDAO dao = (OrderuplimitDAO) DAOFactory.build(OrderuplimitDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderuplimitVO doUpdate(OrderuplimitVO vo) throws Exception {
		try {
			OrderuplimitDAO dao = (OrderuplimitDAO) DAOFactory.build(OrderuplimitDAO.class,user);
			return (OrderuplimitVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderuplimitVO doFindByPk(Serializable pk) throws Exception {
		OrderuplimitDAO dao = (OrderuplimitDAO) DAOFactory.build(OrderuplimitDAO.class,user);
		return (OrderuplimitVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderuplimitDBParam params)
			throws Exception {
		OrderuplimitDAO dao = (OrderuplimitDAO) DAOFactory.build(OrderuplimitDAO.class,user);
		return dao.query(params);
	}
	
    public List  doQueryEmptysimtype(OrderuplimitDBParam params) throws Exception {
			OrderuplimitDAO dao = (OrderuplimitDAO) DAOFactory.build(OrderuplimitDAO.class,user);
			return dao.doQueryEmptysimtype(params);
	 }
}
