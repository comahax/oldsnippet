/**
 * auto-generated code
 * Fri Dec 07 14:13:24 CST 2012
 */
 package com.gmcc.pboss.web.resource.simnoactinfofile;

import com.gmcc.pboss.business.resource.simnoactinfofile.SimnoactinfofileVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.simnoactinfofile.SimnoactinfofileDBParam;
import com.gmcc.pboss.control.resource.simnoactinfofile.Simnoactinfofile ;

/**
 * <p>Title: SimnoactinfofileAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class SimnoactinfofileAction extends BaseAction{
	
	public SimnoactinfofileAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SimnoactinfofileForm());
		this.setParam(new SimnoactinfofileDBParam());

        //ָ��VO��
        setClsVO(SimnoactinfofileVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Simnoactinfofile.class);
		this.setClsQueryParam(SimnoactinfofileDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}