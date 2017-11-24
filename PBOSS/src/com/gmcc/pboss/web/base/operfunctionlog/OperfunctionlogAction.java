/**
 * auto-generated code
 * Mon Sep 07 10:51:00 CST 2009
 */
 package com.gmcc.pboss.web.base.operfunctionlog;

import com.gmcc.pboss.business.base.operfunctionlog.OperfunctionlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.operfunctionlog.OperfunctionlogDBParam;
import com.gmcc.pboss.control.base.operfunctionlog.Operfunctionlog ;

/**
 * <p>Title: OperfunctionlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OperfunctionlogAction extends BaseAction{
	
	public OperfunctionlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OperfunctionlogForm());
		this.setParam(new OperfunctionlogWebParam());

        //指定VO类
        setClsVO(OperfunctionlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Operfunctionlog.class);
		this.setClsQueryParam(OperfunctionlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}