/**
 * auto-generated code
 * Wed Oct 07 13:35:00 CST 2009
 */
 package com.gmcc.pboss.web.channel.cooperator;

import com.gmcc.pboss.business.channel.cooperator.CooperatorVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.cooperator.CooperatorDBParam;
import com.gmcc.pboss.control.channel.cooperator.Cooperator ;

/**
 * <p>Title: CooperatorAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class CooperatorAction extends BaseAction{
	
	public CooperatorAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new CooperatorForm());
		this.setParam(new CooperatorWebParam());

        //ָ��VO��
        setClsVO(CooperatorVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"cooperauid"};
		this.setClsControl(Cooperator.class);
		this.setClsQueryParam(CooperatorDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}