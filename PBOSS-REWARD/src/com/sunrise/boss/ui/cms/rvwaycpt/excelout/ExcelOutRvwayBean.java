package com.sunrise.boss.ui.cms.rvwaycpt.excelout;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.ExcelCodeToName;
import com.sunrise.boss.common.utils.export.ExportDataCreator;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;

/**
 * EXCEL导出ExcelOutRvwayBean
 * 
 * @author zhaowen
 * 
 */
public class ExcelOutRvwayBean extends ExportDataCreator {

	private String _se_wayid;

	private String _sk_wayname;

	private String _se_upperwayid;

	private String _se_cooperator;// 竞争对手类型

	private String _se_cityid;

	private String _se_countyid;// 分公司

	private String _se_svccode;// 服务销售中心

	private String _se_mareacode;// 微区域

	private String _se_waysubtype;

	private User user;

	Calendar ca = Calendar.getInstance(Locale.CHINA);

	SimpleDateFormat v = new SimpleDateFormat("yyyyMMdd");

	public ExcelOutRvwayBean(User user) {
		super(user);
	}

	protected void queryPages(OutputStream os, Object queryVO, User opr)
			throws Exception {
		List querylist = (List) queryVO;
		Object[] objj = (Object[]) querylist.get(0);

		WayListVO difflistvo = (WayListVO) objj[0];

		difflistvo.set_se_waytype("RIVL");
		difflistvo.set_sql_waystate(" (waystate = 1 or waystate = 0) ");
		WayDelegate bd = new WayDelegate();
		String str = null;
		if (querylist.get(1) != null) {
			str = querylist.get(1).toString();
		}
		DataPackage dp = bd.doQuery(difflistvo, user);
		addOutputProperty(0, "wayid", null, null);
		addOutputProperty(0, "wayname", null, null);
		addOutputProperty(0, "shortname", null, null);
		addOutputProperty(0, "catetype", null, null);
		addOutputProperty(0, "waystate", null, null);
		addOutputProperty(0, "cityid", null, null);
		addOutputProperty(0, "countyid", null, null);
		addOutputProperty(0, "svccode", null, null);
		addOutputProperty(0, "mareacode", null, null);
		addOutputProperty(0, "buztypecode", null, null);
		addOutputProperty(0, "adtypecode", null, null);
		addOutputProperty(0, "formtype", null, null);
		addOutputProperty(0, "starttime", DATE, "yyyy-MM-dd");
		addOutputProperty(0, "buzarea", null, null);
		addOutputProperty(0, "empnumber", null, null);
		addOutputProperty(0, "magnumber", null, null);
		addOutputProperty(0, "terminumber", null, null);
		addOutputProperty(0, "waymagcode", null, null);
		addOutputProperty(0, "compacttype", null, null);
		addOutputProperty(0, "signdate", null, null);
		addOutputProperty(0, "expiredate", null, null);
		addOutputProperty(0, "waysubtype", null, null);
		addOutputProperty(0, "pt", null, null);
		addOutputProperty(0, "isconnected", null, null);
		addOutputProperty(0, "createtime", null, null);
		addOutputProperty(0, "disabletime", null, null);
		addOutputProperty(0, "cooperator", null, null);
		addOutputProperty(0, "longtitude", null, null);
		addOutputProperty(0, "latitude", null, null);
		addOutputProperty(0, "upperwayid", null, null);
		addOutputProperty(0, "address", null, null);

		difflistvo.set_pageno("1");
		int pagenum = Integer.valueOf(difflistvo.get_pageno()).intValue();
		BigDecimal num1 = new BigDecimal("0.00");
		BigDecimal num2 = new BigDecimal("0.00");
		while (dp.getRowCount() > (pagenum - 1) * dp.getPageSize()) {
			dp = bd.doQuery(difflistvo, user);
			write(os, dp.getDatas().iterator(), new Class[] { WayVO.class });
			pagenum = Integer.valueOf(difflistvo.get_pageno()).intValue();

			pagenum = pagenum + 1;
			difflistvo.set_pageno(pagenum + "");
		}
		close();
	}

	protected void beforeWrite(OutputStream os) throws Exception {
		writeLines(os, new String[] { "" });
	}

