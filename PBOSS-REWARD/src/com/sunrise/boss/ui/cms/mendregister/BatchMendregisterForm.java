package com.sunrise.boss.ui.cms.mendregister;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchMendregisterForm extends UploadFileForm {
	public BatchMendregisterForm() {
		this.setCheckFormat(new BatchMendregisterCheck());
	}
}
