/**
 * auto-generated code
 * Fri Oct 23 15:23:36 CST 2009
 */
package com.gmcc.pboss.control.sales.noactinfo;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.noactinfo.NoactinfoDBParam;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoDAO;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: NoactinfoBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class NoactinfoBO extends AbstractControlBean implements
		Noactinfo {

	public NoactinfoVO doCreate(NoactinfoVO vo) throws Exception {
		try {
			NoactinfoDAO dao = (NoactinfoDAO) DAOFactory.build(NoactinfoDAO.class, user);
			// TODO set the pk */
			return (NoactinfoVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(NoactinfoVO vo) throws Exception {
		try {
			NoactinfoDAO dao = (NoactinfoDAO) DAOFactory.build(NoactinfoDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			NoactinfoDAO dao = (NoactinfoDAO) DAOFactory.build(NoactinfoDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public NoactinfoVO doUpdate(NoactinfoVO vo) throws Exception {
		try {
			NoactinfoDAO dao = (NoactinfoDAO) DAOFactory.build(NoactinfoDAO.class,user);
			return (NoactinfoVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public NoactinfoVO doFindByPk(Serializable pk) throws Exception {
		NoactinfoDAO dao = (NoactinfoDAO) DAOFactory.build(NoactinfoDAO.class,user);
		return (NoactinfoVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(NoactinfoDBParam params)
			throws Exception {
		NoactinfoDAO dao = (NoactinfoDAO) DAOFactory.build(NoactinfoDAO.class,user);
		return dao.query(params);
	}
}
