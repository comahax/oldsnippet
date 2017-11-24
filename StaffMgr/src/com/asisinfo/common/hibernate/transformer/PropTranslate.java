package com.asisinfo.common.hibernate.transformer;

public class PropTranslate {
	public static Object tranProp(Object prop){
		Object result = prop;
		if(prop!=null&&prop.getClass()==java.sql.Timestamp.class){
			result = new java.util.Date(((java.sql.Timestamp)prop).getTime());
		}
		return result;
	}
}
