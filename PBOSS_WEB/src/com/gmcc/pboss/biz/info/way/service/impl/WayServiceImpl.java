package com.gmcc.pboss.biz.info.way.service.impl;

import com.gmcc.pboss.biz.info.way.dao.WayDao;
import com.gmcc.pboss.biz.info.way.service.WayService;
import com.gmcc.pboss.biz.info.way.support.WayQueryParameterProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class WayServiceImpl extends BaseServiceImpl implements WayService {

	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public WayServiceImpl(){
		super();
		this.serviceCode = ServiceCode.WAY_DETAILS;
		this.serviceName = "网点明细查询";
		isNeedLogin = true;// 需要登录
	}
	private WayDao wayDetailDao;
	
	public WayDao getWayDetailDao() {
		return wayDetailDao;
	}

	public void setWayDetailDao(WayDao wayDetailDao) {
		this.wayDetailDao = wayDetailDao;
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
		this.setProcessor(new WayQueryParameterProcessor());
		QueryResult queryResult = this.wayDetailDao.getAll(this.getProcessor(),parameter);

		result.setRetResult(queryResult);

		result.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}

}
