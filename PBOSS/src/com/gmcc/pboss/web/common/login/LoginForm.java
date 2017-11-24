package com.gmcc.pboss.web.common.login;

import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.ui.User;
import com.sunrise.ws.client.Result;

public class LoginForm extends BaseVO{

	private User user;
	private Result result;
	
	private String isCitySms;//省、市公司随机短信获取标志
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public String getIsCitySms() {
		return isCitySms;
	}
	public void setIsCitySms(String isCitySms) {
		this.isCitySms = isCitySms;
	}
	
}
