/**
 * auto-generated code
 * Sun Oct 18 20:23:20 CST 2009
 */
package com.gmcc.pboss.control.channel.waylog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waylog.WaylogDBParam;
import com.gmcc.pboss.business.channel.waylog.WaylogDAO;
import com.gmcc.pboss.business.channel.waylog.WaylogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WaylogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WaylogBO extends AbstractControlBean implements
		Waylog {

	public WaylogVO doCreate(WaylogVO vo) throws Exception {
		try {
			WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class, user);
			// TODO set the pk */
			return (WaylogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WaylogVO vo) throws Exception {
		try {
			WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaylogVO doUpdate(WaylogVO vo) throws Exception {
		try {
			WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class,user);
			return (WaylogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaylogVO doFindByPk(Serializable pk) throws Exception {
		WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class,user);
		return (WaylogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaylogDBParam params)
			throws Exception {
		WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class,user);
		return dao.query(params);
	}
}
