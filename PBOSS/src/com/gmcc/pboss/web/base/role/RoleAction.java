package com.gmcc.pboss.web.base.role;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.gmcc.pboss.business.base.operrole.OperroleDBParam;
import com.gmcc.pboss.business.base.operrole.OperroleVO;
import com.gmcc.pboss.business.base.role.RoleDBParam;
import com.gmcc.pboss.business.base.role.RoleVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.role.Role;
import com.gmcc.pboss.control.base.role.RoleBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: BooCommuncustrelatAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */

public class RoleAction extends BaseAction{
	
	public RoleAction(){
		super();
		this.setForm(new RoleForm());
		this.setParam(new RoleWebParam());
		
		setClsVO(RoleVO.class);
		this.pkNameArray=new String[1];
		pkNameArray[0]="roleid";
		
		this.setClsControl(Role.class);
		this.setClsQueryParam(RoleDBParam.class);
	}
	
	
	
	@Override
	public String doList() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		RoleDBParam param = (RoleDBParam)getParam();
		Role role = (Role) BOFactory.build(RoleBO.class, getDBAccessUser());
		DataPackage dp = role.doQuery(param,user);
		setDp(dp);
		return WEB_RESULT_LIST;
	}



	public String doNew() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		RoleForm form = (RoleForm)getForm();
		form.setCreatedate(new Date());
		form.setOrgid(user.getWayid());
		form.setOperid(user.getOprcode());
		form.setIsback(new Byte("0"));
		form.setStatus(new Byte("1"));
		//form.setIspublic(new Byte("1"));
		form.setStatusdate(PublicUtils.UtilStrToDate("2099-12-31", "yyyy-MM-dd"));
		this.setCMD(WEB_CMD_NEW);
		return WEB_RESULT_CONTENT;
	}
	
	public String doTxt() throws Exception {
		RoleDBParam roledbparam = (RoleDBParam) super.getParam();
		roledbparam.setQueryAll(true);
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("角色管理导出");
		export.addOutputProperty("roleid", "角色编码");
		export.addOutputProperty("roleid", "角色名称",export.CODE2NAME,"#ROLE");
		export.addOutputProperty("ispublic", "是否全局",export.CODE2NAME,"$IM_YESNO10");
		export.addOutputProperty("status", "状态",export.CODE2NAME,"$CH_OPRSTATUS");
		export.voClassArray = new Class[] { RoleVO.class };

		prepareResponse(export.getFileName());
		
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"角色编码","角色名称", "是否全局", "状态" });
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	public String doRoleselect() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		RoleDBParam param = (RoleDBParam)getParam();
		Role role = (Role) BOFactory.build(RoleBO.class, getDBAccessUser());
		DataPackage dp = role.doQuery(param,user);
		setDp(dp);
		return "roleselect";
	}
	
	/**
	 * 查询有效的角色
	 * @return
	 * @throws Exception
	 */
	public String doRolequerys() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		RoleDBParam param = (RoleDBParam)getParam();
		Role role = (Role) BOFactory.build(RoleBO.class, getDBAccessUser());
		param.set_ne_status("1"); // 添加状态为1有效的过滤条件
		DataPackage dp = role.doQuery(param,user);
		setDp(dp);
		return "rolequerys";
	}
}
