package com.sunrise.boss.delegate.resmanage.common.tag;

import java.util.List;
import java.util.Map;

public class Node {
	private String delegateCls = "";
	private String methodName = "";
	private List paramInfos;
	public String getDelegateCls() {
		return delegateCls;
	}
	public void setDelegateCls(String delegateCls) {
		this.delegateCls = delegateCls;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	class ParamInfo{
		private String name;
		private String value;
		private String type;
		
		ParamInfo (String name,String value,String type){
			this.name = name;
			this.value = value;
			this.type = type;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}

	public List getParamInfos() {
		return paramInfos;
	}
	public void setParamInfos(List paramInfos) {
		this.paramInfos = paramInfos;
	}
}
