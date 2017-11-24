/**
* auto-generated code
* Tue Sep 03 21:23:23 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.chpdsubscription;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.provagent.chpdsubscription.persistent.ChPdSubscriptionVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChPdSubscriptionAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChPdSubscriptionAction extends BaseDelegateAction {
	
	//装载真实User
	private User realuser;
	
    public ChPdSubscriptionAction() {
            setVoClass(ChPdSubscriptionVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "prodno"; 
    }
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{ 
    	CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("订购关系管理");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("prodno", "集团产品编号");
		export.addOutputProperty("provagentid", "省级代理商编码");
		export.addOutputProperty("provagentid", "省级代理商名称", export.CODE2NAME, "#CH_PD_AGENT");		
		export.addOutputProperty("custid", "集团编码");
		export.addOutputProperty("custname", "集团名称");
		export.addOutputProperty("prodid", "集团产品标识");
		export.addOutputProperty("prodid", "集团产品名称", export.CODE2NAME, "#CH_PD_ENTPRODUCT");
		export.addOutputProperty("inbosstime", "产品录入BOSS时间", export.DATE, "yyyy-MM-dd");
		export.addOutputProperty("cityid", "发展地市", export.CODE2NAME, "#REGIONNAME");
		export.addOutputProperty("salesi", "销售SI");
		export.addOutputProperty("servsi", "服务SI");
		export.addOutputProperty("agenteeid", "发展人工号");
		export.addOutputProperty("coopertype", "合作类型", export.CODE2NAME, "$PD_HZLX");
		export.addOutputProperty("incomstime", "COMS入库时间", export.DATE, "yyyy-MM-dd");
		export.addOutputProperty("validation", "有效性", export.CODE2NAME, "#PD_YESORNO");
		export.addOutputProperty("origin", "数据来源", export.CODE2NAME, "$PD_ORIGINTYPE");
		
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);		
		export.voClassArray = new Class[] { ChPdSubscriptionVO.class };
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	
    	return null;
    }
    
    public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{ 
    	
    	ChPdSubscriptionForm Form = (ChPdSubscriptionForm) actionForm;
    	if(null == Form.getInbosstime() || "".equals(Form.getInbosstime())){
    		Form.setInbosstime(new Date());
    	}
    	realuser=user;
    	user.setCityid(SessionFactoryRouter.conversionCityid2Num(Form.getCityid()));
    	super.doSave(actionMapping, actionForm, request, response, user);
    	user=realuser;
    	return (actionMapping.findForward("content"));
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{ 
    	
    	ChPdSubscriptionForm Form = (ChPdSubscriptionForm) actionForm;
    	realuser=user;
    	user.setCityid(SessionFactoryRouter.conversionCityid2Num(Form.get_se_cityid()));
    	super.doList(actionMapping, actionForm, request, response, user);
    	user=realuser;
    	return (actionMapping.findForward("list"));
    }
    
    public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{ 
    	
    	ChPdSubscriptionForm Form = (ChPdSubscriptionForm) actionForm;
    	Form.setInbosstime(new Date());
    	Form.setIncomstime(new Date());
    	Form.setOrigin(new Byte("2"));
    	return (actionMapping.findForward("content"));
    }
}
