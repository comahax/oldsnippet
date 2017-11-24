package com.sunrise.boss.ui.commons.ftp;

import java.util.ResourceBundle;

import com.sunrise.boss.common.utils.sysinfo.SysInfo;

public class FtpInfo {

    public String ftpServer; // ftp������ip

    public int ftpPort; // ftp�������˿�

    public String ftpUser; // ftp��½�û���

    public String ftpPwd; // ftp��½����

    public String curSerPath; // ftp��������ǰĿ¼

    public int timeout; // ��ʱʱ��

    private static FtpInfo info = null;
    
    private static ResourceBundle rs = null;

    public static FtpInfo getInstance() throws Exception {
        if (info == null) {
        	rs = ResourceBundle.getBundle("sysinfo");
            info = new FtpInfo();
            info.ftpServer=rs.getString("ftp.address");
            info.ftpPort=Integer.parseInt(rs.getString("ftp.port"));
            info.ftpUser=rs.getString("ftp.user");
            info.ftpPwd=rs.getString("ftp.password");
            info.curSerPath=rs.getString("ftp.workdir");
            /*info.ftpServer = SysInfo.FTP_ADDRESS;
            info.ftpPort = SysInfo.FTP_PORT;
            info.curSerPath = SysInfo.FTP_WORKDIR;
            info.ftpUser = SysInfo.FTP_USER;
            info.ftpPwd = SysInfo.FTP_PASSWORD;*/
//			info.ftpServer = "180.200.3.170";
//			info.ftpPort = 2100;
//			info.ftpUser = "cx-zcj";
//			info.ftpPwd = "abc123";
//			info.curSerPath = "/home/csz/cx-zcj/";
            info.timeout = 3000;
        }

        return info;
    }
}
