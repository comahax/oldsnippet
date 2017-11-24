/**
 * auto-generated code
 * Tue Oct 13 14:29:08 CST 2009
 */
package com.gmcc.pboss.control.sales.orderstd;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderstd.OrderstdDBParam;
import com.gmcc.pboss.business.sales.orderstd.OrderstdDAO;
import com.gmcc.pboss.business.sales.orderstd.OrderstdVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderstdBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OrderstdBO extends AbstractControlBean implements
		Orderstd {

	public OrderstdVO doCreate(OrderstdVO vo) throws Exception {
		try {
			OrderstdDAO dao = (OrderstdDAO) DAOFactory.build(OrderstdDAO.class, user);
			// TODO set the pk */
			return (OrderstdVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderstdVO vo) throws Exception {
		try {
			OrderstdDAO dao = (OrderstdDAO) DAOFactory.build(OrderstdDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderstdDAO dao = (OrderstdDAO) DAOFactory.build(OrderstdDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderstdVO doUpdate(OrderstdVO vo) throws Exception {
		try {
			OrderstdDAO dao = (OrderstdDAO) DAOFactory.build(OrderstdDAO.class,user);
			return (OrderstdVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderstdVO doFindByPk(Serializable pk) throws Exception {
		OrderstdDAO dao = (OrderstdDAO) DAOFactory.build(OrderstdDAO.class,user);
		return (OrderstdVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderstdDBParam params)
			throws Exception {
		OrderstdDAO dao = (OrderstdDAO) DAOFactory.build(OrderstdDAO.class,user);
		return dao.query(params);
	}
}
