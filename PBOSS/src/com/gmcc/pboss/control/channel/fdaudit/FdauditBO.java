/**
 * auto-generated code
 * Wed Oct 07 14:01:03 CST 2009
 */
package com.gmcc.pboss.control.channel.fdaudit;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.fdaudit.FdauditDAO;
import com.gmcc.pboss.business.channel.fdaudit.FdauditDBParam;
import com.gmcc.pboss.business.channel.fdaudit.FdauditVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: FdauditBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class FdauditBO extends AbstractControlBean implements
		Fdaudit {

	public FdauditVO doCreate(FdauditVO vo) throws Exception {
		try {
			FdauditDAO dao = (FdauditDAO) DAOFactory.build(FdauditDAO.class, user);
			// TODO set the pk */
			return (FdauditVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(FdauditVO vo) throws Exception {
		try {
			FdauditDAO dao = (FdauditDAO) DAOFactory.build(FdauditDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			FdauditDAO dao = (FdauditDAO) DAOFactory.build(FdauditDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public FdauditVO doUpdate(FdauditVO vo) throws Exception {
		try {
			FdauditDAO dao = (FdauditDAO) DAOFactory.build(FdauditDAO.class,user);
			return (FdauditVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public FdauditVO doFindByPk(Serializable pk) throws Exception {
		FdauditDAO dao = (FdauditDAO) DAOFactory.build(FdauditDAO.class,user);
		return (FdauditVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(FdauditDBParam params)
			throws Exception {
		FdauditDAO dao = (FdauditDAO) DAOFactory.build(FdauditDAO.class,user);
		return dao.query(params);
	}
	
	public Object doGetorgVO(Object vo, DBAccessUser user) throws Exception {
		FdauditDAO dao = (FdauditDAO) DAOFactory.build(FdauditDAO.class, user);
		return dao.doGetorgVO(vo, user);
	}
}
