/**
 * auto-generated code
 * Wed Jul 08 11:41:20 CST 2009
 */
package com.gmcc.pboss.web.channel.waytype;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import com.gmcc.pboss.business.channel.waytype.WaytypeVO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.channel.waytype.WaytypeDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.channel.waytype.Waytype;
import com.gmcc.pboss.control.channel.waytype.WaytypeBO;

/**
 * <p>
 * Title: WaytypeAction
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
 * @author Jerimy
 * @version 1.0
 */
public class WaytypeAction extends BaseAction {

	public WaytypeAction() {
		super();

		// ????????��?����??��?????
		this.setForm(new WaytypeForm());
		this.setParam(new WaytypeWebParam());

		// ???��VO?��
		setClsVO(WaytypeVO.class);
		// ???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
		this.pkNameArray = new String[] { "waytypecode" };
		this.setClsControl(Waytype.class);
		this.setClsQueryParam(WaytypeDBParam.class);
		this.setClsAction(WaytypeAction.class);
		/**
		 * ???????��??????????????????BaseAction??CRUD???��?��?????��??Delegate????��
		 * ??��??????��????�� this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�������͹�����");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("waytypecode", "�������ͱ���");
		export.addOutputProperty("waytypename", "������������");
		export.addOutputProperty("uppercode", "�ϼ��������ͱ���");
		export.addOutputProperty("desp", "����", export.CODE2NAME, "$test");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}

	public String doExcel2() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�������͹�����");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("waytypecode", "�������ͱ���");
		export.addOutputProperty("waytypename", "������������");
		export.addOutputProperty("uppercode", "�ϼ��������ͱ���");
		export.addOutputProperty("desp", "����", export.CODE2NAME, "$test");
		export.queryMethodName = "doSearch";
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}

	public String doSearch() throws Exception {
		Waytype waytype = (Waytype) BOFactory.build(WaytypeBO.class,
				getDBAccessUser());
		WaytypeDBParam dbparamParam = new WaytypeDBParam();
		dbparamParam.set_se_waytypecode("2");
		DataPackage dp = waytype.doQuery(dbparamParam);
		setDp(dp);
		return null;
	}

	public DataPackage getDp() {
		return super.getDp();
	}

	public String doTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			export.setFileName("�������͹�����");
		export.addOutputProperty("waytypecode", "�������ͱ���");
		export.addOutputProperty("waytypename", "������������");
		export.addOutputProperty("uppercode", "�ϼ��������ͱ���");
		export.addOutputProperty("desp", "����", export.CODE2NAME, "$test");
		export.voClassArray = new Class[] { WaytypeVO.class };

		prepareResponse(export.getFileName());
		
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"�������ͱ���", "������������", "�ϼ��������ͱ���", "����" });
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
}