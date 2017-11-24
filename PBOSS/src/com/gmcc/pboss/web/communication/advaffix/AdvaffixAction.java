/**
 * auto-generated code
 * Tue Sep 29 10:26:16 CST 2009
 */
 package com.gmcc.pboss.web.communication.advaffix;

import com.gmcc.pboss.business.communication.advaffix.AdvaffixVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.communication.advaffix.AdvaffixDBParam;
import com.gmcc.pboss.control.communication.advaffix.Advaffix ;

/**
 * <p>Title: AdvaffixAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AdvaffixAction extends BaseAction{
	
	public AdvaffixAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new AdvaffixForm());
		this.setParam(new AdvaffixWebParam());

        //指定VO类
        setClsVO(AdvaffixVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"affixid"};
		this.setClsControl(Advaffix.class);
		this.setClsQueryParam(AdvaffixDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}