/**
 * auto-generated code
 * Sun Oct 18 20:50:56 CST 2009
 */
 package com.gmcc.pboss.web.channel.waycompctlog;

import com.gmcc.pboss.business.channel.waycompctlog.WaycompctlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.waycompctlog.WaycompctlogDBParam;
import com.gmcc.pboss.control.channel.waycompctlog.Waycompctlog ;

/**
 * <p>Title: WaycompctlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WaycompctlogAction extends BaseAction{
	
	public WaycompctlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new WaycompctlogForm());
		this.setParam(new WaycompctlogWebParam());

        //ָ��VO��
        setClsVO(WaycompctlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Waycompctlog.class);
		this.setClsQueryParam(WaycompctlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}