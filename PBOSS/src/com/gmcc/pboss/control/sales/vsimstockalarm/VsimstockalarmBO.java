/**
 * auto-generated code
 * Sat Mar 31 16:00:36 CST 2012
 */
package com.gmcc.pboss.control.sales.vsimstockalarm;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.vsimstockalarm.VsimstockalarmDBParam;
import com.gmcc.pboss.business.sales.vsimstockalarm.VsimstockalarmDAO;
import com.gmcc.pboss.business.sales.vsimstockalarm.VsimstockalarmVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: VsimstockalarmBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class VsimstockalarmBO extends AbstractControlBean implements
		Vsimstockalarm {

	public VsimstockalarmVO doCreate(VsimstockalarmVO vo) throws Exception {
		try {
			VsimstockalarmDAO dao = (VsimstockalarmDAO) DAOFactory.build(VsimstockalarmDAO.class, user);
			// TODO set the pk */
			return (VsimstockalarmVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(VsimstockalarmVO vo) throws Exception {
		try {
			VsimstockalarmDAO dao = (VsimstockalarmDAO) DAOFactory.build(VsimstockalarmDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			VsimstockalarmDAO dao = (VsimstockalarmDAO) DAOFactory.build(VsimstockalarmDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public VsimstockalarmVO doUpdate(VsimstockalarmVO vo) throws Exception {
		try {
			VsimstockalarmDAO dao = (VsimstockalarmDAO) DAOFactory.build(VsimstockalarmDAO.class,user);
			return (VsimstockalarmVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public VsimstockalarmVO doFindByPk(Serializable pk) throws Exception {
		VsimstockalarmDAO dao = (VsimstockalarmDAO) DAOFactory.build(VsimstockalarmDAO.class,user);
		return (VsimstockalarmVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(VsimstockalarmDBParam params)
			throws Exception {
		VsimstockalarmDAO dao = (VsimstockalarmDAO) DAOFactory.build(VsimstockalarmDAO.class,user);
		return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.vsimstockalarm.wayQuery", params);
	}
}
