/**
 * auto-generated code
 * Sat Sep 05 11:44:39 CST 2009
 */
 package com.gmcc.pboss.web.resource.com;

import com.gmcc.pboss.business.resource.com.ComVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.com.ComDBParam;
import com.gmcc.pboss.control.resource.com.Com ;

/**
 * <p>Title: ComAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComAction extends BaseAction{
	
	public ComAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ComForm());
		this.setParam(new ComWebParam());

        //指定VO类
        setClsVO(ComVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"comid"};
		this.setClsControl(Com.class);
		this.setClsQueryParam(ComDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	//号码类型识别
	public String doPhoneType(){
		return "phonetype";
	}
}