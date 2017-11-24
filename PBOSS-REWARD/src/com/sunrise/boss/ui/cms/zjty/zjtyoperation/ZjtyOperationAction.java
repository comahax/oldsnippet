package com.sunrise.boss.ui.cms.zjty.zjtyoperation;

/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent.ZjtyOperationListVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent.ZjtyOperationVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.CacheSinglton;
import com.sunrise.boss.delegate.cms.zjty.zjtyoperation.ZjtyOperationDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: ZjtyOperationAction
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
 * @author
 * @version 1.0
 */
public class ZjtyOperationAction extends BaseDelegateAction {

	private static final Log log = LogFactory.getLog(ZjtyOperationAction.class);

	
	public ZjtyOperationAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(ZjtyOperationVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "opnid";
	}
	
	public ActionForward doSelect(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyOperationForm form=(ZjtyOperationForm)actionForm;
		try{
			Page.setPageSize(request, form);
			ZjtyOperationListVO listvo=new ZjtyOperationListVO();
			setListVO(listvo, form); // 设置好listVO，作为查询条件
			listvo.set_ne_isbusi("0");
			CommonDelegate delegate=new CommonDelegate(ZjtyOperationVO.class);
			DataPackage dp=delegate.doQuery(listvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}catch(Exception e){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("select"));
	}
	
	
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyOperationForm form=(ZjtyOperationForm)actionForm;
		Page.setPageSize(request, form);
		try{
			ZjtyOperationListVO listVO = new ZjtyOperationListVO();
			setListVO(listVO, form); // 设置好listVO，作为查询条件
			listVO.set_ne_isbusi("1");
			ZjtyOperationDelegate delegate = new ZjtyOperationDelegate();
			DataPackage dp = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}
		return actionMapping.findForward("list");
	}
	
	public ActionForward doSelectopntree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ZjtyOperationDelegate delegate = new ZjtyOperationDelegate();
			String contextPath = request.getContextPath();
			ZjtyOperationForm form = (ZjtyOperationForm) actionForm;
			String showtext = "";
			String style = request.getParameter("style") == null ? "" : request
					.getParameter("style");
			String opnid = "0";
			String topChildrenURI = "selectOperationXml.jsp";
			String rootName = null;
			String topAction = "";
			String topChildrenURL = null;
			String rootAdaId = null;
			StringBuffer topChildrenURLBuffer = new StringBuffer(100);
			String city = request.getParameter("city") == null ? "" : request
					.getParameter("city");// 根节点
			
			if(!StringUtils.isEmpty(city) && !"all".equals(city)){
				Cache cache = CacheSinglton.getInstance().getCache();
				Element element=new Element(user.getOpercode(),(java.io.Serializable)delegate.doQuery(new ZjtyOperationListVO(), user));
				cache.put(element);
			}else{
				Cache cache = CacheSinglton.getInstance().getCache();
				cache.remove(user.getOpercode());
			}
			
			if (StringUtils.isEmpty(opnid)) {
				throw new BusinessException("", "当前工号所在的地市不存在");
			}

			if ("0".equals(opnid)) {
				rootName = "业务类型";
				rootAdaId = "0";
			} else {
				ZjtyOperationVO zjtyoperationVO = delegate.doFindByPk(opnid, user);
				if (zjtyoperationVO == null) {
					throw new BusinessException("", "不存在业务类型");
				}
				rootName = zjtyoperationVO.getName();
				rootAdaId = zjtyoperationVO.getOpnid().toString();
			}
			topChildrenURLBuffer.append(contextPath).append("/cms/zjty/zjtyoperation/")
					.append(topChildrenURI).append("?parentid=").append(
							rootAdaId).append("&parenttype=operation").append(
							"&function=selectOpn&childrenURL=").append(
							contextPath).append("/cms/zjty/zjtyoperation/").append(
							topChildrenURI).append("&opntype=").append(style)
					//.append("&city=").append(city)
					.append("&showdisable=").append(form.isShowendopn())
					.append("&times=").append((new Date()).getTime());
			request.getSession().setAttribute("_sk_name",
					form.get_sk_name() == null ? "" : form.get_sk_name());
			request.getSession().setAttribute("_ne_opnid",
					form.get_se_opnid() == null ? "" : form.get_se_opnid());

			if (!"0".equals(rootAdaId)) {
				topAction = "\"javascript:selectOpn('" + rootAdaId + "','"
						+ showtext + "' , 'opn') \"";
			} else {
				topAction = rootAdaId == null ? "" : "\"javascript:void(0) \"";
				showtext = "请选择业务类型";
			}
			topChildrenURL = rootAdaId != null ? topChildrenURLBuffer
					.toString() : "";
			request.setAttribute("text", showtext);
			request.setAttribute("rootAdaId", rootAdaId);
			request.setAttribute("parentType", "operation");
			request.setAttribute("rootName", rootName);
			request.setAttribute("topChildrenURL", topChildrenURL);
			request.setAttribute("topAction", topAction);
		} catch (Exception e) {
			log.error(e);
			request.setAttribute("rootAdaId", null);
			if (e instanceof BusinessException) {
				request.setAttribute("text", ((BusinessException) e)
						.getMessage());
			}
		}
		return actionMapping.findForward("selectopntree");
	}

	
	
}
