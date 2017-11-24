/**
 * auto-generated code
 * Tue Oct 20 17:13:30 CST 2009
 */
 package com.gmcc.pboss.web.sales.partnerres;

import com.gmcc.pboss.business.sales.partnerres.PartnerresVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDBParam;
import com.gmcc.pboss.control.sales.partnerres.Partnerres ;

/**
 * <p>Title: PartnerresAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class PartnerresAction extends BaseAction{
	
	public PartnerresAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new PartnerresForm());
		this.setParam(new PartnerresWebParam());

        //指定VO类
        setClsVO(PartnerresVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Partnerres.class);
		this.setClsQueryParam(PartnerresDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}