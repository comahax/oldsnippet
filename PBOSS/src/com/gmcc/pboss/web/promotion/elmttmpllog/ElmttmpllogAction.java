/**
 * auto-generated code
 * Mon Sep 14 14:23:48 CST 2009
 */
 package com.gmcc.pboss.web.promotion.elmttmpllog;

import com.gmcc.pboss.business.promotion.elmttmpllog.ElmttmpllogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.elmttmpllog.ElmttmpllogDBParam;
import com.gmcc.pboss.control.promotion.elmttmpllog.Elmttmpllog ;

/**
 * <p>Title: ElmttmpllogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
public class ElmttmpllogAction extends BaseAction{
	
	public ElmttmpllogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ElmttmpllogForm());
		this.setParam(new ElmttmpllogWebParam());

        //ָ��VO��
        setClsVO(ElmttmpllogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Elmttmpllog.class);
		this.setClsQueryParam(ElmttmpllogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}