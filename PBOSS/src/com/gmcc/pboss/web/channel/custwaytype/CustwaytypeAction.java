/**
 * auto-generated code
 * Wed Oct 21 19:54:26 CST 2009
 */
 package com.gmcc.pboss.web.channel.custwaytype;

import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeDBParam;
import com.gmcc.pboss.control.channel.custwaytype.Custwaytype ;

/**
 * <p>Title: CustwaytypeAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CustwaytypeAction extends BaseAction{
	
	public CustwaytypeAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new CustwaytypeForm());
		this.setParam(new CustwaytypeWebParam());

        //ָ��VO��
        setClsVO(CustwaytypeVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"citycompid","custwaytypecode"};
		this.setClsControl(Custwaytype.class);
		this.setClsQueryParam(CustwaytypeDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}