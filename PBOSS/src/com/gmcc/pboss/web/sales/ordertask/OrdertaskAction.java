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

		//以下几个方法是必须的
		this.setForm(new OrdertaskForm());
		this.setParam(new OrdertaskWebParam());

        //指定VO类
        setClsVO(OrdertaskVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Ordertask.class);
		this.setClsQueryParam(OrdertaskDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}