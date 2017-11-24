/**
 * auto-generated code
 * Tue Sep 15 10:34:49 CST 2015
 */
package com.gmcc.pboss.control.reward.chcwemployee;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.chcwemployee.ChCwEmployeeDBParam;
import com.gmcc.pboss.business.reward.chcwemployee.ChCwEmployeeDAO;
import com.gmcc.pboss.business.reward.chcwemployee.ChCwEmployeeVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ChCwEmployeeBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author ydr
 * @version 1.0
 */
public class ChCwEmployeeBO extends AbstractControlBean implements
		ChCwEmployee {

	public ChCwEmployeeVO doCreate(ChCwEmployeeVO vo) throws Exception {
		try {
			ChCwEmployeeDAO dao = (ChCwEmployeeDAO) DAOFactory.build(ChCwEmployeeDAO.class, user);
			// TODO set the pk */
			return (ChCwEmployeeVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ChCwEmployeeVO vo) throws Exception {
		try {
			ChCwEmployeeDAO dao = (ChCwEmployeeDAO) DAOFactory.build(ChCwEmployeeDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ChCwEmployeeDAO dao = (ChCwEmployeeDAO) DAOFactory.build(ChCwEmployeeDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ChCwEmployeeVO doUpdate(ChCwEmployeeVO vo) throws Exception {
		try {
			ChCwEmployeeDAO dao = (ChCwEmployeeDAO) DAOFactory.build(ChCwEmployeeDAO.class,user);
			return (ChCwEmployeeVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ChCwEmployeeVO doFindByPk(Serializable pk) throws Exception {
		ChCwEmployeeDAO dao = (ChCwEmployeeDAO) DAOFactory.build(ChCwEmployeeDAO.class,user);
		return (ChCwEmployeeVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ChCwEmployeeDBParam params)
			throws Exception {
		ChCwEmployeeDAO dao = (ChCwEmployeeDAO) DAOFactory.build(ChCwEmployeeDAO.class,user);
		return dao.query(params);
	}
}
