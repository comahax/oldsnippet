package com.gmcc.pboss.BgProcess.promotion;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.common.netfile.NetFileHandle;
import com.gmcc.pboss.common.netfile.server.ServerAccess;
import com.gmcc.pboss.common.netfile.server.impl.FTPServerAccess;
import com.gmcc.pboss.common.netfile.server.info.FtpInfo;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;

/**
 * 将BI提供的考核客户数文件下载到PBOSS本地机器上
 * @author zsw
 *
 */
public class PromotionsDownloadBIFileFromFTP extends BgBase{

	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		PromotionsDownloadBIFileFromFTP pro = new PromotionsDownloadBIFileFromFTP();
		
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		
		pro.setMyProfilePath("/promotionGatherData.properties");
		pro.init(args);
		pro.downloadFiles(args[0],args[1]);
	}
	
	protected void init(String[] args) throws Exception {
		
		String cityid = args[0];
		// 加载个性化配置
		if (myProfilePath != null) {
			InputStream is = BgBase.class.getResourceAsStream(myProfilePath);
			properties.load(is);
			is.close();
		}

		// 初始化log
		String logFilename = properties.getProperty("BIFile_"+cityid+"_log");

		BasicConfigurator.configure();
		Logger logger = Logger.getRootLogger();
		DailyRollingFileAppender appender = (DailyRollingFileAppender) logger.getAppender("FILE");
		Date today = new Date();
		appender.setFile((logFilename + "." + (new SimpleDateFormat("yyMMdd")).format(today)));
		appender.activateOptions();

		logger.info("------log file changed to " + logFilename + " ---------------");
		StringBuffer sb = new StringBuffer();
		for (String arg : args) {
			sb.append("[").append(arg).append("] ");
		}
		logger.info(sb);
		log = logger;
		
	}
	public void downloadFiles(String cityid, String busiMonth) throws Exception {
		FtpInfo ftpinfo = FtpInfo.getInstance();
		ServerAccess serverAccess = new FTPServerAccess(ftpinfo);
		NetFileHandle fileHandle = new NetFileHandle(serverAccess);
		try {
			fileHandle.connect(ftpinfo.ftpServer, ftpinfo.ftpPort);
			if(!fileHandle.login(ftpinfo.ftpUser, ftpinfo.ftpPwd)) {
				throw new Exception("FTP 登录用户或密码错误，请核实");
			}
			String regex = "bi_asscust_"+busiMonth+"00_"+cityid+"_[0-9]{3}"+"_00.txt";
			String[] remotefiles = fileHandle.getFilesByNameRegex(ftpinfo.curSerPath, regex);
			String localPath = properties.getProperty(cityid+"_asscust_path");
			fileHandle.downloadFiles(localPath, remotefiles);
			
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}finally {
			try {
				fileHandle.logout();
				fileHandle.disconnect();
			}catch(Exception ex) {
				LoggerUtils.error(ex, log);
			}
		}
	}
	
	/*public String generateBIFileNameRegex(String busiMonth) {
		Map<String,String> citymap = CityMappingUtil.getMap();
		Set<String> cityIdSet = citymap.keySet();
		StringBuffer temp = new StringBuffer();
		for(String cityid : cityIdSet) {
			temp.append(cityid).append("|");
		}
		String cityids = temp.substring(0, temp.length()-1);
		String regex = "bi_asscust_"+busiMonth+"00_("+cityids+")_[0-9]{3}"+"_00.txt";
		return regex;
	}*/
	
	protected boolean checkArgs(String[] args) {
		if (args.length < 2) {
			System.out.println(getHelp());
			return false;
		}
		if (!CityMappingUtil.contain(args[0])) {
			System.out.println("cityid is not exist");
			return false;
		}
		return true;
	}
	
	protected static String getHelp() {
		StringBuffer sb = new StringBuffer();
		sb.append("Explain of args:").append("\n");
		sb.append("the args number is 2").append("\n");
		sb.append("[cityid][businessMonth]").append("\n");
		sb.append("e.g. [ZS][200908]");
		return sb.toString();
	}

}
