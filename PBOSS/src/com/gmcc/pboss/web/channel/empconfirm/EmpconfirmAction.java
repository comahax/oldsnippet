/**
 * auto-generated code
 * Tue Mar 01 19:20:26 CST 2011
 */
 package com.gmcc.pboss.web.channel.empconfirm;

import com.gmcc.pboss.business.channel.empconfirm.EmpconfirmVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.empconfirm.EmpconfirmDBParam;
import com.gmcc.pboss.control.channel.empconfirm.Empconfirm ;

/**
 * <p>Title: EmpconfirmAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmpconfirmAction extends BaseAction{
	
	public EmpconfirmAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new EmpconfirmForm());
		this.setParam(new EmpconfirmDBParam());

        //指定VO类
        setClsVO(EmpconfirmVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"confirmid"};
		this.setClsControl(Empconfirm.class);
		this.setClsQueryParam(EmpconfirmDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}