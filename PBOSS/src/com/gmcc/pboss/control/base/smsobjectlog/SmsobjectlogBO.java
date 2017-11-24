/**
 * auto-generated code
 * Tue Jul 05 10:51:39 CST 2011
 */
package com.gmcc.pboss.control.base.smsobjectlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.smsobjectlog.SmsobjectlogDBParam;
import com.gmcc.pboss.business.base.smsobjectlog.SmsobjectlogDAO;
import com.gmcc.pboss.business.base.smsobjectlog.SmsobjectlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: SmsobjectlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public class SmsobjectlogBO extends AbstractControlBean implements
		Smsobjectlog {

	public SmsobjectlogVO doCreate(SmsobjectlogVO vo) throws Exception {
		try {
			SmsobjectlogDAO dao = (SmsobjectlogDAO) DAOFactory.build(SmsobjectlogDAO.class, user);
			// TODO set the pk */
			return (SmsobjectlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SmsobjectlogVO vo) throws Exception {
		try {
			SmsobjectlogDAO dao = (SmsobjectlogDAO) DAOFactory.build(SmsobjectlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SmsobjectlogDAO dao = (SmsobjectlogDAO) DAOFactory.build(SmsobjectlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmsobjectlogVO doUpdate(SmsobjectlogVO vo) throws Exception {
		try {
			SmsobjectlogDAO dao = (SmsobjectlogDAO) DAOFactory.build(SmsobjectlogDAO.class,user);
			return (SmsobjectlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmsobjectlogVO doFindByPk(Serializable pk) throws Exception {
		SmsobjectlogDAO dao = (SmsobjectlogDAO) DAOFactory.build(SmsobjectlogDAO.class,user);
		return (SmsobjectlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SmsobjectlogDBParam params)
			throws Exception {
		SmsobjectlogDAO dao = (SmsobjectlogDAO) DAOFactory.build(SmsobjectlogDAO.class,user);
		return dao.query(params);
	}
}
