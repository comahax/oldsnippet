/**
 * auto-generated code
 * Sat Aug 13 11:12:29 CST 2011
 */
 package com.gmcc.pboss.web.resource.comcatebrand;

import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandDBParam;
import com.gmcc.pboss.control.resource.comcatebrand.Comcatebrand ;

/**
 * <p>Title: ComcatebrandAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class ComcatebrandAction extends BaseAction{
	
	public ComcatebrandAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ComcatebrandForm());
		this.setParam(new ComcatebrandDBParam());

        //ָ��VO��
        setClsVO(ComcatebrandVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"comcategory"};
		this.setClsControl(Comcatebrand.class);
		this.setClsQueryParam(ComcatebrandDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}