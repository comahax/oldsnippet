/**
 * auto-generated code
 * Fri May 02 07:02:06 CST 2008
 */
package com.sunrise.boss.ui.cms.costcard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.costcard.persistent.CostcardListVO;
import com.sunrise.boss.business.cms.costcard.persistent.CostcardVO;
import com.sunrise.boss.delegate.cms.costcard.CostcardDelegate;

/**
 * <p>
 * Title: CostcardAction
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
public class CostcardAction extends BaseDelegateAction {
	public CostcardAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(CostcardVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[3];
		pkNameArray[0] = "calcmonth";
		pkNameArray[1] = "opnid";
		pkNameArray[2] = "wayid";
	}

	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("list");
	}
	public ActionForward doBatch(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("batch");
	}
}
