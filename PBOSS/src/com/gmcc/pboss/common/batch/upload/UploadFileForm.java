package com.gmcc.pboss.common.batch.upload;

import java.io.File;

import org.apache.struts2.util.ServletContextAware;

/**
 * 
 * <p>
 * Title:
 * </p>
 * <p>
 * Description: 注意，这个是基类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: maywide
 * </p>
 * 
 * @author: kongdongquan
 * @version: 0.9
 * @author: HBM
 * @version: 1.0
 */

public abstract class UploadFileForm implements ServletContextAware {
	private File theFile; // 上传的文件

	private ICheckFormat checkFormat; // 格式检查类
	/**
	 * Retrieve a representation of the file the user has uploaded
	 */
	private File doc;

	public File getDoc() {
		return doc;
	}

	public void setDoc(File doc) {
		this.doc = doc;
	}
	

	public File getTheFile() {
		return theFile;
	}

	public ICheckFormat getCheckFormat() {
		return checkFormat;
	}

	/**
	 * Set a representation of the file the user has uploaded
	 */
	public void setTheFile(File theFile) {
		this.theFile = theFile;
	}

	public void setCheckFormat(ICheckFormat checkFormat) {
		this.checkFormat = checkFormat;
	}
}
