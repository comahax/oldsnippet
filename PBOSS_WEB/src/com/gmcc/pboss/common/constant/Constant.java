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
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-12-24
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：系统固定参数类
 */
public class Constant {
	private static Logger logger = Logger.getLogger(Constant.class);
	
	public static ConstantService getConstantService(){
		ConstantService service = (ConstantService)ContextUtil.getContext().getBean("constantService");
		return service;
	}
	
	/**
	 * 根据固定参数类型，判断该类型是否是固定参数标识
	 * @param constantTtype 固定参数类型
	 * @return
	 */	
	public static boolean isConstantGroupid(String constantType){
		Map<String,String > groupidMap = getConstantGroupid();
		boolean isContains = groupidMap.containsKey(constantType);
		//logger.info(constantType + " 是否是固定参数标识 " +isContains);
		return isContains;
	}
	
	/**
	 * 获得固定参数标识集合
	 * @return
	 * 		Map<groupid, desc> <固定参数标识，描述>
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
			logger.error("[取文件异常]:"+e.getMessage());
		}
		
		return groupidMap;
	}
	
	
	/**
	 * 获得固定参数名称
	 * @param constantTtype 固定参数类型
	 * @param key  			固定参数key
	 * @return 				固定参数名称
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
	 * 从内存中获得该参数的名称
	 * @param constantType 	固定参数类型
	 * @param key			固定参数key
	 * @return				固定参数名称
	 */
	public static String getConstantNameFromCach(String constantType, String key){
		String name = null;
		ConstantService service = getConstantService();
		name = service.getConstantName(constantType, key);
		return name;
	}
	
	/**
	 * 从固定参数配置文件中获得该参数的名称
	 * @param constantType	固定参数类型
	 * @param key 			固定参数key
	 * @return				固定参数名称
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
				//name = "未知固定参数["+ constantType +" :" + key + "]";
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
	 * 获得指定key的固定参数集合
	 * @param constantType	固定参数类型
	 * @param key			需要提取的固定参数key
	 * @return				固定参数集合<dictid,dictname>
	 */
	public static Map<String,String> getConstantsMapWithDictids(String constantType,String[]key){
		Map<String,String> constants = getConstantsMap(constantType);
		for(int i=0;i<key.length;i++){
			constants.remove(key[i]);
		}
		return constants;
	}
	
	/**
	 * 获得固定参数集合
	 * @param constantType  固定参数类型
	 * @return				固定参数集合<dictid,dictname>
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
	 * 从配置文件中获得固定参数集合
	 * @param constantType	固定参数类型
	 * @return				固定参数集合<dictid,dictname>
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
			logger.error("[取文件异常]:"+e.getMessage());
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
			logger.error("[取文件异常]:"+e.getMessage());
		}
		return datsSourceMap;
	}
	/**
	 * 
	 * 按代码返回地市子公司的名称
	 * @param code 代码
	 * @return 名称
	 */
	public static String getCountyidchName(String code){
		return getConstantService().getCntcompanyName(code);
	}
}
