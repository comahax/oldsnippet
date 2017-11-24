/**
 * auto-generated code
 * Tue Jul 05 10:51:39 CST 2011
 */
 package com.gmcc.pboss.web.base.smsobjectlog;

import com.gmcc.pboss.business.base.smsobjectlog.SmsobjectlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.smsobjectlog.SmsobjectlogDBParam;
import com.gmcc.pboss.control.base.smsobjectlog.Smsobjectlog ;

/**
 * <p>Title: SmsobjectlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public class SmsobjectlogAction extends BaseAction{
	
	public SmsobjectlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SmsobjectlogForm());
		this.setParam(new SmsobjectlogDBParam());

        //指定VO类
        setClsVO(SmsobjectlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Smsobjectlog.class);
		this.setClsQueryParam(SmsobjectlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}