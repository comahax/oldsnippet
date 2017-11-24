package com.sunrise.boss.ui.qsmanage.paramstest.testmobileno;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.qsmanage.paramstest.testmobileno.persistent.TestMobilenoVO;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

public class TestMobilenoAction extends BaseAction{
	public TestMobilenoAction(){
		setVoClass(TestMobilenoVO.class);
		this.pkNameArray = new String[1];
		pkNameArray[0] = "mobileno";
	}
	
	protected void onDuplicatePk(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) {
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "该记录已经存在!");
	}
}
