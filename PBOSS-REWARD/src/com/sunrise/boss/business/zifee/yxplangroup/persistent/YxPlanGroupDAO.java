/**
 * auto-generated code
 * Fri Aug 18 11:29:19 CST 2006
 */
package com.sunrise.boss.business.zifee.yxplangroup.persistent;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: YxPlanGroupDAO
 * </p>
 * <p>
 * Description: Data Access Object for YxPlanGroupVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxPlanGroupDAO extends BaseLogDAO {

	/**
	 * default constructor
	 */
	public YxPlanGroupDAO() {
		super(YxPlanGroupVO.class);
	}

	/**
	 * 根据营销方案组标识删除所有的成员关系
	 */
	public void deleteByGroupid(Long groupid, User user) throws Exception {

		if (groupid != null) {

			StringBuffer selectHQL = new StringBuffer(" delete from ").append(
					YxPlanGroupVO.class.getName()).append(
					" where groupyxplan = " + groupid.toString());

			Session session = SessionUtil.currentSession(user.getCityid());

			try {
				session.createQuery(selectHQL.toString()).executeUpdate();
			} catch (Exception ex) {
				throw ex;
			}

		}
	}
	
	public DataPackage batchQueryGroup(String queryItems,User user) throws Exception{
		Session session = SessionUtil.currentSession(getDbFlag());
		String sql="select a.groupyxplan as groupyxplan,b.groupname as groupname,a.memyxplan as memyxplan,c.yxplanname as yxplanname "+
					" from pc_ps_yxplangroup a,pc_ps_yxplangpinf b,pc_ps_yxplan c "+
					" where a.groupyxplan=b.groupid and a.memyxplan=c.yxplanid and b.areacode= '"+user.getCityid()+"'"+
					" and a.groupyxplan in ("+queryItems+") order by a.groupyxplan";
    	SQLQuery query = session.createSQLQuery(sql);
    	query.addScalar("groupyxplan", Hibernate.LONG);
    	query.addScalar("groupname", Hibernate.STRING);
    	query.addScalar("memyxplan", Hibernate.LONG);
    	query.addScalar("yxplanname", Hibernate.STRING);
    	List list = query.list();
    	DataPackage dp = new DataPackage();
    	dp.setDatas(list);
    	dp.setRowCount(list.size());
    	return dp;
	}
	
	public DataPackage batchQueryMem(String queryItems,User user) throws Exception{
		Session session = SessionUtil.currentSession(getDbFlag());
		String sql="select a.groupyxplan as groupyxplan,b.groupname as groupname,a.memyxplan as memyxplan,c.yxplanname as yxplanname "+
					" from pc_ps_yxplangroup a,pc_ps_yxplangpinf b,pc_ps_yxplan c "+
					" where a.groupyxplan=b.groupid and a.memyxplan=c.yxplanid and b.areacode= '"+user.getCityid()+"'"+
					" and a.memyxplan in ("+queryItems+") order by a.groupyxplan";
    	SQLQuery query = session.createSQLQuery(sql);
    	query.addScalar("groupyxplan", Hibernate.LONG);
    	query.addScalar("groupname", Hibernate.STRING);
    	query.addScalar("memyxplan", Hibernate.LONG);
    	query.addScalar("yxplanname", Hibernate.STRING);
    	List list = query.list();
    	DataPackage dp = new DataPackage();
    	dp.setDatas(list);
    	dp.setRowCount(list.size());
    	return dp;
	}

	public DataPackage batchQueryAll(String queryItems,User user) throws Exception{
		Session session = SessionUtil.currentSession(getDbFlag());
		String sql="select a.groupyxplan as groupyxplan,b.groupname as groupname,a.memyxplan as memyxplan,c.yxplanname as yxplanname "+
					" from pc_ps_yxplangroup a,pc_ps_yxplangpinf b,pc_ps_yxplan c "+
					" where a.groupyxplan=b.groupid and a.memyxplan=c.yxplanid and b.areacode= '"+user.getCityid()+"'"+
					" order by a.groupyxplan";
    	SQLQuery query = session.createSQLQuery(sql);
    	query.addScalar("groupyxplan", Hibernate.LONG);
    	query.addScalar("groupname", Hibernate.STRING);
    	query.addScalar("memyxplan", Hibernate.LONG);
    	query.addScalar("yxplanname", Hibernate.STRING);
    	List list = query.list();
    	DataPackage dp = new DataPackage();
    	dp.setDatas(list);
    	dp.setRowCount(list.size());
    	return dp;
	}
}
