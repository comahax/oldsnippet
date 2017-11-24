/**
 * auto-generated code
 * Mon Feb 04 12:03:22 CST 2008
 */
package com.sunrise.boss.ui.cms.reward.rule2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.tool.hbm2ddl.SchemaExportTask;

import com.sunrise.boss.business.cms.reward.rule2.persistent.Rule2ListVO;
import com.sunrise.boss.business.cms.reward.rule2.persistent.Rule2VO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.reward.rule2.Rule2Delegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: Rule2Action
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
public class Rule2Action extends BaseDelegateAction {
	public Rule2Action() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(Rule2VO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[1];
		pkNameArray[0] = "ruleid";
	}
	
	/**
	 * �����ѯ
	 */
	public ActionForward doList(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Rule2Form form=(Rule2Form)actionForm;
		if(null==form.get_se_region()){
			form.set_se_region(user.getCityid());
		}
		Rule2ListVO listVO=new Rule2ListVO();
		this.setListVO(listVO, form);
		Rule2Delegate delegate=new Rule2Delegate();
		DataPackage dp=delegate.doQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return mapping.findForward("list");
	}
	
	
	/**
	 * ��Ч�Թ���ѡ��
	 */
	public ActionForward doSelectrule(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Rule2Form form = (Rule2Form) actionForm;
			Page.setPageSize(request, form);
			form.set_pagesize("10");
			String opnid = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
			if (null != opnid && opnid.trim().length() > 0) {
				form.set_se_opnid(opnid);
			}
			
			Rule2ListVO listVO = new Rule2ListVO();
			BeanUtils.copyProperties(listVO, form);
			Rule2Delegate delegate = new Rule2Delegate();
//			DataPackage dp = delegate.doQuery(listVO, user);
			DataPackage dp = delegate.getDistinctRule(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return mapping.findForward("selectrule");
	}
	
	
	/**
	 * BBC��Ч�Թ���ѡ��
	 */
	public ActionForward doSelectbbcrule(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Rule2Form form = (Rule2Form) actionForm;
			Page.setPageSize(request, form);
			form.set_pagesize("10");
			String opnid = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
			if (null != opnid && opnid.trim().length() > 0) {
				form.set_se_opnid(opnid);
			}
			
			Rule2ListVO listVO = new Rule2ListVO();
			BeanUtils.copyProperties(listVO, form);
			Rule2Delegate delegate = new Rule2Delegate();
			DataPackage dp = delegate.getDistinctBBCRule(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return mapping.findForward("selectbbcrule");
	}
	
	public ActionForward doSelectzjtyrule(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Rule2Form form = (Rule2Form) actionForm;
			Page.setPageSize(request, form);
			form.set_pagesize("10");
			String opnid = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
			if (null != opnid && opnid.trim().length() > 0) {
				form.set_se_opnid(opnid);
			}
			
			Rule2ListVO listVO = new Rule2ListVO();
			BeanUtils.copyProperties(listVO, form);
			Rule2Delegate delegate = new Rule2Delegate();
			DataPackage dp = delegate.getDistinctZjtyRule(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return mapping.findForward("selectzjtyrule");
	}
}
