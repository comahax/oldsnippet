/**
 * auto-generated code
 * Fri Mar 04 17:20:29 CST 2011
 */
 package com.gmcc.pboss.web.channel.emodconfirm;

import com.gmcc.pboss.business.channel.emodconfirm.EmodconfirmVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.emodconfirm.EmodconfirmDBParam;
import com.gmcc.pboss.control.channel.emodconfirm.Emodconfirm ;

/**
 * <p>Title: EmodconfirmAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmodconfirmAction extends BaseAction{
	
	public EmodconfirmAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new EmodconfirmForm());
		this.setParam(new EmodconfirmDBParam());

        //指定VO类
        setClsVO(EmodconfirmVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"confirmid"};
		this.setClsControl(Emodconfirm.class);
		this.setClsQueryParam(EmodconfirmDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}