/**
 * auto-generated code
 * Tue Oct 19 15:41:02 CST 2010
 */
package com.gmcc.pboss.business.sales.waystockrecord;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

/**
 * <p>Title: WaystockrecordDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class WaystockrecordDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public WaystockrecordDAO(){
        super(WaystockrecordVO.class);
    } 
    
    /**
	 * 清理超过半个月网点库存快照的数据
	 * @param restype
	 * @throws Exception
	 */
	public void doDelComrescarddetail() {
		Session session = SessionUtils.currentSession(this.getDbFlag());
		String sql= " delete from FX_SW_WAYSTOCKRECORD where STOCKTIME <= (sysdate -15)";
		SQLQuery sqlquery = session.createSQLQuery(sql);
		sqlquery.executeUpdate();
	}
	
	/**
	 * 重跑的时候先把当天的数据清理
	 * @param startstocktime
	 * @param endstocktime
	 */
	public void doDelWaystockrecord(String startstocktime, String endstocktime) {
		Session session = SessionUtils.currentSession(this.getDbFlag());
		String sql= " delete from FX_SW_WAYSTOCKRECORD where STOCKTIME between to_date"+
		  "(:startstocktime, 'yyyy-MM-dd hh24:mi:ss') and to_date"+
		  "(:endstocktime, 'yyyy-MM-dd hh24:mi:ss')";
		SQLQuery sqlquery = session.createSQLQuery(sql);
		sqlquery.setString("startstocktime", startstocktime);
		sqlquery.setString("endstocktime", endstocktime);
		sqlquery.executeUpdate();
	}
	
	public Long getComcategoryCount() throws Exception{
		Session session = SessionUtils.currentSession(getDbFlag());
		Query query = session.getNamedQuery("com.gmcc.pboss.business.resource.comcategoryrela.comcategorycount");
//		query.setString("basewayid", wayid);
		List list=query.list();
		Long result = 0l;
		if(list.size()>0){
			Long number=(Long)list.get(0);
			if(number.intValue()>0){
				result=number;
			}
		}
		return result;
	}
}
