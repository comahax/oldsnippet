/**
 * auto-generated code
 * Sun Sep 13 11:38:12 CST 2009
 */
 package com.gmcc.pboss.web.channel.operation;

import com.gmcc.pboss.business.channel.operation.OperationVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.operation.OperationDBParam;
import com.gmcc.pboss.control.channel.operation.Operation ;

/**
 * <p>Title: OperationAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class OperationAction extends BaseAction{
	
	public OperationAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OperationForm());
		this.setParam(new OperationWebParam());

        //ָ��VO��
        setClsVO(OperationVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"opnid"};
		this.setClsControl(Operation.class);
		this.setClsQueryParam(OperationDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}