package com.sunrise.jop.web.example.picker;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.infrastructure.component.Code2Name;
import com.sunrise.jop.infrastructure.component.impl.Node;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * MoreCheck��ѡ��
 * @author Canigar
 * 
 */
public class MoreCheckAction extends BaseAction{

	public String doList() throws Exception {
		try{
			if(param== null) {
				param = new DBQueryParam();
				param.set_pageno("1");
				param.set_pagesize("15");
			}
			
			/*** ���ڼ�¼���Ƿ��Ƿ�ҳѡ���Ƿ��ǵ�һ�ε����� ***/
			if(!isFirst()){
				/** ���ñ�־ **/
				setFirst(true);
				
				/*** ��¼�³�ʼ��code �� name ***/
				setInitcode(getCode());
				setInitname(getName());
				
				setInitcondition(getCondition());
				/*** FullCode��FullName��� ***/
				getFull();
			}
			
			//ʹ��Cache�����������棬������������ WebViewInterceptorHandler �У��μ� /jop-aop.xml 
			Code2Name comp = (Code2Name)InterfaceUtils.getInstance().createObject(Code2Name.class); //��Ҫ��Ե����͵ı����б�		
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
			
			condition = initcondition;
			if(StringUtils.isNotBlank(queryCode))	//����û������code��name��Ϊ�µĲ�ѯ������
				condition = condition + ";" + "CODE:" + queryCode;
			if(StringUtils.isNotBlank(queryName))
				condition = condition + ";" + "NAME:" + queryName;
			if(condition.startsWith(";"))
				condition = condition.substring(1);
			DataPackage dp = comp.valueListPackage(definition, condition, param, queryDBFlag);
			setDp(dp);
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "morecheck";
	}
	
	/*** ��ȡ��ѡ�� ÿһ��code��code���õ�name �����磺 1��2��3 �� A��B��C�� ***/
	private void getFull() throws Exception{
		
		StringBuffer fullcode = new StringBuffer("");
		StringBuffer fullname = new StringBuffer("");
		// TODO Auto-generated method stub
		DBQueryParam param = new DBQueryParam();
		param.set_pageno("1");
		param.set_pagesize("10000");
		
		DBAccessUser user = getDBAccessUser();
		String queryDBFlag = user.getCityid();
		if(StringUtils.isNotBlank(dbFlag)) {
			queryDBFlag = dbFlag;
		}
		
		DataPackage dp = Code2NameUtils.valueListPackage(definition, condition, param, queryDBFlag);
		
		if(dp.getDatas() != null && dp.getDatas().size() != 0){
			Iterator itt = dp.getDatas().iterator();
			while(itt.hasNext()){
				Node node = (Node)itt.next();
				fullcode.append(node.getCode()).append(",");
				fullname.append(node.getName()).append(",");
			}
		}
		
		setFullcode(fullcode.toString());
		setFullname(fullname.toString());
		
		setAllcode(getFullcode());
		setAllname(getFullname());
	}
	
	
	

	private String queryCode;
	private String queryName;

	private String code ;	
	private String name ;
	private String definition;	
	private String condition ;	
	private String initcondition;
	private String property;
	private String dbFlag;
	private String allname;
	private String allcode;
	private String fullname;
	private String fullcode;
	private String initcode;
	private String initname;
	private String uncheckcode;
	private String uncheckname;
	private boolean first;
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
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getDbFlag() {
		return dbFlag;
	}
	public void setDbFlag(String dbFlag) {
		this.dbFlag = dbFlag;
	}
	public String getAllname() {
		return allname;
	}
	public void setAllname(String allname) {
		this.allname = allname;
	}
	public String getAllcode() {
		return allcode;
	}
	public void setAllcode(String allcode) {
		this.allcode = allcode;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getFullcode() {
		return fullcode;
	}
	public void setFullcode(String fullcode) {
		this.fullcode = fullcode;
	}
	public String getInitcode() {
		return initcode;
	}
	public void setInitcode(String initcode) {
		this.initcode = initcode;
	}
	public String getInitname() {
		return initname;
	}
	public void setInitname(String initname) {
		this.initname = initname;
	}
	public String getUncheckcode() {
		return uncheckcode;
	}
	public void setUncheckcode(String uncheckcode) {
		this.uncheckcode = uncheckcode;
	}
	public String getUncheckname() {
		return uncheckname;
	}
	public void setUncheckname(String uncheckname) {
		this.uncheckname = uncheckname;
	}
	public boolean isFirst() {
		return first;
	}
	public void setFirst(boolean first) {
		this.first = first;
	}

	public String getQueryCode() {
		return queryCode;
	}

	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getInitcondition() {
		return initcondition;
	}

	public void setInitcondition(String initcondition) {
		this.initcondition = initcondition;
	}
}
