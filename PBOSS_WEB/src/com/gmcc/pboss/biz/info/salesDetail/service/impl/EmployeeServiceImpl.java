package com.gmcc.pboss.biz.info.salesDetail.service.impl;

import com.gmcc.pboss.biz.info.salesDetail.service.EmployeeService;
import com.gmcc.pboss.biz.info.salesDetail.support.EmployeeQueryParamProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.member.dao.IMemberDao;
/**
 * 销售明细查询中使用，查询出的数据生成弹出框列表，供用户选择
 */
public class EmployeeServiceImpl extends BaseServiceImpl implements
		EmployeeService {
	/**
	 * 业务编码和名称设置
	 */
	public EmployeeServiceImpl(){
		super();
		this.serviceCode = ServiceCode.EMPLOYEE_FOE_SELECT;
		this.serviceName = "人员信息展示-弹出框展示和选择";
		this.isNeedLogin = true;
	}
	
	/**
	 * 获取访问数据库的employeeDao
	 */
	private IMemberDao employeeDao;
	public void setEmployeeDao(IMemberDao employeeDao){
		this.employeeDao = employeeDao;
	}
	public IMemberDao getEmployeeDao(){
		return this.employeeDao;
	}
	
	/**
	 * 人员编码列表--这里使用JSON封装，用于界面表格的显示
	 */
	public ServiceResult query(LoginMember loginMember, QueryParameter parameter){
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//使用通用业务员编码，对于子业务，可以继承ServiceRetCode定义不用的业务编码（在getAll方法中实现）

		//查询条件处理器
		this.setProcessor(new EmployeeQueryParamProcessor());
		QueryResult queryResult = this.employeeDao.getAll(getProcessor(), parameter);
			
		result.setRetResult(queryResult);

		result.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);	
		return result;
	}
}
