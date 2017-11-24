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

		//以下几个方法是必须的
		this.setForm(new ChPwComsadvinfologForm());
		this.setParam(new ChPwComsadvinfologDBParam());

        //指定VO类
        setClsVO(ChPwComsadvinfologVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(ChPwComsadvinfolog.class);
		this.setClsQueryParam(ChPwComsadvinfologDBParam.class) ;

	}
}