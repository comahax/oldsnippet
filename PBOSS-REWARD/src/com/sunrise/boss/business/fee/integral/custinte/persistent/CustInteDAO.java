/**
 * auto-generated code
 * 2006.08.08
 */
package com.sunrise.boss.business.fee.integral.custinte.persistent;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * 
 * Title: CutsInteDAO Description: Data Access Object for CutsInteVO Copyright:
 * Copyright (c) 2006 Company: sunrise Tech Ltd.
 * 
 * @author mys
 * @version 1.0
 */
public class CustInteDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public CustInteDAO() {
		super(CustInteVO.class);
	}

	/**
	 * 取（sumProperty）字段的总数
	 * @param params
	 * @param sumProperty
	 * @return 返回总数
	 * @throws Exception
	 */	 
	public Long getSum(CustInteListVO params, String sumProperty)
			throws Exception {
		Long sumvalue = new Long(0);
		if (null != sumProperty && !"".equals(sumProperty)) {
			Long custid = Long.valueOf(params.get_ne_custid());
			Date stoptime = params.getStoptime();

			StringBuffer sql = new StringBuffer("select sum(this.").append(
					sumProperty).append(") from ").append(
							CustInteVO.class.getName()).append(" this");

			StringBuffer whereClause = new StringBuffer();

			if (custid != null)
				whereClause = whereClause
						.append("this.custid = :custid and ");
			if (stoptime != null)
				whereClause = whereClause
						.append("this.stoptime >= :stoptime and this.starttime <= :starttime and ");

			if (whereClause.length() > 4) {
				whereClause = whereClause.delete(whereClause.length() - 4,
						whereClause.length() - 1);
			}
			if (whereClause.length() > 4) {
				sql = sql.append(" WHERE ").append(whereClause);
			}

			try {
				Session session = SessionUtil.currentSession(getDbFlag());
				Query query = session.createQuery(sql.toString());

				if (custid != null)
					query.setLong("custid", custid.longValue());
				if (stoptime != null){
					query.setDate("stoptime", stoptime);
					query.setDate("starttime", stoptime);
				}	
				List list = query.list();
				if(list != null && list.size() > 0 )
					sumvalue = (Long) list.iterator().next();
			} catch (HibernateException ex) {
				if (ex.getCause() != null) {
					throw new Exception(ex.getCause());
				} else {
					throw ex;
				}
			}
		}

		return sumvalue;
	}

}
