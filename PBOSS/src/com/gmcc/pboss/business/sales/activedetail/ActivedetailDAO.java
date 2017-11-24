/**
 * auto-generated code
 * Wed Oct 17 11:57:11 CST 2012
 */
package com.gmcc.pboss.business.sales.activedetail;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

/**
 * <p>
 * Title: ActivedetailDAO
 * </p>
 * <p>
 * Description: Data Access Object for CompanyVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Li Min
 * @version 1.0
 */
public class ActivedetailDAO extends AbstractDAO {

	/**
	 * default constructor
	 */
	public ActivedetailDAO() {
		super(ActivedetailVO.class);
	}

	public void doUpdateActivedetail(String startstocktime, String endstocktime) {
		Session session = SessionUtils.currentSession(this.getDbFlag());
		String sql = "insert into FX_SW_ACTIVEDETAIL  (sid,COUNTYID,Svccode,Mareacode,Upperwayid,Waymagcode,Orderid,Wayid,Wayname,Starlevel,Brand,Comresid,Acttime,Stocktime,Comcategory,Createtime,Statisticstime)  select FX_SW_ACTIVEDETAIL_SEQ.Nextval, ss.* "
				+ " from (select w.countyid, "
				+ "   w.svccode, "
				+ "   w.mareacode, "
				+ "   w.upperwayid, "
				+ "  w.waymagcode, "
				+ "   s1.orderid, "
				+ "   s1.wayid, "
				+ "   w.wayname, "
				+ "   w.starlevel, "
				+ "    s1.brand, "
				+ "    s1.comresid, "
				+ "   s1.acttime, "
				+ "   '' as stocktime, "
				+ "    s1.comcategory, "
				+ "   '' as createtime, "
				+ "   sysdate as STATISTICSTIME "
				+ " from (select t2.wayid, "
				+ "     t2.brand, "
				+ "     t3.orderid, "
				+ "     t4.comresid, "
				+ "     t2.acttime, "
				+ "     t2.comcategory "
				+ " from FX_SW_PARTNERRES  t2, "
				+ "    fx_sw_order       t3, "
				+ "    fx_sw_orderresdet t4 "
				+ " where t2.wayid = t3.wayid "
				+ "  and t3.orderid = t4.orderid "
				+ "  and t2.comresid = t4.comresid and t2.batchno=t4.batchno "
				+ "   and t2.restype = 'COMRESSMP' "
				+ "  and t2.isactive = 1 "
				+ "    and t3.orderstate = 'FINISHED') s1, "
				+ " Ch_pw_way w "
				+ "  where s1.wayid = w.wayid "
				+ "  union "
				+ "  select w.countyid, "
				+ "   w.svccode, "
				+ "   w.mareacode, "
				+ "  w.upperwayid, "
				+ "  w.waymagcode, "
				+ "  '' as orderid, "
				+ "  s1.wayid, "
				+ "  w.wayname, "
				+ "  w.starlevel, "
				+ "  '' as brand, "
				+ "   s1.comresid, "
				+ "  s1.acttime, "
				+ "  '' as stocktime, "
				+ "  s1.comcategory, "
				+ "   '' as createtime, "
				+ "   sysdate as STATISTICSTIME "
				+ " from (select t2.wayid, "
				+ "   t2.brand, "
				+ "  t2.comresid, "
				+ "   t2.comcategory, "
				+ "   t2.acttime "
				+ "  from FX_SW_PARTNERRES t2 "
				+ "  where t2.batchno is null "
				+ "  and t2.restype = 'COMRESSMP' "
				+ "   and t2.isactive = 1) s1, "
				+ " Ch_pw_way w "
				+ " where s1.wayid = w.wayid) ss "
				+ "  where ss.acttime between "
				+ "  to_date(:startstocktime, 'yyyy-MM-dd hh24:mi:ss') and "
				+ " to_date(:endstocktime, 'yyyy-MM-dd hh24:mi:ss')";

		SQLQuery sqlquery = session.createSQLQuery(sql);
		sqlquery.setString("startstocktime", startstocktime);
		sqlquery.setString("endstocktime", endstocktime);
		sqlquery.executeUpdate();
	}

	
	public void doDelActivedetail(String startstocktime, String endstocktime) {
		Session session = SessionUtils.currentSession(this.getDbFlag());
		String sql= " delete from FX_SW_ACTIVEDETAIL where acttime between to_date"+
		  "(:startstocktime, 'yyyy-MM-dd hh24:mi:ss') and to_date"+
		  "(:endstocktime, 'yyyy-MM-dd hh24:mi:ss')";
		SQLQuery sqlquery = session.createSQLQuery(sql);
		sqlquery.setString("startstocktime", startstocktime);
		sqlquery.setString("endstocktime", endstocktime);
		sqlquery.executeUpdate();
	}
}
