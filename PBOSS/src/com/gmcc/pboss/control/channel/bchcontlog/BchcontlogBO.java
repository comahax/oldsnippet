/**
 * auto-generated code
 * Sun Oct 18 20:53:55 CST 2009
 */
package com.gmcc.pboss.control.channel.bchcontlog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.bchcontlog.BchcontlogDBParam;
import com.gmcc.pboss.business.channel.bchcontlog.BchcontlogDAO;
import com.gmcc.pboss.business.channel.bchcontlog.BchcontlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: BchcontlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class BchcontlogBO extends AbstractControlBean implements
		Bchcontlog {

	public BchcontlogVO doCreate(BchcontlogVO vo) throws Exception {
		try {
			BchcontlogDAO dao = (BchcontlogDAO) DAOFactory.build(BchcontlogDAO.class, user);
			// TODO set the pk */
			return (BchcontlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BchcontlogVO vo) throws Exception {
		try {
			BchcontlogDAO dao = (BchcontlogDAO) DAOFactory.build(BchcontlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BchcontlogDAO dao = (BchcontlogDAO) DAOFactory.build(BchcontlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BchcontlogVO doUpdate(BchcontlogVO vo) throws Exception {
		try {
			BchcontlogDAO dao = (BchcontlogDAO) DAOFactory.build(BchcontlogDAO.class,user);
			return (BchcontlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BchcontlogVO doFindByPk(Serializable pk) throws Exception {
		BchcontlogDAO dao = (BchcontlogDAO) DAOFactory.build(BchcontlogDAO.class,user);
		return (BchcontlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BchcontlogDBParam params)
			throws Exception {
		BchcontlogDAO dao = (BchcontlogDAO) DAOFactory.build(BchcontlogDAO.class,user);
		return dao.query(params);
	}
}
