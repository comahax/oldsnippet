package com.sunrise.jop.common.utils.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

/**
 * User: JinBo
 * Date: 2005-12-28
 * Time: 8:48:17
 * I18nMessage������Ĺ��ʻ����Դ���
 */                 
public class I18nMessage {
	public static final String PUBLIC_RESOURCE_NAME = "public";
	
	
    /**
     * ȡָ����������Ϣ
     *
     * @param bundleName ��Դ������
     * @param key        �ؼ���
     * @return ������Ϣ
     */
    public static String getString(String bundleName, String key) {    	
        ResourceBundle rb = getResourceBundle(bundleName,null);

        return getString(rb, key);
    }
    
    /**
     * 
     * @param bundleName
     * @param key
     * @return
     */
    public static String getString(String bundleName, String key, Locale locale) {
        ResourceBundle rb = getResourceBundle(bundleName,locale);
        return getString(rb, key);
    }
    
    /**
     * ��public��Դ��ȡָ������Ϣ�������滻����
     * @param key �ؼ���
     * @param args ����ֵ
     * @return ��Ϣ
     */
    public static String getString(String bundleName, String key, String[] args){
    	return MessageFormat.format(getString(bundleName, key), args);
    }

    /**
     * ȡ��Դ�ļ����ָ����Ϣ
     *
     * @param rb  �Ѿ��򿪵���Դ�ļ�
     * @param key �ؼ���
     * @return ������Ϣ
     */
    public static String getString(ResourceBundle rb, String key) {
        String result = key;
        if (rb == null) return key;
        if ((key != null) && (key.length() != 0)) {
            try {
                result = rb.getString(key);
            } catch (MissingResourceException e) {
                result = key;
            }
        }
        return result;
    }

    /**
     * ����Դ�ļ�
     *
     * @param bundleName ��Դ�ļ�����
     * @return ��Դ�ļ�
     */
    private static ResourceBundle getResourceBundle(String bundleName,Locale locale) {
    	if( locale != null ){
    		return ResourceBundle.getBundle(bundleName,locale);
    	}
        return ResourceBundle.getBundle(bundleName);
    }
    
    /**
     * Public��Դ��ָ���ڸ�Ŀ¼�£�����ΪPublic����Դ�ļ�
     * @param key
     * @return
     */
    public static String getPublicString(String key){
    	return getString(PUBLIC_RESOURCE_NAME, key);
    }
}
