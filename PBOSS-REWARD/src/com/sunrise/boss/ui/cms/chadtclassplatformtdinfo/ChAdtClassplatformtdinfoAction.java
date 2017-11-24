/**
 * auto-generated code
 * Fri Feb 01 12:08:34 CST 2013
 */
package com.sunrise.boss.ui.cms.chadtclassplatformtdinfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.persistent.ChAdtClassplatformbrandinfoListVO;
import com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.persistent.ChAdtClassplatformbrandinfoVO;
import com.sunrise.boss.business.cms.chadtclassplatformtdinfo.persistent.ChAdtClassplatformtdinfoVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.chadtclassplatformbrandinfo.ChAdtClassplatformbrandinfoDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;

/**
 * <p>
 * Title: ChAdtClassplatformtdinfoAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author limin
 * @version 1.0
 */
public class ChAdtClassplatformtdinfoAction extends BaseAction {
	public static final String CH_TERREWARDTYPE_PRO ="CH_TERREWARDTYPE_PRO";//省公司令牌
	public ChAdtClassplatformtdinfoAction() {
		setVoClass(ChAdtClassplatformtdinfoVO.class);
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

		ChAdtClassplatformbrandinfoDelegate chAdtClassplatformbrandinfoDelegate = new ChAdtClassplatformbrandinfoDelegate();
		ChAdtClassplatformbrandinfoListVO chAdtClassplatformbrandinfoListVO = new ChAdtClassplatformbrandinfoListVO();
		chAdtClassplatformbrandinfoListVO.set_ne_state("1");
		DataPackage dpp = chAdtClassplatformbrandinfoDelegate.doQuery(
				chAdtClassplatformbrandinfoListVO, user);
		request.setAttribute("CH_ADT_CLASSPLATFORMBRAND", dpp);
		
		ChAdtClassplatformtdinfoForm tform=(ChAdtClassplatformtdinfoForm)actionForm;
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
		
		super.doList(actionMapping, actionForm, request, response, user);
		
		//翻译品牌名称
		
		DataPackage datap = (DataPackage)request.getAttribute(WebConstant.PAGE_ATTRIBUTE_LIST);
		
		if(datap.getDatas() != null && datap.getDatas().size() > 0){
			for(Iterator<ChAdtClassplatformtdinfoVO> it=datap.getDatas().iterator();it.hasNext();){
				ChAdtClassplatformtdinfoVO chAdtClassplatformtdinfoVO = it.next();
				for(Iterator<ChAdtClassplatformbrandinfoVO> itt=dpp.getDatas().iterator();itt.hasNext();){
					ChAdtClassplatformbrandinfoVO chAdtClassplatformbrandinfoVO = itt.next();
					if(chAdtClassplatformtdinfoVO.getTdbrandid() != null && chAdtClassplatformbrandinfoVO.getBrandid() == Long.parseLong(chAdtClassplatformtdinfoVO.getTdbrandid()+"")){
						chAdtClassplatformtdinfoVO.setTdbrandname(chAdtClassplatformbrandinfoVO.getBrandname());
					}
				}	
			}	
		}
		return  (actionMapping.findForward("list"));
	}

	@Override
	protected ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		return super.doDelete(actionMapping, actionForm, request, response, user);
	}

	
	@Override
	protected ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChAdtClassplatformbrandinfoDelegate chAdtClassplatformbrandinfoDelegate = new ChAdtClassplatformbrandinfoDelegate();
		ChAdtClassplatformbrandinfoListVO chAdtClassplatformbrandinfoListVO = new ChAdtClassplatformbrandinfoListVO();
		chAdtClassplatformbrandinfoListVO.set_ne_state("1");
		DataPackage dpp = chAdtClassplatformbrandinfoDelegate.doQuery(
				chAdtClassplatformbrandinfoListVO, user);
		request.setAttribute("CH_ADT_CLASSPLATFORMBRAND", dpp);
		
		getContentVO(request, user, actionForm);
		String command = getCommandString(request);
		((ChAdtClassplatformtdinfoForm) actionForm).setCmdState(command);
		
		
		ChAdtClassplatformtdinfoForm tform=(ChAdtClassplatformtdinfoForm)actionForm;
//		tform.setRegion("");
		Short.toString(tform.getCitycode());
		if("999".equals(Short.toString(tform.getCitycode())))
			tform.setRegion("999");
		else
			tform.setRegion(Short.toString(tform.getCitycode()));
		
		
		
		request.setAttribute("tdbrandid", ((ChAdtClassplatformtdinfoForm) actionForm).getTdbrandid());
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}

	@Override
	protected ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChAdtClassplatformbrandinfoDelegate chAdtClassplatformbrandinfoDelegate = new ChAdtClassplatformbrandinfoDelegate();
		ChAdtClassplatformbrandinfoListVO chAdtClassplatformbrandinfoListVO = new ChAdtClassplatformbrandinfoListVO();
		chAdtClassplatformbrandinfoListVO.set_ne_state("1");
		
		DataPackage dpp = chAdtClassplatformbrandinfoDelegate.doQuery(
				chAdtClassplatformbrandinfoListVO, user);
		
		ChAdtClassplatformtdinfoForm tform=(ChAdtClassplatformtdinfoForm)actionForm;
    	String region=tform.getRegion();
    	
    	if("999".equals(region))
    		tform.setCitycode(Short.parseShort("999"));
		else
			tform.setCitycode(Short.parseShort(user.getCityid()));
		
		request.setAttribute("CH_ADT_CLASSPLATFORMBRAND", dpp);
		return super.doNew(actionMapping, actionForm, request, response, user);
	}

	@Override
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChAdtClassplatformbrandinfoDelegate chAdtClassplatformbrandinfoDelegate = new ChAdtClassplatformbrandinfoDelegate();
		ChAdtClassplatformbrandinfoListVO chAdtClassplatformbrandinfoListVO = new ChAdtClassplatformbrandinfoListVO();
		chAdtClassplatformbrandinfoListVO.set_ne_state("1");
		DataPackage dpp = chAdtClassplatformbrandinfoDelegate.doQuery(
				chAdtClassplatformbrandinfoListVO, user);
		request.setAttribute("CH_ADT_CLASSPLATFORMBRAND", dpp);
		request.setAttribute("tdbrandid", ((ChAdtClassplatformtdinfoForm) actionForm).getTdbrandid());
		((ChAdtClassplatformtdinfoForm) actionForm).setCitycode(Short.parseShort(((ChAdtClassplatformtdinfoForm) actionForm).getRegion()));
		return super.doSave(actionMapping, actionForm, request, response, user);
	}
	
	
	
	
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		export.setFileName("类平台裸机终端合作机型");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("tdbrandid", "终端品牌ID");
		export.addOutputProperty("productid", "型号");
		export.addOutputProperty("comid", "BOSS商品ID");
		export.addOutputProperty("comid", "商品名称", export.CODE2NAME, "#COMSYSTEM");
		export.addOutputProperty("startdate", "合作期开始时间",CommonExportBean.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("enddate", "合作期结束时间",CommonExportBean.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("citycode", "地市标识", export.CODE2NAME, "#CITYIDNUM2NMAME");
		export.addOutputProperty("adtremark", "备注");
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
