package com.gmcc.pboss.biz.info.rewardtd.rewardadsuc.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class RewardAdSucQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		StringBuilder sb = new StringBuilder();
		RewardAdSucQueryParameter param = (RewardAdSucQueryParameter)parameter;
		String rewardmonth = param.getRewardmonth();
		String wayid = param.getWayid(); 
		String repairmonth = param.getRepairmonth();
		String rewardtype  = param.getRewardtype(); 
		sb.append("   select op.NAME name, t.dictname rewardtype, rec.bakinfo2 comname,rec.bakinfo bakinfo,rec.mobile mobile,rec.oprtime oprtime, ");
	    sb.append(" rec.rewardmonth rewardmonth,decode(rec.acctype, 1, '按笔数计算', 2, '按比例计算', 3, '其他') acctype, ");
		sb.append("  rec.rewardstd rewardstd,rec.paysum paysum,rec.assegrade assegrade,nvl(wrapfee, 0) wrapfee, ");
        sb.append("   rec.assegrade2 assegrade2,rec.noncyc noncyc,rec.bakinfo7 bakinfo7,rec.bakinfo8 bakinfo8,'成功' failreason ");
		sb.append("   from CH_ZD_REWARDRECORD rec, CH_PW_OPERATION op, sa_db_dictitem t ");
		sb.append("   where  to_char(rec.rewardtype) = t.dictid and rec.opnid = op.opnid(+) and rec.opnid='0701010100021' and t.groupid='CH_REWARDTYPE' ");
		
		if (StringUtils.isNotEmpty(rewardtype)) {// 酬金类型
		sb.append("  and rec.rewardtype = :rewardtype ");
		}
		if (StringUtils.isNotEmpty(rewardmonth)) {// 结算月份
			sb.append("	 and rec.rewardmonth = :rewardmonth ");
		}
		if (wayid != null) {// 渠道编码
			sb.append("	  and rec.wayid = :wayid");
		}  
		if (StringUtils.isNotEmpty(repairmonth)) {
			if (repairmonth.equals("1")) {//上半月预发酬金
			sb.append("	  and   substr(rec.batchno,7,2) = '16' ");
			}else if(repairmonth.equals("2")){ //下半月预发酬金
				sb.append("	  and substr(rec.batchno,7,2) = '30' ");
			}
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
		RewardAdSucQueryParameter param = (RewardAdSucQueryParameter)parameter;
		
		if(StringUtils.isNotEmpty(param.getWayid())){
			query.setString("wayid", param.getWayid());
		}
	
		if (StringUtils.isNotEmpty(param.getRewardmonth())) {
			query.setString("rewardmonth", param.getRewardmonth());
		}
		
//		if (StringUtils.isNotEmpty(param.getRepairmonth())) {
//			query.setString("repairmonth", param.getRepairmonth());
//		}
		if(StringUtils.isNotEmpty(param.getRewardtype())){
			query.setString("rewardtype", param.getRewardtype());
		}
	}

}
