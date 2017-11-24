/**
 * auto-generated code
 * Wed Oct 14 10:59:52 CST 2009
 */
 package com.gmcc.pboss.web.sales.orderflow;

import com.gmcc.pboss.business.sales.orderflow.OrderflowVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.orderflow.OrderflowDBParam;
import com.gmcc.pboss.control.sales.orderflow.Orderflow ;

/**
 * <p>Title: OrderflowAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderflowAction extends BaseAction{
	
	public OrderflowAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OrderflowForm());
		this.setParam(new OrderflowWebParam());

        //指定VO类
        setClsVO(OrderflowVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"flowid"};
		this.setClsControl(Orderflow.class);
		this.setClsQueryParam(OrderflowDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doNew() throws Exception {
		// TODO Auto-generated method stub
		super.doNew();
		OrderflowForm form = (OrderflowForm)super.getForm();
		form.setCityid(super.getDBAccessUser().getCityid());
		return WEB_RESULT_CONTENT;
	}

	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		OrderflowDBParam param = (OrderflowDBParam)super.getParam();
		param.set_se_cityid(super.getDBAccessUser().getCityid());
		return super.doList();
	}
	
	
}