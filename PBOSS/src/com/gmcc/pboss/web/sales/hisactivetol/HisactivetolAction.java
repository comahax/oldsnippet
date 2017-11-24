/**
 * auto-generated code
 * Tue Apr 24 17:19:54 CST 2012
 */
package com.gmcc.pboss.web.sales.hisactivetol;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.sales.hisactivetol.HisactivetolDBParam;
import com.gmcc.pboss.business.sales.hisactivetol.HisactivetolVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.export.ExportDataCreator.PropertyFormat;
import com.gmcc.pboss.control.sales.hisactivetol.Hisactivetol;
import com.gmcc.pboss.control.sales.hisactivetol.HisactivetolBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: HisactivetolAction
 * </p>;
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
 * @author dengxingxin
 * @version 1.0
 */
public class HisactivetolAction extends BaseAction {

	public HisactivetolAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new HisactivetolForm());
		this.setParam(new HisactivetolDBParam());

		// ָ��VO��
		setClsVO(HisactivetolVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "brand", "wayid" };
		this.setClsControl(Hisactivetol.class);
		this.setClsQueryParam(HisactivetolDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doExportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);

		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��",
				PublicUtils.utilDateToStr(new Date()) });

		export.setFileName("��ʷ��������ͳ�Ʋ�ѯ");
		export.addOutputProperty("wayid", "�����̱���");
		export.addOutputProperty("wayid", "����������", export.CODE2NAME,
				"#WAYIDINFO");
		export.addOutputProperty("brand", "Ʒ��", export.CODE2NAME,
				"$FX_SMPBRAND");
		export.addOutputProperty("hisactive01", "ǰһ�¼�����");
		export.addOutputProperty("hisactive03", "ǰ���¼�����");
		export.addOutputProperty("hisactive06", "ǰ���¼�����");
		export.addOutputProperty("memo", "˵��");

		export.voClassArray = new Class[] { HisactivetolVO.class };
		HisactivetolDBParam params = (HisactivetolDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}

	public String doShowDetail() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		Hisactivetol hisactivetolBO = (Hisactivetol) BOFactory.build(
				HisactivetolBO.class, user);

		String month = request.getParameter("month");
		String rewayid = request.getParameter("wayid");
		String brand = request.getParameter("brand");
		java.util.Calendar c1 = java.util.Calendar.getInstance();
		String querytime = null;
		if (month != null) {
			if (month.equals("1")) {
				c1.add(c1.MONTH, -1);
				// ǰһ����
				querytime = PublicUtils.formatUtilDate(c1.getTime(), "yyyy-MM")
						+ "-01 00:00:00";
			}
			if (month.equals("3")) {
				// ǰ������
				c1 = java.util.Calendar.getInstance();
				c1.add(c1.MONTH, -3);
				querytime = PublicUtils.formatUtilDate(c1.getTime(), "yyyy-MM")
						+ "-01 00:00:00";
			}
			if (month.equals("6")) {
				// ǰ������
				c1 = java.util.Calendar.getInstance();
				c1.add(c1.MONTH, -6);
				querytime = PublicUtils.formatUtilDate(c1.getTime(), "yyyy-MM")
						+ "-01 00:00:00";
			}
		}

		// ��ǰ��
		java.util.Calendar c2 = java.util.Calendar.getInstance();
		String endtime = PublicUtils.formatUtilDate(c2.getTime(), "yyyy-MM")
				+ "-01 00:00:00";
		DataPackage dp = hisactivetolBO.doHisWayDetail(querytime, endtime,
				rewayid, brand);
		this.setDp(dp);
		this.getRequest().getSession().setAttribute("rewayid", rewayid);//������Ϣ������TXT��
		this.getRequest().getSession().setAttribute("brand", brand);
		this.getRequest().getSession().setAttribute("querytime", querytime);
		this.getRequest().getSession().setAttribute("endtime", endtime);
		
		return "showdetail";
	}

	public String doExportExcelDetail() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName(this.getRequest().getSession().getAttribute("rewayid")+""+this.getRequest().getSession().getAttribute("brand")+"��ϸ");
		export.addOutputProperty("wayid", "�����̱���");
		export.addOutputProperty("wayid", "����������", export.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("brand", "Ʒ��", export.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("comresid", "����");
		export.addOutputProperty("activetime", "����ʱ��");
		export.voClassArray = new Class[] { HisactivetolVO.class };
		export.queryMethodName = "doQueryDetail";
		prepareResponse(export.getFileName());
		HisactivetolDBParam params = (HisactivetolDBParam)super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"�����̱���", "����������", "Ʒ��", "����", "����ʱ��" });
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	public void doQueryDetail() throws Exception{
		String querytime = this.getRequest().getSession().getAttribute("querytime")+"";
		String endtime = this.getRequest().getSession().getAttribute("endtime")+"";
		String rewayid = this.getRequest().getSession().getAttribute("rewayid")+"";
		String brand = this.getRequest().getSession().getAttribute("brand")+"";
		Hisactivetol hisactivetolBO = (Hisactivetol) BOFactory.build(
				HisactivetolBO.class, this.getDBAccessUser());
		DataPackage dp = hisactivetolBO.doHisWayDetail(querytime, endtime,
				rewayid, brand);
		this.setDp(dp);		
	}
	

}