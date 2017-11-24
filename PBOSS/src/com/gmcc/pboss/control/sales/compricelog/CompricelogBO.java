/**
 * auto-generated code
 * Thu Jul 01 16:47:05 CST 2010
 */
package com.gmcc.pboss.control.sales.compricelog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.compricelog.CompricelogDBParam;
import com.gmcc.pboss.business.sales.compricelog.CompricelogDAO;
import com.gmcc.pboss.business.sales.compricelog.CompricelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: CompricelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class CompricelogBO extends AbstractControlBean implements
		Compricelog {

	public CompricelogVO doCreate(CompricelogVO vo) throws Exception {
		try {
			CompricelogDAO dao = (CompricelogDAO) DAOFactory.build(CompricelogDAO.class, user);
			// TODO set the pk */
			return (CompricelogVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new RuntimeException(ex);
		}
	}

	public void doRemoveByVO(CompricelogVO vo) throws Exception {
		try {
			CompricelogDAO dao = (CompricelogDAO) DAOFactory.build(CompricelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new RuntimeException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CompricelogDAO dao = (CompricelogDAO) DAOFactory.build(CompricelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new RuntimeException(ex);
		}
	}

	public CompricelogVO doUpdate(CompricelogVO vo) throws Exception {
		try {
			CompricelogDAO dao = (CompricelogDAO) DAOFactory.build(CompricelogDAO.class,user);
			return (CompricelogVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new RuntimeException(ex);
		}
	}

	public CompricelogVO doFindByPk(Serializable pk) throws Exception {
		CompricelogDAO dao = (CompricelogDAO) DAOFactory.build(CompricelogDAO.class,user);
		return (CompricelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CompricelogDBParam params)
			throws Exception {
		CompricelogDAO dao = (CompricelogDAO) DAOFactory.build(CompricelogDAO.class,user);
		return dao.query(params);
	}
}
