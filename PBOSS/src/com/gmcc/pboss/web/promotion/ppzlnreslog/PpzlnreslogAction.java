/**
 * auto-generated code
 * Thu Sep 17 15:18:01 CST 2009
 */
 package com.gmcc.pboss.web.promotion.ppzlnreslog;

import com.gmcc.pboss.business.promotion.ppzlnreslog.PpzlnreslogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.ppzlnreslog.PpzlnreslogDBParam;
import com.gmcc.pboss.control.promotion.ppzlnreslog.Ppzlnreslog ;

/**
 * <p>Title: PpzlnreslogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class PpzlnreslogAction extends BaseAction{
	
	public PpzlnreslogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new PpzlnreslogForm());
		this.setParam(new PpzlnreslogWebParam());

        //ָ��VO��
        setClsVO(PpzlnreslogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Ppzlnreslog.class);
		this.setClsQueryParam(PpzlnreslogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}