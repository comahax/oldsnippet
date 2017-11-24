/**
 * auto-generated code
 * Tue Dec 07 10:33:29 CST 2010
 */
 package com.gmcc.pboss.web.base.webfunctionitem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.functionitem.FunctionitemDBParam;
import com.gmcc.pboss.business.base.functionitem.FunctionitemVO;
import com.gmcc.pboss.business.base.webfunctionitem.WebfunctionitemVO ;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.base.webfunctionitem.WebfunctionitemDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.functionitem.Functionitem;
import com.gmcc.pboss.control.base.functionitem.FunctionitemBO;
import com.gmcc.pboss.control.base.webfunctionitem.Webfunctionitem ;
import com.gmcc.pboss.control.base.webfunctionitem.WebfunctionitemBO;
import com.gmcc.pboss.web.base.functionitem.FunctionitemForm;

/**
 * <p>Title: WebfunctionitemAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class WebfunctionitemAction extends BaseAction{
	
	public WebfunctionitemAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new WebfunctionitemForm());
		this.setParam(new WebfunctionitemDBParam());

        //指定VO类
        setClsVO(WebfunctionitemVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"funcid"};
		this.setClsControl(Webfunctionitem.class);
		this.setClsQueryParam(WebfunctionitemDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	/**
	 * 获取指定的功能菜单列表及其所有下级子菜单列表;
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doListByParent() throws Exception {
		Webfunctionitem webfunctionitem = (Webfunctionitem) BOFactory.build(
				WebfunctionitemBO.class, getDBAccessUser());
		WebfunctionitemDBParam param = (WebfunctionitemDBParam) super.getParam();
		String parentid = param.get_se_parentid();
		param.getQueryConditions().put("funcid", parentid);// 固定参数查询
		param.setQueryAll(true);
		DataPackage dp = webfunctionitem.doQueryByNameSql(
				"system.webfunctionitem.queryAllFunctionByParentId.test", param);
		super.setDp(dp);
		return "manageList";
	}
	
	/**
	 * 获取当前工号有权限访问的模块
	 */
	public String doMenuTree() throws Exception {
		String cmd = ServletActionContext.getRequest().getParameter("CMD");
		Webfunctionitem webfunctionitem = (Webfunctionitem) BOFactory.build(WebfunctionitemBO.class, getDBAccessUser());
		WebfunctionitemDBParam params = (WebfunctionitemDBParam)getParam();
//		params.getQueryConditions().put("operid", getDBAccessUser().getOprcode());
		params.setQueryAll(true);
		
//		String nameSql = "";
//		if(CoreConfigInfo.IGNORE_MENU_PERM_FLAG || "manageTree".equals(cmd)){//测试环境
//			nameSql = "system.webfunctionitem.queryAllAthorizedFunctionitems.test";
//		}else{
//			nameSql = "system.webfunctionitem.queryAllAthorizedFunctionitems";
//		}
		String nameSql = "system.webfunctionitem.queryAllAthorizedFunctionitems.test";
		
		DataPackage dp = webfunctionitem.doQueryByNameSql(nameSql, params);
		
		setDp(dp);
		if ("manageTree".equals(cmd))
			return "manageTree";
//		if("roleMenuTree".equals(cmd))
//			return "roleMenuTree";
		else
			return "menuTree";
	}
	
	public String doTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网站菜单管理导出");
		export.addOutputProperty("funcid", "菜单编码");
		export.addOutputProperty("funcname", "菜单名称",export.CODE2NAME,"#WEBFUNCTIONITEM");
		export.addOutputProperty("parentid", "上级菜单编码");
		export.addOutputProperty("guiobject", "菜单链接");
		export.addOutputProperty("status", "是否可见",export.CODE2NAME,"$CH_VISIABLE");
		export.addOutputProperty("sortorder", "排序");
		export.voClassArray = new Class[] { WebfunctionitemVO.class };
		export.queryMethodName = "doListall";

		prepareResponse(export.getFileName());
		
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"菜单编码","菜单名称", "上级菜单编码","菜单链接", "是否可见" ,"排序"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网站菜单管理导出");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间",format.format(new Date()) });
		export.addOutputProperty("funcid", "菜单编码");
		export.addOutputProperty("funcname", "菜单名称",export.CODE2NAME,"#WEBFUNCTIONITEM");
		export.addOutputProperty("parentid", "上级菜单编码");
		export.addOutputProperty("guiobject", "菜单链接");
		export.addOutputProperty("status", "是否可见",export.CODE2NAME,"$CH_VISIABLE");
		export.addOutputProperty("sortorder", "排序");
		export.queryMethodName = "doListall";
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	public String doListall() throws Exception{
		WebfunctionitemDBParam param = new WebfunctionitemDBParam();
		param.setQueryAll(true);
		param.set_orderby("funcid");
		setParam(param);
		super.doList();
		return "list";
	}
	
	public String doEdit() throws Exception{
		super.doEdit();
		WebfunctionitemForm form = (WebfunctionitemForm) super.getForm();
		WebfunctionitemDBParam param = (WebfunctionitemDBParam) super.getParam();
		param.set_se_parentid(form.getParentid());
		return WEB_RESULT_CONTENT;
	}
	
	private String buildFuncID(String parentid, DataPackage dp) {
		String funcid = parentid;
		if (dp.getDatas().size() == 0) {
			funcid = parentid + "01";
		} else {
			Iterator<WebfunctionitemVO> itt = dp.getDatas().iterator();
			while (itt.hasNext()) {
				WebfunctionitemVO vo = itt.next();
				if (funcid.compareTo(vo.getFuncid()) < 0) {
					funcid = vo.getFuncid();
				}
			}
			String firstPart = funcid.substring(0, funcid.length() - 2);
			String secPart = funcid.substring(funcid.length() - 2);
			if (secPart.startsWith("0")) {
				int i = Integer.valueOf(secPart) + 1;
				if (i % 10 == 0) {
					secPart = "" + i;
				} else {
					secPart = "0" + i;
				}
			} else {
				int i = Integer.valueOf(secPart) + 1;
				if (i % 10 == 0) {
					secPart = "" + i;
				} else {
					secPart = new Integer(i).toString();
				}
			}
			funcid = firstPart + secPart;
		}
		return funcid;
	}
	
	public String doNew() throws Exception {
		WebfunctionitemForm form = (WebfunctionitemForm) super.getForm();
		WebfunctionitemDBParam param = (WebfunctionitemDBParam) super.getParam();
		form.setParentid(param.get_se_parentid());
		Calendar c = Calendar.getInstance();
		c.set(2099, Calendar.DECEMBER, 31);
		form.setStatusdate(c.getTime());
		this.setCMD(WEB_CMD_NEW);
		if (!param.get_se_parentid().equals("0")) {
			Webfunctionitem item = (Webfunctionitem) BOFactory.build(
					WebfunctionitemBO.class, getDBAccessUser());
			DataPackage dp = item.doQuery(param);
			String funcid = buildFuncID(param.get_se_parentid(), dp);
			form.setFuncid(funcid);
			form.setSortorder(new Short((short) (dp.getDatas().size() + 1)));
		}
		return WEB_RESULT_CONTENT;
	}
}