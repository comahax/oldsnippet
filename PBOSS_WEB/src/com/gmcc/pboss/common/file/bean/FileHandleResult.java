package com.gmcc.pboss.common.file.bean;

import com.gmcc.pboss.common.config.ConfigUtil;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-22
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：文件处理结果
 */
public class FileHandleResult {
	/**文件处理类型*/
	private String fileHandleType; 
	
	private int retCode;
	private boolean isSuccess;
	private String message;
	private Object retObj;
	
	
	
	public FileHandleResult(String fileHandleType) {
		super();
		this.fileHandleType = fileHandleType;
	}
	
	public int getRetCode() {
		return retCode;
	}
	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		message = ConfigUtil.getMessage(getFileHandleType(), retCode);
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getRetObj() {
		return retObj;
	}
	public void setRetObj(Object retObj) {
		this.retObj = retObj;
	}

	public String getFileHandleType() {
		return fileHandleType;
	}

	public void setFileHandleType(String fileHandleType) {
		this.fileHandleType = fileHandleType;
	}
	
	
	
}
