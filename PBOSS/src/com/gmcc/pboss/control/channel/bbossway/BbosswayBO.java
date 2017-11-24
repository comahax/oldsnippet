/**
 * auto-generated code
 * Tue Apr 14 16:34:03 CST 2015
 */
package com.gmcc.pboss.control.channel.bbossway;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.bbossway.BbosswayDBParam;
import com.gmcc.pboss.business.channel.bbossway.BbosswayDAO;
import com.gmcc.pboss.business.channel.bbossway.BbosswayVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: BbosswayBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class BbosswayBO extends AbstractControlBean implements
		Bbossway {

	public BbosswayVO doCreate(BbosswayVO vo) throws Exception {
		try {
			BbosswayDAO dao = (BbosswayDAO) DAOFactory.build(BbosswayDAO.class, user);
			// TODO set the pk */
			return (BbosswayVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BbosswayVO vo) throws Exception {
		try {
			BbosswayDAO dao = (BbosswayDAO) DAOFactory.build(BbosswayDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BbosswayDAO dao = (BbosswayDAO) DAOFactory.build(BbosswayDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BbosswayVO doUpdate(BbosswayVO vo) throws Exception {
		try {
			BbosswayDAO dao = (BbosswayDAO) DAOFactory.build(BbosswayDAO.class,user);
			return (BbosswayVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BbosswayVO doFindByPk(Serializable pk) throws Exception {
		BbosswayDAO dao = (BbosswayDAO) DAOFactory.build(BbosswayDAO.class,user);
		return (BbosswayVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BbosswayDBParam params)
			throws Exception {
		BbosswayDAO dao = (BbosswayDAO) DAOFactory.build(BbosswayDAO.class,user);
		return dao.query(params);
	}
}
