/**
 * auto-generated code
 * Fri Aug 25 11:23:52 CST 2006
 */
package com.sunrise.boss.business.cms.citycompany.control;

import java.io.Serializable;

import org.hibernate.NonUniqueResultException;

import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyDAO;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyListVO;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyVO;
import com.sunrise.boss.business.cms.cntycompany.control.CntycompanyControl;
import com.sunrise.boss.business.cms.cntycompany.control.CntycompanyControlBean;
import com.sunrise.boss.business.cms.custbchtype.control.CustbchtypeControl;
import com.sunrise.boss.business.cms.custbchtype.control.CustbchtypeControlBean;
import com.sunrise.boss.business.cms.custwaytype.control.CustwaytypeControl;
import com.sunrise.boss.business.cms.custwaytype.control.CustwaytypeControlBean;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: CitycompanyControlBean
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
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/citycompany/control/CitycompanyControlBean"
 *           name="CitycompanyControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class CitycompanyControlBean extends AbstractControlBean implements
		CitycompanyControl {

	public CitycompanyVO doCreate(CitycompanyVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(
					CitycompanyDAO.class, user);
			if (dao.findByPk(vo.getCitycompid()) != null) {
				throw new BusinessException("Citycompany-001","�й�˾�����ظ�!");
			}
			return (CitycompanyVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(CitycompanyVO vo, User user) throws Exception {
		try {
			CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(
					CitycompanyDAO.class, user);

			// TODO: ɾ�����

			CntycompanyControl cntycompanyControl = (CntycompanyControl) ControlFactory
					.build(CntycompanyControlBean.class);
			DataPackage citys = cntycompanyControl.getCntycompanysOfCity(vo
					.getCitycompid(), user);

			if (citys.getDatas().size() > 0)
				throw new BusinessException("Citycompany-002", "����������ʹ�ã�����ɾ��");

			CustwaytypeControl custwaytypeControl = (CustwaytypeControl) ControlFactory
					.build(CustwaytypeControlBean.class);
			DataPackage custway = custwaytypeControl.doFindByCitycompany(vo
					.getCitycompid(), user);

			if (custway.getDatas().size() > 0)
				throw new BusinessException("Citycompany-003", "�����ı��ֹ�˾�Զ������ʹ�ã�����ɾ��");

			CustbchtypeControl custbchtypeControl = (CustbchtypeControl) ControlFactory
					.build(CustbchtypeControlBean.class);
			DataPackage custbchtype = custbchtypeControl.doFindByCitycompany(vo
					.getCitycompid(), user);

			if (custbchtype.getDatas().size() > 0)
				throw new BusinessException("Citycompany-004", "�����ı��Զ����������ʹ�ã�����ɾ��");
			dao.remove(vo);

		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CitycompanyVO doUpdate(CitycompanyVO vo, User user) throws Exception {
		try {
			CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(
					CitycompanyDAO.class, user);
			return (CitycompanyVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CitycompanyVO doFindByPk(Serializable pk, User user)
			throws Exception {
		CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(
				CitycompanyDAO.class, user);
		return (CitycompanyVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CitycompanyListVO params, User user)
			throws Exception {
		CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(
				CitycompanyDAO.class, user);
		return dao.query(params);
	}

	public DataPackage getCitycompanysOfCenter(String centerid, User user)
			throws Exception {
		CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(
				CitycompanyDAO.class, user);

		CitycompanyListVO listVO = new CitycompanyListVO();
		listVO.set_se_centerid(centerid);
		return dao.query(listVO);
	}

	public DataPackage doQueryByOprcode(CitycompanyListVO params, User user)
			throws Exception {
		CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(
				CitycompanyDAO.class, user);
		try {
			DataPackage dp = dao.queryByOprcode(params, user.getWayid());
			return dp;
		} catch (NonUniqueResultException e) {
			throw new BusinessException("Citycompany-005", "��¼�����Ƿ�");
		}
	}
	
	/**
	 * �ȸ�����֯��contentҳ���adacodeȥ��������������������������¼����֯�����Ƿ�Ϊ��
	 */
	public boolean doIfOrgcodenull(String adacode, User user) throws Exception {
		CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(CitycompanyDAO.class,
				user);
		return dao.ifOrgcodenull(adacode);
	}
	
	/**
	 * ������֯��contentҳ���adacodeȥ�������������õ�����Ӧ��orgcode
	 */
	public String doGetOrgcode(String adacode, User user) throws Exception {
		CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(CitycompanyDAO.class,
				user);
		return dao.getOrgcode(adacode);
	}
	/**
	 * �޸Ķ�Ӧ����������¼����֯�����ֶ�
	 */
	public void doUpdateOrgcode(String adacode, String orgcode, User user)
			throws Exception {
		CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(CitycompanyDAO.class,
				user);
		dao.updateOrgcode(adacode, orgcode, user);
	}
}
