package test.com.gmcc.pboss.biz.info.delivery.service;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.info.delivery.service.DeliveryService;
import com.gmcc.pboss.biz.info.delivery.support.DeliveryQueryParameter;
import com.gmcc.pboss.biz.info.salesRpt.service.SalesRptService;
import com.gmcc.pboss.biz.info.salesRpt.support.OrderDtlQueryParameter;
import com.gmcc.pboss.biz.info.salesRpt.support.SalesOrderQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.model.delivery.FxSwDisform;
import com.gmcc.pboss.model.sales.FxSwOrdercomcate;

import test.com.gmcc.pboss.common.BaseTest;

public class DeliveryServiceTest extends BaseTest {
	
	/**
	 * 商品订购历史查询
	 */
	private DeliveryService deliveryService;
	
	/**
	 * 订单信息查询
	 */
	private SalesRptService salesOrderService;
	/**
	 * 订单信息查询
	 */
	private SalesRptService orderDtlService;


	/**
	 * @return the deliveryService
	 */
	public DeliveryService getDeliveryService() {
		return deliveryService;
	}
	/**
	 * @param deliveryService the deliveryService to set
	 */
	public void setDeliveryService(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
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
		DeliveryQueryParameter parameter = new DeliveryQueryParameter();
		parameter.setWayid("CH_2333");
		
		parameter.setMonth("201005");
		//测试订单信息
		parameter.setOrderid("ZS201001070095");
		
		//二合一测试，使用不用的Service来做切换工作
		ServiceResult result = this.deliveryService.query(new LoginMember(), parameter);
		
//		SalesOrderQueryParameter parameter = new SalesOrderQueryParameter();
//		parameter.setWayid("CH_2323");
//		parameter.setOrderid("ORD");
//		
//		ServiceResult result = salesOrderService.query(new LoginMember(), parameter);
		//System.out.println(result);
		
		List<FxSwDisform> data = result.getRetResult().getData();
		System.out.println("个数："+ data.size());
		for (int i=0;i<data.size();i++){
			FxSwDisform dtl = data.get(i);
			System.out.println("订单信息："+dtl.getOrderInfo());
		}
	}
	public void testQueryOne() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		LoginMember member = new LoginMember();
		member.setWayid("CH_2333");
		DeliveryQueryParameter parameter = new DeliveryQueryParameter();
		parameter.setWayid("CH_2333");
		parameter.setOrderid("ZS201004200001");
		
		ServiceResult result = deliveryService.initiate(member, parameter);
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
		member.setWayid("CH_2333");
		
		DeliveryQueryParameter parameter = new DeliveryQueryParameter();
		parameter.setWayid("CH_2333");
		parameter.setOrderid("ZS201004200001");

		ServiceResult result = deliveryService.other(member, parameter);
		
//		System.out.println(odr.getComcates());
		if (result.isSuccess()){
			List<FxSwOrdercomcate> data = result.getRetResult().getData();
			System.out.println("个数："+ data.size());

			for (int i=0;i<data.size();i++){
				FxSwOrdercomcate dtl = data.get(i);
				if ("55DG".equals(dtl.getComcategory())){
					System.out.println(dtl.getComcategoryName()+",单位信息："+ dtl.getComcateUtil()+",数量："+ dtl.getOrderamt() +
						",金额："+ dtl.getTotalprice()+",备注："+dtl.getOrdercomtypeName() +",物品信息"+ dtl.getOdrPackageInfo()
						);
				}
//				System.out.println("{"+dtl.getOdrPackageInfo()+"}");
				//break;
			}
		}else{
			System.out.println("没有数据");
		}
	}

	public void testModify() {
//		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
//		LoginMember member = new LoginMember();
//		member.setWayid("CH_2333");
//		DeliveryQueryParameter param = new DeliveryQueryParameter();
////		param.setRecids("2,1");
//		param.setDisstate("WAITDIS");
//		
//		ServiceResult result = this.deliveryService.modify(member, param);
//		if (result.isSuccess()) 
//			System.out.println(":影响记录数:"+ result.getRetObject());
//		else
//			System.out.println("错误代码："+result.getRetCode()+"，错误信息：");
	}
}
