/**
 * auto-generated code
 * Tue Mar 01 19:20:26 CST 2011
 */
 package com.gmcc.pboss.web.channel.empconfirm;

import com.gmcc.pboss.business.channel.empconfirm.EmpconfirmVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.empconfirm.EmpconfirmDBParam;
import com.gmcc.pboss.control.channel.empconfirm.Empconfirm ;

/**
 * <p>Title: EmpconfirmAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmpconfirmAction extends BaseAction{
	
	public EmpconfirmAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new EmpconfirmForm());
		this.setParam(new EmpconfirmDBParam());

        //ָ��VO��
        setClsVO(EmpconfirmVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"confirmid"};
		this.setClsControl(Empconfirm.class);
		this.setClsQueryParam(EmpconfirmDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}