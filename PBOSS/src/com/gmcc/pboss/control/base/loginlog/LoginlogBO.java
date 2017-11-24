/**
 * auto-generated code
 * Mon Dec 20 10:03:23 CST 2010
 */
package com.gmcc.pboss.control.base.loginlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.loginlog.LoginlogDBParam;
import com.gmcc.pboss.business.base.loginlog.LoginlogDAO;
import com.gmcc.pboss.business.base.loginlog.LoginlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: LoginlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class LoginlogBO extends AbstractControlBean implements
		Loginlog {

	public LoginlogVO doCreate(LoginlogVO vo) throws Exception {
		try {
			LoginlogDAO dao = (LoginlogDAO) DAOFactory.build(LoginlogDAO.class, user);
			// TODO set the pk */
			return (LoginlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(LoginlogVO vo) throws Exception {
		try {
			LoginlogDAO dao = (LoginlogDAO) DAOFactory.build(LoginlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			LoginlogDAO dao = (LoginlogDAO) DAOFactory.build(LoginlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public LoginlogVO doUpdate(LoginlogVO vo) throws Exception {
		try {
			LoginlogDAO dao = (LoginlogDAO) DAOFactory.build(LoginlogDAO.class,user);
			return (LoginlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public LoginlogVO doFindByPk(Serializable pk) throws Exception {
		LoginlogDAO dao = (LoginlogDAO) DAOFactory.build(LoginlogDAO.class,user);
		return (LoginlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(LoginlogDBParam params)
			throws Exception {
		LoginlogDAO dao = (LoginlogDAO) DAOFactory.build(LoginlogDAO.class,user);
		return dao.query(params);
	}
}
