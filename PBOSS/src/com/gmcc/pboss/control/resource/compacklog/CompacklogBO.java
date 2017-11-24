/**
 * auto-generated code
 * Fri Sep 25 15:12:44 CST 2009
 */
package com.gmcc.pboss.control.resource.compacklog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.compacklog.CompacklogDBParam;
import com.gmcc.pboss.business.resource.compacklog.CompacklogDAO;
import com.gmcc.pboss.business.resource.compacklog.CompacklogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: CompacklogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class CompacklogBO extends AbstractControlBean implements
		Compacklog {

	public CompacklogVO doCreate(CompacklogVO vo) throws Exception {
		try {
			CompacklogDAO dao = (CompacklogDAO) DAOFactory.build(CompacklogDAO.class, user);
			// TODO set the pk */
			return (CompacklogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CompacklogVO vo) throws Exception {
		try {
			CompacklogDAO dao = (CompacklogDAO) DAOFactory.build(CompacklogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CompacklogDAO dao = (CompacklogDAO) DAOFactory.build(CompacklogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CompacklogVO doUpdate(CompacklogVO vo) throws Exception {
		try {
			CompacklogDAO dao = (CompacklogDAO) DAOFactory.build(CompacklogDAO.class,user);
			return (CompacklogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CompacklogVO doFindByPk(Serializable pk) throws Exception {
		CompacklogDAO dao = (CompacklogDAO) DAOFactory.build(CompacklogDAO.class,user);
		return (CompacklogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CompacklogDBParam params)
			throws Exception {
		CompacklogDAO dao = (CompacklogDAO) DAOFactory.build(CompacklogDAO.class,user);
		return dao.query(params);
	}
}
