/**
 * auto-generated code
 * Fri Feb 01 18:16:01 CST 2008
 */
package com.sunrise.boss.ui.cms.reward.rewardconf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.business.cms.reward.rewardconf.persistent.RewardconfVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.reward.rewardconf.RewardconfDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;

/**
 * <p>
 * Title: RewardconfAction
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
public class RewardconfAction extends BaseDelegateAction {
	public RewardconfAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(RewardconfVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[3];
		pkNameArray[0] = "rewardmonth";
		pkNameArray[1] = "cityid";
		pkNameArray[2] = "rewardkind";
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RewardconfForm form = (RewardconfForm) actionForm;
		if (form.get_se_rewardkind().equals("AG")) {
			return doAglist(actionMapping, actionForm, request, response, user);
		} else {
			return doB2mlist(actionMapping, actionForm, request, response, user);
		}
	}

	/**
	 * 社会渠道酬金省级酬金列表
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doAglist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {

			RewardconfForm form = (RewardconfForm) actionForm;
			form.set_pagesize("21");
			if (StringUtils.isBlank(form.get_orderby())) {
				form.set_orderby("rewardmonth");
				form.set_desc("1");
			}
			if (form.get_se_rewardkind() == null) {
				form.set_se_rewardkind("AG");
			}

			request.setAttribute("flagAG", doCheckPermission(
					"CH_PW_REWARDCONF", user));
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return super.doList(actionMapping, actionForm, request, response, user);
	}

	/**
	 * B2M网站酬金省级酬金列表
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doB2mlist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RewardconfForm form = (RewardconfForm) actionForm;
		try {
			form.set_pagesize("21");
			if (StringUtils.isBlank(form.get_orderby())) {
				form.set_orderby("rewardmonth");
				form.set_desc("1");
			}
			if (StringUtils.isEmpty(form.getRewardb2mkind())) {
				List<String> list = new ArrayList<String>();
				list.add("B2M");
				list.add("UNPB");
				form.set_sin_rewardkind(list);
			}else{
				form.set_se_rewardkind(form.getRewardb2mkind());
			}
			
			request.setAttribute("flagB2M", doCheckPermission(
					"CH_B2M_REWARDCONF", user));
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		 super.doList(actionMapping, actionForm, request, response, user);
		 if (!StringUtils.isEmpty(form.getRewardb2mkind())) {
			 form.set_se_rewardkind(null);
		 }
		 return actionMapping.findForward("list");
	}

	/**
	 * 审核
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doAudit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RewardconfForm form = (RewardconfForm) actionForm;

		String[] selectArray = form.get_selectitem();
		if (selectArray != null) {
			try {
				RewardconfDelegate delegate = new RewardconfDelegate();
				int count = 1;
				for (int i = 0; i < selectArray.length; i++) {
					String[] strs = selectArray[i].split("\\|");
					RewardconfVO vo = new RewardconfVO();
					vo.setRewardmonth(strs[0]);
					vo.setCityid(strs[1]);
					vo.setRewardkind(strs[2]);
					vo.setBatchno(strs[3]);
					vo = delegate.doFindByPk(vo, user);
					// 后台工号权限校验
					if (doCheckPermission("CH_PW_REWARDCONF", user).equals(
							vo.getRewardkind())
							|| doCheckPermission("CH_B2M_REWARDCONF", user)
									.equals(vo.getRewardkind())||vo.getRewardkind().equals("UNPB")) {
						vo.setState(new Short("1"));
						vo.setOprcode(user.getOpercode());
						vo.setOprtime(new Date());
						delegate.doUpdate(vo, user);
						count = i + 1;
					} else {
						request.setAttribute(
								WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"操作失败，您没有权限操作该记录!");
						return super.doList(actionMapping, actionForm, request,
								response, user);
					}
				}
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"操作成功，共" + count + "条记录确认通过!");
				return doList(actionMapping, actionForm, request, response,
						user);
			} catch (Exception e) {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
						.getMessage());
			}
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "无记录可以确认!");
		return super.doList(actionMapping, actionForm, request, response, user);
	}

	/**
	 * 工号权限查询
	 * 
	 * @param permission
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public String doCheckPermission(String permission, User user)
			throws Exception {
		ProvincialrightVO vo = new ProvincialrightVO();
		vo.setProopr(user.getOpercode());
		vo.setRightid(permission);
		// 查找当前工号权限
		CommonDelegate delegate = new CommonDelegate(ProvincialrightVO.class);
		vo = (ProvincialrightVO) delegate.doFindByPk(vo, user);
		if (vo == null) {
			return "-1";
		} else {
			String str = vo.getRightid();
			// 社会渠道酬金省级酬金
			if (str.equals("CH_PW_REWARDCONF")) {
				return "AG";
				// B2M网站酬金省级酬金
			} else if (str.equals("CH_B2M_REWARDCONF")) {
				return "B2M";
				// 自建他营酬金省级酬金
			} else if (str.equals("CH_ZJTY_REWARDCONF")) {
				return "ZJTY";
			} else {
				return "-1";
			}
		}
	}
}
