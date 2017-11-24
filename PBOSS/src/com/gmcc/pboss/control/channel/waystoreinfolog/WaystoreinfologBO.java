package com.gmcc.pboss.control.channel.waystoreinfolog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waystoreinfolog.WaystoreinfologDBParam;
import com.gmcc.pboss.business.channel.waystoreinfolog.WaystoreinfologDAO;
import com.gmcc.pboss.business.channel.waystoreinfolog.WaystoreinfologVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: WaystoreinfologBO </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class WaystoreinfologBO extends AbstractControlBean implements Waystoreinfolog {

	public WaystoreinfologVO doCreate(WaystoreinfologVO vo) throws Exception {
		try {
			WaystoreinfologDAO dao = (WaystoreinfologDAO) DAOFactory.build(WaystoreinfologDAO.class, user);
			// TODO set the pk */
			return (WaystoreinfologVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WaystoreinfologVO vo) throws Exception {
		try {
			WaystoreinfologDAO dao = (WaystoreinfologDAO) DAOFactory.build(WaystoreinfologDAO.class,user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WaystoreinfologDAO dao = (WaystoreinfologDAO) DAOFactory.build(WaystoreinfologDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaystoreinfologVO doUpdate(WaystoreinfologVO vo) throws Exception {
		try {
			WaystoreinfologDAO dao = (WaystoreinfologDAO) DAOFactory.build(WaystoreinfologDAO.class,user);
			return (WaystoreinfologVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaystoreinfologVO doFindByPk(Serializable pk) throws Exception {
		try {
			WaystoreinfologDAO dao = (WaystoreinfologDAO) DAOFactory.build(WaystoreinfologDAO.class,user);
			return (WaystoreinfologVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(WaystoreinfologDBParam params) throws Exception {
		try {
			WaystoreinfologDAO dao = (WaystoreinfologDAO) DAOFactory.build(WaystoreinfologDAO.class,user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
}
