/**
 * auto-generated code
 * Tue Oct 13 16:28:22 CST 2009
 */
 package com.gmcc.pboss.web.sales.orderplan;

import com.gmcc.pboss.business.sales.orderplan.OrderplanVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.orderplan.OrderplanDBParam;
import com.gmcc.pboss.control.sales.orderplan.Orderplan ;

/**
 * <p>Title: OrderplanAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderplanAction extends BaseAction{
	
	public OrderplanAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OrderplanForm());
		this.setParam(new OrderplanWebParam());

        //ָ��VO��
        setClsVO(OrderplanVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Orderplan.class);
		this.setClsQueryParam(OrderplanDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}