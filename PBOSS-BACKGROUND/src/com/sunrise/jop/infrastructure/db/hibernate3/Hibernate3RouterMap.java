package com.sunrise.jop.infrastructure.db.hibernate3;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;

/**
 * 对应sessionFactoryRouter里面的名字,用于spring bean的多数据源注册
 * @author Canigar
 *	
 */
public class Hibernate3RouterMap {
	
	private static Log log = LogFactory.getLog(Hibernate3RouterMap.class); 
	
	private static String dpMapConfig;
	private static String commonDaoMapConfig;
	
	private static HashMap<String,String> dbMap = new HashMap<String, String>();
	private static HashMap<String,String> commonDaoMap = new HashMap<String, String>();
	
	static{
		try {
			InputStream in = Hibernate3RouterMap.class.getResourceAsStream(CoreConfigInfo.CITYID_MAPPING_FILE_PATH);
			Properties properties = new Properties();
			properties.load(in);
			in.close();
			dbMap = new HashMap(properties);

			in = Hibernate3RouterMap.class.getResourceAsStream(CoreConfigInfo.COMMON_DAO_FILE_PATH);
			properties = new Properties();
			properties.load(in);
			in.close();
			commonDaoMap = new HashMap(properties);			
		} catch (Exception ex) {
			log.fatal("SessionFactoryRouter init error!", ex);
			LoggerUtils.error(ex, log);
			System.out.println("*********************************");
			System.out.println("SessionFactoryRouter init error!");
			System.out.println("*********************************");
			System.err.println("*********************************");
			System.err.println("SessionFactoryRouter init error!");
			System.err.println("*********************************");
		}
		
	}
	
	public static String getCityRouter(String cityid){
		return dbMap.get(cityid);
	}
	
	/*
	 * 判断是否包含COMMON库里面的VO
	 */
	public static boolean containsCommonVO(String vo){
		return commonDaoMap.containsKey(vo);
	}

	/**
	 * 判断voClass是否对应COMMON库里面的库表,如何是的话返回"DB_COMMON",否则的话返回dbFlag
	 */
	public static String checkIsCommonDB(Class voClass, String dbFlag) {
		return checkIsCommonDB(voClass.getName(),dbFlag);
	}
	
	/**
	 * 判断voName是否对应COMMON库里面的库表,如何是的话返回"DB_COMMON",否则的话返回dbFlag
	 */
	public static String checkIsCommonDB(String voName, String dbFlag) {
		if(containsCommonVO(voName)){
			return "DB_COMMON";
		}else{
			return dbFlag;
		}
	}
	

	public String getDpMapConfig() {
		return dpMapConfig;
	}

	public void setDpMapConfig(String dpMapConfig) {
		this.dpMapConfig = dpMapConfig;
	}

	public String getCommonDaoMapConfig() {
		return commonDaoMapConfig;
	}

	public void setCommonDaoMapConfig(String commonDaoMapConfig) {
		this.commonDaoMapConfig = commonDaoMapConfig;
	}
}



