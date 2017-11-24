package com.sunrise.boss.ui.cms.cntycompany;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchCntycompanyForm extends UploadFileForm {
	public BatchCntycompanyForm() {
		this.setCheckFormat(new BatchCntycompanyCheck());
	}
}
