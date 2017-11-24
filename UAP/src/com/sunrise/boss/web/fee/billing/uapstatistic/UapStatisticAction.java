package com.sunrise.boss.web.fee.billing.uapstatistic;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sunrise.boss.business.common.dictitem.control.Dictitem;
import com.sunrise.boss.business.common.dictitem.control.DictitemBO;
import com.sunrise.boss.business.fee.billing.uapstatistic.control.UapStatistic;
import com.sunrise.boss.business.fee.billing.uapstatistic.control.UapStatisticBO;
import com.sunrise.boss.business.fee.billing.uapstatistic.persistent.UapStatisticDBParam;
import com.sunrise.boss.business.fee.billing.uapstatistic.persistent.UapStatisticVO;
import com.sunrise.jop.common.utils.i18n.Message;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

public class UapStatisticAction extends BaseAction 
{
	private final static String RESPATH ="/com/sunrise/boss/web/fee/billing/uapstatistic/UapStatisticAction_zh_CN.properties";
	
	public UapStatisticAction()
	{
	    setParam(new UapStatisticDBParam());
	    setClsVO(UapStatisticVO.class);

	    this.pkNameArray = new String[] {"logid","key_column"};
	   
	    setClsControl(UapStatistic.class);
	    setClsQueryParam(UapStatisticDBParam.class);
	    setDbFlag(DBConstant.DB_FLAG_BILL);
	}

	public String doList() throws Exception
	{
		String logid = (String)super.getRequest().getParameter("logid");
		String req_type = (String)super.getRequest().getParameter("req_type");
		User user = (User)super.getDBAccessUser();
		UapStatistic bo = (UapStatistic)BOFactory.build(UapStatisticBO.class, user);
		Dictitem itemBo = (DictitemBO)BOFactory.build(DictitemBO.class, user);
		UapStatisticDBParam param = (UapStatisticDBParam)super.getParam();
		if(param.get_ne_logid() == null){
			param.set_ne_logid(logid);
		}
		if(param.get_ne_rule_id() == null){
			param.set_ne_rule_id(req_type);
		}
		getRequest().setAttribute("req_type", param.get_ne_rule_id());
		getRequest().setAttribute("logid", param.get_ne_logid());
		
		DataPackage itemDp = itemBo.doQueryDescription(param.get_ne_rule_id(),"IB_REQ_UAP", user);
		String description = "";
		if(itemDp != null && !itemDp.getDatas().isEmpty() && itemDp.getDatas().size() > 0){
			Map map = (HashMap) itemDp.getDatas().get(0);
			description = map.get("description").toString();
		}
		getRequest().setAttribute("description", description);
		
		DataPackage dp = bo.doQuery(param);
		setDp(dp);
		this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		
		return "list";
	}
	
	
	public String doExcel() throws Exception {
		User user = (User)getDBAccessUser();
		HttpServletRequest request = super.getRequest();
		UapStatisticDBParam param = (UapStatisticDBParam)getParam();
		ExcelOutUapStatistic export = new ExcelOutUapStatistic(user);
		
		String s = getRequest().getParameter("description");
		String description = new String(s.getBytes("ISO8859-1"),"UTF-8");
		export.setFileName(Message.getString(RESPATH, "title1"));
		export.setDescription(description);
		
		request.setAttribute("creator", export);
		request.setAttribute("LISTVO", param);
		request.setAttribute("queryVO", request);
		return "excelout";
	}

	
}
