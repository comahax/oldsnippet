/**
 * auto-generated code
 * Thu Feb 24 16:50:49 CST 2011
 */
 package com.gmcc.pboss.web.channel.smsloghis;

import com.gmcc.pboss.business.channel.smsloghis.SmsloghisVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.smsloghis.SmsloghisDBParam;
import com.gmcc.pboss.control.channel.smsloghis.Smsloghis ;

/**
 * <p>Title: SmsloghisAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class SmsloghisAction extends BaseAction{
	
	public SmsloghisAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SmsloghisForm());
		this.setParam(new SmsloghisDBParam());

        //ָ��VO��
        setClsVO(SmsloghisVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Smsloghis.class);
		this.setClsQueryParam(SmsloghisDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}