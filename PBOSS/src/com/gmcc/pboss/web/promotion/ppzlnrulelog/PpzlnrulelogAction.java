/**
 * auto-generated code
 * Thu Sep 17 15:13:36 CST 2009
 */
 package com.gmcc.pboss.web.promotion.ppzlnrulelog;

import com.gmcc.pboss.business.promotion.ppzlnrulelog.PpzlnrulelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.ppzlnrulelog.PpzlnrulelogDBParam;
import com.gmcc.pboss.control.promotion.ppzlnrulelog.Ppzlnrulelog ;

/**
 * <p>Title: PpzlnrulelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class PpzlnrulelogAction extends BaseAction{
	
	public PpzlnrulelogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new PpzlnrulelogForm());
		this.setParam(new PpzlnrulelogWebParam());

        //ָ��VO��
        setClsVO(PpzlnrulelogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Ppzlnrulelog.class);
		this.setClsQueryParam(PpzlnrulelogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}