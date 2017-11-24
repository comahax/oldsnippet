package com.sunrise.boss.web.fee.billing.checkplanresult;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import com.sunrise.boss.business.fee.billing.checkplanresult.persistent.CheckPlanResultDBParam;
import com.sunrise.boss.business.fee.billing.checkplanresult.persistent.CheckPlanResultVO;
import com.sunrise.boss.common.export.ExcelCodeToName;
import com.sunrise.boss.common.export.ExportDataCreator;
import com.sunrise.boss.common.export.PageSetting;
import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.common.utils.i18n.Message;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class ExcelOutCheckPlanResult extends ExportDataCreator {
	
	private final static String RESPATH ="/com/sunrise/boss/web/fee/billing/checkplanresult/CheckPlanResultAction_zh_CN.properties";
	
	public ExcelOutCheckPlanResult(User user) {
		super(user);		
	}

	protected String codeToName(String propertyName, String code, User user) {
		
		if (propertyName != null && "acctid".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("#WOFF-ACCT", code, user.getDbFlag());
		}
		if (propertyName != null && "resulttype".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("CHECKPLAN_RESULTTYPE", code, user.getDbFlag());
		}
		return code;
	}

	protected void queryPages(OutputStream os, Object queryVO, User opr)
			throws Exception {
		regformat();
		HttpServletRequest request = (HttpServletRequest) queryVO;
		CheckPlanResultDBParam param = (CheckPlanResultDBParam)request.getAttribute("LISTVO");
		if(null == param){
			param = new CheckPlanResultDBParam();
		}

		CommonBO cb = (CommonBO)BOFactory.build(CommonBO.class, opr);
		cb.setVoClass(CheckPlanResultVO.class);
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
				if (dp!=null && dp.getDatas() != null && dp.toList(CheckPlanResultVO.class).size()>0) {
					write(os, dp.getDatas().iterator(), new Class[] { CheckPlanResultVO.class});
				}
				if (dp != null && (dp.toList(CheckPlanResultVO.class) == null || dp.toList(CheckPlanResultVO.class).size() < 100)) {
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
		// TODO Auto-generated method stub
		this.title = new String[]{
				Message.getString(RESPATH, "logid"),          
                Message.getString(RESPATH, "validbillcyc"),   
                Message.getString(RESPATH, "batch"),          
                Message.getString(RESPATH, "prodid"),         
                Message.getString(RESPATH, "prodname"),       
                Message.getString(RESPATH, "servnumber"),     
                Message.getString(RESPATH, "subsid"),         
                Message.getString(RESPATH, "status"),         
                Message.getString(RESPATH, "useddays"),       
                Message.getString(RESPATH, "tariffitemid"),   
                Message.getString(RESPATH, "acctid"),         
                Message.getString(RESPATH, "prodfee"),         
                Message.getString(RESPATH, "receivable"),        
                Message.getString(RESPATH, "adjust"),        
                Message.getString(RESPATH, "paiclup"),     
                Message.getString(RESPATH, "planlist"),       
                Message.getString(RESPATH, "rulelist"),       
                Message.getString(RESPATH, "paicluplist"), 
                Message.getString(RESPATH, "resulttype"),   
                Message.getString(RESPATH, "checkresult")
		};
	}
	
	private void regformat(){
		addOutputProperty("logid",NUMBER,"#");          
        addOutputProperty("validbillcyc",NUMBER,"#");   
        addOutputProperty("batch",NUMBER,"#");          
        addOutputProperty("prodid",null,null);         
        addOutputProperty("prodname",null,null);       
        addOutputProperty("servnumber",NUMBER,"#");     
        addOutputProperty("subsid",NUMBER,"#");         
        addOutputProperty("status",NUMBER,"#");         
        addOutputProperty("useddays",NUMBER,"#");       
        addOutputProperty("tariffitemid",null,null);   
        addOutputProperty("acctid",CODE2NAME,"#");         
        addOutputProperty("prodfee",NUMBER,"0.00");         
        addOutputProperty("receivable",NUMBER,"0.00");        
        addOutputProperty("adjust",NUMBER,"0.00");        
        addOutputProperty("paiclup",NUMBER,"0.00");     
        addOutputProperty("planlist",null,null);       
        addOutputProperty("rulelist",null,null);       
        addOutputProperty("paicluplist",null,null); 
        addOutputProperty("resulttype",CODE2NAME,"#");   
        addOutputProperty("checkresult",null,null); 
	}

}
