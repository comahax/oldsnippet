/**
 * auto-generated code
 * Fri Oct 16 13:35:33 CST 2009
 */
 package com.gmcc.pboss.web.sales.ordertask;

import com.gmcc.pboss.business.sales.ordertask.OrdertaskVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.ordertask.OrdertaskDBParam;
import com.gmcc.pboss.control.sales.ordertask.Ordertask ;

/**
 * <p>Title: OrdertaskAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrdertaskAction extends BaseAction{
	
	public OrdertaskAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OrdertaskForm());
		this.setParam(new OrdertaskWebParam());

        //ָ��VO��
        setClsVO(OrdertaskVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Ordertask.class);
		this.setClsQueryParam(OrdertaskDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}