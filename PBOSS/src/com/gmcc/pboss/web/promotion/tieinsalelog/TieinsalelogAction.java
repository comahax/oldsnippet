/**
 * auto-generated code
 * Mon Sep 14 17:03:36 CST 2009
 */
 package com.gmcc.pboss.web.promotion.tieinsalelog;

import com.gmcc.pboss.business.promotion.tieinsalelog.TieinsalelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.tieinsalelog.TieinsalelogDBParam;
import com.gmcc.pboss.control.promotion.tieinsalelog.Tieinsalelog ;

/**
 * <p>Title: TieinsalelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class TieinsalelogAction extends BaseAction{
	
	public TieinsalelogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new TieinsalelogForm());
		this.setParam(new TieinsalelogWebParam());

        //指定VO类
        setClsVO(TieinsalelogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Tieinsalelog.class);
		this.setClsQueryParam(TieinsalelogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}