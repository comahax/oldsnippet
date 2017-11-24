package com.gmcc.pboss.biz.info.salescnt.service.impl;

import java.util.ArrayList;

import com.gmcc.pboss.biz.info.salescnt.dao.SalescntDao;
import com.gmcc.pboss.biz.info.salescnt.service.SalescntService;
import com.gmcc.pboss.biz.info.salescnt.support.Salescnt;
import com.gmcc.pboss.biz.info.salescnt.support.SalescntQueryParameter;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.Assert;

public class SalescntServiceImpl extends QueryBaseServiceImpl implements SalescntService {

	public SalescntServiceImpl() {
		//设置业务相关属性
		serviceName = "销售汇总查询";
		serviceCode = ServiceCode.SALES_TOTAL;
		isNeedLogin = true;
	}
	
	private SalescntDao salescntDao;

	public SalescntDao getSalescntDao() {
		return salescntDao;
	}
	
	public void setSalescntDao(SalescntDao salescntDao) {
		this.salescntDao = salescntDao;
	}
	
	public QueryResult getAll(QueryParameter parameter) {
		
		Assert.isTrue(SalescntQueryParameter.class.isAssignableFrom(parameter.getClass()), ServiceConditionCode.REGACT_PARAMETER_TYPE, "参数对象类型不匹配");

		int resimCnt = salescntDao.getRegistersimCnt((SalescntQueryParameter) parameter);// 套卡销售数量
		
		int renewCnt = salescntDao.getRegisternewCnt((SalescntQueryParameter) parameter);// 新业务销售数量
		
		ArrayList list = new ArrayList();
		list.add(new Salescnt("套卡销售", resimCnt));
		list.add(new Salescnt("新业务销售", renewCnt));

		QueryResult result = new QueryResult(Page.EMPTY, list);

		return result;
	}
}
