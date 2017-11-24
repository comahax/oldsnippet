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
 * EXCEL����ExcelOutRvwayBean
 * 
 * @author zhaowen
 * 
 */
public class ExcelOutRvwayBean extends ExportDataCreator {

	private String _se_wayid;

	private String _sk_wayname;

	private String _se_upperwayid;

	private String _se_cooperator;// ������������

	private String _se_cityid;

	private String _se_countyid;// �ֹ�˾

	private String _se_svccode;// ������������

	private String _se_mareacode;// ΢����

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
		writeLines(os, new String[] { "�������ţ�", user.getOpercode()+"<br>", "", "�������ڣ�",
				v.format(ca.getTime())+"<br>"});
		writeExcelEndLine(
				os,
				"ʱ��ʽΪ��YYYY-MM-DD"
						+ "<br>"
						+ "��������:0 �������㡢1 �������桢99 ����"
						+ "<br>"
						+ "״̬:0 ʧЧ��1 ��Ч"
						+ "<br>"
						+ "��Ȧ����:0 ��ҵ����1 ��������2 ��ͨ��Ŧ��3 סլ������4 ѧУ����5 ����6 ���ء�7 ����99 ����"
						+ "<br>"
						+ "��������:0 ������1 ���ء�2 һ������3 ��������4 ��������99 ����"
						+ "<br>"
						+ "ҵ̬����:0 ʡ���ҵ�/ͨѶ������1 ���м��ҵ�/ͨѶ������2 �����ֻ����۵㡢3 �ٻ��ꡢ4 ���������ꡢ5 ����/����"
						+ "<br>" + "6 С�����ꡢ7 �ӻ���/����ͤ/ҩ�ꡢ99 ����" + "<br>"
						+ "ǩԼ����:0 ��ȨЭ�顢1 ֱ������Э�顢2 ֱ��������Э�顢3 ����Э�顢4����Э�顢99����"
						+ "<br>" + "���������������ʣ�RVOW������������Ӫ������RVST:���������������"
						+ "<br>" + "�����ԣ�0 ��������-1 ˫������1 ������" + "<br>"
						+ "�Ƿ�������0 ������1 ������" + "<br>"
						+ "������������:1 �й���ͨ��2 �й����š�3 �й���ͨ��4 �й���ͨ��99 ����" + "<br>");

	}
	protected void writeTitle() {
		// this.title = new String[] { "�������", "��������", "�������", "��������", "״̬",
		// "���й�˾", "�ֹ�˾", "������������", "΢����", "������������", "��Ȧ����", "��������",
		// "ҵ̬����", "��ҵʱ��", "Ӫҵ���", "Ӫҵ��Ա����", "������Ա����", "�ն�����", "������������",
		// "����������������", "������", "�Ƿ�����", "����ʱ��", "��ֹʱ��" };
		this.title = new String[] { "�������", "��������", "�������", "��������", "״̬",
				"���й�˾", "�ֹ�˾", "������������", "΢����", "��Ȧ����", "��������", "ҵ̬����", "��ҵʱ��",
				"Ӫҵ���", "Ӫҵ��Ա����", "������Ա����", "�ն�����", "������������", "ǩԼ����", "ǩ���ͬʱ��",
				"��ͬ������", "����������������", "������", "�Ƿ�����", "����ʱ��", "��ֹʱ��", "������������",
				"����", "γ��", "�ϼ���������", "��ϸ��ַ" };
		this.headtitle = "��������������Ϣ����";
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
