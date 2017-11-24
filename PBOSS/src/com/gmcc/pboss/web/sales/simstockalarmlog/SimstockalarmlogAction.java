/**
 * auto-generated code
 * Sat Mar 31 19:25:50 CST 2012
 */
 package com.gmcc.pboss.web.sales.simstockalarmlog;

import com.gmcc.pboss.business.sales.simstockalarmlog.SimstockalarmlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.simstockalarmlog.SimstockalarmlogDBParam;
import com.gmcc.pboss.control.sales.simstockalarmlog.Simstockalarmlog ;

/**
 * <p>Title: SimstockalarmlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class SimstockalarmlogAction extends BaseAction{
	
	public SimstockalarmlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SimstockalarmlogForm());
		this.setParam(new SimstockalarmlogDBParam());

        //指定VO类
        setClsVO(SimstockalarmlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Simstockalarmlog.class);
		this.setClsQueryParam(SimstockalarmlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}