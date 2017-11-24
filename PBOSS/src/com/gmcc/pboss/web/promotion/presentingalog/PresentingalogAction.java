/**
 * auto-generated code
 * Mon Sep 14 17:09:44 CST 2009
 */
 package com.gmcc.pboss.web.promotion.presentingalog;

import com.gmcc.pboss.business.promotion.presentingalog.PresentingalogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.presentingalog.PresentingalogDBParam;
import com.gmcc.pboss.control.promotion.presentingalog.Presentingalog ;

/**
 * <p>Title: PresentingalogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class PresentingalogAction extends BaseAction{
	
	public PresentingalogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new PresentingalogForm());
		this.setParam(new PresentingalogWebParam());

        //指定VO类
        setClsVO(PresentingalogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Presentingalog.class);
		this.setClsQueryParam(PresentingalogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}