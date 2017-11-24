package com.gmcc.pboss.biz.info.rewardtd.rewardadfail.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class RewardAdFailQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		
		RewardAdFailQueryParameter param = (RewardAdFailQueryParameter)parameter;
		StringBuilder sb = new StringBuilder();
		String rewardmonth = param.getRewardmonth();
		String wayid = param.getWayid(); 
		String repairmonth = param.getRepairmonth();
		sb.append(" select op.NAME name,"); 
		sb.append(" '' rewardtype,fial.BAKINFO2 comname,fial.bakinfo bakinfo,fial.mobile mobile,fial.oprtime oprtime,fial.calcmonth calcmonth, ");
	    sb.append("  '' acctype,'' rewardstd,'' paysum,'' assegrade, nvl(wrapfee, 0) wrapfee,'' assegrade2,fial.noncyc noncyc,fial.bakinfo7 bakinfo7, ");
	    sb.append("  fial.bakinfo8 bakinfo8,'ʧ��' || fial.adtremark failreason from CH_ZD_FAIL fial, CH_PW_OPERATION op  where fial.opnid = op.opnid(+) and fial.opnid='0701010100021' ");

	   // if (StringUtils.isNotEmpty(rewardtype)) {// �������
			//sb.append("  and rec.rewardtype = :rewardtype ");
			//}
			if (StringUtils.isNotEmpty(rewardmonth)) {// �����·�
				sb.append("	 and fial.calcmonth = :rewardmonth ");
			}
			if (wayid != null) {// ��������
				sb.append("	  and fial.wayid = :wayid");
			}  
			if (StringUtils.isNotEmpty(repairmonth)) {
				if (repairmonth.equals("1")) {//�ϰ���Ԥ�����
				sb.append("	  and   substr(fial.batchno,7,2) = '16' ");
				}else if(repairmonth.equals("2")){ //�°���Ԥ�����
					sb.append("	  and substr(fial.batchno,7,2) = '30' ");
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
		RewardAdFailQueryParameter param = (RewardAdFailQueryParameter)parameter;
		
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
