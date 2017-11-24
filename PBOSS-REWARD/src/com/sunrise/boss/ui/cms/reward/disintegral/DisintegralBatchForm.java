package com.sunrise.boss.ui.cms.reward.disintegral;


import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class DisintegralBatchForm extends UploadFileForm {

	public DisintegralBatchForm() {
		this.setCheckFormat(new DisintegralBatchCheck());
	}
}
