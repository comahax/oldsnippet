/**
 * auto-generated code
 * Fri Mar 04 17:20:29 CST 2011
 */
 package com.gmcc.pboss.web.channel.emodconfirm;

import com.gmcc.pboss.business.channel.emodconfirm.EmodconfirmVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.emodconfirm.EmodconfirmDBParam;
import com.gmcc.pboss.control.channel.emodconfirm.Emodconfirm ;

/**
 * <p>Title: EmodconfirmAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmodconfirmAction extends BaseAction{
	
	public EmodconfirmAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new EmodconfirmForm());
		this.setParam(new EmodconfirmDBParam());

        //ָ��VO��
        setClsVO(EmodconfirmVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"confirmid"};
		this.setClsControl(Emodconfirm.class);
		this.setClsQueryParam(EmodconfirmDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}