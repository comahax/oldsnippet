/**
 * auto-generated code
 * Wed Nov 14 09:58:01 CST 2012
 */
 package com.gmcc.pboss.web.channel.busicirclelog;

import com.gmcc.pboss.business.channel.busicirclelog.BusicirclelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.busicirclelog.BusicirclelogDBParam;
import com.gmcc.pboss.control.channel.busicirclelog.Busicirclelog ;

/**
 * <p>Title: BusicirclelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class BusicirclelogAction extends BaseAction{
	
	public BusicirclelogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new BusicirclelogForm());
		this.setParam(new BusicirclelogDBParam());

        //ָ��VO��
        setClsVO(BusicirclelogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Busicirclelog.class);
		this.setClsQueryParam(BusicirclelogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}