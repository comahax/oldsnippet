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
	
	//װ����ʵUser
	private User realuser;
	
    public ChPdSubscriptionAction() {
            setVoClass(ChPdSubscriptionVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "prodno"; 
    }
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{ 
    	CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("������ϵ����");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("prodno", "���Ų�Ʒ���");
		export.addOutputProperty("provagentid", "ʡ�������̱���");
		export.addOutputProperty("provagentid", "ʡ������������", export.CODE2NAME, "#CH_PD_AGENT");		
		export.addOutputProperty("custid", "���ű���");
		export.addOutputProperty("custname", "��������");
		export.addOutputProperty("prodid", "���Ų�Ʒ��ʶ");
		export.addOutputProperty("prodid", "���Ų�Ʒ����", export.CODE2NAME, "#CH_PD_ENTPRODUCT");
		export.addOutputProperty("inbosstime", "��Ʒ¼��BOSSʱ��", export.DATE, "yyyy-MM-dd");
		export.addOutputProperty("cityid", "��չ����", export.CODE2NAME, "#REGIONNAME");
		export.addOutputProperty("salesi", "����SI");
		export.addOutputProperty("servsi", "����SI");
		export.addOutputProperty("agenteeid", "��չ�˹���");
		export.addOutputProperty("coopertype", "��������", export.CODE2NAME, "$PD_HZLX");
		export.addOutputProperty("incomstime", "COMS���ʱ��", export.DATE, "yyyy-MM-dd");
		export.addOutputProperty("validation", "��Ч��", export.CODE2NAME, "#PD_YESORNO");
		export.addOutputProperty("origin", "������Դ", export.CODE2NAME, "$PD_ORIGINTYPE");
		
		
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
