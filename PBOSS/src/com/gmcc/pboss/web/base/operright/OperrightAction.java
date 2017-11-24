/**
 * auto-generated code
 * Mon Jul 13 10:33:51 CST 2009
 */
 package com.gmcc.pboss.web.base.operright;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.operator.OperatorDBParam;
import com.gmcc.pboss.business.base.operfunction.OperfunctionDBParam;
import com.gmcc.pboss.business.base.operright.OperrightDBParam;
import com.gmcc.pboss.business.base.operright.OperrightVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.jqTable.ColumnSet;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.operright.Operright;
import com.gmcc.pboss.control.base.operright.OperrightBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: OperrightAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Lee
 * @version 1.0
 */
public class OperrightAction extends BaseAction{
	
	public OperrightAction() {
		super();

		this.setForm(new OperrightForm());
		this.setParam(new OperrightWebParam());

        setClsVO(OperrightVO.class);
        this.pkNameArray=new String[]{"operid","rightid",};
		this.setClsControl(Operright.class);
		this.setClsQueryParam(OperrightDBParam.class) ;

	}
	
	public String doTxt() throws Exception {
		OperrightDBParam operrightdbparam = (OperrightDBParam) super.getParam();
		operrightdbparam.setQueryAll(true);
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("操作员令牌授权导出");
		export.addOutputProperty("operid", "操作员编码");
		export.addOutputProperty("operid", "姓名",export.CODE2NAME,"#OPERATOR");
		export.addOutputProperty("rightid", "令牌编码");
		export.addOutputProperty("rightid", "令牌名称",export.CODE2NAME,"#RIGHTITEM");
		export.addOutputProperty("status", "状态",export.CODE2NAME,"$CH_OPRSTATUS");
		export.addOutputProperty("createdate", "创建时间",export.DATE,"yyyy-MM-dd");
		export.addOutputProperty("statusdate", "有效时间",export.DATE,"yyyy-MM-dd");
		export.voClassArray = new Class[] { OperrightVO.class };

		prepareResponse(export.getFileName());
		
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"操作员编码","姓名", "令牌编码","令牌名称", "状态" ,"创建时间", "有效时间"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("操作员令牌授权导出");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间",format.format(new Date()) });
		export.addOutputProperty("operid", "操作员编码");
		export.addOutputProperty("operid", "姓名",export.CODE2NAME,"#OPERATOR");
		export.addOutputProperty("rightid", "令牌编码");
		export.addOutputProperty("rightid", "令牌名称",export.CODE2NAME,"#RIGHTITEM");
		export.addOutputProperty("status", "状态",export.CODE2NAME,"$CH_OPRSTATUS");
		export.addOutputProperty("createdate", "创建时间",export.DATE,"yyyy-MM-dd");
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
			if(!StringUtils.isEmpty(request.getParameter("queryRole"))){
				queryRole = request.getParameter("queryRole");
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
			
//			//操作员展现
//			Operator operator = (Operator) BOFactory.build(OperatorBO.class, getDBAccessUser());
//			OperatorDBParam oparams = new OperatorDBParam();
//			OperrightDBParam orparam = (OperrightDBParam) getParam();
//			BeanUtils.copyProperties(oparams, orparam);
//			String sql = "region = '"+CityMappingUtil.getCityNo(getDBAccessUser().getCityid())+"' ";
//			if(!StringUtils.isEmpty(queryRole)){
//				sql += "and (operid like '%"+queryRole+"%' or opername like '%"+queryRole+"%')";
//			}
//			oparams.getQueryConditions().put("_sql_operid", sql);
//			DataPackage dp = operator.doQuery(oparams);
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
		//操作员展现
		try{
			//操作员展现
			Operator operator = (Operator) BOFactory.build(OperatorBO.class, getDBAccessUser());
			OperatorDBParam oparams = new OperatorDBParam();
			OperrightDBParam orparam = (OperrightDBParam) getParam();
			BeanUtils.copyProperties(oparams, orparam);
			String sql = "region = '"+CityMappingUtil.getCityNo(getDBAccessUser().getCityid())+"' ";
			if(!StringUtils.isEmpty(queryRole)){
				sql += "and (operid like '%"+queryRole+"%' or opername like '%"+queryRole+"%')";
			}
			oparams.getQueryConditions().put("_sql_operid", sql);
			DataPackage dp = operator.doQuery(oparams);
			this.writeJSONDataPackage(dp, this.getsetCols());
			
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
		setCols.add(new ColumnSet("operid", "工号"));
		setCols.add(new ColumnSet("opername", "姓名"));
		return setCols;
	}
	
	
	public String doBatchsave() throws Exception {
		try{
			List rightList = new ArrayList();
			for(int i=0;i<_selectitem_checkbox.length;i++){
				String right = _selectitem_checkbox[i].substring(_selectitem_checkbox[i].indexOf("(")+1, _selectitem_checkbox[i].indexOf(")"));
				rightList.add(right);
			}
			List operList = Arrays.asList(_selectitem);
			Operright operright = (Operright)BOFactory.build(OperrightBO.class, getDBAccessUser());
			operright.doBatchSave(rightList, operList);
			setActionMessage("批量授权成功!");
			return doBatchlist();
		}catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
			// TODO: handle exception
		}
		return "batchlist";
	}
	
	@Override
	public String doSave() throws Exception {
		// TODO Auto-generated method stub
		OperrightForm form = (OperrightForm) getForm();
		return super.doSave();
	}
	
	public String doNew() throws Exception{
		// 新建时设置form的默认值
		OperrightForm form = (OperrightForm)getForm();
		form.setStatus(new Byte("1"));
		form.setCreatedate(new Date());
		form.setStatusdate(PublicUtils.UtilStrToDate("2099-12-31", "yyyy-MM-dd"));
		this.CMD = WEB_CMD_NEW;
		return WEB_RESULT_CONTENT;
	}
	
	private String queryText = ""; //令牌查询
	private String queryRole = ""; //角色查询
	private String[] _selectitem_checkbox; //令牌多选框
	private String[] _selectitem;  //角色多选框
	
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