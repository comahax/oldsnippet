/**
 * auto-generated code
 * Tue Jun 29 12:02:04 CST 2010
 */
 package com.gmcc.pboss.web.channel.empmodel;

import com.gmcc.pboss.business.channel.empmodel.EmpmodelVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.empmodel.EmpmodelDBParam;
import com.gmcc.pboss.control.channel.empmodel.Empmodel ;

/**
 * <p>Title: EmpmodelAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zhangsiwei
 * @version 1.0
 */
public class EmpmodelAction extends BaseAction{
	
	public EmpmodelAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new EmpmodelForm());
		this.setParam(new EmpmodelDBParam());

        //ָ��VO��
        setClsVO(EmpmodelVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"empmodelid"};
		this.setClsControl(Empmodel.class);
		this.setClsQueryParam(EmpmodelDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}