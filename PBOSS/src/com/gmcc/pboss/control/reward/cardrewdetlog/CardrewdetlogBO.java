/**
 * auto-generated code
 * Tue Oct 18 10:45:19 CST 2011
 */
package com.gmcc.pboss.control.reward.cardrewdetlog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.cardrewdetlog.CardrewdetlogDBParam;
import com.gmcc.pboss.business.reward.cardrewdetlog.CardrewdetlogDAO;
import com.gmcc.pboss.business.reward.cardrewdetlog.CardrewdetlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: CardrewdetlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CardrewdetlogBO extends AbstractControlBean implements
		Cardrewdetlog {

	public CardrewdetlogVO doCreate(CardrewdetlogVO vo) throws Exception {
		try {
			CardrewdetlogDAO dao = (CardrewdetlogDAO) DAOFactory.build(CardrewdetlogDAO.class, user);
			// TODO set the pk */
			return (CardrewdetlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CardrewdetlogVO vo) throws Exception {
		try {
			CardrewdetlogDAO dao = (CardrewdetlogDAO) DAOFactory.build(CardrewdetlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CardrewdetlogDAO dao = (CardrewdetlogDAO) DAOFactory.build(CardrewdetlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CardrewdetlogVO doUpdate(CardrewdetlogVO vo) throws Exception {
		try {
			CardrewdetlogDAO dao = (CardrewdetlogDAO) DAOFactory.build(CardrewdetlogDAO.class,user);
			return (CardrewdetlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CardrewdetlogVO doFindByPk(Serializable pk) throws Exception {
		CardrewdetlogDAO dao = (CardrewdetlogDAO) DAOFactory.build(CardrewdetlogDAO.class,user);
		return (CardrewdetlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CardrewdetlogDBParam params)
			throws Exception {
		CardrewdetlogDAO dao = (CardrewdetlogDAO) DAOFactory.build(CardrewdetlogDAO.class,user);
		return dao.query(params);
	}
}
