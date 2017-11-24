/**
 * auto-generated code
 * Fri May 07 16:29:05 CST 2010
 */
package com.gmcc.pboss.control.sales.ordertimes;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.ordertimes.OrdertimesDBParam;
import com.gmcc.pboss.business.sales.ordertimes.OrdertimesDAO;
import com.gmcc.pboss.business.sales.ordertimes.OrdertimesVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: OrdertimesBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zsw
 * @version 1.0
 */
public class OrdertimesBO extends AbstractControlBean implements
		Ordertimes {

	public OrdertimesVO doCreate(OrdertimesVO vo) throws Exception {
		try {
			OrdertimesDAO dao = (OrdertimesDAO) DAOFactory.build(OrdertimesDAO.class, user);
			// TODO set the pk */
			return (OrdertimesVO) dao.create(vo);
		} catch (Exception ex) {
//			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrdertimesVO vo) throws Exception {
		try {
			OrdertimesDAO dao = (OrdertimesDAO) DAOFactory.build(OrdertimesDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
//			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrdertimesDAO dao = (OrdertimesDAO) DAOFactory.build(OrdertimesDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
//			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public OrdertimesVO doUpdate(OrdertimesVO vo) throws Exception {
		try {
			OrdertimesDAO dao = (OrdertimesDAO) DAOFactory.build(OrdertimesDAO.class,user);
			return (OrdertimesVO) dao.update(vo);
		} catch (Exception ex) {
//			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public OrdertimesVO doFindByPk(Serializable pk) throws Exception {
		OrdertimesDAO dao = (OrdertimesDAO) DAOFactory.build(OrdertimesDAO.class,user);
		return (OrdertimesVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrdertimesDBParam params)
			throws Exception {
		OrdertimesDAO dao = (OrdertimesDAO) DAOFactory.build(OrdertimesDAO.class,user);
		return dao.query(params);
	}
}
