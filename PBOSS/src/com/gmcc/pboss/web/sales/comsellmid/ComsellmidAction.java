/**
 * auto-generated code
 * Mon Nov 23 16:57:18 CST 2009
 */
 package com.gmcc.pboss.web.sales.comsellmid;

import com.gmcc.pboss.business.sales.comsellmid.ComsellmidVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.comsellmid.ComsellmidDBParam;
import com.gmcc.pboss.control.sales.comsellmid.Comsellmid ;

/**
 * <p>Title: ComsellmidAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ComsellmidAction extends BaseAction{
	
	public ComsellmidAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ComsellmidForm());
		this.setParam(new ComsellmidDBParam());

        //指定VO类
        setClsVO(ComsellmidVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"orderid","recid"};
		this.setClsControl(Comsellmid.class);
		this.setClsQueryParam(ComsellmidDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}