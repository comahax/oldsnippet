/**
* auto-generated code
* Thu Dec 24 16:13:49 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.zjtybusitosmp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.zjty.zjtybusitosmp.persistent.ZjtyBusitosmpVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ZjtyBusitosmpAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyBusitosmpAction extends BaseDelegateAction {
    public ZjtyBusitosmpAction() {
            setVoClass(ZjtyBusitosmpVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[3]; 
           pkNameArray[0] = "cityid"; 
           pkNameArray[1] = "comid"; 
           pkNameArray[2] = "opnid"; 
    }
    
    /**
     * 查询
     */
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ZjtyBusitosmpForm form = (ZjtyBusitosmpForm) actionForm;
//			if ("suite".equals(form.get_se_sort())) {
//				return doSuitelist(actionMapping, actionForm, request,
//						response, user);
//			} else if ("rechangeable".equals(form.get_se_sort())) {
//				return doRechangelist(actionMapping, actionForm, request,
//						response, user);
//			} else {
//				return doG3list(actionMapping, actionForm, request, response,
//						user);
//			}
			form.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
	    	request.setAttribute("cityid", form.get_se_cityid());
	    	return super.doList(actionMapping, actionForm, request, response, user);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("list"));
		}
	}

    /**
     * 新增
     */
    public ActionForward doNew(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	ZjtyBusitosmpForm form = (ZjtyBusitosmpForm) actionForm;
    	form.setSort(form.get_se_sort());
    	form.setCmdState(WebConstant.COMMAND_STRING_NEW);
//    	form.setCityid(SessionFactoryRouter.conversionCityid(user
//				.getCityid()));
    	request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user
				.getCityid()));
    	return (actionMapping.findForward("content"));
    }
    
    public ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	try {
			ZjtyBusitosmpForm form = (ZjtyBusitosmpForm) actionForm;
			form.setCityid(SessionFactoryRouter.conversionCityid(user
					.getCityid()));
			return super.doSave(actionMapping, actionForm, request, response,
					user);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("content"));
		}
    }
    
    /**
     * 套卡商品标识与计酬业务映射列表
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doSuitelist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ZjtyBusitosmpForm form = (ZjtyBusitosmpForm) actionForm;
			Page.setPageSize(request, form);
			form.set_se_sort("suite");
			form.set_se_cityid(SessionFactoryRouter.conversionCityid(user
					.getCityid()));
			request.setAttribute("cityid", form.get_se_cityid());
			return super.doList(actionMapping, actionForm, request, response,
					user);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("list"));
		}
	}
    
    /**
     * 充值卡商品标识与计酬业务映射列表
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doRechangelist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ZjtyBusitosmpForm form = (ZjtyBusitosmpForm) actionForm;
			Page.setPageSize(request, form);
			form.set_se_sort("rechangeable");
			form.set_se_cityid(SessionFactoryRouter.conversionCityid(user
					.getCityid()));
			request.setAttribute("cityid", form.get_se_cityid());
			return super.doList(actionMapping, actionForm, request, response,
					user);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("list"));
		}
	}
    	
    /**
     * G3商品标识与计酬业务映射列表
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doG3list(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ZjtyBusitosmpForm form = (ZjtyBusitosmpForm) actionForm;
			Page.setPageSize(request, form);
			form.set_se_sort("G3");
			form.set_se_cityid(SessionFactoryRouter.conversionCityid(user
					.getCityid()));
			request.setAttribute("cityid", form.get_se_cityid());
			return super.doList(actionMapping, actionForm, request, response,
					user);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("list"));
		}
	}
    
    /**
     * 套卡商品标识与计酬业务映射保存
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doSuitesave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ZjtyBusitosmpForm form = (ZjtyBusitosmpForm) actionForm;
			form.setBrand(new Byte("-1"));
			form.setComprice(new Long("-1"));
			form.setSort("suite");
			form.setCityid(SessionFactoryRouter.conversionCityid(user
					.getCityid()));
			form.set_se_sort("suite");
			return super.doSave(actionMapping, actionForm, request, response,
					user);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("content"));
		}
	}
    
    /**
     * 充值卡商品标识与计酬业务映射保存
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doRechangesave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ZjtyBusitosmpForm form = (ZjtyBusitosmpForm) actionForm;
			form.setBrand(new Byte("-1"));
			form.setComprice(new Long("-1"));
			form.setSort("rechangeable");
			form.setCityid(SessionFactoryRouter.conversionCityid(user
					.getCityid()));
			form.set_se_sort("rechangeable");
			return super.doSave(actionMapping, actionForm, request, response,
					user);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("content"));
		}
	}
    
    /**
     * G3商品标识与计酬业务映射保存
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doG3save(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	try {
			ZjtyBusitosmpForm form = (ZjtyBusitosmpForm) actionForm;
			form.setBrand(new Byte("-1"));
			form.setComprice(new Long("-1"));
			form.setSort("G3");
			form.setCityid(SessionFactoryRouter.conversionCityid(user
					.getCityid()));
			form.set_se_sort("G3");
			return super.doSave(actionMapping, actionForm, request, response,
					user);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("content"));
		}
    }
    
    
    public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("batch");
	}
}
