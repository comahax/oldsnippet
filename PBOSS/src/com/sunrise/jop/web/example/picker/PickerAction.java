/**
 * 
 */
package com.sunrise.jop.web.example.picker;

import org.apache.commons.lang.StringUtils;

import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * @author He Kun
 *
 */
public class PickerAction extends BaseAction {
	
	private String definition,condition, dbFlag;
	private String code, name; //查询用的编码和名称
	private String sqlName;	//自定义SQL名称
	private String mapParam;//用于自定义SQL的参数多个参数名，与值之间用帽号“：”分隔，多个参数之间用分号";"分开
	
	/**
	 * 
	 */
	public PickerAction() {				
	}
	
	public String doList() throws Exception {
		try {
			if(param== null) {
				param = new DBQueryParam();
				param.set_pageno("1");
				param.set_pagesize("15");
			}
			
			if( null != sqlName && !"".equals(sqlName.trim())){
				param.setQueryByNameSql(true);
				param.setNameSql(sqlName.trim());
				
				if( null != mapParam &&!"".equals(mapParam.trim())){
					String temp = mapParam.replaceAll(";$", "");
					String[] mutParams = temp.split(";");
					for(String singParam : mutParams){
						String[] temp2 = singParam.split(":");
						param.getQueryConditions().put(temp2[0], temp2[1]);
					}
				}
			}
			//使用Cache拦截器管理缓存，拦截器配置在 WebViewInterceptorHandler 中，参见 /jop-aop.xml 
			DBAccessUser user = getDBAccessUser();
			
			String queryDBFlag = user.getCityid();
			if(StringUtils.isNotBlank(dbFlag)) {
				queryDBFlag = dbFlag;
			}
			
			
			if(definition.startsWith("$")){
				;	//直接将字典表用picker形式展现
			}else if(definition.startsWith("#")){
				;
			}else{
				definition = "#"+definition;
			}
			
			if(condition == null)
				condition = "";
			
			if(StringUtils.isNotBlank(code))	//添加用户输入的code，name作为新的查询条件。
				condition = condition + ";" + "CODE:" + code;
			
			if(StringUtils.isNotBlank(name))
				condition = condition + ";" + "NAME:" + name;
			
			if(condition.startsWith(";"))
				condition = condition.substring(1);
			
			DataPackage dp = Code2NameUtils.valueListPackage(definition, condition, param, queryDBFlag);
			setDp(dp);
				
		} catch (Exception e) {			 
			e.printStackTrace();
		}
		return "picker";
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSqlName() {
		return sqlName;
	}

	public void setSqlName(String sqlName) {
		this.sqlName = sqlName;
	}

	public String getMapParam() {
		return mapParam;
	}

	public void setMapParam(String mapParam) {
		this.mapParam = mapParam;
	}
}
