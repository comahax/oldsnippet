/**
 * auto-generated code
 * Thu Jul 14 20:18:52 CST 2011
 */
 package com.gmcc.pboss.web.sales.wayassistantlog;

import com.gmcc.pboss.business.sales.wayassistantlog.WayassistantlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.wayassistantlog.WayassistantlogDBParam;
import com.gmcc.pboss.control.sales.wayassistantlog.Wayassistantlog ;

/**
 * <p>Title: WayassistantlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class WayassistantlogAction extends BaseAction{
	
	public WayassistantlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new WayassistantlogForm());
		this.setParam(new WayassistantlogDBParam());

        //ָ��VO��
        setClsVO(WayassistantlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Wayassistantlog.class);
		this.setClsQueryParam(WayassistantlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}