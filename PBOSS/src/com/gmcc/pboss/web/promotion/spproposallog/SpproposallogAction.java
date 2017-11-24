/**
 * auto-generated code
 * Thu Sep 17 14:53:18 CST 2009
 */
 package com.gmcc.pboss.web.promotion.spproposallog;

import com.gmcc.pboss.business.promotion.spproposallog.SpproposallogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.spproposallog.SpproposallogDBParam;
import com.gmcc.pboss.control.promotion.spproposallog.Spproposallog ;

/**
 * <p>Title: SpproposallogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SpproposallogAction extends BaseAction{
	
	public SpproposallogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SpproposallogForm());
		this.setParam(new SpproposallogWebParam());

        //指定VO类
        setClsVO(SpproposallogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Spproposallog.class);
		this.setClsQueryParam(SpproposallogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}