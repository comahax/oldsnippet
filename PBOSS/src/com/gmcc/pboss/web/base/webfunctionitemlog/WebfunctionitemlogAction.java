/**
 * auto-generated code
 * Thu Dec 09 16:37:06 CST 2010
 */
 package com.gmcc.pboss.web.base.webfunctionitemlog;

import com.gmcc.pboss.business.base.webfunctionitemlog.WebfunctionitemlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.webfunctionitemlog.WebfunctionitemlogDBParam;
import com.gmcc.pboss.control.base.webfunctionitemlog.Webfunctionitemlog ;

/**
 * <p>Title: WebfunctionitemlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class WebfunctionitemlogAction extends BaseAction{
	
	public WebfunctionitemlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new WebfunctionitemlogForm());
		this.setParam(new WebfunctionitemlogDBParam());

        //ָ��VO��
        setClsVO(WebfunctionitemlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Webfunctionitemlog.class);
		this.setClsQueryParam(WebfunctionitemlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}