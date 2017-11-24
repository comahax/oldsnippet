package com.sunrise.boss.ui.cms.zjty.chzjtyempltotal;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchEmpltotalForm extends UploadFileForm {
	private String operType;
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}
	public BatchEmpltotalForm() {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new BatchEmpltotalCheck());
	}

}
