package com.gmcc.pboss.biz.info.rewardtd.settlementmonth.service.imp;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gmcc.pboss.biz.info.rewardtd.rewardadsuc.dao.RewardAdSucDao;
import com.gmcc.pboss.biz.info.rewardtd.settlementmonth.dao.SettlementMonthDao;
import com.gmcc.pboss.biz.info.rewardtd.settlementmonth.service.SettlementMonthService;
import com.gmcc.pboss.biz.info.rewardtd.settlementmonth.support.SettlementMonth;
import com.gmcc.pboss.biz.info.rewardtd.settlementmonth.support.SettlementMonthQueryParamProcessor;
import com.gmcc.pboss.biz.info.rewardtd.settlementmonth.support.SettlementMonthQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

public class SettlementMonthServiceImpl extends BaseServiceImpl implements  SettlementMonthService {

	private SettlementMonthDao settlementMonthDao;
	
	/**
	 * ����������ServiceCode��ServiceName��ֵ
	 */
	public  SettlementMonthServiceImpl() {
		super();
		this.serviceCode = ServiceCode.SETTLEMENTMONTH;
		this.serviceName = "ҵ����ϸ����������ά�ȣ�";
		this.isNeedLogin = true;
		this.setProcessor(new SettlementMonthQueryParamProcessor());//����в�ͬ�Ĳ�ѯ������Ҫ��query�����ж�̬set��һ���Ļ�����������д��
		
	}
	
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		ServiceResult ret = new ServiceResult();
		ret.setSuccess(false);
		ret.setRetCode(ServiceRetCode.FAIL); 
		SettlementMonthQueryParameter param = (SettlementMonthQueryParameter) parameter; 
		List<SettlementMonth> retlist = new ArrayList<SettlementMonth>(); 
		
//		List busistat = this.rewardTdFailDao.getrewardTdfail(param);
		
		//��ѯ����������
		this.setProcessor(new SettlementMonthQueryParamProcessor());
		QueryResult queryResult = this.settlementMonthDao.getAllSQL(this.getProcessor(),parameter);
		//�Բ�ѯ�������ݽ��з�װ������װ���������Ϊ������
		List busistat = queryResult.getData();
		
		for (Iterator ite = busistat.iterator(); ite.hasNext();) {
			Object obje[] = (Object[]) ite.next();
			SettlementMonth info = new SettlementMonth();   
			info.setOprmon((String)obje[0].toString()); 
			info.setRwmon((String)obje[1].toString());
			info.setRwtypename((String)obje[2].toString());
			info.setImei((String)obje[3].toString());
			info.setComname((String)obje[4].toString()); 
			info.setMainno((String)obje[5].toString());
			if(Short.parseShort(obje[6].toString())==1){
				info.setBchksucc("ͨ��"); 
			}else if(Short.parseShort(obje[6].toString())==0){
				info.setBchksucc("ûͨ��"); 
			}
			info.setRwmoney(null==obje[7] ||("").equals(obje[7])?0:(new BigDecimal(obje[7].toString())).doubleValue());
			info.setFailrsn((String)obje[8].toString()); 
			
			retlist.add(info);
		} 
		
		queryResult = new QueryResult(queryResult.getPage(),retlist);
		ret.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		ret.setSuccess(true);
		ret.setRetCode(ServiceRetCode.SUCCESS);
		ret.setRetResult(new QueryResult(queryResult.getPage(),retlist)); 
		return ret;
	}

	public SettlementMonthDao getSettlementMonthDao() {
		return settlementMonthDao;
	}

	public void setSettlementMonthDao(SettlementMonthDao settlementMonthDao) {
		this.settlementMonthDao = settlementMonthDao;
	}

}
