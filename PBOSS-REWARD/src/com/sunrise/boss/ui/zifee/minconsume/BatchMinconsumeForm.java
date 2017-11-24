package com.sunrise.boss.ui.zifee.minconsume;

import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchMinconsumeForm extends UploadFileForm {
    private String batchaction;
    private FormFile theFile;
    private String yxplanid;
    private String areacode;
	public BatchMinconsumeForm() {
		this.setCheckFormat(new BatchMinconsumeCheck());
	}
	public String getBatchaction() {
		return batchaction;
	}
	public void setBatchaction(String batchaction) {
		this.batchaction = batchaction;
	}
	public FormFile getTheFile() {
		return theFile;
	}
	public void setTheFile(FormFile theFile) {
		this.theFile = theFile;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getYxplanid() {
		return yxplanid;
	}
	public void setYxplanid(String yxplanid) {
		this.yxplanid = yxplanid;
	}
}