/**
 * auto-generated code
 * Tue Oct 20 17:13:30 CST 2009
 */
 package com.gmcc.pboss.web.sales.partnerres;

import com.gmcc.pboss.business.sales.partnerres.PartnerresVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDBParam;
import com.gmcc.pboss.control.sales.partnerres.Partnerres ;

/**
 * <p>Title: PartnerresAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class PartnerresAction extends BaseAction{
	
	public PartnerresAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new PartnerresForm());
		this.setParam(new PartnerresWebParam());

        //ָ��VO��
        setClsVO(PartnerresVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Partnerres.class);
		this.setClsQueryParam(PartnerresDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}