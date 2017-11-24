package com.gmcc.pboss.common.file.bean;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-21
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：上传文件配置类
 */
public class FileUploadBean {
	/** 文件类型：调查问卷 */
	private String type;
	
	/**是否需要登录*/
	private boolean isNeedLogin = true;
	
	/**是否设置上传总次数*/
	private boolean isUploadTimesLimit = true;
	
	/**上传总次数*/
	private int uploadTotalTimes;
	/** 缓存数据大小（单位：B） */
	private int cacheSize;

	/** 单个上传文件总大小（单位：B） */
	private int maxSize;
	private int maxSizeKb;
	
	/** 一次上传文件总大小（单位：B） */
	private int totalSize;

	/** 上传目录公共部分 */
	private String commonPath;
	/** 上传文件后缀名 */
	private String fileSuffix;

	/** 是否需要重建目录 */
	private boolean isRecreateDoc;
	/** 重建目录规则：按日期（yyyy/mm/dd） */
	private String recreateDocRegular;

	/** 是否需要重新命名文件 */
	private boolean isRenameFile;
	/** 重新命名规则：按登录名称（渠道编码_文件名称） */
	private String renameRegular;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCacheSize() {
		return cacheSize;
	}
	public void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public String getCommonPath() {
		return commonPath;
	}
	public void setCommonPath(String commonPath) {
		this.commonPath = commonPath;
	}
	public String getFileSuffix() {
		return fileSuffix;
	}
	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}
	public boolean isRecreateDoc() {
		return isRecreateDoc;
	}
	public void setRecreateDoc(boolean isRecreateDoc) {
		this.isRecreateDoc = isRecreateDoc;
	}
	public String getRecreateDocRegular() {
		return recreateDocRegular;
	}
	public void setRecreateDocRegular(String recreateDocRegular) {
		this.recreateDocRegular = recreateDocRegular;
	}
	public boolean isRenameFile() {
		return isRenameFile;
	}
	public void setRenameFile(boolean isRenameFile) {
		this.isRenameFile = isRenameFile;
	}
	public String getRenameRegular() {
		return renameRegular;
	}
	public void setRenameRegular(String renameRegular) {
		this.renameRegular = renameRegular;
	}
	
	public boolean isNeedLogin() {
		return isNeedLogin;
	}
	public void setNeedLogin(boolean isNeedLogin) {
		this.isNeedLogin = isNeedLogin;
	}
	
	public boolean isUploadTimesLimit() {
		return isUploadTimesLimit;
	}
	public void setUploadTimesLimit(boolean isUploadTimesLimit) {
		this.isUploadTimesLimit = isUploadTimesLimit;
	}
	public int getUploadTotalTimes() {
		return uploadTotalTimes;
	}
	public void setUploadTotalTimes(int uploadTotalTimes) {
		this.uploadTotalTimes = uploadTotalTimes;
	}
	
	public int getMaxSizeKb() {
		maxSizeKb = this.maxSize/1024;
		return maxSizeKb;
	}
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer info = new StringBuffer();
		/** 文件类型：调查问卷 */
		info.append("type[").append(type).append(']');
		/**是否需要登录*/
		info.append("isNeedLogin[").append(isNeedLogin).append(']');
		/** 缓存数据大小（单位：B） */
		info.append("cacheSize[").append(cacheSize).append(']');
		/** 单个上传文件总大小（单位：B） */
		info.append("maxSize[").append(maxSize).append(']');
		/** 一次上传文件总大小（单位：B） */
		info.append("totalSize[").append(totalSize).append(']');
		/** 上传目录公共部分 */
		info.append("commonPath[").append(commonPath).append(']');
		/** 上传文件后缀名 */
		info.append("fileSuffix[").append(fileSuffix).append(']');
		/** 是否需要重建目录 */
		info.append("isRecreateDoc[").append(isRecreateDoc).append(']');
		/** 重建目录规则：按日期（yyyy/mm/dd） */
		info.append("recreateDocRegular[").append(recreateDocRegular).append(']');
		/** 是否需要重新命名文件 */
		info.append("isRenameFile[").append(isRenameFile).append(']');
		/** 重新命名规则：按登录名称（渠道编码_文件名称） */
		info.append("renameRegular[").append(renameRegular).append(']');
		/**是否设置上传总次数*/
		info.append("isUploadTimesLimit[").append(isUploadTimesLimit).append(']');
		/**上传总次数*/
		info.append("uploadTotalTimes[").append(uploadTotalTimes).append(']');
		return info.toString();
	}
	
	
	
}
