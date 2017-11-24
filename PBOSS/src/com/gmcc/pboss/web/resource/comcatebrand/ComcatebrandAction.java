/**
 * auto-generated code
 * Sat Aug 13 11:12:29 CST 2011
 */
 package com.gmcc.pboss.web.resource.comcatebrand;

import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandDBParam;
import com.gmcc.pboss.control.resource.comcatebrand.Comcatebrand ;

/**
 * <p>Title: ComcatebrandAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class ComcatebrandAction extends BaseAction{
	
	public ComcatebrandAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ComcatebrandForm());
		this.setParam(new ComcatebrandDBParam());

        //指定VO类
        setClsVO(ComcatebrandVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"comcategory"};
		this.setClsControl(Comcatebrand.class);
		this.setClsQueryParam(ComcatebrandDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}