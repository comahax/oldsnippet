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
	private String code, name; //��ѯ�õı��������
	private String sqlName;	//�Զ���SQL����
	private String mapParam;//�����Զ���SQL�Ĳ����������������ֵ֮����ñ�š������ָ����������֮���÷ֺ�";"�ֿ�
	
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
			//ʹ��Cache�����������棬������������ WebViewInterceptorHandler �У��μ� /jop-aop.xml 
			DBAccessUser user = getDBAccessUser();
			
			String queryDBFlag = user.getCityid();
			if(StringUtils.isNotBlank(dbFlag)) {
				queryDBFlag = dbFlag;
			}
			
			
			if(definition.startsWith("$")){
				;	//ֱ�ӽ��ֵ����picker��ʽչ��
			}else if(definition.startsWith("#")){
				;
			}else{
				definition = "#"+definition;
			}
			
			if(condition == null)
				condition = "";
			
			if(StringUtils.isNotBlank(code))	//����û������code��name��Ϊ�µĲ�ѯ������
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
