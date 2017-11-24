/**
 * Copyright(c)1999-2008 Sunrise Electronics Developmnet Co.,Ltd<br>
 * All rights reserved. Use is subject to license terms.
 */
package com.asisinfo.common.json;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Writer;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author wanhongquan
 * @created at 2009-10-22 ����09:09:27
 * @version $Id$
 */
public class JSONUtils {
	private static final String DEFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
	
	
	/** * logger. */
	 private static Log logger = LogFactory.getLog(JSONUtils.class);
	 
	 /** * ��������Ҫ�ı������췽��. */
	 protected JSONUtils() {
	 }
	 
	 /**
	 * write.
	 *
	 * @param bean obj
	 * @param writer �����
	 * @param excludes ��ת������������
	 * @param datePattern date��stringת����ģʽ
	 * @throws Exception д����ݿ��ܳ����쳣
	 */
	 public static void write(Object bean, Writer writer,
	 String[] excludes, String datePattern){
	 JsonConfig jsonConfig = configJson(excludes, datePattern);
	 
	 JSON json = JSONSerializer.toJSON(bean, jsonConfig);
	 
	 json.write(writer);
	 }
	 /**
	  * ����Ĭ�ϵ�����--��������ֶμ����ڸ�ʽ��Ĭ�ϵ�
	  * @param bean ����Ķ���
	  * @param writer �����
	  */
	 public static void write(Object bean,Writer writer)
	 {
		 write(bean,writer,new String[0],DEFAULT_DATE_FORMAT);
	 }
	 /**
	  * ���ڸ�ʽΪĬ�ϵ�--�ų�ָ�����ֶ�
	  * @param bean
	  * @param excludes
	  * @param writer
	  */
	 public static void write(Object bean ,String[] excludes,Writer writer)
	 {
		 write(bean,writer,excludes,DEFAULT_DATE_FORMAT);
	 }
	 /**
	  * ��������ֶΣ����ڸ�ʽ����ָ���ĸ�ʽ���
	  * @param bean
	  * @param datePattern
	  * @param writer
	  */
	 public static void write(Object bean,String datePattern,Writer writer)
	 {
		 write(bean,writer,new String[0],datePattern);
	 }
	 
	 /**
	 * ����json-lib��Ҫ��excludes��datePattern.
	 *
	 * @param excludes ����Ҫת������������
	 * @param datePattern ����ת��ģʽ
	 * @return JsonConfig ���excludes��dataPattern��ɵ�jsonConfig������write
	 */
	 public static JsonConfig configJson(String[] excludes,
	 String datePattern) {
	 JsonConfig jsonConfig = new JsonConfig();
	 jsonConfig.setExcludes(excludes);
	 jsonConfig.setIgnoreDefaultExcludes(false);
	 jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
	 jsonConfig.registerJsonValueProcessor(Date.class,
	 new DateJsonValueProcessor(datePattern));
	 
	 return jsonConfig;
	 }
	 
	 /**
	 * data={"id":"1"}��json����ݴ���ָ����pojo.
	 *
	 * @param <T> Object
	 * @param data json�ַ�
	 * @param clazz ��Ҫת����bean�ľ�������
	 * @param excludes ����Ҫת������������
	 * @param datePattern ����ת��ģʽ
	 * @return T
	 * @throws Exception java.lang.InstantiationException,
	 * java.beans.IntrospectionException,
	 * java.lang.IllegalAccessException
	 */
	 public static <T extends Object> T json2Bean(String data,
	 Class<T> clazz, String[] excludes, String datePattern)
	 throws Exception {
	 // JsonUtils.configJson(excludes, datePattern);
	 T entity = clazz.newInstance();
	 
	 return json2Bean(data, entity, excludes, datePattern);
	 }
	 
	 /**
	 * data={"id":"1"}��json�����ݣ����ָ����pojo.
	 *
	 * @param <T> Object
	 * @param data json�ַ�
	 * @param entity ��Ҫ�����ݵ�bean
	 * @param excludes ����Ҫת������������
	 * @param datePattern ����ת��ģʽ
	 * @return T
	 * @throws Exception java.lang.InstantiationException,
	 * java.beans.IntrospectionException,
	 * java.lang.IllegalAccessException
	 */
	 public static <T extends Object> T json2Bean(String data, T entity,
	 String[] excludes, String datePattern) throws Exception {
	 // JsonUtils.configJson(excludes, datePattern);
	 JSONObject jsonObject = JSONObject.fromObject(data);
	 
	 return json2Bean(jsonObject, entity, excludes, datePattern);
	 }
	 
	 /**
	 * ���Class���entity���ٰ�JSONObject�е��������ȥ.
	 *
	 * @param <T> Object
	 * @param jsonObject json����
	 * @param clazz ��Ҫת����bean�ľ�������
	 * @param excludes ����Ҫת������������
	 * @param datePattern ����ת��ģʽ
	 * @return T
	 * @throws Exception java.lang.InstantiationException,
	 * java.beans.IntrospectionException,
	 * java.lang.IllegalAccessException
	 */
	 public static <T extends Object> T json2Bean(JSONObject jsonObject,
	 Class<T> clazz, String[] excludes, String datePattern)
	 throws Exception {
	 // JsonUtils.configJson(excludes, datePattern);
	 T entity = clazz.newInstance();
	 
	 return json2Bean(jsonObject, entity, excludes, datePattern);
	 }
	 
