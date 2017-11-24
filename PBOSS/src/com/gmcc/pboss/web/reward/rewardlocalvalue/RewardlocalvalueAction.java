/**
 * auto-generated code
 * Wed Jul 28 14:30:16 CST 2010
 */
 package com.gmcc.pboss.web.reward.rewardlocalvalue;

import com.gmcc.pboss.business.reward.rewardlocalvalue.RewardlocalvalueVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.reward.rewardlocalvalue.RewardlocalvalueDBParam;
import com.gmcc.pboss.control.reward.rewardlocalvalue.Rewardlocalvalue ;

/**
 * <p>Title: RewardlocalvalueAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class RewardlocalvalueAction extends BaseAction{
	
	public RewardlocalvalueAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new RewardlocalvalueForm());
		this.setParam(new RewardlocalvalueWebParam());

        //指定VO类
        setClsVO(RewardlocalvalueVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"mstid","seq"};
		this.setClsControl(Rewardlocalvalue.class);
		this.setClsQueryParam(RewardlocalvalueDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}