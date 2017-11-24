/**
 * auto-generated code
 * Wed Nov 14 09:57:16 CST 2012
 */
package com.gmcc.pboss.control.channel.busicircle;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.busicircle.BusicircleDAO;
import com.gmcc.pboss.business.channel.busicircle.BusicircleDBParam;
import com.gmcc.pboss.business.channel.busicircle.BusicircleVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: BusicircleBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class BusicircleBO extends AbstractControlBean implements
		Busicircle {

	public BusicircleVO doCreate(BusicircleVO vo) throws Exception {
		try {
			BusicircleDAO dao = (BusicircleDAO) DAOFactory.build(BusicircleDAO.class, user);
			// TODO set the pk */
			return (BusicircleVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BusicircleVO vo) throws Exception {
		try {
			BusicircleDAO dao = (BusicircleDAO) DAOFactory.build(BusicircleDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BusicircleDAO dao = (BusicircleDAO) DAOFactory.build(BusicircleDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BusicircleVO doUpdate(BusicircleVO vo) throws Exception {
		try {
			BusicircleDAO dao = (BusicircleDAO) DAOFactory.build(BusicircleDAO.class,user);
			return (BusicircleVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BusicircleVO doFindByPk(Serializable pk) throws Exception {
		BusicircleDAO dao = (BusicircleDAO) DAOFactory.build(BusicircleDAO.class,user);
		return (BusicircleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BusicircleDBParam params)
			throws Exception {
		BusicircleDAO dao = (BusicircleDAO) DAOFactory.build(BusicircleDAO.class,user);
		return dao.query(params);
	}
}
