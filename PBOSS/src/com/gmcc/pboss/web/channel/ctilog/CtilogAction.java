/**
 * auto-generated code
 * Thu Dec 01 02:07:15 GMT 2011
 */
 package com.gmcc.pboss.web.channel.ctilog;

import com.gmcc.pboss.business.channel.ctilog.CtilogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.ctilog.CtilogDBParam;
import com.gmcc.pboss.control.channel.ctilog.Ctilog ;

/**
 * <p>Title: CtilogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class CtilogAction extends BaseAction{
	
	public CtilogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new CtilogForm());
		this.setParam(new CtilogDBParam());

        //指定VO类
        setClsVO(CtilogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Ctilog.class);
		this.setClsQueryParam(CtilogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}