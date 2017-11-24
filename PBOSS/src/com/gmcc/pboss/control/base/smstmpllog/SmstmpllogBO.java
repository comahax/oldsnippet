/**
 * auto-generated code
 * Mon Dec 21 09:17:48 CST 2009
 */
package com.gmcc.pboss.control.base.smstmpllog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.smstmpllog.SmstmpllogDBParam;
import com.gmcc.pboss.business.base.smstmpllog.SmstmpllogDAO;
import com.gmcc.pboss.business.base.smstmpllog.SmstmpllogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: SmstmpllogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SmstmpllogBO extends AbstractControlBean implements
		Smstmpllog {

	public SmstmpllogVO doCreate(SmstmpllogVO vo) throws Exception {
		try {
			SmstmpllogDAO dao = (SmstmpllogDAO) DAOFactory.build(SmstmpllogDAO.class, user);
			// TODO set the pk */
			return (SmstmpllogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SmstmpllogVO vo) throws Exception {
		try {
			SmstmpllogDAO dao = (SmstmpllogDAO) DAOFactory.build(SmstmpllogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SmstmpllogDAO dao = (SmstmpllogDAO) DAOFactory.build(SmstmpllogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmstmpllogVO doUpdate(SmstmpllogVO vo) throws Exception {
		try {
			SmstmpllogDAO dao = (SmstmpllogDAO) DAOFactory.build(SmstmpllogDAO.class,user);
			return (SmstmpllogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmstmpllogVO doFindByPk(Serializable pk) throws Exception {
		SmstmpllogDAO dao = (SmstmpllogDAO) DAOFactory.build(SmstmpllogDAO.class,user);
		return (SmstmpllogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SmstmpllogDBParam params)
			throws Exception {
		SmstmpllogDAO dao = (SmstmpllogDAO) DAOFactory.build(SmstmpllogDAO.class,user);
		return dao.query(params);
	}
}
