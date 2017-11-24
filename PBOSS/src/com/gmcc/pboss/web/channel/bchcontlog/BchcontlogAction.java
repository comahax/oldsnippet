/**
 * auto-generated code
 * Sun Oct 18 20:53:55 CST 2009
 */
 package com.gmcc.pboss.web.channel.bchcontlog;

import com.gmcc.pboss.business.channel.bchcontlog.BchcontlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.bchcontlog.BchcontlogDBParam;
import com.gmcc.pboss.control.channel.bchcontlog.Bchcontlog ;

/**
 * <p>Title: BchcontlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class BchcontlogAction extends BaseAction{
	
	public BchcontlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new BchcontlogForm());
		this.setParam(new BchcontlogWebParam());

        //指定VO类
        setClsVO(BchcontlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Bchcontlog.class);
		this.setClsQueryParam(BchcontlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}