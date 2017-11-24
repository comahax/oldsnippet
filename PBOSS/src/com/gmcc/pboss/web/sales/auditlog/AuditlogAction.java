/**
 * auto-generated code
 * Tue Aug 03 15:52:05 CST 2010
 */
 package com.gmcc.pboss.web.sales.auditlog;

import com.gmcc.pboss.business.sales.auditlog.AuditlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.auditlog.AuditlogDBParam;
import com.gmcc.pboss.control.sales.auditlog.Auditlog ;

/**
 * <p>Title: AuditlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AuditlogAction extends BaseAction{
	
	public AuditlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new AuditlogForm());
		this.setParam(new AuditlogWebParam());

        //指定VO类
        setClsVO(AuditlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Auditlog.class);
		this.setClsQueryParam(AuditlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}