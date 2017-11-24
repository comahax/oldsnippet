package com.gmcc.pboss.biz.info.reward.adjustment.dao.hibernate;

 
import java.util.List;

import org.hibernate.Query; 
import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.biz.info.reward.adjustment.dao.AdjustmentDao; 
import com.gmcc.pboss.biz.info.reward.adjustment.support.AdjustmentQueryParameter; 
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.model.reward.adjustment.Adjustment; 

public class AdjustmentDaoHibernate extends BaseHqlQueryDao implements AdjustmentDao  {
	
	public AdjustmentDaoHibernate() {
		super(Adjustment.class);
	} 
 
	public Way getWayInfo(String wayid, String magcode){
		String hql = "from com.gmcc.pboss.biz.info.node.model.Way w where w.waymagcode=:waymagcode and w.wayid=:wayid";
		Query query = this.getSession().createQuery(hql);
		query.setString("wayid", wayid);
		query.setString("waymagcode", magcode);	  
		return (Way)query.uniqueResult();
	}
	
//	public List getBusistat(AdjustmentQueryParameter param){
//		String month = param.getRewardmonth();
//		String wayid = param.getWayid();
//		String paymonth = param.getPaymonth(); 
//		StringBuilder sb = new StringBuilder();
//		sb.append("select t.wayid,a.wayname,a.starlevel,t.rewardmonth,p.paymonth, sum(nvl(t.paysum,0)) paysum,sum(nvl(t.rpmoney,0)) rpmoney,");
//		sb.append(" sum(nvl(t.fees,0)) fees,sum(nvl(t.taxmoney,0)) taxmoney,");
//		sb.append(" (sum(nvl(t.paysum,0))+sum(nvl(t.rpmoney,0))-sum(nvl(t.fees,0))-sum(nvl(t.taxmoney,0))) realpay");
//		sb.append(" from ch_adt_adjustment t,ch_adt_paymentbatch p,ch_pw_way a");
//		sb.append("  where t.batchno is not null and t.batchno=p.batchno  and t.wayid = a.wayid and p.endflag=1");
//		if(wayid!=null && !"".equals(wayid.trim())){//渠道编码
//			sb.append("		and t.wayid=:wayid ");
//		}
//		if (month!=null && !"".equals(month.trim())){
//		    sb.append("   and t.rewardmonth=:rewardmonth ");
//	     }
//		if(paymonth!=null && !"".equals(paymonth.trim())){//付款月份
//			sb.append("		and p.paymonth=:paymonth");
//		}
//		sb.append(" group by t.rewardmonth,a.wayname,a.starlevel,t.wayid,p.paymonth order by t.rewardmonth desc,p.paymonth desc,t.wayid");	
//		Query sqlQuery = this.getSession().createSQLQuery(sb.toString());
//		if(wayid!=null && !"".equals(wayid.trim())){
//		    sqlQuery.setString("wayid", wayid);	
//		}
//		if(month!=null && !"".equals(month.trim())){
//			sqlQuery.setString("rewardmonth", month.trim());		
//		}
//		if(paymonth!=null && !"".equals(paymonth.trim())){
//			sqlQuery.setString("paymonth", paymonth.trim());
//		}  
//		return sqlQuery.list();
//	}
}
