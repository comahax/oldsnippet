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

		//以下几个方法是必须的
		this.setForm(new OrderpackdetForm());
		this.setParam(new OrderpackdetWebParam());

        //指定VO类
        setClsVO(OrderpackdetVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"detid"};
		this.setClsControl(Orderpackdet.class);
		this.setClsQueryParam(OrderpackdetDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}