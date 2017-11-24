package com.gmcc.pboss.common.netfile.server.info;

import java.io.InputStream;
import java.util.Properties;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;

public class FtpInfo {

	public String ftpServer; // ftp������ip

	public int ftpPort; // ftp�������˿�

	public String ftpUser; // ftp��½�û���

	public String ftpPwd; // ftp��½����

	public String curSerPath; // ftp��������ǰĿ¼

	public int timeout; // ��ʱʱ��
	
	public String dowloadLocation; // ���ش��·��

	private static FtpInfo info = null;

	public static FtpInfo getInstance() throws Exception {
		if (info == null) {
			Properties properties = new Properties();
			InputStream is = BgBase.class.getResourceAsStream("/ftp.properties");
			properties.load(is);
			is.close();
			info = new FtpInfo();
			info.ftpServer = properties.getProperty("ftp.address");
			info.ftpPort = Integer.parseInt(properties.getProperty("ftp.port"));
			info.ftpUser = properties.getProperty("ftp.user");
			info.ftpPwd = properties.getProperty("ftp.password");
			info.curSerPath = properties.getProperty("ftp.work.dir");
			info.dowloadLocation = properties.getProperty("ftp.download.location");
			
			info.timeout = 3000;
		}

		return info;
	}

}
