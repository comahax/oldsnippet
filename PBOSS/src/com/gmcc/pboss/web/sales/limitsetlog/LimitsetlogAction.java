/**
 * auto-generated code
 * Thu Jul 08 10:32:29 CST 2010
 */
 package com.gmcc.pboss.web.sales.limitsetlog;

import com.gmcc.pboss.business.sales.limitsetlog.LimitsetlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.limitsetlog.LimitsetlogDBParam;
import com.gmcc.pboss.control.sales.limitsetlog.Limitsetlog ;

/**
 * <p>Title: LimitsetlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class LimitsetlogAction extends BaseAction{
	
	public LimitsetlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new LimitsetlogForm());
		this.setParam(new LimitsetlogDBParam());

        //ָ��VO��
        setClsVO(LimitsetlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Limitsetlog.class);
		this.setClsQueryParam(LimitsetlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}