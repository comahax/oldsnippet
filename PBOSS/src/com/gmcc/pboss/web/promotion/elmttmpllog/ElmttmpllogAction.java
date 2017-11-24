/**
 * auto-generated code
 * Mon Sep 14 14:23:48 CST 2009
 */
 package com.gmcc.pboss.web.promotion.elmttmpllog;

import com.gmcc.pboss.business.promotion.elmttmpllog.ElmttmpllogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.elmttmpllog.ElmttmpllogDBParam;
import com.gmcc.pboss.control.promotion.elmttmpllog.Elmttmpllog ;

/**
 * <p>Title: ElmttmpllogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
public class ElmttmpllogAction extends BaseAction{
	
	public ElmttmpllogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ElmttmpllogForm());
		this.setParam(new ElmttmpllogWebParam());

        //指定VO类
        setClsVO(ElmttmpllogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Elmttmpllog.class);
		this.setClsQueryParam(ElmttmpllogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}