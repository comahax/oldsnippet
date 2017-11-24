/**
 * auto-generated code
 * Mon Sep 07 10:46:06 CST 2009
 */
 package com.gmcc.pboss.web.base.rolelog;

import com.gmcc.pboss.business.base.rolelog.RolelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.rolelog.RolelogDBParam;
import com.gmcc.pboss.control.base.rolelog.Rolelog ;

/**
 * <p>Title: RolelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class RolelogAction extends BaseAction{
	
	public RolelogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new RolelogForm());
		this.setParam(new RolelogWebParam());

        //指定VO类
        setClsVO(RolelogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Rolelog.class);
		this.setClsQueryParam(RolelogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}