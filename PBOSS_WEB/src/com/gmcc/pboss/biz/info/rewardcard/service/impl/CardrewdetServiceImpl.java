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
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public CardrewdetServiceImpl(){
		super();
		this.serviceCode = ServiceCode.CARDREWDET_QUERY;
		this.serviceName = "客户质量发展奖励酬金";
		isNeedLogin = true;// 需要登录
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
	 * 查询
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {	
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//使用通用业务员编码，对于子业务，可以继承ServiceRetCode定义不用的业务编码（在getAll方法中实现）

		this.setProcessor(new CardrewdetQueryParamProcessor());
		QueryResult queryResult = this.cardrewdetDao.getAllSQL(this.getProcessor(), parameter);
		
		//对查询出的数据进行封装，将封装后的数据作为返回数
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

		result.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		
		return result;
	}
	
	/*
	 * 统计汇总
	 */
	public ServiceResult other(LoginMember member, QueryParameter parameter){
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//使用通用业务员编码，对于子业务，可以继承ServiceRetCode定义不用的业务编码（在getAll方法中实现）
		
		this.setProcessor(new CardrewdetStatParamProcessor());
		QueryResult queryResult = this.cardrewdetDao.getAllSQL(this.getProcessor(), parameter);
		//对查询出的数据进行封装，将封装后的数据作为返回数
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
		
		result.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		
		return result;
	}
	
	
}
