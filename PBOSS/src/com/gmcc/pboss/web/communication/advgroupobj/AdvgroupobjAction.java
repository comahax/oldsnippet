/**
 * auto-generated code
 * Tue Sep 29 10:22:17 CST 2009
 */
 package com.gmcc.pboss.web.communication.advgroupobj;

import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjDBParam;
import com.gmcc.pboss.control.communication.advgroupobj.Advgroupobj ;

/**
 * <p>Title: AdvgroupobjAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AdvgroupobjAction extends BaseAction{
	
	public AdvgroupobjAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new AdvgroupobjForm());
		this.setParam(new AdvgroupobjWebParam());

        //ָ��VO��
        setClsVO(AdvgroupobjVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"groupoid"};
		this.setClsControl(Advgroupobj.class);
		this.setClsQueryParam(AdvgroupobjDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}