/**
 * auto-generated code
 * Tue Oct 13 09:23:33 CST 2009
 */
package com.gmcc.pboss.control.sales.baseorderamt;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.baseorderamt.BaseorderamtDBParam;
import com.gmcc.pboss.business.sales.baseorderamt.BaseorderamtDAO;
import com.gmcc.pboss.business.sales.baseorderamt.BaseorderamtVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: BaseorderamtBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BaseorderamtBO extends AbstractControlBean implements
		Baseorderamt {

	public BaseorderamtVO doCreate(BaseorderamtVO vo) throws Exception {
		try {
			BaseorderamtDAO dao = (BaseorderamtDAO) DAOFactory.build(BaseorderamtDAO.class, user);
			// TODO set the pk */
			return (BaseorderamtVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BaseorderamtVO vo) throws Exception {
		try {
			BaseorderamtDAO dao = (BaseorderamtDAO) DAOFactory.build(BaseorderamtDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BaseorderamtDAO dao = (BaseorderamtDAO) DAOFactory.build(BaseorderamtDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BaseorderamtVO doUpdate(BaseorderamtVO vo) throws Exception {
		try {
			BaseorderamtDAO dao = (BaseorderamtDAO) DAOFactory.build(BaseorderamtDAO.class,user);
			return (BaseorderamtVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BaseorderamtVO doFindByPk(Serializable pk) throws Exception {
		BaseorderamtDAO dao = (BaseorderamtDAO) DAOFactory.build(BaseorderamtDAO.class,user);
		return (BaseorderamtVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BaseorderamtDBParam params)
			throws Exception {
		BaseorderamtDAO dao = (BaseorderamtDAO) DAOFactory.build(BaseorderamtDAO.class,user);
		return dao.query(params);
	}
}
