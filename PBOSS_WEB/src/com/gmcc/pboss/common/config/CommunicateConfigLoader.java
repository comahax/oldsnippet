package com.gmcc.pboss.common.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommunicateConfigLoader {
	static public Properties PROPS = new Properties();
	static{
		String path = FileConfigAdapter.getCommonPath()+"/"+"communicate.properties";
		File file = new File(path);
		if(file.exists()){
			try{
				PROPS.load(new FileInputStream(file));		
			}catch (IOException e) {}
		}
	}
}