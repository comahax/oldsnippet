/**
 * auto-generated code
 * Tue Mar 01 19:20:26 CST 2011
 */
package com.gmcc.pboss.control.channel.empconfirm;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.empconfirm.EmpconfirmDBParam;
import com.gmcc.pboss.business.channel.empconfirm.EmpconfirmDAO;
import com.gmcc.pboss.business.channel.empconfirm.EmpconfirmVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: EmpconfirmBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmpconfirmBO extends AbstractControlBean implements
		Empconfirm {

	public EmpconfirmVO doCreate(EmpconfirmVO vo) throws Exception {
		try {
			EmpconfirmDAO dao = (EmpconfirmDAO) DAOFactory.build(EmpconfirmDAO.class, user);
			// TODO set the pk */
			return (EmpconfirmVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmpconfirmVO vo) throws Exception {
		try {
			EmpconfirmDAO dao = (EmpconfirmDAO) DAOFactory.build(EmpconfirmDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmpconfirmDAO dao = (EmpconfirmDAO) DAOFactory.build(EmpconfirmDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmpconfirmVO doUpdate(EmpconfirmVO vo) throws Exception {
		try {
			EmpconfirmDAO dao = (EmpconfirmDAO) DAOFactory.build(EmpconfirmDAO.class,user);
			return (EmpconfirmVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmpconfirmVO doFindByPk(Serializable pk) throws Exception {
		EmpconfirmDAO dao = (EmpconfirmDAO) DAOFactory.build(EmpconfirmDAO.class,user);
		return (EmpconfirmVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmpconfirmDBParam params)
			throws Exception {
		EmpconfirmDAO dao = (EmpconfirmDAO) DAOFactory.build(EmpconfirmDAO.class,user);
		return dao.query(params);
	}
}
