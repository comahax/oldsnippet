package com.gmcc.pboss.biz.info.salesRpt.service.impl;

import org.apache.log4j.Logger;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;

import com.gmcc.pboss.biz.info.salesRpt.service.OrderTimesService;
import com.gmcc.pboss.biz.info.salesRpt.support.processor.OrderTimesParameterProcessor;
import com.gmcc.pboss.biz.info.salesRpt.dao.SalesOrderDao;
import com.gmcc.pboss.biz.info.salesRpt.dao.OrderTimesDao;
import com.gmcc.pboss.model.sales.FxSwOrdertimes;

public class OrderTimesServiceImpl extends QueryBaseServiceImpl implements OrderTimesService {
	
	/**
	 * extends QueryBaseServiceImpl
	 * 
	 */
	OrderTimesServiceImpl(){
		serviceName = "订单次数信息查询";
		serviceCode = ServiceCode.ORDER_TIMES;
		isNeedLogin = true;
		
		this.setProcessor(new OrderTimesParameterProcessor());
	}
	
	SalesOrderDao salesOrderDao;
	public SalesOrderDao getSalesOrderDao(){
		return this.salesOrderDao;
	}
	public void setSalesOrderDao(SalesOrderDao salesOrderDao){
		this.salesOrderDao = salesOrderDao;
	}
	
	OrderTimesDao orderTimesDao;
	public OrderTimesDao getOrderTimesDao(){
		return this.orderTimesDao;
	}
	public void setOrderTimesDao(OrderTimesDao orderTimesDao){
		this.orderTimesDao = orderTimesDao;
	}
	
	//本月有效订单数次数信息查询
	public int[] searchOrderCount(LoginMember member){
		String wayid = member.getWayid();
		int[] a = new int[2];
		int count = this.salesOrderDao.getNumbers(wayid);

		//以下两个方法等效
		//int max = this.orderTimesDao.getForMaxtiems("APPWAY", wayid).getMaxtimes();
		FxSwOrdertimes orderTimes = this.orderTimesDao.getForMaxtiems("APPWAY", wayid);
		//int max = this.orderTimesDao.getForMaxtiems("APPWAY", wayid).getMaxtimes();
		int max;
		if(orderTimes!=null) max = orderTimes.getMaxtimes();
		else max = 0;
		a[0] = max; a[1]=count;
		return a;
	}
}
