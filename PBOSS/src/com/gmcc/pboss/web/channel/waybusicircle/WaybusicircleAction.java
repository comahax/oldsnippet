/**
 * auto-generated code
 * Wed Nov 14 09:58:49 CST 2012
 */
 package com.gmcc.pboss.web.channel.waybusicircle;

import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleDBParam;
import com.gmcc.pboss.control.channel.waybusicircle.Waybusicircle ;

/**
 * <p>Title: WaybusicircleAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class WaybusicircleAction extends BaseAction{
	
	public WaybusicircleAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new WaybusicircleForm());
		this.setParam(new WaybusicircleDBParam());

        //ָ��VO��
        setClsVO(WaybusicircleVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seq"};
		this.setClsControl(Waybusicircle.class);
		this.setClsQueryParam(WaybusicircleDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}