/**
 * auto-generated code
 * Thu Feb 24 16:49:38 CST 2011
 */
 package com.gmcc.pboss.web.channel.smslog;

import com.gmcc.pboss.business.channel.smslog.SmslogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.smslog.SmslogDBParam;
import com.gmcc.pboss.control.channel.smslog.Smslog ;

/**
 * <p>Title: SmslogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class SmslogAction extends BaseAction{
	
	public SmslogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SmslogForm());
		this.setParam(new SmslogDBParam());

        //ָ��VO��
        setClsVO(SmslogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Smslog.class);
		this.setClsQueryParam(SmslogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}