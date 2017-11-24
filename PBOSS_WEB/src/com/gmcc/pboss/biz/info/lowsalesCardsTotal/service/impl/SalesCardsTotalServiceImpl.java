package com.gmcc.pboss.biz.info.lowsalesCardsTotal.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.info.lowsalesCardsTotal.dao.SalesCardsTotalDao;
import com.gmcc.pboss.biz.info.lowsalesCardsTotal.service.SalesCardsTotalService;
import com.gmcc.pboss.biz.info.lowsalesCardsTotal.support.SalesCardsTotal;
import com.gmcc.pboss.biz.info.lowsalesCardsTotal.support.SalesCardsTotalQueryParameter;
import com.gmcc.pboss.biz.info.lowsalesCardsTotal.support.SalescardsTotalQueryParamProcessor;
import com.gmcc.pboss.biz.info.registernewcnt.support.RegisternewcntQueryParamProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.Assert;

public class SalesCardsTotalServiceImpl extends QueryBaseServiceImpl implements
		SalesCardsTotalService {

	public SalesCardsTotalServiceImpl() {
		//设置业务相关属性
		serviceName = "套卡汇总查询";
		serviceCode = ServiceCode.SALES_CARDSTOTAL;
		isNeedLogin = true;
	}
	
	private SalesCardsTotalDao salesCardsTotalDao;

	
	
	public SalesCardsTotalDao getSalesCardsTotalDao() {
		return salesCardsTotalDao;
	}



	public void setSalesCardsTotalDao(SalesCardsTotalDao salesCardsTotalDao) {
		this.salesCardsTotalDao = salesCardsTotalDao;
	}


	/**
	 * 查询-套卡汇总查询信息，HQL多表连接查询(经理查询)
	 * select new Object(*)
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {		
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//使用通用业务员编码，对于子业务，可以继承ServiceRetCode定义不用的业务编码（在getAll方法中实现）

		//查询条件处理器
		this.setProcessor(new SalescardsTotalQueryParamProcessor());
		QueryResult queryResult = this.salesCardsTotalDao.getAll(this.getProcessor(),parameter);

		List<Object[]> data=queryResult.getData();
		List reversed=new ArrayList<SalesCardsTotal>();
		for (Object[] obj:data){
//			String wayid,String countyid,String employeeid,
//			String employeename,String officetel,String brand,
//			String opnid,String opnname,String total
			SalesCardsTotal salesCardsTotal = new SalesCardsTotal();
			salesCardsTotal.setWayid((String) obj[0]);
			salesCardsTotal.setCountyid((String) obj[1]);
			//传employeeid过去,通过employeeid进行查询
			salesCardsTotal.setEmployeeid((String) obj[1+1]);
			salesCardsTotal.setEmployeename((String) obj[0+2+1]);
			salesCardsTotal.setOfficetel((String) obj[1+2+1]);
			salesCardsTotal.setBrand(((BigDecimal) obj[2+2+1]).toString());
			//salesCardsTotal.setOpnid((obj[3+2+1]).toString());
			//if(obj[4+2+1]==null){
			//	salesCardsTotal.setOpnname((obj[3+2+1]).toString());
			//}else{
			//	salesCardsTotal.setOpnname((obj[4+2+1]).toString());
			//}
			salesCardsTotal.setTotal((String) obj[3+2+1]);
			SalesCardsTotal salesCardsTotal22;
			
			salesCardsTotal22 = new SalesCardsTotal(salesCardsTotal);
			reversed.add(salesCardsTotal22);
		}
		queryResult = new QueryResult(queryResult.getPage(),reversed);
		
		result.setRetResult(queryResult);

		result.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}
	
	

//	public QueryResult getAll(QueryParameter parameter) {
//		
//		Assert.isTrue(SalesCardsTotalQueryParameter.class.isAssignableFrom(parameter.getClass()), ServiceConditionCode.REGACT_PARAMETER_TYPE, "参数对象类型不匹配");
//
//		List salesCardsTotal = salesCardsTotalDao.getSalesCardsTotal((SalesCardsTotalQueryParameter) parameter);// 套卡销售汇总
//		
//		QueryResult result = new QueryResult(Page.EMPTY, salesCardsTotal);
//
//		return result;
//	}
	
}
