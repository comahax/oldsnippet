package com.sunrise.boss.ui.cms.operation;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchOperationForm extends UploadFileForm {

	public BatchOperationForm() {
		setCheckFormat(new BatchOperationCheck());
	}

}
