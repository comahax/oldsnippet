/**
 * auto-generated code
 * Mon Nov 23 16:50:43 CST 2009
 */
 package com.gmcc.pboss.web.channel.employeeapplylog;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employeeapplylog.EmployeeapplylogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.employeeapplylog.EmployeeapplylogDBParam;
import com.gmcc.pboss.control.channel.employeeapplylog.Employeeapplylog ;

/**
 * <p>Title: EmployeeapplylogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class EmployeeapplylogAction extends BaseAction{
	
	public EmployeeapplylogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new EmployeeapplylogForm());
		this.setParam(new EmployeeapplylogDBParam());

        //指定VO类
        setClsVO(EmployeeapplylogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"applyno"};
		this.setClsControl(Employeeapplylog.class);
		this.setClsQueryParam(EmployeeapplylogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		EmployeeapplylogDBParam param = (EmployeeapplylogDBParam)getParam();
		// 店员审批日志表是地市表，因此不必加地市ID的限制
//		param.set_se_cityid(getDBAccessUser().getCityid());
		return super.doList();
	}
}