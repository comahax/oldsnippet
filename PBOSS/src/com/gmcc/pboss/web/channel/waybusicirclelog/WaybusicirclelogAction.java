/**
 * auto-generated code
 * Wed Nov 14 09:59:20 CST 2012
 */
 package com.gmcc.pboss.web.channel.waybusicirclelog;

import com.gmcc.pboss.business.channel.waybusicirclelog.WaybusicirclelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.waybusicirclelog.WaybusicirclelogDBParam;
import com.gmcc.pboss.control.channel.waybusicirclelog.Waybusicirclelog ;

/**
 * <p>Title: WaybusicirclelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class WaybusicirclelogAction extends BaseAction{
	
	public WaybusicirclelogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new WaybusicirclelogForm());
		this.setParam(new WaybusicirclelogDBParam());

        //ָ��VO��
        setClsVO(WaybusicirclelogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Waybusicirclelog.class);
		this.setClsQueryParam(WaybusicirclelogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}