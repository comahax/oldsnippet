/**
 * auto-generated code
 * Wed Apr 11 11:02:17 CST 2007
 */
package com.sunrise.boss.business.cms.servcent.control;

import java.io.Serializable;

import org.hibernate.NonUniqueResultException;

import com.sunrise.boss.business.cms.servcent.persistent.ServcentDAO;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentListVO;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: ServcentControlBean
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
 * @author Ye Daoe
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/servcent/control/ServcentControlBean"
 *           name="ServcentControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class ServcentControlBean extends AbstractControlBean implements
		ServcentControl {

	public ServcentVO doCreate(ServcentVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class,
					user);
			if (dao.findByPk(vo.getSvccode()) != null) {
				throw new BusinessException("Servcent-001", "服务销售中心编码重复!");
			}
			return (ServcentVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(ServcentVO vo, User user) throws Exception {
		try {
			ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public ServcentVO doUpdate(ServcentVO vo, User user) throws Exception {
		try {
			ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class,
					user);
			return (ServcentVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public ServcentVO doFindByPk(Serializable pk, User user) throws Exception {
		ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class,
				user);
		return (ServcentVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ServcentListVO params, User user)
			throws Exception {
		ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class,
				user);
		return dao.query(params);
	}

	public DataPackage doQueryByOprcode(ServcentListVO params, User user)
			throws Exception {
		ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class,
				user);
		try {
			DataPackage dp = dao.queryByOprcode(params, user.getWayid());
			return dp;
		} catch (NonUniqueResultException e) {
			throw new BusinessException("Servcent-002", "登录渠道非法");
		}
	}	

	/**
	 * 先根据组织的content页面的adacode去查行政区划表，检查该行政区划记录的组织编码是否为空
	 */
	public boolean doIfOrgcodenull(String adacode, User user) throws Exception {
		ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class,
				user);
		return dao.ifOrgcodenull(adacode);
	}
	
	/**
	 * 根据组织的content页面的adacode去查行政区划表，得到它对应的orgcode
	 */
	public String doGetOrgcode(String adacode, User user) throws Exception {
		ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class,
				user);
		return dao.getOrgcode(adacode);
	}
	/**
	 * 修改对应行政区划记录的组织编码字段
	 */
	public void doUpdateOrgcode(String adacode, String orgcode, User user)
			throws Exception {
		ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class,
				user);
		dao.updateOrgcode(adacode, orgcode, user);
	}
}
