/**
 * auto-generated code
 * Thu Feb 17 11:53:25 CST 2011
 */
 package com.gmcc.pboss.web.channel.employeeextend;

import com.gmcc.pboss.business.channel.employeeextend.EmployeeextendVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.employeeextend.EmployeeextendDBParam;
import com.gmcc.pboss.control.channel.employeeextend.Employeeextend ;

/**
 * <p>Title: EmployeeextendAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmployeeextendAction extends BaseAction{
	
	public EmployeeextendAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new EmployeeextendForm());
		this.setParam(new EmployeeextendDBParam());

        //ָ��VO��
        setClsVO(EmployeeextendVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"employeeid"};
		this.setClsControl(Employeeextend.class);
		this.setClsQueryParam(EmployeeextendDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}