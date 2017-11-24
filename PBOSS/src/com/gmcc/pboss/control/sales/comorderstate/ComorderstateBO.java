/**
 * auto-generated code
 * Tue Oct 13 09:27:46 CST 2009
 */
package com.gmcc.pboss.control.sales.comorderstate;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.comorderstate.ComorderstateDBParam;
import com.gmcc.pboss.business.sales.comorderstate.ComorderstateDAO;
import com.gmcc.pboss.business.sales.comorderstate.ComorderstateVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ComorderstateBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComorderstateBO extends AbstractControlBean implements
		Comorderstate {

	public ComorderstateVO doCreate(ComorderstateVO vo) throws Exception {
		try {
			ComorderstateDAO dao = (ComorderstateDAO) DAOFactory.build(ComorderstateDAO.class, user);
			// TODO set the pk */
			return (ComorderstateVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComorderstateVO vo) throws Exception {
		try {
			ComorderstateDAO dao = (ComorderstateDAO) DAOFactory.build(ComorderstateDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ComorderstateDAO dao = (ComorderstateDAO) DAOFactory.build(ComorderstateDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComorderstateVO doUpdate(ComorderstateVO vo) throws Exception {
		try {
			ComorderstateDAO dao = (ComorderstateDAO) DAOFactory.build(ComorderstateDAO.class,user);
			return (ComorderstateVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComorderstateVO doFindByPk(Serializable pk) throws Exception {
		ComorderstateDAO dao = (ComorderstateDAO) DAOFactory.build(ComorderstateDAO.class,user);
		return (ComorderstateVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ComorderstateDBParam params)
			throws Exception {
		ComorderstateDAO dao = (ComorderstateDAO) DAOFactory.build(ComorderstateDAO.class,user);
		return dao.query(params);
	}
}
