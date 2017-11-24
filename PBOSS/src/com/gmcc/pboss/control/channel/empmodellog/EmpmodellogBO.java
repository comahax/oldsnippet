/**
 * auto-generated code
 * Fri Mar 04 17:08:10 CST 2011
 */
package com.gmcc.pboss.control.channel.empmodellog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.empmodellog.EmpmodellogDBParam;
import com.gmcc.pboss.business.channel.empmodellog.EmpmodellogDAO;
import com.gmcc.pboss.business.channel.empmodellog.EmpmodellogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: EmpmodellogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmpmodellogBO extends AbstractControlBean implements
		Empmodellog {

	public EmpmodellogVO doCreate(EmpmodellogVO vo) throws Exception {
		try {
			EmpmodellogDAO dao = (EmpmodellogDAO) DAOFactory.build(EmpmodellogDAO.class, user);
			// TODO set the pk */
			return (EmpmodellogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmpmodellogVO vo) throws Exception {
		try {
			EmpmodellogDAO dao = (EmpmodellogDAO) DAOFactory.build(EmpmodellogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmpmodellogDAO dao = (EmpmodellogDAO) DAOFactory.build(EmpmodellogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmpmodellogVO doUpdate(EmpmodellogVO vo) throws Exception {
		try {
			EmpmodellogDAO dao = (EmpmodellogDAO) DAOFactory.build(EmpmodellogDAO.class,user);
			return (EmpmodellogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmpmodellogVO doFindByPk(Serializable pk) throws Exception {
		EmpmodellogDAO dao = (EmpmodellogDAO) DAOFactory.build(EmpmodellogDAO.class,user);
		return (EmpmodellogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmpmodellogDBParam params)
			throws Exception {
		EmpmodellogDAO dao = (EmpmodellogDAO) DAOFactory.build(EmpmodellogDAO.class,user);
		return dao.query(params);
	}
}
