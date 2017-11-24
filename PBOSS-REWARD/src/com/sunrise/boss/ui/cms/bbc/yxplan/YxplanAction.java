/**
 * auto-generated code
 * Tue May 05 11:03:52 CST 2009
 */
package com.sunrise.boss.ui.cms.bbc.yxplan;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.yxplan.persistent.YxplanListVO;
import com.sunrise.boss.business.cms.bbc.yxplan.persistent.YxplanVO;
import com.sunrise.boss.delegate.cms.bbc.yxplan.YxplanDelegate;

/**
 * <p>
 * Title: YxplanAction
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
 * @author Jerimy
 * @version 1.0
 */
public class YxplanAction extends BaseDelegateAction {
	public YxplanAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(YxplanVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[2];
		pkNameArray[0] = "opnid";
		pkNameArray[1] = "yxplanid";
	}

	/**
	 * 查看信息
	 */
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return (actionMapping.findForward("list"));
	}
}
