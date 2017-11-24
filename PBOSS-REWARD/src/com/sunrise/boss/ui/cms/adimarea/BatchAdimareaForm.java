package com.sunrise.boss.ui.cms.adimarea;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchAdimareaForm extends UploadFileForm {
	public BatchAdimareaForm() {
		this.setCheckFormat(new BatchAdimareaCheck());
	}
}
