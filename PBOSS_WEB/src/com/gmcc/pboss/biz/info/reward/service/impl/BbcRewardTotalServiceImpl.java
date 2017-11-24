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
		this.serviceName = "��ʵ��֧����𱨱� _B2M��վ";
		setProcessor(new BbcRewardTotalQueryParameterProcessor());
	}

	public QueryResult getAll(QueryParameter parameter) {
		QueryResult result = super.getAll(parameter);
		Iterator iter = result.getData().iterator();
		List<BbcRewardTotal> rtnList = new ArrayList<BbcRewardTotal>();
		
		//����ע�͵��Ĵ��������Ժ���ϸ��ѯʱ��չ
		//BbcRewardQueryParameter param = (BbcRewardQueryParameter)parameter;
		while (iter.hasNext()) {
			BbcRewardTotal total;
			//if(param.isGroup()){//���ܲ�ѯ
				Object[] obj = (Object[])iter.next();
				total = new BbcRewardTotal();
				total.setPaymoney((Double)obj[0]);
				total.setRewardtype((Short)obj[1]);
			//}
			//else{//��ϸ��ѯ-�����Ժ�ҵ����Ҫʱ��չ
				
			//}			
			total.setRewardtypeName(Constant.getConstantName(ConstantsType.BBC_REWARD_TPYPE, total.getRewardtype().toString()));
			rtnList.add(total);
		}
		result.setData(rtnList);
		
		return result;
	}

}
