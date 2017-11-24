/**
 * auto-generated code
 * Tue Jun 05 08:33:24 CST 2012
 */
 package com.gmcc.pboss.web.channel.checkedapplydetail;

import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyVO;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailDBParam;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailVO;
import com.gmcc.pboss.business.channel.checkedapplydetail.ViewCADVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.operright.Operright;
import com.gmcc.pboss.control.base.operright.OperrightBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.checkedapply.Checkedapply;
import com.gmcc.pboss.control.channel.checkedapply.CheckedapplyBO;
import com.gmcc.pboss.control.channel.checkedapplydetail.Checkedapplydetail;
import com.gmcc.pboss.control.channel.checkedapplydetail.CheckedapplydetailBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: CheckedapplydetailAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class CheckedapplydetailAction extends BaseAction{
	
	// 拥有分公司令牌
	private boolean CH_CHECKED_COUNTY;
	// 拥有市公司初审令牌
	private boolean CH_CHECKED_MIDCITY;
	// 系统参数：授权网点几层审核流程
	private boolean paramvalue;
	
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isCH_CHECKED_COUNTY() {
		return CH_CHECKED_COUNTY;
	}

	public void setCH_CHECKED_COUNTY(boolean ch_checked_county) {
		CH_CHECKED_COUNTY = ch_checked_county;
	}
	
	/**
	 * 1、判断市公司是否配置了系统参数【授权网点几层审核流程】(systemid=83, paramtype=’channel’)并且值为1
	 * 2、判断当前登录用户是否拥有分公司令牌
	 * 3、判断当前登录用户是否拥有市公司初审令牌
	 * @throws Exception
	 */
	private void getSysParme() throws Exception {
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class, getDBAccessUser());
		String value = sysparam.doFindByID("83", "channel");
		if (value != null && value.equals("1")) {
			paramvalue = true;
		}
		
		Operright operright = (Operright) BOFactory.build(OperrightBO.class, DBAccessUser.getInnerUser());
		boolean ch_checked_county = operright.doCheckPermission(getDBAccessUser().getOprcode(), "CH_CHECKED_COUNTY");
		setCH_CHECKED_COUNTY(ch_checked_county);
		
		boolean ch_checked_midcity = operright.doCheckPermission(getDBAccessUser().getOprcode(), "CH_CHECKED_MIDCITY");
		this.setCH_CHECKED_MIDCITY(ch_checked_midcity);
	}

	public CheckedapplydetailAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new CheckedapplydetailForm());
		this.setParam(new CheckedapplydetailDBParam());

        //指定VO类
        setClsVO(CheckedapplydetailVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seq"};
		this.setClsControl(Checkedapplydetail.class);
		this.setClsQueryParam(CheckedapplydetailDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		try{
			Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
			CheckedapplydetailDBParam checkedapplydetailDBParam = (CheckedapplydetailDBParam)getParam();
			/*
			 * 判断市公司是否配置了系统参数【授权网点几层审核流程】并且值为1
			 * 判断当前登录用户是否拥有分公司令牌
			 * 判断当前登录用户是否拥有市公司初审令牌
			 */
			getSysParme();
			
			DataPackage temPackage = checkedapplydetailBO.doQueryCheckedapplydetail(checkedapplydetailDBParam);
			
			this.setDp(temPackage);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}
	
	public String doSave() throws Exception{
		CheckedapplydetailForm fheckedapplydetailForm = (CheckedapplydetailForm)getForm();
		String chktype = fheckedapplydetailForm.getChktype();
		if(chktype == null || "".equals(chktype)){
			super.addActionError("考核方式，不能为空");
			return WEB_RESULT_CONTENT;
		}
		
		return super.doSave();
	}
	
	public String doEdit() throws Exception{
		BaseVO vo = findVOFromDB();
		CheckedapplydetailForm form = (CheckedapplydetailForm)getForm(); 
		BeanUtils.copyProperties(form, vo);
		
		Checkedapply checkedapply = (Checkedapply)BOFactory.build(CheckedapplyBO.class,getDBAccessUser());
		CheckedapplyVO checkedapplyVO =checkedapply.doFindByPk(form.getApplyno());
		setStatus(checkedapplyVO.getStatus());
		setForm(form);
		this.CMD = WEB_CMD_EDIT;
		return WEB_RESULT_CONTENT;
	};
	
	//导出Excel
	public String doExportExcel(){
		try{
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			
			super.getParam().setQueryAll(true);
			export.setFileName("授权网点明细查询");
			
			export.voClassArray = new Class[] {ViewCADVO.class};
			export.queryMethodName = "doQueryCheckedapplydetail";
			
			export.addOutputProperty("seq", "序列号");
			export.addOutputProperty("applyno", "申请单号");
			export.addOutputProperty("cityid", "地市公司",export.CODE2NAME,"#CITYCOMPANY");
			export.addOutputProperty("wtype", "网点类型",export.CODE2NAME,"$CH_WTYPE");
			export.addOutputProperty("chainhead", "所属合作商",export.CODE2NAME,"#WAYIDINFO");
			export.addOutputProperty("wayname", "网点名称");
			export.addOutputProperty("wayid", "渠道编码");
			export.addOutputProperty("address", "详细地址");
			export.addOutputProperty("buztypecode", "商圈类型",export.CODE2NAME,"$CH_BUZTYPE");
			export.addOutputProperty("chktype", "考核方式",export.CODE2NAME,"$CH_ASSESSMTHD");
			export.addOutputProperty("starlevel", "星级评定",export.CODE2NAME,"$CH_STARLEVEL");
			export.addOutputProperty("status", "申请状态",export.CODE2NAME,"$CH_APPSTATUS");
			export.addOutputProperty("applytype", "申请类型",export.CODE2NAME,"$CH_CHECKTYPE");
			export.addOutputProperty("waystatus", "网点申请状态",export.CODE2NAME,"$CH_WAYSTATUS");
			export.addOutputProperty("aptime", "申请时间");
			export.addOutputProperty("oprtime", "审核时间"); 
			this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			super.doExcel();
			
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	public String doQueryCheckedapplydetail() throws Exception {
		try {
			CheckedapplydetailDBParam checkedapplydetailDBParam = (CheckedapplydetailDBParam)getParam();
			
			//全量查询
			checkedapplydetailDBParam.setQueryAll(true);
			
			Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
			DataPackage temPackage = checkedapplydetailBO.doQueryCheckedapplydetail(checkedapplydetailDBParam);
			
			setDp(temPackage);
		} catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return "list";
	}

	public boolean isCH_CHECKED_MIDCITY() {
		return CH_CHECKED_MIDCITY;
	}

	public void setCH_CHECKED_MIDCITY(boolean ch_checked_midcity) {
		CH_CHECKED_MIDCITY = ch_checked_midcity;
	}

	public boolean isParamvalue() {
		return paramvalue;
	}

	public void setParamvalue(boolean paramvalue) {
		this.paramvalue = paramvalue;
	}
}