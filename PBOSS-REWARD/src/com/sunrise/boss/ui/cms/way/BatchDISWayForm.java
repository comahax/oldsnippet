package com.sunrise.boss.ui.cms.way;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;


public class BatchDISWayForm extends UploadFileForm {
	
	public BatchDISWayForm() {
		this.setCheckFormat(new BatchSTRTWayCheck());
	}

}