/**
 * auto-generated code
 * Sat Jan 24 11:49:16 CST 2015
 */
 package com.gmcc.pboss.web.channel.property;

import com.gmcc.pboss.business.channel.property.PropertyVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.property.PropertyDBParam;
import com.gmcc.pboss.control.channel.property.Property ;

/**
 * <p>Title: PropertyAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class PropertyAction extends BaseAction{
	
	public PropertyAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new PropertyForm());
		this.setParam(new PropertyDBParam());

        //ָ��VO��
        setClsVO(PropertyVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"wayid"};
		this.setClsControl(Property.class);
		this.setClsQueryParam(PropertyDBParam.class) ;

	}
}