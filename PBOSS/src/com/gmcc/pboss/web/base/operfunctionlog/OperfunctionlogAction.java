/**
 * auto-generated code
 * Mon Sep 07 10:51:00 CST 2009
 */
 package com.gmcc.pboss.web.base.operfunctionlog;

import com.gmcc.pboss.business.base.operfunctionlog.OperfunctionlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.operfunctionlog.OperfunctionlogDBParam;
import com.gmcc.pboss.control.base.operfunctionlog.Operfunctionlog ;

/**
 * <p>Title: OperfunctionlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OperfunctionlogAction extends BaseAction{
	
	public OperfunctionlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OperfunctionlogForm());
		this.setParam(new OperfunctionlogWebParam());

        //ָ��VO��
        setClsVO(OperfunctionlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Operfunctionlog.class);
		this.setClsQueryParam(OperfunctionlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}