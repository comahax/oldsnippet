/**
 * auto-generated code
 * Sat Nov 21 17:07:29 CST 2009
 */
 package com.gmcc.pboss.web.channel.wayhierarchy;

import com.gmcc.pboss.business.channel.wayhierarchy.WayhierarchyVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.wayhierarchy.WayhierarchyDBParam;
import com.gmcc.pboss.control.channel.wayhierarchy.Wayhierarchy ;

/**
 * <p>Title: WayhierarchyAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class WayhierarchyAction extends BaseAction{
	
	public WayhierarchyAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new WayhierarchyForm());
		this.setParam(new WayhierarchyDBParam());

        //ָ��VO��
        setClsVO(WayhierarchyVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"parwayid","subwayid"};
		this.setClsControl(Wayhierarchy.class);
		this.setClsQueryParam(WayhierarchyDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}