package com.sunrise.boss.ui.cms.way;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;


public class BatchLOGISWayForm extends UploadFileForm {
	
	public BatchLOGISWayForm() {
		this.setCheckFormat(new BatchLOGISWayCheck());
	}

}