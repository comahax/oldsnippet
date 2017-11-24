package com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.dao.hibernate;

import java.util.List;
import org.hibernate.Query;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.dao.RewardTdSucDao;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.support.RewardTdSucInfo;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.support.RewardTdSucQueryParameter;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;

public class RewardTdSucDaoHibernate extends BaseHqlQueryDao implements RewardTdSucDao{
 
	
	public RewardTdSucDaoHibernate() {
		super(RewardTdSucInfo.class);
	}  
	

		public String getComnameSuc (String bakinfo2){
			String comname="";
			StringBuilder sb = new StringBuilder();
			sb.append("   select comname  from common.IM_PR_COM "); 
			if (bakinfo2 != null && !"".equals(bakinfo2.trim())) {// Ω·À„‘¬∑›
				sb.append("	where COMID = "+ bakinfo2);
			}
			Query sqlQuery = this.getSession().createSQLQuery(sb.toString());
			Object obj = sqlQuery.uniqueResult();
			if(obj!=null){
				comname=sqlQuery.uniqueResult().toString();
			}
			return comname;
		}
}

