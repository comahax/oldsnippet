/**
 * auto-generated code
 * Mon Sep 14 16:45:04 CST 2009
 */
 package com.gmcc.pboss.web.promotion.pquantitylog;

import com.gmcc.pboss.business.promotion.pquantitylog.PquantitylogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.pquantitylog.PquantitylogDBParam;
import com.gmcc.pboss.control.promotion.pquantitylog.Pquantitylog ;

/**
 * <p>Title: PquantitylogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class PquantitylogAction extends BaseAction{
	
	public PquantitylogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new PquantitylogForm());
		this.setParam(new PquantitylogWebParam());

        //ָ��VO��
        setClsVO(PquantitylogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Pquantitylog.class);
		this.setClsQueryParam(PquantitylogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}