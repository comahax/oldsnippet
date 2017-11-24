package com.gmcc.pboss.web.resource.resalarmrulelog;


import com.gmcc.pboss.business.resource.resalarmrulelog.ResalarmrulelogDBParam;
import com.gmcc.pboss.business.resource.resalarmrulelog.ResalarmrulelogVO;
import com.gmcc.pboss.control.resource.resalarmrulelog.Resalarmrulelog;
import com.sunrise.jop.ui.struts2.BaseAction ;


/**
 * <p>Title: ResalarmrulelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResalarmrulelogAction extends BaseAction{
	
	public ResalarmrulelogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ResalarmrulelogForm());
		this.setParam(new ResalarmrulelogDBParam());

        //指定VO类
        setClsVO(ResalarmrulelogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Resalarmrulelog.class);
		this.setClsQueryParam(ResalarmrulelogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}