/**
 * auto-generated code
 * Mon Nov 23 16:57:18 CST 2009
 */
 package com.gmcc.pboss.web.sales.comsellmid;

import com.gmcc.pboss.business.sales.comsellmid.ComsellmidVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.comsellmid.ComsellmidDBParam;
import com.gmcc.pboss.control.sales.comsellmid.Comsellmid ;

/**
 * <p>Title: ComsellmidAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ComsellmidAction extends BaseAction{
	
	public ComsellmidAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ComsellmidForm());
		this.setParam(new ComsellmidDBParam());

        //ָ��VO��
        setClsVO(ComsellmidVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"orderid","recid"};
		this.setClsControl(Comsellmid.class);
		this.setClsQueryParam(ComsellmidDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}