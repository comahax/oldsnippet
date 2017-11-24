package com.gmcc.pboss.biz.info.rewardtd.rewardadsuc.dao.hibernate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.dao.DataAccessResourceFailureException;

import com.gmcc.pboss.biz.info.rewardtd.rewardadsuc.dao.RewardAdSucDao;
import com.gmcc.pboss.biz.info.rewardtd.rewardadsuc.support.RewardAdSucInfo;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;

public class RewardAdSucDaoHibernate extends BaseHqlQueryDao implements RewardAdSucDao{
 
	
	public RewardAdSucDaoHibernate() {
		super(RewardAdSucInfo.class);
	}  
	

		public String getComnameSuc (String bakinfo2){
			String comname="";
			try {
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
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return comname;
		}
		
		public Map<String,String> getDictitemRestype(){
			//Query query = this.getSession().getNamedQuery("com.gmcc.pboss.biz.basic.dictItem.model.getFundtype");
			StringBuilder sb = new StringBuilder();
			sb.append("   select DICTID,DICTNAME from sa_db_dictitem "); 
			sb.append("	where groupid='CH_REWARDTYPE' ");
			sb.append("	and ((to_number(DICTID) >=11  and  to_number(DICTID) <=19) or  to_number(DICTID)>=101) order by  to_number(DICTID) ");
			Query sqlQuery = this.getSession().createSQLQuery(sb.toString());
			
			List<Object[]> list = (List<Object[]>)sqlQuery.list();
			Map<String,String> dictitemRestype = new HashMap<String,String>();
			if(list!=null && list.size()>0){
				for(Iterator<Object[]> it=list.iterator();it.hasNext();){
					Object[] obj = it.next();
					dictitemRestype.put((String)obj[0], (String)obj[1]);
				}
			}		
			return dictitemRestype;
		}
}

