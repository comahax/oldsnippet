/**
 * auto-generated code
 * Wed Oct 07 14:01:03 CST 2009
 */
 package com.gmcc.pboss.web.channel.fdaudit;

import com.gmcc.pboss.business.channel.fdaudit.FdauditVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.fdaudit.FdauditDBParam;
import com.gmcc.pboss.control.channel.fdaudit.Fdaudit ;

/**
 * <p>Title: FdauditAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class FdauditAction extends BaseAction{
	
	public FdauditAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new FdauditForm());
		this.setParam(new FdauditWebParam());

        //ָ��VO��
        setClsVO(FdauditVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recno"};
		this.setClsControl(Fdaudit.class);
		this.setClsQueryParam(FdauditDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}