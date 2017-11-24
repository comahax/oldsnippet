/**
 * auto-generated code
 * Fri Apr 18 17:02:15 CST 2008
 */
package com.sunrise.boss.ui.cms.reward.ruleonbusi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.ruleonbusi.persistent.RuleonbusiListVO;
import com.sunrise.boss.business.cms.reward.ruleonbusi.persistent.RuleonbusiVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.reward.ruleonbusi.RuleonbusiDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: RuleonbusiAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @version 1.0
 */
public class RuleonbusiAction extends BaseDelegateAction {
	public RuleonbusiAction() {
		setVoClass(RuleonbusiVO.class);
		this.pkNameArray = new String[2];
		pkNameArray[0] = "opnid";
		pkNameArray[1] = "ruleid";
	}
	
	/**
	 * 适用业务设置查询
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String ruleid = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_KEY);
			RuleonbusiForm form = (RuleonbusiForm) actionForm;
			if (null != ruleid && ruleid.trim().length() > 0) {
				form.set_se_ruleid(ruleid);
			}
			
			RuleonbusiDelegate busiDelegate = new RuleonbusiDelegate();
			RuleonbusiListVO busiListVO = new RuleonbusiListVO();
			BeanUtils.copyProperties(busiListVO, form);
			DataPackage pack = busiDelegate.doQuery(busiListVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return actionMapping.findForward("list");
	}
	
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String ruleid = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_KEY);
			RuleonbusiForm form = (RuleonbusiForm) actionForm;
			if (null != ruleid && ruleid.trim().length() > 0) {
				form.set_se_ruleid(ruleid);
			}
			
			RuleonbusiDelegate busiDelegate = new RuleonbusiDelegate();
			RuleonbusiListVO busiListVO = new RuleonbusiListVO();
			BeanUtils.copyProperties(busiListVO, form);
			DataPackage pack = busiDelegate.doQuery1(busiListVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return actionMapping.findForward("list");
	}
}
