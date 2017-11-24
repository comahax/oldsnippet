package com.sunrise.boss.ui.qsmanage.paramstest.testopr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.qsmanage.paramstest.testopr.persistent.TestOprVO;

public class TestOprAction extends BaseAction {
	public TestOprAction() {
		setVoClass(TestOprVO.class);
		this.pkNameArray = new String[1];
		pkNameArray[0] = "oprcode";
	}
	
	protected void onDuplicatePk(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) {
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "该记录已经存在!");
	}
}
