/**
 * auto-generated code
 * Tue Aug 24 11:24:17 CST 2010
 */
 package com.gmcc.pboss.web.sales.bankdeduct;

import java.util.Date;

import com.gmcc.pboss.business.sales.bankdeduct.BankdeductVO ;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductDBParam;
import com.gmcc.pboss.control.sales.bankdeduct.Bankdeduct ;

/**
 * <p>Title: BankdeductAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class BankdeductAction extends BaseAction{
	
	public BankdeductAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new BankdeductForm());
		this.setParam(new BankdeductDBParam());

        //指定VO类
        setClsVO(BankdeductVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"deductid"};
		this.setClsControl(Bankdeduct.class);
		this.setClsQueryParam(BankdeductDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doList() throws Exception {
		BankdeductDBParam param = (BankdeductDBParam)getParam();
		//默认按当天的起始时间查询
		if(null == param.get_dnl_creatdate() )
			param.set_dnl_creatdate(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00");
		if(null == param.get_dnm_creatdate() )
			param.set_dnm_creatdate(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
		return super.doList();
	}
}