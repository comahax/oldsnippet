/**
 * auto-generated code
 * Mon Sep 07 11:18:53 CST 2009
 */
 package com.gmcc.pboss.web.base.operrolelog;

import com.gmcc.pboss.business.base.operrolelog.OperrolelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.operrolelog.OperrolelogDBParam;
import com.gmcc.pboss.control.base.operrolelog.Operrolelog ;

/**
 * <p>Title: OperrolelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OperrolelogAction extends BaseAction{
	
	public OperrolelogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OperrolelogForm());
		this.setParam(new OperrolelogWebParam());

        //ָ��VO��
        setClsVO(OperrolelogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Operrolelog.class);
		this.setClsQueryParam(OperrolelogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}