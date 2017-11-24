package com.gmcc.pboss.biz.info.reward.cityrecord.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import com.gmcc.pboss.biz.info.reward.cityrecord.dao.CityrecordDao;
import com.gmcc.pboss.biz.info.reward.cityrecord.support.CityrecordQueryParameter;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.model.reward.cityrecord.ChAdtCityRecord;
import com.gmcc.pboss.biz.info.node.model.Way;

public class CityrecordDaoHibernate extends BaseHqlQueryDao implements
		CityrecordDao {
	public CityrecordDaoHibernate(){
		super(ChAdtCityRecord.class);
	}
	
	/*
	 * 获取所有2级编码及其父级（1级）编码和名称
	 */
	public List getOpnlevel2(){
		Query sqlQuery = this.getSession().getNamedQuery("com.gmcc.pboss.model.reward.cityrecord.getOpnlevel2");
		return sqlQuery.list();
	}
	
	public Way getWayInfo(String wayid, String magcode){
		String hql = "from com.gmcc.pboss.biz.info.node.model.Way w where w.waymagcode=:waymagcode and w.wayid=:wayid";
		Query query = this.getSession().createQuery(hql);
		query.setString("wayid", wayid);
		query.setString("waymagcode", magcode);	
		
		//Criteria critetia = this.getSession().createCriteria(Way.class);
		
		return (Way)query.uniqueResult();
	}
	
	public List getBusistat(String opnid,String wayid,String month){
		StringBuilder sb = new StringBuilder();
		sb.append("select to_char(r.rewardtype) rewardtype,to_char(r.rewardtype) dictname,");//r.rewardmonth,
//		sb.append("       case when r.rewardtype=1 then to_char('一期')");
//		sb.append("         when r.rewardtype=2 then to_char('二期')");
//		sb.append("         else to_char('三期') end dictname,");//d.dictname,
		sb.append("       to_char(r.oprtime,'yyyyMM') oprmonth,");
		sb.append("       sum(r.busivalue) busitotal,sum(r.paymoney) paytotal");
		sb.append("   from ch_adt_cityrecord r,");
		sb.append("      (select o.opnid from ch_pw_operation o");
		sb.append("			where o.opnlevel=5");//o.isbusi=1
		sb.append("			start with o.opnid=:opnid");
		sb.append("			connect by prior o.opnid=o.parentid) o");
		sb.append("   where r.isflag=0 and r.opnid=o.opnid");
		sb.append("   and r.wayid=:wayid");			
		if(month!=null && !"".equals(month.trim())){
			sb.append("   and r.rewardmonth=:rewardmonth");	
		}
		sb.append("   group by r.rewardtype,to_char(r.oprtime,'yyyyMM')");//,r.rewardmonth
		sb.append("   order by r.rewardtype,oprmonth desc");//,r.rewardmonth desc
		Query sqlQuery = this.getSession().createSQLQuery(sb.toString());
		sqlQuery.setString("opnid", opnid);	
		sqlQuery.setString("wayid", wayid);			
		if(month!=null && !"".equals(month.trim())){
			sqlQuery.setString("rewardmonth", month);		
		}
		return sqlQuery.list();
	}
	
	//20130704删除此方案，用下面的getBusistat(CityrecordQueryParameter param)替代
//	public List getBusistat(String wayid,String month){
//		StringBuilder sb = new StringBuilder();
//		sb.append("select r.upperopnid,r.subopnid,to_char(r.rewardtype) rewardtype,to_char(r.rewardtype) dictname,");
//		sb.append("       to_char(r.oprtime,'yyyyMM') oprmonth,");
//		sb.append("       sum(r.busivalue) busitotal,sum(r.paymoney) paytotal");
//		sb.append(" from ch_adt_cityrecord r");
//		sb.append(" where r.isflag=0");
//		sb.append("   	and r.wayid=:wayid");
//		if(month!=null && !"".equals(month.trim())){
//			sb.append("   	and r.rewardmonth=:rewardmonth");
//		}
//		sb.append(" group by r.upperopnid,r.subopnid,r.rewardtype,to_char(r.oprtime,'yyyyMM')");
//		sb.append(" order by r.upperopnid,r.subopnid,r.rewardtype,oprmonth desc");
//		Query sqlQuery = this.getSession().createSQLQuery(sb.toString());
//		sqlQuery.setString("wayid", wayid);			
//		if(month!=null && !"".equals(month.trim())){
//			sqlQuery.setString("rewardmonth", month);		
//		}
//		return sqlQuery.list();
//	}
	public List getBusistat(CityrecordQueryParameter param){
		String month = param.getMonth();
		String wayid = param.getWayid();
		String paymonth = param.getPaymonth();
		String oprmonth = param.getOprmonth();
		StringBuilder sb = new StringBuilder();
		sb.append("select r.upperopnid,r.subopnid,to_char(r.rewardtype) rewardtype,to_char(r.rewardtype) dictname,");
		sb.append("       to_char(r.oprtime,'yyyyMM') oprmonth,");
		sb.append("       sum(r.busivalue) busitotal,sum(r.paymoney) paytotal");
		sb.append(" from ch_adt_cityrecord r");
		sb.append(" where r.isflag=6 ");
		sb.append("   	and r.wayid=:wayid");
		if(month!=null && !"".equals(month.trim())){//结算月份
			sb.append("   	and r.rewardmonth=:rewardmonth");
		}
		if(paymonth!=null && !"".equals(paymonth.trim())){//付款月份
			sb.append("		and r.paymonth=:paymonth");
		}
		if(oprmonth!=null && !"".equals(oprmonth.trim())){//付款月份
			sb.append("		and to_char(r.oprtime,'yyyyMM')=:oprmonth");
		}
		sb.append(" group by r.upperopnid,r.subopnid,r.rewardtype,to_char(r.oprtime,'yyyyMM')");
		sb.append(" order by r.upperopnid,r.subopnid,r.rewardtype,oprmonth desc");
		Query sqlQuery = this.getSession().createSQLQuery(sb.toString());
		sqlQuery.setString("wayid", wayid);			
		if(month!=null && !"".equals(month.trim())){
			sqlQuery.setString("rewardmonth", month.trim());		
		}
		if(paymonth!=null && !"".equals(paymonth.trim())){
			sqlQuery.setString("paymonth", paymonth.trim());
		}
		if(oprmonth!=null && !"".equals(oprmonth.trim())){
			sqlQuery.setString("oprmonth", oprmonth.trim());
		}
		return sqlQuery.list();
	}

}
