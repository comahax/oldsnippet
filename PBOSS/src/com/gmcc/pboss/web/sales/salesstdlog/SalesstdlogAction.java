/**
 * auto-generated code
 * Wed Oct 26 09:57:14 CST 2011
 */
 package com.gmcc.pboss.web.sales.salesstdlog;

import com.gmcc.pboss.business.sales.salesstdlog.SalesstdlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.salesstdlog.SalesstdlogDBParam;
import com.gmcc.pboss.control.sales.salesstdlog.Salesstdlog ;

/**
 * <p>Title: SalesstdlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SalesstdlogAction extends BaseAction{
	
	public SalesstdlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SalesstdlogForm());
		this.setParam(new SalesstdlogDBParam());

        //指定VO类
        setClsVO(SalesstdlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Salesstdlog.class);
		this.setClsQueryParam(SalesstdlogDBParam.class) ;

	}
}