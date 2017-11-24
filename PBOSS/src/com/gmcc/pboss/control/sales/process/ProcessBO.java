/**
 * auto-generated code
 * Wed Oct 14 09:04:57 CST 2009
 */
package com.gmcc.pboss.control.sales.process;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.process.ProcessDBParam;
import com.gmcc.pboss.business.sales.process.ProcessDAO;
import com.gmcc.pboss.business.sales.process.ProcessVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ProcessBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ProcessBO extends AbstractControlBean implements
		Process {

	public ProcessVO doCreate(ProcessVO vo) throws Exception {
		try {
			ProcessDAO dao = (ProcessDAO) DAOFactory.build(ProcessDAO.class, user);
			// TODO set the pk */
			return (ProcessVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ProcessVO vo) throws Exception {
		try {
			ProcessDAO dao = (ProcessDAO) DAOFactory.build(ProcessDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ProcessDAO dao = (ProcessDAO) DAOFactory.build(ProcessDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ProcessVO doUpdate(ProcessVO vo) throws Exception {
		try {
			ProcessDAO dao = (ProcessDAO) DAOFactory.build(ProcessDAO.class,user);
			return (ProcessVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ProcessVO doFindByPk(Serializable pk) throws Exception {
		ProcessDAO dao = (ProcessDAO) DAOFactory.build(ProcessDAO.class,user);
		return (ProcessVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ProcessDBParam params)
			throws Exception {
		ProcessDAO dao = (ProcessDAO) DAOFactory.build(ProcessDAO.class,user);
		return dao.query(params);
	}
}
