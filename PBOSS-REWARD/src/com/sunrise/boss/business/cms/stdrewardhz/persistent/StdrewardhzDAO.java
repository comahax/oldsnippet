/**
 * auto-generated code
 * Sun Feb 01 17:08:50 CST 2009
 */
package com.sunrise.boss.business.cms.stdrewardhz.persistent;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: StdrewardhzDAO
 * </p>
 * <p>
 * Description: Data Access Object for StdrewardhzVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Linli
 * @version 1.0
 */
public class StdrewardhzDAO extends BaseLogDAO {

	/**
	 * default constructor
	 */
	public StdrewardhzDAO() {
		super(StdrewardhzVO.class);
	}

	public String doQueryHealth(User user) throws Exception {
		String dvalue = "";
		// 查询结果
		DataPackage result = new DataPackage();

		StringBuffer sqlHeadSel = new StringBuffer(
				"select dvalue as dvalue from ch_adt_dictparam where dkey='RWD_HZNXJ_JKD' and state=1");
//				"select dvalue as dvalue from  pboss_" + SessionFactoryRouter.conversionCityid(user.getCityid()).toLowerCase() + ".ch_adt_dictparam where dkey='RWD_HZNXJ_JKD' and state=1");
//				"select dvalue as dvalue from " + SessionFactoryRouter.conversionCityid(user.getCityid()) + "pb.ch_adt_dictparam where dkey='RWD_HZNXJ_JKD' and state=1");
		//根据user来路由地市的数据库
		Session session = SessionUtil.currentSession(user.getCityid());
//		Session session = SessionUtil.currentSession(getDbFlag());
		try {

			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("dvalue", Hibernate.STRING);

			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();

			// 取指定页面
			List list = querySel.list();
			dvalue=(String) list.get(0);
			list.clear();
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return dvalue;
	}
}
