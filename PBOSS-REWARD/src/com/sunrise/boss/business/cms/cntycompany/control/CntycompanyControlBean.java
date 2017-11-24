/**
 * auto-generated code
 * Fri Aug 25 11:16:40 CST 2006
 */
package com.sunrise.boss.business.cms.cntycompany.control;

import java.io.Serializable;

import org.hibernate.NonUniqueResultException;

import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyDAO;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyListVO;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: CntycompanyControlBean
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
 * @author yjr
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/cntycompany/control/CntycompanyControlBean"
 *           name="CntycompanyControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class CntycompanyControlBean extends AbstractControlBean implements
		CntycompanyControl {

	public CntycompanyVO doCreate(CntycompanyVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(
					CntycompanyDAO.class, user);
			if (dao.findByPk(vo.getCountycompid()) != null) {
				throw new BusinessException("Cntycompany-001","县公司编码重复!");
			}
			return (CntycompanyVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(CntycompanyVO vo, User user) throws Exception {
		try {
			CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(
					CntycompanyDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CntycompanyVO doUpdate(CntycompanyVO vo, User user) throws Exception {
		try {
			CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(
					CntycompanyDAO.class, user);
			return (CntycompanyVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CntycompanyVO doFindByPk(Serializable pk, User user)
			throws Exception {
		CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(
				CntycompanyDAO.class, user);
		return (CntycompanyVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CntycompanyListVO params, User user)
			throws Exception {
		CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(
				CntycompanyDAO.class, user);
		return dao.query(params);
	}

	public DataPackage getCntycompanysOfCity(String cityid, User user)
			throws Exception {
		CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(
				CntycompanyDAO.class, user);

		CntycompanyListVO listVO = new CntycompanyListVO();
		listVO.set_se_citycompid(cityid);
		return dao.query(listVO);
	}

	public DataPackage doQueryByOprcode(CntycompanyListVO params, User user)
			throws Exception {
		CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(
				CntycompanyDAO.class, user);
		try {
			DataPackage dp = dao.queryByOprcode(params, user.getWayid());
			return dp;
		} catch (NonUniqueResultException e) {
			throw new BusinessException("Cntycompany-002", "登录渠道非法");
		}
	}
	
	/**
	 * 先根据组织的content页面的adacode去查行政区划表，检查该行政区划记录的组织编码是否为空
	 */
	public boolean doIfOrgcodenull(String adacode, User user) throws Exception {
		CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(CntycompanyDAO.class,
				user);
		return dao.ifOrgcodenull(adacode);
	}
	
	/**
	 * 根据组织的content页面的adacode去查行政区划表，得到它对应的orgcode
	 */
	public String doGetOrgcode(String adacode, User user) throws Exception {
		CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(CntycompanyDAO.class,
				user);
		return dao.getOrgcode(adacode);
	}
	/**
	 * 修改对应行政区划记录的组织编码字段
	 */
	public void doUpdateOrgcode(String adacode, String orgcode, User user)
			throws Exception {
		CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(CntycompanyDAO.class,
				user);
		dao.updateOrgcode(adacode, orgcode, user);
	}
}
