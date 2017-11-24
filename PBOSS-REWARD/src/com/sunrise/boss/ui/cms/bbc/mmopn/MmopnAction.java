/**
 * auto-generated code
 * Mon Jan 04 14:36:52 CST 2010
 */
package com.sunrise.boss.ui.cms.bbc.mmopn;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.mmopn.persistent.MmopnListVO;
import com.sunrise.boss.business.cms.bbc.mmopn.persistent.MmopnVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.bbc.mmopn.MmopnDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: MmopnAction
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
 * @author Jerimyy
 * @version 1.0
 */
public class MmopnAction extends BaseDelegateAction {
	public MmopnAction() {
		setVoClass(MmopnVO.class);
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[1];
		pkNameArray[0] = "opnid";
	}

	/**
	 * 保存
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
			boolean isMusic=isMusic(request);
		try {
			MmopnVO contentVO = new MmopnVO();
			setSaveVO(contentVO, actionForm); // 在此格式化处理好 vo 以保存
			MmopnDelegate delegate = new MmopnDelegate();
			if(isMusic){
				delegate.doCreatemusic(contentVO, user);
			}else
			{
				delegate.doCreate(contentVO, user);
			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					"EDIT");
			if(isMusic)
			{
				return (actionMapping.findForward("contentmusic"));	
			}
			else
			{
				return (actionMapping.findForward("content"));	
			}
			
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		if(isMusic)
		{
			return (actionMapping.findForward("contentmusic"));	
		}
		else
		{
			return (actionMapping.findForward("content"));	
		}
		
	}

	/**            
	 * 导出为EXCEL格式。
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		boolean isMusic=isMusic(request);
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(isMusic){
			export.setFileName("无线音乐管理");
		}else
		{
			export.setFileName("MM业务管理");
		}
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("opnid", "业务编码");
		export.addOutputProperty("name", "业务名称");
		export.addOutputProperty("entid", "企业代码");
		export.addOutputProperty("busiid", "计费业务代码");
		if(!isMusic){
			export.addOutputProperty("acctype", "计酬方式",CommonExportBean.CODE2NAME,"$CH_ACCTYPE");
		}
		export.addOutputProperty("rewardstd", "酬金标准",CommonExportBean.NUMBER,"0.0000");
		export.addOutputProperty("state", "生效状态",CommonExportBean.CODE2NAME,"$CH_VALIDFLAG");
		if(!isMusic){
			export.addOutputProperty("ossrc", "加载平台",CommonExportBean.CODE2NAME,"$CH_MMOSSRC");
		}
		export.addOutputProperty("shortopn", "简码");
		export.addOutputProperty("wapurl", "WAP应用URL");
		export.addOutputProperty("memo", "业务简介");
		if(!isMusic){
			export.addOutputProperty("opnmon", "业务资费");
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super
				.doExcel(actionMapping, actionForm, request, response, user);
	}
	
	/**
	 * 删除
	 */
	public ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		MmopnDelegate delegate = new MmopnDelegate();
		for (int i = 0; i < selectArray.length; i++) {
			if (selectArray[0].indexOf('|') == -1) { // 单一主键
				MmopnVO vo=delegate.doFindByPk(getDeletePK(selectArray[i]), user);
				delegate.doRemove(vo, user);
			} 
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "处理成功");
		return doList(actionMapping, actionForm, request, response, user);
	}
	
	/**
	 * 查询
	 */
	public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		//MMOPN or  MUSIC
		boolean flag=isMusic(request);
		Page.setPageSize(request, (BaseActionForm) actionForm);
		Object listVO = getListVO();
		BaseActionForm baseForm = (BaseActionForm) actionForm;
		// BeanUtils.copyProperties(listVO, actionForm);
		
		setListVO(listVO, actionForm); // 设置好listVO，作Ordinary为查询条件
		MmopnListVO listParam=(MmopnListVO)listVO;
		//MMOPN 业务与 音乐业务业务编码范围不同
		if(flag)
		{
			listParam.set_snl_opnid("050200001");
			listParam.set_snm_opnid("050202000");
		}
		else
		{
			listParam.set_snl_opnid("050100001");
			listParam.set_snm_opnid("050109999");
		}
		CommonDelegate delegate = new CommonDelegate(voClass);
		boolean isDisplayCount = true;
		if (baseForm.get_displaycount() != null && (baseForm.get_displaycount().equalsIgnoreCase("no") || baseForm.get_displaycount().equalsIgnoreCase("false"))) {
			isDisplayCount = false;
		}
		DataPackage dp = delegate.doQuery(listVO, user, isDisplayCount);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		if(flag){
			return (actionMapping.findForward("listmusic"));
		}else
		{
			return (actionMapping.findForward("list"));
		}
	}
	/**
	 * 新建
	 */
	public ActionForward doNew(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		//MMOPN or  MUSIC
		
		// 新建时设置form的默认值
		setNewForm(actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		if(isMusic(request)){
			return (actionMapping.findForward("contentmusic"));
		}else
		{
		return (actionMapping.findForward("content"));
		}
	}

	/**
	 * 编辑
	 */
	public ActionForward doEdit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		getContentVO(request, user, actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		if(isMusic(request))
		{
			return (actionMapping.findForward("contentmusic"));
		}else
		{
			return (actionMapping.findForward("content"));
		}
	}
	private boolean isMusic(HttpServletRequest request) throws Exception{
		boolean isMusic=false;
		isMusic="TRUE".equals(request.getParameter("MUSIC"));
		return isMusic;
	}
}
