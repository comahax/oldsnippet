/**
 * auto-generated code
 * Wed Nov 14 09:58:49 CST 2012
 */
package com.gmcc.pboss.control.channel.waybusicircle;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleDBParam;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleDAO;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: WaybusicircleBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class WaybusicircleBO extends AbstractControlBean implements
		Waybusicircle {

	public WaybusicircleVO doCreate(WaybusicircleVO vo) throws Exception {
		try {
			WaybusicircleDAO dao = (WaybusicircleDAO) DAOFactory.build(WaybusicircleDAO.class, user);
			// TODO set the pk */
			return (WaybusicircleVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WaybusicircleVO vo) throws Exception {
		try {
			WaybusicircleDAO dao = (WaybusicircleDAO) DAOFactory.build(WaybusicircleDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WaybusicircleDAO dao = (WaybusicircleDAO) DAOFactory.build(WaybusicircleDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaybusicircleVO doUpdate(WaybusicircleVO vo) throws Exception {
		try {
			WaybusicircleDAO dao = (WaybusicircleDAO) DAOFactory.build(WaybusicircleDAO.class,user);
			return (WaybusicircleVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaybusicircleVO doFindByPk(Serializable pk) throws Exception {
		WaybusicircleDAO dao = (WaybusicircleDAO) DAOFactory.build(WaybusicircleDAO.class,user);
		return (WaybusicircleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaybusicircleDBParam params)
			throws Exception {
		WaybusicircleDAO dao = (WaybusicircleDAO) DAOFactory.build(WaybusicircleDAO.class,user);
		return dao.query(params);
	}
}
