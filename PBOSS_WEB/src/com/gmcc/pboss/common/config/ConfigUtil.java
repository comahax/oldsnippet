package com.gmcc.pboss.common.config;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.gmcc.pboss.common.bean.URLAuthority;
import com.gmcc.pboss.common.config.bean.PendingTaskConfigBean;
import com.gmcc.pboss.common.config.exception.FileConfigException;
import com.gmcc.pboss.common.config.xml.IXmlHandle;
import com.gmcc.pboss.common.config.xml.impl.ConstantDictionaryXMLHandle;
import com.gmcc.pboss.common.config.xml.impl.ConstantLoadConfigXMLHandle;
import com.gmcc.pboss.common.config.xml.impl.PendingTaskXmlHandleImpl;
import com.gmcc.pboss.common.config.xml.impl.URLAuthorityHandle;
import com.gmcc.pboss.common.dictionary.FileDictionary;
import com.gmcc.pboss.common.dictionary.Regex;
import com.gmcc.pboss.common.service.ServiceCode;

/**
 * ���˹�˾��������ҵ��
 * 
 * @author tangzhu
 * @date 2009-7-31 ������Ŀ�� ����ģ�飺 ������
 */
public class ConfigUtil {
	private static Logger logger = Logger.getLogger(ConfigUtil.class);

	/**
	 * ����ҵ������ҵ�񷵻����ѯ��Ϣ��ʾ��Ϣ
	 * 
	 * @param serviceCode
	 * @param retCode
	 * @return
	 */
	public static String getMessage(String serviceCode, int retCode) {
		String message = null;
		try {
			FileConfigAdapter fileConfig = FileConfigAdapter.init();

			if (retCode < 100) {
				serviceCode = ServiceCode.COMMON;
			}
			StringBuffer flage = new StringBuffer();
			flage.append(serviceCode).append(Regex.UNDERLINE).append(retCode);

			message = (String) fileConfig.loadProperty(FileDictionary.MESSAGE_NAME, flage.toString(), null);

			if (message == null) {
				message = "δ֪����[" + flage.toString() + "]!";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception>>>>>" + e.getMessage());
			message = "ϵͳ��æ�����Ժ����ԣ�";
		}
		return message;
	}
	/**
	 * �õ�ĳ�������ļ��е���Ϣ
	 * @return
	 */
	public static String getCommonConfig(String fileName, String code){
		String msg = null;
		
		try {
			FileConfigAdapter fileConfig = FileConfigAdapter.init();
			msg = (String) fileConfig.loadProperty(fileName, code, null);
			if(msg != null){
				//msg = new String(msg.getBytes("ISO-8859-1"),"GBK");
			}else{
				msg = "δ֪����["+code+"]!";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception>>>>>" + e.getMessage());
			msg = "ϵͳ��æ�����Ժ����ԣ�";
		}
		
		return msg;
	}
	
	
	
	/**
	 * ���URLȨ��Bean
	 * @return
	 */
	public static URLAuthority getURLAuthority(){
		IXmlHandle handle = new URLAuthorityHandle();
		URLAuthority bean = null;
		try {
			FileConfigAdapter fileConfig = FileConfigAdapter.init();
			bean = (URLAuthority)fileConfig.loadProperty(FileDictionary.URL_AUTHORITY, "URL_AUTHORITY", handle);
		} catch (FileConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

	public static String getPageLocation(String key){
		String msg = "";
		try {
			FileConfigAdapter fileConfig = FileConfigAdapter.init();
			msg = (String) fileConfig.loadProperty(FileDictionary.PAGELOCTION_FILE, key, null);
			if (msg==null){
				msg="";
			}
		}catch(Exception e){
			msg="";
			logger.error("[ȡLocation�쳣]:"+e.getMessage());
		}
		return msg;
	}
	
	/**
	 * ��ô�������������Ϣ��
	 * @param name
	 * @return
	 */
	public static PendingTaskConfigBean getPendingTaskConfigByName(String name){
		IXmlHandle handle = new PendingTaskXmlHandleImpl();
		PendingTaskConfigBean bean = null;
		FileConfigAdapter fileConfig;
		try {
			fileConfig = FileConfigAdapter.init();
			Map<String,PendingTaskConfigBean> taskes = (Map<String,PendingTaskConfigBean>)
													fileConfig.loadProperty("PENDINGTASK_FILE", "PENDINGTASK_FILE", handle);
			bean = taskes.get(name);
		} catch (FileConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bean;
	}
}
