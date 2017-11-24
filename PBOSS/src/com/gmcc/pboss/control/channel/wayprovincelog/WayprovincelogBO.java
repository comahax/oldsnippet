/**
 * auto-generated code
 * Fri Aug 05 08:57:56 CST 2011
 */
package com.gmcc.pboss.control.channel.wayprovincelog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.wayprovincelog.WayprovincelogDBParam;
import com.gmcc.pboss.business.channel.wayprovincelog.WayprovincelogDAO;
import com.gmcc.pboss.business.channel.wayprovincelog.WayprovincelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: WayprovincelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class WayprovincelogBO extends AbstractControlBean implements
		Wayprovincelog {

	public WayprovincelogVO doCreate(WayprovincelogVO vo) throws Exception {
		try {
			WayprovincelogDAO dao = (WayprovincelogDAO) DAOFactory.build(WayprovincelogDAO.class, user);
			// TODO set the pk */
			return (WayprovincelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WayprovincelogVO vo) throws Exception {
		try {
			WayprovincelogDAO dao = (WayprovincelogDAO) DAOFactory.build(WayprovincelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WayprovincelogDAO dao = (WayprovincelogDAO) DAOFactory.build(WayprovincelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayprovincelogVO doUpdate(WayprovincelogVO vo) throws Exception {
		try {
			WayprovincelogDAO dao = (WayprovincelogDAO) DAOFactory.build(WayprovincelogDAO.class,user);
			return (WayprovincelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayprovincelogVO doFindByPk(Serializable pk) throws Exception {
		WayprovincelogDAO dao = (WayprovincelogDAO) DAOFactory.build(WayprovincelogDAO.class,user);
		return (WayprovincelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WayprovincelogDBParam params)
			throws Exception {
		WayprovincelogDAO dao = (WayprovincelogDAO) DAOFactory.build(WayprovincelogDAO.class,user);
		return dao.query(params);
	}
}
