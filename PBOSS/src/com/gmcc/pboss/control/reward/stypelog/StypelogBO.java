package com.gmcc.pboss.control.reward.stypelog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.stypelog.StypelogDAO;
import com.gmcc.pboss.business.reward.stypelog.StypelogDBParam;
import com.gmcc.pboss.business.reward.stypelog.StypelogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: StypelogBO </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class StypelogBO extends AbstractControlBean implements Stypelog {

	public StypelogVO doCreate(StypelogVO vo) throws Exception {
		try {
			StypelogDAO dao = (StypelogDAO) DAOFactory.build(StypelogDAO.class, user);
			// TODO set the pk */
			return (StypelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(StypelogVO vo) throws Exception {
		try {
			StypelogDAO dao = (StypelogDAO) DAOFactory.build(StypelogDAO.class,user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			StypelogDAO dao = (StypelogDAO) DAOFactory.build(StypelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StypelogVO doUpdate(StypelogVO vo) throws Exception {
		try {
			StypelogDAO dao = (StypelogDAO) DAOFactory.build(StypelogDAO.class,user);
			return (StypelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StypelogVO doFindByPk(Serializable pk) throws Exception {
		try {
			StypelogDAO dao = (StypelogDAO) DAOFactory.build(StypelogDAO.class,user);
			return (StypelogVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(StypelogDBParam params) throws Exception {
		try {
			StypelogDAO dao = (StypelogDAO) DAOFactory.build(StypelogDAO.class,user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
}
