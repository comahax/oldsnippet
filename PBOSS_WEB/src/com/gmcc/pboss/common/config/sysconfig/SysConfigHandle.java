package com.gmcc.pboss.common.config.sysconfig;

import java.io.UnsupportedEncodingException;
import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.config.exception.FileConfigException;


/**
 * Copyright(C)  ���ݴ��˵��ӿ������޹�˾-��������ҵ��
 *
 * Module: ��ȡϵͳ�����ļ�
 * @author libo
 * @version
 * @see
 * @since 2008-11-23
 * @description: ����վ�ĸ��ֿ�������Ϣ��д������ļ���ͳһ����
 * @log: 
 */
public class SysConfigHandle {
    
    private static final String SYS_CONFIG_FILE_CODE = "SYS_CONFIG";
    
    /**
     * @description: ���ݲ���������ȡ��ϵͳ�����ļ����ֵ����û�и�ֵʱ���ؿ�
     * @param: property ������
     * @return: String ��Ӧ��ֵ
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
