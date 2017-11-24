/**
 * auto-generated code Tue Oct 24 17:27:56 CST 2006
 */
package com.sunrise.boss.ui.cms.employeelog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.employeelog.persistent.EmployeelogListVO;
import com.sunrise.boss.business.cms.employeelog.persistent.EmployeelogVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.employeelog.EmployeelogDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: EmployeelogAction
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
 * @author He Kun
 * @version 1.0
 */
public class EmployeelogAction extends BaseDelegateAction {
	public EmployeelogAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(EmployeelogVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "logid";
	}

	protected void setListVO(Object listVO, final ActionForm listForm) {
		try {
			BeanUtils.copyProperties(listVO, listForm);
			String _desc = ((BaseActionForm) listForm).get_desc();
			String _orderby = ((BaseActionForm) listForm).get_orderby();
			if ("".equals(_desc) && "".equals(_orderby) || _desc == null
					&& _orderby == null) {
				((EmployeelogListVO) listVO).set_desc("1");
				((EmployeelogListVO) listVO).set_orderby("logid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ActionForward doServerhallshow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("serverhalllist");
	}

	public ActionForward doDitchmgrshow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("ditchmgrlist");
	}

	public ActionForward doSocietyshow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("societylist");
	}

	public ActionForward doSocietylist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		EmployeelogListVO listVO = new EmployeelogListVO();
		setListVO(listVO, actionForm);
		listVO.set_se_waytype("AG");// 普通代理渠道,即社会渠道
		String sql = " wayid in (select wayid from ch_pw_way start with wayid='"
				+ user.getWayid()
				+ "' connect by prior   wayid   = upperwayid) "; // 数据权限限制

		listVO.set_sql_waycondition(sql);

		EmployeelogDelegate delegate = new EmployeelogDelegate();
		if("".equals(listVO.get_pagesize()) || null==listVO.get_pagesize())
		{
			listVO.set_pagesize("20");
		}
		if("".equals(listVO.get_pageno()) || null==listVO.get_pageno())
		{
			listVO.set_pageno("1");
		}
		BeanUtils.copyProperties(actionForm,listVO);
		DataPackage pack = delegate.doSocietyEmployeeLogQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);

		return actionMapping.findForward("societylist");
	}

	public ActionForward doServerhalllist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		EmployeelogListVO listVO = new EmployeelogListVO();
		setListVO(listVO, actionForm);

		EmployeelogDelegate delegate = new EmployeelogDelegate();
		DataPackage pack = delegate.doServerhallEmployeeLogQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);

		return actionMapping.findForward("serverhalllist");
	}

	public ActionForward doDitchmgrlist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		EmployeelogListVO listVO = new EmployeelogListVO();
		setListVO(listVO, actionForm);

		EmployeelogDelegate delegate = new EmployeelogDelegate();
		DataPackage pack = delegate.doDitchmgrEmployeeLogQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);

		return actionMapping.findForward("ditchmgrlist");
	}
}
