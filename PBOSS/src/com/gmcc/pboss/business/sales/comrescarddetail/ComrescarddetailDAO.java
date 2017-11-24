/**
 * auto-generated code
 * Wed Oct 17 11:55:44 CST 2012
 */
package com.gmcc.pboss.business.sales.comrescarddetail;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

/**
 * <p>
 * Title: ComrescarddetailDAO
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
public class ComrescarddetailDAO extends AbstractDAO {

	/**
	 * default constructor
	 */
	public ComrescarddetailDAO() {
		super(ComrescarddetailVO.class);
	}

	public void doUpdateComrescarddetail(String startstocktime,
			String endstocktime) {
		Session session = SessionUtils.currentSession(this.getDbFlag());
		String sql = "insert into FX_SW_COMRESCARDDETAIL (sid,countyid,svccode,mareacode,orderid,wayid,wayname,starlevel,comresid,stocktime,comcategory,waymagcode,upperwayid,acttime,brand,createtime,STATISTICSTIME)  select FX_SW_COMRESCARDDETAIL_SEQ.Nextval, ss.* "
				+ "from (select w.countyid, "
				+ " w.svccode, "
				+ " w.mareacode, "
				+ "  s1.orderid, "
				+ "  s1.wayid, "
				+ "  w.wayname, "
				+ "  w.starlevel, "
				+ "  s1.comresid, "
				+ " s1.createtime as stocktime, "
				+ "  s1.comcategory, "
				+ "  w.waymagcode, "
				+ "  w.upperwayid, "
				+ "  '' as acttime, "
				+ "  '' as brand, "
				+ "  s1.createtime, "
				+ " sysdate as STATISTICSTIME "
				+ "  from (select t2.wayid, "
				+ "   t3.orderid, "
				+ " t4.comresid, "
				+ " t2.createtime, "
				+ "    t2.comcategory "
				+ " from FX_SW_PARTNERRES  t2, "
				+ " fx_sw_order       t3, "
				+ "  fx_sw_orderresdet t4 "
				+ "  where t2.wayid = t3.wayid "
				+ "   and t3.orderid = t4.orderid "
				+ "   and t2.comresid = t4.comresid "
				+ "   and t2.restype = 'COMRESCARD' "
				+ "   and t3.orderstate = 'FINISHED') s1, "
				+ " Ch_pw_way w "
				+ " where s1.wayid = w.wayid "
				+ "   union "
				+ " select w.countyid, "
				+ "   w.svccode, "
				+ "    w.mareacode, "
				+ "    '' as orderid, "
				+ "    s1.wayid, "
				+ "    w.wayname, "
				+ "    w.starlevel, "
				+ "    s1.comresid, "
				+ "     s1.createtime as stocktime, "
				+ "    s1.comcategory, "
				+ "     w.waymagcode, "
				+ "     w.upperwayid, "
				+ "     '' as acttime, "
				+ "     '' as brand, "
				+ "     s1.createtime, "
				+ "     sysdate as STATISTICSTIME "
				+ " from (select t2.wayid, "
				+ "     t2.brand, "
				+ "    t2.comresid, "
				+ "    t2.comcategory, "
				+ "   t2.createtime "
				+ " from FX_SW_PARTNERRES t2 "
				+ "  where t2.batchno is null "
				+ "    and t2.restype = 'COMRESCARD') s1, "
				+ "   Ch_pw_way w "
				+ " where s1.wayid = w.wayid) ss "
				+ " where ss.stocktime between "
				+ "  to_date(:startstocktime, 'yyyy-MM-dd hh24:mi:ss') and "
				+ "  to_date(:endstocktime, 'yyyy-MM-dd hh24:mi:ss')";

		SQLQuery sqlquery = session.createSQLQuery(sql);
		sqlquery.setString("startstocktime", startstocktime);
		sqlquery.setString("endstocktime", endstocktime);
		sqlquery.executeUpdate();
	}
	
	public void doDelComrescarddetail(String startstocktime, String endstocktime) {
		Session session = SessionUtils.currentSession(this.getDbFlag());
		
		String sql= " delete from FX_SW_COMRESCARDDETAIL where stocktime between to_date"+
		  "(:startstocktime, 'yyyy-MM-dd hh24:mi:ss') and to_date"+
		  "(:endstocktime, 'yyyy-MM-dd hh24:mi:ss')";

		SQLQuery sqlquery = session.createSQLQuery(sql);
		sqlquery.setString("startstocktime", startstocktime);
		sqlquery.setString("endstocktime", endstocktime);
		sqlquery.executeUpdate();
	}
}
