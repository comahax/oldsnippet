/**
 * auto-generated code
 * Thu Sep 17 15:15:04 CST 2009
 */
 package com.gmcc.pboss.web.promotion.ppzlnptnrlog;

import com.gmcc.pboss.business.promotion.ppzlnptnrlog.PpzlnptnrlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.ppzlnptnrlog.PpzlnptnrlogDBParam;
import com.gmcc.pboss.control.promotion.ppzlnptnrlog.Ppzlnptnrlog ;

/**
 * <p>Title: PpzlnptnrlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class PpzlnptnrlogAction extends BaseAction{
	
	public PpzlnptnrlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new PpzlnptnrlogForm());
		this.setParam(new PpzlnptnrlogWebParam());

        //ָ��VO��
        setClsVO(PpzlnptnrlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Ppzlnptnrlog.class);
		this.setClsQueryParam(PpzlnptnrlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}