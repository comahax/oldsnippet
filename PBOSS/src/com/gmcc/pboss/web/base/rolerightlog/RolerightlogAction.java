/**
 * auto-generated code
 * Mon Sep 07 10:50:13 CST 2009
 */
 package com.gmcc.pboss.web.base.rolerightlog;

import com.gmcc.pboss.business.base.rolerightlog.RolerightlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.rolerightlog.RolerightlogDBParam;
import com.gmcc.pboss.control.base.rolerightlog.Rolerightlog ;

/**
 * <p>Title: RolerightlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class RolerightlogAction extends BaseAction{
	
	public RolerightlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new RolerightlogForm());
		this.setParam(new RolerightlogWebParam());

        //ָ��VO��
        setClsVO(RolerightlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Rolerightlog.class);
		this.setClsQueryParam(RolerightlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}