package com.sunrise.boss.ui.example.batchtest;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;


public class BatchtestForm extends UploadFileForm {
	private Short oprtype;

	public BatchtestForm() {
		this.setCheckFormat(new BatchtestCheck());
	}

	public Short getOprtype() {
		return oprtype;
	}

	public void setOprtype(Short oprtype) {
		this.oprtype = oprtype;
	}

}