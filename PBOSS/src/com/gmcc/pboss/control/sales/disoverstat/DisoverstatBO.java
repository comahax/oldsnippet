/**
 * auto-generated code
 * Mon Nov 14 15:52:02 CST 2011
 */
package com.gmcc.pboss.control.sales.disoverstat;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.disoverstat.DisoverstatDBParam;
import com.gmcc.pboss.business.sales.disoverstat.DisoverstatDAO;
import com.gmcc.pboss.business.sales.disoverstat.DisoverstatVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: DisoverstatBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class DisoverstatBO extends AbstractControlBean implements
		Disoverstat {

	public DisoverstatVO doCreate(DisoverstatVO vo) throws Exception {
		try {
			DisoverstatDAO dao = (DisoverstatDAO) DAOFactory.build(DisoverstatDAO.class, user);
			// TODO set the pk */
			return (DisoverstatVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(DisoverstatVO vo) throws Exception {
		try {
			DisoverstatDAO dao = (DisoverstatDAO) DAOFactory.build(DisoverstatDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DisoverstatDAO dao = (DisoverstatDAO) DAOFactory.build(DisoverstatDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisoverstatVO doUpdate(DisoverstatVO vo) throws Exception {
		try {
			DisoverstatDAO dao = (DisoverstatDAO) DAOFactory.build(DisoverstatDAO.class,user);
			return (DisoverstatVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisoverstatVO doFindByPk(Serializable pk) throws Exception {
		DisoverstatDAO dao = (DisoverstatDAO) DAOFactory.build(DisoverstatDAO.class,user);
		return (DisoverstatVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(DisoverstatDBParam params)
			throws Exception {
		DisoverstatDAO dao = (DisoverstatDAO) DAOFactory.build(DisoverstatDAO.class,user);
		return dao.query(params);
	}
}
