package com.sunrise.boss.web.fee.billing.uapanalyse;

import java.io.OutputStream;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import com.sunrise.boss.business.fee.billing.uapanalyse.persistent.UapAnalyseDBParam;
import com.sunrise.boss.business.fee.billing.uapanalyse.persistent.UapAnalyseVO;
import com.sunrise.boss.common.export.ExcelCodeToName;
import com.sunrise.boss.common.export.ExportDataCreator;
import com.sunrise.boss.common.export.PageSetting;
import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.common.utils.i18n.Message;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class ExcelOutUapAnalyse extends ExportDataCreator {

	private final static String RESPATH ="/com/sunrise/boss/web/fee/billing/uapanalyse/UapAnalyseAction_zh_CN.properties";
	private String description;
	
	public ExcelOutUapAnalyse(User user) {
		super(user);		
	}

	protected String codeToName(String propertyName, String code, User user) {
		if (propertyName != null && "rule_id".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$IB_REQ_UAP", code, user.getDbFlag());
		}
		if (propertyName != null && "key_column".equals(propertyName)){
			ExcelCodeToName et = new ExcelCodeToName();
			code = code+" "+et.codeToName("#WOFF-ACCT", code, user.getDbFlag());
		}
		if (propertyName != null && "chgrate_count".equals(propertyName) || propertyName != null && "chgrate_amt".equals(propertyName)){
			Double d = Double.valueOf(code);
			Double amt = d*100;
			code = String.format("%.2f", amt)+"%";
		}
		if (StringUtils.equals(propertyName, "cmpamt") || StringUtils.equals(propertyName, "curamt")) {
			//因为金额在数据库的单位为分，导出的数据单位为元，所以做了一些处理
			if (code != null && code.length() > 0) {
				if (code.length() >= 3) {
					code = code.substring(0, code.length() - 2) + "."
							+ code.substring(code.length() - 2);
				} if (code.length() == 2) {
					code = "0." + code;
				} if (code.length() == 1) {
					code = "0.0" + code;
				}
			}
		}
		return code;
	}

	protected void queryPages(OutputStream os, Object queryVO, User opr)
			throws Exception {
		regformat();
		HttpServletRequest request = (HttpServletRequest) queryVO;
		UapAnalyseDBParam param = (UapAnalyseDBParam)request.getAttribute("LISTVO");
		if(null == param){
			param = new UapAnalyseDBParam();
		}

		CommonBO cb = (CommonBO)BOFactory.build(CommonBO.class, opr);
		cb.setVoClass(UapAnalyseVO.class);
		param.set_pagesize("100");
		try{
			long startindex = Long.parseLong(param.getStartindex());
			long endindex = Long.parseLong(param.getEndindex());
			
			PageSetting.checkPageIndex(startindex,endindex,Long.parseLong(param.get_pagesize()));
			for( ; startindex <= endindex; startindex++){	

				param.set_pageno(String.valueOf(startindex));
				DataPackage dp = null;
				try {
					dp = cb.doQuery(param);
				} catch (Exception ex) {
					
				}
				if (dp!=null && dp.getDatas() != null && dp.toList(UapAnalyseVO.class).size()>0) {
					write(os, dp.getDatas().iterator(), new Class[] { UapAnalyseVO.class});
				}
				if (dp != null && (dp.toList(UapAnalyseVO.class) == null || dp.toList(UapAnalyseVO.class).size() < 100)) {
					break;
				}
				dp=null;

			}
			close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

	}

	protected void writeTitle() {
		String type = "";
		if("费项".equals(description)){
			type = "fx";
		}else if("无主原因".equals(description)){
			type = "wzyy";
		}else if("账单类型".equals(description)){
			type = "zdlx";
		}
		if("费项".equals(description) || "无主原因".equals(description) || "账单类型".equals(description)){
			this.title = new String[]{
					Message.getString(RESPATH, "areqtype"),
					Message.getString(RESPATH, type),
					Message.getString(RESPATH, "avalidbillcyc"),
	                Message.getString(RESPATH, "cmpmonth"),
	                Message.getString(RESPATH, "thismnthcount"),
	                Message.getString(RESPATH, "slastmnthcount"),
	                Message.getString(RESPATH, "thismnthamt"),
	                Message.getString(RESPATH, "slastmnthamt"),                     
	                Message.getString(RESPATH, "countchgrate"),
	                Message.getString(RESPATH, "amtchgrate"),
	                Message.getString(RESPATH, "atime"),
	                Message.getString(RESPATH, "remark"),
			};
		}else{
			this.title = new String[]{
					Message.getString(RESPATH, "areqtype"),
					Message.getString(RESPATH, "avalidbillcyc"),
	                Message.getString(RESPATH, "cmpmonth"),
	                Message.getString(RESPATH, "thismnthcount"),
	                Message.getString(RESPATH, "slastmnthcount"),
	                Message.getString(RESPATH, "thismnthamt"),
	                Message.getString(RESPATH, "slastmnthamt"),                     
	                Message.getString(RESPATH, "countchgrate"),
	                Message.getString(RESPATH, "amtchgrate"),
	                Message.getString(RESPATH, "atime"),
	                Message.getString(RESPATH, "remark"),
			};
		}
		
	}
	
	private void regformat(){
		addOutputProperty("rule_id",CODE2NAME,"#");
		if("费项".equals(description)){
			addOutputProperty("key_column",CODE2NAME,"#");
		}else if("无主原因".equals(description) || "账单类型".equals(description)){
			addOutputProperty("key_column",null,null);
		}
		addOutputProperty("validbillcyc",null,null);
	    addOutputProperty("cmp_month",null,null);
	    addOutputProperty("curcnt",null,null);
	    addOutputProperty("cmpcnt",null,null);
	    addOutputProperty("curamt",CODE2NAME,null);
	    addOutputProperty("cmpamt",CODE2NAME,"#");                     
	    addOutputProperty("chgrate_count",CODE2NAME,"#");
	    addOutputProperty("chgrate_amt",CODE2NAME,"#");
	    addOutputProperty("uptime",DATE,"yyyy-MM-dd HH:mm:ss");
	    addOutputProperty("remark",null,null);
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
