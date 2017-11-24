package com.sunrise.boss.ui.cms.reward.busiwayrel;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BusiwayrelBatchForm extends UploadFileForm {
	private String oprType;

	public BusiwayrelBatchForm() {
		super.setCheckFormat(new BusiwayrelBatchCheck());
	}

	public String getOprType() {
		return oprType;
	}

	public void setOprType(String oprType) {
		this.oprType = oprType;
	}
}
