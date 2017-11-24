/**
 * auto-generated code
 * Sat Nov 21 17:07:29 CST 2009
 */
 package com.gmcc.pboss.web.channel.wayhierarchy;

import com.gmcc.pboss.business.channel.wayhierarchy.WayhierarchyVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.wayhierarchy.WayhierarchyDBParam;
import com.gmcc.pboss.control.channel.wayhierarchy.Wayhierarchy ;

/**
 * <p>Title: WayhierarchyAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class WayhierarchyAction extends BaseAction{
	
	public WayhierarchyAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new WayhierarchyForm());
		this.setParam(new WayhierarchyDBParam());

        //指定VO类
        setClsVO(WayhierarchyVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"parwayid","subwayid"};
		this.setClsControl(Wayhierarchy.class);
		this.setClsQueryParam(WayhierarchyDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}