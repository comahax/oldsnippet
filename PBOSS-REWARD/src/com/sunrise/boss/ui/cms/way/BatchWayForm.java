package com.sunrise.boss.ui.cms.way;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchWayForm extends UploadFileForm{
	public BatchWayForm() {
		this.setCheckFormat(new BatchWayCheck());
	}
}
