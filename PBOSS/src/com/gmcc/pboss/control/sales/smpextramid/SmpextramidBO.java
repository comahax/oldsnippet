/**
 * auto-generated code
 * Tue Oct 20 14:31:44 CST 2009
 */
package com.gmcc.pboss.control.sales.smpextramid;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.smpextramid.SmpextramidDBParam;
import com.gmcc.pboss.business.sales.smpextramid.SmpextramidDAO;
import com.gmcc.pboss.business.sales.smpextramid.SmpextramidVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: SmpextramidBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class SmpextramidBO extends AbstractControlBean implements
		Smpextramid {

	public SmpextramidVO doCreate(SmpextramidVO vo) throws Exception {
		try {
			SmpextramidDAO dao = (SmpextramidDAO) DAOFactory.build(SmpextramidDAO.class, user);
			// TODO set the pk */
			return (SmpextramidVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SmpextramidVO vo) throws Exception {
		try {
			SmpextramidDAO dao = (SmpextramidDAO) DAOFactory.build(SmpextramidDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SmpextramidDAO dao = (SmpextramidDAO) DAOFactory.build(SmpextramidDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmpextramidVO doUpdate(SmpextramidVO vo) throws Exception {
		try {
			SmpextramidDAO dao = (SmpextramidDAO) DAOFactory.build(SmpextramidDAO.class,user);
			return (SmpextramidVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmpextramidVO doFindByPk(Serializable pk) throws Exception {
		SmpextramidDAO dao = (SmpextramidDAO) DAOFactory.build(SmpextramidDAO.class,user);
		return (SmpextramidVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SmpextramidDBParam params)
			throws Exception {
		SmpextramidDAO dao = (SmpextramidDAO) DAOFactory.build(SmpextramidDAO.class,user);
		return dao.query(params);
	}
}
