/**
 * auto-generated code
 * Sun Sep 13 11:05:37 CST 2009
 */
 package com.gmcc.pboss.web.channel.microarea;

import com.gmcc.pboss.business.channel.microarea.MicroareaVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.microarea.MicroareaDBParam;
import com.gmcc.pboss.control.channel.microarea.Microarea ;

/**
 * <p>Title: MicroareaAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class MicroareaAction extends BaseAction{
	
	public MicroareaAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new MicroareaForm());
		this.setParam(new MicroareaWebParam());

        //ָ��VO��
        setClsVO(MicroareaVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"macode","maname","svccode"};
		this.setClsControl(Microarea.class);
		this.setClsQueryParam(MicroareaDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}