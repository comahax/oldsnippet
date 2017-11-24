/**
 * auto-generated code
 * Thu Apr 05 10:00:59 CST 2007
 */
package com.sunrise.boss.business.cms.adimarea.persistent;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyDAO;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyVO;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyDAO;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyVO;
import com.sunrise.boss.business.cms.microarea.persistent.MicroareaDAO;
import com.sunrise.boss.business.cms.microarea.persistent.MicroareaVO;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentDAO;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentVO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: AdimareaDAO
 * </p>
 * <p>
 * Description: Data Access Object for AdimareaVO
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
public class AdimareaDAO extends BaseLogDAO {

	/**
	 * default constructor
	 */
	public AdimareaDAO() {
		super(AdimareaVO.class);
	}

	public List doQuerySuberada(String adacode) throws Exception {
		Session session = SessionUtil.currentSession(this.getDbFlag());
		Query query = session.getNamedQuery("boss.cms.adimarea.querySubAdas");
		query.setString("idorname", adacode);
		List list = query.list();
		return list;
	}

	public DataPackage queryByOprcode(AdimareaListVO params, String loginwayid)
			throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());

		SQLQuery query = (SQLQuery) session
				.getNamedQuery("boss.cms.adimarea.queryByUser");
		String queryString = query.getQueryString();
		params.getQueryConditions().put("loginwayid", loginwayid);
		return queryBySql(queryString, params, 0);
	}

	public Object ifExistAdacode(AdimareaListVO params, String loginwayid)
			throws Exception {
		AdimareaListVO params2 = new AdimareaListVO();
		params2.getQueryConditions().put("loginwayid", loginwayid);
		return queryUniqueByNamedSqlQuery("boss.cms.adimarea.ifExistAdacode", params2, String.class);
	}

	/**
	 * 当用户新增或删除一条记录时,需要判断这条记录是否在其登录工号所允许的数据范围内
	 */
	public boolean judgeIfReasonable(AdimareaListVO params, String loginwayid,
			String contentuppercode) throws Exception {
		params.getQueryConditions().put("loginwayid", loginwayid);
		params.getQueryConditions().put("contentuppercode", contentuppercode);
		DataPackage dp = queryByNamedSqlQuery(
				"boss.cms.adimarea.judgeIfReasonable", params);
		if (dp.getRowCount() < 1) {
			return false;
		} else
			return true;
	}

	/**
	 * 汇总辖区人口数
	 */
	public Long AddupTotalppn(AdimareaListVO listvo) throws Exception {
		listvo.getQueryConditions().put("uppercode", listvo.get_se_uppercode());
		Long totalppns = (Long) queryUniqueByNamedSqlQuery(
				"boss.cms.adimarea.AddupTotalppn", listvo, Long.class);
		return totalppns;
	}

	/**
	 * 汇总常住人口数
	 */
	public Long AddupResippn(AdimareaListVO listvo) throws Exception {
		listvo.getQueryConditions().put("uppercode", listvo.get_se_uppercode());
		Long resippns = (Long) queryUniqueByNamedSqlQuery(
				"boss.cms.adimarea.AddupResippn", listvo, Long.class);
		return resippns;
	}

	/**
	 * 汇总流动人口数
	 */
	public Long AddupNonresippn(AdimareaListVO listvo) throws Exception {
		listvo.getQueryConditions().put("uppercode", listvo.get_se_uppercode());
		Long nonresippns = (Long) queryUniqueByNamedSqlQuery(
				"boss.cms.adimarea.AddupNonresippn", listvo, Long.class);
		return nonresippns;
	}

	/**
	 * 汇总辖区面积
	 */
	public Long AddupAdarea(AdimareaListVO listvo) throws Exception {
		listvo.getQueryConditions().put("uppercode", listvo.get_se_uppercode());
		Long adareas = (Long) queryUniqueByNamedSqlQuery(
				"boss.cms.adimarea.AddupAdarea", listvo, Long.class);
		return adareas;
	}

	/**
	 * 汇总辖区移动用户数
	 */
	public Long AddupGmccusers(AdimareaListVO listvo) throws Exception {
		listvo.getQueryConditions().put("uppercode", listvo.get_se_uppercode());
		Long gmccuserss = (Long) queryUniqueByNamedSqlQuery(
				"boss.cms.adimarea.AddupGmccusers", listvo, Long.class);
		return gmccuserss;
	}

	/**
	 * 汇总辖区联通用户数
	 */
	public Long AddupCucusers(AdimareaListVO listvo) throws Exception {
		listvo.getQueryConditions().put("uppercode", listvo.get_se_uppercode());
		Long cucuserss = (Long) queryUniqueByNamedSqlQuery(
				"boss.cms.adimarea.AddupCucusers", listvo, Long.class);
		return cucuserss;
	}

	/**
	 * 汇总辖区电信用户数
	 */
	public Long AddupCtcusers(AdimareaListVO listvo) throws Exception {
		listvo.getQueryConditions().put("uppercode", listvo.get_se_uppercode());
		Long ctcuserss = (Long) queryUniqueByNamedSqlQuery(
				"boss.cms.adimarea.AddupCtcusers", listvo, Long.class);
		return ctcuserss;
	}

	/**
	 * 汇总辖区移动电话用户数
	 */
	public Long AddupHandphones(AdimareaListVO listvo) throws Exception {
		listvo.getQueryConditions().put("uppercode", listvo.get_se_uppercode());
		Long handphoness = (Long) queryUniqueByNamedSqlQuery(
				"boss.cms.adimarea.AddupHandphones", listvo, Long.class);
		return handphoness;
	}
	
	/**
	 * 当保存行政区划信息时,同时把此条记录对应的组织结构信息的行政区划编码更新为当前所保存的记录的行政区划编码.
	 */
	public void ChgAdacodeofOrg(String orgcode,String adacode,User user) throws Exception{
		Session session = SessionUtil.currentSession(getDbFlag());
		StringBuffer selectHQL1 = new StringBuffer("from com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyVO this where this.citycompid ='")
								.append(orgcode).append("'");
		StringBuffer selectHQL2 = new StringBuffer("from com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyVO this where this.countycompid ='")
								.append(orgcode).append("'");
		StringBuffer selectHQL3 = new StringBuffer("from com.sunrise.boss.business.cms.servcent.persistent.ServcentVO this where this.svccode ='")
								.append(orgcode).append("'");
		StringBuffer selectHQL4 = new StringBuffer("from com.sunrise.boss.business.cms.microarea.persistent.MicroareaVO this where this.macode ='")
								.append(orgcode).append("'");
		Query query1 = session.createQuery(selectHQL1.toString());
		List list1 = query1.list();
		if (list1 != null && list1.size() > 0) {
			CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(
					CitycompanyDAO.class, user);
			CitycompanyVO vo = (CitycompanyVO)dao.findByPk(orgcode);
			vo.setAdacode(adacode);
			dao.update(vo);
		}else{
			Query query2 = session.createQuery(selectHQL2.toString());
			List list2 = query2.list();
			if (list2 != null && list2.size() > 0){
				CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(
						CntycompanyDAO.class, user);
				CntycompanyVO vo = (CntycompanyVO)dao.findByPk(orgcode);
				vo.setAdacode(adacode);
				dao.update(vo);
			}else{
				Query query3 = session.createQuery(selectHQL3.toString());
				List list3 = query3.list();
				if (list3 != null && list3.size() > 0){
					ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class,
							user);
					ServcentVO vo = (ServcentVO)dao.findByPk(orgcode);
					vo.setAdacode(adacode);
					dao.update(vo);
				}else{
					Query query4 = session.createQuery(selectHQL4.toString());
					List list4 = query4.list();
					if (list4 != null && list4.size() > 0){
						MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(
								MicroareaDAO.class, user);
						MicroareaVO vo = (MicroareaVO)dao.findByPk(orgcode);
						vo.setAdacode(adacode);
						dao.update(vo);
					}
				}
			}
		}
	}
}
