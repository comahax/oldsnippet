package com.sunrise.jop.common.utils.lang;

import java.util.Map;

import com.sunrise.jop.infrastructure.component.Code2Name;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.infrastructure.dproxy.ProxyFactory;

public class Code2NameUtils {

	private static Code2Name comp;

	static {
		try {
			Class implClass = InterfaceUtils.getInstance().getImplClass(Code2Name.class);
			comp = (Code2Name) ProxyFactory.createObject(implClass, new String[] { "code2Name" }, "WebViewInterceptorHandler");

		} catch (InstantiationException e) {
			throw new RuntimeException("Fail to instantiate code2name component instance " + e, e);
		}
	}
	
	public static String code2Name(String definition,String codeValue,String dbFlag){
		return comp.code2Name(definition, codeValue, dbFlag);
	}
	
	public static Map valueList(String definition, String dbFlag) {
		return valueList(definition, null, dbFlag);
	}
	
	public static Map valueList(String definition, String condition, String dbFlag) {	
		return valueList(definition, condition, null, dbFlag);
	}
	
	public static Map valueList(String definition, String condition,DBQueryParam param, String dbFlag) {
		return comp.valueList(definition, condition, param, dbFlag);
	}
	
	public static DataPackage valueListPackage(String definition, String condition,DBQueryParam param, String dbFlag ){
		return comp.valueListPackage(definition, condition, param, dbFlag);
	}
}
