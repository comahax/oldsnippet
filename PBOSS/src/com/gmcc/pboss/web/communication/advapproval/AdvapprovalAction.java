/**
 * auto-generated code
 * Tue Sep 29 10:24:36 CST 2009
 */
 package com.gmcc.pboss.web.communication.advapproval;

import com.gmcc.pboss.business.communication.advapproval.AdvapprovalVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.communication.advapproval.AdvapprovalDBParam;
import com.gmcc.pboss.control.communication.advapproval.Advapproval ;

/**
 * <p>Title: AdvapprovalAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AdvapprovalAction extends BaseAction{
	
	public AdvapprovalAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new AdvapprovalForm());
		this.setParam(new AdvapprovalWebParam());

        //指定VO类
        setClsVO(AdvapprovalVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"approvalid"};
		this.setClsControl(Advapproval.class);
		this.setClsQueryParam(AdvapprovalDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}