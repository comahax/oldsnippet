/**
 * auto-generated code
 * Wed Jul 28 14:29:18 CST 2010
 */
 package com.gmcc.pboss.web.reward.rewardlocaldtl;

import com.gmcc.pboss.business.reward.rewardlocaldtl.RewardlocaldtlVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.reward.rewardlocaldtl.RewardlocaldtlDBParam;
import com.gmcc.pboss.control.reward.rewardlocaldtl.Rewardlocaldtl ;

/**
 * <p>Title: RewardlocaldtlAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class RewardlocaldtlAction extends BaseAction{
	
	public RewardlocaldtlAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new RewardlocaldtlForm());
		this.setParam(new RewardlocaldtlWebParam());

        //ָ��VO��
        setClsVO(RewardlocaldtlVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"rewardmonth"};
		this.setClsControl(Rewardlocaldtl.class);
		this.setClsQueryParam(RewardlocaldtlDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}