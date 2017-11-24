/**
 * auto-generated code
 * Wed Nov 14 09:58:49 CST 2012
 */
 package com.gmcc.pboss.web.channel.waybusicircle;

import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleDBParam;
import com.gmcc.pboss.control.channel.waybusicircle.Waybusicircle ;

/**
 * <p>Title: WaybusicircleAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class WaybusicircleAction extends BaseAction{
	
	public WaybusicircleAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new WaybusicircleForm());
		this.setParam(new WaybusicircleDBParam());

        //指定VO类
        setClsVO(WaybusicircleVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seq"};
		this.setClsControl(Waybusicircle.class);
		this.setClsQueryParam(WaybusicircleDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}