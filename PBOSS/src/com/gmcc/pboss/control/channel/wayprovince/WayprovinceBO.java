/**
 * auto-generated code
 * Fri Aug 05 08:51:02 CST 2011
 */
package com.gmcc.pboss.control.channel.wayprovince;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.channel.wayprovince.WayprovinceDBParam;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceDAO;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: WayprovinceBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class WayprovinceBO extends AbstractControlBean implements
		Wayprovince {

	public WayprovinceVO doCreate(WayprovinceVO vo) throws Exception {
		try {
			//WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class, "DB_BOSSCOMMON");
			WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class, user);
			// TODO set the pk */
			return (WayprovinceVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WayprovinceVO vo) throws Exception {
		try {
			//WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class,"DB_BOSSCOMMON");
			WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			//WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class,"DB_BOSSCOMMON");
			WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayprovinceVO doUpdate(WayprovinceVO vo) throws Exception {
		try {
			//WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class,"DB_BOSSCOMMON");
			WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class, user);
			return (WayprovinceVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayprovinceVO doFindByPk(Serializable pk) throws Exception {
		//WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class,"DB_BOSSCOMMON");
		WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class, user);
		return (WayprovinceVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WayprovinceDBParam params)
			throws Exception {
		//WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class,"DB_BOSSCOMMON");
		WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class, user);
		return dao.query(params);
	}

	public List doQueryWpByUniquewayid(String uniquewayid) throws Exception {
		//WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class, "DB_BOSSCOMMON");
		WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class, user);
		return dao.doQueryWpByUniquewayid(uniquewayid);
		
	}

	public List doQueryWpByWayid(String wayid) throws Exception {
		//WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class, "DB_BOSSCOMMON");
		WayprovinceDAO dao = (WayprovinceDAO) DAOFactory.build(WayprovinceDAO.class, user);
		return dao.doQueryWpByWayid(wayid);
	}
}
