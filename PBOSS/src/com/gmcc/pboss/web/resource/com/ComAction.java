/**
 * auto-generated code
 * Sat Sep 05 11:44:39 CST 2009
 */
 package com.gmcc.pboss.web.resource.com;

import com.gmcc.pboss.business.resource.com.ComVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.com.ComDBParam;
import com.gmcc.pboss.control.resource.com.Com ;

/**
 * <p>Title: ComAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComAction extends BaseAction{
	
	public ComAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ComForm());
		this.setParam(new ComWebParam());

        //ָ��VO��
        setClsVO(ComVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"comid"};
		this.setClsControl(Com.class);
		this.setClsQueryParam(ComDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	//��������ʶ��
	public String doPhoneType(){
		return "phonetype";
	}
}