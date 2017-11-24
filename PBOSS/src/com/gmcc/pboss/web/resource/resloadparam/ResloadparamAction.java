/**
 * auto-generated code
 * Sat Sep 05 16:17:17 CST 2009
 */
 package com.gmcc.pboss.web.resource.resloadparam;

import com.gmcc.pboss.business.resource.resloadparam.ResloadparamVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.resloadparam.ResloadparamDBParam;
import com.gmcc.pboss.control.resource.resloadparam.Resloadparam ;

/**
 * <p>Title: ResloadparamAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResloadparamAction extends BaseAction{
	
	public ResloadparamAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ResloadparamForm());
		this.setParam(new ResloadparamWebParam());

        //指定VO类
        setClsVO(ResloadparamVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"id"};
		this.setClsControl(Resloadparam.class);
		this.setClsQueryParam(ResloadparamDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		ResloadparamDBParam param = (ResloadparamDBParam)super.getParam();
		if( null == param.get_se_cityid())
		param.set_se_cityid(super.getDBAccessUser().getCityid());
		return super.doList();
	}

	@Override
	public String doNew() throws Exception {
		// TODO Auto-generated method stub
		super.doNew();
		ResloadparamForm form = (ResloadparamForm)super.getForm();
		form.setCityid(super.getDBAccessUser().getCityid());
		return "content";
	}
	
	
	
}