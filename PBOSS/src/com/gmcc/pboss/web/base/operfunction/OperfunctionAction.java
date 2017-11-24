/**
 * auto-generated code
 * Tue Sep 08 16:02:06 CST 2009
 */
 package com.gmcc.pboss.web.base.operfunction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.operator.OperatorDBParam;
import com.gmcc.pboss.business.base.operfunction.OperfunctionDBParam;
import com.gmcc.pboss.business.base.operfunction.OperfunctionVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.jqTable.ColumnSet;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.operfunction.Operfunction;
import com.gmcc.pboss.control.base.operfunction.OperfunctionBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: OperfunctionAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OperfunctionAction extends BaseAction{
	
	public OperfunctionAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OperfunctionForm());
		this.setParam(new OperfunctionWebParam());

        //ָ��VO��
        setClsVO(OperfunctionVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"functionid","operid"};
		this.setClsControl(Operfunction.class);
		this.setClsQueryParam(OperfunctionDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doTxt() throws Exception {
		OperfunctionDBParam operfunctiondbparam = (OperfunctionDBParam)super.getParam();
		operfunctiondbparam.setQueryAll(true);
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("����Ա�˵���Ȩ����");
		export.addOutputProperty("operid", "����Ա����");
		export.addOutputProperty("operid", "����",export.CODE2NAME,"#OPERATOR");
		export.addOutputProperty("functionid", "�˵�����");
		export.addOutputProperty("functionid", "�˵����� ",export.CODE2NAME,"#FUNCTIONITEM");
		export.addOutputProperty("createdate", "����ʱ��",export.DATE,"yyyy-MM-dd");
		export.addOutputProperty("status", "״̬",export.CODE2NAME,"$CH_OPRSTATUS");
		export.addOutputProperty("statusdate", "��Чʱ��",export.DATE,"yyyy-MM-dd");
		export.voClassArray = new Class[] { OperfunctionVO.class };

		prepareResponse(export.getFileName());
		
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"����Ա����", "����","�˵�����", "�˵����� ","����ʱ��", "״̬" ,"��Чʱ��"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("����Ա�˵���Ȩ����");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��",format.format(new Date()) });
		export.addOutputProperty("operid", "����Ա����");
		export.addOutputProperty("operid", "����",export.CODE2NAME,"#OPERATOR");
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
			
			System.out.println(topChildrenURLBuffer.toString());
			
			request.setAttribute("rootId", rootId);
			request.setAttribute("rootName", rootName);
			request.setAttribute("topChildrenURL", topChildrenURLBuffer.toString());
			request.setAttribute("queryText", queryText);
			
//			//����Աչ��
//			Operator operator = (Operator) BOFactory.build(OperatorBO.class, getDBAccessUser());
//			OperatorDBParam oparams = new OperatorDBParam();
//			OperfunctionDBParam orparam = (OperfunctionDBParam) getParam();
//			BeanUtils.copyProperties(oparams, orparam);
//			String sql = "region = '"+CityMappingUtil.getCityNo(getDBAccessUser().getCityid())+"' ";
//			if(!StringUtils.isEmpty(queryRole)){
//				sql += "and (operid like '%"+queryRole+"%' or opername like '%"+queryRole+"%')";
//			}
//			oparams.getQueryConditions().put("_sql_operid", sql);
//				
//			DataPackage dp = operator.doQuery(oparams);
//			setDp(dp);
			
		}catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
			request.setAttribute("rootName", "�Ƿ�����");
			// TODO: handle exception
		}
		return "batchlist";
	}
	
	public String doBatchsave() throws Exception {
		try{
			List funcList = new ArrayList();
			for(int i=0;i<_selectitem_checkbox.length;i++){
				String funcid = _selectitem_checkbox[i].substring(_selectitem_checkbox[i].indexOf("(")+1, _selectitem_checkbox[i].indexOf(")"));
				funcList.add(funcid);
			}
			List operList = Arrays.asList(_selectitem);
			Operfunction operfunction = (Operfunction)BOFactory.build(OperfunctionBO.class, getDBAccessUser());
			operfunction.doBatchSave(funcList, operList);
			setActionMessage("������Ȩ�ɹ�!");
			return doBatchlist();
		}catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
			// TODO: handle exception
		}
		return "batchlist";
	}
	
	public String doBatchJSONlist(){
		//����Աչ��
		try{
			Operator operator = (Operator) BOFactory.build(OperatorBO.class, getDBAccessUser());
			OperatorDBParam oparams = new OperatorDBParam();
			OperfunctionDBParam orparam = (OperfunctionDBParam) getParam();
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
		setCols.add(new ColumnSet("operid", "����"));
		setCols.add(new ColumnSet("opername", "����"));
		return setCols;
	}
	
	public String doNew() throws Exception{
		// �½�ʱ����form��Ĭ��ֵ
		OperfunctionForm form = (OperfunctionForm)getForm();
		form.setStatus(new Byte("1"));
		form.setCreatedate(new Date());
		form.setStatusdate(PublicUtils.UtilStrToDate("2099-12-31", "yyyy-MM-dd"));
		this.CMD = WEB_CMD_NEW;
		return WEB_RESULT_CONTENT;
	}
	
	private String queryText = ""; //���Ʋ�ѯ
	private String queryRole = ""; //Oper��ѯ
	private String[] _selectitem_checkbox; //���ƶ�ѡ��
	private String[] _selectitem;  //Oper��ѡ��
	
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