/**
 * auto-generated code
 * Mon Dec 21 09:17:48 CST 2009
 */
 package com.gmcc.pboss.web.base.smstmpllog;

import com.gmcc.pboss.business.base.smstmpllog.SmstmpllogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.smstmpllog.SmstmpllogDBParam;
import com.gmcc.pboss.control.base.smstmpllog.Smstmpllog ;

/**
 * <p>Title: SmstmpllogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SmstmpllogAction extends BaseAction{
	
	public SmstmpllogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SmstmpllogForm());
		this.setParam(new SmstmpllogDBParam());

        //指定VO类
        setClsVO(SmstmpllogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Smstmpllog.class);
		this.setClsQueryParam(SmstmpllogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}