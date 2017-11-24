package com.gmcc.pboss.biz.info.reward.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.biz.info.reward.model.BbcRewardTotal;
import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.BbcRewardTotalQueryParameterProcessor;
import com.gmcc.pboss.biz.info.reward.support.RewardKind;
//import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.biz.info.reward.support.BbcRewardQueryParameter;

public class BbcRewardTotalServiceImpl extends AbstractBbcRewardService implements RewardService {

	public BbcRewardTotalServiceImpl() {
		super();
		this.serviceCode = ServiceCode.REWARDREPORT_TOTAL_BBC;
		this.serviceName = "月实际支付酬金报表 _B2M网站";
		setProcessor(new BbcRewardTotalQueryParameterProcessor());
	}

	public QueryResult getAll(QueryParameter parameter) {
		QueryResult result = super.getAll(parameter);
		Iterator iter = result.getData().iterator();
		List<BbcRewardTotal> rtnList = new ArrayList<BbcRewardTotal>();
		
		//以下注释掉的代码留待以后明细查询时扩展
		//BbcRewardQueryParameter param = (BbcRewardQueryParameter)parameter;
		while (iter.hasNext()) {
			BbcRewardTotal total;
			//if(param.isGroup()){//汇总查询
				Object[] obj = (Object[])iter.next();
				total = new BbcRewardTotal();
				total.setPaymoney((Double)obj[0]);
				total.setRewardtype((Short)obj[1]);
			//}
			//else{//明细查询-留待以后业务需要时扩展
				
			//}			
			total.setRewardtypeName(Constant.getConstantName(ConstantsType.BBC_REWARD_TPYPE, total.getRewardtype().toString()));
			rtnList.add(total);
		}
		result.setData(rtnList);
		
		return result;
	}

}
