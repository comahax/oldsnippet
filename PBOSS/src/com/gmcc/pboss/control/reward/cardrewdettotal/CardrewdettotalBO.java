/**
 * auto-generated code
 * Tue Oct 18 19:25:01 CST 2011
 */
package com.gmcc.pboss.control.reward.cardrewdettotal;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.reward.cardrewdet.CardrewdetDAO;
import com.gmcc.pboss.business.reward.cardrewdet.CardrewdetDBParam;
import com.gmcc.pboss.business.reward.cardrewdettotal.CardrewdettotalDBParam;
import com.gmcc.pboss.business.reward.cardrewdettotal.CardrewdettotalDAO;
import com.gmcc.pboss.business.reward.cardrewdettotal.CardrewdettotalVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: CardrewdettotalBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CardrewdettotalBO extends AbstractControlBean implements
		Cardrewdettotal {

	public CardrewdettotalVO doCreate(CardrewdettotalVO vo) throws Exception {
		try {
			CardrewdettotalDAO dao = (CardrewdettotalDAO) DAOFactory.build(CardrewdettotalDAO.class, user);
			// TODO set the pk */
			return (CardrewdettotalVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CardrewdettotalVO vo) throws Exception {
		try {
			CardrewdettotalDAO dao = (CardrewdettotalDAO) DAOFactory.build(CardrewdettotalDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CardrewdettotalDAO dao = (CardrewdettotalDAO) DAOFactory.build(CardrewdettotalDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CardrewdettotalVO doUpdate(CardrewdettotalVO vo) throws Exception {
		try {
			CardrewdettotalDAO dao = (CardrewdettotalDAO) DAOFactory.build(CardrewdettotalDAO.class,user);
			return (CardrewdettotalVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CardrewdettotalVO doFindByPk(Serializable pk) throws Exception {
		CardrewdettotalDAO dao = (CardrewdettotalDAO) DAOFactory.build(CardrewdettotalDAO.class,user);
		return (CardrewdettotalVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CardrewdettotalDBParam params)
			throws Exception {
		CardrewdettotalDAO dao = (CardrewdettotalDAO) DAOFactory.build(CardrewdettotalDAO.class,user);
		return dao.query(params);
	}
	public DataPackage doQu(Map<String, String> conditionMap,
			CardrewdettotalDBParam params) throws Exception {
		// TODO Auto-generated method stub
		CardrewdettotalDAO dao = (CardrewdettotalDAO) DAOFactory.build(CardrewdettotalDAO.class,user);
		return dao.doGroup(conditionMap, params);
	}
}
