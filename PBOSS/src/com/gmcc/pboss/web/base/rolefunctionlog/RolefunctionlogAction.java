/**
 * auto-generated code
 * Mon Sep 07 10:49:06 CST 2009
 */
 package com.gmcc.pboss.web.base.rolefunctionlog;

import com.gmcc.pboss.business.base.rolefunctionlog.RolefunctionlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.rolefunctionlog.RolefunctionlogDBParam;
import com.gmcc.pboss.control.base.rolefunctionlog.Rolefunctionlog ;

/**
 * <p>Title: RolefunctionlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class RolefunctionlogAction extends BaseAction{
	
	public RolefunctionlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new RolefunctionlogForm());
		this.setParam(new RolefunctionlogWebParam());

        //ָ��VO��
        setClsVO(RolefunctionlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Rolefunctionlog.class);
		this.setClsQueryParam(RolefunctionlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}