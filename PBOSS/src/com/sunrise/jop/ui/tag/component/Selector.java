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
	protected String condition; // 过滤器,只保留指定条件的值
	protected String dbFlag;
	protected String showonly;
	protected String nameOnly;
	protected String readonly = "true";
	protected String headOption; // 下拉框的第一个Option <option
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
		// 先计算 list 属性的值，及下拉框的内容，再调用super的evaluateParams方法

		setList(buildMapList());

		// if(property!=null) {
		// value = getStack().findValue(property)!=null ?
		// String.valueOf(getStack().findValue(property)) : null;
		// }

		super.evaluateParams();
	}

	private String conditionValue; // 过滤器,只保留指定条件的值
	private String dbFlagValue;
	private String showonlyValue; // 控制显示方式时使用
	private String nameOnlyValue;
	private String readonlyValue = "true";

	/**
	 * 计算主要参数的值，以便根据其查询数据
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
	 * 根据 definition，condition等参数计算list数据
	 * 
	 * @return
	 */
	protected Map buildMapList() {
		evaluateQueryParams();

		try {
			DBQueryParam param = new DBQueryParam();
			param.set_pagesize("30");
			// 使用Cache拦截器管理缓存，拦截器配置在 WebViewInterceptorHandler 中，参见 /jop-aop.xml
			Map map = Code2NameUtils.valueList(definition, conditionValue, param, dbFlagValue);
			Map newMap = new LinkedHashMap();
			if (headOption == null) {
				newMap.put(null, null); // 加一个空白项
			} else {
				newMap.put(null, headOption);// 添加一个默认的Option：如，请选择....
			}
			newMap.putAll(map);
			return newMap;
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap();
		}
	}

}
