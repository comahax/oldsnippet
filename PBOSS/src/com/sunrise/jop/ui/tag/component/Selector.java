package com.sunrise.jop.ui.tag.component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Select;

import com.opensymphony.xwork2.util.ValueStack;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * 
 * @author He Kun
 * 
 */
public class Selector extends Select {

	protected String definition;
	protected String condition; // ������,ֻ����ָ��������ֵ
	protected String dbFlag;
	protected String showonly;
	protected String nameOnly;
	protected String readonly = "true";
	protected String headOption; // ������ĵ�һ��Option <option
								// value="">headOption</option>

	public Selector(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDbFlag() {
		return dbFlag;
	}

	public void setDbFlag(String dbFlag) {
		this.dbFlag = dbFlag;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getNameOnly() {
		return nameOnly;
	}

	public void setNameOnly(String nameOnly) {
		this.nameOnly = nameOnly;
	}

	public String getShowonly() {
		return showonly;
	}

	public void setShowonly(String showonly) {
		this.showonly = showonly;
	}

	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	public String getHeadOption() {
		return headOption;
	}

	public void setHeadOption(String headOption) {
		this.headOption = headOption;
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

	public void evaluateParams() {
		// �ȼ��� list ���Ե�ֵ��������������ݣ��ٵ���super��evaluateParams����

		setList(buildMapList());

		// if(property!=null) {
		// value = getStack().findValue(property)!=null ?
		// String.valueOf(getStack().findValue(property)) : null;
		// }

		super.evaluateParams();
	}

	private String conditionValue; // ������,ֻ����ָ��������ֵ
	private String dbFlagValue;
	private String showonlyValue; // ������ʾ��ʽʱʹ��
	private String nameOnlyValue;
	private String readonlyValue = "true";

	/**
	 * ������Ҫ������ֵ���Ա�������ѯ����
	 * 
	 */
	protected void evaluateQueryParams() {
		if (condition != null) {
			conditionValue = getStack().findString(condition);
			//fix struts2 evaluate bug
			if(conditionValue == null)
				conditionValue = condition;
		}
			
		if (dbFlag != null)
			dbFlagValue = getStack().findString(dbFlag);
		if (dbFlagValue == null)
			dbFlagValue = CoreConfigInfo.COMMON_DB_NAME;

		if (showonly != null) {
			showonlyValue = getStack().findString(showonly);
			if(showonlyValue == null)
				showonlyValue = showonly;
		}
			
		if (nameOnly != null) {
			nameOnlyValue = getStack().findString(nameOnly);
			if(nameOnlyValue == null)
				nameOnlyValue = nameOnly;
		}
			
		if (readonly != null) {
			readonlyValue = getStack().findString(readonly);
			if(readonlyValue == null)
				readonlyValue = readonly;
		}
			
	}

	/**
	 * ���� definition��condition�Ȳ�������list����
	 * 
	 * @return
	 */
	protected Map buildMapList() {
		evaluateQueryParams();

		try {
			DBQueryParam param = new DBQueryParam();
			param.set_pagesize("30");
			// ʹ��Cache�����������棬������������ WebViewInterceptorHandler �У��μ� /jop-aop.xml
			Map map = Code2NameUtils.valueList(definition, conditionValue, param, dbFlagValue);
			Map newMap = new LinkedHashMap();
			if (headOption == null) {
				newMap.put(null, null); // ��һ���հ���
			} else {
				newMap.put(null, headOption);// ���һ��Ĭ�ϵ�Option���磬��ѡ��....
			}
			newMap.putAll(map);
			return newMap;
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap();
		}
	}

}
