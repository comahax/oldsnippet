/**
 * auto-generated code
 * Thu Feb 12 10:06:59 CST 2009
 */
package com.sunrise.boss.ui.cms.wayhzwg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.wayhzwg.persistent.WayhzwgVO;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: WayhznxAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Li ZhaoLiang
 * @version 1.0
 */
public class WayhzwgAction extends BaseDelegateAction {
	public WayhzwgAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(WayhzwgVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[2];
		pkNameArray[0] = "wayid";
		pkNameArray[1] = "wgmonth";
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WayhzwgForm form = (WayhzwgForm) actionForm;
		//默认违规月份降序排序（违规月份最近的放顶列）。显示在列表中。
		if (StringUtils.isBlank(form.get_orderby())) {
			form.set_orderby("wgmonth");
			form.set_desc("1");
		}

		return super.doList(actionMapping, actionForm, request, response, user);
	}
}
