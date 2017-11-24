/**
 * auto-generated code
 * Tue Jul 14 14:52:45 CST 2009
 */
package com.gmcc.pboss.web.base.functionitem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsException;

import com.gmcc.pboss.business.base.functionitem.FunctionitemDBParam;
import com.gmcc.pboss.business.base.functionitem.FunctionitemVO;
import com.gmcc.pboss.business.base.operright.OperrightDBParam;
import com.gmcc.pboss.business.base.operright.OperrightVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.functionitem.Functionitem;
import com.gmcc.pboss.control.base.functionitem.FunctionitemBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: FunctionitemAction
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
 * @author
 * @version 1.0
 */
public class FunctionitemAction extends BaseAction {

	public FunctionitemAction() {
		super();

		this.setForm(new FunctionitemForm());
		this.setParam(new FunctionitemWebParam());

		setClsVO(FunctionitemVO.class);
		this.pkNameArray = new String[] { "funcid" };
		this.setClsControl(Functionitem.class);
		this.setClsQueryParam(FunctionitemDBParam.class);
	}

	/**
	 * ��ȡ��ǰ������Ȩ�޷��ʵ�ģ��
	 */
	public String doMenuTree() throws Exception {
		String cmd = ServletActionContext.getRequest().getParameter("CMD");
		Functionitem functionitem = (Functionitem) BOFactory.build(FunctionitemBO.class, getDBAccessUser());
		FunctionitemDBParam params = (FunctionitemDBParam)getParam();
		params.getQueryConditions().put("operid", getDBAccessUser().getOprcode());
		params.setQueryAll(true);
		
		String nameSql = "";
		if(CoreConfigInfo.IGNORE_MENU_PERM_FLAG || "manageTree".equals(cmd)){//���Ի���
			nameSql = "system.functionitem.queryAllAthorizedFunctionitems.test";
		}else{
			nameSql = "system.functionitem.queryAllAthorizedFunctionitems";
		}
		
		DataPackage dp = functionitem.doQueryByNameSql(nameSql, params);
		
		setDp(dp);
		if ("manageTree".equals(cmd))
			return "manageTree";
		if("roleMenuTree".equals(cmd))
			return "roleMenuTree";
		else
			return "menuTree";
	}

