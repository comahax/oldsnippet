/**
 * auto-generated code
 * Tue Oct 13 14:59:20 CST 2009
 */
 package com.gmcc.pboss.web.sales.orderpackdet;

import com.gmcc.pboss.business.sales.orderpackdet.OrderpackdetVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.orderpackdet.OrderpackdetDBParam;
import com.gmcc.pboss.control.sales.orderpackdet.Orderpackdet ;

/**
 * <p>Title: OrderpackdetAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderpackdetAction extends BaseAction{
	
	public OrderpackdetAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OrderpackdetForm());
		this.setParam(new OrderpackdetWebParam());

        //ָ��VO��
        setClsVO(OrderpackdetVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"detid"};
		this.setClsControl(Orderpackdet.class);
		this.setClsQueryParam(OrderpackdetDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}