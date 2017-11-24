/**
 * auto-generated code
 * Tue Aug 09 20:23:41 CST 2011
 */
package com.gmcc.pboss.control.resource.cityrescode;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.cityrescode.CityrescodeDBParam;
import com.gmcc.pboss.business.resource.cityrescode.CityrescodeDAO;
import com.gmcc.pboss.business.resource.cityrescode.CityrescodeVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: CityrescodeBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class CityrescodeBO extends AbstractControlBean implements
		Cityrescode {

	public CityrescodeVO doCreate(CityrescodeVO vo) throws Exception {
		try {
			CityrescodeDAO dao = (CityrescodeDAO) DAOFactory.build(CityrescodeDAO.class, user);
			// TODO set the pk */
			return (CityrescodeVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CityrescodeVO vo) throws Exception {
		try {
			CityrescodeDAO dao = (CityrescodeDAO) DAOFactory.build(CityrescodeDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CityrescodeDAO dao = (CityrescodeDAO) DAOFactory.build(CityrescodeDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CityrescodeVO doUpdate(CityrescodeVO vo) throws Exception {
		try {
			CityrescodeDAO dao = (CityrescodeDAO) DAOFactory.build(CityrescodeDAO.class,user);
			return (CityrescodeVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CityrescodeVO doFindByPk(Serializable pk) throws Exception {
		CityrescodeDAO dao = (CityrescodeDAO) DAOFactory.build(CityrescodeDAO.class,user);
		return (CityrescodeVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CityrescodeDBParam params)
			throws Exception {
		CityrescodeDAO dao = (CityrescodeDAO) DAOFactory.build(CityrescodeDAO.class,user);
		return dao.query(params);
	}
}
