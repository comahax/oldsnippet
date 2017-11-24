package com.sunrise.boss.ui.cms.rewardreport;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchRewardreportForm extends UploadFileForm {

	public BatchRewardreportForm() throws Exception {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new BatchRewardreportCheck());
	}

}
