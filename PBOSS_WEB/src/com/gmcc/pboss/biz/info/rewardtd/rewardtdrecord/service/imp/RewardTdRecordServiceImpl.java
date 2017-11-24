package com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.service.imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.dao.RewardTdRecordDao;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.service.RewardTdRecordService;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.support.RewardTdRecordInfo;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.support.RewardTdRecordQueryParamProcessor;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.support.RewardTdRecordQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class RewardTdRecordServiceImpl extends BaseServiceImpl implements  RewardTdRecordService{
 
	
private RewardTdRecordDao  rewardTdRecordDao;
	
	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public  RewardTdRecordServiceImpl() {
		super();
		this.serviceCode = ServiceCode.REWARDTD_SUC_DATA;
		this.serviceName = "终端计酬成功数据汇总";
		this.isNeedLogin = true;
		this.setProcessor(new RewardTdRecordQueryParamProcessor());//如果有不同的查询器，需要在query方法中动态set，一个的话可以在这里写死
		
	}
	
	//
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		ServiceResult ret = new ServiceResult();
		ret.setSuccess(false);
		ret.setRetCode(ServiceRetCode.FAIL);

		RewardTdRecordQueryParameter param = (RewardTdRecordQueryParameter) parameter; 
		List<RewardTdRecordInfo> retlist = new ArrayList<RewardTdRecordInfo>(); 
		
		
		//查询条件处理器
		this.setProcessor(new RewardTdRecordQueryParamProcessor());
		QueryResult queryResult = this.rewardTdRecordDao.getAllSQL(this.getProcessor(),parameter);
		
		//对查询出的数据进行封装，将封装后的数据作为返回数
		List busistat = queryResult.getData();
		
		
		for (Iterator ite = busistat.iterator(); ite.hasNext();) {
			Object obje[] = (Object[]) ite.next();
			RewardTdRecordInfo info = new RewardTdRecordInfo();
			info.setName((String) obje[0]);
			if ( null !=obje[1] ){  
				info.setRewardtype("heyue".equals(obje[1])?"合约终端酬金":"裸机终端酬金"); 
			}else{
				info.setRewardtype("");
			} 
			info.setOprtime((String)obje[2]);
			info.setRewardmonth((String)obje[3]);
			info.setPaysum((new BigDecimal(obje[4].toString())).doubleValue());
			retlist.add(info);
		} 
		queryResult = new QueryResult(queryResult.getPage(),retlist);
		ret.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		ret.setSuccess(true);
		ret.setRetCode(ServiceRetCode.SUCCESS);
		ret.setRetResult(new QueryResult(null,retlist)); 
		return ret;
	}
	

	public RewardTdRecordDao getRewardTdRecordDao() {
		return rewardTdRecordDao;
	}

	public void setRewardTdRecordDao(RewardTdRecordDao rewardTdRecordDao) {
		this.rewardTdRecordDao = rewardTdRecordDao;
	}
}
