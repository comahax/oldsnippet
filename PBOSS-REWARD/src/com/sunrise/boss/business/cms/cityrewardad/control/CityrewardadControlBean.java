/**
 * auto-generated code
 * Sun Feb 01 10:31:20 CST 2009
 */
package com.sunrise.boss.business.cms.cityrewardad.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cityrewardad.persistent.CityrewardadVO;
import com.sunrise.boss.business.cms.cityrewardad.persistent.CityrewardadDAO;
import com.sunrise.boss.business.cms.cityrewardad.persistent.CityrewardadListVO;

/**
 * <p>Title: CityrewardadControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/cityrewardad/control/CityrewardadControlBean"
 name="CityrewardadControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
 */
public class CityrewardadControlBean extends AbstractControlBean implements
		CityrewardadControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CityrewardadVO doCreate(CityrewardadVO vo, User user)
			throws Exception {
		try {
			CityrewardadDAO dao = (CityrewardadDAO) DAOFactory.build(
					CityrewardadDAO.class, user);
			// TODO  set the pk */
			return (CityrewardadVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(CityrewardadVO vo, User user) throws Exception {
		try {
			CityrewardadDAO dao = (CityrewardadDAO) DAOFactory.build(
					CityrewardadDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CityrewardadVO doUpdate(CityrewardadVO vo, User user)
			throws Exception {
		try {
			CityrewardadDAO dao = (CityrewardadDAO) DAOFactory.build(
					CityrewardadDAO.class, user);
			return (CityrewardadVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CityrewardadVO doFindByPk(Serializable pk, User user)
			throws Exception {
		CityrewardadDAO dao = (CityrewardadDAO) DAOFactory.build(
				CityrewardadDAO.class, user);
		return (CityrewardadVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CityrewardadListVO params, User user)
			throws Exception {
		CityrewardadDAO dao = (CityrewardadDAO) DAOFactory.build(
				CityrewardadDAO.class, user);
		return dao.query(params);
	}
}
