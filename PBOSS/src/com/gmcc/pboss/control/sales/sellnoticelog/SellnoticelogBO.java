/**
 * auto-generated code
 * Thu Jan 26 11:27:21 CST 2012
 */
package com.gmcc.pboss.control.sales.sellnoticelog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.sellnoticelog.SellnoticelogDBParam;
import com.gmcc.pboss.business.sales.sellnoticelog.SellnoticelogDAO;
import com.gmcc.pboss.business.sales.sellnoticelog.SellnoticelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: SellnoticelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class SellnoticelogBO extends AbstractControlBean implements
		Sellnoticelog {

	public SellnoticelogVO doCreate(SellnoticelogVO vo) throws Exception {
		try {
			SellnoticelogDAO dao = (SellnoticelogDAO) DAOFactory.build(SellnoticelogDAO.class, user);
			// TODO set the pk */
			return (SellnoticelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SellnoticelogVO vo) throws Exception {
		try {
			SellnoticelogDAO dao = (SellnoticelogDAO) DAOFactory.build(SellnoticelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SellnoticelogDAO dao = (SellnoticelogDAO) DAOFactory.build(SellnoticelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SellnoticelogVO doUpdate(SellnoticelogVO vo) throws Exception {
		try {
			SellnoticelogDAO dao = (SellnoticelogDAO) DAOFactory.build(SellnoticelogDAO.class,user);
			return (SellnoticelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SellnoticelogVO doFindByPk(Serializable pk) throws Exception {
		SellnoticelogDAO dao = (SellnoticelogDAO) DAOFactory.build(SellnoticelogDAO.class,user);
		return (SellnoticelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SellnoticelogDBParam params)
			throws Exception {
		SellnoticelogDAO dao = (SellnoticelogDAO) DAOFactory.build(SellnoticelogDAO.class,user);
		return dao.query(params);
	}
}
