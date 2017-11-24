package com.gmcc.pboss.common.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;
import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.struts2.UserProvider;

public class PbossSmpSelectorTag extends AbstractUITag {

	protected String mode; // 显示模式,根据具体业务控制下拉列表内容
	protected String dbFlag;
	protected String headOption; // 下拉框的第一个Option <option value="">headOption</option>
	
	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}


	public String getDbFlag() {
		return dbFlag;
	}


	public void setDbFlag(String dbFlag) {
		this.dbFlag = dbFlag;
	}

	public String getHeadOption() {
		return headOption;
	}


	public void setHeadOption(String headOption) {
		this.headOption = headOption;
	}


	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		Class clazz = InterfaceUtils.getInstance().getImplClass(UserProvider.class);
		UserProvider provider;
		try {
			provider = (UserProvider)clazz.newInstance();
			DBAccessUser user = (DBAccessUser)provider.getUser();// req.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
			dbFlag = user.getCityid();
		}catch (Exception e) {
			throw new IllegalArgumentException("Can't find or instant UserProvider's impl class! ");
		}
		
		return new PbossSmpSelector(stack,req,res);
	}


	@Override
	protected void populateParams() {
		// TODO Auto-generated method stub
		super.populateParams();
		PbossSmpSelector selector = (PbossSmpSelector)component;
		selector.setDbFlag(dbFlag);
		selector.setMode(mode);
		selector.setHeadOption(headOption);
	}

	

}
