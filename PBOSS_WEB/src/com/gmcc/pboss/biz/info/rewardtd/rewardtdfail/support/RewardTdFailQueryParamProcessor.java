package com.gmcc.pboss.biz.info.rewardtd.rewardtdfail.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class RewardTdFailQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		
		RewardTdFailQueryParameter param = (RewardTdFailQueryParameter)parameter;
		
		StringBuilder sb = new StringBuilder();
		String rewardmonth = param.getRewardmonth();
		String wayid = param.getWayid(); 
		String rewardtype  = param.getRewardtype(); 
		sb.append(" select op.NAME name,"); 
		sb.append("  (case when (substr(fial.opnid, 1, 8) in ('04050401', '04050402') or substr(fial.opnid, 1, 4) = '0408') then  'h'");
	    sb.append("    when (fial.opnid like '04050405%' or fial.opnid like '04050406%' or fial.opnid like '0407%' or  fial.opnid like '0411%') then  'l' end) rewardtype,");
	    sb.append("   fial.BAKINFO2 comname,fial.bakinfo bakinfo,fial.mobile mobile, fial.oprtime oprtime, fial.calcmonth calcmonth,");
	    sb.append("   '' acctype,  '' rewardstd,  '' paysum,'' assegrade,nvl(wrapfee, 0) wrapfee, '' assegrade2,  fial.noncyc noncyc,");
	    sb.append("   fial.bakinfo7 bakinfo7,  fial.bakinfo8 bakinfo8, '失败' || fial.adtremark  failreason");
	    sb.append("   from CH_ZD_FAIL fial, CH_PW_OPERATION op where fial.opnid = op.opnid(+)  ");
	    if(rewardtype!=null && !"".equals(rewardtype.trim())){//酬金类型    
	    	
		   if(rewardtype.equals("1")){// 合约终端酬金  
			    sb.append("  and (fial.opnid   like '04050401%' or fial.opnid like '04050402%' or fial.opnid like '0408%') "); 
		   }else if(rewardtype.equals("2")){//裸机终端酬金
			    sb.append(" and (fial.opnid like '04050405%' or fial.opnid like '04050406%' or  fial.opnid like '0407%' or  fial.opnid like '0411%')");
		   }else {
		    	sb.append(" and (fial.opnid like '040504%' or fial.opnid like '0407%' or  fial.opnid like '0408%' or  fial.opnid like '0411%')");
		}
	    }
	    if(rewardmonth!=null && !"".equals(rewardmonth.trim())){//结算月份
		sb.append("	 and fial.calcmonth = :rewardmonth");
		} 
	    if(wayid!=null && !"".equals(wayid.trim())){//渠道编码
		sb.append("	  and fial.wayid = :wayid");
		}  
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
		RewardTdFailQueryParameter param = (RewardTdFailQueryParameter)parameter;
		
		if(StringUtils.isNotEmpty(param.getWayid())){
			query.setString("wayid", param.getWayid());
		}
		if (StringUtils.isNotEmpty(param.getRewardmonth())) {
			query.setString("rewardmonth", param.getRewardmonth());
		}
		
//		if(StringUtils.isNotEmpty(param.getRewardtype())){
//			query.setString("rewardtype", param.getRewardtype());
//		}
	}


}
