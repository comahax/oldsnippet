package com.gmcc.pboss.common.ui.abstracts;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Select;

import com.opensymphony.xwork2.util.ValueStack;
import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.struts2.UserProvider;

public abstract class PbossSelector extends Select {

	protected String dbFlag;
	protected String readonly = "true";
	protected String headOption;// 下拉框的第一个Option <option
								// value="">headOption</option>
	
	private static UserProvider provider;
	
	static {
		try {		
			provider = (UserProvider)InterfaceUtils.getInstance().createObject(UserProvider.class);		
		} catch (Exception e) {
			e.printStackTrace();
			throw new JOPException("无法创建或调用 userProviderClass 接口的实现类实例" + e.getMessage());
		}
	}
	
	public PbossSelector(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
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

	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}
	
	protected String dbFlagValue;
	protected String readonlyValue = "true";
	
	/**
	 * 从值栈中获取属性值，以便根据其查询数据，子类可覆盖该方法以获取需要的属性
	 * 
	 */
	protected void evaluateQueryParams() {
		
		if (dbFlag != null)
			dbFlagValue = getStack().findString(dbFlag);
		if (dbFlagValue == null)
			dbFlagValue = dbFlag != null ? dbFlag : CoreConfigInfo.COMMON_DB_NAME;
			
		if (readonly != null) {
			readonlyValue = getStack().findString(readonly);
			if(readonlyValue == null)
				readonlyValue = readonly;
		}
			
	}
	public void evaluateExtraParams() {
		super.evaluateExtraParams();

		if (readonly != null) {
			addParameter("readonly", getStack().findValue(readonly,
					Boolean.class));
		}
		if (listKey == null) {
			addParameter("listKey", "key");
		}

		if (listValue == null) {
			addParameter("listValue", "value");
		}
	}
	/**
	 * 计算获取下拉列表中元素的name和value
	 * @return
	 */
	public abstract Map buildMapList();
	
	/**
	 * 获取当前会话对应的User对象
	 * 子类必须实现这个方法，提供具体的数据库访问参数
	 */
	public DBAccessUser getDBAccessUser() {		
		DBAccessUser user = null;
				
		user = provider.getUser();	
		
		if(user == null)
			throw new RuntimeException("PbossSelector 无法获取当前  User ");
		else
			return user;
		
	}
	
	

}
