/**
 * auto-generated code
 * Fri Dec 17 11:26:27 CST 2010
 */
 package com.gmcc.pboss.web.sales.auditdet;

import com.gmcc.pboss.business.sales.auditdet.AuditdetVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.auditdet.AuditdetDBParam;
import com.gmcc.pboss.control.sales.auditdet.Auditdet ;

/**
 * <p>Title: AuditdetAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class AuditdetAction extends BaseAction{
	
	public AuditdetAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new AuditdetForm());
		this.setParam(new AuditdetDBParam());

        //ָ��VO��
        setClsVO(AuditdetVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"auditseq","recid"};
		this.setClsControl(Auditdet.class);
		this.setClsQueryParam(AuditdetDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}