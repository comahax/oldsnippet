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

		//以下几个方法是必须的
		this.setForm(new OrderuplimitlogForm());
		this.setParam(new OrderuplimitlogDBParam());

        //指定VO类
        setClsVO(OrderuplimitlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Orderuplimitlog.class);
		this.setClsQueryParam(OrderuplimitlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}