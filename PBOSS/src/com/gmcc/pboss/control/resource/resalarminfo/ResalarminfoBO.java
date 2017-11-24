/**
 * auto-generated code
 * Fri Jul 09 09:11:20 CST 2010
 */
package com.gmcc.pboss.control.resource.resalarminfo;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.resalarminfo.ResalarminfoDBParam;
import com.gmcc.pboss.business.resource.resalarminfo.ResalarminfoDAO;
import com.gmcc.pboss.business.resource.resalarminfo.ResalarminfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ResalarminfoBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResalarminfoBO extends AbstractControlBean implements
		Resalarminfo {

	public ResalarminfoVO doCreate(ResalarminfoVO vo) throws Exception {
		try {
			ResalarminfoDAO dao = (ResalarminfoDAO) DAOFactory.build(ResalarminfoDAO.class, user);
			// TODO set the pk */
			return (ResalarminfoVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ResalarminfoVO vo) throws Exception {
		try {
			ResalarminfoDAO dao = (ResalarminfoDAO) DAOFactory.build(ResalarminfoDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ResalarminfoDAO dao = (ResalarminfoDAO) DAOFactory.build(ResalarminfoDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResalarminfoVO doUpdate(ResalarminfoVO vo) throws Exception {
		try {
			ResalarminfoDAO dao = (ResalarminfoDAO) DAOFactory.build(ResalarminfoDAO.class,user);
			return (ResalarminfoVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResalarminfoVO doFindByPk(Serializable pk) throws Exception {
		ResalarminfoDAO dao = (ResalarminfoDAO) DAOFactory.build(ResalarminfoDAO.class,user);
		return (ResalarminfoVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ResalarminfoDBParam params)
			throws Exception {
		ResalarminfoDAO dao = (ResalarminfoDAO) DAOFactory.build(ResalarminfoDAO.class,user);
		return dao.query(params);
	}
}
