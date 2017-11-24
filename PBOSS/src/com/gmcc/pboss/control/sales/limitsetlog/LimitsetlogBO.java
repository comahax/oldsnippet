/**
 * auto-generated code
 * Thu Jul 08 10:32:29 CST 2010
 */
package com.gmcc.pboss.control.sales.limitsetlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.limitsetlog.LimitsetlogDBParam;
import com.gmcc.pboss.business.sales.limitsetlog.LimitsetlogDAO;
import com.gmcc.pboss.business.sales.limitsetlog.LimitsetlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: LimitsetlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class LimitsetlogBO extends AbstractControlBean implements
		Limitsetlog {

	public LimitsetlogVO doCreate(LimitsetlogVO vo) throws Exception {
		try {
			LimitsetlogDAO dao = (LimitsetlogDAO) DAOFactory.build(LimitsetlogDAO.class, user);
			// TODO set the pk */
			return (LimitsetlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(LimitsetlogVO vo) throws Exception {
		try {
			LimitsetlogDAO dao = (LimitsetlogDAO) DAOFactory.build(LimitsetlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			LimitsetlogDAO dao = (LimitsetlogDAO) DAOFactory.build(LimitsetlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public LimitsetlogVO doUpdate(LimitsetlogVO vo) throws Exception {
		try {
			LimitsetlogDAO dao = (LimitsetlogDAO) DAOFactory.build(LimitsetlogDAO.class,user);
			return (LimitsetlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public LimitsetlogVO doFindByPk(Serializable pk) throws Exception {
		LimitsetlogDAO dao = (LimitsetlogDAO) DAOFactory.build(LimitsetlogDAO.class,user);
		return (LimitsetlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(LimitsetlogDBParam params)
			throws Exception {
		LimitsetlogDAO dao = (LimitsetlogDAO) DAOFactory.build(LimitsetlogDAO.class,user);
		return dao.query(params);
	}
}
