/**
 * auto-generated code
 * Tue Jan 05 15:32:41 CST 2010
 */
package com.sunrise.boss.ui.cms.zjty.zjtydataquery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.zjty.zjtydataquery.persistent.ZjtyDataqueryListVO;
import com.sunrise.boss.business.cms.zjty.zjtydataquery.persistent.ZjtyDataqueryVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.zjty.zjtydataquery.ZjtyDataqueryDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ZjtyDataqueryAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyDataqueryAction extends BaseAction {
	public ZjtyDataqueryAction() {
		setVoClass(ZjtyDataqueryVO.class);
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[1];
		pkNameArray[0] = "seq";
	}

	/**
	 * 服务业务数据校验有效结果列表
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doBosssucc(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			ZjtyDataqueryForm form = (ZjtyDataqueryForm) actionForm;
			ZjtyDataqueryDelegate bosssuccdelegate = new ZjtyDataqueryDelegate();
			ZjtyDataqueryListVO params = new ZjtyDataqueryListVO();
			this.setListVO(params, form);
			DataPackage dp = bosssuccdelegate.doQueryBosssucc(params, user);
			request.setAttribute(WebConstant.COMMAND_STRING_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("bosssucclist");
	}

	/**
	 * 服务业务数据校验无效结果列表
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doBossfail(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			ZjtyDataqueryForm form = (ZjtyDataqueryForm) actionForm;
			ZjtyDataqueryDelegate bossfaildelegate = new ZjtyDataqueryDelegate();
			ZjtyDataqueryListVO params = new ZjtyDataqueryListVO();
			this.setListVO(params, form);
			DataPackage dp = bossfaildelegate.doQueryBossfail(params, user);
			request.setAttribute(WebConstant.COMMAND_STRING_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("bossfaillist");
	}

	/**
	 * 服务业务奖励酬金校验成功列表
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doBossjlsucc(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			ZjtyDataqueryForm form = (ZjtyDataqueryForm) actionForm;
			ZjtyDataqueryDelegate bossjlsuccdelegate = new ZjtyDataqueryDelegate();
			ZjtyDataqueryListVO params = new ZjtyDataqueryListVO();
			this.setListVO(params, form);
			DataPackage dp = bossjlsuccdelegate.doQueryBossjlsucc(params, user);
			request.setAttribute(WebConstant.COMMAND_STRING_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("bossjlsucclist");
	}

	/**
	 * 服务业务奖励酬金校验失败列表
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doBossjlfail(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			ZjtyDataqueryForm form = (ZjtyDataqueryForm) actionForm;
			ZjtyDataqueryDelegate bossjlfaildelegate = new ZjtyDataqueryDelegate();
			ZjtyDataqueryListVO params = new ZjtyDataqueryListVO();
			this.setListVO(params, form);
			DataPackage dp = bossjlfaildelegate.doQueryBossjlfail(params, user);
			request.setAttribute(WebConstant.COMMAND_STRING_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("bossjlfaillist");
	}

	/**
	 * 标准卡类销售数据校验有效结果列表
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSalesucc(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			ZjtyDataqueryForm form = (ZjtyDataqueryForm) actionForm;
			ZjtyDataqueryDelegate salesuccdelegate = new ZjtyDataqueryDelegate();
			ZjtyDataqueryListVO params = new ZjtyDataqueryListVO();
			this.setListVO(params, form);
			DataPackage dp = salesuccdelegate.doQuerySalesucc(params, user);
			request.setAttribute(WebConstant.COMMAND_STRING_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("salesucclist");
	}

	/**
	 * 标准卡类销售数据校验无效结果列表
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSalefail(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			ZjtyDataqueryForm form = (ZjtyDataqueryForm) actionForm;
			ZjtyDataqueryDelegate salefaildelegate = new ZjtyDataqueryDelegate();
			ZjtyDataqueryListVO params = new ZjtyDataqueryListVO();
			this.setListVO(params, form);
			DataPackage dp = salefaildelegate.doQuerySalefail(params, user);
			request.setAttribute(WebConstant.COMMAND_STRING_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("salefaillist");
	}

	/**
	 * 定制终端销售数据校验有效结果列表
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doTmnalsucc(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			ZjtyDataqueryForm form = (ZjtyDataqueryForm) actionForm;
			ZjtyDataqueryDelegate tmnalsuccdelegate = new ZjtyDataqueryDelegate();
			ZjtyDataqueryListVO params = new ZjtyDataqueryListVO();
			this.setListVO(params, form);
			DataPackage dp = tmnalsuccdelegate.doQueryTmnalsucc(params, user);
			request.setAttribute(WebConstant.COMMAND_STRING_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("tmnalsucclist");
	}

	/**
	 * 定制终端销售数据校验无效结果列表
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doTmnalfail(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			ZjtyDataqueryForm form = (ZjtyDataqueryForm) actionForm;
			ZjtyDataqueryDelegate tmnalfaildelegate = new ZjtyDataqueryDelegate();
			ZjtyDataqueryListVO params = new ZjtyDataqueryListVO();
			this.setListVO(params, form);
			DataPackage dp = tmnalfaildelegate.doQueryTmnalfail(params, user);
			request.setAttribute(WebConstant.COMMAND_STRING_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("tmnalfaillist");
	}
}
