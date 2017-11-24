package com.gmcc.pboss.common.config.sysconfig;

import java.io.UnsupportedEncodingException;
import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.config.exception.FileConfigException;


/**
 * Copyright(C)  广州从兴电子开发有限公司-电子渠道业务部
 *
 * Module: 读取系统配置文件
 * @author libo
 * @version
 * @see
 * @since 2008-11-23
 * @description: 把网站的各种可配置信息都写在这个文件，统一管理
 * @log: 
 */
public class SysConfigHandle {
    
    private static final String SYS_CONFIG_FILE_CODE = "SYS_CONFIG";
    
    /**
     * @description: 根据参数名来获取在系统配置文件里的值，当没有该值时返回空
     * @param: property 参数名
     * @return: String 对应的值
     * @throws: 
     */
    public static String loadProperty(String property){
        String value = null;
        try {
            FileConfigAdapter fileConfig = FileConfigAdapter.init();
            value = (String)fileConfig.loadProperty(SYS_CONFIG_FILE_CODE, property, null);
            if(value != null){
                value = new String(value.getBytes("ISO-8859-1"), "GBK");
            }
            return value;
        } catch (FileConfigException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(SysConfigHandle.loadProperty(args[0]));
    }
}
