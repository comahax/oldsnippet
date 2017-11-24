package com.asisinfo.common.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;

import com.asisinfo.common.utils.DateUtils;

public class DynamicProperty {
	
	private static Map propClassMap = new HashMap();
	static {
		registPropType();
	}
	
	private static void registPropType(){
		propClassMap.put("integer", Integer.class);
		propClassMap.put("long", Long.class);
		propClassMap.put("float", Float.class);
		propClassMap.put("double", Double.class);
		propClassMap.put("byte", Byte.class);
		propClassMap.put("string", String.class);
		propClassMap.put("timestamp", Timestamp.class);
		propClassMap.put("date", Date.class);
		propClassMap.put("bigdecimal", BigDecimal.class);
		propClassMap.put("biginteger", BigInteger.class);
	}
	
	/**
	 * 将字符串值构造成指定类型的值
	 * @param value
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public static Object str2Prop(String value,String type) throws Exception{
		Class cls = getClassForType(type);
		if(cls==String.class)
			return value;
		
		if(value==null||value.trim().length()==0)
			return null;
		
		if(cls==java.util.Date.class){
			return DateUtils.StrToDate(value, "yyyy-MM-dd");
		}
		return ConvertUtils.convert(value, cls);
	}
	
	/**
	 * 将属性值转换成指定的类型
	 * @param value
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public static Object convert(Object value,String type) throws Exception{
		if(value==null)
			return null;
		Class cls = getClassForType(type);
		return ConvertUtils.convert(value, cls);
	}
	
	/**
	 * 得到简写类型[long,string等]对应的class
	 * @param typeStr
	 * @return
	 * @throws Exception
	 */
	public static Class getClassForType(String typeStr) throws Exception{
		typeStr = typeStr.toLowerCase();
		Class thisClass = (Class)propClassMap.get(typeStr);
		if(thisClass==null){
			thisClass = Class.forName(typeStr);
		}	
		return thisClass;
	}
}
