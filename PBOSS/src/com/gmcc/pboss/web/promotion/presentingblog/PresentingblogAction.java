/**
 * auto-generated code
 * Mon Sep 14 17:08:10 CST 2009
 */
 package com.gmcc.pboss.web.promotion.presentingblog;

import com.gmcc.pboss.business.promotion.presentingblog.PresentingblogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.presentingblog.PresentingblogDBParam;
import com.gmcc.pboss.control.promotion.presentingblog.Presentingblog ;

/**
 * <p>Title: PresentingblogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class PresentingblogAction extends BaseAction{
	
	public PresentingblogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new PresentingblogForm());
		this.setParam(new PresentingblogWebParam());

        //ָ��VO��
        setClsVO(PresentingblogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Presentingblog.class);
		this.setClsQueryParam(PresentingblogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}