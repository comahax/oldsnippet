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
	 * �������ļ�·��
	 * @param docFileName 
	 * @param createNew �Ƿ�Ҫ�������ļ����ı�ʶ
	 * @return
	 * @throws Exception
	 */
	public static String createFilename(String docFileName,boolean createNew)
			throws Exception {
		String location = FtpInfo.getUpload();
		if (location == null || location.equals("")) {
			throw new RuntimeException(
					"�ļ�·��û�����ã������sysinfo.properties��uploadlocation������!");
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
			// ���ļ���ǰ����ǰ׺:yyyyMMddHHmmssXXXX_(XXXXΪ��λ�����)
			prefix = dateStr + (new java.util.Random()).nextInt(9999)+"_";
		}
		String destFilePath = location + prefix + docFileName;
		return destFilePath;
	}
	
	/**
	 * �������ļ��� 
	 * @param oldFileName ԭ���ļ���
	 * @return �µ��ļ�������ʽΪ: ���ļ���ǰ����ǰ׺:yyyyMMddHHmmssXXXX_(XXXXΪ��λ�����)
	 * @throws Exception
	 */
	public static String genFileName(String oldFileName) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = format.format(new Date());
		// ���ļ���ǰ����ǰ׺:yyyyMMddHHmmssXXXX_(XXXXΪ��λ�����)
		String prefix = dateStr + (new java.util.Random()).nextInt(9999)+"_";
		String newFileName = prefix + oldFileName;
		return newFileName;
	}
	
	/**
	 * �����ļ�
	 * @param src Դ�ļ�
	 * @param dst Ŀ���ļ�
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
				throw new RuntimeException("Դ�ļ�û�ҵ�! ����п����Ǹ��ϴ��ļ���û�����ݣ���ȷ���ļ��������ݺ�����ִ���ϴ�������");
			} catch (IOException ioe) {
				throw new RuntimeException("�ļ���д����");
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
     * ���ļ����еĺ���תΪUTF8����Ĵ�,�Ա�����ʱ����ȷ��ʾ�����ļ���.
     * @param s ԭ�ļ���
     * @return ���±������ļ���
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
