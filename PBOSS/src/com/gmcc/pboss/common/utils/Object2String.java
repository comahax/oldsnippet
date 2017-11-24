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
	 * �ж��Ƿ�Ϊ��ͨ����,�˷�����ʱ������� listVOProperty ʹ��
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
			//����֮ǰ����WSDLЭ�鲻�淶���ܶ�Ӧ�����ַ��͵��ֶ�ֱ�Ӷ������Object��Ϊ�˴�ӡ��Щ�ֶΣ�
			//�����Object��������
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ����Ƿ���ַ���<br>
	 * �ǺϷ��ִ�����true;���ִ�����false;
	 * 
	 * @param str
	 * @return
	 */
	private static boolean checkNullAndBlank(String str) {
		return (null != str && !"".equals(str));
	}
	
	/**
	 * ��������ַ�����ʽ�Ƿ�YYYYMMDDHHMMSS
	 * 
	 * @param datetime
	 * @return
	 */
	private static boolean checkDateTime14(String datetime) {
		if (!checkNullAndBlank(datetime)) {
			return false;
		}

		// ����ƥ��ʽ
		String matchCase = "[1-9][0-9]{3}(0[0-9]|1[0-2])([0-2][0-9]|3[0-1])(2[0-3]|[0-1][0-9])([0-5][0-9])([0-5][0-9])";
		return datetime.matches(matchCase);
	}
	
	/**
	 * ��EEE MMM dd HH:mm:ss z yyyy ת���� YYYYMMDDHH24MISS
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	private static String changeAreaDateToStr14(String date) throws Exception {
		return dateTemplate14.format(dateTemplateArea.parse(date));
	}
	
	/**
	 * ���ӿ�����Ķ���ת��Ϊ�ַ�������PortTypeImplʹ��
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 *             �����������׳��쳣
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

					// ���������������»��ߵ�,Ҫ���а��»���ȥ��(�������������»���)
					if (fieldName.contains("_")) {
						fieldName = fieldName.replace("_", "");
					}
					try {
						String value = BeanUtils.getProperty(vo, fieldName);
						if (Object2String.checkNullAndBlank(value)) {
							if (fields[i].getType().getName().endsWith("Date")) {// ����Ҫ����ת��
								value = Object2String.changeAreaDateToStr14(value);// �˴���Ҫ�����Э����Ӧ�ĸ�ʽ����
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
						// ����û�ж�Ӧ��get����(������������������)
						log.info(voClass.getSimpleName() + "����,��ȡ����("+ fields[i].getName() + ")����.");
					}
				} else {// �ݹ���͸������Զ���
					Class<?>[] classes = null;
					Method method = voClass.getDeclaredMethod("get"
							+ fields[i].getName().substring(0, 1).toUpperCase()
							+ fields[i].getName().substring(1), classes);
					Object[] objs = null;
					Object obj = method.invoke(vo, objs);
					if (obj != null) {
						if (obj.getClass().getName().contains("ArrayList")) {// ����ArrayList����
							List tmp = (ArrayList) obj;
							for (int j = 0; j < tmp.size(); j++) {
								buff.append(complexObject2Str(tmp.get(j)));
							}
						} else {
							buff.append(complexObject2Str(obj));
						}
					} //else {// null�ж�,��ֹ�����쳣	// ����Ϊnull ,������   }
				}
			}
			// ���END-TAG����.
			buff.append("</").append(voClass.getSimpleName()).append(">");// <RequestMessage>
		} catch (Exception e) {
			e.printStackTrace();
			return "���ܱ�������:" + vo.getClass().getName();
		}
		return buff.toString();
	}
}