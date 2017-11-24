/**
 * auto-generated code
 * Wed Nov 14 09:58:01 CST 2012
 */
 package com.gmcc.pboss.web.channel.busicirclelog;

import com.gmcc.pboss.business.channel.busicirclelog.BusicirclelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.busicirclelog.BusicirclelogDBParam;
import com.gmcc.pboss.control.channel.busicirclelog.Busicirclelog ;

/**
 * <p>Title: BusicirclelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class BusicirclelogAction extends BaseAction{
	
	public BusicirclelogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new BusicirclelogForm());
		this.setParam(new BusicirclelogDBParam());

        //指定VO类
        setClsVO(BusicirclelogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Busicirclelog.class);
		this.setClsQueryParam(BusicirclelogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}