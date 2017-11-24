/**
 * auto-generated code
 * Wed Apr 11 11:02:17 CST 2007
 */
package com.sunrise.boss.ui.cms.servcent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.servcent.persistent.ServcentListVO;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.servcent.ServcentDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: ServcentAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author Ye Daoe
 * @version 1.0
 */
public class ServcentAction extends BaseDelegateAction {
	public ServcentAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(ServcentVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "svccode";
	}

	/**
	 * 查询

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			ServcentListVO listvo = new ServcentListVO();
			setListVO(listvo, actionForm); // 设置好listVO，作为查询条件
			ServcentDelegate delegate = new ServcentDelegate();
			DataPackage pack = delegate.doQueryByOprcode(listvo, user);
			pack.setPageSize(20);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}
	 */
	protected ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean commonExportBean = new CommonExportBean(user);
		commonExportBean.setFileName("服务销售中心管理");
		commonExportBean.addOutputProperty("svccode", "服务销售中心编码");
		commonExportBean.addOutputProperty("countyid", "分公司编码");
		commonExportBean.addOutputProperty("svcname", "服务销售中心名称");
		commonExportBean.addOutputProperty("svctype", "服务销售中心类型",
				CommonExportBean.CODE2NAME, "$CH_SVCTYPE");
		commonExportBean.addOutputProperty("agent", "法人代表");
		commonExportBean.addOutputProperty("billingcode", "计费用行政区域代码");
		commonExportBean.addOutputProperty("adacode", "行政区划编码");
		commonExportBean.appendEndLine(new String[] { "导出工号:",
				user.getOpercode() });
		commonExportBean
				.appendEndLine(new String[] { "导出渠道:", user.getWayid() });

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT,
				commonExportBean);
		return super
				.doExcel(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ServcentVO servcentvo = new ServcentVO();
		setSaveVO(servcentvo, actionForm); // 在此格式化处理好 vo 以保存
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		ServcentDelegate delegate = new ServcentDelegate();
		String adacode = ((ServcentForm) actionForm).getAdacode();
		String orgcode = ((ServcentForm) actionForm).getSvccode();
		String confirmorgcode = delegate.doGetOrgcode(adacode, user);

		try {
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				delegate.doUpdate(servcentvo, user);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
				if (adacode != null &&!adacode.equals("")) {
					try {
						if ( delegate.doIfOrgcodenull(adacode, user)) {
							delegate.doUpdateOrgcode(adacode, orgcode, user);
						}
					} catch (BusinessException e) {
						if (e.getCode().equals("CMS-915")) {
							request.setAttribute("affirm", "false");
							request.setAttribute("adacode", adacode);
							request.setAttribute("confirmorgcode",
									confirmorgcode);
							((BaseActionForm) actionForm)
									.setCmdState(WebConstant.COMMAND_STRING_EDIT);
							return (actionMapping.findForward("content"));
						}
					}
				}
			} else {
				delegate.doCreate(servcentvo, user);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
				if (adacode != null &&!adacode.equals("")) {
					try {
						if ( delegate.doIfOrgcodenull(adacode, user)) {
							delegate.doUpdateOrgcode(adacode, orgcode, user);
						}
					} catch (BusinessException e) {
						if (e.getCode().equals("CMS-915")) {
							request.setAttribute("affirm", "false");
							request.setAttribute("adacode", adacode);
							request.setAttribute("confirmorgcode",
									confirmorgcode);
							((BaseActionForm) actionForm)
									.setCmdState(WebConstant.COMMAND_STRING_EDIT);
							return (actionMapping.findForward("content"));
						}
					}
				}
			}
			BeanUtils.copyProperties(actionForm, servcentvo); // 把更新后的值赋给form，用于web显示
			((BaseActionForm) actionForm)
					.setCmdState(WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("content"));
	}

	public ActionForward doChangeorg(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ServcentDelegate delegate = new ServcentDelegate();
		String adacode = ((ServcentForm) actionForm).getAdacode();
		String orgcode = ((ServcentForm) actionForm).getSvccode();
		delegate.doUpdateOrgcode(adacode, orgcode, user);
		return (actionMapping.findForward("content"));
	}
	
	/**
	 * 提供给需要选择用户的模块使用
	 */
	public ActionForward doShowdata(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ServcentForm form = (ServcentForm) actionForm;
		Page.setPageSize(request, form);

		ServcentListVO listVO = new ServcentListVO();
		setListVO(listVO, actionForm);
		String countyid = request.getParameter("countyid");
		if (!"".equals(countyid) && countyid != null) {
			listVO.set_se_countyid(countyid);
		}

		ServcentDelegate delegate = new ServcentDelegate();
		DataPackage dp = delegate.doQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("showdata"));
	}
}
