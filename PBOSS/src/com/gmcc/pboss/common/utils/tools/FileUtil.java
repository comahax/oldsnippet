package com.gmcc.pboss.common.utils.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.common.ftp.FtpInfo;

public class FileUtil {
	/**
	 * 建立新文件路径
	 * @param docFileName 
	 * @param createNew 是否要生成新文件名的标识
	 * @return
	 * @throws Exception
	 */
	public static String createFilename(String docFileName,boolean createNew)
			throws Exception {
		String location = FtpInfo.getUpload();
		if (location == null || location.equals("")) {
			throw new RuntimeException(
					"文件路径没有设置，请检阅sysinfo.properties中uploadlocation的配置!");
		}
		int strLength = location.length();
		String pathSeperator = location.substring(strLength - 1, strLength);
		location = ServletActionContext.getServletContext().getRealPath(location);
		if (!location.endsWith(pathSeperator)) {
			location = location + pathSeperator;
		}
		location = location.replace('\\', '/');
		String prefix = "";
		if(createNew) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			String dateStr = format.format(new Date());
			// 在文件名前增加前缀:yyyyMMddHHmmssXXXX_(XXXX为四位随机数)
			prefix = dateStr + (new java.util.Random()).nextInt(9999)+"_";
		}
		String destFilePath = location + prefix + docFileName;
		return destFilePath;
	}
	
	/**
	 * 生成新文件名 
	 * @param oldFileName 原来文件名
	 * @return 新的文件名，格式为: 在文件名前增加前缀:yyyyMMddHHmmssXXXX_(XXXX为四位随机数)
	 * @throws Exception
	 */
	public static String genFileName(String oldFileName) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = format.format(new Date());
		// 在文件名前增加前缀:yyyyMMddHHmmssXXXX_(XXXX为四位随机数)
		String prefix = dateStr + (new java.util.Random()).nextInt(9999)+"_";
		String newFileName = prefix + oldFileName;
		return newFileName;
	}
	
	/**
	 * 拷贝文件
	 * @param src 源文件
	 * @param dst 目标文件
	 * @throws Exception
	 */
	 public static void copy(File src, File dst) throws Exception {     
	        InputStream in = null;
	        OutputStream out = null;
	        try{                
	            in = new BufferedInputStream( new FileInputStream(src));
	            out = new BufferedOutputStream( new FileOutputStream(dst)); 
	            
	            byte [] buffer = new byte [1024];    
	            while (in.read(buffer) > 0 )    
	                out.write(buffer);      
	        }catch (FileNotFoundException fnfe) {
				throw new RuntimeException("源文件没找到! 这很有可能是该上传文件中没有内容，请确保文件中有内容后重新执行上传操作。");
			} catch (IOException ioe) {
				throw new RuntimeException("文件读写错误");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}finally {
	        	if(in != null)
	        		in.close();
	        	if(out != null)
	        		out.close();
	        }
	            
	    }
	 /**
     * 将文件名中的汉字转为UTF8编码的串,以便下载时能正确显示另存的文件名.
     * @param s 原文件名
     * @return 重新编码后的文件名
     */
    public static String toUtf8String(String s) {
		 StringBuffer sb = new StringBuffer();
		 for (int i=0;i<s.length();i++) {
		     char c = s.charAt(i);
		     if (c >= 0 && c <= 255) {
		    	 sb.append(c);
		     } else {
				 byte[] b;
				 try {
				      b = Character.toString(c).getBytes("utf-8");
				 } catch (Exception ex) {
				      System.out.println(ex);
				      b = new byte[0];
				 }
				 for (int j = 0; j < b.length; j++) {
				      int k = b[j];
				      if (k < 0) k += 256;
				      sb.append("%" + Integer.toHexString(k).toUpperCase());
				 }
		     }
		 }
		 return sb.toString();
	} 
}
