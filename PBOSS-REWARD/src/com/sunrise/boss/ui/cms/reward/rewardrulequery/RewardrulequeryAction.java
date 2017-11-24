package com.sunrise.boss.ui.cms.reward.rewardrulequery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.rewardrulequery.persistent.RewardrulequeryVO;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: StdrewardbjAction
 * </p>
 * <p>
 * Description: 业务酬金规则查询
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author linli
 * @version 1.0 2008-07-21
 */
public class RewardrulequeryAction extends BaseDelegateAction {

	public RewardrulequeryAction() {
		setVoClass(RewardrulequeryVO.class);
		this.pkNameArray = new String[2];
		pkNameArray[0] = "rewardid";
		pkNameArray[0] = "regionid";
	}

	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return (actionMapping.findForward("list"));
	}
}
