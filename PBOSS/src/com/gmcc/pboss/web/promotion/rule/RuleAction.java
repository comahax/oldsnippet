/**
 * auto-generated code
 * Thu Sep 17 14:50:45 CST 2009
 */
 package com.gmcc.pboss.web.promotion.rule;

import com.gmcc.pboss.business.promotion.rule.RuleVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.rule.RuleDBParam;
import com.gmcc.pboss.control.promotion.rule.Rule ;

/**
 * <p>Title: RuleAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleAction extends BaseAction{
	
	public RuleAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new RuleForm());
		this.setParam(new RuleWebParam());

        //ָ��VO��
        setClsVO(RuleVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"ruleid"};
		this.setClsControl(Rule.class);
		this.setClsQueryParam(RuleDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}