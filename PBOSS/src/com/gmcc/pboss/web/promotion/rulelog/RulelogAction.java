/**
 * auto-generated code
 * Thu Sep 17 14:57:06 CST 2009
 */
 package com.gmcc.pboss.web.promotion.rulelog;

import com.gmcc.pboss.business.promotion.rulelog.RulelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.rulelog.RulelogDBParam;
import com.gmcc.pboss.control.promotion.rulelog.Rulelog ;

/**
 * <p>Title: RulelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RulelogAction extends BaseAction{
	
	public RulelogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new RulelogForm());
		this.setParam(new RulelogWebParam());

        //ָ��VO��
        setClsVO(RulelogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Rulelog.class);
		this.setClsQueryParam(RulelogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}