	 /**
	 * ��JSONObject�е������䵽entity��.
	 *
	 * @param <T> Object
	 * @param jsonObject json����
	 * @param entity ��Ҫ�����ݵ�node
	 * @param excludes ����Ҫת������������
	 * @param datePattern ����ת��ģʽ
	 * @return T
	 * @throws Exception java.lang.InstantiationException,
	 * java.beans.IntrospectionException,
	 * java.lang.IllegalAccessException
	 */
	 public static <T extends Object> T json2Bean(JSONObject jsonObject,
	 T entity, String[] excludes, String datePattern)
	 throws Exception {
	 // JsonUtils.configJson(excludes, datePattern);
	 Set<String> excludeSet = new HashSet<String>();
	 
	 for (String exclude : excludes) {
	 excludeSet.add(exclude);
	 }
	 
	 for (Object object : jsonObject.entrySet()) {
	 Map.Entry entry = (Map.Entry) object;
	 String propertyName = entry.getKey().toString();
	 
	 if (excludeSet.contains(propertyName)) {
	 continue;
	 }
	 
	 String propertyValue = entry.getValue().toString();
	 
	 try {
	 PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName,
	 entity.getClass());
	 Class propertyType = propertyDescriptor.getPropertyType();
	 
	 Method writeMethod = propertyDescriptor.getWriteMethod();
	 
	 if (propertyType == String.class) {
	 writeMethod.invoke(entity, propertyValue);
	 } else if ((propertyType == Byte.class)
	 || (propertyType == byte.class)) {
	 writeMethod.invoke(entity,
	 Byte.parseByte(propertyValue));
	 } else if ((propertyType == Short.class)
	 || (propertyType == short.class)) {
	 writeMethod.invoke(entity,
	 Short.parseShort(propertyValue));
	 } else if ((propertyType == Integer.class)
	 || (propertyType == int.class)) {
	 writeMethod.invoke(entity,
	 Integer.parseInt(propertyValue));
	 } else if ((propertyType == Long.class)
	 || (propertyType == long.class)) {
	 writeMethod.invoke(entity,
	 Long.parseLong(propertyValue));
	 } else if ((propertyType == Float.class)
	 || (propertyType == float.class)) {
	 writeMethod.invoke(entity,
	 Float.parseFloat(propertyValue));
	 } else if ((propertyType == Double.class)
	 || (propertyType == double.class)) {
	 writeMethod.invoke(entity,
	 Double.parseDouble(propertyValue));
	 } else if ((propertyType == Boolean.class)
	 || (propertyType == boolean.class)) {
	 writeMethod.invoke(entity,
	 Boolean.parseBoolean(propertyValue));
	 } else if ((propertyType == Character.class)
	 || (propertyType == char.class)) {
	 writeMethod.invoke(entity, propertyValue.charAt(0));
	 } else if (propertyType == Date.class) {
	 SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
	 writeMethod.invoke(entity,
	 dateFormat.parse(propertyValue));
	 }
	 } catch (IntrospectionException ex) {
	 logger.info(ex);
	 
	 continue;
	 }
	 }
	 
	 return entity;
	 }
	 
	 /**
	 * data=[{"id":"1"},{"id":2}]��json�����ݣ�����pojo����.
	 *
	 * @param <T> Object
	 * @param data json�ַ�
	 * @param clazz ��Ҫת����node�ľ�������
	 * @param excludes ����Ҫת������������
	 * @param datePattern ����ת��ģʽ
	 * @return List
	 * @throws Exception java.lang.InstantiationException,
	 * java.beans.IntrospectionException,
	 * java.lang.IllegalAccessException
	 */
	 public static <T extends Object> List<T> json2List(String data,
	 Class<T> clazz, String[] excludes, String datePattern)
	 throws Exception {
	 JSONArray jsonArray = JSONArray.fromObject(data);
	 
	 return json2List(jsonArray, clazz, excludes, datePattern);
	 }
	 
	 /**
	 * data=[{"id":"1"},{"id":2}]��json�����ݣ�����pojo����.
	 *
	 * @param <T> Object
	 * @param jsonArray JSONArray
	 * @param clazz ��Ҫת����node�ľ�������
	 * @param excludes ����Ҫת������������
	 * @param datePattern ����ת��ģʽ
	 * @return List
	 * @throws Exception java.lang.InstantiationException,
	 * java.beans.IntrospectionException,
	 * java.lang.IllegalAccessException
	 */
	 public static <T extends Object> List<T> json2List(
	 JSONArray jsonArray, Class<T> clazz, String[] excludes,
	 String datePattern) throws Exception {
	 List<T> list = new ArrayList<T>();
	 
	 for (int i = 0; i < jsonArray.size(); i++) {
	 JSONObject jsonObject = jsonArray.getJSONObject(i);
	 T node = json2Bean(jsonObject, clazz, excludes, datePattern);
	 list.add(node);
	 }
	 
	 return list;
	 }
	
	 
}
