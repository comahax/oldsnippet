/**
 * auto-generated code
 * Wed Oct 07 14:01:03 CST 2009
 */
 package com.gmcc.pboss.web.channel.fdaudit;

import com.gmcc.pboss.business.channel.fdaudit.FdauditVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.fdaudit.FdauditDBParam;
import com.gmcc.pboss.control.channel.fdaudit.Fdaudit ;

/**
 * <p>Title: FdauditAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class FdauditAction extends BaseAction{
	
	public FdauditAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new FdauditForm());
		this.setParam(new FdauditWebParam());

        //指定VO类
        setClsVO(FdauditVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recno"};
		this.setClsControl(Fdaudit.class);
		this.setClsQueryParam(FdauditDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}