/**
 * auto-generated code
 * Tue Oct 18 10:45:19 CST 2011
 */
 package com.gmcc.pboss.web.reward.cardrewdetlog;

import com.gmcc.pboss.business.reward.cardrewdetlog.CardrewdetlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.reward.cardrewdetlog.CardrewdetlogDBParam;
import com.gmcc.pboss.control.reward.cardrewdetlog.Cardrewdetlog ;

/**
 * <p>Title: CardrewdetlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CardrewdetlogAction extends BaseAction{
	
	public CardrewdetlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new CardrewdetlogForm());
		this.setParam(new CardrewdetlogDBParam());

        //指定VO类
        setClsVO(CardrewdetlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Cardrewdetlog.class);
		this.setClsQueryParam(CardrewdetlogDBParam.class) ;

	}
}