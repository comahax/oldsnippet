/**
 * auto-generated code
 * Thu Jul 14 20:18:52 CST 2011
 */
 package com.gmcc.pboss.web.sales.wayassistantlog;

import com.gmcc.pboss.business.sales.wayassistantlog.WayassistantlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.wayassistantlog.WayassistantlogDBParam;
import com.gmcc.pboss.control.sales.wayassistantlog.Wayassistantlog ;

/**
 * <p>Title: WayassistantlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class WayassistantlogAction extends BaseAction{
	
	public WayassistantlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new WayassistantlogForm());
		this.setParam(new WayassistantlogDBParam());

        //指定VO类
        setClsVO(WayassistantlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Wayassistantlog.class);
		this.setClsQueryParam(WayassistantlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}