/**
 * auto-generated code
 * Fri Dec 07 14:12:22 CST 2012
 */
 package com.gmcc.pboss.web.resource.simnoactinfo;

import com.gmcc.pboss.business.resource.simnoactinfo.SimnoactinfoVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.simnoactinfo.SimnoactinfoDBParam;
import com.gmcc.pboss.control.resource.simnoactinfo.Simnoactinfo ;

/**
 * <p>Title: SimnoactinfoAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class SimnoactinfoAction extends BaseAction{
	
	public SimnoactinfoAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SimnoactinfoForm());
		this.setParam(new SimnoactinfoDBParam());

        //指定VO类
        setClsVO(SimnoactinfoVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Simnoactinfo.class);
		this.setClsQueryParam(SimnoactinfoDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}