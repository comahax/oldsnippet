/**
 * auto-generated code
 * Tue Sep 29 10:24:36 CST 2009
 */
 package com.gmcc.pboss.web.communication.advapproval;

import com.gmcc.pboss.business.communication.advapproval.AdvapprovalVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.communication.advapproval.AdvapprovalDBParam;
import com.gmcc.pboss.control.communication.advapproval.Advapproval ;

/**
 * <p>Title: AdvapprovalAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AdvapprovalAction extends BaseAction{
	
	public AdvapprovalAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new AdvapprovalForm());
		this.setParam(new AdvapprovalWebParam());

        //ָ��VO��
        setClsVO(AdvapprovalVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"approvalid"};
		this.setClsControl(Advapproval.class);
		this.setClsQueryParam(AdvapprovalDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}