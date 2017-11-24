package com.sunrise.boss.web.fee.billing.rhfixfeecresult;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import com.sunrise.boss.business.fee.billing.rhfixfeecresult.persistent.RhFixfeeCresultDBParam;
import com.sunrise.boss.business.fee.billing.rhfixfeecresult.persistent.RhFixfeeCresultVO;
import com.sunrise.boss.common.export.ExcelCodeToName;
import com.sunrise.boss.common.export.ExportDataCreator;
import com.sunrise.boss.common.export.PageSetting;
import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.common.utils.i18n.Message;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class ExcelOutRhFixfeeCresult extends ExportDataCreator {
	
	private final static String RESPATH ="/com/sunrise/boss/web/fee/billing/rhfixfeecresult/RhFixfeeCresultAction_zh_CN.properties";
	
	public ExcelOutRhFixfeeCresult(User user) {
		super(user);		
	}

	protected String codeToName(String propertyName, String code, User user) {
		
		if (propertyName != null && "acctid".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("#WOFF-ACCT", code, user.getDbFlag());
		}
//		if (propertyName != null && "isaccount".equals(propertyName)) {
//			ExcelCodeToName et = new ExcelCodeToName();
//			code = et.codeToName("YES_NO", code, user.getDbFlag());
//		}
		if (propertyName != null && "resulttype".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$IB_REQ_UAP", code, user.getDbFlag());
		}
		return code;
	}

	protected void queryPages(OutputStream os, Object queryVO, User opr)
			throws Exception {
		regformat();
		HttpServletRequest request = (HttpServletRequest) queryVO;
		RhFixfeeCresultDBParam param = (RhFixfeeCresultDBParam)request.getAttribute("LISTVO");
		if(null == param){
			param = new RhFixfeeCresultDBParam();
		}

		CommonBO cb = (CommonBO)BOFactory.build(CommonBO.class, opr);
		cb.setVoClass(RhFixfeeCresultVO.class);
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
				if (dp!=null && dp.getDatas() != null && dp.toList(RhFixfeeCresultVO.class).size()>0) {
					write(os, dp.getDatas().iterator(), new Class[] { RhFixfeeCresultVO.class});
				}
				if (dp != null && (dp.toList(RhFixfeeCresultVO.class) == null || dp.toList(RhFixfeeCresultVO.class).size() < 100)) {
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
                Message.getString(RESPATH, "batch"),        
                Message.getString(RESPATH, "validbillcyc"),                   
                Message.getString(RESPATH, "servnumber"),   
                Message.getString(RESPATH, "subsid"),         
                Message.getString(RESPATH, "acctid"),        
                Message.getString(RESPATH, "receivable"),      
                Message.getString(RESPATH, "adjust"),         
                Message.getString(RESPATH, "paiclup"),     
                Message.getString(RESPATH, "planlist"),      
                Message.getString(RESPATH, "rulelist"),      
                Message.getString(RESPATH, "paicluplist"), 
                //Message.getString(RESPATH, "isaccount"),   
                Message.getString(RESPATH, "resulttype")
		};
	}
	
	private void regformat(){
		addOutputProperty("logid",NUMBER,"#");    
        addOutputProperty("batch",NUMBER,"#");        
        addOutputProperty("validbillcyc",NUMBER,"#");                   
        addOutputProperty("servnumber",NUMBER,"#");    
        addOutputProperty("subsid",NUMBER,"#");        
        addOutputProperty("acctid",CODE2NAME,"#");        
        addOutputProperty("receivable",NUMBER,"0.00");      
        addOutputProperty("adjust",NUMBER,"0.00");         
        addOutputProperty("paiclup",NUMBER,"0.00");     
        addOutputProperty("planlist",null,null);      
        addOutputProperty("rulelist",null,null);      
        addOutputProperty("paicluplist",null,null); 
        //addOutputProperty("isaccount",CODE2NAME,"#");   
        addOutputProperty("resulttype",CODE2NAME,"#");
	}

}
