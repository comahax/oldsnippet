package com.sunrise.jop.ui.tag.component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.CheckboxList;

import com.opensymphony.xwork2.util.ValueStack;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;

/**
 * FreeMaker File: multicheckbox.ftl
 * @author Canigar
 *
 */
public class MultiCheckBox extends CheckboxList{

	protected String randomCode; //生成页面selectAll等js随机码
	protected String definition;
	protected String condition; // 过滤器,只保留指定条件的值
	protected String dbFlag;
	
	private String conditionValue; // 过滤器,只保留指定条件的值
	private String dbFlagValue;
	
	public MultiCheckBox(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void evaluateParams() {
		setList(buildMapList());
		// TODO Auto-generated method stub
		super.evaluateParams();
	
	}
	
	public void evaluateExtraParams() {
		super.evaluateExtraParams();
		if (listKey == null) {
			addParameter("listKey", "key");
		}
		if (listValue == null) {
			addParameter("listValue", "value");
		}
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		for(int i=0;i<10;i++){
			sb.append(r.nextInt(10));
		}
		addParameter("randomCode", sb.toString());
	}
	
	/**
	 * 根据 definition，condition等参数计算list数据
	 * 
	 * @return
	 */
	protected Map buildMapList() {
		evaluateQueryParams();
		try {
			// 使用Cache拦截器管理缓存，拦截器配置在 WebViewInterceptorHandler 中，参见 /jop-aop.xml
			Map map = Code2NameUtils.valueList(definition, conditionValue, dbFlagValue);
			Map newMap = new LinkedHashMap();
			newMap.putAll(map);
			return newMap;
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap();
		}
	}
	
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
			
	}
	
	@Override
	protected String getDefaultTemplate() {
		// TODO Auto-generated method stub
		return "multicheckbox";
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
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

	public String getRandomCode() {
		return randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}

}
