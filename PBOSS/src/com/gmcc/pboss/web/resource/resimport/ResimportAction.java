/**
 * auto-generated code
 * Fri Sep 25 15:01:17 CST 2009
 */
 package com.gmcc.pboss.web.resource.resimport;

import com.gmcc.pboss.business.resource.resimport.ResimportVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.resimport.ResimportDBParam;
import com.gmcc.pboss.control.resource.resimport.Resimport ;

/**
 * <p>Title: ResimportAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResimportAction extends BaseAction{
	
	public ResimportAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ResimportForm());
		this.setParam(new ResimportWebParam());

        //指定VO类
        setClsVO(ResimportVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Resimport.class);
		this.setClsQueryParam(ResimportDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}