/**
 * auto-generated code
 * Tue Sep 08 09:43:07 CST 2009
 */
 package com.gmcc.pboss.web.base.operatorlog;

import com.gmcc.pboss.business.base.operatorlog.OperatorlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.operatorlog.OperatorlogDBParam;
import com.gmcc.pboss.control.base.operatorlog.Operatorlog ;

/**
 * <p>Title: OperatorlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OperatorlogAction extends BaseAction{
	
	public OperatorlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OperatorlogForm());
		this.setParam(new OperatorlogWebParam());

        //ָ��VO��
        setClsVO(OperatorlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Operatorlog.class);
		this.setClsQueryParam(OperatorlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}