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

		//���¼��������Ǳ����
		this.setForm(new WebfunctionitemForm());
		this.setParam(new WebfunctionitemDBParam());

        //ָ��VO��
        setClsVO(WebfunctionitemVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"funcid"};
		this.setClsControl(Webfunctionitem.class);
		this.setClsQueryParam(WebfunctionitemDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	/**
	 * ��ȡָ���Ĺ��ܲ˵��б��������¼��Ӳ˵��б�;
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doListByParent() throws Exception {
		Webfunctionitem webfunctionitem = (Webfunctionitem) BOFactory.build(
				WebfunctionitemBO.class, getDBAccessUser());
		WebfunctionitemDBParam param = (WebfunctionitemDBParam) super.getParam();
		String parentid = param.get_se_parentid();
		param.getQueryConditions().put("funcid", parentid);// �̶�������ѯ
		param.setQueryAll(true);
		DataPackage dp = webfunctionitem.doQueryByNameSql(
				"system.webfunctionitem.queryAllFunctionByParentId.test", param);
		super.setDp(dp);
		return "manageList";
	}
	
	/**
	 * ��ȡ��ǰ������Ȩ�޷��ʵ�ģ��
	 */
	public String doMenuTree() throws Exception {
		String cmd = ServletActionContext.getRequest().getParameter("CMD");
		Webfunctionitem webfunctionitem = (Webfunctionitem) BOFactory.build(WebfunctionitemBO.class, getDBAccessUser());
		WebfunctionitemDBParam params = (WebfunctionitemDBParam)getParam();
//		params.getQueryConditions().put("operid", getDBAccessUser().getOprcode());
		params.setQueryAll(true);
		
//		String nameSql = "";
//		if(CoreConfigInfo.IGNORE_MENU_PERM_FLAG || "manageTree".equals(cmd)){//���Ի���
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
		export.setFileName("��վ�˵�������");
		export.addOutputProperty("funcid", "�˵�����");
		export.addOutputProperty("funcname", "�˵�����",export.CODE2NAME,"#WEBFUNCTIONITEM");
		export.addOutputProperty("parentid", "�ϼ��˵�����");
		export.addOutputProperty("guiobject", "�˵�����");
		export.addOutputProperty("status", "�Ƿ�ɼ�",export.CODE2NAME,"$CH_VISIABLE");
		export.addOutputProperty("sortorder", "����");
		export.voClassArray = new Class[] { WebfunctionitemVO.class };
		export.queryMethodName = "doListall";

		prepareResponse(export.getFileName());
		
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"�˵�����","�˵�����", "�ϼ��˵�����","�˵�����", "�Ƿ�ɼ�" ,"����"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("��վ�˵�������");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��",format.format(new Date()) });
		export.addOutputProperty("funcid", "�˵�����");
		export.addOutputProperty("funcname", "�˵�����",export.CODE2NAME,"#WEBFUNCTIONITEM");
		export.addOutputProperty("parentid", "�ϼ��˵�����");
		export.addOutputProperty("guiobject", "�˵�����");
		export.addOutputProperty("status", "�Ƿ�ɼ�",export.CODE2NAME,"$CH_VISIABLE");
		export.addOutputProperty("sortorder", "����");
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