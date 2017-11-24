/**
 * auto-generated code
 * Mon Sep 14 16:40:25 CST 2009
 */
 package com.gmcc.pboss.web.promotion.rewardstdlog;

import com.gmcc.pboss.business.promotion.rewardstdlog.RewardstdlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.rewardstdlog.RewardstdlogDBParam;
import com.gmcc.pboss.control.promotion.rewardstdlog.Rewardstdlog ;

/**
 * <p>Title: RewardstdlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class RewardstdlogAction extends BaseAction{
	
	public RewardstdlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new RewardstdlogForm());
		this.setParam(new RewardstdlogWebParam());

        //指定VO类
        setClsVO(RewardstdlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Rewardstdlog.class);
		this.setClsQueryParam(RewardstdlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}