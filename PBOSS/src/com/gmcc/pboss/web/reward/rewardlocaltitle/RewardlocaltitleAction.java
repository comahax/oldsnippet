/**
 * auto-generated code
 * Wed Jul 28 14:27:43 CST 2010
 */
 package com.gmcc.pboss.web.reward.rewardlocaltitle;

import com.gmcc.pboss.business.reward.rewardlocaltitle.RewardlocaltitleVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.reward.rewardlocaltitle.RewardlocaltitleDBParam;
import com.gmcc.pboss.control.reward.rewardlocaltitle.Rewardlocaltitle ;

/**
 * <p>Title: RewardlocaltitleAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class RewardlocaltitleAction extends BaseAction{
	
	public RewardlocaltitleAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new RewardlocaltitleForm());
		this.setParam(new RewardlocaltitleWebParam());

        //指定VO类
        setClsVO(RewardlocaltitleVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"rewardmonth","rpttype"};
		this.setClsControl(Rewardlocaltitle.class);
		this.setClsQueryParam(RewardlocaltitleDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}