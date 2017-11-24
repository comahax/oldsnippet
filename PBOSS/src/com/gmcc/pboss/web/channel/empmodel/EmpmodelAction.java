/**
 * auto-generated code
 * Tue Jun 29 12:02:04 CST 2010
 */
 package com.gmcc.pboss.web.channel.empmodel;

import com.gmcc.pboss.business.channel.empmodel.EmpmodelVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.empmodel.EmpmodelDBParam;
import com.gmcc.pboss.control.channel.empmodel.Empmodel ;

/**
 * <p>Title: EmpmodelAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zhangsiwei
 * @version 1.0
 */
public class EmpmodelAction extends BaseAction{
	
	public EmpmodelAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new EmpmodelForm());
		this.setParam(new EmpmodelDBParam());

        //指定VO类
        setClsVO(EmpmodelVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"empmodelid"};
		this.setClsControl(Empmodel.class);
		this.setClsQueryParam(EmpmodelDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}