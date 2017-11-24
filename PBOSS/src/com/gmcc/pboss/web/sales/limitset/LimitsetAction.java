/**
 * auto-generated code
 * Thu Jul 08 10:27:55 CST 2010
 */
 package com.gmcc.pboss.web.sales.limitset;

import com.gmcc.pboss.business.sales.limitset.LimitsetDBParam;
import com.gmcc.pboss.business.sales.limitset.LimitsetVO;
import com.gmcc.pboss.control.sales.limitset.Limitset;
import com.gmcc.pboss.control.sales.limitset.LimitsetBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: LimitsetAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class LimitsetAction extends BaseAction{
	
	public LimitsetAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new LimitsetForm());
		this.setParam(new LimitsetDBParam());

        //指定VO类
        setClsVO(LimitsetVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Limitset.class);
		this.setClsQueryParam(LimitsetDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		String cityid = getDBAccessUser().getCityid();
		LimitsetForm form= (LimitsetForm) getForm();
		form.setCityid(cityid);
		
		LimitsetDBParam param = (LimitsetDBParam)getParam();
		param.set_se_cityid(cityid);
		
		super.doList();
		return WEB_RESULT_LIST;
	}
	
	public String doNew() throws Exception{
		super.doNew();
		String cityid = getDBAccessUser().getCityid();
		LimitsetForm form= (LimitsetForm) getForm();
		form.setCityid(cityid);
		
		return WEB_RESULT_CONTENT;
	}
	
	public String doSave() throws Exception{
		LimitsetForm form= (LimitsetForm) getForm();
		Limitset limitset = (Limitset)BOFactory.build(LimitsetBO.class,getDBAccessUser());
		
		//查询记录是否已经存在
		LimitsetDBParam param = new LimitsetDBParam();
		param.set_se_cityid(form.getCityid());
		param.set_se_countyid(form.getCountyid());
		param.set_se_comcategory(form.getComcategory());
		param.set_ne_starlevel(String.valueOf(form.getStarlevel()));
		
		if (WEB_CMD_EDIT.equals(CMD)) {
			param.set_nne_recid(form.getRecid().toString());
		}
		DataPackage dp = limitset.doQuery(param);
		if (dp.getRowCount() > 0) {
			addActionError("相同记录已经存在，请检查。");
			return WEB_RESULT_CONTENT;
		}

		super.doSave();
		setActionMessage("保存成功!");
		setCMD(WEB_CMD_SAVE);
		
		return WEB_RESULT_CONTENT;
	}
}