/**
 * auto-generated code
 * Fri Oct 02 10:44:18 CST 2009
 */
package com.gmcc.pboss.control.resource.discomres;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.discomres.DiscomresDAO;
import com.gmcc.pboss.business.resource.discomres.DiscomresDBParam;
import com.gmcc.pboss.business.resource.discomres.DiscomresVO;
import com.gmcc.pboss.business.resource.discomres.VDiscomresDAO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: DiscomresBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class DiscomresBO extends AbstractControlBean implements
		Discomres {

	public DiscomresVO doCreate(DiscomresVO vo) throws Exception {
		try {
			DiscomresDAO dao = (DiscomresDAO) DAOFactory.build(DiscomresDAO.class, user);
			// TODO set the pk */
			return (DiscomresVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(DiscomresVO vo) throws Exception {
		try {
			DiscomresDAO dao = (DiscomresDAO) DAOFactory.build(DiscomresDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DiscomresDAO dao = (DiscomresDAO) DAOFactory.build(DiscomresDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DiscomresVO doUpdate(DiscomresVO vo) throws Exception {
		try {
			DiscomresDAO dao = (DiscomresDAO) DAOFactory.build(DiscomresDAO.class,user);
			return (DiscomresVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DiscomresVO doFindByPk(Serializable pk) throws Exception {
		DiscomresDAO dao = (DiscomresDAO) DAOFactory.build(DiscomresDAO.class,user);
		return (DiscomresVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(DiscomresDBParam params)
			throws Exception {
		DiscomresDAO dao = (DiscomresDAO) DAOFactory.build(DiscomresDAO.class,user);
		return dao.query(params);
	}

	public DataPackage doQueryDiscomresInfo(DiscomresDBParam params)
			throws Exception {
		VDiscomresDAO dao = (VDiscomresDAO) DAOFactory.build(VDiscomresDAO.class,user);
		return dao.doQueryDiscomresInfo(params);
	}
}
