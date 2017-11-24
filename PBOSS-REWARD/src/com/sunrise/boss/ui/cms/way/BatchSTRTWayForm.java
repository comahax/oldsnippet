package com.sunrise.boss.ui.cms.way;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;


public class BatchSTRTWayForm extends UploadFileForm {
	
	public BatchSTRTWayForm() {
		this.setCheckFormat(new BatchSTRTWayCheck());
	}

}