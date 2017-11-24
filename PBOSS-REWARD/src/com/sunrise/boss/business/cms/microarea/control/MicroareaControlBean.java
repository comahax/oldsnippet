/**
 * auto-generated code
 * Wed Apr 11 10:59:58 CST 2007
 */
package com.sunrise.boss.business.cms.microarea.control;

import java.io.Serializable;

import org.hibernate.NonUniqueResultException;

import com.sunrise.boss.business.cms.microarea.persistent.MicroareaDAO;
import com.sunrise.boss.business.cms.microarea.persistent.MicroareaListVO;
import com.sunrise.boss.business.cms.microarea.persistent.MicroareaVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: MicroareaControlBean
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
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/microarea/control/MicroareaControlBean"
 *           name="MicroareaControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class MicroareaControlBean extends AbstractControlBean implements
		MicroareaControl {

	public MicroareaVO doCreate(MicroareaVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(
					MicroareaDAO.class, user);
			if (dao.findByPk(vo.getMacode())!=null){
				throw new BusinessException("Microarea-001","微区域编码重复!");
			}
			return (MicroareaVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(MicroareaVO vo, User user) throws Exception {
		try {
			MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(
					MicroareaDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public MicroareaVO doUpdate(MicroareaVO vo, User user) throws Exception {
		try {
			MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(
					MicroareaDAO.class, user);
			return (MicroareaVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public MicroareaVO doFindByPk(Serializable pk, User user) throws Exception {
		MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(MicroareaDAO.class,
				user);
		return (MicroareaVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(MicroareaListVO params, User user)
			throws Exception {
		MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(MicroareaDAO.class,
				user);
		return dao.query(params);
	}

	public DataPackage doQueryByOprcode(MicroareaListVO params, User user)
			throws Exception {
		MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(MicroareaDAO.class,
				user);
		try {
			DataPackage dp = dao.queryByOprcode(params, user.getWayid());
			return dp;
		} catch (NonUniqueResultException e) {
			throw new BusinessException("Microarea-002", "登录渠道非法");
		}
	}
	
	/**
	 * 先根据组织的content页面的adacode去查行政区划表，检查该行政区划记录的组织编码是否为空
	 */
	public boolean doIfOrgcodenull(String adacode, User user) throws Exception {
		MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(MicroareaDAO.class,
				user);
		return dao.ifOrgcodenull(adacode);
	}
	
	/**
	 * 根据组织的content页面的adacode去查行政区划表，得到它对应的orgcode
	 */
	public String doGetOrgcode(String adacode, User user) throws Exception {
		MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(MicroareaDAO.class,
				user);
		return dao.getOrgcode(adacode);
	}
	/**
	 * 修改对应行政区划记录的组织编码字段
	 */
	public void doUpdateOrgcode(String adacode, String orgcode, User user)
			throws Exception {
		MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(MicroareaDAO.class,
				user);
		dao.updateOrgcode(adacode, orgcode, user);
	}
}
