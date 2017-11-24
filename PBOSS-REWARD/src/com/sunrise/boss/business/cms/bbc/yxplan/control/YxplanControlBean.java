/**
 * auto-generated code
 * Tue May 05 11:03:52 CST 2009
 */
package com.sunrise.boss.business.cms.bbc.yxplan.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.yxplan.persistent.YxplanDAO;
import com.sunrise.boss.business.cms.bbc.yxplan.persistent.YxplanListVO;
import com.sunrise.boss.business.cms.bbc.yxplan.persistent.YxplanVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanDAO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;

/**
 * <p>
 * Title: YxplanControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/bbc/yxplan/control/YxplanControlBean"
 *           name="YxplanControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class YxplanControlBean extends AbstractControlBean implements
		YxplanControl {

	public YxplanVO doCreate(YxplanVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			YxplanDAO dao = (YxplanDAO) DAOFactory.build(YxplanDAO.class, user);
			YxPlanDAO zfDAO = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class,
					user);
			zfDAO.setDbFlag("DB_BOSSCOMMON");
			YxPlanVO zfVO = (YxPlanVO) zfDAO.findByPk(vo.getYxplanid());
			if (zfVO != null) {
				String cityid = zfVO.getAreacode();
				if (cityid == null) {
					throw new Exception("所选营销方案区域标识为空,请修复数据");
				}
				if ("100".equals(cityid)) {
					vo.setCityid("999");
				} else {
					vo.setCityid(zfVO.getAreacode());
				}
			}

			return (YxplanVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(YxplanVO vo, User user) throws Exception {
		try {
			YxplanDAO dao = (YxplanDAO) DAOFactory.build(YxplanDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public YxplanVO doUpdate(YxplanVO vo, User user) throws Exception {
		try {
			YxplanDAO dao = (YxplanDAO) DAOFactory.build(YxplanDAO.class, user);
			return (YxplanVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public YxplanVO doFindByPk(Serializable pk, User user) throws Exception {
		YxplanDAO dao = (YxplanDAO) DAOFactory.build(YxplanDAO.class, user);
		return (YxplanVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(YxplanListVO params, User user) throws Exception {
		YxplanDAO dao = (YxplanDAO) DAOFactory.build(YxplanDAO.class, user);
		if ("".equals(params.get_sk_opnname())
				&& "".equals(params.get_sk_yxplanname())
				|| (params.get_sk_opnname() == null || params
						.get_sk_yxplanname() == null)) {
			return dao.query(params);
		} else {
			return doQuery2(params, user);
		}
	}

	public DataPackage doQuery2(YxplanListVO params, User user)
			throws Exception {
		YxplanDAO dao = (YxplanDAO) DAOFactory.build(YxplanDAO.class, user);
		return dao.doQueryName(params);
	}
}
