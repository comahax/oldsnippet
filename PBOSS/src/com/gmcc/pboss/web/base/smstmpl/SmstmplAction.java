/**
 * auto-generated code
 * Mon Dec 21 09:15:59 CST 2009
 */
 package com.gmcc.pboss.web.base.smstmpl;

import com.gmcc.pboss.business.base.smstmpl.SmstmplDBParam;
import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: SmstmplAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SmstmplAction extends BaseAction{
	
	public SmstmplAction(){
		super();

		//���¼��������Ǳ����
		this.setForm(new SmstmplForm());
		this.setParam(new SmstmplDBParam());

        //ָ��VO��
        setClsVO(SmstmplVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"sid"};
		this.setClsControl(Smstmpl.class);
		this.setClsQueryParam(SmstmplDBParam.class) ;
		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}