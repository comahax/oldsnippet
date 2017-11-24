package com.sunrise.boss.web.common.batch.upload;

import java.io.File;
/**
 * 文件属性类
 * @author panmeifa
 */
public class FormFile {

	private File file;
	private String fileName;
	private String contentType;
	
	public FormFile(File file, String fileName, String contentType) {
		this.file = file;
		this.fileName = fileName;
		this.contentType = contentType;
	}
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public void delete() {
		this.file.delete();
	}
}
