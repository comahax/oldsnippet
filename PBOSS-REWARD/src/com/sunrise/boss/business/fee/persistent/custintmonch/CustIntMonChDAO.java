/**
 * auto-generated code
 * Wed Aug 16 14:03:04 CST 2006
 */
package com.sunrise.boss.business.fee.persistent.custintmonch;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * Title: CustIntMonChDAO Description: Data Access Object for CustIntMonChVO
 * Copyright: Copyright (c) 2006 Company: Maywide Tech Ltd.
 * 
 * @author mys
 * @version 1.0
 */
public class CustIntMonChDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public CustIntMonChDAO() {
		super(CustIntMonChVO.class);
	}

	public Long getSum(CustIntMonChListVO params, String sumProperty)
			throws Exception {
		Long sumvalue = new Long(0);
		if (null != sumProperty && !"".equals(sumProperty)) {
			String custid = params.get_ne_custid();
			String billcyc = params.get_ne_billcyc();
			
			StringBuffer sql = new StringBuffer("select sum(this.")
					.append(sumProperty).append(") from ")
					.append(CustIntMonChVO.class.getName()).append(" this");

			StringBuffer whereClause = new StringBuffer();

			if (custid != null && !"".equals(custid)){
				whereClause = whereClause.append("this.custid = :custid and ");
			}	
			if (billcyc != null && !"".equals(billcyc)){
				whereClause = whereClause.append("this.billcyc >= :billcyc  and ");
			}

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
			
				if (custid != null && !"".equals(custid)){
					query.setLong("custid", Long.parseLong(custid));
				}	
				if (billcyc != null && !"".equals(billcyc)){
					query.setLong("billcyc", Long.parseLong(billcyc));
				}	
				
				List list = query.list();
				if(list != null && list.size() > 0 ){
					sumvalue = (Long) list.iterator().next();
				}
				
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
