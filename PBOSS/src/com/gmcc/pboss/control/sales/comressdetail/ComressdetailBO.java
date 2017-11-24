/**
 * auto-generated code
 * Thu Jun 12 15:45:43 CST 2014
 */
package com.gmcc.pboss.control.sales.comressdetail;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.comressdetail.ComressdetailDAO;
import com.gmcc.pboss.business.sales.comressdetail.ComressdetailVO;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptDBParam;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ComressdetailBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ComressdetailBO extends AbstractControlBean implements
		Comressdetail {

	public ComressdetailVO doCreate(ComressdetailVO vo) throws Exception {
		try {
			ComressdetailDAO dao = (ComressdetailDAO) DAOFactory.build(ComressdetailDAO.class, user);
			// TODO set the pk */
			return (ComressdetailVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComressdetailVO vo) throws Exception {
		try {
			ComressdetailDAO dao = (ComressdetailDAO) DAOFactory.build(ComressdetailDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ComressdetailDAO dao = (ComressdetailDAO) DAOFactory.build(ComressdetailDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComressdetailVO doUpdate(ComressdetailVO vo) throws Exception {
		try {
			ComressdetailDAO dao = (ComressdetailDAO) DAOFactory.build(ComressdetailDAO.class,user);
			return (ComressdetailVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComressdetailVO doFindByPk(Serializable pk) throws Exception {
		ComressdetailDAO dao = (ComressdetailDAO) DAOFactory.build(ComressdetailDAO.class,user);
		return (ComressdetailVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaystocksnptDBParam params)
			throws Exception {
		ComressdetailDAO dao = (ComressdetailDAO) DAOFactory.build(ComressdetailDAO.class,user);
		return dao.query(params);
	}
}
