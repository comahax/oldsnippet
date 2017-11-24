package com.sunrise.boss.ui.commons.multiselect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxanywhere.AAUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: MultiselectAction
 * </p>
 * <p>
 * Description: 多选弹出框
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: Sunrise Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @since 1.0
 * @version 1.0
 * @date 2008-08-28
 */
public class MultiselectAction extends Action {
	/** 请求参数 实现类名称 */
	private static final String DEFINITION = "DEFINITION";

	/** 请求参数 已存在字符串 */
	private static final String CODESTR = "CODESTR";

	/** 请求参数 分隔符号 */
	private static final String SPLITCHAR = "SPLITCHAR";

	/** 请求参数 可选集合 */
	private static final String COLLECTION_SOURCE = "COLLECTION_SOURCE";

	/** 请求参数 已选集合 */
	private static final String COLLECTION_EXIST = "COLLECTION_EXIST";

	/** 实现类的包路径 */
	private static final String PKGPATH = "com.sunrise.boss.ui.commons.multiselect.impl.";

	/** 默认分隔符号 逗号 */
	private static final String DEFAULT_SPLIT = ",";

	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String cmd = request.getParameter(WebConstant.PAGE_ATTRIBUTE_COMMAND);
		try {
			if (cmd.equalsIgnoreCase("show")) {
				return doShow(mapping, actionForm, request, response);
			} else if (cmd.equalsIgnoreCase("list")) {
				return doList(mapping, actionForm, request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
		}
		return (mapping.findForward("success"));
	}

	/**
	 * 初始化展现
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward doShow(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = (User) request.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			String definition = (String) request.getParameter(DEFINITION);
			Multiselect multiselect = (Multiselect) Class.forName(
					PKGPATH + definition).newInstance();

			String codeStr = (String) request.getParameter(CODESTR);
			codeStr = (codeStr == null) ? "" : codeStr.trim();

			String splitChar = (String) request.getParameter(SPLITCHAR);
			splitChar = (splitChar == null) ? DEFAULT_SPLIT : splitChar.trim();

			request.setAttribute(COLLECTION_SOURCE, multiselect
					.getInitSource(user));
			
			String[] codes = null;
			if (codeStr.length() > 0) {
				codes = codeStr.split(splitChar);
			}
			request.setAttribute(COLLECTION_EXIST, multiselect.getInitExist(
					codes, user));

			request.setAttribute(DEFINITION, definition);
			request.setAttribute(SPLITCHAR, splitChar);
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
		}
		return (mapping.findForward("success"));
	}

	/**
	 * 查询可选集合
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward doList(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = (User) request.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			String definition = (String) request.getParameter(DEFINITION);
			Multiselect multiselect = (Multiselect) Class.forName(
					PKGPATH + definition).newInstance();

			MultiselectForm form = (MultiselectForm) actionForm;
			String code = (form.getCode() == null) ? "" : form.getCode().trim();
			String name = (form.getName() == null) ? "" : form.getName().trim();
			if (code.length() == 0 && name.length() == 0) {
				request.setAttribute(COLLECTION_SOURCE, multiselect
						.getInitSource(user));
			} else {
				request.setAttribute(COLLECTION_SOURCE, multiselect
						.querySource(code, name, user));
			}
			if (AAUtils.isAjaxRequest(request)) {
				AAUtils.addZonesToRefresh(request, "zoneSource");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
		}
		return (mapping.findForward("success"));
	}
}
