package com.sunrise.boss.ui.cms.costcard;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchCostcardForm extends UploadFileForm {

	public BatchCostcardForm() {
		this.setCheckFormat(new BatchCostcardCheck());
	}
}