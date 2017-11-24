package com.gmcc.pboss.biz.info.registernewcnt.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.info.registernewcnt.dao.RegisternewcntDao;
import com.gmcc.pboss.biz.info.registernewcnt.service.RegisternewcntService;
import com.gmcc.pboss.biz.info.registernewcnt.support.Registernewcnt;
import com.gmcc.pboss.biz.info.registernewcnt.support.RegisternewcntQueryParamProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class RegisternewcntServiceImpl extends QueryBaseServiceImpl implements RegisternewcntService {

	public RegisternewcntServiceImpl() {
		//设置业务相关属性
		serviceName = "新业务销售汇总查询";
		serviceCode = ServiceCode.REGISTERNEW_TOTAL;
		isNeedLogin = true;
	}
	
	private RegisternewcntDao registernewcntDao;

	public RegisternewcntDao getRegisternewcntDao() {
		return registernewcntDao;
	}

	public void setRegisternewcntDao(RegisternewcntDao registernewcntDao) {
		this.registernewcntDao = registernewcntDao;
	}
	
	/**
	 * 查询-新业务销售汇总信息，HQL多表连接查询(经理查询)
	 * select new Object(*)
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {		
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//使用通用业务员编码，对于子业务，可以继承ServiceRetCode定义不用的业务编码（在getAll方法中实现）

		//查询条件处理器
		this.setProcessor(new RegisternewcntQueryParamProcessor());
		QueryResult queryResult = this.registernewcntDao.getAll(this.getProcessor(),parameter);

		//对查询出的数据进行封装，将封装后的数据作为返回数
		List data = queryResult.getData();
		List reversed = new ArrayList<Registernewcnt>();
		for(int i=0;i<data.size();i++){
			Object[] obj = (Object[])data.get(i);
			Registernewcnt temp = new Registernewcnt(
					(String)obj[0],
					(String)obj[1],
					(String)obj[2],
					(String)obj[3],
					(String)obj[4]);
			reversed.add(i,temp);
		}
		queryResult = new QueryResult(queryResult.getPage(),reversed);
		
		result.setRetResult(queryResult);

		result.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}
}
