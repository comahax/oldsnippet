package com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class RewardTdRecordQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		RewardTdRecordQueryParameter param = (RewardTdRecordQueryParameter)parameter;
		StringBuilder sb = new StringBuilder();
		String rewardmonth = param.getRewardmonth();
		String wayid = param.getWayid(); 
		String rewardtype  = param.getRewardtype();
		sb.append(" select op.NAME name,"); 
		sb.append(" (case when (substr(rec.opnid, 1, 8) in ('04050401', '04050402') or   substr(rec.opnid, 1, 4) = '0408') then  'heyue'");
	    sb.append("   when (rec.opnid like '04050405%' or rec.opnid like '04050406%' or   rec.opnid like '0407%' or  rec.opnid like '0411%') then  'luoji' end)  rewardtype,");
	    sb.append("    to_char(oprtime, 'yyyymm') oprtime, rec.rewardmonth rewardmonth, sum(rec.paysum) paysum from CH_ZD_REWARDRECORD rec, CH_PW_OPERATION op ");
	    sb.append("   where rec.opnid = op.opnid(+) ");
	    if(rewardtype!=null && !"".equals(rewardtype.trim())){//酬金类型    
	    	
		   if(rewardtype.equals("1")){// 合约终端酬金  
		      sb.append("  and (rec.opnid   like '04050401%' or rec.opnid like '04050402%' or rec.opnid like '0408%') "); 
		   }else if(rewardtype.equals("2")){//裸机终端酬金
		      sb.append(" and (rec.opnid like '04050405%' or rec.opnid like '04050406%' or  rec.opnid like '0407%' or  rec.opnid like '0411%')");
		   } 
	    } else {
	    	sb.append(" and (rec.opnid like '040504%' or rec.opnid like '0407%' or  rec.opnid like '0408%' or  rec.opnid like '0411%')");
	    }
	    if(rewardmonth!=null && !"".equals(rewardmonth.trim())){//结算月份
		sb.append("	 and rec.rewardmonth = :rewardmonth");
		} 
	    if(wayid!=null && !"".equals(wayid.trim())){//渠道编码
		sb.append("	  and rec.wayid = :wayid");
		}
	    sb.append("  group by op.NAME,(case when (substr(rec.opnid, 1, 8) in ('04050401', '04050402') or  substr(rec.opnid, 1, 4) = '0408') then  'heyue' ");
	    sb.append("  when (rec.opnid like '04050405%' or rec.opnid like '04050406%' or  rec.opnid like '0407%' or  rec.opnid like '0411%') then  'luoji' end), ");
	    sb.append("  to_char(oprtime, 'yyyymm'), rec.rewardmonth"); 
		
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
		RewardTdRecordQueryParameter param = (RewardTdRecordQueryParameter)parameter;
		
		if(StringUtils.isNotEmpty(param.getWayid())){
			query.setString("wayid", param.getWayid());
		}
		if(StringUtils.isNotEmpty(param.getRewardmonth())){
			query.setString("rewardmonth", param.getRewardmonth());
		}
		
//		if(StringUtils.isNotEmpty(param.getRewardtype())){
//			query.setString("rewardtype", param.getRewardtype());
//		}
	}

}
