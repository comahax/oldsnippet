/**
 * auto-generated code
 * Wed Oct 07 13:35:00 CST 2009
 */
 package com.gmcc.pboss.web.channel.cooperator;

import com.gmcc.pboss.business.channel.cooperator.CooperatorVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.cooperator.CooperatorDBParam;
import com.gmcc.pboss.control.channel.cooperator.Cooperator ;

/**
 * <p>Title: CooperatorAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class CooperatorAction extends BaseAction{
	
	public CooperatorAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new CooperatorForm());
		this.setParam(new CooperatorWebParam());

        //指定VO类
        setClsVO(CooperatorVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"cooperauid"};
		this.setClsControl(Cooperator.class);
		this.setClsQueryParam(CooperatorDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}