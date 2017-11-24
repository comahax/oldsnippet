package com.sunrise.boss.web.fee.billing.billlogdeta;

import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;

import com.sunrise.boss.business.fee.billing.billlogdeta.persistent.BillLogDetaDBParam;
import com.sunrise.boss.business.fee.billing.billlogdeta.persistent.BillLogDetaVO;
import com.sunrise.boss.common.export.ExcelCodeToName;
import com.sunrise.boss.common.export.ExportDataCreator;
import com.sunrise.boss.common.export.PageSetting;
import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.common.utils.i18n.Message;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class ExcelOutBillLogDeta extends ExportDataCreator 
{
	public static final String BILLLOGDETA_FEE_PROPERTIES = "/com/sunrise/boss/web/fee/billing/billlogdeta/BillLogDetaAction_zh_CN.properties";
	public ExcelOutBillLogDeta(User user) {
		super(user);		
	}

	protected String codeToName(String propertyName, String code, User user) {
		
		if (propertyName != null && "acctid".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("#WOFF-ACCT", code, user.getDbFlag());
		}
		
		if (propertyName != null && "subphase".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$IB_WL_RHBILLLOGDETA", code, user.getDbFlag());
		}
		
		if (propertyName != null && "acctamt".equals(propertyName)) {
			NumberFormat numberFormat = new DecimalFormat("0.00");
	        code = numberFormat.format( new Double(code)/100 );
		}
		return code;
	}

	protected void queryPages(OutputStream os, Object queryVO, User opr)
			throws Exception {
		regformat();
		HttpServletRequest request = (HttpServletRequest) queryVO;
		BillLogDetaDBParam param = (BillLogDetaDBParam)request.getAttribute("LISTVO");
		if(null == param){
			param = new BillLogDetaDBParam();
		}

		CommonBO cb = (CommonBO)BOFactory.build(CommonBO.class, opr);
		cb.setVoClass(BillLogDetaVO.class);
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
				if (dp!=null && dp.getDatas() != null && dp.toList(BillLogDetaVO.class).size()>0) {
					write(os, dp.getDatas().iterator(), new Class[] { BillLogDetaVO.class});
				}
				if (dp != null && (dp.toList(BillLogDetaVO.class) == null || dp.toList(BillLogDetaVO.class).size() < 100)) {
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
		this.title = new String[]{
				Message.getString(BILLLOGDETA_FEE_PROPERTIES, "validbillcyc"),
				Message.getString(BILLLOGDETA_FEE_PROPERTIES, "subphase"),
				Message.getString(BILLLOGDETA_FEE_PROPERTIES, "acctid"),
				Message.getString(BILLLOGDETA_FEE_PROPERTIES, "acctname"),
				Message.getString(BILLLOGDETA_FEE_PROPERTIES, "acctamt"),
				Message.getString(BILLLOGDETA_FEE_PROPERTIES, "acctcount")
		};
	}
	
	private void regformat(){
		addOutputProperty("validbillcyc",NUMBER,"#");
		addOutputProperty("subphase",CODE2NAME,"#");
		addOutputProperty("acctid",NUMBER,"#");
		addOutputProperty("acctid",CODE2NAME,"#");
		addOutputProperty("acctamt",CODE2NAME,"#");
		addOutputProperty("acctcount",NUMBER,"#");
	}

}
