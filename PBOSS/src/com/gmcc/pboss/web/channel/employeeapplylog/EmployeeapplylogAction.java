/**
 * auto-generated code
 * Mon Nov 23 16:50:43 CST 2009
 */
 package com.gmcc.pboss.web.channel.employeeapplylog;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employeeapplylog.EmployeeapplylogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.employeeapplylog.EmployeeapplylogDBParam;
import com.gmcc.pboss.control.channel.employeeapplylog.Employeeapplylog ;

/**
 * <p>Title: EmployeeapplylogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class EmployeeapplylogAction extends BaseAction{
	
	public EmployeeapplylogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new EmployeeapplylogForm());
		this.setParam(new EmployeeapplylogDBParam());

        //ָ��VO��
        setClsVO(EmployeeapplylogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"applyno"};
		this.setClsControl(Employeeapplylog.class);
		this.setClsQueryParam(EmployeeapplylogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		EmployeeapplylogDBParam param = (EmployeeapplylogDBParam)getParam();
		// ��Ա������־���ǵ��б���˲��ؼӵ���ID������
//		param.set_se_cityid(getDBAccessUser().getCityid());
		return super.doList();
	}
}