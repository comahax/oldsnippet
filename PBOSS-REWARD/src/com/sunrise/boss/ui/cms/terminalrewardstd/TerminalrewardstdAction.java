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
	public static final String CH_TERREWARDTYPE_PRO ="CH_TERREWARDTYPE_PRO";//ʡ��˾����
	public static final String CH_TERREWARDTYPE_CITY ="CH_TERREWARDTYPE_CITY";//�й�˾����
	
	
	
    public TerminalrewardstdAction() {
            setVoClass(TerminalrewardstdVO.class);
        // TODO: ������������������
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
		//region������й�˾����ʡ��˾,��ת����ͬ�ĳ������ҳ��
//		String region = (String) request.getParameter("region");
//		String region=tform.getRegion();
		//������й�˾����������Ϊ�й�˾��id,ʡ��˾�Ͳ�������
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
//    	//region������й�˾����ʡ��˾,��ת����ͬ�ĳ������ҳ��
//		String region = (String) request.getParameter("region");
//		//������й�˾����������Ϊ�й�˾��id,ʡ��˾�Ͳ�������
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
		export.setFileName("�ն˳���׼����");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("comid", "�ն���ƷID");
		export.addOutputProperty("rewardstd", "����׼"); 
		export.addOutputProperty("rewardtype", "�������", export.CODE2NAME, "$CH_TERREWARDTYPE");
		export.addOutputProperty("acctype", "�Ƴ�����", export.CODE2NAME, "#CH_ACCTYPE");
		export.addOutputProperty("adtremark", "��ע");
		export.addOutputProperty("standardprice", "��׼��");
		
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
    

