/**
 * auto-generated code
 * Wed Apr 11 11:02:17 CST 2007
 */
package com.sunrise.boss.business.cms.servcent.persistent;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaDAO;
import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: ServcentDAO
 * </p>
 * <p>
 * Description: Data Access Object for ServcentVO
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
public class ServcentDAO extends BaseLogDAO {

	/**
	 * default constructor
	 */
	public ServcentDAO() {
		super(ServcentVO.class);
	}

	public DataPackage queryByOprcode(ServcentListVO params, String loginwayid)
			throws Exception {
		params.getQueryConditions().put("loginwayid", loginwayid);
		
		params.setUseFixedParamOnly(true);
		
		if (queryUniqueByNamedSqlQuery("boss.cms.servcent.ifHasmacode", params,
				String.class) != null) {
			throw new BusinessException("","���Ĺ�����Ȩ�鿴��������������Ϣ!");
		} else if (queryUniqueByNamedSqlQuery("boss.cms.servcent.ifHassvccode",
				params, String.class) != null) {
			return queryByNamedSqlQuery("boss.cms.servcent.queryAsserv", params);
		} else if (queryUniqueByNamedSqlQuery(
				"boss.cms.servcent.ifHascountyid", params, String.class) != null) {
			return queryByNamedSqlQuery("boss.cms.servcent.queryAscounty",
					params);
		} else if (queryUniqueByNamedSqlQuery("boss.cms.servcent.ifHascityid",
				params, String.class) != null) {
			return queryByNamedSqlQuery("boss.cms.servcent.queryAscity", params);
		}else return queryByNamedSqlQuery("boss.cms.servcent.queryAsprov", params);
	}

	/**
	 * ���û�������ɾ��һ����¼ʱ,��Ҫ�ж�������¼�Ƿ������¼��������������ݷ�Χ��(��ʱû����)
	 */
	public boolean judgeIfReasonable(ServcentListVO params,
			String loginsvccode, String contentcountyid) throws Exception {
		params.getQueryConditions().put("loginsvccode", loginsvccode);
		params.getQueryConditions().put("contentcountyid", contentcountyid);
		DataPackage dp = queryByNamedSqlQuery(
				"boss.cms.servcent.judgeIfReasonable", params);
		if (dp.getRowCount() < 1) {
			return false;
		} else
			return true;
	}

	/**
	 * �ȸ�����֯��contentҳ���adacodeȥ��������������������������¼����֯�����Ƿ�Ϊ��
	 */
	public boolean ifOrgcodenull(String adacode) throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		StringBuffer selectHQL = new StringBuffer(
				"select this from com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO this where this.adacode ='")
				.append(adacode).append("'");
		Query query = session.createQuery(selectHQL.toString());
		List list = query.list();
		if (list.size() < 1) {
			return true;
		}else if (((AdimareaVO) list.get(0)).getOrgcode()==null){
			return true;
		}
		else
			throw new BusinessException("CMS-915","��Ӧ����������¼����֯���벻Ϊ��!");
			//return false;
	}
	
	/**
	 * ������֯��contentҳ���adacodeȥ�������������õ�����Ӧ��orgcode
	 */
	public String getOrgcode(String adacode) throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		StringBuffer selectHQL = new StringBuffer(
				"select this from com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO this where this.adacode ='")
				.append(adacode).append("'");
		Query query = session.createQuery(selectHQL.toString());
		List list = query.list();
		if (list != null && list.size() > 0) {
			return ((AdimareaVO) list.get(0)).getOrgcode();
		} else
			return null;
	}

	/**
	 * �޸Ķ�Ӧ����������¼����֯�����ֶ�
	 */
	public void updateOrgcode(String adacode, String orgcode, User user)
			throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		AdimareaVO vo = (AdimareaVO) dao.findByPk(adacode);
		if (vo != null) {
			vo.setOrgcode(orgcode);
			dao.update(vo);
		} else
			throw new BusinessException("CMS-916", "����������������������!");
	}
}
