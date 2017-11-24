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

		//以下几个方法是必须的
		this.setForm(new SysparamForm());
		this.setParam(new SysparamWebParam());

        //指定VO类
        setClsVO(SysparamVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"paramtype","systemid"};
		this.setClsControl(Sysparam.class);
		this.setClsQueryParam(SysparamDBParam.class) ;
	}
	
	protected void onDuplicatePk() {
		setActionMessage("系统已存在该系统参数!");
	}
}