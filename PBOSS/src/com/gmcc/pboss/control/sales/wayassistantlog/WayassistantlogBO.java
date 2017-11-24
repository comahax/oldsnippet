/**
 * auto-generated code
 * Thu Jul 14 20:18:52 CST 2011
 */
package com.gmcc.pboss.control.sales.wayassistantlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.wayassistantlog.WayassistantlogDBParam;
import com.gmcc.pboss.business.sales.wayassistantlog.WayassistantlogDAO;
import com.gmcc.pboss.business.sales.wayassistantlog.WayassistantlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: WayassistantlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class WayassistantlogBO extends AbstractControlBean implements
		Wayassistantlog {

	public WayassistantlogVO doCreate(WayassistantlogVO vo) throws Exception {
		try {
			WayassistantlogDAO dao = (WayassistantlogDAO) DAOFactory.build(WayassistantlogDAO.class, user);
			// TODO set the pk */
			return (WayassistantlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WayassistantlogVO vo) throws Exception {
		try {
			WayassistantlogDAO dao = (WayassistantlogDAO) DAOFactory.build(WayassistantlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WayassistantlogDAO dao = (WayassistantlogDAO) DAOFactory.build(WayassistantlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayassistantlogVO doUpdate(WayassistantlogVO vo) throws Exception {
		try {
			WayassistantlogDAO dao = (WayassistantlogDAO) DAOFactory.build(WayassistantlogDAO.class,user);
			return (WayassistantlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayassistantlogVO doFindByPk(Serializable pk) throws Exception {
		WayassistantlogDAO dao = (WayassistantlogDAO) DAOFactory.build(WayassistantlogDAO.class,user);
		return (WayassistantlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WayassistantlogDBParam params)
			throws Exception {
		WayassistantlogDAO dao = (WayassistantlogDAO) DAOFactory.build(WayassistantlogDAO.class,user);
		return dao.query(params);
	}
}
