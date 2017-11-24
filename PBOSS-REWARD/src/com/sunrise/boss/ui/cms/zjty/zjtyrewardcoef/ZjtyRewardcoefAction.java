package com.sunrise.boss.ui.cms.zjty.zjtyrewardcoef;

/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.persistent.ZjtyRewardcoefVO;
import com.sunrise.boss.common.base.db.*;
import com.sunrise.boss.common.exception.business.BusinessException;

import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtyrewardcoef.ZjtyRewardcoefDelegate;

import com.sunrise.boss.ui.base.BaseDelegateAction;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: ZjtyRewardcoefAction
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
public class ZjtyRewardcoefAction extends BaseDelegateAction {

	public ZjtyRewardcoefAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(ZjtyRewardcoefVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[3];
		pkNameArray[0] = "coefid";
		pkNameArray[1] = "wayid";
		pkNameArray[2] = "effectiblemonth";
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyRewardcoefForm form = (ZjtyRewardcoefForm) actionForm;
		if (form.get_se_cityid() == null) {
			form.set_se_cityid(user.getCityid());
		}
		super.doList(actionMapping, actionForm, request, response, user);
		DataPackage dp = (DataPackage) request
				.getAttribute(WebConstant.PAGE_ATTRIBUTE_LIST);
		request.getSession().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return actionMapping.findForward("list");
	}

	public ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		DataPackage dp = (DataPackage) request.getSession().getAttribute(
				WebConstant.PAGE_ATTRIBUTE_LIST);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String[] selectArray = ((ZjtyRewardcoefForm) actionForm)
				.get_selectitem();
		for (int i = 0; i < selectArray.length; i++) {
			String[] str = selectArray[i].split("\\|");
			String effectiblemont = format.format(ZjtyRewardcoefAction
					.getDefaultDate(-1));
			if (Integer.parseInt(str[2]) < Integer.parseInt(effectiblemont)) {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
						WebConstant.COMMAND_STRING_EDIT);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"不允许删除历史作用月为[" + effectiblemont + "]之前的记录");
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
				request.getSession().setAttribute(
						WebConstant.PAGE_ATTRIBUTE_LIST, dp);
				return actionMapping.findForward("list");
			}
		}
		return super.doDelete(actionMapping, actionForm, request, response,
				user);
	}
	
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyRewardcoefForm form = (ZjtyRewardcoefForm) actionForm;
		ZjtyRewardcoefVO contentVO = new ZjtyRewardcoefVO();
		setSaveVO(contentVO, actionForm); // 在此格式化处理好 vo 以保存
		WayListVO waylistvo = new WayListVO();
		WayDelegate wayDelegate = new WayDelegate();
		DataPackage dp;

//		String effectiblemont = format.format(ZjtyRewardcoefAction
//				.getDefaultDate(-1));
//		String userinput = form.getEffectiblemonth();
//
//		if (Integer.parseInt(userinput) < Integer.parseInt(effectiblemont)) {
//			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
//					WebConstant.COMMAND_STRING_EDIT);
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//					"不允许录入或修改历史作用月记录!");
//			return actionMapping.findForward("content");
//		}

		if (null != contentVO.getWayid() && !"".equals(contentVO.getWayid())) {
			if (!wayDelegate.isWayExist(contentVO.getWayid(), user)) {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
						WebConstant.COMMAND_STRING_EDIT);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"保存失败,渠道代码不存在");
				return (actionMapping.findForward("content"));
			}
		}
		waylistvo.set_se_wayid(form.getWayid());
		waylistvo.set_se_waytype("AG");
		
		dp = wayDelegate.doQuery(waylistvo, user);
		if (dp.getDatas().size() <= 0) {
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"保存失败,该渠道不是自建设他营的渠道!");
			return (actionMapping.findForward("content"));
		}

		ZjtyRewardcoefDelegate delegate = new ZjtyRewardcoefDelegate();
		ZjtyRewardcoefVO tmpvo = delegate.doFindByPk(contentVO, user);
		if (tmpvo == null) {
			WayVO vo = new WayVO();
			vo.setWayid(contentVO.getWayid());
			WayDelegate waydelegate = new WayDelegate();
			vo = waydelegate.doFindByPk(vo.getWayid(), user);
			if (vo == null) {
				throw new BusinessException("", "该记录已经存在");
			}
			form.setCityid(SessionFactoryRouter.conversionCityid2Num(vo
					.getCityid()));
		}
		form.setIspass(new Short("1"));
		return super.doSave(actionMapping, actionForm, request, response, user);
	}

	private static Date getDefaultDate(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		return c.getTime();
	}

	public ActionForward doAudit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyRewardcoefForm form = (ZjtyRewardcoefForm) actionForm;

		String[] selectArray = form.get_selectitem();
		if (selectArray != null) {
			String auditopr = request.getParameter("ISPASS");
			try {
				ZjtyRewardcoefDelegate delegate = new ZjtyRewardcoefDelegate();
				for (int i = 0; i < selectArray.length; i++) {
					String[] strs = selectArray[i].split("\\|");
					ZjtyRewardcoefVO vo = new ZjtyRewardcoefVO();
					vo.setCoefid(new Short(strs[0]));
					vo.setWayid(strs[1]);
					vo.setEffectiblemonth(strs[2]);
					vo = delegate.doFindByPk(vo, user);
					vo.setIspass(new Short(auditopr));
					delegate.doUpdate(vo, user);
				}
			} catch (Exception e) {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
						.getMessage());
			}
		} else {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "请至少勾选一行");
		}
		return doList(actionMapping, actionForm, request, response, user);
	}
}
