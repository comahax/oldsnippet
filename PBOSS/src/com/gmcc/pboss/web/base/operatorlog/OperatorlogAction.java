/**
 * auto-generated code
 * Tue Sep 08 09:43:07 CST 2009
 */
 package com.gmcc.pboss.web.base.operatorlog;

import com.gmcc.pboss.business.base.operatorlog.OperatorlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.operatorlog.OperatorlogDBParam;
import com.gmcc.pboss.control.base.operatorlog.Operatorlog ;

/**
 * <p>Title: OperatorlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OperatorlogAction extends BaseAction{
	
	public OperatorlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OperatorlogForm());
		this.setParam(new OperatorlogWebParam());

        //指定VO类
        setClsVO(OperatorlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Operatorlog.class);
		this.setClsQueryParam(OperatorlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}