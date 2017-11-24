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

		//以下几个方法是必须的
		this.setForm(new OrderplanForm());
		this.setParam(new OrderplanWebParam());

        //指定VO类
        setClsVO(OrderplanVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Orderplan.class);
		this.setClsQueryParam(OrderplanDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}