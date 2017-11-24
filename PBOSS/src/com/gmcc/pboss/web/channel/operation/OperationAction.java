/**
 * auto-generated code
 * Sun Sep 13 11:38:12 CST 2009
 */
 package com.gmcc.pboss.web.channel.operation;

import com.gmcc.pboss.business.channel.operation.OperationVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.operation.OperationDBParam;
import com.gmcc.pboss.control.channel.operation.Operation ;

/**
 * <p>Title: OperationAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class OperationAction extends BaseAction{
	
	public OperationAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OperationForm());
		this.setParam(new OperationWebParam());

        //指定VO类
        setClsVO(OperationVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"opnid"};
		this.setClsControl(Operation.class);
		this.setClsQueryParam(OperationDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}