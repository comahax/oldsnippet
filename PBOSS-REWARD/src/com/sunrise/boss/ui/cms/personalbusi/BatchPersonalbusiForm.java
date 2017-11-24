package com.sunrise.boss.ui.cms.personalbusi;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchPersonalbusiForm extends UploadFileForm {

	public BatchPersonalbusiForm() {
		this.setCheckFormat(new BatchPersonalbusiCheck());
	}
}