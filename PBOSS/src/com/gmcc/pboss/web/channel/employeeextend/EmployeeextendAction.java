/**
 * auto-generated code
 * Thu Feb 17 11:53:25 CST 2011
 */
 package com.gmcc.pboss.web.channel.employeeextend;

import com.gmcc.pboss.business.channel.employeeextend.EmployeeextendVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.employeeextend.EmployeeextendDBParam;
import com.gmcc.pboss.control.channel.employeeextend.Employeeextend ;

/**
 * <p>Title: EmployeeextendAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmployeeextendAction extends BaseAction{
	
	public EmployeeextendAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new EmployeeextendForm());
		this.setParam(new EmployeeextendDBParam());

        //指定VO类
        setClsVO(EmployeeextendVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"employeeid"};
		this.setClsControl(Employeeextend.class);
		this.setClsQueryParam(EmployeeextendDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}