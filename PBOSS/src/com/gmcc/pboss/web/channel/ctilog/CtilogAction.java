/**
 * auto-generated code
 * Thu Dec 01 02:07:15 GMT 2011
 */
 package com.gmcc.pboss.web.channel.ctilog;

import com.gmcc.pboss.business.channel.ctilog.CtilogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.ctilog.CtilogDBParam;
import com.gmcc.pboss.control.channel.ctilog.Ctilog ;

/**
 * <p>Title: CtilogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class CtilogAction extends BaseAction{
	
	public CtilogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new CtilogForm());
		this.setParam(new CtilogDBParam());

        //ָ��VO��
        setClsVO(CtilogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Ctilog.class);
		this.setClsQueryParam(CtilogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}