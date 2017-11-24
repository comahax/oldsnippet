/**
 * auto-generated code
 * Fri Aug 25 11:16:40 CST 2006
 */
package com.sunrise.boss.business.cms.cntycompany.persistent;

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
 * Title: CntycompanyDAO
 * </p>
 * <p>
 * Description: Data Access Object for CntycompanyVO
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
public class CntycompanyDAO extends BaseLogDAO {

	/**
	 * default constructor
	 */
	public CntycompanyDAO() {
		super(CntycompanyVO.class);
	}

	public DataPackage queryByOprcode(CntycompanyListVO params,
			String loginwayid) throws Exception {
		params.getQueryConditions().put("loginwayid", loginwayid);
		
		params.setUseFixedParamOnly(true);
		
		if (queryUniqueByNamedSqlQuery("boss.cms.cntycompany.ifHasmacode",
				params, String.class) != null) {
			throw new BusinessException("","���Ĺ�����Ȩ�鿴�ֹ�˾��Ϣ!");
		} else if (queryUniqueByNamedSqlQuery(
				"boss.cms.cntycompany.ifHassvccode", params, String.class) != null) {
			throw new BusinessException("","���Ĺ�����Ȩ�鿴�ֹ�˾��Ϣ!");
		} else if (queryUniqueByNamedSqlQuery(
				"boss.cms.cntycompany.ifHascountyid", params, String.class) != null) {
			return queryByNamedSqlQuery("boss.cms.cntycompany.queryAscnty",
					params);
		} else if (queryUniqueByNamedSqlQuery(
				"boss.cms.cntycompany.ifHascityid", params, String.class) != null) {
			return queryByNamedSqlQuery("boss.cms.cntycompany.queryAscity",
					params);
		}
		return queryByNamedSqlQuery("boss.cms.cntycompany.queryAsprov", params);
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
		vo.setOrgcode(orgcode);
		dao.update(vo);
	}
}
