/**
 * auto-generated code
 * Wed Sep 21 15:48:50 CST 2011
 */
package com.gmcc.pboss.control.base.dbloginlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.dbloginlog.DbLoginlogDBParam;
import com.gmcc.pboss.business.base.dbloginlog.DbLoginlogDAO;
import com.gmcc.pboss.business.base.dbloginlog.DbLoginlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: DbLoginlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class DbLoginlogBO extends AbstractControlBean implements
		DbLoginlog {

	public DbLoginlogVO doCreate(DbLoginlogVO vo) throws Exception {
		try {
			DbLoginlogDAO dao = (DbLoginlogDAO) DAOFactory.build(DbLoginlogDAO.class, user);
			// TODO set the pk */
			return (DbLoginlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(DbLoginlogVO vo) throws Exception {
		try {
			DbLoginlogDAO dao = (DbLoginlogDAO) DAOFactory.build(DbLoginlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DbLoginlogDAO dao = (DbLoginlogDAO) DAOFactory.build(DbLoginlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DbLoginlogVO doUpdate(DbLoginlogVO vo) throws Exception {
		try {
			DbLoginlogDAO dao = (DbLoginlogDAO) DAOFactory.build(DbLoginlogDAO.class,user);
			return (DbLoginlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DbLoginlogVO doFindByPk(Serializable pk) throws Exception {
		DbLoginlogDAO dao = (DbLoginlogDAO) DAOFactory.build(DbLoginlogDAO.class,user);
		return (DbLoginlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(DbLoginlogDBParam params)
			throws Exception {
		DbLoginlogDAO dao = (DbLoginlogDAO) DAOFactory.build(DbLoginlogDAO.class,user);
		return dao.query(params);
	}
}
