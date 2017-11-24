/**
 * auto-generated code
 * Thu Sep 17 15:15:04 CST 2009
 */
 package com.gmcc.pboss.web.promotion.ppzlnptnrlog;

import com.gmcc.pboss.business.promotion.ppzlnptnrlog.PpzlnptnrlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.ppzlnptnrlog.PpzlnptnrlogDBParam;
import com.gmcc.pboss.control.promotion.ppzlnptnrlog.Ppzlnptnrlog ;

/**
 * <p>Title: PpzlnptnrlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class PpzlnptnrlogAction extends BaseAction{
	
	public PpzlnptnrlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new PpzlnptnrlogForm());
		this.setParam(new PpzlnptnrlogWebParam());

        //指定VO类
        setClsVO(PpzlnptnrlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Ppzlnptnrlog.class);
		this.setClsQueryParam(PpzlnptnrlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}