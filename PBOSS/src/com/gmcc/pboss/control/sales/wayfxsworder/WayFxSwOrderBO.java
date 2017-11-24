/**
 * auto-generated code
 * Tue Dec 14 15:42:11 CST 2010
 */
package com.gmcc.pboss.control.sales.wayfxsworder;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.sales.ressum.RessumDAO;
import com.gmcc.pboss.business.sales.ressum.RessumDBParam;
import com.gmcc.pboss.business.sales.wayfxsworder.WayFxSwOrderDBParam;
import com.gmcc.pboss.business.sales.wayfxsworder.WayFxSwOrderDAO;
import com.gmcc.pboss.business.sales.wayfxsworder.WayFxSwOrderVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: WayFxSwOrderBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class WayFxSwOrderBO extends AbstractControlBean implements
		WayFxSwOrder {

	public WayFxSwOrderVO doCreate(WayFxSwOrderVO vo) throws Exception {
		try {
			WayFxSwOrderDAO dao = (WayFxSwOrderDAO) DAOFactory.build(WayFxSwOrderDAO.class, user);
			// TODO set the pk */
			return (WayFxSwOrderVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WayFxSwOrderVO vo) throws Exception {
		try {
			WayFxSwOrderDAO dao = (WayFxSwOrderDAO) DAOFactory.build(WayFxSwOrderDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WayFxSwOrderDAO dao = (WayFxSwOrderDAO) DAOFactory.build(WayFxSwOrderDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayFxSwOrderVO doUpdate(WayFxSwOrderVO vo) throws Exception {
		try {
			WayFxSwOrderDAO dao = (WayFxSwOrderDAO) DAOFactory.build(WayFxSwOrderDAO.class,user);
			return (WayFxSwOrderVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayFxSwOrderVO doFindByPk(Serializable pk) throws Exception {
		WayFxSwOrderDAO dao = (WayFxSwOrderDAO) DAOFactory.build(WayFxSwOrderDAO.class,user);
		return (WayFxSwOrderVO) dao.findByPk(pk);
	}

	/*
	public DataPackage doQuery(WayFxSwOrderDBParam params)
			throws Exception {
		WayFxSwOrderDAO dao = (WayFxSwOrderDAO) DAOFactory.build(WayFxSwOrderDAO.class,user);
		return dao.query(params);
	}
	*/
	public DataPackage doQueryWayFxOrder(Map<String,String> conditionMap, WayFxSwOrderDBParam param) throws Exception {
		WayFxSwOrderDAO dao = (WayFxSwOrderDAO) DAOFactory.build(WayFxSwOrderDAO.class,user);
		return dao.doQueryWayFxOrder(conditionMap, param);
	}
}
