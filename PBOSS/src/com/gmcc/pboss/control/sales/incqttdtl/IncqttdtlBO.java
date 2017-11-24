/**
 * auto-generated code
 * Thu Oct 29 15:57:12 CST 2009
 */
package com.gmcc.pboss.control.sales.incqttdtl;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.incqttdtl.IncqttdtlDBParam;
import com.gmcc.pboss.business.sales.incqttdtl.IncqttdtlDAO;
import com.gmcc.pboss.business.sales.incqttdtl.IncqttdtlVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: IncqttdtlBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class IncqttdtlBO extends AbstractControlBean implements
		Incqttdtl {

	public IncqttdtlVO doCreate(IncqttdtlVO vo) throws Exception {
		try {
			IncqttdtlDAO dao = (IncqttdtlDAO) DAOFactory.build(IncqttdtlDAO.class, user);
			// TODO set the pk */
			return (IncqttdtlVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(IncqttdtlVO vo) throws Exception {
		try {
			IncqttdtlDAO dao = (IncqttdtlDAO) DAOFactory.build(IncqttdtlDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			IncqttdtlDAO dao = (IncqttdtlDAO) DAOFactory.build(IncqttdtlDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public IncqttdtlVO doUpdate(IncqttdtlVO vo) throws Exception {
		try {
			IncqttdtlDAO dao = (IncqttdtlDAO) DAOFactory.build(IncqttdtlDAO.class,user);
			return (IncqttdtlVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public IncqttdtlVO doFindByPk(Serializable pk) throws Exception {
		IncqttdtlDAO dao = (IncqttdtlDAO) DAOFactory.build(IncqttdtlDAO.class,user);
		return (IncqttdtlVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(IncqttdtlDBParam params)
			throws Exception {
		IncqttdtlDAO dao = (IncqttdtlDAO) DAOFactory.build(IncqttdtlDAO.class,user);
		return dao.query(params);
	}
}
