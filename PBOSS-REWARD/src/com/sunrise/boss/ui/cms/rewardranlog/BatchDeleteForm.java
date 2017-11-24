package com.sunrise.boss.ui.cms.rewardranlog;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchDeleteForm extends UploadFileForm {

	public BatchDeleteForm() throws Exception {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new DeleteCheck());
	}

}
