/**
 * auto-generated code
 * Mon Sep 14 17:03:36 CST 2009
 */
 package com.gmcc.pboss.web.promotion.tieinsalelog;

import com.gmcc.pboss.business.promotion.tieinsalelog.TieinsalelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.tieinsalelog.TieinsalelogDBParam;
import com.gmcc.pboss.control.promotion.tieinsalelog.Tieinsalelog ;

/**
 * <p>Title: TieinsalelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class TieinsalelogAction extends BaseAction{
	
	public TieinsalelogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new TieinsalelogForm());
		this.setParam(new TieinsalelogWebParam());

        //ָ��VO��
        setClsVO(TieinsalelogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Tieinsalelog.class);
		this.setClsQueryParam(TieinsalelogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}