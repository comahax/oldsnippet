/**
 * auto-generated code
 * Mon Sep 07 10:51:49 CST 2009
 */
 package com.gmcc.pboss.web.base.operrightlog;

import com.gmcc.pboss.business.base.operrightlog.OperrightlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.operrightlog.OperrightlogDBParam;
import com.gmcc.pboss.control.base.operrightlog.Operrightlog ;

/**
 * <p>Title: OperrightlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OperrightlogAction extends BaseAction{
	
	public OperrightlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OperrightlogForm());
		this.setParam(new OperrightlogWebParam());

        //ָ��VO��
        setClsVO(OperrightlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Operrightlog.class);
		this.setClsQueryParam(OperrightlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}