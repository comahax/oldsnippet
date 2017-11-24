/**
 * auto-generated code
 * Thu Nov 05 10:44:22 CST 2009
 */
 package com.gmcc.pboss.web.channel.wayacctlog;

import com.gmcc.pboss.business.channel.wayacctlog.WayacctlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.wayacctlog.WayacctlogDBParam;
import com.gmcc.pboss.control.channel.wayacctlog.Wayacctlog ;

/**
 * <p>Title: WayacctlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WayacctlogAction extends BaseAction{
	
	public WayacctlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new WayacctlogForm());
		this.setParam(new WayacctlogDBParam());

        //指定VO类
        setClsVO(WayacctlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Wayacctlog.class);
		this.setClsQueryParam(WayacctlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}