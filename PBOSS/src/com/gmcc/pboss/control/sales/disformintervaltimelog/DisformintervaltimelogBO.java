/**
 * auto-generated code
 * Sat Mar 31 19:18:17 CST 2012
 */
package com.gmcc.pboss.control.sales.disformintervaltimelog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.disformintervaltimelog.DisformintervaltimelogDBParam;
import com.gmcc.pboss.business.sales.disformintervaltimelog.DisformintervaltimelogDAO;
import com.gmcc.pboss.business.sales.disformintervaltimelog.DisformintervaltimelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: DisformintervaltimelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class DisformintervaltimelogBO extends AbstractControlBean implements
		Disformintervaltimelog {

	public DisformintervaltimelogVO doCreate(DisformintervaltimelogVO vo) throws Exception {
		try {
			DisformintervaltimelogDAO dao = (DisformintervaltimelogDAO) DAOFactory.build(DisformintervaltimelogDAO.class, user);
			// TODO set the pk */
			return (DisformintervaltimelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(DisformintervaltimelogVO vo) throws Exception {
		try {
			DisformintervaltimelogDAO dao = (DisformintervaltimelogDAO) DAOFactory.build(DisformintervaltimelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DisformintervaltimelogDAO dao = (DisformintervaltimelogDAO) DAOFactory.build(DisformintervaltimelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisformintervaltimelogVO doUpdate(DisformintervaltimelogVO vo) throws Exception {
		try {
			DisformintervaltimelogDAO dao = (DisformintervaltimelogDAO) DAOFactory.build(DisformintervaltimelogDAO.class,user);
			return (DisformintervaltimelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisformintervaltimelogVO doFindByPk(Serializable pk) throws Exception {
		DisformintervaltimelogDAO dao = (DisformintervaltimelogDAO) DAOFactory.build(DisformintervaltimelogDAO.class,user);
		return (DisformintervaltimelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(DisformintervaltimelogDBParam params)
			throws Exception {
		DisformintervaltimelogDAO dao = (DisformintervaltimelogDAO) DAOFactory.build(DisformintervaltimelogDAO.class,user);
		return dao.query(params);
	}
}
