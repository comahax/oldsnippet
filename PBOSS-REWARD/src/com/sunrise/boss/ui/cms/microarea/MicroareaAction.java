/**
 * auto-generated code
 * Wed Apr 11 10:59:58 CST 2007
 */
package com.sunrise.boss.ui.cms.microarea;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.microarea.persistent.MicroareaListVO;
import com.sunrise.boss.business.cms.microarea.persistent.MicroareaVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.microarea.MicroareaDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: MicroareaAction
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
public class MicroareaAction extends BaseDelegateAction {
	public MicroareaAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(MicroareaVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "macode";
	}

	/**
	 * 查询
	 
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			MicroareaListVO listvo = new MicroareaListVO();
			setListVO(listvo, actionForm); // 设置好listVO，作为查询条件
			MicroareaDelegate delegate = new MicroareaDelegate();
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
		commonExportBean.setFileName("微区域管理");
		commonExportBean.addOutputProperty("macode", "微区域编码");
		commonExportBean.addOutputProperty("svccode", "服务销售中心编码");
		commonExportBean.addOutputProperty("maname", "微区域名称");
		commonExportBean.addOutputProperty("matype", "微区域类型",
				CommonExportBean.CODE2NAME, "$CH_MATYPE");
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
		MicroareaVO microareavo = new MicroareaVO();
		setSaveVO(microareavo, actionForm); // 在此格式化处理好 vo 以保存
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		MicroareaDelegate delegate = new MicroareaDelegate();
		String adacode = ((MicroareaForm) actionForm).getAdacode();
		String orgcode = ((MicroareaForm) actionForm).getMacode();
		String confirmorgcode = delegate.doGetOrgcode(adacode, user);

		try {
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				delegate.doUpdate(microareavo, user);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
				if (adacode != null && !adacode.equals("")) {
					try {
						if (delegate.doIfOrgcodenull(adacode, user)) {
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
				delegate.doCreate(microareavo, user);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
				if (adacode != null && !adacode.equals("")) {
					try {
						if (delegate.doIfOrgcodenull(adacode, user)) {
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
			BeanUtils.copyProperties(actionForm, microareavo); // 把更新后的值赋给form，用于web显示
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
		MicroareaDelegate delegate = new MicroareaDelegate();
		String adacode = ((MicroareaForm) actionForm).getAdacode();
		String orgcode = ((MicroareaForm) actionForm).getMacode();
		delegate.doUpdateOrgcode(adacode, orgcode, user);
		return (actionMapping.findForward("content"));
	}
}
