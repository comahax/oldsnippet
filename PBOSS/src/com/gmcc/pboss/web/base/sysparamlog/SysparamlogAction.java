/**
 * auto-generated code
 * Mon Sep 07 10:58:56 CST 2009
 */
 package com.gmcc.pboss.web.base.sysparamlog;

import com.gmcc.pboss.business.base.sysparamlog.SysparamlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.sysparamlog.SysparamlogDBParam;
import com.gmcc.pboss.control.base.sysparamlog.Sysparamlog ;

/**
 * <p>Title: SysparamlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class SysparamlogAction extends BaseAction{
	
	public SysparamlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SysparamlogForm());
		this.setParam(new SysparamlogWebParam());

        //ָ��VO��
        setClsVO(SysparamlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Sysparamlog.class);
		this.setClsQueryParam(SysparamlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}