/**
 * auto-generated code
 * Wed Nov 18 16:14:43 CST 2009
 */
 package com.gmcc.pboss.web.channel.waitreq;

import com.gmcc.pboss.business.channel.waitreq.WaitreqVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.waitreq.WaitreqDBParam;
import com.gmcc.pboss.control.channel.waitreq.Waitreq ;

/**
 * <p>Title: WaitreqAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WaitreqAction extends BaseAction{
	
	public WaitreqAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new WaitreqForm());
		this.setParam(new WaitreqDBParam());

        //ָ��VO��
        setClsVO(WaitreqVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"streamno"};
		this.setClsControl(Waitreq.class);
		this.setClsQueryParam(WaitreqDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}