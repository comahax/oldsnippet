/**
 * auto-generated code
 * Fri Dec 07 14:12:22 CST 2012
 */
package com.gmcc.pboss.control.resource.simnoactinfo;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.simnoactinfo.SimnoactinfoDBParam;
import com.gmcc.pboss.business.resource.simnoactinfo.SimnoactinfoDAO;
import com.gmcc.pboss.business.resource.simnoactinfo.SimnoactinfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: SimnoactinfoBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class SimnoactinfoBO extends AbstractControlBean implements
		Simnoactinfo {

	public SimnoactinfoVO doCreate(SimnoactinfoVO vo) throws Exception {
		try {
			SimnoactinfoDAO dao = (SimnoactinfoDAO) DAOFactory.build(SimnoactinfoDAO.class, user);
			// TODO set the pk */
			return (SimnoactinfoVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SimnoactinfoVO vo) throws Exception {
		try {
			SimnoactinfoDAO dao = (SimnoactinfoDAO) DAOFactory.build(SimnoactinfoDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SimnoactinfoDAO dao = (SimnoactinfoDAO) DAOFactory.build(SimnoactinfoDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SimnoactinfoVO doUpdate(SimnoactinfoVO vo) throws Exception {
		try {
			SimnoactinfoDAO dao = (SimnoactinfoDAO) DAOFactory.build(SimnoactinfoDAO.class,user);
			return (SimnoactinfoVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SimnoactinfoVO doFindByPk(Serializable pk) throws Exception {
		SimnoactinfoDAO dao = (SimnoactinfoDAO) DAOFactory.build(SimnoactinfoDAO.class,user);
		return (SimnoactinfoVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SimnoactinfoDBParam params)
			throws Exception {
		SimnoactinfoDAO dao = (SimnoactinfoDAO) DAOFactory.build(SimnoactinfoDAO.class,user);
		return dao.query(params);
	}
}
