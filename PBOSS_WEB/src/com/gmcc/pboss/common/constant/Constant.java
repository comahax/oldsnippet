package com.gmcc.pboss.common.constant;

import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.common.config.DataSourceConfigXMLHandle;
import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.config.exception.FileConfigException;
import com.gmcc.pboss.common.config.xml.IXmlHandle;
import com.gmcc.pboss.common.config.xml.impl.ConstantDictionaryXMLHandle;
import com.gmcc.pboss.common.config.xml.impl.ConstantLoadConfigXMLHandle;
import com.gmcc.pboss.common.constant.service.ConstantService;
import com.gmcc.pboss.common.context.ContextUtil;
import com.gmcc.pboss.common.dictionary.FileDictionary;
 
/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-12-24
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������ϵͳ�̶�������
 */
public class Constant {
	private static Logger logger = Logger.getLogger(Constant.class);
	
	public static ConstantService getConstantService(){
		ConstantService service = (ConstantService)ContextUtil.getContext().getBean("constantService");
		return service;
	}
	
	/**
	 * ���ݹ̶��������ͣ��жϸ������Ƿ��ǹ̶�������ʶ
	 * @param constantTtype �̶���������
	 * @return
	 */	
	public static boolean isConstantGroupid(String constantType){
		Map<String,String > groupidMap = getConstantGroupid();
		boolean isContains = groupidMap.containsKey(constantType);
		//logger.info(constantType + " �Ƿ��ǹ̶�������ʶ " +isContains);
		return isContains;
	}
	
	/**
	 * ��ù̶�������ʶ����
	 * @return
	 * 		Map<groupid, desc> <�̶�������ʶ������>
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,String> getConstantGroupid(){
		IXmlHandle handle = new ConstantLoadConfigXMLHandle();
		FileConfigAdapter fileConfig;
		Map<String, String> groupidMap = null;
		
		try {
			fileConfig = FileConfigAdapter.init();
			groupidMap = (Map<String, String>)fileConfig.loadProperty(FileDictionary.CONSTANT_LOAD, FileDictionary.CONSTANT_LOAD, handle);
			
		} 
		catch (FileConfigException e) {
			e.printStackTrace();
			logger.error("[ȡ�ļ��쳣]:"+e.getMessage());
		}
		
		return groupidMap;
	}
	
	
	/**
	 * ��ù̶���������
	 * @param constantTtype �̶���������
	 * @param key  			�̶�����key
	 * @return 				�̶���������
	 */
	public static String getConstantName(String constantType, String key){
		String name = null;
		if(isConstantGroupid(constantType)){
			name = getConstantNameFromCach(constantType, key);
		}
		else{
			name = getConstantNameFromXML(constantType, key);
		}
		return name;
	}
	
	/**
	 * ���ڴ��л�øò���������
	 * @param constantType 	�̶���������
	 * @param key			�̶�����key
	 * @return				�̶���������
	 */
	public static String getConstantNameFromCach(String constantType, String key){
		String name = null;
		ConstantService service = getConstantService();
		name = service.getConstantName(constantType, key);
		return name;
	}
	
	/**
	 * �ӹ̶����������ļ��л�øò���������
	 * @param constantType	�̶���������
	 * @param key 			�̶�����key
	 * @return				�̶���������
	 * 		  
	 */
	@SuppressWarnings("unchecked")
	public static String getConstantNameFromXML(String constantType, String key){
		String name = null;
		IXmlHandle handle = new ConstantDictionaryXMLHandle(); 
		
		try {
			FileConfigAdapter fileConfig = FileConfigAdapter.init();
			Map<String,String> constants = (Map<String,String>)fileConfig.loadProperty(FileDictionary.CONSTANTS_DICTIONARY, constantType, handle);
			
			if(constants != null && constants.containsKey(key)){
				name = (String)constants.get(key);
			}
			else{
				//name = "δ֪�̶�����["+ constantType +" :" + key + "]";
				name = key;
			}
		} 
		catch (FileConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	}
	
	/**
	 * ���ָ��key�Ĺ̶���������
	 * @param constantType	�̶���������
	 * @param key			��Ҫ��ȡ�Ĺ̶�����key
	 * @return				�̶���������<dictid,dictname>
	 */
	public static Map<String,String> getConstantsMapWithDictids(String constantType,String[]key){
		Map<String,String> constants = getConstantsMap(constantType);
		for(int i=0;i<key.length;i++){
			constants.remove(key[i]);
		}
		return constants;
	}
	
	/**
	 * ��ù̶���������
	 * @param constantType  �̶���������
	 * @return				�̶���������<dictid,dictname>
	 */
	public static Map<String, String> getConstantsMap(String constantType){
		Map<String,String> constants = null;
		if(isConstantGroupid(constantType)){
			constants = getConstantsMapFromCach(constantType);
		}
		else{
			constants = getConstantsMapFromXML(constantType);
		}
		return constants;
	}
	
	/**
	 * �������ļ��л�ù̶���������
	 * @param constantType	�̶���������
	 * @return				�̶���������<dictid,dictname>
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,String>getConstantsMapFromXML(String constantType){
		IXmlHandle handle = new ConstantDictionaryXMLHandle();
		Map<String,String> constants = null;
		try{
			FileConfigAdapter fileConfig = FileConfigAdapter.init();
			constants = (Map<String,String>)fileConfig.loadProperty(FileDictionary.CONSTANTS_DICTIONARY, constantType, handle);
		}
		catch (FileConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("[ȡ�ļ��쳣]:"+e.getMessage());
		}
		return constants;
	}
	
	public static Map<String,String>getConstantsMapFromCach(String constantType){
		
		ConstantService service = getConstantService();
		
		return service.getConstantMap(constantType);
	}
	
	public static Map<String,String[]> getXaProperties(){
		IXmlHandle handle = new DataSourceConfigXMLHandle();
		FileConfigAdapter fileConfig;
		Map<String, String[]> datsSourceMap = null;
		try {
			fileConfig = FileConfigAdapter.init();
			datsSourceMap = (Map<String, String[]>)fileConfig.loadProperty(FileDictionary.DATASOURSE_INFO, FileDictionary.DATASOURSE_INFO, handle);
		} catch (FileConfigException e) {
			e.printStackTrace();
			logger.error("[ȡ�ļ��쳣]:"+e.getMessage());
		}
		return datsSourceMap;
	}
	/**
	 * 
	 * �����뷵�ص����ӹ�˾������
	 * @param code ����
	 * @return ����
	 */
	public static String getCountyidchName(String code){
		return getConstantService().getCntcompanyName(code);
	}
}
