package com.sunrise.boss.ui.cms.reward.chpwregsiviolation;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ChPwRegsiviolationBatchForm extends UploadFileForm {

	public ChPwRegsiviolationBatchForm() {
		super.setCheckFormat(new ChPwRegsiviolationCheck());
	}

}
