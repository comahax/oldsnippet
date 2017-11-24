package com.gmcc.pboss.biz.info.servcent.service.impl;

import com.gmcc.pboss.biz.info.servcent.dao.ServcentDao;
import com.gmcc.pboss.biz.info.servcent.service.ServcentService;
import com.gmcc.pboss.biz.info.servcent.support.ServcentQueryParameterProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class ServcentServiceImpl extends BaseServiceImpl implements ServcentService {

	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public ServcentServiceImpl(){
		super();
		this.serviceCode = ServiceCode.SERVCENT_DETAILS;
		this.serviceName = "销售服务中心查询";
		isNeedLogin = true;// 需要登录
	}
	
	private ServcentDao servcentDao;

	public ServcentDao getServcentDao() {
		return servcentDao;
	}

	public void setServcentDao(ServcentDao servcentDao) {
		this.servcentDao = servcentDao;
	}
	
	/**
	 * 查询-网点明细信息，HQL查询
	 * select new Object(*)
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {		
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//使用通用业务员编码，对于子业务，可以继承ServiceRetCode定义不用的业务编码（在getAll方法中实现）

		//查询条件处理器
		this.setProcessor(new ServcentQueryParameterProcessor());
		QueryResult queryResult = this.servcentDao.getAll(this.getProcessor(),parameter);

		result.setRetResult(queryResult);

		result.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}
}
