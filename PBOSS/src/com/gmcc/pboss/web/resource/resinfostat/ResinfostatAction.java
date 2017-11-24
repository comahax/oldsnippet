/**
 * auto-generated code
 * Mon Aug 16 15:40:34 CST 2010
 */
 package com.gmcc.pboss.web.resource.resinfostat;

import com.gmcc.pboss.business.resource.resinfostat.ResinfostatVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.resinfostat.ResinfostatDBParam;
import com.gmcc.pboss.control.resource.resinfostat.Resinfostat ;

/**
 * <p>Title: ResinfostatAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zhangsiwei
 * @version 1.0
 */
public class ResinfostatAction extends BaseAction{
	
	public ResinfostatAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ResinfostatForm());
		this.setParam(new ResinfostatDBParam());

        //指定VO类
        setClsVO(ResinfostatVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"brand","statdate","wayid"};
		this.setClsControl(Resinfostat.class);
		this.setClsQueryParam(ResinfostatDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}