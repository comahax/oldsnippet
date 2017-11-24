package com.gmcc.pboss.common.file.util;

import java.io.File;

import org.apache.log4j.Logger;

import com.common.util.file.FileUtil;
import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.config.exception.FileConfigException;
import com.gmcc.pboss.common.config.xml.IXmlHandle;
import com.gmcc.pboss.common.config.xml.impl.FileHandleConfigXmlHandle;
import com.gmcc.pboss.common.dictionary.Regex;
import com.gmcc.pboss.common.file.bean.FileHandleConfig;
import com.gmcc.pboss.common.file.bean.FileUploadBean;
import com.gmcc.pboss.common.file.dictionary.RecreateDocRegular;
import com.gmcc.pboss.common.file.dictionary.RenameRegular;
import com.gmcc.pboss.common.file.exception.ErrorFileSuffixException;
import com.gmcc.pboss.common.util.CommonUtil;
import com.gmcc.pboss.common.util.RndNumberBuilder;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-10-21
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������������
 */
public class FileHandleUtil {
	/**
	 * ����ļ�����׺��
	 * @param allName
	 * @return
	 */
	public static String getFileSuffix(String allName){
		/*�ָ����.*/
		String fileName =  getFileName(allName);
		String[]temp = fileName.split(Regex.POINT);
		
		return temp[temp.length - 1];
	}
	/**
	 * ȡ�ļ��� ��������׺
	 * @param allName
	 * @return
	 */
	public static String getFileNameNoSuffix(String allName){
		String fileName =  getFileName(allName);
		String[]temp = fileName.split(Regex.POINT);
		
		return temp[0];
	}
	/**
	 * ȡ�ļ����� ������׺
	 * @param allName
	 * @return
	 */
	public static String getFileName(String allName){
		String[]temp = allName.split("\\\\");
		return temp[temp.length - 1];
	}
	
	/**
	 * ����Ŀ¼
	 * @param path
	 * @param regluar
	 * 
	 */
	public static String createDoc(String path , String regluar){
		
		StringBuffer sb = new StringBuffer();
		String flage = "/";
		
		sb.append(path);
		if(regluar.equalsIgnoreCase(RecreateDocRegular.BY_DATE)){
			
			sb.append(CommonUtil.getNowYear()).append(flage);
			sb.append(CommonUtil.getNowMonth()).append(flage);
			sb.append(CommonUtil.getNowDate()).append(flage);
			
		}
		
		path = sb.toString();
		File doc = new File(path);
		if(!doc.exists()){
			doc.mkdirs();
		}
		
		return sb.toString();
	}
	/**
	 * ��������
	 * @param fileName
	 * @param userName
	 * @param regular
	 * @return
	 */
	public static String renameFile(String fileName, String userName,String regular){
		StringBuffer sb = new StringBuffer();
		
//		String fileName = getFileNameNoSuffix(allName);
		String suffix = getFileSuffix(fileName);
		
		if(regular.equalsIgnoreCase(RenameRegular.BY_MNAME)){
			//sb.append(getFileName(fileName))
			//.append(Regex.UNDERLINE)
			
			sb.append(userName).append(Regex.UNDERLINE)
			.append(System.currentTimeMillis()).append(Regex.UNDERLINE)
			.append(RndNumberBuilder.getRndNumber(6))
			.append('.').append(suffix);
		}
		
		return sb.toString();
	}
	
	/**
	 * �����ϴ����Ͷ�ȡ�ϴ�����
	 * @param upLoadType
	 * @return
	 */
	public static FileUploadBean loadUploadConfig(String upLoadType){
		//logger.info("�����ϴ����Ͷ�ȡ�ϴ�����>>>"+upLoadType);
		IXmlHandle handle = new FileHandleConfigXmlHandle();
		
		FileConfigAdapter fileConfig;
		FileHandleConfig bean = null;
		FileUploadBean config = null;
		try {
			fileConfig = FileConfigAdapter.init();
			bean = (FileHandleConfig)fileConfig.loadProperty("FILE_HANDLE", "FILE_HANDLE", handle);
			config = (FileUploadBean)bean.getUploadFiles().get(upLoadType);
			
			//logger.info(config.toString());
		} 
		catch (FileConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return config;
	}
	
	public static FileHandleConfig getUploadConfig() {
		IXmlHandle handle = new FileHandleConfigXmlHandle();
		
		FileConfigAdapter fileConfig;
		FileHandleConfig config = null;
		try {
			fileConfig = FileConfigAdapter.init();
			config = (FileHandleConfig)fileConfig.loadProperty("FILE_HANDLE", "FILE_HANDLE", handle);
			//logger.info(config.toString());
		} 
		catch (FileConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return config;
	}
	/**
	 * ����·��ɾ��·�����ļ�������Ҳ����true
	 * @param path
	 * @return
	 */
	public static boolean deleteFileByPath(String path){
		return FileUtil.deleteFileByPath(path);
	}
	
	/**
	 * �ж��ļ���׺�Ƿ���ȷ
	 * @param suffix
	 * @param rightSuffix
	 * @throws ErrorFileSuffixException
	 */
	public static void judgeFileSuffix(String suffix, String configSuffix)throws ErrorFileSuffixException{
		String[]s = configSuffix.split(Regex.COMMA);
		int f = 0;
		int l = s.length;
		for(int i=0; i<l; i++){
			//System.out.println("Suffix>>>"+s[i]);
			if(s[i].equalsIgnoreCase(suffix))
				f++;
		}
		
		if(f == 0)
			throw new ErrorFileSuffixException("Upload file suffix["+suffix+"] is incorrectness, " +
												"the right suffix is["+configSuffix+"]");
			
	}
	public static  void loggerUploadException(Logger logger,Exception e){
		loggerException(logger, e, "UploadException");
	}
	public static void loggerException(Logger logger,Exception e, String flage){
		StringBuffer einfo = new StringBuffer();
		einfo.append(flage).append(">>> :").append(e.toString());
		logger.error(einfo.toString());
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

