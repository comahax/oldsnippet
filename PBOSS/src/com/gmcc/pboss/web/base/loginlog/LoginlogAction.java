/**
 * auto-generated code
 * Mon Dec 20 10:03:23 CST 2010
 */
 package com.gmcc.pboss.web.base.loginlog;

import com.gmcc.pboss.business.base.loginlog.LoginlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.loginlog.LoginlogDBParam;
import com.gmcc.pboss.control.base.loginlog.Loginlog ;

/**
 * <p>Title: LoginlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class LoginlogAction extends BaseAction{
	
	public LoginlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new LoginlogForm());
		this.setParam(new LoginlogWebParam());

        //ָ��VO��
        setClsVO(LoginlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Loginlog.class);
		this.setClsQueryParam(LoginlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}