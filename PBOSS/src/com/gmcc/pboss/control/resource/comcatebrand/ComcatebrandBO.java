/**
 * auto-generated code
 * Sat Aug 13 11:12:29 CST 2011
 */
package com.gmcc.pboss.control.resource.comcatebrand;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandDAO;
import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandDBParam;
import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ComcatebrandBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class ComcatebrandBO extends AbstractControlBean implements
		Comcatebrand {

	public ComcatebrandVO doCreate(ComcatebrandVO vo) throws Exception {
		try {
			ComcatebrandDAO dao = (ComcatebrandDAO) DAOFactory.build(ComcatebrandDAO.class, user);
			// TODO set the pk */
			return (ComcatebrandVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComcatebrandVO vo) throws Exception {
		try {
			ComcatebrandDAO dao = (ComcatebrandDAO) DAOFactory.build(ComcatebrandDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ComcatebrandDAO dao = (ComcatebrandDAO) DAOFactory.build(ComcatebrandDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComcatebrandVO doUpdate(ComcatebrandVO vo) throws Exception {
		try {
			ComcatebrandDAO dao = (ComcatebrandDAO) DAOFactory.build(ComcatebrandDAO.class,user);
			return (ComcatebrandVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComcatebrandVO doFindByPk(Serializable pk) throws Exception {
		ComcatebrandDAO dao = (ComcatebrandDAO) DAOFactory.build(ComcatebrandDAO.class,user);
		return (ComcatebrandVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ComcatebrandDBParam params)
			throws Exception {
		ComcatebrandDAO dao = (ComcatebrandDAO) DAOFactory.build(ComcatebrandDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doQueryRes2Comcate(ComcatebrandDBParam params,String cityid)
			throws Exception {
		ComcatebrandDAO dao = (ComcatebrandDAO) DAOFactory.build(ComcatebrandDAO.class,user);
		return dao.doQueryRes2Comcate(params,cityid);
	}
}
