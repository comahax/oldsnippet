/**
 * auto-generated code
 * Thu Jan 26 11:27:21 CST 2012
 */
 package com.gmcc.pboss.web.sales.sellnoticelog;

import com.gmcc.pboss.business.sales.sellnoticelog.SellnoticelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.sellnoticelog.SellnoticelogDBParam;
import com.gmcc.pboss.control.sales.sellnoticelog.Sellnoticelog ;

/**
 * <p>Title: SellnoticelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class SellnoticelogAction extends BaseAction{
	
	public SellnoticelogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SellnoticelogForm());
		this.setParam(new SellnoticelogDBParam());

        //指定VO类
        setClsVO(SellnoticelogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Sellnoticelog.class);
		this.setClsQueryParam(SellnoticelogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}