/**
 * auto-generated code
 * Tue Aug 09 16:10:47 CST 2011
 */
 package com.gmcc.pboss.web.resource.cityrescodelog;

import com.gmcc.pboss.business.resource.cityrescodelog.CityrescodelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.cityrescodelog.CityrescodelogDBParam;
import com.gmcc.pboss.control.resource.cityrescodelog.Cityrescodelog ;

/**
 * <p>Title: CityrescodelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class CityrescodelogAction extends BaseAction{
	
	public CityrescodelogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new CityrescodelogForm());
		this.setParam(new CityrescodelogDBParam());

        //ָ��VO��
        setClsVO(CityrescodelogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Cityrescodelog.class);
		this.setClsQueryParam(CityrescodelogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}