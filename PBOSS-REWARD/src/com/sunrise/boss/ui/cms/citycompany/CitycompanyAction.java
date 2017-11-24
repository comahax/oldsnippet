/**
 * auto-generated code
 * Fri Aug 25 11:23:52 CST 2006
 */
package com.sunrise.boss.ui.cms.citycompany;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyListVO;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.citycompany.CitycompanyDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: CitycompanyAction
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
 * @author yjr
 * @version 1.0
 */
public class CitycompanyAction extends BaseDelegateAction {
	public CitycompanyAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(CitycompanyVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "citycompid";
	}

	public void onDuplicatePk(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) {
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
				"相同编码的市公司已经存在, 请输入其他编码");
	}

	/**
	 * 查询
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			CitycompanyListVO listvo = new CitycompanyListVO();
			setListVO(listvo, actionForm); // 设置好listVO，作为查询条件
			CitycompanyDelegate delegate = new CitycompanyDelegate();
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

	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CitycompanyVO citycompanyvo = new CitycompanyVO();
		setSaveVO(citycompanyvo, actionForm); // 在此格式化处理好 vo 以保存
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		CitycompanyDelegate delegate = new CitycompanyDelegate();
		String adacode = ((CitycompanyForm) actionForm).getAdacode();
		String orgcode = ((CitycompanyForm) actionForm).getCitycompid();
		String confirmorgcode = delegate.doGetOrgcode(adacode, user);

		try {
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				delegate.doUpdate(citycompanyvo, user);
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
				delegate.doCreate(citycompanyvo, user);
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
			BeanUtils.copyProperties(actionForm, citycompanyvo); // 把更新后的值赋给form，用于web显示
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
		CitycompanyDelegate delegate = new CitycompanyDelegate();
		String adacode = ((CitycompanyForm) actionForm).getAdacode();
		String orgcode = ((CitycompanyForm) actionForm).getCitycompid();
		delegate.doUpdateOrgcode(adacode, orgcode, user);
		return (actionMapping.findForward("content"));
	}
}
