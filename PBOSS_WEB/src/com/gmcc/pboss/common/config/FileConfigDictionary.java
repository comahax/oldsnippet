package com.gmcc.pboss.common.config;

public class FileConfigDictionary {
    
    /**
     * �����ļ�������ΪXML�ļ�
     */
    public static final String FILE_TYPE_XML = "XML";
    
    /**
     * �����ļ�������Ϊ�����ļ�
     */
    public static final String FILE_TYPE_PROPERTIES = "PROPERTIES";
    
    /**
     * ÿ�����һ��
     */
    public static final String UPDATE_TYPE_ONCE_DAY = "ONCE_DAY";
    
    /**
     * ÿСʱ����һ��
     */
    public static final String UPDATE_TYPE_ONCE_HOUR = "ONCE_HOUR";
    
    /**
     * �������ļ����޸�ʱ�����
     */
    public static final String UPDATE_TYPE_FILE_MODIFIED = "FILE_MODIFIED";
    
    /**
     * ֻ����һ��
     */
    public static final String UPDATE_TYPE_ONCE_ONLY = "ONCE_ONLY";
    
    /**
     * �ļ����õ�·��
    public static final String FILE_CONFIG_PATH = "/AppLog/Config/BizEngine_Config/FileConfig.xml";
    */
    public static void main(String[]args){
    	System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
    }
    
}
