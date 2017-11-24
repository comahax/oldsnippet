package test.com.gmcc.pboss.biz.info.salesRpt.service;

import java.util.ArrayList;
import java.util.List;
import com.gmcc.pboss.biz.info.regactInfo.model.MhTkRegactinfo;
import com.gmcc.pboss.biz.info.regactInfo.service.RegactInfoService;
import com.gmcc.pboss.biz.info.regactInfo.support.RegactInfoQueryParameter;
import com.gmcc.pboss.biz.info.salesRpt.service.SalesRptService;
import com.gmcc.pboss.biz.info.salesRpt.support.OrderDtlQueryParameter;
import com.gmcc.pboss.biz.info.salesRpt.support.SalesHistoryQueryParameter;
import com.gmcc.pboss.biz.info.salesRpt.support.SalesOrderQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.model.sales.FxSwOrder;

import test.com.gmcc.pboss.common.BaseTest;

public class SalesRptServiceTest extends BaseTest {
	
	/**
	 * 商品订购历史查询
	 */
	private SalesRptService salesHistoryService;
	
	/**
	 * 订单信息查询
	 */
	private SalesRptService salesOrderService;
	/**
	 * 订单信息查询
	 */
	private SalesRptService orderDtlService;

	/**
	 * @return the salesHistoryService
	 */
	public SalesRptService getSalesHistoryService() {
		return salesHistoryService;
	}
	/**
	 * @param salesHistoryService the salesHistoryService to set
	 */
	public void setSalesHistoryService(SalesRptService salesHistoryService) {
		this.salesHistoryService = salesHistoryService;
	}

	/**
	 * @return the salesOrderService
	 */
	public SalesRptService getSalesOrderService() {
		return salesOrderService;
	}
	/**
	 * @param salesOrderService the salesOrderService to set
	 */
	public void setSalesOrderService(SalesRptService salesOrderService) {
		this.salesOrderService = salesOrderService;
	}
	
	/**
	 * @return the orderDtlService
	 */
	public SalesRptService getOrderDtlService() {
		return orderDtlService;
	}
	/**
	 * @param orderDtlService the orderDtlService to set
	 */
	public void setOrderDtlService(SalesRptService orderDtlService) {
		this.orderDtlService = orderDtlService;
	}
	public void testQuery() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		SalesHistoryQueryParameter parameter = new SalesHistoryQueryParameter();
		parameter.setWayid("CH_2323");
		parameter.setComType("50DG");
		parameter.setMonth("200909");
		//二合一测试，使用不用的Service来做切换工作
		ServiceResult result = salesHistoryService.query(new LoginMember(), parameter);
		
//		SalesOrderQueryParameter parameter = new SalesOrderQueryParameter();
//		parameter.setWayid("CH_2323");
//		parameter.setOrderid("ORD");
//		
//		ServiceResult result = salesOrderService.query(new LoginMember(), parameter);
		//System.out.println(result);
		
		List data = result.getRetResult().getData();
		System.out.println("个数："+ data.size());
		for (int i=0;i<data.size();i++){
		}
	}
	public void testQueryOne() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		LoginMember member = new LoginMember();
		member.setWayid("CH_2323");
		SalesOrderQueryParameter parameter = new SalesOrderQueryParameter();
		parameter.setWayid("CH_2323");
		parameter.setOrderid("ORD13");
		
		ServiceResult result = salesOrderService.initiate(member, parameter);
		//System.out.println(result);
		
//		System.out.println(odr.getComcates());
		System.out.println("个数："+ result.getMessage());
		//明细
//		for (int i=0;i<data.size();i++){
//		}
	}
	
	public void testQueryDtl() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		LoginMember member = new LoginMember();
		member.setWayid("CH_2323");
		OrderDtlQueryParameter parameter = new OrderDtlQueryParameter();
		parameter.setWayid("CH_2323");
		parameter.setOrderid("ORD13");
//		parameter.setSelecType(ConstantsType.SALES_SELECTYPE_COMCATE);
		parameter.setSelecType(ConstantsType.SALES_SELECTYPE_RESDETS);
		
		ServiceResult result = orderDtlService.query(member, parameter);
		//System.out.println(result);
		
//		System.out.println(odr.getComcates());
		if (result.isSuccess()){
			List data = result.getRetResult().getData();
			System.out.println("个数："+ data.size());
		}else{
			System.out.println("没有数据");
		}
	}

}
