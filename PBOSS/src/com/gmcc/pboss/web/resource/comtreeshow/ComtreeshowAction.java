/**
 * auto-generated code
 * Wed Sep 09 09:21:23 CST 2009
 */
 package com.gmcc.pboss.web.resource.comtreeshow;

import com.gmcc.pboss.business.resource.comtreeshow.ComtreeshowVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.comtreeshow.ComtreeshowDBParam;
import com.gmcc.pboss.control.resource.comtreeshow.Comtreeshow ;

/**
 * <p>Title: ComtreeshowAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
public class ComtreeshowAction extends BaseAction{
	
	public ComtreeshowAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ComtreeshowForm());
		this.setParam(new ComtreeshowWebParam());

        //ָ��VO��
        setClsVO(ComtreeshowVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"cityid","comclassid","comtype","wayid"};
		this.setClsControl(Comtreeshow.class);
		this.setClsQueryParam(ComtreeshowDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}