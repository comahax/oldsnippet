package com.sunrise.boss.ui.cms.bbc.bbcadjust;


import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BbcadjustunpbbatchForm extends UploadFileForm {
	private String oprType;
	public BbcadjustunpbbatchForm() {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new BbcadjustunpbbatchCheck());
	}
	public String getOprType() {
		return oprType;
	}

	public void setOprType(String oprType) {
		this.oprType = oprType;
	}
}
