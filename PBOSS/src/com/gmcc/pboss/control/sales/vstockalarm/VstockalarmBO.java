/**
 * auto-generated code
 * Wed Jun 01 09:15:31 GMT 2011
 */
package com.gmcc.pboss.control.sales.vstockalarm;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.vstockalarm.VstockalarmDBParam;
import com.gmcc.pboss.business.sales.vstockalarm.VstockalarmDAO;
import com.gmcc.pboss.business.sales.vstockalarm.VstockalarmVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: VstockalarmBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class VstockalarmBO extends AbstractControlBean implements
		Vstockalarm {

	public VstockalarmVO doCreate(VstockalarmVO vo) throws Exception {
		try {
			VstockalarmDAO dao = (VstockalarmDAO) DAOFactory.build(VstockalarmDAO.class, user);
			// TODO set the pk */
			return (VstockalarmVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(VstockalarmVO vo) throws Exception {
		try {
			VstockalarmDAO dao = (VstockalarmDAO) DAOFactory.build(VstockalarmDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			VstockalarmDAO dao = (VstockalarmDAO) DAOFactory.build(VstockalarmDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public VstockalarmVO doUpdate(VstockalarmVO vo) throws Exception {
		try {
			VstockalarmDAO dao = (VstockalarmDAO) DAOFactory.build(VstockalarmDAO.class,user);
			return (VstockalarmVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public VstockalarmVO doFindByPk(Serializable pk) throws Exception {
		VstockalarmDAO dao = (VstockalarmDAO) DAOFactory.build(VstockalarmDAO.class,user);
		return (VstockalarmVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(VstockalarmDBParam params)
			throws Exception {
		VstockalarmDAO dao = (VstockalarmDAO) DAOFactory.build(VstockalarmDAO.class,user);
		DataPackage dp= dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.vstockalarm.query", params);
		return dp;
	}
}
