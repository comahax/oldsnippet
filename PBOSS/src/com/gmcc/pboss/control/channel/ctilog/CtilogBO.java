/**
 * auto-generated code
 * Thu Dec 01 02:07:15 GMT 2011
 */
package com.gmcc.pboss.control.channel.ctilog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.ctilog.CtilogDBParam;
import com.gmcc.pboss.business.channel.ctilog.CtilogDAO;
import com.gmcc.pboss.business.channel.ctilog.CtilogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: CtilogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class CtilogBO extends AbstractControlBean implements
		Ctilog {

	public CtilogVO doCreate(CtilogVO vo) throws Exception {
		try {
			CtilogDAO dao = (CtilogDAO) DAOFactory.build(CtilogDAO.class, user);
			// TODO set the pk */
			return (CtilogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CtilogVO vo) throws Exception {
		try {
			CtilogDAO dao = (CtilogDAO) DAOFactory.build(CtilogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CtilogDAO dao = (CtilogDAO) DAOFactory.build(CtilogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CtilogVO doUpdate(CtilogVO vo) throws Exception {
		try {
			CtilogDAO dao = (CtilogDAO) DAOFactory.build(CtilogDAO.class,user);
			return (CtilogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CtilogVO doFindByPk(Serializable pk) throws Exception {
		CtilogDAO dao = (CtilogDAO) DAOFactory.build(CtilogDAO.class,user);
		return (CtilogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CtilogDBParam params)
			throws Exception {
		CtilogDAO dao = (CtilogDAO) DAOFactory.build(CtilogDAO.class,user);
		return dao.query(params);
	}
}
