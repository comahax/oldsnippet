/**
 * auto-generated code
 * Thu Dec 01 02:42:27 GMT 2011
 */
 package com.gmcc.pboss.web.channel.waitchange;

import com.gmcc.pboss.business.channel.waitchange.WaitchangeVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.waitchange.WaitchangeDBParam;
import com.gmcc.pboss.control.channel.waitchange.Waitchange ;

/**
 * <p>Title: WaitchangeAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class WaitchangeAction extends BaseAction{
	
	public WaitchangeAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new WaitchangeForm());
		this.setParam(new WaitchangeDBParam());

        //指定VO类
        setClsVO(WaitchangeVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"streamno"};
		this.setClsControl(Waitchange.class);
		this.setClsQueryParam(WaitchangeDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}