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

		//���¼��������Ǳ����
		this.setForm(new RewardlocalvalueForm());
		this.setParam(new RewardlocalvalueWebParam());

        //ָ��VO��
        setClsVO(RewardlocalvalueVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"mstid","seq"};
		this.setClsControl(Rewardlocalvalue.class);
		this.setClsQueryParam(RewardlocalvalueDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}