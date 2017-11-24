package com.gmcc.pboss.biz.info.reward.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.Projections;

import com.gmcc.pboss.biz.info.reward.dao.RewardRecordDao;
import com.gmcc.pboss.biz.info.reward.model.RewardRecord;
import com.gmcc.pboss.biz.info.reward.service.OperationService;
import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.biz.info.reward.support.RewardRecordQueryParameterProcessor;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class RewardRecordServiceImpl extends AbstractRewardService implements RewardService {

	private OperationService operationService;

	public RewardRecordServiceImpl() {
		super();
		setProcessor(new RewardRecordQueryParameterProcessor());
	}

	public OperationService getOperationService() {
		return operationService;
	}

	public void setOperationService(OperationService operationService) {
		this.operationService = operationService;
	}

	// 设置业务名称
	public QueryResult getAll(QueryParameter parameter) {
		QueryResult result = super.getAll(parameter);
		Iterator iter = result.getData().iterator();
		//@@性能修改点
		List<RewardRecord> rtnList = new ArrayList<RewardRecord>();
		
		//提取parameter
		RewardQueryParameter param = (RewardQueryParameter) parameter;
		while (iter.hasNext()) {
			RewardRecord record;
			if (param.isGroup()){
				//如果是汇总（月产生报表）,分解查询结果
				Object[] obj = (Object[]) iter.next();
				
				/*
				 * 
					add(Projections.sum("paysum").as("paysum")).	-- obj[0]
					add(Projections.sum("paymoney1").as("paymoney1")). 	-- obj[1]
					add(Projections.sum("paymoney2").as("paymoney2")). 	-- obj[2]
					add(Projections.sum("paymoney3").as("paymoney3")). 	-- obj[3]
					add(Projections.groupProperty("rewardtype")). 	-- obj[4]
					add(Projections.groupProperty("paymonth1")). 	-- obj[5]
					add(Projections.groupProperty("paymonth2")). 	-- obj[6]
					add(Projections.groupProperty("paymonth3")). 	-- obj[7]
					add(Projections.groupProperty("acctype"))	 	-- obj[8]
					
				 */
				//把Group by 的结果封装起来
				record = new RewardRecord();
				record.setPaysum((Double) obj[0]);
				record.setPaymoney1((Double) obj[1]);
				record.setPaymoney2((Double) obj[2]);
				record.setPaymoney3((Double) obj[3]);
				record.setRewardtype((Short) obj[4]);
				record.setPaymonth1((String) obj[5]);
				record.setPaymonth2((String) obj[6]);
				record.setPaymonth3((String) obj[7]);
				record.setAcctype((Short) obj[8]);
			}else{
				record = (RewardRecord) iter.next();
			}
			
			record.setOpnname(operationService.getOperationName(record.getOpnid()));
			record.setRewardtypeName(Constant.getConstantName(ConstantsType.SOCIETY_REWARD_TPYPE, record.getRewardtype().toString()));
			
			if(record.getRewardtype().equals((short)7)){
				record.setAcctypeName(Constant.getConstantName(ConstantsType.BSACCTYPE, record.getAcctype().toString()));	
			}else{
				record.setAcctypeName(Constant.getConstantName(ConstantsType.ACCTYPE, record.getAcctype().toString()));				
			}
			rtnList.add(record);
		}
		result.setData(rtnList);
		return result;
	}
	
	/**
	 * 统计社会渠道网点酬金池余额
	 * @param parameter
	 * @return
	 */
	protected Long statRewardBalance(QueryParameter parameter) {
		RewardRecordDao rewardRecordDao = (RewardRecordDao)this.getDao();
		RewardQueryParameter param = (RewardQueryParameter)parameter;
		return rewardRecordDao.statRewardBalance(param);
	}

}
