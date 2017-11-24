/**
 * auto-generated code
 * Thu Jul 09 16:16:16 CST 2009
 */
 package com.gmcc.pboss.web.base.roleright;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.role.RoleDBParam;
import com.gmcc.pboss.business.base.roleright.RolerightDBParam;
import com.gmcc.pboss.business.base.roleright.RolerightVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.jqTable.ColumnSet;
import com.gmcc.pboss.control.base.role.Role;
import com.gmcc.pboss.control.base.role.RoleBO;
import com.gmcc.pboss.control.base.roleright.Roleright;
import com.gmcc.pboss.control.base.roleright.RolerightBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: RolerightAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
public class RolerightAction extends BaseAction{
	
	public RolerightAction() {
		super();

		//????????·?·¨??±?????
		this.setForm(new RolerightForm());
		this.setParam(new RolerightWebParam());

        //???¨VO?à
        setClsVO(RolerightVO.class);
        //???¨?÷?ü??×é?????????????÷?ü???ò?è???¨?????????÷?ü??×???????
        this.pkNameArray=new String[]{"itemid","rightid"};
		this.setClsControl(Roleright.class);
		this.setClsQueryParam(RolerightDBParam.class) ;

		/**
		 * ???????¨??????????????????BaseAction??CRUD???á?÷?????¨??Delegate????°??é??????±????¨
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		Roleright bo = (Roleright)BOFactory.build(RolerightBO.class, user);
		RolerightDBParam params = (RolerightDBParam)getParam();
		DataPackage dp = bo.doQuery(params, user);
		setDp(dp);
		return "list";
	}
	
	public String doTxt() throws Exception {
		RolerightDBParam rolerightParam = (RolerightDBParam) super.getParam();
		rolerightParam.setQueryAll(true);
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("角色令牌授权导出");
		export.addOutputProperty("itemid", "角色编码");
		export.addOutputProperty("itemid", "角色名称",export.CODE2NAME,"#ROLE");
		export.addOutputProperty("rightid", "令牌编码");
		export.addOutputProperty("rightid", "令牌名称",export.CODE2NAME,"#RIGHTITEM");
		export.addOutputProperty("createdate", "创建时间",export.DATE,"yyyy-MM-dd");
		export.addOutputProperty("status", "状态",export.CODE2NAME,"$CH_OPRSTATUS");
		export.addOutputProperty("statusdate", "有效时间",export.DATE,"yyyy-MM-dd");
		export.voClassArray = new Class[] { RolerightVO.class };

		getResponse().setHeader("pragma", "no-cache");
		getResponse().setHeader("Cache-control", "public");
		getResponse().setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		getResponse().setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		getResponse().setContentType("text/plain");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"角色编码", "角色名称","令牌编码","令牌名称", "创建时间", "状态" ,"有效时间"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("角色令牌授权导出");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间",format.format(new Date()) });
		export.addOutputProperty("itemid", "角色编码");
		export.addOutputProperty("itemid", "角色名称",export.CODE2NAME,"#ROLE");
		export.addOutputProperty("rightid", "令牌编码");
		export.addOutputProperty("rightid", "令牌名称",export.CODE2NAME,"#RIGHTITEM");
		export.addOutputProperty("createdate", "创建时间",export.DATE,"yyyy-MM-dd");
		export.addOutputProperty("status", "状态",export.CODE2NAME,"$CH_OPRSTATUS");
		export.addOutputProperty("statusdate", "有效时间",export.DATE,"yyyy-MM-dd");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	public String doBatchlist() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			//令牌树展现
			String contextPath = request.getContextPath();
			String topChildrenURI = "selectRightXml.jsp";
			
			
			String rootId = "0";
			String rootName = "令牌树";

			if(!StringUtils.isEmpty(request.getParameter("queryText"))){
				queryText = request.getParameter("queryText");
			}
			
			StringBuffer topChildrenURLBuffer = new StringBuffer(100);
			topChildrenURLBuffer.append(contextPath).append("/base/rightitem/").append(topChildrenURI)
				.append("?parentid=").append(rootId)
				.append("&parentname=").append(rootName)
				.append("&queryText=").append(queryText)
				.append("&childrenURL=").append(contextPath).append("/base/rightitem/").append(topChildrenURI);
			
			System.out.println(topChildrenURLBuffer.toString());
			
			request.setAttribute("rootId", rootId);
			request.setAttribute("rootName", rootName);
			request.setAttribute("topChildrenURL", topChildrenURLBuffer.toString());
			request.setAttribute("queryText", queryText);
			
//			//角色展现
//			Role role = (Role) BOFactory.build(RoleBO.class, getDBAccessUser());
//			RoleDBParam rparams = new RoleDBParam();
//			RolerightDBParam rrparam = (RolerightDBParam) getParam();
//			BeanUtils.copyProperties(rparams, rrparam);
//			String sql = "roleid like '%"+queryRole+"%' or rolename like '%"+queryRole+"%'";
//			rparams.getQueryConditions().put("_sql_roleid", sql);
//				
//			DataPackage dp = role.doQuery(rparams);
//			setDp(dp);
			
		}catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
			request.setAttribute("rootName", "非法数据");
			// TODO: handle exception
		}
		return "batchlist";
	}
	
	public String doBatchJSONlist(){
		//角色展现
		try{
			HttpServletRequest request = getRequest();
			User user = (User) request.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			Role role = (Role) BOFactory.build(RoleBO.class, getDBAccessUser());
			RoleDBParam oparams = new RoleDBParam();
			RolerightDBParam orparam = (RolerightDBParam) getParam();
			BeanUtils.copyProperties(oparams, orparam);
			String sql = "Roleid like '%"+queryRole+"%' or Rolename like '%"+queryRole+"%'";
			oparams.getQueryConditions().put("_sql_operid", sql);
				
			DataPackage dp = role.doQuery(oparams,user);
			this.writeJSONDataPackage(dp, this.getsetCols());
//			setDp(dp);
			
		}catch(Exception e){
			e.printStackTrace();
			setActionMessage(e.getMessage());
			this.writeJSONError(e.getMessage());
		}
		return null;
	}
	
	
	@Override
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("sel","<input type=\"checkbox\" name=\"allbox\" onclick=\"checkAll();\" />",true));
		setCols.add(new ColumnSet("roleid", "角色编码"));
		setCols.add(new ColumnSet("rolename", "角色名称"));
		return setCols;
	}
	
	public String doBatchsave() throws Exception {
		try{
			List rightList = new ArrayList();
			for(int i=0;i<_selectitem_checkbox.length;i++){
				String right = _selectitem_checkbox[i].substring(_selectitem_checkbox[i].indexOf("(")+1, _selectitem_checkbox[i].indexOf(")"));
				rightList.add(right);
			}
			List roleList = Arrays.asList(_selectitem);
			Roleright roleright = (Roleright)BOFactory.build(RolerightBO.class, getDBAccessUser());
			roleright.doBatchSave(rightList, roleList);
			setActionMessage("批量授权成功!");
			return doBatchlist();
		}catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
			// TODO: handle exception
		}
		return "batchlist";
	}
	
	public String doNew() throws Exception{
		// 新建时设置form的默认值
		RolerightForm form = (RolerightForm)getForm();
		form.setStatus(new Byte("1"));
		form.setCreatedate(new Date());
		form.setStatusdate(PublicUtils.UtilStrToDate("2099-12-31", "yyyy-MM-dd"));
		this.CMD = WEB_CMD_NEW;
		Role role = (Role) BOFactory.build(RoleBO.class, getDBAccessUser());
		if (!role.doIfAdmin()){
			getRequest().setAttribute("adminflag",0);
		}
		return WEB_RESULT_CONTENT;
	}
	
	private String queryText = ""; 
	private String queryRole = ""; 
	private String[] _selectitem_checkbox; 
	private String[] _selectitem;  
	
	public String[] get_selectitem() {
		return _selectitem;
	}

	public void set_selectitem(String[] _selectitem) {
		this._selectitem = _selectitem;
	}

	public String[] get_selectitem_checkbox() {
		return _selectitem_checkbox;
	}

	public void set_selectitem_checkbox(String[] _selectitem_checkbox) {
		this._selectitem_checkbox = _selectitem_checkbox;
	}

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public String getQueryRole() {
		return queryRole;
	}

	public void setQueryRole(String queryRole) {
		this.queryRole = queryRole;
	}
}