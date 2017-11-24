/**
 * auto-generated code
 * Fri Dec 17 11:26:27 CST 2010
 */
 package com.gmcc.pboss.web.sales.auditdet;

import com.gmcc.pboss.business.sales.auditdet.AuditdetVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.auditdet.AuditdetDBParam;
import com.gmcc.pboss.control.sales.auditdet.Auditdet ;

/**
 * <p>Title: AuditdetAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class AuditdetAction extends BaseAction{
	
	public AuditdetAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new AuditdetForm());
		this.setParam(new AuditdetDBParam());

        //指定VO类
        setClsVO(AuditdetVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"auditseq","recid"};
		this.setClsControl(Auditdet.class);
		this.setClsQueryParam(AuditdetDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}