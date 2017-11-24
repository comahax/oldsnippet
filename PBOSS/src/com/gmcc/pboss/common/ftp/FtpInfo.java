package com.gmcc.pboss.common.ftp;

import com.sunrise.jop.infrastructure.config.CoreConfigInfo;

public class FtpInfo {

	public String ftpServer; // ftp������ip

	public int ftpPort; // ftp�������˿�

	public String ftpUser; // ftp��½�û���

	public String ftpPwd; // ftp��½����

	public String curSerPath; // ftp��������ǰĿ¼

	public int timeout; // ��ʱʱ��

	private static FtpInfo info = null;

	public static FtpInfo getInstance() throws Exception {
		if (info == null) {
			info = new FtpInfo();
			info.ftpServer = CoreConfigInfo.FTP_ADDRESS;
			info.ftpPort = Integer.parseInt(CoreConfigInfo.FTP_PORT);
			info.ftpUser = CoreConfigInfo.FTP_USER;
			info.ftpPwd = CoreConfigInfo.FTP_PASSWORD;
			info.curSerPath = CoreConfigInfo.FTP_WORK_DIR;

			info.timeout = 3000;
		}

		return info;
	}

	public static String getUpload() throws Exception {
		return CoreConfigInfo.UPLOAD_LOCATION;
	}

	public static String getDownload() throws Exception {
		return CoreConfigInfo.DOWNLOAD_LOCATION;
	}
}
