/**
 * auto-generated code
 * Mon Sep 07 10:52:58 CST 2009
 */
 package com.gmcc.pboss.web.base.dictitemlog;

import com.gmcc.pboss.business.base.dictitemlog.DictitemlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.dictitemlog.DictitemlogDBParam;
import com.gmcc.pboss.control.base.dictitemlog.Dictitemlog ;

/**
 * <p>Title: DictitemlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class DictitemlogAction extends BaseAction{
	
	public DictitemlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new DictitemlogForm());
		this.setParam(new DictitemlogWebParam());

        //ָ��VO��
        setClsVO(DictitemlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Dictitemlog.class);
		this.setClsQueryParam(DictitemlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}