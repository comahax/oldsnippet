/**
 * auto-generated code
 * Thu Jul 08 10:27:55 CST 2010
 */
package com.gmcc.pboss.control.sales.limitset;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.limitset.LimitsetDBParam;
import com.gmcc.pboss.business.sales.limitset.LimitsetDAO;
import com.gmcc.pboss.business.sales.limitset.LimitsetVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: LimitsetBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class LimitsetBO extends AbstractControlBean implements
		Limitset {

	public LimitsetVO doCreate(LimitsetVO vo) throws Exception {
		try {
			LimitsetDAO dao = (LimitsetDAO) DAOFactory.build(LimitsetDAO.class, user);
			// TODO set the pk */
			return (LimitsetVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(LimitsetVO vo) throws Exception {
		try {
			LimitsetDAO dao = (LimitsetDAO) DAOFactory.build(LimitsetDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			LimitsetDAO dao = (LimitsetDAO) DAOFactory.build(LimitsetDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public LimitsetVO doUpdate(LimitsetVO vo) throws Exception {
		try {
			LimitsetDAO dao = (LimitsetDAO) DAOFactory.build(LimitsetDAO.class,user);
			return (LimitsetVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public LimitsetVO doFindByPk(Serializable pk) throws Exception {
		LimitsetDAO dao = (LimitsetDAO) DAOFactory.build(LimitsetDAO.class,user);
		return (LimitsetVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(LimitsetDBParam params)
			throws Exception {
		LimitsetDAO dao = (LimitsetDAO) DAOFactory.build(LimitsetDAO.class,user);
		return dao.query(params);
	}
}
