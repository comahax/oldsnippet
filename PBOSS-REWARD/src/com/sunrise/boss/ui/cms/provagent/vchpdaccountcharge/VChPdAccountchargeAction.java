/**
* auto-generated code
* Wed Sep 04 20:56:32 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.vchpdaccountcharge;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.provagent.chpdsubscription.persistent.ChPdSubscriptionVO;
import com.sunrise.boss.business.cms.provagent.vchpdaccountcharge.persistent.VChPdAccountchargeListVO;
import com.sunrise.boss.business.cms.provagent.vchpdaccountcharge.persistent.VChPdAccountchargeVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.provagent.vchpdaccountcharge.VChPdAccountchargeDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: VChPdAccountchargeAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class VChPdAccountchargeAction extends BaseAction {
	
	//装载真实User
	private User realuser;
	
    public VChPdAccountchargeAction() {
            setVoClass(VChPdAccountchargeVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "chargeid"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	VChPdAccountchargeForm form = (VChPdAccountchargeForm) actionForm;
		Page.setPageSize(request, (VChPdAccountchargeForm) form);
		
		VChPdAccountchargeListVO vchpdaccountchargelistvo = new VChPdAccountchargeListVO();
		setListVO(vchpdaccountchargelistvo, actionForm);
		Date date = new Date(System.currentTimeMillis());
		if(vchpdaccountchargelistvo.get_dnl_incomstime()!=null && !("".equals(vchpdaccountchargelistvo.get_dnl_incomstime())))
			vchpdaccountchargelistvo.set_dnl_incomstime(vchpdaccountchargelistvo.get_dnl_incomstime()+" 00:00:00");
		if(vchpdaccountchargelistvo.get_dnm_incomstime()!=null && !("".equals(vchpdaccountchargelistvo.get_dnm_incomstime())))
			vchpdaccountchargelistvo.set_dnm_incomstime(vchpdaccountchargelistvo.get_dnm_incomstime()+" 23:59:59");
		
		realuser=user;
    	user.setCityid(SessionFactoryRouter.conversionCityid2Num(form.get_se_cityid()));
		VChPdAccountchargeDelegate vchpdaccountchargeDelegate = new VChPdAccountchargeDelegate();
		DataPackage pack = vchpdaccountchargeDelegate.doQuery(vchpdaccountchargelistvo, user);
		user=realuser;
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		return (actionMapping.findForward("list"));
    }
    
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	VChPdAccountchargeForm form = (VChPdAccountchargeForm) actionForm;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar   ca   =   Calendar.getInstance();
		ca.setTime(new Date());
		ca.set(Calendar.DAY_OF_MONTH,   1);
		Date   firstDate   =   ca.getTime();
		ca.add(Calendar.MONTH,   1);
		ca.add(Calendar.DAY_OF_MONTH,   -1);
		Date   lastDate   =   ca.getTime();
		
		if(form.get_dnl_incomstime()==null || ("".equals(form.get_dnl_incomstime())))
			form.set_dnl_incomstime(df.format(firstDate));
		if(form.get_dnm_incomstime()==null || ("".equals(form.get_dnm_incomstime())))
			form.set_dnm_incomstime(df.format(lastDate));
		
		return (actionMapping.findForward("list"));
    }
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{ 
    	CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("集团产品销账数据查询");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("chargeid", "记录序号");
		export.addOutputProperty("cityid", "地市标识", export.CODE2NAME, "#REGIONNAME");
		export.addOutputProperty("prodno", "集团产品编号");
		export.addOutputProperty("provagentid", "代理商编码");
		export.addOutputProperty("provagentid", "代理商名称", export.CODE2NAME, "#CH_PD_AGENT");	
		export.addOutputProperty("prodid", "集团产品标识");
		export.addOutputProperty("prodid", "集团产品名称", export.CODE2NAME, "#CH_PD_ENTPRODUCT");
		export.addOutputProperty("custname", "集团名称");		
		export.addOutputProperty("chargemoney", "销账金额");		
		export.addOutputProperty("feemonth", "计费月份");
		export.addOutputProperty("incomstime", "采集时间", export.DATE, "yyyy-MM-dd");
		export.addOutputProperty("phase", "期数");
		export.addOutputProperty("rewardid", "酬金明细序号");		
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);		
		export.voClassArray = new Class[] { VChPdAccountchargeVO.class };
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	
    	return null;
    }
}
