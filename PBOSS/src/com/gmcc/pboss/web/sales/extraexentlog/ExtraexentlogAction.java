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

		//以下几个方法是必须的
		this.setForm(new ExtraexentlogForm());
		this.setParam(new ExtraexentlogDBParam());

        //指定VO类
        setClsVO(ExtraexentlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Extraexentlog.class);
		this.setClsQueryParam(ExtraexentlogDBParam.class) ;

	}
}