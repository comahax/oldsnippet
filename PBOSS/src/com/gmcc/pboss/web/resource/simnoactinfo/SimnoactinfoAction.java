/**
 * auto-generated code
 * Fri Dec 07 14:12:22 CST 2012
 */
 package com.gmcc.pboss.web.resource.simnoactinfo;

import com.gmcc.pboss.business.resource.simnoactinfo.SimnoactinfoVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.simnoactinfo.SimnoactinfoDBParam;
import com.gmcc.pboss.control.resource.simnoactinfo.Simnoactinfo ;

/**
 * <p>Title: SimnoactinfoAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class SimnoactinfoAction extends BaseAction{
	
	public SimnoactinfoAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SimnoactinfoForm());
		this.setParam(new SimnoactinfoDBParam());

        //ָ��VO��
        setClsVO(SimnoactinfoVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Simnoactinfo.class);
		this.setClsQueryParam(SimnoactinfoDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}