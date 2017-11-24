/**
 * auto-generated code
 * Wed Nov 14 09:59:20 CST 2012
 */
package com.gmcc.pboss.control.channel.waybusicirclelog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waybusicirclelog.WaybusicirclelogDBParam;
import com.gmcc.pboss.business.channel.waybusicirclelog.WaybusicirclelogDAO;
import com.gmcc.pboss.business.channel.waybusicirclelog.WaybusicirclelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: WaybusicirclelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class WaybusicirclelogBO extends AbstractControlBean implements
		Waybusicirclelog {

	public WaybusicirclelogVO doCreate(WaybusicirclelogVO vo) throws Exception {
		try {
			WaybusicirclelogDAO dao = (WaybusicirclelogDAO) DAOFactory.build(WaybusicirclelogDAO.class, user);
			// TODO set the pk */
			return (WaybusicirclelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WaybusicirclelogVO vo) throws Exception {
		try {
			WaybusicirclelogDAO dao = (WaybusicirclelogDAO) DAOFactory.build(WaybusicirclelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WaybusicirclelogDAO dao = (WaybusicirclelogDAO) DAOFactory.build(WaybusicirclelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaybusicirclelogVO doUpdate(WaybusicirclelogVO vo) throws Exception {
		try {
			WaybusicirclelogDAO dao = (WaybusicirclelogDAO) DAOFactory.build(WaybusicirclelogDAO.class,user);
			return (WaybusicirclelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaybusicirclelogVO doFindByPk(Serializable pk) throws Exception {
		WaybusicirclelogDAO dao = (WaybusicirclelogDAO) DAOFactory.build(WaybusicirclelogDAO.class,user);
		return (WaybusicirclelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaybusicirclelogDBParam params)
			throws Exception {
		WaybusicirclelogDAO dao = (WaybusicirclelogDAO) DAOFactory.build(WaybusicirclelogDAO.class,user);
		return dao.query(params);
	}
}
