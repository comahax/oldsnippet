/**
 * auto-generated code
 * Fri Apr 09 12:40:50 CST 2010
 */
package com.sunrise.boss.ui.cms.reward.terminalsucc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.business.cms.reward.terminalsucc.persistent.TerminalsuccComVO;
import com.sunrise.boss.business.cms.reward.terminalsucc.persistent.TerminalsuccListVO;
import com.sunrise.boss.business.cms.reward.terminalsucc.persistent.TerminalsuccVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.reward.terminalsucc.TerminalsuccDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: TerminalsuccAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author LiZhaoLiang
 * @version 1.0
 */
public class TerminalsuccAction extends BaseAction {
	
	private CommonDelegate delegate;
	
	public TerminalsuccAction() throws Exception {
		setVoClass(TerminalsuccVO.class);
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[1];
		pkNameArray[0] = "seq";
		delegate = new CommonDelegate(ProvincialrightVO.class);
	}

	private static Date getDefaultDate(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		return c.getTime();
	}

	/**
	 * 设置终端可结算销量查询为当前结算月, 地市为当前登陆工号的地市
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
			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
			TerminalsuccForm form = (TerminalsuccForm) actionForm;
			String calcmonth = format.format(TerminalsuccAction
					.getDefaultDate(-1));
			form.set_se_calcmonth(calcmonth);
			form.set_se_cityid(user.getCityid());
			return doList(actionMapping, form, request, response, user);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("list"));
		}
	}

	/**
	 * 终端可结算销量查询
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			TerminalsuccForm form = (TerminalsuccForm) actionForm;
			Page.setPageSize(request, form);
			TerminalsuccDelegate delegate = new TerminalsuccDelegate();
			TerminalsuccListVO listvo = new TerminalsuccListVO();
			if(!this.doCheckRewardRight(actionMapping, actionForm, request, response, user)){
				form.set_se_cityid(user.getCityid());
			}
			this.setListVO(listvo, form);
			listvo.set_orderby("comid");
			//后台多表联合查询 DAO
			DataPackage dp = delegate.doQuery(listvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			e.printStackTrace();
		}
		return (actionMapping.findForward("list"));
	}

	/**
	 * 终端可结算销量查询文本导出
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			export.setFileName("终端可结算销量导出");
			export.addOutputProperty("cityid");
			export.addOutputProperty("comid");
			export.addOutputProperty("opnid");
			export.addOutputProperty("opnid", CommonExportBean.CODE2NAME,
					"#OPERATION");
			export.addOutputProperty("wayid");
			export.addOutputProperty("wayid", CommonExportBean.CODE2NAME,
					"#WAY");
			export.addOutputProperty("calcmonth");
			export.addOutputProperty("busivalue");
			export.voClassArray = new Class[] { TerminalsuccComVO.class };
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
			String fn = "attachment; filename=" + export.getFileName() + ".txt";
			response.setHeader("Content-Disposition", new String(fn
					.getBytes("GBK"), "ISO-8859-1"));
			response.setContentType("text/plain");
			export.writeTxtTitle(response.getOutputStream(), new String[] {
					"地市编码", "商品标识", "业务编码", "业务名称", "业务发生渠道", "业务发生渠道名称",
					"结算月份", "业务量", });
			super.ExportQuery(actionMapping, actionForm, request, response,
					user, export);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward(null);
	}
	
	public boolean doCheckRewardRight(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ProvincialrightVO rewardrightvo = new ProvincialrightVO();
		ProvincialrightVO rewardprovincalrightvo = new ProvincialrightVO();
		rewardrightvo.setProopr(user.getOpercode());
		rewardrightvo.setRightid("CH_PW_REWARD");
		rewardrightvo = (ProvincialrightVO) delegate.doFindByPk(rewardrightvo,
				user);
		rewardprovincalrightvo.setProopr(user.getOpercode());
		rewardprovincalrightvo.setRightid("CH_PW_REWARD_PROVINCIAL");
		rewardprovincalrightvo = (ProvincialrightVO) delegate.doFindByPk(
				rewardprovincalrightvo, user);

		if (rewardrightvo == null && rewardprovincalrightvo == null) {
			return false;
		} else {
			return true;
		}
	}
}
