package com.gmcc.pboss.biz.info.reward.cityrecord.support;

import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class CityrecordQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		CityrecordQueryParameter param = (CityrecordQueryParameter)parameter;
		StringBuilder sb = new StringBuilder();
		sb.append("select r.wayid,w.wayname,r.opnid,o.name,r.rewardtype,to_char(r.rewardtype) dictname,r.mobile,r.rewardmonth,");
		sb.append("		to_char(r.oprtime,'yyyy-MM-dd hh24:mi:ss') oprtime,r.busivalue,r.paymoney");
		sb.append("	from ch_adt_cityrecord r, ch_pw_way w,");
		sb.append("		(select o.opnid,o.name from ch_pw_operation o");
		sb.append("			where o.opnlevel=5");//o.isbusi=1
		sb.append("			start with o.opnid=:opnid connect by prior o.opnid=o.parentid) o");
		sb.append("	where r.opnid=o.opnid and r.wayid=w.wayid and r.isflag=6 ");//and r.rewardtype=d.dictid(+)
		sb.append("		 and to_char(r.oprtime,'yyyyMM')=:oprmonth");
		sb.append("		 and r.wayid=:wayid and r.rewardtype=:rewardtype ");
		if(param.getMonth()!=null && !"".equals(param.getMonth())){
			sb.append(" and r.rewardmonth=:rewardmonth ");
		}
		if(param.isSupportPaymonth() && param.getPaymonth()!=null && !"".equals(param.getPaymonth())){
			sb.append(" and r.paymonth=:paymonth");
		}
		sb.append(" order by r.oprtime");
		return sb.toString();
	}

	@Override
	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		// TODO Auto-generated method stub
		CityrecordQueryParameter param = (CityrecordQueryParameter)parameter;
		if(param.getWayid()!=null && !"".equals(param.getWayid())){
			query.setString("wayid", param.getWayid());
		}
		if(param.getOpnid2()!=null && !"".equals(param.getOpnid2())){
			query.setString("opnid", param.getOpnid2());
		}
		if(param.getRewardtype()!=null && !"".equals(param.getRewardtype())){
			query.setLong("rewardtype", Long.parseLong(param.getRewardtype()));
		}
		if(param.getMonth()!=null && !"".equals(param.getMonth())){
			query.setString("rewardmonth", param.getMonth());
		}
		if(param.getOprmonth()!=null && !"".equals(param.getOprmonth())){
			query.setString("oprmonth", param.getOprmonth());
		}
		if(param.getMonth()!=null && !"".equals(param.getMonth())){
			query.setString("rewardmonth", param.getMonth());
		}
		if(param.isSupportPaymonth() && param.getPaymonth()!=null && !"".equals(param.getPaymonth())){
			query.setString("paymonth", param.getPaymonth());
		}
	}

}
