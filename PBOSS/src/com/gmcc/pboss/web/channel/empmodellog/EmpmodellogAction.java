/**
 * auto-generated code
 * Fri Mar 04 17:08:10 CST 2011
 */
 package com.gmcc.pboss.web.channel.empmodellog;

import com.gmcc.pboss.business.channel.empmodellog.EmpmodellogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.empmodellog.EmpmodellogDBParam;
import com.gmcc.pboss.control.channel.empmodellog.Empmodellog ;

/**
 * <p>Title: EmpmodellogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmpmodellogAction extends BaseAction{
	
	public EmpmodellogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new EmpmodellogForm());
		this.setParam(new EmpmodellogDBParam());

        //ָ��VO��
        setClsVO(EmpmodellogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Empmodellog.class);
		this.setClsQueryParam(EmpmodellogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}