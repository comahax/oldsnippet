/**
 * auto-generated code
 * Thu Sep 17 15:16:39 CST 2009
 */
 package com.gmcc.pboss.web.promotion.ppzlncomlog;

import com.gmcc.pboss.business.promotion.ppzlncomlog.PpzlncomlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.ppzlncomlog.PpzlncomlogDBParam;
import com.gmcc.pboss.control.promotion.ppzlncomlog.Ppzlncomlog ;

/**
 * <p>Title: PpzlncomlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class PpzlncomlogAction extends BaseAction{
	
	public PpzlncomlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new PpzlncomlogForm());
		this.setParam(new PpzlncomlogWebParam());

        //ָ��VO��
        setClsVO(PpzlncomlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Ppzlncomlog.class);
		this.setClsQueryParam(PpzlncomlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}