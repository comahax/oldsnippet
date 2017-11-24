package com.sunrise.boss.ui.commons.batch.upload;

import org.apache.struts.action.*;
import org.apache.struts.upload.*;

/**
 * 
 * <p>
 * Title:
 * </p>
 * <p>
 * Description: ע�⣬����ǻ���
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

public abstract class UploadFileForm extends ActionForm {
	private FormFile theFile; // �ϴ����ļ�

	private ICheckFormat checkFormat; // ��ʽ�����
	
	private String filename;

	/**
	 * Retrieve a representation of the file the user has uploaded
	 */
	public FormFile getTheFile() {
		return theFile;
	}

	public ICheckFormat getCheckFormat() {
		return checkFormat;
	}

	/**
	 * Set a representation of the file the user has uploaded
	 */
	public void setTheFile(FormFile theFile) {
		this.theFile = theFile;
	}

	public void setCheckFormat(ICheckFormat checkFormat) {
		this.checkFormat = checkFormat;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
