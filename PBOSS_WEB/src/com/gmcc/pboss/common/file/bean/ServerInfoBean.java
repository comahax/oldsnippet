package com.gmcc.pboss.common.file.bean;

import java.util.Hashtable;
import java.util.Map;

import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.config.exception.FileConfigException;
import com.gmcc.pboss.common.config.xml.IXmlHandle;
import com.gmcc.pboss.common.config.xml.impl.FileHandleConfigXmlHandle;

public class ServerInfoBean {

	/**FTP服务器IP*/
	private String ip;
	/**FTP服务器端口*/
	private int port;
	/**FTP登录用户名*/
	private String username;
	/**FTP登录密码*/
	private String password;
	/**FTP当前目录*/
	private String workdir;
	
	private static ServerInfoBean info = null;
	
	public static ServerInfoBean getInstance() {
		if(info == null) {
			IXmlHandle handle = new FileHandleConfigXmlHandle();
			FileConfigAdapter fileConfig;
			FileHandleConfig config = null;
			try {
				fileConfig = FileConfigAdapter.init();
				config = (FileHandleConfig)fileConfig.loadProperty("FILE_HANDLE", "FILE_HANDLE", handle);
				info = config.getServer();
			} 
			catch (FileConfigException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return info;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWorkdir() {
		return workdir;
	}
	public void setWorkdir(String workdir) {
		this.workdir = workdir;
	}
	
}
