/**
 * auto-generated code
 * Mon Sep 14 17:09:44 CST 2009
 */
 package com.gmcc.pboss.web.promotion.presentingalog;

import com.gmcc.pboss.business.promotion.presentingalog.PresentingalogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.presentingalog.PresentingalogDBParam;
import com.gmcc.pboss.control.promotion.presentingalog.Presentingalog ;

/**
 * <p>Title: PresentingalogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class PresentingalogAction extends BaseAction{
	
	public PresentingalogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new PresentingalogForm());
		this.setParam(new PresentingalogWebParam());

        //ָ��VO��
        setClsVO(PresentingalogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Presentingalog.class);
		this.setClsQueryParam(PresentingalogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}