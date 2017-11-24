package com.sunrise.boss.ui.cms.bbc.mmopn;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchMmopnForm extends UploadFileForm{
	public BatchMmopnForm() {
		super.setCheckFormat(new BatchMmopnCheck());
	}

}
