/**
 * auto-generated code
 * Tue Aug 03 15:52:05 CST 2010
 */
 package com.gmcc.pboss.web.sales.auditlog;

import com.gmcc.pboss.business.sales.auditlog.AuditlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.auditlog.AuditlogDBParam;
import com.gmcc.pboss.control.sales.auditlog.Auditlog ;

/**
 * <p>Title: AuditlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AuditlogAction extends BaseAction{
	
	public AuditlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new AuditlogForm());
		this.setParam(new AuditlogWebParam());

        //ָ��VO��
        setClsVO(AuditlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Auditlog.class);
		this.setClsQueryParam(AuditlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}