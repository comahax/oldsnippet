/**
 * auto-generated code
 * Sun Oct 18 20:50:56 CST 2009
 */
 package com.gmcc.pboss.web.channel.waycompctlog;

import com.gmcc.pboss.business.channel.waycompctlog.WaycompctlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.waycompctlog.WaycompctlogDBParam;
import com.gmcc.pboss.control.channel.waycompctlog.Waycompctlog ;

/**
 * <p>Title: WaycompctlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WaycompctlogAction extends BaseAction{
	
	public WaycompctlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new WaycompctlogForm());
		this.setParam(new WaycompctlogWebParam());

        //指定VO类
        setClsVO(WaycompctlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Waycompctlog.class);
		this.setClsQueryParam(WaycompctlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}