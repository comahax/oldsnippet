/**
 * auto-generated code
 * Thu Mar 10 18:50:30 CST 2011
 */
package com.gmcc.pboss.control.channel.operationsms;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.operationsms.OperationsmsDBParam;
import com.gmcc.pboss.business.channel.operationsms.OperationsmsDAO;
import com.gmcc.pboss.business.channel.operationsms.OperationsmsVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: OperationsmsBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class OperationsmsBO extends AbstractControlBean implements
		Operationsms {

	public OperationsmsVO doCreate(OperationsmsVO vo) throws Exception {
		try {
			OperationsmsDAO dao = (OperationsmsDAO) DAOFactory.build(OperationsmsDAO.class, user);
			// TODO set the pk */
			return (OperationsmsVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OperationsmsVO vo) throws Exception {
		try {
			OperationsmsDAO dao = (OperationsmsDAO) DAOFactory.build(OperationsmsDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OperationsmsDAO dao = (OperationsmsDAO) DAOFactory.build(OperationsmsDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperationsmsVO doUpdate(OperationsmsVO vo) throws Exception {
		try {
			OperationsmsDAO dao = (OperationsmsDAO) DAOFactory.build(OperationsmsDAO.class,user);
			return (OperationsmsVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperationsmsVO doFindByPk(Serializable pk) throws Exception {
		OperationsmsDAO dao = (OperationsmsDAO) DAOFactory.build(OperationsmsDAO.class,user);
		return (OperationsmsVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OperationsmsDBParam params)
			throws Exception {
		OperationsmsDAO dao = (OperationsmsDAO) DAOFactory.build(OperationsmsDAO.class,user);
		return dao.query(params);
	}
}
