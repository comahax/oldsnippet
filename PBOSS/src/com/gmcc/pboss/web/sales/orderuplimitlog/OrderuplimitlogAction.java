/**
 * auto-generated code
 * Tue Jun 22 17:28:44 CST 2010
 */
 package com.gmcc.pboss.web.sales.orderuplimitlog;

import com.gmcc.pboss.business.sales.orderuplimitlog.OrderuplimitlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.orderuplimitlog.OrderuplimitlogDBParam;
import com.gmcc.pboss.control.sales.orderuplimitlog.Orderuplimitlog ;

/**
 * <p>Title: OrderuplimitlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderuplimitlogAction extends BaseAction{
	
	public OrderuplimitlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OrderuplimitlogForm());
		this.setParam(new OrderuplimitlogDBParam());

        //ָ��VO��
        setClsVO(OrderuplimitlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Orderuplimitlog.class);
		this.setClsQueryParam(OrderuplimitlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}