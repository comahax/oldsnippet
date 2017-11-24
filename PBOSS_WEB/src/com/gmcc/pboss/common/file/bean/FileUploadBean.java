package com.gmcc.pboss.common.file.bean;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-10-21
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * �������ϴ��ļ�������
 */
public class FileUploadBean {
	/** �ļ����ͣ������ʾ� */
	private String type;
	
	/**�Ƿ���Ҫ��¼*/
	private boolean isNeedLogin = true;
	
	/**�Ƿ������ϴ��ܴ���*/
	private boolean isUploadTimesLimit = true;
	
	/**�ϴ��ܴ���*/
	private int uploadTotalTimes;
	/** �������ݴ�С����λ��B�� */
	private int cacheSize;

	/** �����ϴ��ļ��ܴ�С����λ��B�� */
	private int maxSize;
	private int maxSizeKb;
	
	/** һ���ϴ��ļ��ܴ�С����λ��B�� */
	private int totalSize;

	/** �ϴ�Ŀ¼�������� */
	private String commonPath;
	/** �ϴ��ļ���׺�� */
	private String fileSuffix;

	/** �Ƿ���Ҫ�ؽ�Ŀ¼ */
	private boolean isRecreateDoc;
	/** �ؽ�Ŀ¼���򣺰����ڣ�yyyy/mm/dd�� */
	private String recreateDocRegular;

	/** �Ƿ���Ҫ���������ļ� */
	private boolean isRenameFile;
	/** �����������򣺰���¼���ƣ���������_�ļ����ƣ� */
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
		/** �ļ����ͣ������ʾ� */
		info.append("type[").append(type).append(']');
		/**�Ƿ���Ҫ��¼*/
		info.append("isNeedLogin[").append(isNeedLogin).append(']');
		/** �������ݴ�С����λ��B�� */
		info.append("cacheSize[").append(cacheSize).append(']');
		/** �����ϴ��ļ��ܴ�С����λ��B�� */
		info.append("maxSize[").append(maxSize).append(']');
		/** һ���ϴ��ļ��ܴ�С����λ��B�� */
		info.append("totalSize[").append(totalSize).append(']');
		/** �ϴ�Ŀ¼�������� */
		info.append("commonPath[").append(commonPath).append(']');
		/** �ϴ��ļ���׺�� */
		info.append("fileSuffix[").append(fileSuffix).append(']');
		/** �Ƿ���Ҫ�ؽ�Ŀ¼ */
		info.append("isRecreateDoc[").append(isRecreateDoc).append(']');
		/** �ؽ�Ŀ¼���򣺰����ڣ�yyyy/mm/dd�� */
		info.append("recreateDocRegular[").append(recreateDocRegular).append(']');
		/** �Ƿ���Ҫ���������ļ� */
		info.append("isRenameFile[").append(isRenameFile).append(']');
		/** �����������򣺰���¼���ƣ���������_�ļ����ƣ� */
		info.append("renameRegular[").append(renameRegular).append(']');
		/**�Ƿ������ϴ��ܴ���*/
		info.append("isUploadTimesLimit[").append(isUploadTimesLimit).append(']');
		/**�ϴ��ܴ���*/
		info.append("uploadTotalTimes[").append(uploadTotalTimes).append(']');
		return info.toString();
	}
	
	
	
}
