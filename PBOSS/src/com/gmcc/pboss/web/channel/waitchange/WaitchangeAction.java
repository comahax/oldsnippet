/**
 * auto-generated code
 * Thu Dec 01 02:42:27 GMT 2011
 */
 package com.gmcc.pboss.web.channel.waitchange;

import com.gmcc.pboss.business.channel.waitchange.WaitchangeVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.waitchange.WaitchangeDBParam;
import com.gmcc.pboss.control.channel.waitchange.Waitchange ;

/**
 * <p>Title: WaitchangeAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class WaitchangeAction extends BaseAction{
	
	public WaitchangeAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new WaitchangeForm());
		this.setParam(new WaitchangeDBParam());

        //ָ��VO��
        setClsVO(WaitchangeVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"streamno"};
		this.setClsControl(Waitchange.class);
		this.setClsQueryParam(WaitchangeDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}