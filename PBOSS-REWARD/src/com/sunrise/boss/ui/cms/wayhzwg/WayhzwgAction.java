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
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(WayhzwgVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[2];
		pkNameArray[0] = "wayid";
		pkNameArray[1] = "wgmonth";
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WayhzwgForm form = (WayhzwgForm) actionForm;
		//Ĭ��Υ���·ݽ�������Υ���·�����ķŶ��У�����ʾ���б��С�
		if (StringUtils.isBlank(form.get_orderby())) {
			form.set_orderby("wgmonth");
			form.set_desc("1");
		}

		return super.doList(actionMapping, actionForm, request, response, user);
	}
}
