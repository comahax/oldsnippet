/**
 * auto-generated code
 * Mon Sep 18 15:12:11 CST 2006
 */
package com.sunrise.boss.ui.cms.reward.rewardtotal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.business.cms.reward.rewardconf.persistent.RewardconfListVO;
import com.sunrise.boss.business.cms.reward.rewardconf.persistent.RewardconfVO;
import com.sunrise.boss.business.cms.reward.rewardtotal.persistent.RewardtotalListVO;
import com.sunrise.boss.business.cms.reward.rewardtotal.persistent.RewardtotalVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.reward.rewardconf.RewardconfDelegate;
import com.sunrise.boss.delegate.cms.reward.rewardtotal.RewardtotalDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: RtstockpileAction
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
 * @author gy
 * @version 1.0
 */
public class RewardtotalAction extends BaseDelegateAction {
	public RewardtotalAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(RewardtotalVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "totalid";
	}
	
	/**
	 * 增加对查询条件的"结算月"是否已出帐确认判断,所有ActionForword都要经过这个判断
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @单号 CR_AA200901091_551119 
	 */
	public boolean doCheckRewardMonth(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RewardtotalForm form = (RewardtotalForm) actionForm;
		
		if(StringUtils.isEmpty(form.get_se_chagmonth())){
			return true;
		}
		
		RewardconfListVO listvo = new RewardconfListVO();
		listvo.set_se_rewardkind("AG");
		listvo.set_se_rewardmonth(form.get_se_chagmonth().trim());
		listvo.set_se_cityid(user.getCityid());
		listvo.set_se_state("1");
		listvo.set_pagesize("0");
		RewardconfDelegate confdelegate = new RewardconfDelegate();
		DataPackage confDp = confdelegate.doQuery(listvo, user);
		if(confDp != null && confDp.getDatas().size() != 0){
			return true;
		}
		CommonDelegate delegate = new CommonDelegate(ProvincialrightVO.class);
		ProvincialrightVO rightvo = new ProvincialrightVO();
		rightvo.setProopr(user.getOpercode());
		rightvo.setRightid("CH_PW_REWARDCONF");
		rightvo = (ProvincialrightVO) delegate.doFindByPk(rightvo, user);
		if(rightvo == null){
			return false;
		}else{
			return true;
		}
	}

	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		if(!this.doCheckRewardMonth(actionMapping, actionForm, request, response, user)){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "当前变更月份酬金未出帐确认或非省级出帐确认操作工号，暂不能查询(导出)!");
			return actionMapping.findForward("list");
		}
		
		RewardtotalForm form = (RewardtotalForm) actionForm;
		Page.setPageSize(request, (BaseActionForm) actionForm);

		RewardtotalListVO listVO = new RewardtotalListVO();
		BeanUtils.copyProperties(listVO, form);

		RewardtotalDelegate delegate = new RewardtotalDelegate();
		DataPackage dp = delegate.doQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
	}

	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RewardtotalForm form = (RewardtotalForm) actionForm;
		form.set_ne_isbudget("1");
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		form.set_se_paymonth(format.format(this.getDefaultDate(-1)));
		form.set_se_chagmonth(format.format(this.getDefaultDate(-1)));
		return (actionMapping.findForward("list"));
	}

	public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		if(!this.doCheckRewardMonth(actionMapping, actionForm, request, response, user)){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "当前变更月份酬金未出帐确认或非省级出帐确认操作工号，暂不能查询(导出)!");
			return actionMapping.findForward("list");
		}
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("酬金计算结果总表查询");
		export.addOutputProperty("totalid");
		export.addOutputProperty("isbudget",CommonExportBean.CODE2NAME,"$CH_ISBUDGET");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayid",CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("slv", CommonExportBean.CODE2NAME,
				"$CH_STARLEVEL");
		export.addOutputProperty("rewardtype", CommonExportBean.CODE2NAME, "$CH_REWARDTYPE");
		export.addOutputProperty("chagmonth");
		export.addOutputProperty("paymonth");
		export.addOutputProperty("paymoney");
		export.addOutputProperty("rewardmonth1");
		export.addOutputProperty("rewardmoney1");
		export.addOutputProperty("rewardmonth2");
		export.addOutputProperty("rewardmoney2");
		export.addOutputProperty("rewardmonth3");
		export.addOutputProperty("rewardmoney3");
		export.addOutputProperty("paystat",CommonExportBean.CODE2NAME, "$CH_PPAYSTATE");
		export.voClassArray=new Class[]{RewardtotalVO.class};
		response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-control","public");
        response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
        String fn = "attachment; filename="+export.getFileName()+".txt";  
        response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"),
                                        "ISO-8859-1"));
        response.setContentType("text/plain");
        export.writeTxtTitle(response.getOutputStream(), new String[] { "酬金总表标识", "预估标志", "渠道标识", "渠道名称", "星级", "酬金类型",
				"变更月份", "发放月份", "酬金总额", "结算月份1", "结算金额1", "结算月份2", "结算金额2", "结算月份3",
				"结算金额3", "发放标志"});
		super.ExportQuery(actionMapping, actionForm, request, response, user, export);
		return actionMapping.findForward(null);
	}
	

//处理默认日期方法,正数为延后i个月,负数为提前i个月
	private	Date getDefaultDate(int i){
		Calendar c=Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		return c.getTime();
	}
}
