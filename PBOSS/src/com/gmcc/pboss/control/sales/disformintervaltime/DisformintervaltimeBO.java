/**
 * auto-generated code
 * Sat Mar 31 17:39:07 CST 2012
 */
package com.gmcc.pboss.control.sales.disformintervaltime;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.disformintervaltime.DisformintervaltimeDBParam;
import com.gmcc.pboss.business.sales.disformintervaltime.DisformintervaltimeDAO;
import com.gmcc.pboss.business.sales.disformintervaltime.DisformintervaltimeVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: DisformintervaltimeBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class DisformintervaltimeBO extends AbstractControlBean implements
		Disformintervaltime {

	public DisformintervaltimeVO doCreate(DisformintervaltimeVO vo) throws Exception {
		try {
			DisformintervaltimeDAO dao = (DisformintervaltimeDAO) DAOFactory.build(DisformintervaltimeDAO.class, user);
			// TODO set the pk */
			return (DisformintervaltimeVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(DisformintervaltimeVO vo) throws Exception {
		try {
			DisformintervaltimeDAO dao = (DisformintervaltimeDAO) DAOFactory.build(DisformintervaltimeDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DisformintervaltimeDAO dao = (DisformintervaltimeDAO) DAOFactory.build(DisformintervaltimeDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisformintervaltimeVO doUpdate(DisformintervaltimeVO vo) throws Exception {
		try {
			DisformintervaltimeDAO dao = (DisformintervaltimeDAO) DAOFactory.build(DisformintervaltimeDAO.class,user);
			return (DisformintervaltimeVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisformintervaltimeVO doFindByPk(Serializable pk) throws Exception {
		DisformintervaltimeDAO dao = (DisformintervaltimeDAO) DAOFactory.build(DisformintervaltimeDAO.class,user);
		return (DisformintervaltimeVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(DisformintervaltimeDBParam params)
			throws Exception {
		DisformintervaltimeDAO dao = (DisformintervaltimeDAO) DAOFactory.build(DisformintervaltimeDAO.class,user);
		return dao.query(params);
	}
	
	//【分销管理】—>【配送单管理】 ->【配送单超时预警统计查询】
	public DataPackage doDisformStat(DisformintervaltimeDBParam params) throws Exception {
		DisformintervaltimeDAO dao = (DisformintervaltimeDAO) DAOFactory.build(DisformintervaltimeDAO.class,user);
		return dao.doDisformStat(params);
	}
}
