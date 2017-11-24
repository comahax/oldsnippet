/**
 * auto-generated code
 * Thu Apr 05 09:18:42 CST 2012
 */
 package com.gmcc.pboss.web.sales.simrealtimeamt;

import com.gmcc.pboss.business.sales.simrealtimeamt.SimrealtimeamtVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.simrealtimeamt.SimrealtimeamtDBParam;
import com.gmcc.pboss.control.sales.simrealtimeamt.Simrealtimeamt ;

/**
 * <p>Title: SimrealtimeamtAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class SimrealtimeamtAction extends BaseAction{
	
	public SimrealtimeamtAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SimrealtimeamtForm());
		this.setParam(new SimrealtimeamtDBParam());

        //指定VO类
        setClsVO(SimrealtimeamtVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"wayid"};
		this.setClsControl(Simrealtimeamt.class);
		this.setClsQueryParam(SimrealtimeamtDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}