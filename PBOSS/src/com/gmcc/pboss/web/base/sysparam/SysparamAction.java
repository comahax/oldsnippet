/**
 * auto-generated code
 * Wed Sep 02 17:01:06 CST 2009
 */
package com.gmcc.pboss.web.base.sysparam;

import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.sunrise.jop.common.utils.i18n.I18nMessage;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.gmcc.pboss.business.base.sysparam.SysparamDBParam;
import com.gmcc.pboss.control.base.sysparam.Sysparam;

/**
 * <p>
 * Title: SysparamAction
 * </p>
 * ;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Yedaoe
 * @version 1.0
 */
public class SysparamAction extends BaseAction {

	public SysparamAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SysparamForm());
		this.setParam(new SysparamWebParam());

        //ָ��VO��
        setClsVO(SysparamVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"paramtype","systemid"};
		this.setClsControl(Sysparam.class);
		this.setClsQueryParam(SysparamDBParam.class) ;
	}
	
	protected void onDuplicatePk() {
		setActionMessage("ϵͳ�Ѵ��ڸ�ϵͳ����!");
	}
}