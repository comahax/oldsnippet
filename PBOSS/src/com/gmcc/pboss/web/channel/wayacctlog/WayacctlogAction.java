/**
 * auto-generated code
 * Thu Nov 05 10:44:22 CST 2009
 */
 package com.gmcc.pboss.web.channel.wayacctlog;

import com.gmcc.pboss.business.channel.wayacctlog.WayacctlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.wayacctlog.WayacctlogDBParam;
import com.gmcc.pboss.control.channel.wayacctlog.Wayacctlog ;

/**
 * <p>Title: WayacctlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WayacctlogAction extends BaseAction{
	
	public WayacctlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new WayacctlogForm());
		this.setParam(new WayacctlogDBParam());

        //ָ��VO��
        setClsVO(WayacctlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Wayacctlog.class);
		this.setClsQueryParam(WayacctlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}