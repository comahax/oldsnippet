/**
 * auto-generated code
 * Thu Sep 17 14:55:03 CST 2009
 */
 package com.gmcc.pboss.web.promotion.ruleitemlog;

import com.gmcc.pboss.business.promotion.ruleitemlog.RuleitemlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.ruleitemlog.RuleitemlogDBParam;
import com.gmcc.pboss.control.promotion.ruleitemlog.Ruleitemlog ;

/**
 * <p>Title: RuleitemlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleitemlogAction extends BaseAction{
	
	public RuleitemlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new RuleitemlogForm());
		this.setParam(new RuleitemlogWebParam());

        //ָ��VO��
        setClsVO(RuleitemlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Ruleitemlog.class);
		this.setClsQueryParam(RuleitemlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}