	protected void afterWrite(OutputStream os) throws Exception {
		writeLines(os, new String[] { "" });
		writeLines(os, new String[] { "导出工号：", user.getOpercode()+"<br>", "", "导出日期：",
				v.format(ca.getTime())+"<br>"});
		writeExcelEndLine(
				os,
				"时格式为：YYYY-MM-DD"
						+ "<br>"
						+ "连锁性质:0 连锁网点、1 独立店面、99 其它"
						+ "<br>"
						+ "状态:0 失效、1 有效"
						+ "<br>"
						+ "商圈类型:0 商业区、1 商务区、2 交通枢纽、3 住宅社区、4 学校区域、5 厂矿、6 郊县、7 乡镇、99 其他"
						+ "<br>"
						+ "区域类型:0 城区、1 郊县、2 一类乡镇、3 二类乡镇、4 三类乡镇、99 其它"
						+ "<br>"
						+ "业态类型:0 省级家电/通讯连锁、1 地市级家电/通讯连锁、2 独立手机销售点、3 百货店、4 连锁便利店、5 银行/邮政"
						+ "<br>" + "6 小便利店、7 杂货铺/报刊亭/药店、99 其它" + "<br>"
						+ "签约类型:0 授权协议、1 直供排他协议、2 直供非排他协议、3 积分协议、4附加协议、99其它"
						+ "<br>" + "竞争对手渠道性质：RVOW：竞争对手自营渠道、RVST:竞争对手社会渠道"
						+ "<br>" + "排他性：0 单排他、-1 双排他、1 非排他" + "<br>"
						+ "是否联网：0 联网、1 非联网" + "<br>"
						+ "竞争对手类型:1 中国联通、2 中国电信、3 中国网通、4 中国铁通、99 其它" + "<br>");

	}
	protected void writeTitle() {
		// this.title = new String[] { "渠道编号", "渠道名称", "渠道简称", "连锁性质", "状态",
		// "地市公司", "分公司", "服务销售中心", "微区域", "竞争对手类型", "商圈类型", "区域类型",
		// "业态类型", "开业时间", "营业面积", "营业人员数量", "管理人员数量", "终端数量", "所属渠道经理",
		// "竞争对手渠道性质", "排他性", "是否联网", "建立时间", "截止时间" };
		this.title = new String[] { "渠道编号", "渠道名称", "渠道简称", "连锁性质", "状态",
				"地市公司", "分公司", "服务销售中心", "微区域", "商圈类型", "区域类型", "业态类型", "开业时间",
				"营业面积", "营业人员数量", "管理人员数量", "终端数量", "所属渠道经理", "签约类型", "签署合同时间",
				"合同到期日", "竞争对手渠道性质", "排他性", "是否联网", "建立时间", "截止时间", "竞争对手类型",
				"经度", "纬度", "上级渠道编码", "详细地址" };
		this.headtitle = "竞争对手渠道信息管理";
	}

	protected String codeToName(String propertyName, String code, User user) {
		if (StringUtils.equals(propertyName, "catetype")) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$CH_CATETYPE", code, user);
		}
		if (StringUtils.equals(propertyName, "cooperator")) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$CH_COOPERATOR", code, user);
		}
		if (StringUtils.equals(propertyName, "waystate")) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$CH_VALIDFLAG", code, user);
		}
		if (StringUtils.equals(propertyName, "buztypecode")) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$CH_BUZTYPE", code, user);
		}
		if (StringUtils.equals(propertyName, "adtypecode")) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$CH_ADTYPE", code, user);
		}
		if (StringUtils.equals(propertyName, "formtype")) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$CH_FORMTYPE", code, user);
		}
		if (StringUtils.equals(propertyName, "pt")) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$CH_PT", code, user);
		}
		if (StringUtils.equals(propertyName, "isconnected")) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$CH_ISCONNECTED", code, user);
		}
		if (StringUtils.equals(propertyName, "waysubtype")) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("#WAYTYPE", code, user);
		}
		return code;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_cooperator() {
		return _se_cooperator;
	}

	public void set_se_cooperator(String _se_cooperator) {
		this._se_cooperator = _se_cooperator;
	}

	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	public String get_se_mareacode() {
		return _se_mareacode;
	}

	public void set_se_mareacode(String _se_mareacode) {
		this._se_mareacode = _se_mareacode;
	}

	public String get_se_svccode() {
		return _se_svccode;
	}

	public void set_se_svccode(String _se_svccode) {
		this._se_svccode = _se_svccode;
	}

	public String get_se_upperwayid() {
		return _se_upperwayid;
	}

	public void set_se_upperwayid(String _se_upperwayid) {
		this._se_upperwayid = _se_upperwayid;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_sk_wayname() {
		return _sk_wayname;
	}

	public void set_sk_wayname(String _sk_wayname) {
		this._sk_wayname = _sk_wayname;
	}

	public String get_se_waysubtype() {
		return _se_waysubtype;
	}

	public void set_se_waysubtype(String _se_waysubtype) {
		this._se_waysubtype = _se_waysubtype;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
