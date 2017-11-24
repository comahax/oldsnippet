/**
 * auto-generated code
 * Wed Sep 02 13:59:59 CST 2009
 */
package com.gmcc.pboss.web.resource.emptysim;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.emptysim.EmptysimVO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.resource.emptysim.EmptysimDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.emptysim.Emptysim;
import com.gmcc.pboss.control.resource.emptysim.EmptysimBO;

/**
 * <p>
 * Title: EmptysimAction
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
 * @author
 * @version 1.0
 */
public class EmptysimAction extends BaseAction {

	public EmptysimAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new EmptysimForm());
		this.setParam(new EmptysimWebParam());

		// 指定VO类
		setClsVO(EmptysimVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "emptyno" };
		this.setClsControl(Emptysim.class);
		this.setClsQueryParam(EmptysimDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doList() throws Exception {
		try {
			EmptysimDBParam param = (EmptysimDBParam) this.getParam();
			param.set_orderby("emptyno");
			param.set_desc("1");
			Emptysim bo = (EmptysimBO) BOFactory.build(EmptysimBO.class, this
					.getDBAccessUser());
			DataPackage dp = bo.doResQuery(param);
			this.setDp(dp);
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return WEB_RESULT_LIST;
	}

	public String doTolist() throws Exception {
		try {// 首次进入页面，显示登录账户所属分公司信息
			EmptysimDBParam param = (EmptysimDBParam) this.getParam();
			User user = (User) super.getRequest().getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			Way wayBO = (WayBO) BOFactory.build(WayBO.class, super
					.getDBAccessUser());
			WayVO wayvo = wayBO.doFindByPk(user.getWayid());
			param.set_se_countyid(wayvo.getCountyid());
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}

	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("空白SIM卡可售资源导出");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("emptyno", "空卡序列号");
		export.addOutputProperty("comid", "商品标识");
		export.addOutputProperty("comid", "商品名称",export.CODE2NAME, "#COM");
		export.addOutputProperty("countyid", "分公司", export.CODE2NAME,
				"#CNTYCOMPANY");
		export.addOutputProperty("cardmill", "卡商");
		export.addOutputProperty("iccid", "ICCID");
		export.addOutputProperty("pukno", "PUK码");
		export.addOutputProperty("wayid", "渠道标识", export.CODE2NAME,
				"#WAYIDINFO");
		export.addOutputProperty("simtype", "SIM卡类型", export.CODE2NAME,
				"$IM_SIMTYPE");
		export.addOutputProperty("usestate", "状态", export.CODE2NAME,
				"$FX_COMSTATE");
		export.addOutputProperty("entertime", "入库时间", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("applytime", "申请时间", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("bosssaletime", "BOSS销售时间", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		EmptysimDBParam params = (EmptysimDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		return super.doExcel();
	}

	// 统计数据 导出EXCEL
	public String doStatExcel() throws Exception {
		try {
			Emptysim bo = (EmptysimBO) BOFactory.build(EmptysimBO.class, super
					.getDBAccessUser());
			DataPackage dp = bo.doStat((EmptysimDBParam) super.getParam());
			super.setDp(dp);
		} catch (Exception e) {
			super.addActionError(e.getMessage());
		}
		return "exportexcel";
	}

	public String doTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("空白SIM卡可售资源导出");
		export.addOutputProperty("emptyno", "空卡序列号");
		export.addOutputProperty("comid", "商品标识");
		export.addOutputProperty("comid", "商品名称",export.CODE2NAME, "#COM");
		export.addOutputProperty("countyid", "分公司", export.CODE2NAME,
				"#CNTYCOMPANY");
		export.addOutputProperty("cardmill", "卡商");
		export.addOutputProperty("iccid", "ICCID");
		export.addOutputProperty("pukno", "PUK码");
		export.addOutputProperty("wayid", "渠道标识", export.CODE2NAME,
				"#WAYIDINFO");
		export.addOutputProperty("simtype", "SIM卡类型", export.CODE2NAME,
				"$IM_SIMTYPE");
		export.addOutputProperty("usestate", "状态", export.CODE2NAME,
				"$FX_COMSTATE");
		export.addOutputProperty("entertime", "入库时间", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("applytime", "申请时间", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("bosssaletime", "BOSS销售时间", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.voClassArray = new Class[] { EmptysimVO.class };

		prepareResponse(export.getFileName());
		EmptysimDBParam params = (EmptysimDBParam) super.getParam();
		params.set_pageno("5");
		params.set_pagesize("0");
		super.setParam(params);
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"空卡序列号", "商品标识", "商品名称", "分公司", "卡商", "ICCID", "PUK码", "渠道标识", "SIM卡类型", "状态",
				"入库时间", "申请时间", "BOSS销售时间" });
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}

	// 空白SIM卡库存统计
	public String doStat() throws Exception {

		try {

			if (this.isQuery) {
				EmptysimDBParam emptysimdbparam = (EmptysimDBParam) super
						.getParam();
				emptysimdbparam.setQueryAll(true);
				Emptysim bo = (Emptysim) BOFactory.build(EmptysimBO.class,
						super.getDBAccessUser());
				DataPackage dp = bo.doStat(emptysimdbparam);
				super.setDp(dp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getCause() == null ? e.getMessage() : e
					.getCause().getMessage());
		}
		return "stat";
	}

	private boolean isQuery;// 是否统计标识，默认不查询

	public boolean getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(boolean isQuery) {
		this.isQuery = isQuery;
	}

}