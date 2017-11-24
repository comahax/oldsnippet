package com.gmcc.pboss.control.reward.ltypelog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.ltypelog.LtypelogDAO;
import com.gmcc.pboss.business.reward.ltypelog.LtypelogDBParam;
import com.gmcc.pboss.business.reward.ltypelog.LtypelogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: LtypelogBO </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class LtypelogBO extends AbstractControlBean implements Ltypelog {

	public LtypelogVO doCreate(LtypelogVO vo) throws Exception {
		try {
			LtypelogDAO dao = (LtypelogDAO) DAOFactory.build(LtypelogDAO.class, user);
			// TODO set the pk */
			return (LtypelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(LtypelogVO vo) throws Exception {
		try {
			LtypelogDAO dao = (LtypelogDAO) DAOFactory.build(LtypelogDAO.class,user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			LtypelogDAO dao = (LtypelogDAO) DAOFactory.build(LtypelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public LtypelogVO doUpdate(LtypelogVO vo) throws Exception {
		try {
			LtypelogDAO dao = (LtypelogDAO) DAOFactory.build(LtypelogDAO.class,user);
			return (LtypelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public LtypelogVO doFindByPk(Serializable pk) throws Exception {
		try {
			LtypelogDAO dao = (LtypelogDAO) DAOFactory.build(LtypelogDAO.class,user);
			return (LtypelogVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(LtypelogDBParam params) throws Exception {
		try {
			LtypelogDAO dao = (LtypelogDAO) DAOFactory.build(LtypelogDAO.class,user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
}
