/**
 * auto-generated code
 * Thu Sep 03 15:32:51 CST 2009
 */
 package com.gmcc.pboss.web.base.dictitem;

import com.gmcc.pboss.business.base.dictitem.DictitemVO ;
import com.sunrise.jop.common.utils.i18n.I18nMessage;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.control.base.dictitem.Dictitem ;

/**
 * <p>Title: DictitemAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class DictitemAction extends BaseAction{
	
	public DictitemAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new DictitemForm());
		this.setParam(new DictitemWebParam());

        //指定VO类
        setClsVO(DictitemVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"dictid","groupid"};
		this.setClsControl(Dictitem.class);
		this.setClsQueryParam(DictitemDBParam.class) ;		
	}
	
	protected void onDuplicatePk() {
		setActionMessage("系统已存在该固定参数!");
	}
}