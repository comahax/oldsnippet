/**
 * auto-generated code
 * Thu Jul 08 10:32:29 CST 2010
 */
 package com.gmcc.pboss.web.sales.limitsetlog;

import com.gmcc.pboss.business.sales.limitsetlog.LimitsetlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.limitsetlog.LimitsetlogDBParam;
import com.gmcc.pboss.control.sales.limitsetlog.Limitsetlog ;

/**
 * <p>Title: LimitsetlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class LimitsetlogAction extends BaseAction{
	
	public LimitsetlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new LimitsetlogForm());
		this.setParam(new LimitsetlogDBParam());

        //指定VO类
        setClsVO(LimitsetlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Limitsetlog.class);
		this.setClsQueryParam(LimitsetlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}