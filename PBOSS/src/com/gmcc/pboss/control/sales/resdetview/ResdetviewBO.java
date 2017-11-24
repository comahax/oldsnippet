/**
 * auto-generated code
 * Sun Oct 18 15:07:09 CST 2009
 */
package com.gmcc.pboss.control.sales.resdetview;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.resdetview.ResdetviewDBParam;
import com.gmcc.pboss.business.sales.resdetview.ResdetviewDAO;
import com.gmcc.pboss.business.sales.resdetview.ResdetviewVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ResdetviewBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class ResdetviewBO extends AbstractControlBean implements
		Resdetview {

	public ResdetviewVO doCreate(ResdetviewVO vo) throws Exception {
		try {
			ResdetviewDAO dao = (ResdetviewDAO) DAOFactory.build(ResdetviewDAO.class, user);
			// TODO set the pk */
			return (ResdetviewVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ResdetviewVO vo) throws Exception {
		try {
			ResdetviewDAO dao = (ResdetviewDAO) DAOFactory.build(ResdetviewDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ResdetviewDAO dao = (ResdetviewDAO) DAOFactory.build(ResdetviewDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResdetviewVO doUpdate(ResdetviewVO vo) throws Exception {
		try {
			ResdetviewDAO dao = (ResdetviewDAO) DAOFactory.build(ResdetviewDAO.class,user);
			return (ResdetviewVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResdetviewVO doFindByPk(Serializable pk) throws Exception {
		ResdetviewDAO dao = (ResdetviewDAO) DAOFactory.build(ResdetviewDAO.class,user);
		return (ResdetviewVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ResdetviewDBParam params)
			throws Exception {
		ResdetviewDAO dao = (ResdetviewDAO) DAOFactory.build(ResdetviewDAO.class,user);
		return dao.query(params);
	}
}
