/**
 * auto-generated code
 * Tue Nov 15 11:32:53 CST 2011
 */
package com.gmcc.pboss.control.sales.disoverdetail;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.disoverdetail.DisoverdetailDBParam;
import com.gmcc.pboss.business.sales.disoverdetail.DisoverdetailDAO;
import com.gmcc.pboss.business.sales.disoverdetail.DisoverdetailVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: DisoverdetailBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class DisoverdetailBO extends AbstractControlBean implements
		Disoverdetail {

	public DisoverdetailVO doCreate(DisoverdetailVO vo) throws Exception {
		try {
			DisoverdetailDAO dao = (DisoverdetailDAO) DAOFactory.build(DisoverdetailDAO.class, user);
			// TODO set the pk */
			return (DisoverdetailVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(DisoverdetailVO vo) throws Exception {
		try {
			DisoverdetailDAO dao = (DisoverdetailDAO) DAOFactory.build(DisoverdetailDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DisoverdetailDAO dao = (DisoverdetailDAO) DAOFactory.build(DisoverdetailDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisoverdetailVO doUpdate(DisoverdetailVO vo) throws Exception {
		try {
			DisoverdetailDAO dao = (DisoverdetailDAO) DAOFactory.build(DisoverdetailDAO.class,user);
			return (DisoverdetailVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisoverdetailVO doFindByPk(Serializable pk) throws Exception {
		DisoverdetailDAO dao = (DisoverdetailDAO) DAOFactory.build(DisoverdetailDAO.class,user);
		return (DisoverdetailVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(DisoverdetailDBParam params)
			throws Exception {
		DisoverdetailDAO dao = (DisoverdetailDAO) DAOFactory.build(DisoverdetailDAO.class,user);
		return dao.query(params);
	}
}
