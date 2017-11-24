package com.gmcc.pboss.common.file.impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.gmcc.pboss.common.file.IFileHandle;
import com.gmcc.pboss.common.file.bean.FileHandleResult;
import com.gmcc.pboss.common.file.bean.FileUploadBean;
import com.gmcc.pboss.common.file.bean.ServerInfoBean;
import com.gmcc.pboss.common.file.dictionary.FileHandleRetCode;
import com.gmcc.pboss.common.file.exception.ErrorFileSuffixException;
import com.gmcc.pboss.common.file.util.FileHandleUtil;
import com.gmcc.pboss.common.file.util.FtpAccess;

public class FTPFileHandleImpl implements IFileHandle {

private static Logger logger = Logger.getLogger(FileHandleImpl.class);
	
	/**ʹ����*/
	private String userName;
	/**�ļ���������*/
	private String fileHandleType;
	
	
	public FTPFileHandleImpl(String userName,String fileHandleType) {
		this.userName = userName;
		this.fileHandleType = fileHandleType;
	}
	
	public FileHandleResult upload(HttpServletRequest request,
			FileUploadBean uploaCconfig, ServerInfoBean ftpInfo) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		int retCode = FileHandleRetCode.UPLOAD_FAIL;
		String fileName = "";
		FtpAccess fa = null;
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//1.ָ�����ڴ��л������ݴ�С,��λΪbyte
			factory.setSizeThreshold(uploaCconfig.getCacheSize());
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			//2.ָ�������ϴ��ļ������ߴ� 
			upload.setFileSizeMax(uploaCconfig.getMaxSize());
			//3.ָ��һ���ϴ�����ļ����ܳߴ� 
			upload.setSizeMax(uploaCconfig.getTotalSize());
			
			//4.�õ������ύ��
			List items = upload.parseRequest(request);
			logger.debug("�ύ������"+items.size());
			
			if(items != null && items.size() > 0) {
				fa = new FtpAccess(ftpInfo);
			}
			Iterator it = items.iterator();
			while(it.hasNext()){
				DiskFileItem fi = (DiskFileItem)it.next();
				
				if(!fi.isFormField()){
					
					//�ϴ��ļ���С
					long fileSize = fi.getSize();
					//�ϴ��ļ�
					String allName = fi.getName();
					//�ϴ��ļ���׺
					String suffix = FileHandleUtil.getFileSuffix(allName);
					
					logger.debug("�ϴ��ļ���С="+fileSize +" �ϴ��ļ�="+allName);					
					
					if(fileSize != 0 ){
						//�ж��ļ���ʽ�Ƿ���ȷ
						String configSuffix = uploaCconfig.getFileSuffix();
						FileHandleUtil.judgeFileSuffix(suffix, configSuffix);
						
						fileName = FileHandleUtil.getFileName(allName);
						//�Ƿ���������
						if(uploaCconfig.isRenameFile()){
							fileName = FileHandleUtil.renameFile(fileName, userName, uploaCconfig.getRenameRegular());
						}
						
						File tempFile = fi.getStoreLocation();
						fa.doUploadFile(tempFile, fileName, "");
						
						isSuccess = true;
						retCode = FileHandleRetCode.UPLOAD_SUCCESS;
					}
				}
			}//end while
			
		} 
		catch (FileUploadException e) {
			// TODO Auto-generated catch block
			retCode = FileHandleRetCode.UPLOAD_OSIZE;
			FileHandleUtil.loggerUploadException(logger,e);
		}
		catch (ErrorFileSuffixException e){
			retCode = FileHandleRetCode.UPLOAD_WSUFFIX;
			FileHandleUtil.loggerUploadException(logger,e);
		}
		catch(Exception e){
			retCode = FileHandleRetCode.UPLOAD_EXCEPTION;
			FileHandleUtil.loggerUploadException(logger,e);
		}
		finally {
			try {
				if (fa != null && fa.ftp != null) {
					fa.ftp.logout();
					fa.ftp.disconnect();
		        }
			}catch(Exception e) {
				retCode = FileHandleRetCode.UPLOAD_EXCEPTION;
				FileHandleUtil.loggerUploadException(logger,e);
			}
		}
		
		FileHandleResult result = new FileHandleResult(getFileHandleType());
		result.setSuccess(isSuccess);
		result.setRetCode(retCode);
		result.setRetObj(fileName);
		
		return result;
	}
	
	/**ʹ����*/
	public String getUserName() {
		return userName;
	}
	/**ʹ����*/
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**�ļ���������*/
	public String getFileHandleType() {
		return fileHandleType;
	}
	/**�ļ���������*/
	public void setFileHandleType(String fileHandleType) {
		this.fileHandleType = fileHandleType;
	}
	

}
