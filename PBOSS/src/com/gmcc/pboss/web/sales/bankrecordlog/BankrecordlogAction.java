/**
 * auto-generated code
 * Tue Jan 17 09:54:18 CST 2012
 */
 package com.gmcc.pboss.web.sales.bankrecordlog;

import com.gmcc.pboss.business.sales.bankrecordlog.BankrecordlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.bankrecordlog.BankrecordlogDBParam;
import com.gmcc.pboss.control.sales.bankrecordlog.Bankrecordlog ;

/**
 * <p>Title: BankrecordlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class BankrecordlogAction extends BaseAction{
	
	public BankrecordlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new BankrecordlogForm());
		this.setParam(new BankrecordlogDBParam());

        //ָ��VO��
        setClsVO(BankrecordlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Bankrecordlog.class);
		this.setClsQueryParam(BankrecordlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}