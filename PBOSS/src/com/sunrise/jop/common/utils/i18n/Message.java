package com.sunrise.jop.common.utils.i18n;

import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.jop.common.utils.bean.BeanUtils;

/**
 * Title: Message Description: Message���ڴ��� �����ļ���� ������Ϣ�� Copyright: Copyright (c)
 * 2006 Company: sunrise Tech Ltd.
 * 
 * @author mys
 * @version 1.0
 * 
 */
public class Message {
	private static Log log = LogFactory.getLog(BeanUtils.class);

	public static final String PUBLIC_PROPERTIES_RESOURCE = "/com/sunrise/boss/resource/i18n/common/public.properties";

	public static final String MESSAGE_COMPART_SYMBOL = ";";

	/**
	 * ȡָ���ļ��ĳ־õ����Լ�
	 * 
	 * @param bundleName
	 *            ��Դ�ļ�ȫ��
	 * @return �־õ����Լ�
	 */
	public static Properties getProperties(String bundleName) {

		InputStream in = Message.class.getResourceAsStream(bundleName);
		Properties properties = new Properties();
		if (null != in) {
			try {
				properties.load(in);
				in.close();
			} catch (IOException ex) {
				log.error("error : can't load Properties!");
			} catch (Exception ex) {
				log.error("error : can't load Properties!");
				if (null != ex.getMessage()) {
					log.error("error:" + ex.getMessage(), ex);

				} else {
					log.error("error", ex);
				}
			}
		} else {
			log.info("info : can't InputStream bundleName:" + bundleName);
		}
		return properties;
	}

	/**
	 * ȡָ����Դ�ļ����ָ����Ϣ
	 * 
	 * @param properties
	 *            �־õ����Լ�
	 * @param key
	 *            �ؼ���
	 * @return ������Ϣ
	 */
	private static String getString(Properties properties, String key) {
		String result = key;
		if (properties == null)
			return key;
		if ((key != null) && (key.length() != 0)) {
			try {
				result = properties.getProperty(key);
			} catch (MissingResourceException e) {
				result = key;
			}
		}
		return result;
	}

	/**
	 * ȡָ����Դ�ļ����ָ����Ϣ
	 * 
	 * @param properties
	 *            �־õ����Լ�
	 * @param key
	 *            �ؼ���
	 * @param args
	 *            ����ֵ
	 * @return ������Ϣ
	 */
	private static String getString(Properties properties, String key,
			String[] args) {
		String result = key;
		if (properties == null)
			return key;
		if ((key != null) && (key.length() != 0)) {
			try {
				result = properties.getProperty(key);

				if (args != null) {
					for (int i = 0; i < args.length; i++) {
						result = result
								.replaceFirst("\\{" + i + "\\}", args[i]);
					}
				}
			} catch (MissingResourceException e) {
				result = key;
			}
		}
		return result;
	}

	/**
	 * ȡָ����Դ�ļ����ָ����Ϣ
	 * 
	 * @param properties
	 *            �־õ����Լ�
	 * @param key
	 *            �ؼ���
	 * @param defaultValue
	 *            Ĭ��ֵ ����Ҳ���key��Ӧ��ֵ���򷵻�Ĭ��ֵ
	 * @return ������Ϣ
	 */
	private static String getString(Properties properties, String key,
			String defaultValue) {
		String result = key;
		if (properties == null)
			return key;
		if ((key != null) && (key.length() != 0)) {
			try {
				result = properties.getProperty(key, defaultValue);
			} catch (MissingResourceException e) {
				result = key;
			}
		}
		return result;
	}

	/**
	 * ��public��Դ��ȡָ������Ϣ
	 * 
	 * @param key
	 *            �ؼ���
	 * @return ������Ϣ
	 */
	public static String getPublicString(String key) {
		Properties properties = getProperties(PUBLIC_PROPERTIES_RESOURCE);
		return getString(properties, key);
	}

	/**
	 * ��public��Դ��ȡָ������Ϣ
	 * 
	 * @param key
	 *            �ؼ���
	 * @param defaultValue
	 *            Ĭ��ֵ ����Ҳ���key��Ӧ��ֵ���򷵻�Ĭ��ֵ
	 * @return ������Ϣ
	 */
	public static String getPublicString(String key, String defaultValue) {
		Properties properties = getProperties(PUBLIC_PROPERTIES_RESOURCE);
		return getString(properties, key, defaultValue);
	}

	/**
	 * ��public��Դ��ȡָ������Ϣ�������滻����
	 * 
	 * @param key
	 *            �ؼ���
	 * @param args
	 *            ����ֵ
	 * @return ������Ϣ
	 */
	public static String getPublicString(String key, String[] args) {
		Properties properties = getProperties(PUBLIC_PROPERTIES_RESOURCE);
		return getString(properties, key, args);
	}

	/**
	 * ȡָ����Դ�ļ����ָ����Ϣ
	 * 
	 * @param bundleName
	 *            ��Դ�ļ�ȫ��
	 * @param key
	 *            �ؼ���
	 * @param args
	 *            ����ֵ
	 * @return ������Ϣ
	 */
	public static String getString(String bundleName, String key, String[] args) {
		Properties properties = getProperties(bundleName);
		return getString(properties, key, args);
	}

	/**
	 * ȡָ����Դ�ļ����ָ����Ϣ
	 * 
	 * @param bundleName
	 *            ��Դ�ļ�ȫ��
	 * @param key
	 *            �ؼ���
	 * @return ������Ϣ
	 */
	public static String getString(String bundleName, String key,
			String defaultValue) {
		Properties properties = getProperties(bundleName);
		return getString(properties, key, defaultValue);
	}

	/**
	 * ȡָ����Դ�ļ����ָ����Ϣ
	 * 
	 * @param bundleName
	 *            ��Դ�ļ�ȫ��
	 * @param key
	 *            �ؼ���
	 * @param defaultValue
	 *            Ĭ��ֵ ����Ҳ���key��Ӧ��ֵ���򷵻�Ĭ��ֵ
	 * @return ������Ϣ
	 */
	public static String getString(String bundleName, String key) {
		Properties properties = getProperties(bundleName);
		return getString(properties, key);
	}

	/**
	 * ȡָ����Դ�ļ����ָ����Ϣ
	 * 
	 * @param bundleName
	 *            ��Դ�ļ�ȫ��
	 * @param key
	 *            ����ؼ���
	 * @return ������Ϣ
	 */
	public static String toString(String bundleName, String[] key) {
		return toString(bundleName, key, MESSAGE_COMPART_SYMBOL);
	}

	/**
	 * ȡָ����Դ�ļ����ָ����Ϣ
	 * 
	 * @param bundleName
	 *            ��Դ�ļ�ȫ��
	 * @param key
	 *            ����ؼ���
	 * @param symbol
	 *            �ָ�����
	 * @return ������Ϣ
	 */
	public static String toString(String bundleName, String[] key, String symbol) {
		Properties properties = getProperties(bundleName);
		StringBuffer message = new StringBuffer("");
		if (key != null) {
			for (int i = 0; i < key.length; i++) {
				message.append(getString(properties, key[i]));
				message.append(symbol);
			}
		}
		return message.toString();
	}
}
