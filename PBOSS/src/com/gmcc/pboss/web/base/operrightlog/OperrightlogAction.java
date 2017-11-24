/**
 * auto-generated code
 * Mon Sep 07 10:51:49 CST 2009
 */
 package com.gmcc.pboss.web.base.operrightlog;

import com.gmcc.pboss.business.base.operrightlog.OperrightlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.operrightlog.OperrightlogDBParam;
import com.gmcc.pboss.control.base.operrightlog.Operrightlog ;

/**
 * <p>Title: OperrightlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OperrightlogAction extends BaseAction{
	
	public OperrightlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OperrightlogForm());
		this.setParam(new OperrightlogWebParam());

        //指定VO类
        setClsVO(OperrightlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Operrightlog.class);
		this.setClsQueryParam(OperrightlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}