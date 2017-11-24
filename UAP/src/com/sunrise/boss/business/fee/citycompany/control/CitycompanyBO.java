/**
 * auto-generated code
 * Fri Aug 25 11:23:52 CST 2006
 */
package com.sunrise.boss.business.fee.citycompany.control;

import java.io.Serializable;

import org.hibernate.NonUniqueResultException;

import com.sunrise.boss.business.fee.citycompany.persistent.CitycompanyDAO;
import com.sunrise.boss.business.fee.citycompany.persistent.CitycompanyDBParam;
import com.sunrise.boss.business.fee.citycompany.persistent.CitycompanyVO;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


/**
 * <p>
 * Title: CitycompanyControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author yjr
 * @version 1.0
 */

public class CitycompanyBO extends AbstractControlBean implements
		Citycompany {

	public CitycompanyVO doCreate(CitycompanyVO vo) throws Exception {
		try {
			// TODO set the pk */
			CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(
					CitycompanyDAO.class, user);
			if (dao.findByPk(vo.getCitycompid()) != null) {
				throw new BusinessException("市公司编码重复");
			}
			return (CitycompanyVO) dao.create(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void doRemove(CitycompanyVO vo) throws Exception {
		try {
			CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(
					CitycompanyDAO.class, user);
		
			dao.remove(vo);

		} catch (Exception ex) {
			throw ex;
		}
	}

	public CitycompanyVO doUpdate(CitycompanyVO vo) throws Exception {
		try {
			CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(
					CitycompanyDAO.class, user);
			return (CitycompanyVO) dao.update(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public CitycompanyVO doFindByPk(Serializable pk)
			throws Exception {
		CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(
				CitycompanyDAO.class, user);
		return (CitycompanyVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CitycompanyDBParam params)
			throws Exception {
		CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(
				CitycompanyDAO.class, user);
		return dao.query(params);
	}
	
}
