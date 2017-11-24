/**
 * auto-generated code
 * Tue Aug 09 16:10:47 CST 2011
 */
package com.gmcc.pboss.control.resource.cityrescodelog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.cityrescodelog.CityrescodelogDBParam;
import com.gmcc.pboss.business.resource.cityrescodelog.CityrescodelogDAO;
import com.gmcc.pboss.business.resource.cityrescodelog.CityrescodelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: CityrescodelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class CityrescodelogBO extends AbstractControlBean implements
		Cityrescodelog {

	public CityrescodelogVO doCreate(CityrescodelogVO vo) throws Exception {
		try {
			CityrescodelogDAO dao = (CityrescodelogDAO) DAOFactory.build(CityrescodelogDAO.class, user);
			// TODO set the pk */
			return (CityrescodelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CityrescodelogVO vo) throws Exception {
		try {
			CityrescodelogDAO dao = (CityrescodelogDAO) DAOFactory.build(CityrescodelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CityrescodelogDAO dao = (CityrescodelogDAO) DAOFactory.build(CityrescodelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CityrescodelogVO doUpdate(CityrescodelogVO vo) throws Exception {
		try {
			CityrescodelogDAO dao = (CityrescodelogDAO) DAOFactory.build(CityrescodelogDAO.class,user);
			return (CityrescodelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CityrescodelogVO doFindByPk(Serializable pk) throws Exception {
		CityrescodelogDAO dao = (CityrescodelogDAO) DAOFactory.build(CityrescodelogDAO.class,user);
		return (CityrescodelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CityrescodelogDBParam params)
			throws Exception {
		CityrescodelogDAO dao = (CityrescodelogDAO) DAOFactory.build(CityrescodelogDAO.class,user);
		return dao.query(params);
	}
}
