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

		//���¼��������Ǳ����
		this.setForm(new RewardstdlogForm());
		this.setParam(new RewardstdlogWebParam());

        //ָ��VO��
        setClsVO(RewardstdlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Rewardstdlog.class);
		this.setClsQueryParam(RewardstdlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}