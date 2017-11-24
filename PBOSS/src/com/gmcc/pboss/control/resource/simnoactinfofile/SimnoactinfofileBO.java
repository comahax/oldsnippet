/**
 * auto-generated code
 * Fri Dec 07 14:13:24 CST 2012
 */
package com.gmcc.pboss.control.resource.simnoactinfofile;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.simnoactinfofile.SimnoactinfofileDBParam;
import com.gmcc.pboss.business.resource.simnoactinfofile.SimnoactinfofileDAO;
import com.gmcc.pboss.business.resource.simnoactinfofile.SimnoactinfofileVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: SimnoactinfofileBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class SimnoactinfofileBO extends AbstractControlBean implements
		Simnoactinfofile {

	public SimnoactinfofileVO doCreate(SimnoactinfofileVO vo) throws Exception {
		try {
			SimnoactinfofileDAO dao = (SimnoactinfofileDAO) DAOFactory.build(SimnoactinfofileDAO.class, user);
			// TODO set the pk */
			return (SimnoactinfofileVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SimnoactinfofileVO vo) throws Exception {
		try {
			SimnoactinfofileDAO dao = (SimnoactinfofileDAO) DAOFactory.build(SimnoactinfofileDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SimnoactinfofileDAO dao = (SimnoactinfofileDAO) DAOFactory.build(SimnoactinfofileDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SimnoactinfofileVO doUpdate(SimnoactinfofileVO vo) throws Exception {
		try {
			SimnoactinfofileDAO dao = (SimnoactinfofileDAO) DAOFactory.build(SimnoactinfofileDAO.class,user);
			return (SimnoactinfofileVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SimnoactinfofileVO doFindByPk(Serializable pk) throws Exception {
		SimnoactinfofileDAO dao = (SimnoactinfofileDAO) DAOFactory.build(SimnoactinfofileDAO.class,user);
		return (SimnoactinfofileVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SimnoactinfofileDBParam params)
			throws Exception {
		SimnoactinfofileDAO dao = (SimnoactinfofileDAO) DAOFactory.build(SimnoactinfofileDAO.class,user);
		return dao.query(params);
	}
}
