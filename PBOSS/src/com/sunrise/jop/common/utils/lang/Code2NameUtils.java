package com.sunrise.jop.common.utils.lang;

import java.util.Map;

import com.sunrise.jop.infrastructure.component.Code2Name;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.infrastructure.dproxy.ProxyFactory;

/**
 * Code2Name工具类
 * @author Canigar
 *
 */
public class Code2NameUtils {

	private static Code2Name comp;
	//对应Code2Name里面的拦截方法,判断是否使用缓存击中
	private static String[] code2NameMethods = null;
	
	static {
		try {
			if(CoreConfigInfo.USE_CACHE_FLAG){
				code2NameMethods = new String[]{"code2Name"};
			}else{
				code2NameMethods = new String[0];
			}
			Class implClass = InterfaceUtils.getInstance().getImplClass(Code2Name.class);
			//String数组里面是做使用缓存的拦截的方法
			comp = (Code2Name) ProxyFactory.createObject(implClass, code2NameMethods, "WebViewInterceptorHandler");
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
