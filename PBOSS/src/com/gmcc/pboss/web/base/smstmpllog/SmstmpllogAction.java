/**
 * auto-generated code
 * Mon Dec 21 09:17:48 CST 2009
 */
 package com.gmcc.pboss.web.base.smstmpllog;

import com.gmcc.pboss.business.base.smstmpllog.SmstmpllogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.smstmpllog.SmstmpllogDBParam;
import com.gmcc.pboss.control.base.smstmpllog.Smstmpllog ;

/**
 * <p>Title: SmstmpllogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SmstmpllogAction extends BaseAction{
	
	public SmstmpllogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SmstmpllogForm());
		this.setParam(new SmstmpllogDBParam());

        //ָ��VO��
        setClsVO(SmstmpllogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Smstmpllog.class);
		this.setClsQueryParam(SmstmpllogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}