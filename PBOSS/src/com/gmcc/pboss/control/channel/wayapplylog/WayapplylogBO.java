/**
 * auto-generated code
 * Mon Nov 23 16:35:24 CST 2009
 */
package com.gmcc.pboss.control.channel.wayapplylog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.wayapplylog.WayapplylogDBParam;
import com.gmcc.pboss.business.channel.wayapplylog.WayapplylogDAO;
import com.gmcc.pboss.business.channel.wayapplylog.WayapplylogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: WayapplylogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WayapplylogBO extends AbstractControlBean implements
		Wayapplylog {

	public WayapplylogVO doCreate(WayapplylogVO vo) throws Exception {
		try {
			WayapplylogDAO dao = (WayapplylogDAO) DAOFactory.build(WayapplylogDAO.class, user);
			// TODO set the pk */
			return (WayapplylogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WayapplylogVO vo) throws Exception {
		try {
			WayapplylogDAO dao = (WayapplylogDAO) DAOFactory.build(WayapplylogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WayapplylogDAO dao = (WayapplylogDAO) DAOFactory.build(WayapplylogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayapplylogVO doUpdate(WayapplylogVO vo) throws Exception {
		try {
			WayapplylogDAO dao = (WayapplylogDAO) DAOFactory.build(WayapplylogDAO.class,user);
			return (WayapplylogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayapplylogVO doFindByPk(Serializable pk) throws Exception {
		WayapplylogDAO dao = (WayapplylogDAO) DAOFactory.build(WayapplylogDAO.class,user);
		return (WayapplylogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WayapplylogDBParam params)
			throws Exception {
		WayapplylogDAO dao = (WayapplylogDAO) DAOFactory.build(WayapplylogDAO.class,user);
		return dao.query(params);
	}
}
