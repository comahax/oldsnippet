/**
 * auto-generated code
 * Wed Oct 17 11:50:59 CST 2012
 */
package com.gmcc.pboss.business.sales.comressdetail;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

/**
 * <p>Title: ComressdetailDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Li Min
 * @version 1.0
 */
public class ComressdetailDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public ComressdetailDAO(){
        super(ComressdetailVO.class);
    }
    
	
	
	public void doUpdateComressdetail(String startstocktime,String endstocktime){
		Session session = SessionUtils.currentSession(this.getDbFlag());
		String sql= "insert into FX_SW_COMRESSDETAIL(sid,Countyid,SVCCODE,MAREACODE,Upperwayid,Waymagcode,Orderid,Wayid,Wayname,Starlevel,Brand,Comresid,Stocktime,Comcategory,Acttime,Iccid,Createtime,Statisticstime) select FX_SW_COMRESSDETAIL_SEQ.Nextval, ss.* from "+
				  "(select w.countyid,"+
				          "w.svccode,"+
				          "w.mareacode,"+
				          "w.upperwayid,"+
				          "w.waymagcode,"+
				          "s1.orderid,"+
				          "s1.wayid,"+
				          "w.wayname,"+
				          "w.starlevel,"+
				          "s1.brand,"+
				          "s1.comresid,"+
				          "s1.createtime as stocktime,"+
				          "s1.comcategory,"+
				          "'' as acttime,"+
				          "c.iccid as iccid,"+
				          "s1.createtime,"+
				          "sysdate as STATISTICSTIME "+
				     "from (select t2.wayid,"+
				                  "t2.brand,"+
				                  "t3.orderid,"+
				                  "t4.comresid,"+
				                  "t2.createtime,"+
				                  "t2.comcategory,"+
				                  "t2.comid "+
				             "from FX_SW_PARTNERRES t2, fx_sw_order t3, fx_sw_orderresdet t4 "+
				            "where t2.wayid = t3.wayid "+
				              " and t3.orderid = t4.orderid "+
				              " and t2.comresid = t4.comresid "+
				              " and t2.batchno = t4.batchno "+
				              " and t2.restype = 'COMRESSMP' "+
				              " and t3.orderstate = 'FINISHED') s1,"+
				          "Ch_pw_way w,"+
				          "IM_FX_COMRESSMP c "+
				    "where s1.wayid = w.wayid "+
				      " and s1.comresid = c.comresid "+
				      " and s1.comid = c.comid union select w.countyid, w.svccode,"+
				    "w.mareacode, w.upperwayid, w.waymagcode, '' as orderid, s1.wayid,"+
				    "w.wayname, w.starlevel, '' as brand, s1.comresid, s1.createtime as stocktime,"+
				    "s1.comcategory, '' as acttime, c.iccid as iccid,"+
				    "s1.createtime, sysdate as STATISTICSTIME from  "+
				    "(select t2.wayid,"+
				                  "t2.brand,"+
				                  "t2.comresid,"+
				                  "t2.comcategory,"+
				                  "t2.createtime,"+
				                  "t2.comid "+
				             " from FX_SW_PARTNERRES t2 "+
				            " where t2.batchno is null "+
				              " and t2.restype = 'COMRESSMP') s1, Ch_pw_way w,"+
				    "IM_FX_COMRESSMP c "+
				    " where s1.wayid = w.wayid "+
				      " and s1.comresid = c.comresid "+
				      " and s1.comid = c.comid) ss where ss.stocktime between to_date"+
				  "(:startstocktime, 'yyyy-MM-dd hh24:mi:ss') and to_date"+
				  "(:endstocktime, 'yyyy-MM-dd hh24:mi:ss')";
						
				SQLQuery sqlquery = session.createSQLQuery(sql);
				sqlquery.setString("startstocktime", startstocktime);
				sqlquery.setString("endstocktime", endstocktime);
				sqlquery.executeUpdate();
	}
	
	/**
	 * 同步之前先删除套卡数据收集同一天的数据，防止数据重复
	 * @param starttime
	 * @param endtime
	 * @throws Exception
	 */
	public void doDelComressdetail(String startstocktime,String endstocktime){
		Session session = SessionUtils.currentSession(this.getDbFlag());
		
		//delete from FX_SW_COMRESSDETAIL where where
		String sql= " delete from FX_SW_COMRESSDETAIL where stocktime between to_date"+
				  "(:startstocktime, 'yyyy-MM-dd hh24:mi:ss') and to_date"+
				  "(:endstocktime, 'yyyy-MM-dd hh24:mi:ss')";
						
				SQLQuery sqlquery = session.createSQLQuery(sql);
				sqlquery.setString("startstocktime", startstocktime);
				sqlquery.setString("endstocktime", endstocktime);
				sqlquery.executeUpdate();
	}
}
