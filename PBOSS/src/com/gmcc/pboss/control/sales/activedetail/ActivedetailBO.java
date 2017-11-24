/**
 * auto-generated code
 * Thu Jun 12 15:48:34 CST 2014
 */
package com.gmcc.pboss.control.sales.activedetail;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.activedetail.ActivedetailDAO;
import com.gmcc.pboss.business.sales.activedetail.ActivedetailVO;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptDBParam;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ActivedetailBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ActivedetailBO extends AbstractControlBean implements
		Activedetail {

	public ActivedetailVO doCreate(ActivedetailVO vo) throws Exception {
		try {
			ActivedetailDAO dao = (ActivedetailDAO) DAOFactory.build(ActivedetailDAO.class, user);
			// TODO set the pk */
			return (ActivedetailVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ActivedetailVO vo) throws Exception {
		try {
			ActivedetailDAO dao = (ActivedetailDAO) DAOFactory.build(ActivedetailDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ActivedetailDAO dao = (ActivedetailDAO) DAOFactory.build(ActivedetailDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ActivedetailVO doUpdate(ActivedetailVO vo) throws Exception {
		try {
			ActivedetailDAO dao = (ActivedetailDAO) DAOFactory.build(ActivedetailDAO.class,user);
			return (ActivedetailVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ActivedetailVO doFindByPk(Serializable pk) throws Exception {
		ActivedetailDAO dao = (ActivedetailDAO) DAOFactory.build(ActivedetailDAO.class,user);
		return (ActivedetailVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaystocksnptDBParam params)
			throws Exception {
		ActivedetailDAO dao = (ActivedetailDAO) DAOFactory.build(ActivedetailDAO.class,user);
		return dao.query(params);
	}
}
