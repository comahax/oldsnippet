/**
 * auto-generated code
 * Sun Jun 19 20:24:03 CST 2011
 */
 package com.gmcc.pboss.web.sales.extraexentlog;

import com.gmcc.pboss.business.sales.extraexentlog.ExtraexentlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.extraexentlog.ExtraexentlogDBParam;
import com.gmcc.pboss.control.sales.extraexentlog.Extraexentlog ;

/**
 * <p>Title: ExtraexentlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ExtraexentlogAction extends BaseAction{
	
	public ExtraexentlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ExtraexentlogForm());
		this.setParam(new ExtraexentlogDBParam());

        //ָ��VO��
        setClsVO(ExtraexentlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Extraexentlog.class);
		this.setClsQueryParam(ExtraexentlogDBParam.class) ;

	}
}