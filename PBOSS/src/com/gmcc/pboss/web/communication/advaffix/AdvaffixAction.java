/**
 * auto-generated code
 * Tue Sep 29 10:26:16 CST 2009
 */
 package com.gmcc.pboss.web.communication.advaffix;

import com.gmcc.pboss.business.communication.advaffix.AdvaffixVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.communication.advaffix.AdvaffixDBParam;
import com.gmcc.pboss.control.communication.advaffix.Advaffix ;

/**
 * <p>Title: AdvaffixAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AdvaffixAction extends BaseAction{
	
	public AdvaffixAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new AdvaffixForm());
		this.setParam(new AdvaffixWebParam());

        //ָ��VO��
        setClsVO(AdvaffixVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"affixid"};
		this.setClsControl(Advaffix.class);
		this.setClsQueryParam(AdvaffixDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}