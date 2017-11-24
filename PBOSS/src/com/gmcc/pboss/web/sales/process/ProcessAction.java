/**
 * auto-generated code
 * Wed Oct 14 09:04:57 CST 2009
 */
 package com.gmcc.pboss.web.sales.process;

import com.gmcc.pboss.business.sales.process.ProcessVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.process.ProcessDBParam;
import com.gmcc.pboss.control.sales.process.Process ;

/**
 * <p>Title: ProcessAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ProcessAction extends BaseAction{
	
	public ProcessAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ProcessForm());
		this.setParam(new ProcessWebParam());

        //指定VO类
        setClsVO(ProcessVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"processid"};
		this.setClsControl(Process.class);
		this.setClsQueryParam(ProcessDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doNew() throws Exception {
		// TODO Auto-generated method stub
		super.doNew();
		ProcessForm form = (ProcessForm)super.getForm();
		form.setCityid(super.getDBAccessUser().getCityid());
		return WEB_RESULT_CONTENT;
	}

	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		ProcessWebParam param = (ProcessWebParam)super.getParam();
		param.set_se_cityid(super.getDBAccessUser().getCityid());
		return super.doList();
	}

	
}