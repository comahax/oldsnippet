package com.gmcc.pboss.common.file.bean;

import java.util.Map;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-21
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：文件处理配置对象
 */
public class FileHandleConfig{
	/**上传文件配置信息*/
	private Map uploadFiles;

	/**FTP服务器信息*/
	private ServerInfoBean server;
	
	public ServerInfoBean getServer() {
		return server;
	}
	public void setServer(ServerInfoBean server) {
		this.server = server;
	}
	/**上传文件配置信息*/
	public Map getUploadFiles() {
		return uploadFiles;
	}
	/**上传文件配置信息*/
	public void setUploadFiles(Map uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	
	
	
}
