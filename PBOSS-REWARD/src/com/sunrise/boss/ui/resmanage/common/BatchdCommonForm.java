package com.sunrise.boss.ui.resmanage.common;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchdCommonForm extends UploadFileForm {
	
	private String waystyle;
	private String auditoprcode;

	public String getAuditoprcode() {
		return auditoprcode;
	}

	public void setAuditoprcode(String auditoprcode) {
		this.auditoprcode = auditoprcode;
	}

	public String getWaystyle() {
		return waystyle;
	}

	public void setWaystyle(String waystyle) {
		this.waystyle = waystyle;
	}

}
