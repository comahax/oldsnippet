/**
 * auto-generated code
 * Sat Jun 11 09:41:33 CST 2011
 */
package com.gmcc.pboss.business.chdstcooperasyn2crm.cooperasynlog;

import java.io.Serializable;

import com.gmcc.pboss.business.chpwempsyn2crm.empsynlog.EmpsynlogDBParam;
import com.gmcc.pboss.business.chpwempsyn2crm.empsynlog.EmpsynlogDAO;
import com.gmcc.pboss.business.chpwempsyn2crm.empsynlog.EmpsynlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: EmpsynlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CooperasynlogBO extends AbstractControlBean implements
	Cooperasynlog {

	public CooperasynlogVO doCreate(CooperasynlogVO vo) throws Exception {
		try {
			CooperasynlogDAO dao = (CooperasynlogDAO) DAOFactory.build(CooperasynlogDAO.class, user);
			// TODO set the pk */
			return (CooperasynlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CooperasynlogVO vo) throws Exception {
		try {
			CooperasynlogDAO dao = (CooperasynlogDAO) DAOFactory.build(CooperasynlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CooperasynlogDAO dao = (CooperasynlogDAO) DAOFactory.build(CooperasynlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CooperasynlogVO doUpdate(CooperasynlogVO vo) throws Exception {
		try {
			CooperasynlogDAO dao = (CooperasynlogDAO) DAOFactory.build(CooperasynlogDAO.class,user);
			return (CooperasynlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CooperasynlogVO doFindByPk(Serializable pk) throws Exception {
		CooperasynlogDAO dao = (CooperasynlogDAO) DAOFactory.build(CooperasynlogDAO.class,user);
		return (CooperasynlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CooperasynlogDBParam params)
			throws Exception {
		CooperasynlogDAO dao = (CooperasynlogDAO) DAOFactory.build(CooperasynlogDAO.class,user);
		return dao.query(params);
	}
}
