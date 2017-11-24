/**
 * auto-generated code
 * Wed Sep 02 17:16:59 CST 2009
 */
 package com.gmcc.pboss.web.resource.numtypedeflog;

import com.gmcc.pboss.business.resource.numtypedeflog.NumtypedeflogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.numtypedeflog.NumtypedeflogDBParam;
import com.gmcc.pboss.control.resource.numtypedeflog.Numtypedeflog ;

/**
 * <p>Title: NumtypedeflogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class NumtypedeflogAction extends BaseAction{
	
	public NumtypedeflogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new NumtypedeflogForm());
		this.setParam(new NumtypedeflogWebParam());

        //指定VO类
        setClsVO(NumtypedeflogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Numtypedeflog.class);
		this.setClsQueryParam(NumtypedeflogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		NumtypedeflogDBParam param = (NumtypedeflogDBParam)super.getParam();
		String dnm_optime = param.get_dnm_optime();
		String dnl_optime = param.get_dnl_optime();
		if(dnm_optime != null && dnm_optime.trim().length()==10)
			param.set_dnm_optime(dnm_optime.trim()+" 23:59:59");
		if(dnl_optime != null && dnl_optime.trim().length()==10)
			param.set_dnl_optime(dnl_optime.trim()+" 00:00:00");
		return super.doList();
	}
}