	/**
	 * ��ȡ�����Ĺ��ܲ˵����˵����ϼ��˵���ʶΪ0��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doTopMenu() throws Exception {
		FunctionitemDBParam param = (FunctionitemDBParam) super.getParam();
		param.setQueryAll(true);
		
		param.getQueryConditions().put("parentid", "0");
		param.getQueryConditions().put("operid", getDBAccessUser().getOprcode());
		Functionitem functionitem = (Functionitem) BOFactory.build(FunctionitemBO.class, getDBAccessUser());
		String nameSql = "";
		if(CoreConfigInfo.IGNORE_MENU_PERM_FLAG){//���Ի���
			nameSql = "system.functionitem.queryTopMenuTree.test";
		}else{//��ʽ����
			nameSql = "system.functionitem.queryTopMenuTree";
		}
		DataPackage dp = functionitem.doQueryByNameSql(nameSql, param);
		setDp(dp);
		return "top";
	}

	public String doNew() throws Exception {
		FunctionitemForm form = (FunctionitemForm) super.getForm();
		FunctionitemDBParam param = (FunctionitemDBParam) super.getParam();
		form.setParentid(param.get_se_parentid());
		Calendar c = Calendar.getInstance();
		c.set(2099, Calendar.DECEMBER, 31);
		form.setStatusdate(c.getTime());
		this.setCMD(WEB_CMD_NEW);
		if (!param.get_se_parentid().equals("0")) {
			Functionitem item = (Functionitem) BOFactory.build(
					FunctionitemBO.class, getDBAccessUser());
			DataPackage dp = item.doQuery(param);
			String funcid = buildFuncID(param.get_se_parentid(), dp);
			form.setFuncid(funcid);
			form.setSortorder(new Short((short) (dp.getDatas().size() + 1)));
		}
		return WEB_RESULT_CONTENT;
	}
	
	public String doEdit() throws Exception{
		super.doEdit();
		FunctionitemForm form = (FunctionitemForm) super.getForm();
		FunctionitemDBParam param = (FunctionitemDBParam) super.getParam();
		param.set_se_parentid(form.getParentid());
		return WEB_RESULT_CONTENT;
	}
	
	public String doListall() throws Exception{
		FunctionitemDBParam param = new FunctionitemDBParam();
		param.setQueryAll(true);
		param.set_orderby("funcid");
		setParam(param);
		super.doList();
		return "list";
	}
	
	public String doTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�˵�������");
		export.addOutputProperty("funcid", "�˵�����");
		export.addOutputProperty("funcname", "�˵�����",export.CODE2NAME,"#FUNCTIONITEM");
		export.addOutputProperty("parentid", "�ϼ��˵�����");
		export.addOutputProperty("guiobject", "�˵�����");
		export.addOutputProperty("status", "�Ƿ�ɼ�",export.CODE2NAME,"$YesOrNo");
		export.addOutputProperty("sortorder", "����");
		export.voClassArray = new Class[] { FunctionitemVO.class };
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
		export.setFileName("�˵�������");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��",format.format(new Date()) });
		export.addOutputProperty("funcid", "�˵�����");
		export.addOutputProperty("funcname", "�˵�����",export.CODE2NAME,"#FUNCTIONITEM");
		export.addOutputProperty("parentid", "�ϼ��˵�����");
		export.addOutputProperty("guiobject", "�˵�����");
		export.addOutputProperty("status", "�Ƿ�ɼ�",export.CODE2NAME,"$YesOrNo");
		export.addOutputProperty("sortorder", "����");
		export.queryMethodName = "doListall";
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	

	private String buildFuncID(String parentid, DataPackage dp) {
		String funcid = parentid;
		if (dp.getDatas().size() == 0) {
			funcid = parentid + "01";
		} else {
			Iterator<FunctionitemVO> itt = dp.getDatas().iterator();
			while (itt.hasNext()) {
				FunctionitemVO vo = itt.next();
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

	/**
	 * ��ȡָ���Ĺ��ܲ˵����������¼��Ӳ˵�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doListFunMenuByParent() throws Exception {
		FunctionitemForm form = (FunctionitemForm) super.getForm();
		Functionitem functionitem = (Functionitem) BOFactory.build(
				FunctionitemBO.class, getDBAccessUser());
		param.getQueryConditions().put("funcid", form.getFuncid());// �̶�������ѯ
		param.getQueryConditions().put("operid", getDBAccessUser().getOprcode());
		param.setQueryAll(true);
		
		String nameSql = "";
		if(CoreConfigInfo.IGNORE_MENU_PERM_FLAG){//���Ի���
			nameSql = "system.functionitem.queryAllFunctionByParentId.test";
		}else{//��ʽ����
			param.getQueryConditions().put("funcid", form.getFuncid()+"%");// �̶�������ѯ
			nameSql = "system.functionitem.queryAllFunctionByParentId";
		}
		DataPackage dp = functionitem.doQueryByNameSql(nameSql, (FunctionitemDBParam)param);
		setDp(dp);
		return "sontree";
	}

	/**
	 * ��ȡָ���Ĺ��ܲ˵��б��������¼��Ӳ˵��б�;
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doListByParent() throws Exception {
		Functionitem functionitem = (Functionitem) BOFactory.build(
				FunctionitemBO.class, getDBAccessUser());
		FunctionitemDBParam param = (FunctionitemDBParam) super.getParam();
		String parentid = param.get_se_parentid();
		param.getQueryConditions().put("funcid", parentid);// �̶�������ѯ
		param.setQueryAll(true);
		DataPackage dp = functionitem.doQueryByNameSql(
				"system.functionitem.queryAllFunctionByParentId.test", param);
		super.setDp(dp);
		return "manageList";
	}

}