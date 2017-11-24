package com.sunrise.boss.ui.cms.rewardranlog;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchRewardranlogForm extends UploadFileForm {

	public BatchRewardranlogForm() throws Exception {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new RewardranlogCheck());
	}

}
