package com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class RewardTdSucQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		StringBuilder sb = new StringBuilder();
		RewardTdSucQueryParameter param = (RewardTdSucQueryParameter)parameter;
		String month = param.getRewardmonth();
		String wayid = param.getWayid(); 
		String repairmonth = param.getRepairmonth();
		String rewardtype  = param.getRewardtype(); 
		sb.append("   select op.NAME name, ");
	    sb.append(" ( case when (substr(rec.opnid, 1, 8) in ('04050401', '04050402') or substr(rec.opnid, 1, 4) = '0408') then  'h' ");
		sb.append("  when (rec.opnid like '04050405%' or rec.opnid like '04050406%' or  rec.opnid like '0407%' or  rec.opnid like '0411%') then  'l' end) rewardtype, ");
        sb.append("  rec.bakinfo2 comname, rec.bakinfo bakinfo, rec.mobile mobile,rec.oprtime oprtime, rec.rewardmonth rewardmonth, ");
		sb.append("  decode(rec.acctype, 1, '按笔数计算', 2, '按比例计算', 3,'其他') acctype, rec.rewardstd rewardstd, rec.paysum paysum,");
		sb.append("  rec.assegrade assegrade,nvl(wrapfee, 0) wrapfee, rec.assegrade2 assegrade2, rec.repairmonth repairmonth,");
		sb.append("  rec.noncyc noncyc, rec.bakinfo7 bakinfo7, rec.bakinfo8 bakinfo8, '成功' failreason  from CH_ZD_REWARDRECORD rec,");
		sb.append("  CH_PW_OPERATION op where rec.opnid = op.opnid(+) "); 
		
		if (rewardtype != null && !"".equals(rewardtype.trim())) {// 酬金类型

			if (rewardtype.equals("1")) {// 合约终端酬金
				sb.append("  and (rec.opnid   like '04050401%' or rec.opnid like '04050402%' or rec.opnid like '0408%') ");
			}else if (rewardtype.equals("2")) {// 裸机终端酬金
				sb.append(" and  ( rec.opnid like '04050405%' or rec.opnid like '04050406%' or  rec.opnid like '0407%' or  rec.opnid like '0411%') ");
			}  
		}else{
			sb.append("  and (rec.opnid like '040504%' or rec.opnid like '0407%' or rec.opnid like '0408%' or  rec.opnid like '0411%')");
		}
		if (StringUtils.isNotEmpty(month)) {// 结算月份
			sb.append("	 and rec.rewardmonth = :rewardmonth");
		}
		if (wayid != null) {// 渠道编码
			sb.append("	  and rec.wayid = :wayid");
		}  
		if (StringUtils.isNotEmpty(repairmonth)) {// 渠道编码
			sb.append("	  and rec.repairmonth = :repairmonth");
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
		RewardTdSucQueryParameter param = (RewardTdSucQueryParameter)parameter;
		
		if(StringUtils.isNotEmpty(param.getWayid())){
			query.setString("wayid", param.getWayid());
		}
	
		if (StringUtils.isNotEmpty(param.getRewardmonth())) {
			query.setString("rewardmonth", param.getRewardmonth());
		}
		
		if (StringUtils.isNotEmpty(param.getRepairmonth())) {
			query.setString("repairmonth", param.getRepairmonth());
		}
//		if(StringUtils.isNotEmpty(param.getRewardtype())){
//			query.setString("rewardtype", param.getRewardtype());
//		}
	}

}
