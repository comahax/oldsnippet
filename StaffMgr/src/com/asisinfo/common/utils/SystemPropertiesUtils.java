package com.asisinfo.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;


/**
 * @ClassName SystemPropertiesUtils
 * @Description 系统参数帮助类
 * 
 */
public class SystemPropertiesUtils
{
	public static final Logger LOGGER = Logger.getLogger(SystemPropertiesUtils.class);
	
	private static Properties properties;
	
	static{
		try {
			InputStream input = new ClassPathResource("system.properties").getInputStream();
			properties = new Properties();
			properties.load(input);
			IOUtils.closeQuietly(input);
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.error("加载资源失败",e);
		}
	}
	
	/**
	  * 根据属性文件键获取相应的值，若无，则返回空
	  * @param key 属性文件中的键
	  * @return 相应键对应的值
	  * @throws IOException 文件读取错误
	  */
	public static String getSystemPropertiesStringValue(String key)
	{
		Assert.notNull(key, "系统属性键不能为空。");
		String value = properties.getProperty(key);
		
		return StringUtils.hasLength(value) ? value : "";
	}
	
	/**
	  * 根据属性文件键获取相应的值，若无，则返回默认值
	  * @param key 属性文件中的键
	  * @param defaultValue 若无相应值，则返回给定的默认值
	  * @return 属性值
	  */
	public static String getSystemPropertiesStringValue(String key, String defaultValue)
	{
		Assert.notNull(key, "系统属性键不能为空。");
		String value = properties.getProperty(key);
		
		return StringUtils.hasLength(value) ? value : defaultValue;
	}
	
	/**
	  * 根据属性文件键获取相应的值，若无，则返回默认值
	  * @param key 属性文件中的键
	  * @param defaultValue 若无相应值，则返回给定的默认值
	  * @return 属性值
	  */
	public static int getSystemPropertiesIntValue(String key, int defaultValue)
	{
		Assert.notNull(key, "系统属性键不能为空。");
		String value = properties.getProperty(key);
		
		int propertyIntValue = defaultValue;
		if (StringUtils.hasLength(value))
		{
			try
            {
	            propertyIntValue = Integer.parseInt(value);
            }
            catch (NumberFormatException e)
            {
	            LOGGER.error("系统属性【" + key +"】获取属性值错误，将使用默认值【" + propertyIntValue + "】。" , e);
            }
		}
		
		return  propertyIntValue;
	}
}
