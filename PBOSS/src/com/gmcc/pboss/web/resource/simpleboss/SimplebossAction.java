/**
 * auto-generated code
 * Wed Sep 09 09:17:44 CST 2009
 */
 package com.gmcc.pboss.web.resource.simpleboss;

import com.gmcc.pboss.business.resource.simpleboss.SimplebossVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.simpleboss.SimplebossDBParam;
import com.gmcc.pboss.control.resource.simpleboss.Simpleboss ;

/**
 * <p>Title: SimplebossAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
public class SimplebossAction extends BaseAction{
	
	public SimplebossAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SimplebossForm());
		this.setParam(new SimplebossWebParam());

        //指定VO类
        setClsVO(SimplebossVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"cityid","wayid"};
		this.setClsControl(Simpleboss.class);
		this.setClsQueryParam(SimplebossDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}