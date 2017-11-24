/**
 * auto-generated code
 * Thu Sep 17 15:13:36 CST 2009
 */
 package com.gmcc.pboss.web.promotion.ppzlnrulelog;

import com.gmcc.pboss.business.promotion.ppzlnrulelog.PpzlnrulelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.ppzlnrulelog.PpzlnrulelogDBParam;
import com.gmcc.pboss.control.promotion.ppzlnrulelog.Ppzlnrulelog ;

/**
 * <p>Title: PpzlnrulelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class PpzlnrulelogAction extends BaseAction{
	
	public PpzlnrulelogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new PpzlnrulelogForm());
		this.setParam(new PpzlnrulelogWebParam());

        //指定VO类
        setClsVO(PpzlnrulelogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Ppzlnrulelog.class);
		this.setClsQueryParam(PpzlnrulelogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}