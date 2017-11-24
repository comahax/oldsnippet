package com.gmcc.pboss.biz.info.rewardcard.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.gmcc.pboss.biz.info.rewardcard.service.CardrewdetService;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.biz.info.rewardcard.dao.CardrewdetDao;
import com.gmcc.pboss.biz.info.rewardcard.support.CardrewdetQueryParamProcessor;
import com.gmcc.pboss.biz.info.rewardcard.support.CardrewdetDetail;
import com.gmcc.pboss.biz.info.rewardcard.support.CardrewdetStatParamProcessor;
import com.gmcc.pboss.biz.info.rewardcard.support.CardrewdetStat;

public class CardrewdetServiceImpl extends BaseServiceImpl implements
		CardrewdetService {
	/**
	 * ����������ServiceCode��ServiceName��ֵ
	 */
	public CardrewdetServiceImpl(){
		super();
		this.serviceCode = ServiceCode.CARDREWDET_QUERY;
		this.serviceName = "�ͻ�������չ�������";
		isNeedLogin = true;// ��Ҫ��¼
		//this.setProcessor(new CardrewdetQueryParamProcessor());
	}
	
	/*
	 * DAO
	 */
	private CardrewdetDao cardrewdetDao;
	public CardrewdetDao getCardrewdetDao() {
		return cardrewdetDao;
	}

	public void setCardrewdetDao(CardrewdetDao cardrewdetDao) {
		this.cardrewdetDao = cardrewdetDao;
	}
	
	/*
	 * ��ѯ
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {	
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//ʹ��ͨ��ҵ��Ա���룬������ҵ�񣬿��Լ̳�ServiceRetCode���岻�õ�ҵ����루��getAll������ʵ�֣�

		this.setProcessor(new CardrewdetQueryParamProcessor());
		QueryResult queryResult = this.cardrewdetDao.getAllSQL(this.getProcessor(), parameter);
		
		//�Բ�ѯ�������ݽ��з�װ������װ���������Ϊ������
		List data = queryResult.getData();
		List<CardrewdetDetail> reversed = new ArrayList<CardrewdetDetail>();
		for(int i=0;i<data.size();i++){
			Object[] obj = (Object[])data.get(i);
			CardrewdetDetail detail = new CardrewdetDetail(
					(String)obj[0],
					(String)obj[1],
					(String)obj[2],
					(String)obj[3],
					(String)obj[4],
					(String)obj[5],
					(String)obj[6],
					(String)obj[7]);			
			reversed.add(detail);			
		}
		queryResult = new QueryResult(queryResult.getPage(),reversed);
		
		result.setRetResult(queryResult);

		result.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		
		return result;
	}
	
	/*
	 * ͳ�ƻ���
	 */
	public ServiceResult other(LoginMember member, QueryParameter parameter){
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//ʹ��ͨ��ҵ��Ա���룬������ҵ�񣬿��Լ̳�ServiceRetCode���岻�õ�ҵ����루��getAll������ʵ�֣�
		
		this.setProcessor(new CardrewdetStatParamProcessor());
		QueryResult queryResult = this.cardrewdetDao.getAllSQL(this.getProcessor(), parameter);
		//�Բ�ѯ�������ݽ��з�װ������װ���������Ϊ������
		List data = queryResult.getData();
		List<CardrewdetStat> reversed = new ArrayList<CardrewdetStat>();
		for(int i=0;i<data.size();i++){
			Object[] obj = (Object[])data.get(i);
			CardrewdetStat detail = new CardrewdetStat(
					(String)obj[0],
					(String)obj[1],
					obj[2].toString(),
					(String)obj[3],
					(String)obj[4],
					(String)obj[5],
					(String)obj[6]);
			reversed.add(detail);
		}
		queryResult = new QueryResult(queryResult.getPage(),reversed);
		
		result.setRetResult(queryResult);
		
		result.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		
		return result;
	}
	
	
}
