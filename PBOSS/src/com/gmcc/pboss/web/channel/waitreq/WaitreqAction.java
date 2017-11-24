/**
 * auto-generated code
 * Wed Nov 18 16:14:43 CST 2009
 */
 package com.gmcc.pboss.web.channel.waitreq;

import com.gmcc.pboss.business.channel.waitreq.WaitreqVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.waitreq.WaitreqDBParam;
import com.gmcc.pboss.control.channel.waitreq.Waitreq ;

/**
 * <p>Title: WaitreqAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WaitreqAction extends BaseAction{
	
	public WaitreqAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new WaitreqForm());
		this.setParam(new WaitreqDBParam());

        //指定VO类
        setClsVO(WaitreqVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"streamno"};
		this.setClsControl(Waitreq.class);
		this.setClsQueryParam(WaitreqDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}