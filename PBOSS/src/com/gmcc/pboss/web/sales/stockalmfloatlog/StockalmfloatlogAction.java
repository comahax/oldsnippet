/**
 * auto-generated code
 * Sun May 22 15:20:29 GMT 2011
 */
 package com.gmcc.pboss.web.sales.stockalmfloatlog;

import com.gmcc.pboss.business.sales.stockalmfloatlog.StockalmfloatlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.stockalmfloatlog.StockalmfloatlogDBParam;
import com.gmcc.pboss.control.sales.stockalmfloatlog.Stockalmfloatlog ;

/**
 * <p>Title: StockalmfloatlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class StockalmfloatlogAction extends BaseAction{
	
	public StockalmfloatlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new StockalmfloatlogForm());
		this.setParam(new StockalmfloatlogDBParam());

        //指定VO类
        setClsVO(StockalmfloatlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Stockalmfloatlog.class);
		this.setClsQueryParam(StockalmfloatlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}