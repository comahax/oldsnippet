/**
 * auto-generated code
 * Thu Jul 08 15:13:51 CST 2010
 */
 package com.gmcc.pboss.web.sales.timesectlog;

import com.gmcc.pboss.business.sales.timesectlog.TimesectlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.timesectlog.TimesectlogDBParam;
import com.gmcc.pboss.control.sales.timesectlog.Timesectlog ;

/**
 * <p>Title: TimesectlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class TimesectlogAction extends BaseAction{
	
	public TimesectlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new TimesectlogForm());
		this.setParam(new TimesectlogDBParam());

        //ָ��VO��
        setClsVO(TimesectlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Timesectlog.class);
		this.setClsQueryParam(TimesectlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}