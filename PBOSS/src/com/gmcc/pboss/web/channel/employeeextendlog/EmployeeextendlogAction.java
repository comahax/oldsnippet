/**
 * auto-generated code
 * Thu Feb 17 11:55:20 CST 2011
 */
 package com.gmcc.pboss.web.channel.employeeextendlog;

import com.gmcc.pboss.business.channel.employeeextendlog.EmployeeextendlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.employeeextendlog.EmployeeextendlogDBParam;
import com.gmcc.pboss.control.channel.employeeextendlog.Employeeextendlog ;

/**
 * <p>Title: EmployeeextendlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmployeeextendlogAction extends BaseAction{
	
	public EmployeeextendlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new EmployeeextendlogForm());
		this.setParam(new EmployeeextendlogDBParam());

        //指定VO类
        setClsVO(EmployeeextendlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Employeeextendlog.class);
		this.setClsQueryParam(EmployeeextendlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}