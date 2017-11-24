/**
 * auto-generated code
 * Fri Dec 07 14:13:24 CST 2012
 */
 package com.gmcc.pboss.web.resource.simnoactinfofile;

import com.gmcc.pboss.business.resource.simnoactinfofile.SimnoactinfofileVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.simnoactinfofile.SimnoactinfofileDBParam;
import com.gmcc.pboss.control.resource.simnoactinfofile.Simnoactinfofile ;

/**
 * <p>Title: SimnoactinfofileAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class SimnoactinfofileAction extends BaseAction{
	
	public SimnoactinfofileAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SimnoactinfofileForm());
		this.setParam(new SimnoactinfofileDBParam());

        //指定VO类
        setClsVO(SimnoactinfofileVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Simnoactinfofile.class);
		this.setClsQueryParam(SimnoactinfofileDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}