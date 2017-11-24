/**
 * auto-generated code
 * Wed Apr 28 13:14:56 CST 2010
 */
 package com.gmcc.pboss.web.sales.adpaydet;

import com.gmcc.pboss.business.sales.adpaydet.AdpaydetVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.adpaydet.AdpaydetDBParam;
import com.gmcc.pboss.control.sales.adpaydet.Adpaydet ;

/**
 * <p>Title: AdpaydetAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zsw
 * @version 1.0
 */
public class AdpaydetAction extends BaseAction{
	
	public AdpaydetAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new AdpaydetForm());
		this.setParam(new AdpaydetDBParam());

        //指定VO类
        setClsVO(AdpaydetVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"orderid","sumid"};
		this.setClsControl(Adpaydet.class);
		this.setClsQueryParam(AdpaydetDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}