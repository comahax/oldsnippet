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
	protected String headOption;// ������ĵ�һ��Option <option
								// value="">headOption</option>
	
	private static UserProvider provider;
	
	static {
		try {		
			provider = (UserProvider)InterfaceUtils.getInstance().createObject(UserProvider.class);		
		} catch (Exception e) {
			e.printStackTrace();
			throw new JOPException("�޷���������� userProviderClass �ӿڵ�ʵ����ʵ��" + e.getMessage());
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
	 * ��ֵջ�л�ȡ����ֵ���Ա�������ѯ���ݣ�����ɸ��Ǹ÷����Ի�ȡ��Ҫ������
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
	 * �����ȡ�����б���Ԫ�ص�name��value
	 * @return
	 */
	public abstract Map buildMapList();
	
	/**
	 * ��ȡ��ǰ�Ự��Ӧ��User����
	 * �������ʵ������������ṩ��������ݿ���ʲ���
	 */
	public DBAccessUser getDBAccessUser() {		
		DBAccessUser user = null;
				
		user = provider.getUser();	
		
		if(user == null)
			throw new RuntimeException("PbossSelector �޷���ȡ��ǰ  User ");
		else
			return user;
		
	}
	
	

}
