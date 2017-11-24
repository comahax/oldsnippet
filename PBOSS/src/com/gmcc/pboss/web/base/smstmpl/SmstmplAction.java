/**
 * auto-generated code
 * Mon Dec 21 09:15:59 CST 2009
 */
 package com.gmcc.pboss.web.base.smstmpl;

import com.gmcc.pboss.business.base.smstmpl.SmstmplDBParam;
import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: SmstmplAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SmstmplAction extends BaseAction{
	
	public SmstmplAction(){
		super();

		//以下几个方法是必须的
		this.setForm(new SmstmplForm());
		this.setParam(new SmstmplDBParam());

        //指定VO类
        setClsVO(SmstmplVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"sid"};
		this.setClsControl(Smstmpl.class);
		this.setClsQueryParam(SmstmplDBParam.class) ;
		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}