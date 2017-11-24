/**
 * auto-generated code
 * Sun Sep 13 11:05:37 CST 2009
 */
 package com.gmcc.pboss.web.channel.microarea;

import com.gmcc.pboss.business.channel.microarea.MicroareaVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.microarea.MicroareaDBParam;
import com.gmcc.pboss.control.channel.microarea.Microarea ;

/**
 * <p>Title: MicroareaAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class MicroareaAction extends BaseAction{
	
	public MicroareaAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new MicroareaForm());
		this.setParam(new MicroareaWebParam());

        //指定VO类
        setClsVO(MicroareaVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"macode","maname","svccode"};
		this.setClsControl(Microarea.class);
		this.setClsQueryParam(MicroareaDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}