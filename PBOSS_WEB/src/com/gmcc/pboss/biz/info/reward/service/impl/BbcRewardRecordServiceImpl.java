package com.gmcc.pboss.biz.info.reward.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import com.gmcc.pboss.biz.info.reward.model.BbcRewardRecord;
import com.gmcc.pboss.biz.info.reward.service.OperationService;
import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.BbcRewardRecordQueryParameterProcessor;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.biz.info.reward.support.BbcRewardQueryParameter;


public class BbcRewardRecordServiceImpl extends AbstractBbcRewardService implements RewardService {

	private OperationService bbcOperationService;

	public BbcRewardRecordServiceImpl() {
		super();
		setProcessor(new BbcRewardRecordQueryParameterProcessor());
	}

	public OperationService getBbcOperationService() {
		return bbcOperationService;
	}

	public void setBbcOperationService(OperationService bbcOperationService) {
		this.bbcOperationService = bbcOperationService;
	}

	// ����ҵ������ �� �����������
	public QueryResult getAll(QueryParameter parameter) {
		QueryResult result = super.getAll(parameter);
		Iterator iter = result.getData().iterator();
		//@@�����޸ĵ�
		List<BbcRewardRecord> rtnList = new ArrayList<BbcRewardRecord>();
		
		//��ȡparameter
		BbcRewardQueryParameter param = (BbcRewardQueryParameter)parameter;
		while (iter.hasNext()) {
			BbcRewardRecord record ;
			if(param.isGroup()){//���ܲ�ѯ
				//����ǻ��ܣ��²�������,�ֽ��ѯ���
				Object[] obj = (Object[]) iter.next();
				//��Group by �Ľ����װ����
				record = new BbcRewardRecord();
				record.setPaysum((Double)obj[0]);
				record.setRewardtype((Short)obj[1]);				
			}
			else{//��ϸ��ѯ
				record = (BbcRewardRecord) iter.next();
				record.setOpnname(bbcOperationService.getOperationName(record.getOpnid()));
				//record.setRewardtypeName(Constant.getConstantName(ConstantsType.BBC_REWARD_TPYPE, record.getRewardtype().toString()));
			}	
			record.setRewardtypeName(Constant.getConstantName(ConstantsType.BBC_REWARD_TPYPE, record.getRewardtype().toString()));
			rtnList.add(record);
		}
		result.setData(rtnList);
		return result;
	}

}
