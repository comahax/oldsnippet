/**
 * auto-generated code
 * Mon Mar 23 12:59:35 CST 2015
 */
 package com.gmcc.pboss.web.communication.chpwcomsadvinfolog;

import com.gmcc.pboss.business.communication.chpwcomsadvinfolog.ChPwComsadvinfologVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.communication.chpwcomsadvinfolog.ChPwComsadvinfologDBParam;
import com.gmcc.pboss.control.communication.chpwcomsadvinfolog.ChPwComsadvinfolog ;

/**
 * <p>Title: ChPwComsadvinfologAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPwComsadvinfologAction extends BaseAction{
	
	public ChPwComsadvinfologAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ChPwComsadvinfologForm());
		this.setParam(new ChPwComsadvinfologDBParam());

        //ָ��VO��
        setClsVO(ChPwComsadvinfologVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(ChPwComsadvinfolog.class);
		this.setClsQueryParam(ChPwComsadvinfologDBParam.class) ;

	}
}