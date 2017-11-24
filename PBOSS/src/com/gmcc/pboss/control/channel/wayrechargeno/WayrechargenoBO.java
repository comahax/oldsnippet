/**
 * auto-generated code
 * Tue Jul 12 17:07:47 CST 2011
 */
package com.gmcc.pboss.control.channel.wayrechargeno;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.wayrechargeno.WayrechargenoDBParam;
import com.gmcc.pboss.business.channel.wayrechargeno.WayrechargenoDAO;
import com.gmcc.pboss.business.channel.wayrechargeno.WayrechargenoVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: WayrechargenoBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class WayrechargenoBO extends AbstractControlBean implements
		Wayrechargeno {

	public WayrechargenoVO doCreate(WayrechargenoVO vo) throws Exception {
		try {
			WayrechargenoDAO dao = (WayrechargenoDAO) DAOFactory.build(WayrechargenoDAO.class, user);
			// TODO set the pk */
			return (WayrechargenoVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WayrechargenoVO vo) throws Exception {
		try {
			WayrechargenoDAO dao = (WayrechargenoDAO) DAOFactory.build(WayrechargenoDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WayrechargenoDAO dao = (WayrechargenoDAO) DAOFactory.build(WayrechargenoDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayrechargenoVO doUpdate(WayrechargenoVO vo) throws Exception {
		try {
			WayrechargenoDAO dao = (WayrechargenoDAO) DAOFactory.build(WayrechargenoDAO.class,user);
			return (WayrechargenoVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayrechargenoVO doFindByPk(Serializable pk) throws Exception {
		WayrechargenoDAO dao = (WayrechargenoDAO) DAOFactory.build(WayrechargenoDAO.class,user);
		return (WayrechargenoVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WayrechargenoDBParam params)
			throws Exception {
		WayrechargenoDAO dao = (WayrechargenoDAO) DAOFactory.build(WayrechargenoDAO.class,user);
		return dao.query(params);
	}
}
