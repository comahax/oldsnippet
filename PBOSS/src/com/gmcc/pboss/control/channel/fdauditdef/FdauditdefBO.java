/**
 * auto-generated code
 * Wed Oct 07 20:21:59 CST 2009
 */
package com.gmcc.pboss.control.channel.fdauditdef;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.fdauditdef.FdauditdefDBParam;
import com.gmcc.pboss.business.channel.fdauditdef.FdauditdefDAO;
import com.gmcc.pboss.business.channel.fdauditdef.FdauditdefVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: FdauditdefBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class FdauditdefBO extends AbstractControlBean implements
		Fdauditdef {

	public FdauditdefVO doCreate(FdauditdefVO vo) throws Exception {
		try {
			FdauditdefDAO dao = (FdauditdefDAO) DAOFactory.build(FdauditdefDAO.class, user);
			// TODO set the pk */
			return (FdauditdefVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(FdauditdefVO vo) throws Exception {
		try {
			FdauditdefDAO dao = (FdauditdefDAO) DAOFactory.build(FdauditdefDAO.class,user);
			dao.remove(dao.findByPk(vo));
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			FdauditdefDAO dao = (FdauditdefDAO) DAOFactory.build(FdauditdefDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public FdauditdefVO doUpdate(FdauditdefVO vo) throws Exception {
		try {
			FdauditdefDAO dao = (FdauditdefDAO) DAOFactory.build(FdauditdefDAO.class,user);
			return (FdauditdefVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public FdauditdefVO doFindByPk(Serializable pk) throws Exception {
		FdauditdefDAO dao = (FdauditdefDAO) DAOFactory.build(FdauditdefDAO.class,user);
		return (FdauditdefVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(FdauditdefDBParam params)
			throws Exception {
		FdauditdefDAO dao = (FdauditdefDAO) DAOFactory.build(FdauditdefDAO.class,user);
		return dao.query(params);
	}
}
