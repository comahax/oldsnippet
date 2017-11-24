/**
 * auto-generated code
 * Thu Jun 12 15:47:39 CST 2014
 */
package com.gmcc.pboss.control.sales.comrescarddetail;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.comrescarddetail.ComrescarddetailDAO;
import com.gmcc.pboss.business.sales.comrescarddetail.ComrescarddetailVO;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptDBParam;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ComrescarddetailBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ComrescarddetailBO extends AbstractControlBean implements
		Comrescarddetail {

	public ComrescarddetailVO doCreate(ComrescarddetailVO vo) throws Exception {
		try {
			ComrescarddetailDAO dao = (ComrescarddetailDAO) DAOFactory.build(ComrescarddetailDAO.class, user);
			// TODO set the pk */
			return (ComrescarddetailVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComrescarddetailVO vo) throws Exception {
		try {
			ComrescarddetailDAO dao = (ComrescarddetailDAO) DAOFactory.build(ComrescarddetailDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ComrescarddetailDAO dao = (ComrescarddetailDAO) DAOFactory.build(ComrescarddetailDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComrescarddetailVO doUpdate(ComrescarddetailVO vo) throws Exception {
		try {
			ComrescarddetailDAO dao = (ComrescarddetailDAO) DAOFactory.build(ComrescarddetailDAO.class,user);
			return (ComrescarddetailVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComrescarddetailVO doFindByPk(Serializable pk) throws Exception {
		ComrescarddetailDAO dao = (ComrescarddetailDAO) DAOFactory.build(ComrescarddetailDAO.class,user);
		return (ComrescarddetailVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaystocksnptDBParam params)
			throws Exception {
		ComrescarddetailDAO dao = (ComrescarddetailDAO) DAOFactory.build(ComrescarddetailDAO.class,user);
		return dao.query(params);
	}
}
