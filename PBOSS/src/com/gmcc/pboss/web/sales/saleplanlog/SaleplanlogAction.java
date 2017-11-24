/**
 * auto-generated code
 * Tue Nov 08 14:10:56 CST 2011
 */
 package com.gmcc.pboss.web.sales.saleplanlog;

import com.gmcc.pboss.business.sales.saleplanlog.SaleplanlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.saleplanlog.SaleplanlogDBParam;
import com.gmcc.pboss.control.sales.saleplanlog.Saleplanlog ;

/**
 * <p>Title: SaleplanlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SaleplanlogAction extends BaseAction{
	
	public SaleplanlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SaleplanlogForm());
		this.setParam(new SaleplanlogDBParam());

        //指定VO类
        setClsVO(SaleplanlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Saleplanlog.class);
		this.setClsQueryParam(SaleplanlogDBParam.class) ;

	}
}