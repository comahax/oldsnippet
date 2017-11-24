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

		// 以下几个方法是必须的
		this.setForm(new HisactivetolForm());
		this.setParam(new HisactivetolDBParam());

		// 指定VO类
		setClsVO(HisactivetolVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "brand", "wayid" };
		this.setClsControl(Hisactivetol.class);
		this.setClsQueryParam(HisactivetolDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doExportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);

		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间",
				PublicUtils.utilDateToStr(new Date()) });

		export.setFileName("历史激活数据统计查询");
		export.addOutputProperty("wayid", "合作商编码");
		export.addOutputProperty("wayid", "合作商名称", export.CODE2NAME,
				"#WAYIDINFO");
		export.addOutputProperty("brand", "品牌", export.CODE2NAME,
				"$FX_SMPBRAND");
		export.addOutputProperty("hisactive01", "前一月激活量");
		export.addOutputProperty("hisactive03", "前三月激活量");
		export.addOutputProperty("hisactive06", "前六月激活量");
		export.addOutputProperty("memo", "说明");

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
				// 前一个月
				querytime = PublicUtils.formatUtilDate(c1.getTime(), "yyyy-MM")
						+ "-01 00:00:00";
			}
			if (month.equals("3")) {
				// 前三个月
				c1 = java.util.Calendar.getInstance();
				c1.add(c1.MONTH, -3);
				querytime = PublicUtils.formatUtilDate(c1.getTime(), "yyyy-MM")
						+ "-01 00:00:00";
			}
			if (month.equals("6")) {
				// 前六个月
				c1 = java.util.Calendar.getInstance();
				c1.add(c1.MONTH, -6);
				querytime = PublicUtils.formatUtilDate(c1.getTime(), "yyyy-MM")
						+ "-01 00:00:00";
			}
		}

		// 当前月
		java.util.Calendar c2 = java.util.Calendar.getInstance();
		String endtime = PublicUtils.formatUtilDate(c2.getTime(), "yyyy-MM")
				+ "-01 00:00:00";
		DataPackage dp = hisactivetolBO.doHisWayDetail(querytime, endtime,
				rewayid, brand);
		this.setDp(dp);
		this.getRequest().getSession().setAttribute("rewayid", rewayid);//保存信息供导出TXT用
		this.getRequest().getSession().setAttribute("brand", brand);
		this.getRequest().getSession().setAttribute("querytime", querytime);
		this.getRequest().getSession().setAttribute("endtime", endtime);
		
		return "showdetail";
	}

	public String doExportExcelDetail() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName(this.getRequest().getSession().getAttribute("rewayid")+""+this.getRequest().getSession().getAttribute("brand")+"明细");
		export.addOutputProperty("wayid", "合作商编码");
		export.addOutputProperty("wayid", "合作商名称", export.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("brand", "品牌", export.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("comresid", "号码");
		export.addOutputProperty("activetime", "激活时间");
		export.voClassArray = new Class[] { HisactivetolVO.class };
		export.queryMethodName = "doQueryDetail";
		prepareResponse(export.getFileName());
		HisactivetolDBParam params = (HisactivetolDBParam)super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"合作商编码", "合作商名称", "品牌", "号码", "激活时间" });
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