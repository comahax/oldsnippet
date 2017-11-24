/**
 * auto-generated code
 * Thu Oct 13 15:54:23 CST 2011
 */
package com.gmcc.pboss.control.reward.cardrewdet;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.reward.cardrewdet.CardrewdetDBParam;
import com.gmcc.pboss.business.reward.cardrewdet.CardrewdetDAO;
import com.gmcc.pboss.business.reward.cardrewdet.CardrewdetVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: CardrewdetBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CardrewdetBO extends AbstractControlBean implements
		Cardrewdet {

	public CardrewdetVO doCreate(CardrewdetVO vo) throws Exception {
		try {
			CardrewdetDAO dao = (CardrewdetDAO) DAOFactory.build(CardrewdetDAO.class, user);
			// TODO set the pk */
			return (CardrewdetVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CardrewdetVO vo) throws Exception {
		try {
			CardrewdetDAO dao = (CardrewdetDAO) DAOFactory.build(CardrewdetDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CardrewdetDAO dao = (CardrewdetDAO) DAOFactory.build(CardrewdetDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CardrewdetVO doUpdate(CardrewdetVO vo) throws Exception {
		try {
			CardrewdetDAO dao = (CardrewdetDAO) DAOFactory.build(CardrewdetDAO.class,user);
			return (CardrewdetVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CardrewdetVO doFindByPk(Serializable pk) throws Exception {
		CardrewdetDAO dao = (CardrewdetDAO) DAOFactory.build(CardrewdetDAO.class,user);
		return (CardrewdetVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CardrewdetDBParam params)
			throws Exception {
		CardrewdetDAO dao = (CardrewdetDAO) DAOFactory.build(CardrewdetDAO.class,user);
		return dao.query(params);
	}

	public DataPackage doQu(Map<String, String> conditionMap,
			CardrewdetDBParam params) throws Exception {
		// TODO Auto-generated method stub
		CardrewdetDAO dao = (CardrewdetDAO) DAOFactory.build(CardrewdetDAO.class,user);
		return dao.doGroup(conditionMap, params);
	}
}
