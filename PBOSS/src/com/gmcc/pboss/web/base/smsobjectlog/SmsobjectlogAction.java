/**
 * auto-generated code
 * Tue Jul 05 10:51:39 CST 2011
 */
 package com.gmcc.pboss.web.base.smsobjectlog;

import com.gmcc.pboss.business.base.smsobjectlog.SmsobjectlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.smsobjectlog.SmsobjectlogDBParam;
import com.gmcc.pboss.control.base.smsobjectlog.Smsobjectlog ;

/**
 * <p>Title: SmsobjectlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public class SmsobjectlogAction extends BaseAction{
	
	public SmsobjectlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SmsobjectlogForm());
		this.setParam(new SmsobjectlogDBParam());

        //ָ��VO��
        setClsVO(SmsobjectlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Smsobjectlog.class);
		this.setClsQueryParam(SmsobjectlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}