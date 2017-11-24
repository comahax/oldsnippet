/**
 * auto-generated code
 * Fri Mar 20 16:55:40 CST 2015
 */
 package com.gmcc.pboss.web.communication.chpwcomsrcvobj;

import com.gmcc.pboss.business.communication.chpwcomsrcvobj.ChPwComsrcvobjVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.communication.chpwcomsrcvobj.ChPwComsrcvobjDBParam;
import com.gmcc.pboss.control.communication.chpwcomsrcvobj.ChPwComsrcvobj ;

/**
 * <p>Title: ChPwComsrcvobjAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPwComsrcvobjAction extends BaseAction{
	
	public ChPwComsrcvobjAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ChPwComsrcvobjForm());
		this.setParam(new ChPwComsrcvobjDBParam());

        //指定VO类
        setClsVO(ChPwComsrcvobjVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"rvcobjid"};
		this.setClsControl(ChPwComsrcvobj.class);
		this.setClsQueryParam(ChPwComsrcvobjDBParam.class) ;

	}

	public String doStatistics() throws Exception {
		ChPwComsrcvobjDBParam  param = (ChPwComsrcvobjDBParam) this.getParam();
		param.set_orderby("state");
		param.set_desc("1");
		super.doList();
		return "statistics";
	}
}