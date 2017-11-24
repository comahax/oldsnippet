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
	public static final String CH_TERREWARDTYPE_PRO ="CH_TERREWARDTYPE_PRO";//省公司令牌
    public ChAdtClassplatformtdstdAction() {
            setVoClass(ChAdtClassplatformtdstdVO.class);
        // TODO: 给出主键的名字数组
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
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "BOSS商品ID不合法!");
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
		export.setFileName("类平台裸机终端合作机型达量酬金标准管理");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("comid", "BOSS商品ID");
		export.addOutputProperty("rewardtype", "酬金类型", export.CODE2NAME, "$CH_CPFTDREWARDTYPE");
		export.addOutputProperty("acctype", "计酬标识", export.CODE2NAME, "#CLASSPLATFORMTDSTD_ACCTYPE");
		export.addOutputProperty("saleslower", "销售量区间下限");
		export.addOutputProperty("salesupper", "销售量区间上限");
		export.addOutputProperty("rewardstd", "酬金标准");
		export.addOutputProperty("citycode", "地市标识", export.CODE2NAME, "#CITYIDNUM2NMAME");
		
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
