/**
 * auto-generated code
 * Wed Apr 28 13:14:56 CST 2010
 */
 package com.gmcc.pboss.web.sales.adpaydet;

import com.gmcc.pboss.business.sales.adpaydet.AdpaydetVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.adpaydet.AdpaydetDBParam;
import com.gmcc.pboss.control.sales.adpaydet.Adpaydet ;

/**
 * <p>Title: AdpaydetAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zsw
 * @version 1.0
 */
public class AdpaydetAction extends BaseAction{
	
	public AdpaydetAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new AdpaydetForm());
		this.setParam(new AdpaydetDBParam());

        //ָ��VO��
        setClsVO(AdpaydetVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"orderid","sumid"};
		this.setClsControl(Adpaydet.class);
		this.setClsQueryParam(AdpaydetDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}