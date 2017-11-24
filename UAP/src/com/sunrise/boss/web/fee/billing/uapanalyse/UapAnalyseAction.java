package com.sunrise.boss.web.fee.billing.uapanalyse;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sunrise.boss.business.common.dictitem.control.Dictitem;
import com.sunrise.boss.business.common.dictitem.control.DictitemBO;
import com.sunrise.boss.business.fee.billing.uapanalyse.control.UapAnalyseBO;
import com.sunrise.boss.business.fee.billing.uapanalyse.control.UapAnalyse;
import com.sunrise.boss.business.fee.billing.uapanalyse.persistent.UapAnalyseDBParam;
import com.sunrise.boss.business.fee.billing.uapanalyse.persistent.UapAnalyseVO;
import com.sunrise.jop.common.utils.i18n.Message;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

public class UapAnalyseAction extends BaseAction {
	
	private final static String RESPATH ="/com/sunrise/boss/web/fee/billing/uapanalyse/UapAnalyseAction_zh_CN.properties";

	public UapAnalyseAction(){
		setParam(new UapAnalyseDBParam());
		setClsVO(UapAnalyseVO.class);
		
		this.pkNameArray = new String[]{"logid","key_column"};
		
		setClsControl(UapAnalyse.class);
		setClsQueryParam(UapAnalyseDBParam.class);
		setDbFlag(DBConstant.DB_FLAG_BILL);
	}
	
	public String doList() throws Exception
	{
		User user = (User)super.getDBAccessUser();
		UapAnalyse bo = (UapAnalyse)BOFactory.build(UapAnalyseBO.class,user);
		Dictitem itemBo = (DictitemBO)BOFactory.build(DictitemBO.class, user);
		String logid = (String)super.getRequest().getParameter("logid");
		String req_type = (String)super.getRequest().getParameter("req_type");
		
		UapAnalyseDBParam param = (UapAnalyseDBParam)super.getParam();
		if(param.get_ne_logid() == null){
			param.set_ne_logid(logid);
		}
		if(param.get_ne_rule_id() == null){
			param.set_ne_rule_id(req_type);
		}
		getRequest().setAttribute("req_type", param.get_ne_rule_id());
		getRequest().setAttribute("logid", param.get_ne_logid());
		param.set_orderby("is_normal");
		param.set_desc("1");
		DataPackage dp = bo.doQuery(param);
		setDp(dp);
		
		DataPackage itemDp = itemBo.doQueryDescription(param.get_ne_rule_id(),"IB_REQ_UAP", user);
		String description = "";
		if(itemDp != null && !itemDp.getDatas().isEmpty() && itemDp.getDatas().size() > 0){
			Map map = (HashMap) itemDp.getDatas().get(0);
			description = map.get("description").toString();
		}
		getRequest().setAttribute("description", description);
		this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		
		return "list";
	}
	
	
	public String doExcel() throws Exception {
		User user = (User)getDBAccessUser();
		HttpServletRequest request = super.getRequest();
		UapAnalyseDBParam param = (UapAnalyseDBParam)getParam();
		ExcelOutUapAnalyse export = new ExcelOutUapAnalyse(user);
		
		String s = getRequest().getParameter("description");
		String description = new String(s.getBytes("ISO8859-1"),"UTF-8");
		export.setFileName(Message.getString(RESPATH, "title2"));
		export.setDescription(description);
		
		request.setAttribute("creator", export);
		request.setAttribute("LISTVO", param);
		request.setAttribute("queryVO", request);
		return "excelout";
	}
	
}
