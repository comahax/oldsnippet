/**
 * auto-generated code
 * Thu Feb 24 16:50:49 CST 2011
 */
 package com.gmcc.pboss.web.channel.smsloghis;

import com.gmcc.pboss.business.channel.smsloghis.SmsloghisVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.smsloghis.SmsloghisDBParam;
import com.gmcc.pboss.control.channel.smsloghis.Smsloghis ;

/**
 * <p>Title: SmsloghisAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class SmsloghisAction extends BaseAction{
	
	public SmsloghisAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SmsloghisForm());
		this.setParam(new SmsloghisDBParam());

        //指定VO类
        setClsVO(SmsloghisVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Smsloghis.class);
		this.setClsQueryParam(SmsloghisDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}