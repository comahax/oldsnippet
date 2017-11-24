/**
 * auto-generated code
 * Fri Jul 10 14:35:20 CST 2009
 */
package com.gmcc.pboss.web.base.operrole;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.operator.OperatorDBParam;
import com.gmcc.pboss.business.base.operrole.OperroleDBParam;
import com.gmcc.pboss.business.base.operrole.OperroleVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.operrole.Operrole;
import com.gmcc.pboss.control.base.operrole.OperroleBO;
import com.gmcc.pboss.control.base.role.Role;
import com.gmcc.pboss.control.base.role.RoleBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: OperroleAction
 * </p>
 * ;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Lee
 * @version 1.0
 */
public class OperroleAction extends BaseAction {

	public OperroleAction() {
		super();

		this.setForm(new OperroleForm());
		this.setParam(new OperroleWebParam());

		setClsVO(OperroleVO.class);
		this.pkNameArray = new String[] { "operid", "roleid" };
		this.setClsControl(Operrole.class);
		this.setClsQueryParam(OperroleDBParam.class);
	}	
	
	

	@Override
	public String doList() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		Operrole operrole = (Operrole)BOFactory.build(OperroleBO.class, user);
		OperroleDBParam param = (OperroleDBParam)getParam();
		if (param.get_orderby()==null){
			param.set_orderby("operid");
		}
		DataPackage dp = operrole.doQuery(param, user);
		setDp(dp);
		return "list";
	}



	public String doTxt() throws Exception {
		OperroleDBParam operroledbparam = (OperroleDBParam) super.getParam();
		operroledbparam.setQueryAll(true);
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("操作员角色设置导出");
		export.addOutputProperty("operid", "操作员编码");
		export.addOutputProperty("operid", "姓名",export.CODE2NAME,"#OPERATOR");
		export.addOutputProperty("roleid", "角色编码");
		export.addOutputProperty("roleid", "角色名称",export.CODE2NAME,"#ROLE");
		export.addOutputProperty("createdate", "创建时间",export.DATE,"yyyy-MM-dd");
		export.addOutputProperty("status", "状态",export.CODE2NAME,"$CH_OPRSTATUS");
		export.addOutputProperty("statusdate", "有效时间", CommonExportBean.DATE,
				"yyyy-MM-dd");
		// export.addOutputProperty("resuse", "资源用途", export.CODE2NAME,
		// "$IM_FXRESUSE");
		// export.addOutputProperty("storarea", "所属库区", export.CODE2NAME,
		// "$IM_FXSTORAREA");
		export.voClassArray = new Class[] { OperroleVO.class };

		prepareResponse(export.getFileName());
		
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"操作员编码", "姓名","角色编码","角色名称", "创建时间", "状态", "有效时间" });
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}

	public String doOperrolelist() throws Exception {
		HttpServletRequest request = getRequest();
		try {
			if (!StringUtils.isEmpty(request.getParameter("_sk_opername"))) {
				_sk_opername = request.getParameter("_sk_opername");
			}
			Operator operator = (Operator) BOFactory.build(OperatorBO.class,getDBAccessUser());
			OperatorDBParam oparams = new OperatorDBParam();
			OperroleDBParam orparam = (OperroleDBParam) getParam();
			BeanUtils.copyProperties(oparams, orparam);
			String sql = "region = '"+CityMappingUtil.getCityNo(getDBAccessUser().getCityid())+"' ";
			if(!StringUtils.isEmpty(_sk_opername)){
				sql += "and (operid like '%"+_sk_opername+"%' or opername like '%"+_sk_opername+"%')";
			}
			oparams.getQueryConditions().put("_sql_operid", sql);
			DataPackage dp = operator.doQuery(oparams);
			setDp(dp);
		} catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return "batchoperroleset";
	}
	
	public String doNew() throws Exception {
		OperroleForm form = (OperroleForm)getForm();
		form.setCreatedate(new Date());
		form.setStatusdate(PublicUtils.UtilStrToDate("2099-12-31", "yyyy-MM-dd"));
		this.setCMD(WEB_CMD_NEW);
		Role role = (Role) BOFactory.build(RoleBO.class, getDBAccessUser());
		if (!role.doIfAdmin()){
			getRequest().setAttribute("adminflag",0);
		}
		return WEB_RESULT_CONTENT;
	}

	public String doBatchsave() throws Exception {
		try {
			List operList = Arrays.asList(_selectitem);
			List roleList = new ArrayList();
			OperroleForm form = (OperroleForm)getForm();
			roleList.add(form.getRoleid());
			
			Operrole operrole = (Operrole) BOFactory.build(OperroleBO.class,
					getDBAccessUser());
			operrole.doBatchSave(roleList, operList);
			setActionMessage("批量设置成功!");
			return doOperrolelist();
		} catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
			return "batchoperroleset";
		}
	}

	private String[] _selectitem; // 操作员多选框
	private String[] _selectitem2; // 角色多选框
	private String _sk_opername;

	public String[] get_selectitem() {
		return _selectitem;
	}

	public void set_selectitem(String[] _selectitem) {
		this._selectitem = _selectitem;
	}

	public String[] get_selectitem2() {
		return _selectitem2;
	}

	public void set_selectitem2(String[] _selectitem2) {
		this._selectitem2 = _selectitem2;
	}

	public String get_sk_opername() {
		return _sk_opername;
	}

	public void set_sk_opername(String _sk_opername) {
		this._sk_opername = _sk_opername;
	}

}