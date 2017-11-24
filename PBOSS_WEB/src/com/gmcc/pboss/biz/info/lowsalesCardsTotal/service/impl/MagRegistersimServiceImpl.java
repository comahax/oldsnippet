package com.gmcc.pboss.biz.info.lowsalesCardsTotal.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.info.salesDetail.dao.RegistersimDao;
import com.gmcc.pboss.biz.info.salesDetail.model.RegistersimDetail;
import com.gmcc.pboss.biz.info.lowsalesCardsTotal.service.MagRegistersimService;
import com.gmcc.pboss.biz.info.lowsalesCardsTotal.support.MagRegistersimQueryParamProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class MagRegistersimServiceImpl extends BaseServiceImpl implements
		MagRegistersimService {
	
	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public MagRegistersimServiceImpl(){
		super();
		this.serviceCode = ServiceCode.REGISTER_SIM_QUERY;
		this.serviceName = "套卡销售明细查询-从汇总界面进入";
		isNeedLogin = true;// 需要登录
		//this.setProcessor(new MagRegistersimQueryParamProcessor());
	}
	
	/**
	 * 套卡销售明细查询dao
	 */
	private RegistersimDao registersimDao;
	public void setRegistersimDao(RegistersimDao registersimDao){
		this.registersimDao = registersimDao;
	}
	public RegistersimDao getRegistersimDao(){
		return this.registersimDao;
	}
	
	/**
	 * 查询-套卡消息明细信息，HQL多表连接查询
	 * select new Object(*)
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {		
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//使用通用业务员编码，对于子业务，可以继承ServiceRetCode定义不用的业务编码（在getAll方法中实现）

		//查询条件处理器
		this.setProcessor(new MagRegistersimQueryParamProcessor());
		QueryResult queryResult = this.registersimDao.getAllSQL(this.getProcessor(),parameter);

		//对查询出的数据进行封装，将封装后的数据作为返回数
		List data = queryResult.getData();
		List reversed = new ArrayList<RegistersimDetail>();
		for(int i=0;i<data.size();i++){
			Object[] obj = (Object[])data.get(i);
			RegistersimDetail temp = new RegistersimDetail(
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
					(String)obj[10],
					(String)obj[11],
					(String)obj[12],
					(String)obj[13],
					(String)obj[14]);
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
