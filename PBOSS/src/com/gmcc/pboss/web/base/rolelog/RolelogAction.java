/**
 * auto-generated code
 * Mon Sep 07 10:46:06 CST 2009
 */
 package com.gmcc.pboss.web.base.rolelog;

import com.gmcc.pboss.business.base.rolelog.RolelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.rolelog.RolelogDBParam;
import com.gmcc.pboss.control.base.rolelog.Rolelog ;

/**
 * <p>Title: RolelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class RolelogAction extends BaseAction{
	
	public RolelogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new RolelogForm());
		this.setParam(new RolelogWebParam());

        //ָ��VO��
        setClsVO(RolelogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Rolelog.class);
		this.setClsQueryParam(RolelogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}