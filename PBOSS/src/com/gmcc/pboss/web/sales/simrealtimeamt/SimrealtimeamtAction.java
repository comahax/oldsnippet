/**
 * auto-generated code
 * Thu Apr 05 09:18:42 CST 2012
 */
 package com.gmcc.pboss.web.sales.simrealtimeamt;

import com.gmcc.pboss.business.sales.simrealtimeamt.SimrealtimeamtVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.simrealtimeamt.SimrealtimeamtDBParam;
import com.gmcc.pboss.control.sales.simrealtimeamt.Simrealtimeamt ;

/**
 * <p>Title: SimrealtimeamtAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class SimrealtimeamtAction extends BaseAction{
	
	public SimrealtimeamtAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SimrealtimeamtForm());
		this.setParam(new SimrealtimeamtDBParam());

        //ָ��VO��
        setClsVO(SimrealtimeamtVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"wayid"};
		this.setClsControl(Simrealtimeamt.class);
		this.setClsQueryParam(SimrealtimeamtDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}