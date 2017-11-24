/**
 * auto-generated code
 * Tue Oct 13 16:28:22 CST 2009
 */
package com.gmcc.pboss.control.sales.orderplan;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderplan.OrderplanDBParam;
import com.gmcc.pboss.business.sales.orderplan.OrderplanDAO;
import com.gmcc.pboss.business.sales.orderplan.OrderplanVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderplanBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/sales/orderplan/control/OrderplanBO"
*    name="Orderplan"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class OrderplanBO extends AbstractControlBean implements
		Orderplan {

	public OrderplanVO doCreate(OrderplanVO vo) throws Exception {
		try {
			OrderplanDAO dao = (OrderplanDAO) DAOFactory.build(OrderplanDAO.class, user);
			// TODO set the pk */
			return (OrderplanVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderplanVO vo) throws Exception {
		try {
			OrderplanDAO dao = (OrderplanDAO) DAOFactory.build(OrderplanDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderplanDAO dao = (OrderplanDAO) DAOFactory.build(OrderplanDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderplanVO doUpdate(OrderplanVO vo) throws Exception {
		try {
			OrderplanDAO dao = (OrderplanDAO) DAOFactory.build(OrderplanDAO.class,user);
			return (OrderplanVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderplanVO doFindByPk(Serializable pk) throws Exception {
		OrderplanDAO dao = (OrderplanDAO) DAOFactory.build(OrderplanDAO.class,user);
		return (OrderplanVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderplanDBParam params)
			throws Exception {
		OrderplanDAO dao = (OrderplanDAO) DAOFactory.build(OrderplanDAO.class,user);
		return dao.query(params);
	}
}
