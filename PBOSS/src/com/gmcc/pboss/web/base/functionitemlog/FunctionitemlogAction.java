/**
 * auto-generated code
 * Mon Sep 07 10:48:24 CST 2009
 */
 package com.gmcc.pboss.web.base.functionitemlog;

import com.gmcc.pboss.business.base.functionitemlog.FunctionitemlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.functionitemlog.FunctionitemlogDBParam;
import com.gmcc.pboss.control.base.functionitemlog.Functionitemlog ;

/**
 * <p>Title: FunctionitemlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class FunctionitemlogAction extends BaseAction{
	
	public FunctionitemlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new FunctionitemlogForm());
		this.setParam(new FunctionitemlogWebParam());

        //指定VO类
        setClsVO(FunctionitemlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Functionitemlog.class);
		this.setClsQueryParam(FunctionitemlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}