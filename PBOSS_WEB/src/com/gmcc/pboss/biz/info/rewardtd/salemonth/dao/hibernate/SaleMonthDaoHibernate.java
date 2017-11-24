package com.gmcc.pboss.biz.info.rewardtd.salemonth.dao.hibernate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.gmcc.pboss.biz.info.rewardtd.salemonth.dao.SaleMonthDao;
import com.gmcc.pboss.biz.info.rewardtd.salemonth.support.SaleMonth;
import com.gmcc.pboss.biz.info.rewardtd.salemonth.support.SaleMonthQueryParameter;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;

public class SaleMonthDaoHibernate extends BaseHqlQueryDao  implements SaleMonthDao{
	
	public SaleMonthDaoHibernate() {
		super(SaleMonth.class);
	}   
	
	public String getMaxcount(SaleMonthQueryParameter parameter){
		String maxcount="";
		try {
		StringBuilder sb = new StringBuilder();
		sb.append("   select max(months_between(to_date(RWMON,'yyyymm'),to_date(OPRMON,'yyyymm')))+1 maxcount from CH_RP_WAYREWARDDETAIL "); 
		sb.append("	where 1=1 ");
		sb.append("	and WAYID= '"+parameter.getWayid()+"'");
		sb.append(" and  oprmon =  '"+parameter.getOprmon()+"'");
		
		Query sqlQuery = this.getSession().createSQLQuery(sb.toString());
		
		Object obj = sqlQuery.uniqueResult();
		if(obj!=null){
			maxcount=sqlQuery.uniqueResult().toString();
		}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxcount;
	}

}
