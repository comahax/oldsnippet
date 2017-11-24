/**
 * auto-generated code
 * Wed Nov 14 09:58:01 CST 2012
 */
package com.gmcc.pboss.control.channel.busicirclelog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.busicirclelog.BusicirclelogDBParam;
import com.gmcc.pboss.business.channel.busicirclelog.BusicirclelogDAO;
import com.gmcc.pboss.business.channel.busicirclelog.BusicirclelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: BusicirclelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class BusicirclelogBO extends AbstractControlBean implements
		Busicirclelog {

	public BusicirclelogVO doCreate(BusicirclelogVO vo) throws Exception {
		try {
			BusicirclelogDAO dao = (BusicirclelogDAO) DAOFactory.build(BusicirclelogDAO.class, user);
			// TODO set the pk */
			return (BusicirclelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BusicirclelogVO vo) throws Exception {
		try {
			BusicirclelogDAO dao = (BusicirclelogDAO) DAOFactory.build(BusicirclelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BusicirclelogDAO dao = (BusicirclelogDAO) DAOFactory.build(BusicirclelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BusicirclelogVO doUpdate(BusicirclelogVO vo) throws Exception {
		try {
			BusicirclelogDAO dao = (BusicirclelogDAO) DAOFactory.build(BusicirclelogDAO.class,user);
			return (BusicirclelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BusicirclelogVO doFindByPk(Serializable pk) throws Exception {
		BusicirclelogDAO dao = (BusicirclelogDAO) DAOFactory.build(BusicirclelogDAO.class,user);
		return (BusicirclelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BusicirclelogDBParam params)
			throws Exception {
		BusicirclelogDAO dao = (BusicirclelogDAO) DAOFactory.build(BusicirclelogDAO.class,user);
		return dao.query(params);
	}
}
