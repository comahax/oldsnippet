package com.asisinfo.staff.timer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

import com.asisinfo.staff.bean.KmConfig;
import com.asisinfo.staff.bean.KmConfigs;

public class FtpUtil {
	
    private  static Logger logger = Logger.getLogger(FtpUtil.class);
	
	private static Properties pro = new Properties();
	
	private static void init() {
		BufferedInputStream is = null;
		String path = null;
		try {
			URL url = FtpUtil.class.getResource("/pathinfo.properties");
			path = url.getPath();
			path = URLDecoder.decode(path, "GBK");
			path = path.replace('/', File.separatorChar).replace('\\',File.separatorChar);
			File f = new File(path);
			boolean b = f.exists();
			if (b) {
				is = new BufferedInputStream(new FileInputStream(f));
				pro.load(is);
			} else {
				logger.error("pathinfo.properties===配置文件不存在:" + f);
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("pathinfo.properties ===" + e.toString(), e);
		} catch (IOException e) {
			logger.error("pathinfo.properties ===" + e.toString(), e);
		} catch (Exception e) {
			logger.error("pathinfo.properties ===" + e.toString(), e);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}
	
	public static String upLoadFileFtp(String fileName){    
		     init();
		    //fileNamePath   上传的路径地址
		    String fileNamePath = pro.getProperty("uploadFile.oldfilePath")+ File.separator;
		    //ftp服务器地址
		    String ftpHost= pro.getProperty("uploadFile.ftpHostfilePath")+ File.separator; 
		    // FTP服务器端口号
		    String port = pro.getProperty("uploadFile.portfilePath")+ File.separator;  
		    //FTP登录帐号
		    String userName = pro.getProperty("uploadFile.userNamefilePath")+ File.separator;
		    //FTP登录密码
		    String passWord = pro.getProperty("uploadFile.passWordfilePath")+ File.separator;
		    //FTP服务器文件目录
            String path = pro.getProperty("uploadFile.filePath")+ File.separator;
            FTPClient ftpClient = new FTPClient();
            FileInputStream fis = null;
            String returnMessage = "0";
           // FtpClient ftpClient = new FtpClient(ftpHost, port);// ftpHost为FTP服务器的IP地址，port为FTP服务器的登陆端口,ftpHost为String型,port为int型。    
        try {
	            ftpClient.connect(ftpHost, Integer.parseInt(port));
	           // ftpClient.login(userName, passWord);// userName、passWord分别为FTP服务器的登陆用户名和密码    
	            boolean loginResult = ftpClient.login(userName, passWord);
	            int returnCode = ftpClient.getReplyCode();
       	 if (loginResult && FTPReply.isPositiveCompletion(returnCode)) {
	            ftpClient.makeDirectory(path);  
	            ftpClient.changeWorkingDirectory(path);// path为FTP服务器上保存上传文件的路径。    
	            ftpClient.setBufferSize(1024);
	            ftpClient.setControlEncoding("UTF-8");
	            ftpClient.enterLocalPassiveMode();
	            //* @param pathname FTP服务器保存目录
	            //* @param fileName 上传到FTP服务器后的文件名称
	            File file = new File(fileNamePath);
	   		    String test[];
	   		    test=file.list();  
   		    for(int i=0;i<test.length;i++)
   		    {
   		    	fileName=test[i];
   		    }
	            fis = new FileInputStream(fileNamePath+fileName);  
	            ftpClient.storeFile(fileName, fis);
	
	       	    returnMessage = "1"; // 上传成功
       	 } else {// 如果登录失败
       	      returnMessage = "0";
       	 }
       	 } catch (Exception e) {
       	    e.printStackTrace();
       	 throw new RuntimeException("FTP客户端出错！", e);
       	 } finally {
       	 // IOUtils.closeQuietly(fis);
       	 try {
       	    ftpClient.disconnect();
       	 } catch (Exception e) {
       	    e.printStackTrace();
       	 throw new RuntimeException("关闭FTP连接发生异常！", e);
       	 }
       	 }
       	 return returnMessage; 
      }
	

	
	 /**
	 * 下载文件
	 * @param hostname FTP服务器地址
	 * @param port FTP服务器端口号
	 * @param username FTP登录帐号
	 * @param password FTP登录密码
	 * @param pathname FTP服务器文件目录
	 * @param filename 文件名称
	 * @param localpath 下载后的文件路径
	 * @return
	 * @throws IOException 
	 */
	 public static boolean downloadFile() throws IOException{
		 init();
	    boolean flag = false;
	    //localpath 下载后的文件路径
        String localpath = pro.getProperty("downloadFile.newfilePath")+ File.separator;
        //ftp服务器地址
        String ftpHost= pro.getProperty("uploadFile.ftpHostfilePath")+ File.separator;   
        // FTP服务器端口号
        String port = pro.getProperty("uploadFile.portfilePath")+ File.separator;
        //FTP登录帐号
        String userName = pro.getProperty("uploadFile.userNamefilePath")+ File.separator; 
        //FTP登录密码
        String passWord = pro.getProperty("uploadFile.passWordfilePath")+ File.separator; 
        //FTP服务器文件目录
        String path = pro.getProperty("uploadFile.filePath")+ File.separator;
        //filename 文件名称
        String filename=null;
     
		 FTPClient ftpClient = new FTPClient();
		 try {
		 //连接FTP服务器
		ftpClient.connect(ftpHost, Integer.parseInt(port));
		 //登录FTP服务器
		boolean loginResult = ftpClient.login(userName, passWord);
		// ftpClient.login(username, password);
		 //验证FTP服务器是否登录成功
		 int replyCode = ftpClient.getReplyCode();
		 if(!FTPReply.isPositiveCompletion(replyCode)){
		 return flag;
		 }
		 //切换FTP目录 
	     ftpClient.changeWorkingDirectory(path);// path为FTP服务器上保存上传文件的路径。
		 // ftpClient.changeWorkingDirectory(path);
		 FTPFile[] ftpFiles = ftpClient.listFiles();
		 //获取
		 for(FTPFile file : ftpFiles){
//	     if(filename.equalsIgnoreCase(file.getName())){
		 if(filename.startsWith("STAFF_BILL") && filename.equalsIgnoreCase(file.getName())){
		 File localFile = new File(localpath + "/" + file.getName());
		 OutputStream os = new FileOutputStream(localFile);
		 ftpClient.retrieveFile(file.getName(), os);
		 os.close();
		 }
		 }
		 ftpClient.logout();
		 flag = true;
		 } catch (Exception e) {
		 e.printStackTrace();
		 } finally{
		 if(ftpClient.isConnected()){
			 try {
			 ftpClient.logout();
			 } catch (IOException e) {
			  
			 }
		 }
		 }
		 return flag;
		 }
}
