/**
 * auto-generated code
 * Mon Dec 20 10:03:23 CST 2010
 */
 package com.gmcc.pboss.web.base.loginlog;

import com.gmcc.pboss.business.base.loginlog.LoginlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.loginlog.LoginlogDBParam;
import com.gmcc.pboss.control.base.loginlog.Loginlog ;

/**
 * <p>Title: LoginlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class LoginlogAction extends BaseAction{
	
	public LoginlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new LoginlogForm());
		this.setParam(new LoginlogWebParam());

        //指定VO类
        setClsVO(LoginlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Loginlog.class);
		this.setClsQueryParam(LoginlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}