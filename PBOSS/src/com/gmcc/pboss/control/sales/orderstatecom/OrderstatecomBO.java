/**
 * auto-generated code
 * Wed Dec 15 18:40:46 CST 2010
 */
package com.gmcc.pboss.control.sales.orderstatecom;

import java.io.Serializable;
import java.util.Date;

import com.gmcc.pboss.business.sales.orderstatecom.OrderstatecomDAO;
import com.gmcc.pboss.business.sales.orderstatecom.OrderstatecomDBParam;
import com.gmcc.pboss.business.sales.orderstatecom.OrderstatecomVO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderstatecomBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author YangDaRen
 * @version 1.0
 */
public class OrderstatecomBO extends AbstractControlBean implements
		Orderstatecom {

	public OrderstatecomVO doCreate(OrderstatecomVO vo) throws Exception {
		try {
			OrderstatecomDAO dao = (OrderstatecomDAO) DAOFactory.build(OrderstatecomDAO.class, user);
			// TODO set the pk */
			return (OrderstatecomVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderstatecomVO vo) throws Exception {
		try {
			OrderstatecomDAO dao = (OrderstatecomDAO) DAOFactory.build(OrderstatecomDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderstatecomDAO dao = (OrderstatecomDAO) DAOFactory.build(OrderstatecomDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderstatecomVO doUpdate(OrderstatecomVO vo) throws Exception {
		try {
			OrderstatecomDAO dao = (OrderstatecomDAO) DAOFactory.build(OrderstatecomDAO.class,user);
			return (OrderstatecomVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderstatecomVO doFindByPk(Serializable pk) throws Exception {
		OrderstatecomDAO dao = (OrderstatecomDAO) DAOFactory.build(OrderstatecomDAO.class,user);
		return (OrderstatecomVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderstatecomDBParam params)
			throws Exception {
		OrderstatecomDAO dao = (OrderstatecomDAO) DAOFactory.build(OrderstatecomDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doQueryStatecom(OrderstatecomDBParam params) throws Exception {
		OrderstatecomDAO dao = (OrderstatecomDAO) DAOFactory.build(OrderstatecomDAO.class,user);
		Date dtend = PublicUtils.UtilStrToDate(params.get_dnm_createtime());
		Date dtstart = PublicUtils.UtilStrToDate(params.get_dnl_createtime());
		params.getQueryConditions().put("ENDDATE", dtend);
		params.getQueryConditions().put("STARTDATE", dtstart);
		params.set_dnl_createtime(null);
		params.set_dnm_createtime(null);
		return dao.queryByNamedSqlQuery("sales.orderstatecom.querystatecom", params);
	}
}
