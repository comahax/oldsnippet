/**
 * auto-generated code
 * Tue Sep 01 21:01:30 CST 2009
 */
 package com.gmcc.pboss.web.base.rolefunction;

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
import com.gmcc.pboss.business.base.rolefunction.RolefunctionDBParam;
import com.gmcc.pboss.business.base.rolefunction.RolefunctionVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.jqTable.ColumnSet;
import com.gmcc.pboss.control.base.role.Role;
import com.gmcc.pboss.control.base.role.RoleBO;
import com.gmcc.pboss.control.base.rolefunction.Rolefunction;
import com.gmcc.pboss.control.base.rolefunction.RolefunctionBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: RolefunctionAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class RolefunctionAction extends BaseAction{
	
	public RolefunctionAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new RolefunctionForm());
		this.setParam(new RolefunctionWebParam());

        //ָ��VO��
        setClsVO(RolefunctionVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"functionid","itemid"};
		this.setClsControl(Rolefunction.class);
		this.setClsQueryParam(RolefunctionDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		Rolefunction bo = (Rolefunction)BOFactory.build(RolefunctionBO.class, user);
		RolefunctionDBParam params = (RolefunctionDBParam)getParam();
		DataPackage dp = bo.doQuery(params, user);
		setDp(dp);
		return "list";
	}
	
	public String doTxt() throws Exception {
		RolefunctionDBParam rolefunctionParam = (RolefunctionDBParam) super.getParam();
		rolefunctionParam.setQueryAll(true);
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("��ɫ�˵���Ȩ����");
		export.addOutputProperty("itemid", "��ɫ����");
		export.addOutputProperty("itemid", "��ɫ����",export.CODE2NAME,"#ROLE");
		export.addOutputProperty("functionid", "�˵�����");
		export.addOutputProperty("functionid", "�˵����� ",export.CODE2NAME,"#FUNCTIONITEM");
		export.addOutputProperty("createdate", "����ʱ��",export.DATE,"yyyy-MM-dd");
		export.addOutputProperty("status", "״̬",export.CODE2NAME,"$CH_OPRSTATUS");
		export.addOutputProperty("statusdate", "��Чʱ��",export.DATE,"yyyy-MM-dd");
		export.voClassArray = new Class[] { RolefunctionVO.class };

		prepareResponse(export.getFileName());
		
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"��ɫ����", "��ɫ����", "�˵�����", "�˵����� ",  "����ʱ��" ,"״̬","��Чʱ��"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("��ɫ�˵���Ȩ����");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��",format.format(new Date()) });
		export.addOutputProperty("itemid", "��ɫ����");
		export.addOutputProperty("itemid", "��ɫ����",export.CODE2NAME,"#ROLE");
		export.addOutputProperty("functionid", "�˵�����");
		export.addOutputProperty("functionid", "�˵����� ",export.CODE2NAME,"#FUNCTIONITEM");
		export.addOutputProperty("createdate", "����ʱ��",export.DATE,"yyyy-MM-dd");
		export.addOutputProperty("status", "״̬",export.CODE2NAME,"$CH_OPRSTATUS");
		export.addOutputProperty("statusdate", "��Чʱ��",export.DATE,"yyyy-MM-dd");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	public String doBatchlist() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			//�˵���չ��
			String contextPath = request.getContextPath();
			String topChildrenURI = "selectFuncXml.jsp";
			
			
			String rootId = "0";
			String rootName = "�˵���";

			if(!StringUtils.isEmpty(request.getParameter("queryText"))){
				queryText = request.getParameter("queryText");
			}
			if(!StringUtils.isEmpty(request.getParameter("queryRole"))){
				queryRole = request.getParameter("queryRole");
			}
			
			StringBuffer topChildrenURLBuffer = new StringBuffer(100);
			topChildrenURLBuffer.append(contextPath).append("/base/functionitem/").append(topChildrenURI)
				.append("?parentid=").append(rootId)
				.append("&parentname=").append(rootName)
				.append("&queryText=").append(queryText)
				.append("&childrenURL=").append(contextPath).append("/base/functionitem/").append(topChildrenURI);
			
			request.setAttribute("rootId", rootId);
			request.setAttribute("rootName", rootName);
			request.setAttribute("topChildrenURL", topChildrenURLBuffer.toString());
			request.setAttribute("queryText", queryText);
			
//			
//			//��ɫչ��
//			Role role = (Role) BOFactory.build(RoleBO.class, getDBAccessUser());
//			RoleDBParam oparams = new RoleDBParam();
//			RolefunctionDBParam orparam = (RolefunctionDBParam) getParam();
//			if(!StringUtils.isEmpty(orparam.get_Page())){
//				orparam.set_pagesize(orparam.get_Page());
//			}
//			BeanUtils.copyProperties(oparams, orparam);
//			String sql = "Roleid like '%"+queryRole+"%' or Rolename like '%"+queryRole+"%'";
//			oparams.getQueryConditions().put("_sql_operid", sql);
//				
//			DataPackage dp = role.doQuery(oparams);
//			setDp(dp);
		}catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
			request.setAttribute("rootName", "�Ƿ�����");
			// TODO: handle exception
		}
		return "batchlist";
	}
	
	public String doBatchJSONlist(){
		//��ɫչ��
		try{
			HttpServletRequest request = getRequest();
			User user = (User) request.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			Role role = (Role) BOFactory.build(RoleBO.class, getDBAccessUser());
			RoleDBParam oparams = new RoleDBParam();
			RolefunctionDBParam orparam = (RolefunctionDBParam) getParam();
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
		setCols.add(new ColumnSet("roleid", "��ɫ����"));
		setCols.add(new ColumnSet("rolename", "��ɫ����"));
		return setCols;
	}

	
	public String doBatchsave() throws Exception {
		try{
			List funcList = new ArrayList();
			for(int i=0;i<_selectitem_checkbox.length;i++){
				String funcid = _selectitem_checkbox[i].substring(_selectitem_checkbox[i].indexOf("(")+1, _selectitem_checkbox[i].indexOf(")"));
				funcList.add(funcid);
			}
			List roleList = Arrays.asList(_selectitem);
			Rolefunction rolefunction = (Rolefunction)BOFactory.build(RolefunctionBO.class, getDBAccessUser());
			rolefunction.doBatchSave(funcList, roleList);
			setActionMessage("������Ȩ�ɹ�!");
			return doBatchlist();
		}catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
			// TODO: handle exception
		}
		return "batchlist";
	}
	
	public String doNew() throws Exception {
		RolefunctionForm form = (RolefunctionForm)getForm();
		form.setOperatetype(new Byte("1"));
		form.setCreatedate(new Date());
		form.setStatus(new Byte("1"));
		form.setStatusdate(PublicUtils.UtilStrToDate("2099-12-31", "yyyy-MM-dd"));
		this.setCMD(WEB_CMD_NEW);
		Role role = (Role) BOFactory.build(RoleBO.class, getDBAccessUser());
		if (!role.doIfAdmin()){
			getRequest().setAttribute("adminflag",0);
		}
		return WEB_RESULT_CONTENT;
	}

	
	
	private String queryText = ""; //���Ʋ�ѯ
	private String queryRole = ""; //��ɫ
	private String[] _selectitem_checkbox; //���ƶ�ѡ��
	private String[] _selectitem;  //��ɫ��ѡ��
	
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