/**
 * auto-generated code
 * Tue Jun 22 17:26:01 CST 2010
 */
 package com.gmcc.pboss.web.sales.stockalarmlog;

import com.gmcc.pboss.business.sales.stockalarmlog.StockalarmlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.stockalarmlog.StockalarmlogDBParam;
import com.gmcc.pboss.control.sales.stockalarmlog.Stockalarmlog ;

/**
 * <p>Title: StockalarmlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class StockalarmlogAction extends BaseAction{
	
	public StockalarmlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new StockalarmlogForm());
		this.setParam(new StockalarmlogDBParam());

        //指定VO类
        setClsVO(StockalarmlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Stockalarmlog.class);
		this.setClsQueryParam(StockalarmlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}