package com.gmcc.pboss.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

public class Object2String {
	private static Logger log = Logger.getLogger(Object2String.class);
	
	private static DateFormat dateTemplate14 = new SimpleDateFormat("yyyyMMddHHmmss");
	private static SimpleDateFormat dateTemplateArea = new SimpleDateFormat(
			"EEE MMM dd HH:mm:ss z yyyy", Locale.US);
	
	/**
	 * 判断是否为普通类型,此方法暂时由上面的 listVOProperty 使用
	 * @param classType
	 * @return
	 * @throws Exception
	 */
	private static boolean isSimpleType(Class<?> classType) throws Exception{
		String typeName = classType.getName();
		if(typeName.endsWith("String")){
			return true;
		}else if(typeName.endsWith("Date")){
			return true;
		}else if(typeName.endsWith("Integer")||typeName.equals("int")){
			return true;
		}else if(typeName.endsWith("Long")||typeName.equals("long")){
			return true;
		}else if(typeName.endsWith("Float")||typeName.equals("float")){
			return true;
		}else if(typeName.endsWith("Double")||typeName.equals("double")){
			return true;
		}else if(typeName.endsWith("Byte")||typeName.equals("byte")){
			return true;
		}else if(typeName.endsWith("Character")||typeName.equals("char")){
			return true;
		}else if(typeName.endsWith("Boolean")||typeName.equals("boolean")){
			return true;
		}else if(typeName.endsWith("Object")){
			//由于之前定义WSDL协议不规范，很多应该是字符型的字段直接定义成了Object，为了打印这些字段，
			//必须把Object包含进来
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 检查是否空字符串<br>
	 * 是合法字串返回true;空字串返回false;
	 * 
	 * @param str
	 * @return
	 */
	private static boolean checkNullAndBlank(String str) {
		return (null != str && !"".equals(str));
	}
	
	/**
	 * 检查日期字符串格式是否YYYYMMDDHHMMSS
	 * 
	 * @param datetime
	 * @return
	 */
	private static boolean checkDateTime14(String datetime) {
		if (!checkNullAndBlank(datetime)) {
			return false;
		}

		// 正则匹配式
		String matchCase = "[1-9][0-9]{3}(0[0-9]|1[0-2])([0-2][0-9]|3[0-1])(2[0-3]|[0-1][0-9])([0-5][0-9])([0-5][0-9])";
		return datetime.matches(matchCase);
	}
	
	/**
	 * 将EEE MMM dd HH:mm:ss z yyyy 转换成 YYYYMMDDHH24MISS
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	private static String changeAreaDateToStr14(String date) throws Exception {
		return dateTemplate14.format(dateTemplateArea.parse(date));
	}
	
	/**
	 * 将接口请求的对象转换为字符串，给PortTypeImpl使用
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 *             反射出错则会抛出异常
	 */
	@SuppressWarnings("unchecked")
	public static String complexObject2Str(Object vo) {
		StringBuffer buff = new StringBuffer();
		try {
			Class<?> voClass = vo.getClass();
			buff.append("<").append(voClass.getSimpleName()).append(">");
			Field[] fields = voClass.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				if (Object2String.isSimpleType(fields[i].getType())) {
					String fieldName = fields[i].getName();

					// 对于属性名称有下划线的,要进行把下划线去掉(函数名不能有下划线)
					if (fieldName.contains("_")) {
						fieldName = fieldName.replace("_", "");
					}
					try {
						String value = BeanUtils.getProperty(vo, fieldName);
						if (Object2String.checkNullAndBlank(value)) {
							if (fields[i].getType().getName().endsWith("Date")) {// 日期要进行转换
								value = Object2String.changeAreaDateToStr14(value);// 此处需要改造成协议适应的格式？？
							}
							// <element>string</element>
							buff.append("<").append(fields[i].getName()).append(">");
							buff.append(value);
							buff.append("</").append(fields[i].getName()).append(">");
						} else {
							// <element/>
							buff.append("<").append(fields[i].getName()).append("/>");
						}
					} catch (Exception e) {
						// 属性没有对应的get方法(可能是属性名有问题)
						log.info(voClass.getSimpleName() + "对象,读取属性("+ fields[i].getName() + ")出错.");
					}
				} else {// 递归解释复杂属性对象
					Class<?>[] classes = null;
					Method method = voClass.getDeclaredMethod("get"
							+ fields[i].getName().substring(0, 1).toUpperCase()
							+ fields[i].getName().substring(1), classes);
					Object[] objs = null;
					Object obj = method.invoke(vo, objs);
					if (obj != null) {
						if (obj.getClass().getName().contains("ArrayList")) {// 遍历ArrayList对象
							List tmp = (ArrayList) obj;
							for (int j = 0; j < tmp.size(); j++) {
								buff.append(complexObject2Str(tmp.get(j)));
							}
						} else {
							buff.append(complexObject2Str(obj));
						}
					} //else {// null判断,防止出现异常	// 对象为null ,不处理   }
				}
			}
			// 最后将END-TAG补上.
			buff.append("</").append(voClass.getSimpleName()).append(">");// <RequestMessage>
		} catch (Exception e) {
			e.printStackTrace();
			return "不能遍历对象:" + vo.getClass().getName();
		}
		return buff.toString();
	}
}