/**
 * auto-generated code
 * Tue Dec 14 14:53:32 CST 2010
 */
package com.gmcc.pboss.control.sales.orderstate;

import java.io.Serializable;
import java.util.Date;

import com.gmcc.pboss.business.sales.orderstate.OrderstateDAO;
import com.gmcc.pboss.business.sales.orderstate.OrderstateDBParam;
import com.gmcc.pboss.business.sales.orderstate.OrderstateVO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderstateBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author YangDaRen
 * @version 1.0
 */
public class OrderstateBO extends AbstractControlBean implements
		Orderstate {

	public OrderstateVO doCreate(OrderstateVO vo) throws Exception {
		try {
			OrderstateDAO dao = (OrderstateDAO) DAOFactory.build(OrderstateDAO.class, user);
			// TODO set the pk */
			return (OrderstateVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderstateVO vo) throws Exception {
		try {
			OrderstateDAO dao = (OrderstateDAO) DAOFactory.build(OrderstateDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderstateDAO dao = (OrderstateDAO) DAOFactory.build(OrderstateDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderstateVO doUpdate(OrderstateVO vo) throws Exception {
		try {
			OrderstateDAO dao = (OrderstateDAO) DAOFactory.build(OrderstateDAO.class,user);
			return (OrderstateVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderstateVO doFindByPk(Serializable pk) throws Exception {
		OrderstateDAO dao = (OrderstateDAO) DAOFactory.build(OrderstateDAO.class,user);
		return (OrderstateVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderstateDBParam params)
			throws Exception {
		OrderstateDAO dao = (OrderstateDAO) DAOFactory.build(OrderstateDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doQueryState(OrderstateDBParam params) throws Exception {
		OrderstateDAO dao = (OrderstateDAO) DAOFactory.build(OrderstateDAO.class,user);
		Date dtend = PublicUtils.UtilStrToDate(params.get_dnm_createtime());
		Date dtstart = PublicUtils.UtilStrToDate(params.get_dnl_createtime());
		params.getQueryConditions().put("ENDDATE", dtend);
		params.getQueryConditions().put("STARTDATE", dtstart);
		params.set_dnl_createtime(null);
		params.set_dnm_createtime(null);
		return dao.queryByNamedSqlQuery("sales.orderstate.querystate", params);
	}
}
