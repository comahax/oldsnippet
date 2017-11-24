/**
 * auto-generated code
 * Thu Jul 08 15:13:51 CST 2010
 */
 package com.gmcc.pboss.web.sales.timesectlog;

import com.gmcc.pboss.business.sales.timesectlog.TimesectlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.timesectlog.TimesectlogDBParam;
import com.gmcc.pboss.control.sales.timesectlog.Timesectlog ;

/**
 * <p>Title: TimesectlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class TimesectlogAction extends BaseAction{
	
	public TimesectlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new TimesectlogForm());
		this.setParam(new TimesectlogDBParam());

        //指定VO类
        setClsVO(TimesectlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Timesectlog.class);
		this.setClsQueryParam(TimesectlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}