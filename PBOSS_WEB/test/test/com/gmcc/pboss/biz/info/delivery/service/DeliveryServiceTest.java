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
	 * ��Ʒ������ʷ��ѯ
	 */
	private DeliveryService deliveryService;
	
	/**
	 * ������Ϣ��ѯ
	 */
	private SalesRptService salesOrderService;
	/**
	 * ������Ϣ��ѯ
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
		//���Զ�����Ϣ
		parameter.setOrderid("ZS201001070095");
		
		//����һ���ԣ�ʹ�ò��õ�Service�����л�����
		ServiceResult result = this.deliveryService.query(new LoginMember(), parameter);
		
//		SalesOrderQueryParameter parameter = new SalesOrderQueryParameter();
//		parameter.setWayid("CH_2323");
//		parameter.setOrderid("ORD");
//		
//		ServiceResult result = salesOrderService.query(new LoginMember(), parameter);
		//System.out.println(result);
		
		List<FxSwDisform> data = result.getRetResult().getData();
		System.out.println("������"+ data.size());
		for (int i=0;i<data.size();i++){
			FxSwDisform dtl = data.get(i);
			System.out.println("������Ϣ��"+dtl.getOrderInfo());
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
		System.out.println("������"+ result.getMessage());
		//��ϸ
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
			System.out.println("������"+ data.size());

			for (int i=0;i<data.size();i++){
				FxSwOrdercomcate dtl = data.get(i);
				if ("55DG".equals(dtl.getComcategory())){
					System.out.println(dtl.getComcategoryName()+",��λ��Ϣ��"+ dtl.getComcateUtil()+",������"+ dtl.getOrderamt() +
						",��"+ dtl.getTotalprice()+",��ע��"+dtl.getOrdercomtypeName() +",��Ʒ��Ϣ"+ dtl.getOdrPackageInfo()
						);
				}
//				System.out.println("{"+dtl.getOdrPackageInfo()+"}");
				//break;
			}
		}else{
			System.out.println("û������");
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
//			System.out.println(":Ӱ���¼��:"+ result.getRetObject());
//		else
//			System.out.println("������룺"+result.getRetCode()+"��������Ϣ��");
	}
}
