/**
 * auto-generated code
 * Wed Oct 21 19:54:26 CST 2009
 */
 package com.gmcc.pboss.web.channel.custwaytype;

import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeDBParam;
import com.gmcc.pboss.control.channel.custwaytype.Custwaytype ;

/**
 * <p>Title: CustwaytypeAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CustwaytypeAction extends BaseAction{
	
	public CustwaytypeAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new CustwaytypeForm());
		this.setParam(new CustwaytypeWebParam());

        //指定VO类
        setClsVO(CustwaytypeVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"citycompid","custwaytypecode"};
		this.setClsControl(Custwaytype.class);
		this.setClsQueryParam(CustwaytypeDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}