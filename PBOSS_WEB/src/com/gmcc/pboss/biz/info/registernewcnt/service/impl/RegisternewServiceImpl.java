package com.gmcc.pboss.biz.info.registernewcnt.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.info.registernewcnt.dao.RegisternewDao;
import com.gmcc.pboss.biz.info.registernewcnt.service.RegisternewService;
import com.gmcc.pboss.biz.info.registernewcnt.support.RegisternewQueryParamProcessor;
import com.gmcc.pboss.biz.info.registernewcnt.support.Registernewcnt;
import com.gmcc.pboss.biz.info.salesDetail.model.RegisternewDetail;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

/**
 * 新业务销售明细CH_PW_REGISTERNEW
 * @author Administrator
 *
 */
public class RegisternewServiceImpl extends BaseServiceImpl
		implements RegisternewService {

	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public RegisternewServiceImpl(){
		super();
		this.serviceCode = ServiceCode.REGISTERNEW_TOTAL;
		this.serviceName = "新业务销售明细查询";
		isNeedLogin = true;// 需要登录
		//this.setProcessor(new RegisternewQueryParamProcessor());
	}
	
	private RegisternewDao registernewDao;
	public void setRegisternewDao(RegisternewDao registernewDao){
		this.registernewDao = registernewDao;
	}
	public RegisternewDao getRegisternewDao(){
		return this.registernewDao;
	}
	
	/**
	 * 查询-新业务消息明细信息，HQL多表连接查询
	 * select new Object(*)
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {		
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//使用通用业务员编码，对于子业务，可以继承ServiceRetCode定义不用的业务编码（在getAll方法中实现）

		//查询条件处理器
		this.setProcessor(new RegisternewQueryParamProcessor());
		QueryResult queryResult = this.registernewDao.getAll(this.getProcessor(),parameter);

		//对查询出的数据进行封装，将封装后的数据作为返回数
		List data = queryResult.getData();
		List reversed = new ArrayList<RegisternewDetail>();
		for(int i=0;i<data.size();i++){
			Object[] obj = (Object[])data.get(i);
			RegisternewDetail temp = new RegisternewDetail(
					(String)obj[0],
					(String)obj[1],
					(String)obj[2],
					(String)obj[3],
					(String)obj[4],
					(String)obj[5],
					(String)obj[6],
					(String)obj[7],
					(String)obj[8],
					(String)obj[9],
					(String)obj[10]);
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
