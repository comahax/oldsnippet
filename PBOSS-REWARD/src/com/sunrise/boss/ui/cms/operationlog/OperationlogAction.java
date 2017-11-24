/**
 * auto-generated code
 * Wed Jan 17 07:46:46 CST 2007
 */
package com.sunrise.boss.ui.cms.operationlog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.operationlog.persistent.OperationlogListVO;
import com.sunrise.boss.business.cms.operationlog.persistent.OperationlogVO;
import com.sunrise.boss.delegate.cms.operationlog.OperationlogDelegate;

/**
 * <p>
 * Title: OperationlogAction
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
public class OperationlogAction extends BaseDelegateAction {
	public OperationlogAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(OperationlogVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[1];
		pkNameArray[0] = "logid";
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BaseActionForm form = (BaseActionForm) actionForm;
		if (StringUtils.isBlank(form.get_orderby())) {
			form.set_orderby("optime");
			form.set_desc("1");
		}
		return super.doList(actionMapping, actionForm, request, response, user);
	}
}
