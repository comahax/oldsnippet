package com.gmcc.pboss.common.config;

public class FileConfigDictionary {
    
    /**
     * 配置文件的类型为XML文件
     */
    public static final String FILE_TYPE_XML = "XML";
    
    /**
     * 配置文件的类型为属性文件
     */
    public static final String FILE_TYPE_PROPERTIES = "PROPERTIES";
    
    /**
     * 每天更新一次
     */
    public static final String UPDATE_TYPE_ONCE_DAY = "ONCE_DAY";
    
    /**
     * 每小时更新一次
     */
    public static final String UPDATE_TYPE_ONCE_HOUR = "ONCE_HOUR";
    
    /**
     * 更根据文件的修改时间更新
     */
    public static final String UPDATE_TYPE_FILE_MODIFIED = "FILE_MODIFIED";
    
    /**
     * 只加载一次
     */
    public static final String UPDATE_TYPE_ONCE_ONLY = "ONCE_ONLY";
    
    /**
     * 文件配置的路径
    public static final String FILE_CONFIG_PATH = "/AppLog/Config/BizEngine_Config/FileConfig.xml";
    */
    public static void main(String[]args){
    	System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
    }
    
}
