/**
 * auto-generated code
 * Thu Feb 17 11:55:20 CST 2011
 */
 package com.gmcc.pboss.web.channel.employeeextendlog;

import com.gmcc.pboss.business.channel.employeeextendlog.EmployeeextendlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.employeeextendlog.EmployeeextendlogDBParam;
import com.gmcc.pboss.control.channel.employeeextendlog.Employeeextendlog ;

/**
 * <p>Title: EmployeeextendlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmployeeextendlogAction extends BaseAction{
	
	public EmployeeextendlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new EmployeeextendlogForm());
		this.setParam(new EmployeeextendlogDBParam());

        //ָ��VO��
        setClsVO(EmployeeextendlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Employeeextendlog.class);
		this.setClsQueryParam(EmployeeextendlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}