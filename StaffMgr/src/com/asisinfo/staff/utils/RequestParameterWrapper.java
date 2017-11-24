package com.asisinfo.staff.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
/**
 * 请求参数封装到bean
 * @author LHC
 *
 */
public class RequestParameterWrapper {
	private static Logger log = Logger.getLogger(RequestParameterWrapper.class);
	private static List<SimpleDateFormat> formats = new ArrayList<SimpleDateFormat>();
	static{
		formats.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		formats.add(new SimpleDateFormat("yyyyMMdd"));
	}
	
	public static <T> T tranfer(HttpServletRequest request,Class<T> clazz){
		try {
			T obj = clazz.newInstance();
			HashMap<String,String[]> map = (HashMap<String,String[]>) request.getParameterMap();
			 for (Map.Entry<String,String[]> entry : map.entrySet()) {
				 String[] value = entry.getValue();
				 if (value==null||value[0].equals("")) 
					 continue;
				 Field field = getDeclaredField(clazz, entry.getKey());;
				 if (field!=null) {
					 try {
						 Class<?> class1 = field.getType();
						 field.setAccessible(true);
						if (class1==String.class) {
							field.set(obj, value[0]);
						}else if (class1==Integer.class||class1==int.class) {
							field.set(obj, Integer.parseInt(value[0]));
						}else if(class1==Date.class){
							int i = 0;
								for(SimpleDateFormat format:formats){
									try {
										field.set(obj, format.parse(value[0]));
										break;
									} catch (Exception e) {
										i++;
										if (i==formats.size()) {
											throw e;
										}
									}
								}
						}
					} catch (Exception e) {
						log.warn(field.getName()+"注入失败", e);
					}
				}
			 }
			 return obj;
		} catch (Exception e) {
			log.warn(clazz.getName()+"注入失败", e);
		}
		return null;
	}
	
	/** 
     * 循环向上转型, 获取对象的 Method 
     * @param object : 子类对象 
     * @param methodName : 父类中的方法名 
     * @return 父类中的方法对象 
     */  
	private static Method getMethod(Object object, String methodName,Class<?>... parameterTypes){  
        Method method = null ;  
          
        for(Class<?> clazz = object.getClass() ; clazz != Object.class ; clazz = clazz.getSuperclass()) {  
            try {
                method = clazz.getMethod(methodName,parameterTypes) ;  
                return method ;  
            } catch (Exception e) {}  
        }  
        
        return null;  
    } 
	/**
	 * 循环向上转型, 获取对象的 Field
	 * @param clazz
	 * @param fieldName 字段名
	 * @return
	 */
	private static Field getDeclaredField(Class clazz, String fieldName){
		Field field;
		for( ; clazz != Object.class ; clazz = clazz.getSuperclass()) {  
            try {
                field = clazz.getDeclaredField(fieldName);  
                return field ;  
            } catch (Exception e) {}  
        }  
        
        return null;  
	}
	/**
	 * 获取set方法名
	 * @param propertityName 参数名
	 * @return
	 */
	private static String setMethodName(String propertityName){
		return "set"+ propertityName.substring(0, 1).toUpperCase() + propertityName.substring(1);
	}
}
