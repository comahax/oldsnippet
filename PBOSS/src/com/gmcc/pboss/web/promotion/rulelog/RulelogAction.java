/**
 * auto-generated code
 * Thu Sep 17 14:57:06 CST 2009
 */
 package com.gmcc.pboss.web.promotion.rulelog;

import com.gmcc.pboss.business.promotion.rulelog.RulelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.rulelog.RulelogDBParam;
import com.gmcc.pboss.control.promotion.rulelog.Rulelog ;

/**
 * <p>Title: RulelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RulelogAction extends BaseAction{
	
	public RulelogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new RulelogForm());
		this.setParam(new RulelogWebParam());

        //指定VO类
        setClsVO(RulelogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Rulelog.class);
		this.setClsQueryParam(RulelogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}