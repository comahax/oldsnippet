/**
 * auto-generated code
 * Mon Sep 14 16:45:04 CST 2009
 */
 package com.gmcc.pboss.web.promotion.pquantitylog;

import com.gmcc.pboss.business.promotion.pquantitylog.PquantitylogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.pquantitylog.PquantitylogDBParam;
import com.gmcc.pboss.control.promotion.pquantitylog.Pquantitylog ;

/**
 * <p>Title: PquantitylogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class PquantitylogAction extends BaseAction{
	
	public PquantitylogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new PquantitylogForm());
		this.setParam(new PquantitylogWebParam());

        //指定VO类
        setClsVO(PquantitylogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Pquantitylog.class);
		this.setClsQueryParam(PquantitylogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}