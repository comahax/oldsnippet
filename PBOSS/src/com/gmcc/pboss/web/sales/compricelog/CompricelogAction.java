/**
 * auto-generated code
 * Thu Jul 01 16:47:05 CST 2010
 */
 package com.gmcc.pboss.web.sales.compricelog;

import com.gmcc.pboss.business.sales.compricelog.CompricelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.compricelog.CompricelogDBParam;
import com.gmcc.pboss.control.sales.compricelog.Compricelog ;

/**
 * <p>Title: CompricelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class CompricelogAction extends BaseAction{
	
	public CompricelogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new CompricelogForm());
		this.setParam(new CompricelogWebParam());

        //指定VO类
        setClsVO(CompricelogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Compricelog.class);
		this.setClsQueryParam(CompricelogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}