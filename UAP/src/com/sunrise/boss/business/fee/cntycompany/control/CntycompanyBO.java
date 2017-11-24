/**
 * auto-generated code
 * Fri Aug 25 11:16:40 CST 2006
 */
package com.sunrise.boss.business.fee.cntycompany.control;

import java.io.Serializable;

import org.hibernate.NonUniqueResultException;

import com.sunrise.boss.business.fee.cntycompany.persistent.CntycompanyDAO;
import com.sunrise.boss.business.fee.cntycompany.persistent.CntycompanyDBParam;
import com.sunrise.boss.business.fee.cntycompany.persistent.CntycompanyVO;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: CntycompanyControlBean
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

public class CntycompanyBO extends AbstractControlBean implements
		Cntycompany {

	public CntycompanyVO doCreate(CntycompanyVO vo) throws Exception {
		try {
			// TODO set the pk */
			CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(CntycompanyDAO.class, user);
			if (dao.findByPk(vo.getCountycompid()) != null) {
				throw new BusinessException("县公司编码重复!");
			}
			return (CntycompanyVO) dao.create(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void doRemove(CntycompanyVO vo) throws Exception {
		try {
			CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(CntycompanyDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public CntycompanyVO doUpdate(CntycompanyVO vo) throws Exception {
		try {
			CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(CntycompanyDAO.class, user);
			return (CntycompanyVO) dao.update(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public CntycompanyVO doFindByPk(Serializable pk)
			throws Exception {
		CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(CntycompanyDAO.class, user);
		return (CntycompanyVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CntycompanyDBParam params)
			throws Exception {
		CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(CntycompanyDAO.class, user);
		return dao.query(params);
	}

}
