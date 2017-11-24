package com.sunrise.boss.web.fee.billing.checkplanresult;

import javax.servlet.http.HttpServletRequest;

import com.sunrise.boss.business.fee.billing.checkplanresult.control.CheckPlanResult;
import com.sunrise.boss.business.fee.billing.checkplanresult.persistent.CheckPlanResultDBParam;
import com.sunrise.boss.business.fee.billing.checkplanresult.persistent.CheckPlanResultVO;
import com.sunrise.boss.business.fee.billing.rhfixfeecresult.persistent.RhFixfeeCresultDBParam;
import com.sunrise.boss.web.fee.billing.rhfixfeecresult.ExcelOutRhFixfeeCresult;
import com.sunrise.jop.common.utils.i18n.Message;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;



public class CheckPlanResultAction extends BaseAction {
	
	private final static String RESPATH ="/com/sunrise/boss/web/fee/billing/checkplanresult/CheckPlanResultAction_zh_CN.properties";
	
	public CheckPlanResultAction() {	
		setForm(new CheckPlanResultForm());
	    setParam(new CheckPlanResultDBParam());
	    setClsVO(CheckPlanResultVO.class);

	    this.pkNameArray = new String[] { "logid" };
	    setClsControl(CheckPlanResult.class);
	    setClsQueryParam(CheckPlanResultDBParam.class);

	    String target = getRequest().getParameter("target");
	    if(target == null || target.equals("")){
	    	target = "GR";
	    }
	    if("JT".equals(target)) {
	    	setDbFlag(DBConstant.DB_FLAG_GDIB); //集团菜单
	    	getRequest().setAttribute("target",target);	
	    }else {
	    	setDbFlag(DBConstant.DB_FLAG_IB); //节点菜单
	    	getRequest().setAttribute("target",target);	
	    }
	}
	
	public String doList() throws Exception {
		String logid = getRequest().getParameter("logid");
		CheckPlanResultDBParam param = (CheckPlanResultDBParam) getParam();
		if(null != logid && !"".equals(logid)){
			param.set_ne_logid(logid);
		}
		return super.doList();
	}
	
	public String doExcel() throws Exception
	{
		User user = (User)getDBAccessUser();
		HttpServletRequest request = super.getRequest();
		CheckPlanResultDBParam param = (CheckPlanResultDBParam)getParam();
		ExcelOutCheckPlanResult export = new ExcelOutCheckPlanResult(user);
		
		export.setFileName(Message.getString(RESPATH, "title"));
		
		request.setAttribute("creator", export);
		request.setAttribute("LISTVO", param);
		request.setAttribute("queryVO", request);
		
		return "excelout";
	}
}
