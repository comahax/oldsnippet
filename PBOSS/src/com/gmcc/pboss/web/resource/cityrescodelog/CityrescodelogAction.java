/**
 * auto-generated code
 * Tue Aug 09 16:10:47 CST 2011
 */
 package com.gmcc.pboss.web.resource.cityrescodelog;

import com.gmcc.pboss.business.resource.cityrescodelog.CityrescodelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.cityrescodelog.CityrescodelogDBParam;
import com.gmcc.pboss.control.resource.cityrescodelog.Cityrescodelog ;

/**
 * <p>Title: CityrescodelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class CityrescodelogAction extends BaseAction{
	
	public CityrescodelogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new CityrescodelogForm());
		this.setParam(new CityrescodelogDBParam());

        //指定VO类
        setClsVO(CityrescodelogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Cityrescodelog.class);
		this.setClsQueryParam(CityrescodelogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}