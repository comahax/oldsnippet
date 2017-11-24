package com.gmcc.pboss.web.sales.order;

import java.io.FileNotFoundException;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.processfile.BatchTaskAction;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.web.common.webservice.CRMService;
import com.opensymphony.xwork2.ActionContext;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.struts2.WebConstant;

public class RecordedBatchTaskAction extends BatchTaskAction {
	public String execute() throws Exception {
		try {
			String step = getRequest().getParameter("step");
			getRequest().setAttribute("step", step);
			
			//系统入账
			if(StringUtils.isEmpty(step))
			{
				DBAccessUser user = (DBAccessUser)ActionContext.getContext().getSession().get(WebConstant.SESSION_ATTRIBUTE_USER);				
				CRMService crmservice = new CRMService();
				if(crmservice.isCRMCityPort(user.getCityid())){//如果调用CRM接口入账，等待时间设为0
					getRequest().setAttribute("delaySeconds", "0");
				}else{//否则，BOSS入账
					Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
					String paramValue = sysparam.doFindByID("9", "pboss_fx");
					if(null==paramValue)paramValue = "120";
					getRequest().setAttribute("delaySeconds", paramValue);
				}
			}
			//boss接口入账
			else
			{
				String filename = getRequest().getParameter("filename");
				serializeParameter(filename);
			}
			return doProcess();
		} catch (Exception ex) {
			String msg = ex.getMessage();
			if (ex instanceof FileNotFoundException) {// 屏蔽文件路径
				msg = "系统找不到指定的文件";
			}
			addActionError(msg);
			return ERROR;
		}
	}

}
