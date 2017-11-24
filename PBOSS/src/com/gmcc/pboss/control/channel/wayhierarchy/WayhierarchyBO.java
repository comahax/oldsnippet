/**
 * auto-generated code
 * Sat Nov 21 17:07:29 CST 2009
 */
package com.gmcc.pboss.control.channel.wayhierarchy;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.wayhierarchy.WayhierarchyDBParam;
import com.gmcc.pboss.business.channel.wayhierarchy.WayhierarchyDAO;
import com.gmcc.pboss.business.channel.wayhierarchy.WayhierarchyVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: WayhierarchyBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class WayhierarchyBO extends AbstractControlBean implements
		Wayhierarchy {

	public WayhierarchyVO doCreate(WayhierarchyVO vo) throws Exception {
		try {
			WayhierarchyDAO dao = (WayhierarchyDAO) DAOFactory.build(WayhierarchyDAO.class, user);
			//WayhierarchyDAO dao = (WayhierarchyDAO) DAOFactory.build(WayhierarchyDAO.class, "DB_BOSSCOMMON");
			// TODO set the pk */
			return (WayhierarchyVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WayhierarchyVO vo) throws Exception {
		try {
			WayhierarchyDAO dao = (WayhierarchyDAO) DAOFactory.build(WayhierarchyDAO.class,user);
			//WayhierarchyDAO dao = (WayhierarchyDAO) DAOFactory.build(WayhierarchyDAO.class, "DB_BOSSCOMMON");
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WayhierarchyDAO dao = (WayhierarchyDAO) DAOFactory.build(WayhierarchyDAO.class,user);
			//WayhierarchyDAO dao = (WayhierarchyDAO) DAOFactory.build(WayhierarchyDAO.class, "DB_BOSSCOMMON");
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayhierarchyVO doUpdate(WayhierarchyVO vo) throws Exception {
		try {
			WayhierarchyDAO dao = (WayhierarchyDAO) DAOFactory.build(WayhierarchyDAO.class,user);
			//WayhierarchyDAO dao = (WayhierarchyDAO) DAOFactory.build(WayhierarchyDAO.class, "DB_BOSSCOMMON");
			return (WayhierarchyVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayhierarchyVO doFindByPk(Serializable pk) throws Exception {
		WayhierarchyDAO dao = (WayhierarchyDAO) DAOFactory.build(WayhierarchyDAO.class,user);
		return (WayhierarchyVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WayhierarchyDBParam params)
			throws Exception {
		WayhierarchyDAO dao = (WayhierarchyDAO) DAOFactory.build(WayhierarchyDAO.class,user);
		return dao.query(params);
	}
}
