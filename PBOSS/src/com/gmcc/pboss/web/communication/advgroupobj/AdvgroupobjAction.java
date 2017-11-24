/**
 * auto-generated code
 * Tue Sep 29 10:22:17 CST 2009
 */
 package com.gmcc.pboss.web.communication.advgroupobj;

import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjDBParam;
import com.gmcc.pboss.control.communication.advgroupobj.Advgroupobj ;

/**
 * <p>Title: AdvgroupobjAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AdvgroupobjAction extends BaseAction{
	
	public AdvgroupobjAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new AdvgroupobjForm());
		this.setParam(new AdvgroupobjWebParam());

        //指定VO类
        setClsVO(AdvgroupobjVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"groupoid"};
		this.setClsControl(Advgroupobj.class);
		this.setClsQueryParam(AdvgroupobjDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}