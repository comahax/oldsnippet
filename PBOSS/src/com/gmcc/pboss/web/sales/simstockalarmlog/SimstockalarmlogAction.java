/**
 * auto-generated code
 * Sat Mar 31 19:25:50 CST 2012
 */
 package com.gmcc.pboss.web.sales.simstockalarmlog;

import com.gmcc.pboss.business.sales.simstockalarmlog.SimstockalarmlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.simstockalarmlog.SimstockalarmlogDBParam;
import com.gmcc.pboss.control.sales.simstockalarmlog.Simstockalarmlog ;

/**
 * <p>Title: SimstockalarmlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class SimstockalarmlogAction extends BaseAction{
	
	public SimstockalarmlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SimstockalarmlogForm());
		this.setParam(new SimstockalarmlogDBParam());

        //ָ��VO��
        setClsVO(SimstockalarmlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Simstockalarmlog.class);
		this.setClsQueryParam(SimstockalarmlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}