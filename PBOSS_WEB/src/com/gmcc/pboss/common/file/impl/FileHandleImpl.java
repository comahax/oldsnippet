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
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-10-21
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public class FileHandleImpl implements IFileHandle{
	private static Logger logger = Logger.getLogger(FileHandleImpl.class);
	
	/**ʹ����*/
	private String userName;
	/**�ļ���������*/
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
			//1.ָ�����ڴ��л������ݴ�С,��λΪbyte
			factory.setSizeThreshold(uploadConfig.getCacheSize());
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			//2.ָ�������ϴ��ļ������ߴ� 
			upload.setFileSizeMax(uploadConfig.getMaxSize());
			//3.ָ��һ���ϴ�����ļ����ܳߴ� 
			upload.setSizeMax(uploadConfig.getTotalSize());
			
			//4.�õ������ύ��
			List items = upload.parseRequest(request);
			logger.debug("�ύ������"+items.size());
			
			Iterator it = items.iterator();
			while(it.hasNext()){
				FileItem fi = (FileItem)it.next();
				
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
						String configSuffix = uploadConfig.getFileSuffix();
						FileHandleUtil.judgeFileSuffix(suffix, configSuffix);
						
						String path = uploadConfig.getCommonPath();
						//�Ƿ��ؽ�Ŀ¼
						if(uploadConfig.isRecreateDoc()){
							path = FileHandleUtil.createDoc(path, uploadConfig.getRecreateDocRegular());
						}
						//�Ƿ���������
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