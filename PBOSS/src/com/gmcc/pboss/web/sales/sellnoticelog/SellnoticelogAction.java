/**
 * auto-generated code
 * Thu Jan 26 11:27:21 CST 2012
 */
 package com.gmcc.pboss.web.sales.sellnoticelog;

import com.gmcc.pboss.business.sales.sellnoticelog.SellnoticelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.sellnoticelog.SellnoticelogDBParam;
import com.gmcc.pboss.control.sales.sellnoticelog.Sellnoticelog ;

/**
 * <p>Title: SellnoticelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class SellnoticelogAction extends BaseAction{
	
	public SellnoticelogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SellnoticelogForm());
		this.setParam(new SellnoticelogDBParam());

        //ָ��VO��
        setClsVO(SellnoticelogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Sellnoticelog.class);
		this.setClsQueryParam(SellnoticelogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}