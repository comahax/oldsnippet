/**
 * auto-generated code
 * Thu Feb 24 16:49:38 CST 2011
 */
 package com.gmcc.pboss.web.channel.smslog;

import com.gmcc.pboss.business.channel.smslog.SmslogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.smslog.SmslogDBParam;
import com.gmcc.pboss.control.channel.smslog.Smslog ;

/**
 * <p>Title: SmslogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class SmslogAction extends BaseAction{
	
	public SmslogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SmslogForm());
		this.setParam(new SmslogDBParam());

        //指定VO类
        setClsVO(SmslogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Smslog.class);
		this.setClsQueryParam(SmslogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}