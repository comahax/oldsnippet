/**
 * auto-generated code
 * Thu Sep 17 14:55:57 CST 2009
 */
 package com.gmcc.pboss.web.promotion.elmtinstlog;

import com.gmcc.pboss.business.promotion.elmtinstlog.ElmtinstlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.elmtinstlog.ElmtinstlogDBParam;
import com.gmcc.pboss.control.promotion.elmtinstlog.Elmtinstlog ;

/**
 * <p>Title: ElmtinstlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ElmtinstlogAction extends BaseAction{
	
	public ElmtinstlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ElmtinstlogForm());
		this.setParam(new ElmtinstlogWebParam());

        //ָ��VO��
        setClsVO(ElmtinstlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Elmtinstlog.class);
		this.setClsQueryParam(ElmtinstlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}