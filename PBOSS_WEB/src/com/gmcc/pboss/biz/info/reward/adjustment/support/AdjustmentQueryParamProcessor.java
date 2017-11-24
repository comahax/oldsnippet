package com.gmcc.pboss.biz.info.reward.adjustment.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.support.RewardTdSucQueryParameter;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class AdjustmentQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		StringBuilder sb = new StringBuilder();
		AdjustmentQueryParameter param = (AdjustmentQueryParameter)parameter;
		String month = param.getRewardmonth();
		String wayid = param.getWayid(); 
		String paymonth = param.getPaymonth();

		sb.append("select t.wayid,a.wayname,a.starlevel,t.rewardmonth,p.paymonth, sum(nvl(t.paysum,0)) paysum,sum(nvl(t.rpmoney,0)) rpmoney,");
		sb.append(" sum(nvl(t.fees,0)) fees,sum(nvl(t.taxmoney,0)) taxmoney,");
		sb.append(" (sum(nvl(t.paysum,0))+sum(nvl(t.rpmoney,0))-sum(nvl(t.fees,0))-sum(nvl(t.taxmoney,0))) realpay");
		sb.append(" from ch_adt_adjustment t,ch_adt_paymentbatch p,ch_pw_way a");
		sb.append("  where t.batchno is not null and t.batchno=p.batchno  and t.wayid = a.wayid and p.endflag=1");
		
		if(StringUtils.isNotEmpty(wayid)){//渠道编码
			sb.append("		and t.wayid=:wayid ");
		}
		if (StringUtils.isNotEmpty(month)){
		    sb.append("   and t.rewardmonth=:rewardmonth ");
	     }
		if(StringUtils.isNotEmpty(paymonth)){//付款月份
			sb.append("		and p.paymonth=:paymonth");
		}
		
		sb.append(" group by t.rewardmonth,a.wayname,a.starlevel,t.wayid,p.paymonth order by t.rewardmonth desc,p.paymonth desc,t.wayid");	
		
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
		AdjustmentQueryParameter param = (AdjustmentQueryParameter)parameter;
		
		if(StringUtils.isNotEmpty(param.getWayid())){
			query.setString("wayid", param.getWayid());
		}
	
		if (StringUtils.isNotEmpty(param.getRewardmonth())) {
			query.setString("rewardmonth", param.getRewardmonth());
		}
		
		if (StringUtils.isNotEmpty(param.getPaymonth())) {
			query.setString("paymonth", param.getPaymonth());
		}
	
	}

}
