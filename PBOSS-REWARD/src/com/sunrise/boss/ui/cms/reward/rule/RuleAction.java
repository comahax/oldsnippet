/**
 * auto-generated code
 * Sun Feb 03 10:15:39 CST 2008
 */
package com.sunrise.boss.ui.cms.reward.rule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.rule.persistent.RuleVO;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: RuleAction
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
public class RuleAction extends BaseDelegateAction {
	public RuleAction() {
		setVoClass(RuleVO.class);
		this.pkNameArray = new String[1];
		pkNameArray[0] = "ruleid";
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RuleForm form = (RuleForm) actionForm;
		form.set_se_ruletype("AG");
		if (StringUtils.isBlank(form.get_orderby())) {
			form.set_orderby("ruleid");
			// form.set_desc("1");
		}
		return super.doList(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		RuleForm form = (RuleForm) actionForm;
		Calendar cal=Calendar.getInstance();
		cal.setTime(form.getEnddate());
		cal.set(Calendar.HOUR_OF_DAY,23);
		cal.set(Calendar.MINUTE,59);
		cal.set(Calendar.SECOND,59);
		//String endDate =(form.getEnddate().toLocaleString()).replaceAll("0:00:00", "23:59:59");
		form.setEnddate(cal.getTime());
		form.setRuletype("AG");
		return super.doSave(actionMapping, actionForm, request, response, user);
	}

}
