package com.gmcc.pboss.common.file.impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
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

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-21
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 */
public class FileHandleImpl implements IFileHandle{
	private static Logger logger = Logger.getLogger(FileHandleImpl.class);
	
	/**使用者*/
	private String userName;
	/**文件处理类型*/
	private String fileHandleType;
	

	public FileHandleImpl(String userName, String fileHandleType) {
		super();
		this.userName = userName;
		this.fileHandleType = fileHandleType;
	}

	public FileHandleResult upload(HttpServletRequest request, FileUploadBean uploadConfig, ServerInfoBean ftpInfo) {
		// TODO Auto-generated method stub
		
		boolean isSuccess = false;
		int retCode = FileHandleRetCode.UPLOAD_FAIL;
		String fullName = "";
		
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//1.指定在内存中缓存数据大小,单位为byte
			factory.setSizeThreshold(uploadConfig.getCacheSize());
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			//2.指定单个上传文件的最大尺寸 
			upload.setFileSizeMax(uploadConfig.getMaxSize());
			//3.指定一次上传多个文件的总尺寸 
			upload.setSizeMax(uploadConfig.getTotalSize());
			
			//4.得到所有提交项
			List items = upload.parseRequest(request);
			logger.debug("提交项数："+items.size());
			
			Iterator it = items.iterator();
			while(it.hasNext()){
				FileItem fi = (FileItem)it.next();
				
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
						String configSuffix = uploadConfig.getFileSuffix();
						FileHandleUtil.judgeFileSuffix(suffix, configSuffix);
						
						String path = uploadConfig.getCommonPath();
						//是否重建目录
						if(uploadConfig.isRecreateDoc()){
							path = FileHandleUtil.createDoc(path, uploadConfig.getRecreateDocRegular());
						}
						//是否重新命名
						String newName = "";
						if(uploadConfig.isRenameFile()){
							newName = FileHandleUtil.renameFile(allName, userName, uploadConfig.getRenameRegular());
						}
						
						fullName = path + newName;
						File uploadFile = new File(fullName);
						fi.write(uploadFile);
						
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
		
		FileHandleResult result = new FileHandleResult(getFileHandleType());
		result.setSuccess(isSuccess);
		result.setRetCode(retCode);
		result.setRetObj(fullName);
		
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