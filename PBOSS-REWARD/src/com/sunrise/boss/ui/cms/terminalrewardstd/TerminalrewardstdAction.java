/**
* auto-generated code
* Sat Jan 05 17:17:55 CST 2013
*/
package com.sunrise.boss.ui.cms.terminalrewardstd;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.terminalrewardstd.persistent.TerminalrewardstdVO;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: TerminalrewardstdAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lc
 * @version 1.0
 */
public class TerminalrewardstdAction extends BaseAction {
	public static final String CH_TERREWARDTYPE_PRO ="CH_TERREWARDTYPE_PRO";//省公司令牌
	public static final String CH_TERREWARDTYPE_CITY ="CH_TERREWARDTYPE_CITY";//市公司令牌
	
	
	
    public TerminalrewardstdAction() {
            setVoClass(TerminalrewardstdVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[4]; 
           pkNameArray[0] = "citycode"; 
           pkNameArray[1] = "comid"; 
           pkNameArray[2] = "rewardtype"; 
    }
    protected ActionForward doEdit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		getContentVO(request, user, actionForm);
		String command = getCommandString(request);
		
		TerminalrewardstdForm tform=(TerminalrewardstdForm)actionForm;
//		tform.setRegion("");
		Short.toString(tform.getCitycode());
		if("999".equals(Short.toString(tform.getCitycode())))
			tform.setRegion("999");
		else
			tform.setRegion(Short.toString(tform.getCitycode()));
		((BaseActionForm) tform).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}
    
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		TerminalrewardstdForm tform=(TerminalrewardstdForm)actionForm;
		boolean ispass = false;
		ACLDelegate acldelegate = new ACLDelegate(); 
		ispass = acldelegate.checkPermission(user.getOpercode(), CH_TERREWARDTYPE_PRO);
		if(ispass){
			if(tform.get_ne_citycode() == null || tform.get_ne_citycode().equals("")){
				tform.set_ne_citycode("999");	
			}
			tform.setRegion("999");
		}
		else{
			if(tform.get_ne_citycode() == null || tform.get_ne_citycode().equals("")){
			tform.set_ne_citycode(user.getCityid());
			}
			tform.setRegion(user.getCityid());
		} 
		tform.set_orderby("comid");
		tform.set_desc("0");
		//region获得是市公司还是省公司,跳转到不同的酬金设置页面
//		String region = (String) request.getParameter("region");
//		String region=tform.getRegion();
		//如果是市公司过来就设置为市公司的id,省公司就不用设置
//		if("999".equals(region)){
//			tform.set_ne_citycode("999");
//			tform.setRegion("999");
//		}
//		else{
//			tform.set_ne_citycode(user.getCityid());
//			tform.setRegion(user.getCityid());
//		}
		
		return super.doList(actionMapping, tform, request, response, user);
	
	
	}
    
    public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	TerminalrewardstdForm tform=(TerminalrewardstdForm)actionForm;
    	String region=tform.getRegion();
    	
    	if("999".equals(region))
//    		tform.setCitycode(Short.parseShort("999"));
    		return actionMapping.findForward("batchpro");
//		else
//			tform.setCitycode(Short.parseShort(user.getCityid()));
    	
		return actionMapping.findForward("batch");
		
	}
    
//    protected ActionForward doSave(ActionMapping actionMapping,
//			ActionForm actionForm, HttpServletRequest request,
//			HttpServletResponse response, User user) throws Exception {
//    	
//    	//region获得是市公司还是省公司,跳转到不同的酬金设置页面
//		String region = (String) request.getParameter("region");
//		//如果是市公司过来就设置为市公司的id,省公司就不用设置
//		if("000".equals(region))
//			form.setRegion(user.getCityid());
//    	
//    	TerminalrewardstdForm tform=(TerminalrewardstdForm)actionForm;
//    	
////    	SessionFactoryRouter.conversionCityid2Num(cityid2)
//    	tform.setCitycode(Short.parseShort(user.getCityid()));
//    	tform.setCreatetime(new Date());
//    	return super.doSave(actionMapping, tform, request, response, user);
//    }
    
    public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	
    	TerminalrewardstdForm tform=(TerminalrewardstdForm)actionForm;
    	String region=tform.getRegion();
    	
    	if("999".equals(region))
    		tform.setCitycode(Short.parseShort("999"));
		else
			tform.setCitycode(Short.parseShort(user.getCityid()));
    	
//    	tform.setCitycode(Short.parseShort(user.getCityid()));
    	tform.setCreatetime(new Date());
    	return super.doNew(actionMapping, tform, request, response, user);
    	
    }
    
    
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("终端酬金标准参数");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("comid", "终端商品ID");
		export.addOutputProperty("rewardstd", "酬金标准"); 
		export.addOutputProperty("rewardtype", "酬金类型", export.CODE2NAME, "$CH_TERREWARDTYPE");
		export.addOutputProperty("acctype", "计酬类型", export.CODE2NAME, "#CH_ACCTYPE");
		export.addOutputProperty("adtremark", "备注");
		export.addOutputProperty("standardprice", "基准价");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {voClass};
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}
    
}
    

