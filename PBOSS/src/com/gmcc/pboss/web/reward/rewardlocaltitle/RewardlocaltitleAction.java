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

		//���¼��������Ǳ����
		this.setForm(new RewardlocaltitleForm());
		this.setParam(new RewardlocaltitleWebParam());

        //ָ��VO��
        setClsVO(RewardlocaltitleVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"rewardmonth","rpttype"};
		this.setClsControl(Rewardlocaltitle.class);
		this.setClsQueryParam(RewardlocaltitleDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}