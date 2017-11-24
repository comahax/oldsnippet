/**
 * auto-generated code
 * Thu Dec 09 16:37:06 CST 2010
 */
 package com.gmcc.pboss.web.base.webfunctionitemlog;

import com.gmcc.pboss.business.base.webfunctionitemlog.WebfunctionitemlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.webfunctionitemlog.WebfunctionitemlogDBParam;
import com.gmcc.pboss.control.base.webfunctionitemlog.Webfunctionitemlog ;

/**
 * <p>Title: WebfunctionitemlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class WebfunctionitemlogAction extends BaseAction{
	
	public WebfunctionitemlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new WebfunctionitemlogForm());
		this.setParam(new WebfunctionitemlogDBParam());

        //指定VO类
        setClsVO(WebfunctionitemlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Webfunctionitemlog.class);
		this.setClsQueryParam(WebfunctionitemlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}