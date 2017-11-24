package com.sunrise.jop.common.spring;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.sunrise.jop.common.encrypt.DESCrypterandDecrypter;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;

public class DecryptPropertyPlaceholderConfigurer   
        extends PropertyPlaceholderConfigurer {
	
	protected String jopCoreConfig;
	
	public String getJopCoreConfig() {
		return jopCoreConfig;
	}

	public void setJopCoreConfig(String jopCoreConfig) {
		this.jopCoreConfig = jopCoreConfig;
		if(!StringUtils.isEmpty(jopCoreConfig)){
			String absPath = CoreConfigInfo.getRuntimeParam(jopCoreConfig);
			
			if(StringUtils.isNotEmpty(absPath)){
				
				String[] paths = absPath.split(",");
				Resource[] locations = new Resource[paths.length];	
				for (int i = 0; i < locations.length; i++) {
					locations[i] = new FileSystemResource(new File(paths[i]));
				}
				setLocations(locations);
			}
		}
	}

	protected File[] absolutedLocation;
	
	public File[] getAbsolutedLocation() {
		return absolutedLocation;
	}

	public void setAbsolutedLocation(File[] absolutedLocation) {
		
		this.absolutedLocation = absolutedLocation;
		Resource[] locations = new Resource[absolutedLocation.length];	
		for (int i = 0; i < locations.length; i++) {
			locations[i] = new FileSystemResource(absolutedLocation[i]);
		}
		
		setLocations(locations);
	}
    
    @Override
    protected void loadProperties(Properties props) throws IOException {
		super.loadProperties(props);
	}
    
    protected String parseStringValue(String strVal, Properties props, Set visitedPlaceholders)
    throws BeanDefinitionStoreException {
		int startIndex = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
		int endIndex = strVal.indexOf(ENCRYPT_PLACEHOLDER_SUFFIX);
		if(startIndex == 0 && (endIndex == strVal.length() - 2)){
			String placeholder = strVal.substring(startIndex + this.encryptPlaceholderSuffix.length(), endIndex);
			placeholder = parseStringValue(placeholder, props, visitedPlaceholders);
			String propVal = props.getProperty(placeholder);
			
			try {
				DESCrypterandDecrypter des = new DESCrypterandDecrypter();
				propVal = des.decrypt(propVal);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return propVal;
    	}else{
    		return super.parseStringValue(strVal, props, visitedPlaceholders);
    	}
    }
    
    public static final String ENCRYPT_PLACEHOLDER_SUFFIX = "}*";
    
    private String encryptPlaceholderSuffix = ENCRYPT_PLACEHOLDER_SUFFIX;

}   
