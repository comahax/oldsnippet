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
	
	/**使用者*/
	private String userName;
	/**文件处理类型*/
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
			//1.指定在内存中缓存数据大小,单位为byte
			factory.setSizeThreshold(uploaCconfig.getCacheSize());
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			//2.指定单个上传文件的最大尺寸 
			upload.setFileSizeMax(uploaCconfig.getMaxSize());
			//3.指定一次上传多个文件的总尺寸 
			upload.setSizeMax(uploaCconfig.getTotalSize());
			
			//4.得到所有提交项
			List items = upload.parseRequest(request);
			logger.debug("提交项数："+items.size());
			
			if(items != null && items.size() > 0) {
				fa = new FtpAccess(ftpInfo);
			}
			Iterator it = items.iterator();
			while(it.hasNext()){
				DiskFileItem fi = (DiskFileItem)it.next();
				
				if(!fi.isFormField()){
					
					//上传文件大小
					long fileSize = fi.getSize();
					//上传文件
					String allName = fi.getName();
					//上传文件后缀
					String suffix = FileHandleUtil.getFileSuffix(allName);
					
					logger.debug("上传文件大小="+fileSize +" 上传文件="+allName);					
					
					if(fileSize != 0 ){
						//判断文件格式是否正确
						String configSuffix = uploaCconfig.getFileSuffix();
						FileHandleUtil.judgeFileSuffix(suffix, configSuffix);
						
						fileName = FileHandleUtil.getFileName(allName);
						//是否重新命名
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
	
	/**使用者*/
	public String getUserName() {
		return userName;
	}
	/**使用者*/
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**文件处理类型*/
	public String getFileHandleType() {
		return fileHandleType;
	}
	/**文件处理类型*/
	public void setFileHandleType(String fileHandleType) {
		this.fileHandleType = fileHandleType;
	}
	

}
