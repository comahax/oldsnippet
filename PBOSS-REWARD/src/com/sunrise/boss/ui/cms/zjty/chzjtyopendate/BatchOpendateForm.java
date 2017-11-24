package com.sunrise.boss.ui.cms.zjty.chzjtyopendate;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchOpendateForm extends UploadFileForm {
	private String operType;

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public BatchOpendateForm() {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new BatchOpendateCheck());
	}

}
