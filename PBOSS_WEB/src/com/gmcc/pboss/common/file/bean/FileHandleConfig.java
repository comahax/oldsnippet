package com.gmcc.pboss.common.file.bean;

import java.util.Map;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-10-21
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * �������ļ��������ö���
 */
public class FileHandleConfig{
	/**�ϴ��ļ�������Ϣ*/
	private Map uploadFiles;

	/**FTP��������Ϣ*/
	private ServerInfoBean server;
	
	public ServerInfoBean getServer() {
		return server;
	}
	public void setServer(ServerInfoBean server) {
		this.server = server;
	}
	/**�ϴ��ļ�������Ϣ*/
	public Map getUploadFiles() {
		return uploadFiles;
	}
	/**�ϴ��ļ�������Ϣ*/
	public void setUploadFiles(Map uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	
	
	
}
