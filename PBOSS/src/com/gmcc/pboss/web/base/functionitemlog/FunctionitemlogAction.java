/**
 * auto-generated code
 * Mon Sep 07 10:48:24 CST 2009
 */
 package com.gmcc.pboss.web.base.functionitemlog;

import com.gmcc.pboss.business.base.functionitemlog.FunctionitemlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.functionitemlog.FunctionitemlogDBParam;
import com.gmcc.pboss.control.base.functionitemlog.Functionitemlog ;

/**
 * <p>Title: FunctionitemlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class FunctionitemlogAction extends BaseAction{
	
	public FunctionitemlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new FunctionitemlogForm());
		this.setParam(new FunctionitemlogWebParam());

        //ָ��VO��
        setClsVO(FunctionitemlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Functionitemlog.class);
		this.setClsQueryParam(FunctionitemlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}