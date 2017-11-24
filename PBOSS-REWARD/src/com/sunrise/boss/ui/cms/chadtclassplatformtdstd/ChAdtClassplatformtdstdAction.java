/**
* auto-generated code
* Fri Feb 01 14:20:31 CST 2013
*/
package com.sunrise.boss.ui.cms.chadtclassplatformtdstd;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.chadtclassplatformtdinfo.persistent.ChAdtClassplatformtdinfoListVO;
import com.sunrise.boss.business.cms.chadtclassplatformtdstd.persistent.ChAdtClassplatformtdstdVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.chadtclassplatformtdinfo.ChAdtClassplatformtdinfoDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.cms.chadtclassplatformtdinfo.ChAdtClassplatformtdinfoForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChAdtClassplatformtdstdAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtClassplatformtdstdAction extends BaseAction {
	public static final String CH_TERREWARDTYPE_PRO ="CH_TERREWARDTYPE_PRO";//ʡ��˾����
    public ChAdtClassplatformtdstdAction() {
            setVoClass(ChAdtClassplatformtdstdVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }

    
    public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		return actionMapping.findForward("batch");
	}
    
    
    
	@Override
	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		if(((ChAdtClassplatformtdstdForm)actionForm).get_ne_citycode() == null || "".equals(((ChAdtClassplatformtdstdForm)actionForm).get_ne_citycode())){
			boolean ispass = false;
			ACLDelegate acldelegate = new ACLDelegate(); 
			ispass = acldelegate.checkPermission(user.getOpercode(), CH_TERREWARDTYPE_PRO);
			if(ispass){
				((ChAdtClassplatformtdstdForm)actionForm).set_ne_citycode("999");
			}else{
			((ChAdtClassplatformtdstdForm)actionForm).set_ne_citycode(user.getCityid());
			}
		}
		return super.doList(actionMapping, actionForm, request, response, user);
	}




	@Override
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Date mdate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String currdate = format.format(mdate);
		
		ChAdtClassplatformtdstdForm chAdtClassplatformtdstdForm = (ChAdtClassplatformtdstdForm)actionForm;
		
		ChAdtClassplatformtdinfoDelegate chAdtClassplatformtdinfoDelegate = new ChAdtClassplatformtdinfoDelegate();
		ChAdtClassplatformtdinfoListVO ChAdtClassplatformtdinfoListVO = new ChAdtClassplatformtdinfoListVO();
		ChAdtClassplatformtdinfoListVO.set_se_comid(chAdtClassplatformtdstdForm.getComid());
		ChAdtClassplatformtdinfoListVO.set_dnl_enddate(currdate);
		ChAdtClassplatformtdinfoListVO.set_dnm_startdate(currdate);
		
		DataPackage dpp = chAdtClassplatformtdinfoDelegate.doQuery(ChAdtClassplatformtdinfoListVO, user);
		if(dpp == null || dpp.getDatas() == null || dpp.getDatas().size() == 0){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "BOSS��ƷID���Ϸ�!");
			return (actionMapping.findForward("content"));
		}else{
			
			boolean ispass;
			ACLDelegate acldelegate = new ACLDelegate(); 
			ispass = acldelegate.checkPermission(user.getOpercode(), CH_TERREWARDTYPE_PRO);
			if(ispass){
				((ChAdtClassplatformtdstdForm) actionForm).setCitycode(Short.parseShort("999"));
			}else{
				((ChAdtClassplatformtdstdForm) actionForm).setCitycode(((ChAdtClassplatformtdstdForm) actionForm).getCitycode());
			}
			return super.doSave(actionMapping, actionForm, request, response, user);			
		}		
	}
	
	
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("��ƽ̨����ն˺������ʹ�������׼����");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("comid", "BOSS��ƷID");
		export.addOutputProperty("rewardtype", "�������", export.CODE2NAME, "$CH_CPFTDREWARDTYPE");
		export.addOutputProperty("acctype", "�Ƴ��ʶ", export.CODE2NAME, "#CLASSPLATFORMTDSTD_ACCTYPE");
		export.addOutputProperty("saleslower", "��������������");
		export.addOutputProperty("salesupper", "��������������");
		export.addOutputProperty("rewardstd", "����׼");
		export.addOutputProperty("citycode", "���б�ʶ", export.CODE2NAME, "#CITYIDNUM2NMAME");
		
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
