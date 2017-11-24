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
	 * ����������ServiceCode��ServiceName��ֵ
	 */
	public  RewardTdRecordServiceImpl() {
		super();
		this.serviceCode = ServiceCode.REWARDTD_SUC_DATA;
		this.serviceName = "�ն˼Ƴ�ɹ����ݻ���";
		this.isNeedLogin = true;
		this.setProcessor(new RewardTdRecordQueryParamProcessor());//����в�ͬ�Ĳ�ѯ������Ҫ��query�����ж�̬set��һ���Ļ�����������д��
		
	}
	
	//
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		ServiceResult ret = new ServiceResult();
		ret.setSuccess(false);
		ret.setRetCode(ServiceRetCode.FAIL);

		RewardTdRecordQueryParameter param = (RewardTdRecordQueryParameter) parameter; 
		List<RewardTdRecordInfo> retlist = new ArrayList<RewardTdRecordInfo>(); 
		
		
		//��ѯ����������
		this.setProcessor(new RewardTdRecordQueryParamProcessor());
		QueryResult queryResult = this.rewardTdRecordDao.getAllSQL(this.getProcessor(),parameter);
		
		//�Բ�ѯ�������ݽ��з�װ������װ���������Ϊ������
		List busistat = queryResult.getData();
		
		
		for (Iterator ite = busistat.iterator(); ite.hasNext();) {
			Object obje[] = (Object[]) ite.next();
			RewardTdRecordInfo info = new RewardTdRecordInfo();
			info.setName((String) obje[0]);
			if ( null !=obje[1] ){  
				info.setRewardtype("heyue".equals(obje[1])?"��Լ�ն˳��":"����ն˳��"); 
			}else{
				info.setRewardtype("");
			} 
			info.setOprtime((String)obje[2]);
			info.setRewardmonth((String)obje[3]);
			info.setPaysum((new BigDecimal(obje[4].toString())).doubleValue());
			retlist.add(info);
		} 
		queryResult = new QueryResult(queryResult.getPage(),retlist);
		ret.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
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
