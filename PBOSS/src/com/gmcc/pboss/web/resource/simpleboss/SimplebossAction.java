/**
 * auto-generated code
 * Wed Sep 09 09:17:44 CST 2009
 */
 package com.gmcc.pboss.web.resource.simpleboss;

import com.gmcc.pboss.business.resource.simpleboss.SimplebossVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.simpleboss.SimplebossDBParam;
import com.gmcc.pboss.control.resource.simpleboss.Simpleboss ;

/**
 * <p>Title: SimplebossAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
public class SimplebossAction extends BaseAction{
	
	public SimplebossAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SimplebossForm());
		this.setParam(new SimplebossWebParam());

        //ָ��VO��
        setClsVO(SimplebossVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"cityid","wayid"};
		this.setClsControl(Simpleboss.class);
		this.setClsQueryParam(SimplebossDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}